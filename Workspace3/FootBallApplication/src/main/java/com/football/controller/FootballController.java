package com.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.football.model.FootBall;
import com.football.model.Response;
import com.football.service.RestService;

@RestController
public class FootballController {

	@Autowired
	private RestService restService;
	
	
	@GetMapping("/team1")
	public FootBall getTeam1() {
		return restService.getTeam1Data();
	}
	@GetMapping("/team2")
	public FootBall getTeam2() {
		return restService.getTeam2Data();
	}
	@GetMapping("/{team}/{year}")
	public Response getScore(@PathVariable("team") String team,@PathVariable("year")int year) {
		return restService.getTotalGoals(team, year);
	}
}
