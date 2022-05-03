package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
public class SpringDeckCardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDeckCardsApplication.class, args);
	}
}
