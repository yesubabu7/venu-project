package yesu.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import yesu.entities.CustomerEntity;

@Component
public class LoanDAO {

	@PersistenceContext
	private EntityManager em;

	public boolean sendDataToDao(CustomerEntity customer) {
		try {
			em.persist(customer);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
