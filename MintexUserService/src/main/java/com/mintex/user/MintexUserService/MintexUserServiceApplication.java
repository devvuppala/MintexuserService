package com.mintex.user.MintexUserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.mintex"})
public class MintexUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MintexUserServiceApplication.class, args);
		System.out.println("Started");
	}
}
