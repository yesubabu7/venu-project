package com.insurance.insuranceCompany.Dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.insurance.insuranceCompany.model.InsurancePackage;
import com.insurance.insuranceCompany.model.NetworkHospitals;
import com.insurance.insuranceCompany.rowMapper.NetworkHospitalRowMapper;
import com.insurance.insuranceCompany.rowMapper.PackagesRowMapper;

@Component
public class NetworkHospitalDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public ArrayList<NetworkHospitals> getAllHopitals() {
		String sql = "SELECT * FROM NetworkHospitals";

		return (ArrayList<NetworkHospitals>) jdbcTemplate.query(sql, new NetworkHospitalRowMapper());

	}

	public int deleteHospital(int hid) {
		String sql = "delete from NetworkHospitals where hosp_id=" + hid;

		return jdbcTemplate.update(sql);

	}

	public int addHospital(NetworkHospitals hsp) {
		String max = "select max(hosp_id) from NetworkHospitals";
		int max2 = jdbcTemplate.queryForObject(max, Integer.class) + 1;
		String sql = "insert into NetworkHospitals(hosp_id,hosp_title,hosp_location,hosp_address,hosp_contact_number,hosp_pincode,hosp_luudate,grade,facilities)  values(?,?,?,?,?,?,?,?,?)";
		LocalDate currentDate = LocalDate.now();

		// Convert it to a java.sql.Date
		Date currentDateSql = Date.valueOf(currentDate);
		return jdbcTemplate.update(sql, max2, hsp.getHospTitle(), hsp.getHospLocation(), hsp.getHospAddress(),
				hsp.getHospContactNumber(), hsp.getHospPincode(), currentDateSql, hsp.getGrade(), hsp.getFacilities());
	}

	public int getHospCount() {
		String sql = "SELECT COUNT(*) FROM NetworkHospitals";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	public int editHospital(NetworkHospitals netHsp) {
		String sql = "UPDATE NetworkHospitals SET " + "hosp_title = ?, hosp_location = ?, hosp_address = ?, "
				+ "hosp_contact_number = ?, hosp_pincode = ?, grade = ?, facilities = ? " + "WHERE hosp_id = ?";

		// Define the parameters to be used in the SQL query
		Object[] params = { netHsp.getHospTitle(), netHsp.getHospLocation(), netHsp.getHospAddress(),
				netHsp.getHospContactNumber(), netHsp.getHospPincode(), netHsp.getGrade(), netHsp.getFacilities(),
				netHsp.getHospId() };

		try {
			int rowsUpdated = jdbcTemplate.update(sql, params);

			if (rowsUpdated > 0) {
				return rowsUpdated; // Return the number of rows updated
			} else {
				return -1; // Indicates that no rows were updated (hospital not found)
			}
		} catch (Exception e) {
			e.printStackTrace(); // Handle or log the exception
			return 0; // Indicates an error occurred
		}
	}

	public ArrayList<InsurancePackage> getRelatedPackages(int hspid) {
		String sql = "SELECT D.* FROM InsurancePackages AS D JOIN HospitalInsuranceMapping AS IPCD ON D.insp_id = IPCD.insp_id JOIN NetworkHospitals AS IP ON IPCD.hosp_id = IP.hosp_id WHERE IP.hosp_id ="
				+ hspid;
		return (ArrayList<InsurancePackage>) jdbcTemplate.query(sql, new PackagesRowMapper());

	}

	public int addPackage(String title, String desc, String status, long rangeStart, long rangeEnd,
			Integer ageLimitStart, Integer ageLimitEnd, int hospid) {

		String sql = "INSERT INTO InsurancePackages (insp_title, insp_desc, insp_status, insp_range_start, insp_range_end, insp_agelimit_start, insp_agelimit_end) VALUES (?, ?, ?, ?,?,?,?) RETURNING insp_id";

		try {
			// Execute the query and retrieve the generated disease ID
			int disid = jdbcTemplate.queryForObject(sql, Integer.class, title, desc, status, rangeStart, rangeEnd,
					ageLimitStart, ageLimitEnd);
			String sql1 = "insert into HospitalInsuranceMapping values(?,?)";
			return jdbcTemplate.update(sql1, hospid, disid);

		} catch (Exception e) {
			e.printStackTrace();
			return -1; // Return a negative value or handle the error as needed
		}

	}

	public int deletePackage(int did, int hospid) {
		String sql = "delete from HospitalInsuranceMapping where hosp_id=? and insp_id=?";
		int count = jdbcTemplate.update(sql, hospid, did);
		System.out.println("this is count" + count);
		return jdbcTemplate.update(sql, hospid, did);
	}

	public String updatePackage(String id, String title, String description, String status, String rangeStart,
			String rangeEnd, String ageLimitStrt, String ageLimitEnd) {

		try {
			// Convert parameters to appropriate data types, if necessary
			int packageId = Integer.parseInt(id);
			double rangeStartValue = Double.parseDouble(rangeStart);
			double rangeEndValue = Double.parseDouble(rangeEnd);
			int ageLimitStartValue = Integer.parseInt(ageLimitStrt);
			int ageLimitEndValue = Integer.parseInt(ageLimitEnd);

			// Create the SQL update statement
			String sql = "UPDATE InsurancePackages SET insp_title = ?, insp_desc = ?, insp_status = ?, "
					+ "insp_range_start = ?, insp_range_end = ?, insp_agelimit_start = ?, insp_agelimit_end = ? "
					+ "WHERE insp_id = ?";

			// Execute the update statement with the provided values
			int updatedRows = jdbcTemplate.update(sql, title, description, status, rangeStartValue, rangeEndValue,
					ageLimitStartValue, ageLimitEndValue, packageId);

			if (updatedRows > 0) {
				return "Package updated successfully";
			} else {
				return "No records were updated";
			}
		} catch (NumberFormatException e) {
			// Handle parsing errors (e.g., invalid numeric input)
			return "Invalid input data";
		} catch (Exception e) {
			// Handle other exceptions (e.g., database errors)
			return "An error occurred: " + e.getMessage();
		}
	}

	public ArrayList<NetworkHospitals> getSearcHospitals(String search) {
		String sql = "SELECT * FROM NetworkHospitals WHERE hosp_title LIKE '%" + search + "%'";

		return (ArrayList<NetworkHospitals>) jdbcTemplate.query(sql, new NetworkHospitalRowMapper());
	}

}
