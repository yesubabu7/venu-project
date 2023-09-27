package com.insurance.insuranceCompany.Dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.insurance.insuranceCompany.model.InsCompCustomer;
import com.insurance.insuranceCompany.model.InsCompPolicy;
import com.insurance.insuranceCompany.rowMapper.*;



@Component
public class CustomerDAOImpl implements CustomerDAOInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public ArrayList<InsCompCustomer> getAllCustomers() {
		String stmt = "SELECT * FROM Customers";
		return (ArrayList<InsCompCustomer>) jdbcTemplate.query(stmt, new CustomerRowMapper());
	}

	@Override
	public InsCompCustomer getCustomerById(int id) {
		String stmt = "SELECT * FROM Customers WHERE cust_id = ?";
		return jdbcTemplate.queryForObject(stmt, new CustomerRowMapper(), new Object[]{id});
	}

	@Override
	public String updateStatus(int id, String status) {
		String sql = "UPDATE Customers SET cust_status = ? WHERE cust_id = ?";
        try {
            int rowsUpdated = jdbcTemplate.update(sql, status, id);
            if (rowsUpdated > 0) {
                return "Status Updated Successfully..!!";
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
	public ArrayList<InsCompPolicy> getPolicies(String custId) {
		Integer id = Integer.parseInt(custId);
		String sql = "SELECT * FROM InsurancePolicies WHERE iplc_cust_id = ?";
        return (ArrayList<InsCompPolicy>) jdbcTemplate.query(sql, new Object[]{id}, new InsCompPolicyRowMapper());
	}

}