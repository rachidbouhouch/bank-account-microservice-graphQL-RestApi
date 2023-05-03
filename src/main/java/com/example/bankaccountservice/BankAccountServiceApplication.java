package com.example.bankaccountservice;

import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.entities.Customer;
import com.example.bankaccountservice.enums.AccountType;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import com.example.bankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {



	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){

		return arg -> {
			Stream.of("Rachid","Achraf","Khalid","Youssef").forEach(
					(c)-> {
						Customer customer=Customer.builder()
								.name(c)
								.build();
						customerRepository.save(customer);

					}
			);

			customerRepository.findAll().forEach(
					(c)-> {
						for(int i=0;i<10;i++){
							BankAccount bankAccount = BankAccount.builder()
									.id(UUID.randomUUID().toString())
									.createdAt(new Date())
									.type(Math.random()>0.5? AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT)
									.balance(10000+Math.random()*90000)
									.currency("MAD")
									.customer(c)
									.build();
							bankAccountRepository.save(bankAccount);
						}
					}
			);

		};
	}


}
