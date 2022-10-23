package com.activite2.accountservice;

import com.activite2.accountservice.entities.Bankaccount;
import com.activite2.accountservice.entities.Customer;
import com.activite2.accountservice.enums.AccountType;
import com.activite2.accountservice.repositories.BankAccountRepository;
import com.activite2.accountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository,CustomerRepository customerRepository){
		return args -> {
			Stream.of("Mohamed","yassine","hanae","imane").forEach(c->{
				Customer customer=Customer.builder()
						.name(c)
						.build();
				customerRepository.save(customer);
				for (int i = 0; i <10 ; i++) {
					Bankaccount bankaccount = Bankaccount.builder()
							.id(UUID.randomUUID().toString())
							.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
							.balance(Math.random() * 90000)
							.createdAt(new Date())
							.currency("MAD")
							.customer(customer)
							.build();
					bankAccountRepository.save(bankaccount);
				}
			});



		};
	}

}
