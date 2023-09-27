package com.insurance.insuranceCompany.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.insurance.insuranceCompany.contract.InsurancePackageDAO;
import com.insurance.insuranceCompany.model.Categories;
import com.insurance.insuranceCompany.model.DiseaseDetails;
import com.insurance.insuranceCompany.model.InsurancePackage;
import com.insurance.insuranceCompany.model.InsurancePackageCoveredDisease;
import com.insurance.insuranceCompany.rowMapper.CategoryMapper;
import com.insurance.insuranceCompany.rowMapper.DiseseDetailsRowMapper;
import com.insurance.insuranceCompany.rowMapper.InsurancePackageCoveredDiseaseRowMapper;
import com.insurance.insuranceCompany.rowMapper.InsurancePackageRowMapper;

@Component
public class InsurancePackageDAOImpl implements InsurancePackageDAO {

	private final JdbcTemplate jdbcTemplate;
	private static final String GET_INSURANCE_PACKAGES = "SELECT * FROM InsurancePackages";
	private static final String GET_COVERED_DISEASES_BY_PACKAGE_ID = "SELECT * FROM InsurancePackageCoveredDiseases WHERE insp_id = ?";
	private static final String GET_DISEASE_DETAILS_BY_DISEASE_ID = "select * from Diseases where disc_id=?";
	private static final String GET_FILTERED_PACKAGES = "select * FROM InsurancePackages where insp_status=? and ? BETWEEN insp_agelimit_start AND insp_agelimit_end;";
	private static final String GET_PACKAGES_BY_STATUS = "select * FROM InsurancePackages where insp_status=?";
	private static final String GET_FILTERED_PACKAGES_BY_AGE = "select * FROM InsurancePackages where ? BETWEEN insp_agelimit_start AND insp_agelimit_end;";
	private static final String GET_DISEASE_DETAILS_BY_PACKAGE_ID = "SELECT D.* FROM Diseases AS D JOIN InsurancePackageCoveredDiseases AS IPCD ON D.disc_id = IPCD.disc_id JOIN InsurancePackages AS IP ON IPCD.insp_id = IP.insp_id WHERE IP.insp_id = ?;";
	private static final String GET_CATEGORIES_DETAILS_BY_PACKAGE_ID = "SELECT D.* FROM InsurancePackageCategories AS D JOIN InsurancePackageCoverageCategories AS IPCD ON D.ipcc_id = IPCD.ipcc_id JOIN InsurancePackages AS IP ON IPCD.insp_id = IP.insp_id WHERE IP.insp_id = ?;";

	@Autowired
	public InsurancePackageDAOImpl(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<InsurancePackage> getAllInsurancePackages() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_INSURANCE_PACKAGES, new InsurancePackageRowMapper());
	}

	@SuppressWarnings("deprecation")
	public List<InsurancePackageCoveredDisease> getCoveredDiseasesByPackageId(int packageId) {
		return jdbcTemplate.query(GET_COVERED_DISEASES_BY_PACKAGE_ID, new Object[] { packageId },
				new InsurancePackageCoveredDiseaseRowMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public DiseaseDetails getDetailsByDiseaseId(int discId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(GET_DISEASE_DETAILS_BY_DISEASE_ID, new Object[] { discId },
				new DiseseDetailsRowMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<InsurancePackage> getFiteredDiseases(String status, int age) {
		// TODO Auto-generated method stub
		System.out.println("dao" + status + age);
		// System.out.println(jdbcTemplate.query("select * FROM InsurancePackages",
		// values, new InsurancePackageRowMapper()));
		return jdbcTemplate.query(GET_FILTERED_PACKAGES, new Object[] { status, age }, new InsurancePackageRowMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<InsurancePackage> getPackagesByStatus(String status) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_PACKAGES_BY_STATUS, new Object[] { status }, new InsurancePackageRowMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<InsurancePackage> getAllInsurancePackagesByAge(int age) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_FILTERED_PACKAGES_BY_AGE, new Object[] { age }, new InsurancePackageRowMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<DiseaseDetails> getDiseasesByPackageId(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_DISEASE_DETAILS_BY_PACKAGE_ID, new Object[] { id }, new DiseseDetailsRowMapper());

	}

	@Override
	public int addDisease(String name, String iCDCode, String description, String status, int inspid) {
		String sql = "INSERT INTO Diseases (disc_name, disc_icdcode, disc_desc, disc_status) VALUES (?, ?, ?, ?) RETURNING disc_id";

		try {
			// Execute the query and retrieve the generated disease ID
			int disid = jdbcTemplate.queryForObject(sql, Integer.class, name, iCDCode, description, status);
			String sql1 = "insert into InsurancePackageCoveredDiseases values(?,?)";
			return jdbcTemplate.update(sql1, inspid, disid);

		} catch (Exception e) {
			e.printStackTrace();
			return -1; // Return a negative value or handle the error as needed
		}
	}

	@Override
	public int deleteDisease(int did, int inspid) {

		try {
			String sql = "delete from InsurancePackageCoveredDiseases where insp_id=? and disc_id=? ";
			jdbcTemplate.update(sql, inspid, did);

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			return -1; // Return a negative value or handle the error as needed
		}
	}

	@Override
	public String editDisease(String name, String iCDCode, String description, String status, Integer id) {
		String sql = "UPDATE diseases SET disc_name = ?, disc_icdcode = ?, disc_desc = ?, disc_status = ? WHERE disc_id = ?";
		try {
			int rowsUpdated = jdbcTemplate.update(sql, name, iCDCode, description, status, id);
			System.out.println(rowsUpdated + "::::");
			if (rowsUpdated > 0) {
				return "Disease Updated Successfully..!!";
			} else {
				return "No disease found with the provided ID.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to update disease: " + e.getMessage();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Categories> getCategoriesByPackageId(int inspId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_CATEGORIES_DETAILS_BY_PACKAGE_ID, new Object[] { inspId }, new CategoryMapper());
	}

	public int deleteCategory(int did, int inspid) {

		try {
			String sql = "delete from InsurancePackageCoverageCategories where insp_id=? and ipcc_id=? ";
			jdbcTemplate.update(sql, inspid, did);
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			return -1; // Return a negative value or handle the error as needed
		}
	}

	@Override
	public int addCategory(String name, String title, String description, String status, int inspid) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO InsurancePackageCategories (ipcc_title, ipcc_desc, ipcc_status) VALUES (?, ?, ?) RETURNING ipcc_id";

		try {
			// Execute the query and retrieve the generated disease ID
			int ipccid = jdbcTemplate.queryForObject(sql, Integer.class, title, description, status);
			String sql1 = "insert into InsurancePackageCoverageCategories values(?,?)";
			return jdbcTemplate.update(sql1, inspid, ipccid);

		} catch (Exception e) {
			e.printStackTrace();
			return -1; // Return a negative value or handle the error as needed
		}
	}

	public String editCategory(String title, String description, String status) {
		System.out.println(title + "-" + description + "-" + status);
		String sql = "UPDATE InsurancePackageCategories SET ipcc_desc = ?, ipcc_status = ? WHERE ipcc_title = ?";
		try {
			int rowsUpdated = jdbcTemplate.update(sql, description, status, title);
			if (rowsUpdated > 0) {
				return "Disease Updated Successfully..!!";
			} else {
				return "No disease found with the provided ID.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to update disease: " + e.getMessage();
		}
	}

	@Override
	public int deletePackage(int inspid) {
		String sql1 = "delete from InsurancePackageCoverageCategories where  insp_id=?";
		jdbcTemplate.update(sql1, inspid);

		String sql2 = "delete from InsurancePackageCoveredDiseases where  insp_id=?";
		jdbcTemplate.update(sql2, inspid);

		String sql = "delete from InsurancePackages where  insp_id=?";

		return jdbcTemplate.update(sql, inspid);
	}

	public int deletePackage(int did, int hospid) {
		String sql = "delete from InsurancePackages where hosp_id=? and insp_id=?";
		int count = jdbcTemplate.update(sql, hospid, did);
		System.out.println("this is count" + count);
		return jdbcTemplate.update(sql, hospid, did);
	}
	// ------------------------------------------------------------------------------------

	@Override
	public String editPackage(String id, String title, String description, String status, String rangeStart,
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

	@Override
	public void addPackage(InsurancePackage insp) {

		String stmt = "INSERT INTO InsurancePackages (insp_title, insp_desc, insp_status, insp_range_start, insp_range_end, insp_agelimit_start, insp_agelimit_end) VALUES (?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(stmt, insp.getInspTitle(), insp.getInspDescription(), insp.getInspStatus(),
				insp.getInspRangeStart(), insp.getInspRangeEnd(), insp.getInspAgeLimitStart(),
				insp.getInspAgeLimitEnd());
	}
}