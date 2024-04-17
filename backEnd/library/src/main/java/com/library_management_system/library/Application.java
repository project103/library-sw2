package com.library_management_system.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("hello");

	}

}
