package com.insurance.insuranceCompany.contract;

import java.util.ArrayList;

import com.insurance.insuranceCompany.model.PaymentModel;

public interface PaymentDAOInterface {
	public ArrayList<PaymentModel> getAllTransaction();
}
