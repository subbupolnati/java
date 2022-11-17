package com.movietitlesearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movietitlesearch.model.Movie;
import com.movietitlesearch.model.Response;
import com.movietitlesearch.service.MovieService;

@RestController
public class MovieTitleController {

	@Autowired
	MovieService movieService;
	
	@GetMapping("/movies")
	public ResponseEntity<Movie[]> searchAll(){
		return movieService.searchAllMovies();
	}
	@GetMapping("/movies/{name}")
	public ResponseEntity<Movie[]> getMovies(@PathVariable("name")String title){
		return movieService.getMovie(title);
	}
	@GetMapping("/movies/{name}/sort")
	public List<Movie> getTitle(@PathVariable("name")String title){
		return movieService.getTitleSorting(title);
	}
}
