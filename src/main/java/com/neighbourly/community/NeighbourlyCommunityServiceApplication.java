package com.neighbourly.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NeighbourlyCommunityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeighbourlyCommunityServiceApplication.class, args);
	}

}
