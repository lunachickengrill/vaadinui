package eu.vrtime.vaadinui.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.vrtime.vaadinui.domain.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

	public List<Customer> findByCustomerIdStartsWithIgnoreCase(final String customerId);
	
	public Customer findByFirstNameStartsWithIgnoreCase(final String firstName);
	
	public Customer findByLastNameStartsWithIgnoreCase(final String lastName);
	
}
