package eu.vrtime.vaadinui.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import eu.vrtime.vaadinui.domain.Customer;
import eu.vrtime.vaadinui.repo.CustomerRepo;

@Configuration
@EnableJpaRepositories(basePackages = {"eu.vrtime.vaadinui.repo"})
@EntityScan(basePackages = {"eu.vrtime.vaadinui.domain"})
public class SpringConfig {

	@Bean
	public CommandLineRunner genTestData(CustomerRepo customerRepo) {

		/* Nuclear War */
		
		return (args) -> {
			customerRepo.saveAndFlush(new Customer("1111", "Ronnie", "Raygun"));
			customerRepo.saveAndFlush(new Customer("2222", "P.M.", "Satcher"));
			customerRepo.saveAndFlush(new Customer("3333", "Infidel", "Castro"));
			customerRepo.saveAndFlush(new Customer("4444", "Col. Malomar", "Khadaffy"));
			customerRepo.saveAndFlush(new Customer("5555", "Ayatollah", "Kookamamie"));
			customerRepo.saveAndFlush(new Customer("6666", "Mao", "the Pun"));
			customerRepo.saveAndFlush(new Customer("7777", "Jimi", "Farmer"));
			customerRepo.saveAndFlush(new Customer("8888", "Tricky", "Dick"));
			customerRepo.saveAndFlush(new Customer("9999", "Mikhail", "Gorabachef"));
			customerRepo.saveAndFlush(new Customer("1010", "", "Ghanji"));

		};

	}

}
