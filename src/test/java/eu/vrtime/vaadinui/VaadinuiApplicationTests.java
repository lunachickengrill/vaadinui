package eu.vrtime.vaadinui;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import eu.vrtime.vaadinui.repo.CustomerRepo;

@SpringBootTest
class VaadinuiApplicationTests {
	
	@Autowired
	private CustomerRepo customerRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testDummyData() {
		assertTrue(customerRepo.count()>0);
		assertTrue(customerRepo.findByCustomerIdStartsWithIgnoreCase("1111")!=null);
	}

}
