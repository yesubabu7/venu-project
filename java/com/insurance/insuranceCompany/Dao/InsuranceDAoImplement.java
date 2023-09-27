package com.insurance.insuranceCompany.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.insurance.insuranceCompany.model.InsurancePolicy;
import com.insurance.insuranceCompany.model.InsurancePolicySchedule;
import com.insurance.insuranceCompany.rowMapper.InsurancePolicyRowMapper;
import com.insurance.insuranceCompany.rowMapper.InsurancePolicyScheduleRowMapper;

@Component
public class InsuranceDAoImplement implements InsuranceDAO {
	private final JdbcTemplate j;

	@Autowired
	public InsuranceDAoImplement(JdbcTemplate j) {
		this.j = j;
	}

	@Override
	public List<InsurancePolicy> getAllPolicies() {
		String sql = "SELECT * FROM InsurancePolicies1";
		return j.query(sql, new InsurancePolicyRowMapper());
	}

	@Override
	public List<InsurancePolicySchedule> getAllSchedule() {
		String sql = "SELECT * FROM InsurancePolicySchedule";
		return j.query(sql, new InsurancePolicyScheduleRowMapper());
	}

	@Override
	public int addPolicy(InsurancePolicy e) {
		return j.update(
				"INSERT INTO InsurancePolicies1 (iplc_cust_id, iplc_cdate, iplc_sum_assured, iplc_applicable_date, iplc_nom_insured, iplc_insp_id, iplc_yrly_prem_amount, iplc_paymode_count, iplc_expdate, iplc_agnt_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				e.getIplc_cust_id(), e.getIplc_cdate(), e.getIplc_sum_assured(), e.getIplc_applicable_date(),
				e.getIplc_nom_insured(), e.getIplc_insp_id(), e.getIplc_yrly_prem_amount(), e.getIplc_paymode_count(),
				e.getIplc_expdate(), e.getIplc_agnt_id());
	}

	@Override
	public int updateStatus(InsurancePolicy e) {
		return j.update("UPDATE InsurancePolicies1 SET iplc_status = ? WHERE iplc_id = ?", e.getIplc_status(),
				e.getIplc_id());

	}

	@Override
	public InsurancePolicy getPolicyById(int id) {
		String stmt = "SELECT * FROM InsurancePolicies1 WHERE iplc_id = ?";
		return j.queryForObject(stmt, new InsurancePolicyRowMapper(), new Object[] { id });
	}

	@Override
	public int getNonPaymentStatus(int id) {
		try {
			String sql = "SELECT COUNT(*) FROM InsurancePolicySchedule WHERE CURRENT_DATE >= iplc_date AND iplc_paid_date IS NULL AND iplc_id = ?";
			return j.queryForObject(sql, Integer.class, id);
		} catch (EmptyResultDataAccessException e) {
			// Handle the case where no results are found
			return 0; // or throw an exception or handle it as needed
		}
	}

	@Override
	public List<Integer> findDistinctIplcIds() {
		String sql = "SELECT DISTINCT iplc_id FROM InsurancePolicySchedule";
		return j.queryForList(sql, Integer.class);
	}

	@Override
	public List<InsurancePolicySchedule> getAllScheduleById(int id) {
		String sql = "select * from InsurancePolicySchedule where iplc_id=?";
		return j.query(sql, new InsurancePolicyScheduleRowMapper(), new Object[] { id });
	}

}
