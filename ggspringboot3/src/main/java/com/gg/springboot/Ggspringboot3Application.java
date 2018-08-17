package com.gg.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Ggspringboot3Application {

	public static void main(String[] args) {
		SpringApplication.run(Ggspringboot3Application.class, args);
	}
}
