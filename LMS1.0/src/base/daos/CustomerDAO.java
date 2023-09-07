package base.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import base.models.Customer;
import base.models.LoanApplicant;
import base.models.Nominee;

@Component
public class CustomerDAO {

	@PersistenceContext
	private EntityManager em;

	public void save(Customer customer, Nominee nominee, LoanApplicant loanapplicant) {
		em.persist(customer);
		em.persist(nominee);
		em.persist(loanapplicant);
	}

}
