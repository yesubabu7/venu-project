package com.insurance.insuranceCompany.rowMapper;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.insuranceCompany.model.Disease;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiseaseRowMapper implements RowMapper<Disease> {
    @Override
    public Disease mapRow(ResultSet rs, int rowNum) throws SQLException {
        Disease disease = new Disease();
        disease.setDisc_id(rs.getLong("disc_id"));
        disease.setDisc_name(rs.getString("disc_name"));
        disease.setDisc_icdcode(rs.getString("disc_icdcode"));
        disease.setDisc_desc(rs.getString("disc_desc"));
        disease.setDisc_status(rs.getString("disc_status"));
        return disease;
    }
}
