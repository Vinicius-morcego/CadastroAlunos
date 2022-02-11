package com.algaworks.algaschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.algaworks.algaschool.infrastructure.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)

public class AlgaschoolApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgaschoolApiApplication.class, args);
	}

}
