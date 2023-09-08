package base.daos;

import java.util.List;

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

	public List getLoanApplicantDao() {

		return em.createQuery("SELECT e FROM LoanApplicant e").getResultList();
	}

	public boolean loanStatusDao(List<LoanApplicant> loan, Long applicantId) {
		for (LoanApplicant bb : loan) {
			if (bb.getId().equals(applicantId)) {
				// Found the matching applicant by ID
				bb.setStatus("accepted");
				em.merge(bb); // Persist the changes
				return true; // Return true to indicate success
			}
		}
		return false; // Return false if no matching ID was found
	}

}