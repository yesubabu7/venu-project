package com.insurance.insuranceCompany.Dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.insurance.insuranceCompany.rowMapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.insurance.insuranceCompany.model.Disease;
import com.insurance.insuranceCompany.model.InsurancePackage;

@Component
public class PackagesDao {
	@Autowired
	JdbcTemplate jdbc;
	
	
	public ArrayList<InsurancePackage> getAllPackages(){
		
		return (ArrayList<InsurancePackage>) jdbc.query("Select * from InsurancePackages ", new PackagesRowMapper());
	}


	public int addHospital(InsurancePackage insp) {
		String sql="insert into InsurancePackages(insp_title,insp_desc,insp_status,insp_range_start,insp_range_end,insp_agelimit_start,insp_agelimit_end)  values(?,?,?,?,?,?,?)";
		return jdbc.update(sql,insp.getInspTitle(),insp.getInspDescription(),insp.getInspStatus(),insp.getInspRangeStart(),insp.getInspRangeEnd(),insp.getInspAgeLimitStart(),insp.getInspAgeLimitEnd());
		
	}


	public int deletePackage(int pid) {
	
		String sql="delete from InsurancePackages where insp_id="+pid;
		
		return jdbc.update(sql);
	}


	public ArrayList<Disease> showDiseases(int pid) {
	    String sql = "SELECT * FROM Diseases d " +
                "INNER JOIN InsurancePackageCoveredDiseases icd " +
                "ON d.disc_id = icd.disc_id " +
                "WHERE icd.insp_id = ?";
	    ArrayList<Disease> diseaseNames = (ArrayList<Disease>) jdbc.query(sql, new Object[]{pid}, new DiseaseRowMapper());
	    
	    return diseaseNames;
	}


	public int getPackCount() {
		String sql="SELECT COUNT(*) FROM InsurancePackages";
		Integer count = jdbc.queryForObject(sql, Integer.class);
		return count;
	}
	

}
