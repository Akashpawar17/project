package com.capg.hcms.user;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HcmsUserManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcmsUserManagementSystemApplication.class, args);
	}
	@Bean
	public Random getRandom() {
		return new Random();
	}

}
