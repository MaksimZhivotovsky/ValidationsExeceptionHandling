package com.example.max.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.max.model.User;
import com.example.max.repo.UserRepo;

@Configuration
public class ProgectConfig {

	@Bean
	public CommandLineRunner dataLoader(UserRepo repo) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
	    		repo.save(new User(1l, "firstName", "LastName", "first@mail.ru", 23, "1234567891"));
	    		repo.save(new User(2l, "Ivan", "Ivanov", "ivanov@mail.ru", 33, "1234567891"));
	    		repo.save(new User(3l, "Petor", "Petrov", "petrov@mail.ru", 23, "1234567891"));
			}
		};
	}
}
