package com.insurance.insuranceCompany.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.insuranceCompany.model.InsurancePackageCoveredDisease;

public class InsurancePackageCoveredDiseaseRowMapper implements RowMapper<InsurancePackageCoveredDisease> {

    @Override
    public InsurancePackageCoveredDisease mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        InsurancePackageCoveredDisease disease = new InsurancePackageCoveredDisease();
        
        // Set values using setters
        disease.setInspId(resultSet.getInt(1));  // Assuming insp_id is the first column
        disease.setDiscId(resultSet.getInt(2));  // Assuming disc_id is the second column

        return disease;
    }
}
