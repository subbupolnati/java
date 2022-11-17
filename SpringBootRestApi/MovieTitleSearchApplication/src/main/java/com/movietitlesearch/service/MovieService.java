package com.movietitlesearch.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movietitlesearch.model.Movie;
import com.movietitlesearch.model.Response;

@Service
public class MovieService {

	RestTemplate restTemplate;
	String Titles[];
	public MovieService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	public ResponseEntity<Movie[]>  searchAllMovies(){
		String url="http://localhost:9090/movies";
		HttpEntity<Movie> entity=new HttpEntity<Movie>(null,null);
		ResponseEntity<Movie[]> response=restTemplate.exchange(url,HttpMethod.GET,entity,Movie[].class);
		return response;
	}
	public ResponseEntity<Movie[]> getMovie(String title){
		String url="http://localhost:9090/movies/"+title;
		HttpEntity<Movie> entity=new HttpEntity<Movie>(null,null);
		ResponseEntity<Movie[]> response=restTemplate.exchange(url,HttpMethod.GET,entity,Movie[].class);
		return response;
	}
	public List<Movie> getTitleSorting(String title){
		String url="http://localhost:9090/movies/"+title;
		HttpEntity<Movie> entity=new HttpEntity<Movie>(null,null);
		ResponseEntity<Movie[]> response=restTemplate.exchange(url,HttpMethod.GET,entity,Movie[].class);
		Movie[] m=response.getBody();
		ArrayList responseList=new ArrayList<>();
		for(int i=0;i<m.length;i++) {
			responseList.add(m[i].getTitle());
		}
		Collections.sort(responseList);
		return responseList;
	}
	
}