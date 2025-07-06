package com.credify.credifyapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CredifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CredifyApplication.class, args);
		System.out.println("Hello from Credify app!");
	}

}
