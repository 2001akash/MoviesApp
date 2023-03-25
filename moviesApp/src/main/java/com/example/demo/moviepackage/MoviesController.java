package com.example.demo.moviepackage;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {

	// to Access this method type in browser
	// http://localhost:8080/movies
	
	// Dependency Injection 
	
	@Autowired
	private MovieService service;
	
	@RequestMapping("/movies")
	public List<Movie> getAllMovies() {
		
		return service.getAllMovies();
	}
	
	// to call this method
	// http://localhost:8080/movies/2
	
	@RequestMapping("/movies/{id}")
	public Movie getMovie(@PathVariable String id) {
		
	 return service.getMovie(id);
				
	}
	
	// adding a function to Add Movie
	@RequestMapping(method=RequestMethod.POST,value="/movies")
	public void addMovie(@RequestBody Movie mov) {
		service.addMovie(mov);
	}
	
	// Let us Define  a method to Update an Exisiting Movie, this will use Put Request to the server.
	
	@RequestMapping(method=RequestMethod.PUT,value="/movie/{id}")
	public void updateMovie(@RequestBody Movie mov , @PathVariable String id ) {
		service.updateMovie(mov,id);
	}
	
	//Let us write a Method to Delete Movie
	
	@RequestMapping(method=RequestMethod.DELETE,value="movie/{id}")
	public void deleteMovie(@PathVariable String id) {
		service.deleteMovie(id);
	}
	
	// let us write the method to search movie by movie Title
	
	@RequestMapping("/search/{title}")
	public Movie getMovieByTitle(@PathVariable String title) {
		return service.getMovieByTitle(title);
	}
	
	
}




















