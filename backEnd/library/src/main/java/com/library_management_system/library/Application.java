package com.library_management_system.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAspectJAutoProxy()
public class Application {

		public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("hello");

	}


}
