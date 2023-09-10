package yesu.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import yesu.models.Customer;
import yesu.models.CustomerCustomerID;
import yesu.models.CustomerUser;
import yesu.models.LoanApplicant;
import yesu.models.Nominee;

@Component
public class CustomerDAO {
	
	int globalVariable;
	

	@PersistenceContext
	private EntityManager em;
	int userid;
	
	
	
	public List<Long> findCustomerIDSForUserId(int userId) {
		 globalVariable=userId;
        String jpql = "SELECT c.customerCustomId FROM CustomerCustomerID c " +
                      "WHERE c.customerUser.userId = :userId";

        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        query.setParameter("userId", userId);
        
        
        
        
        

        return query.getResultList();
    }
	
	

	public void save(Customer customer, Nominee nominee, LoanApplicant loanapplicant) {
		em.persist(customer);
		em.persist(nominee);
		em.persist(loanapplicant);
		
		
		
		String jpql = "SELECT MAX(c.customerCustomId) FROM CustomerCustomerID c";

		TypedQuery<Long> query = em.createQuery(jpql, Long.class);

		Long maxCustomerID = query.getSingleResult(); // Get the maximum customer_custom_id

		if (maxCustomerID != null) {
		    userid = this.globalVariable;
		    System.out.println(userid+"in dap");
		    System.out.println(globalVariable+"in dap global");
		    
		    maxCustomerID += 1;

		    // Create a new CustomerCustomerID entity and set its values
		    CustomerCustomerID newCustomerID = new CustomerCustomerID();

		    newCustomerID.setUserId(userid);

		    newCustomerID.setCustomerCustomId(maxCustomerID);

		    // Persist the new CustomerCustomerID entity
		    em.persist(newCustomerID);
		} else {
		    System.out.println("Empty CustomerCustomerID table");
		}

	}

	public List getLoanApplicantDao() {

		return em.createQuery("SELECT e FROM LoanApplicant e").getResultList();
	}
	
	

	public boolean loanStatusDao(List<LoanApplicant> loan, Long applicantId,String status) {
		for (LoanApplicant bb : loan) {
			if (bb.getId().equals(applicantId) &&  status.equals("Accept")) {
				// Found the matching applicant by ID
				bb.setStatus("accepted");
				em.merge(bb); // Persist the changes
				return true; // Return true to indicate success
			}
			else if (bb.getId().equals(applicantId) && status.equals("Reject")) {
				// Found the matching applicant by ID
				bb.setStatus("Rejected");
				em.merge(bb); // Persist the changes
				return true; // Return true to indicate success
			}
		}
		
		
		return false; // Return false if no matching ID was found
	}
	
	
	
	public List<CustomerUser> getAllCustomerUsersDao() {
        String query = "SELECT cu FROM CustomerUser cu";
        return em.createQuery(query, CustomerUser.class).getResultList();
    }

	

	

	

	public List<Customer> getAllSelectedCustomers(List<Long> customerIDs) {
		// TODO Auto-generated method stub
		String jpql = "SELECT c FROM Customer c WHERE c.id IN :customerIDs";

        TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
        query.setParameter("customerIDs", customerIDs);

        return query.getResultList();
		
		
	}
	

	
		
	}
