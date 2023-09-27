package com.insurance.insuranceCompany.rowMapper;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.insuranceCompany.model.NetworkHospitals;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NetworkHospitalRowMapper implements RowMapper<NetworkHospitals> {

    @Override
    public NetworkHospitals mapRow(ResultSet rs, int rowNum) throws SQLException {
        NetworkHospitals hospital = new NetworkHospitals();
        hospital.setHospId(rs.getInt("hosp_id"));
        hospital.setHospTitle(rs.getString("hosp_title"));
        hospital.setHospLocation(rs.getString("hosp_location"));
        hospital.setHospAddress(rs.getString("hosp_address"));
        hospital.setHospContactNumber(rs.getString("hosp_contact_number"));
        hospital.setHospPincode(rs.getInt("hosp_pincode"));
        hospital.setHospLuudate(rs.getDate("hosp_luudate"));
        hospital.setHospLuuser(rs.getInt("hosp_luuser"));
        hospital.setGrade(rs.getString("grade"));
        hospital.setFacilities(rs.getString("facilities"));
        return hospital;
    }
}
