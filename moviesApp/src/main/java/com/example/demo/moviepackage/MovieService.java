package com.example.demo.moviepackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MovieRepository;

@Service
public class MovieService {
	

	@Autowired
	MovieRepository movieRepository;

	private ArrayList<Movie> movies= new ArrayList<Movie>(
			Arrays.asList(
			
			new Movie("1","Bahubali","Story of a King"),
			new Movie("2","Black Adam","DC Movies "),
			new Movie("3","Shershah","Army Wins over Enemy! ")
			
			));
	
	public List<Movie> getAllMovies(){
		
				List<Movie> movies = new ArrayList();
				movieRepository.findAll().forEach(movies::add);
				return movies;
				
	}
	
	// let us define a function to get Movie by ID
	
	public Movie getMovie(String id) {
		return 
				movies.stream().filter(mov->mov.getId().equals(id)).findFirst().get();
	}

	public void addMovie(Movie mov) {
		
		movies.add(mov);
	}

	public void updateMovie(Movie mov, String id) {
		
		// here Service Method Contains the Logic to Update Movie.
		
		// in the below logic we scanned Existing Movies.
		// we checked if the id of existing movie matches with provided id in request
		// using .set() method we updated the existing movie by new details provided.
		
		for(int i=0;i<movies.size();i++) {
		
			Movie m = movies.get(i);
			
			if(m.getId().equals(id)) {
				movies.set(i, mov);
				return;
			}
			
		}
		
	}

	public void deleteMovie(String id) {

		// code to delete the movie
		movies.removeIf(mov -> mov.getId().equals(id));
		
	}

	public Movie getMovieByTitle(String title) {
		
		return 
movies.stream().filter(mov->mov.getName().equalsIgnoreCase(title)).findFirst().get();
		
	}
}














