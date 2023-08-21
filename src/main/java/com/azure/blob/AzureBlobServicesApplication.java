package com.azure.blob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AzureBlobServicesApplication {

	public static void main(String[] args) {
		System.out.println("Hello world");
		SpringApplication.run(AzureBlobServicesApplication.class, args);
	}

}
