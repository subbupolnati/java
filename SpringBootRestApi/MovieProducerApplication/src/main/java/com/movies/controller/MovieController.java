package com.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movies.model.Movie;
import com.movies.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		return movieService.showAllDetails();
	}
	@GetMapping("/movies/{name}")
	public List<Movie>getMovies(@PathVariable("name")String title){
		return movieService.getMovie(title);
	}
}

