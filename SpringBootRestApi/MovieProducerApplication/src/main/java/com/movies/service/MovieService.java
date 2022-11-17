package com.movies.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.movies.model.Movie;

@Service
public class MovieService {

	private List<Movie> movieList=new ArrayList<Movie>(
			Arrays.asList(new Movie("water world",1980,"tt2581456"),
					new Movie("Water world",1980,"tt2581456"),
					new Movie("The Making of 'Waterworld'",1995,"tt2670548"),
					new Movie("Waterworld 4: History of the Islands",1980,"tt2581477"),
					new Movie("Swordquest: Waterworld",1980,"tt2581487"),
					new Movie("spider man",1980,"tt2581894"),
					new Movie("Ant man",2000,"tt2581441")
			));
	
	public List<Movie> showAllDetails(){
		return movieList;
	}
	
	public List<Movie> getMovie(String title) {
		List<Movie> m=new ArrayList<Movie>();
		for(Movie e:movieList) {
			Movie movie=new Movie();
			if(e.getTitle().contains(title)) {
				movie.setTitle(e.getTitle());
				movie.setYear(e.getYear());
				movie.setImdbID(e.getImdbID());
				m.add(movie);
			}
		}
		return m;
	}
}
