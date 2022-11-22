package com.justeat.cocktails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.justeat.controller","com.justeat.service","com.justeat.service.impl"} )
@EntityScan("com.justeat.entity")
@EnableJpaRepositories("com.justeat.repository") 
public class CocktailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CocktailsApplication.class, args);
	}

}
