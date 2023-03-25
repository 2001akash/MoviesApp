package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.moviepackage.Movie;

@Repository
public  interface MovieRepository extends CrudRepository<Movie, String>  {

	
	
	
}
