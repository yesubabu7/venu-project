package yesu.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yesu.daos.LoanDAO;
import yesu.entities.CustomerEntity;
import yesu.models.LoanApplicationForm;

@Service
public class LoanServices {

	private LoanDAO loandao;

	@Autowired
	public LoanServices(LoanDAO loandao) {
		this.loandao = loandao;
	}

	@Transactional
	public boolean sendDataToService(LoanApplicationForm loanApplication) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		CustomerEntity customer = new CustomerEntity();

		try {
			customer.setFirstName(loanApplication.getFirstname());
			customer.setLastName(loanApplication.getLastname());
			customer.setDob(dateFormat.parse(loanApplication.getDob()));
			customer.setPan(loanApplication.getPan());
			customer.setMobile(loanApplication.getMobile());
			customer.setAddress(loanApplication.getAddress());
			customer.setGuardianName(loanApplication.getGuardianName());
			customer.setLastUpdatedDate(new Date());
			customer.setCustLUser(1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return loandao.sendDataToDao(customer);
	}

}