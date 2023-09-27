package com.insurance.insuranceCompany.Dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.insurance.insuranceCompany.contract.DiseaseDAOInterface;
import com.insurance.insuranceCompany.model.Disease;
import com.insurance.insuranceCompany.rowMapper.*;

@Component
public class DiseaseDAOImpl implements DiseaseDAOInterface {
    
	@Autowired
    JdbcTemplate jd;

    @Override
    public ArrayList<Disease> getAllDisease() {
        String sql = "SELECT * FROM Diseases";
        return (ArrayList<Disease>) jd.query(sql, new DiseaseRowMapper());
    }

    @Override
    public String addDisease(String name, String iscCode, String desc, String status) {
        String sql = "INSERT INTO Diseases (disc_name, disc_icdcode, disc_desc, disc_status) VALUES (?, ?, ?, ?)";
        try {
            jd.update(con -> {
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setString(1, name);
                ps.setString(2, iscCode);
                ps.setString(3, desc);
                ps.setString(4, status);
                
                return ps;
            });
            return "Disease Added Successfully..!!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to add disease: " + e.getMessage();
        }
    }

    @Override
    public String editDisease(String name, String ICDCode, String desc, String status) {
        String sql = "UPDATE Diseases SET disc_icdcode = ?, disc_desc = ?, disc_status = ? WHERE disc_name = ?";
        try {
            int rowsUpdated = jd.update(sql, ICDCode, desc, status, name);
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
    public String deleteDisease(String name) {
        String sql = "DELETE FROM Diseases WHERE disc_name = ?";
        try {
            int rowsDeleted = jd.update(sql, name);
            if (rowsDeleted > 0) {
                return "Disease Deleted Successfully..!!";
            } else {
                return "No disease found with the provided name.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to delete disease: " + e.getMessage();
        }
    }
}
