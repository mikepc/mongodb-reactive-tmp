package com.owlbrite.sponsorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@SpringBootApplication
public class SponsorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SponsorServiceApplication.class, args);
	}
}
