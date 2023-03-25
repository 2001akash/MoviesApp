package com.example.demo;

import com.example.demo.MovieRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackageClasses = MovieRepository.class)
@SpringBootApplication(scanBasePackages = {"com.example.demo","com.example.demo.moviepackage"})
public class MoviesAppApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MoviesAppApplication.class, args);
	}

	
	
	
}