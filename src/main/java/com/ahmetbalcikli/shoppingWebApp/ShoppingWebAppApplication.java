package com.ahmetbalcikli.shoppingWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ShoppingWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingWebAppApplication.class, args);
	}

}
