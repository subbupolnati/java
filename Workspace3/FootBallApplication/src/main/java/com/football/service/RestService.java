package com.football.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.football.model.FootBall;
import com.football.model.Matches;
import com.football.model.Response;

@Service
public class RestService {

	RestTemplate template;

	public RestService(RestTemplate template) {
		super();
		this.template = template;
	}
	
	public FootBall getTeam1Data() {
		return template.getForObject("https://jsonmock.hackerrank.com/api/football_matches?year=2011&team1=Barcelona&page=1", FootBall.class);
	}
	public FootBall getTeam2Data() {
		return template.getForObject("https://jsonmock.hackerrank.com/api/football_matches?year=2011&team2=Barcelona&page=1", FootBall.class);
	}
	public Response getTotalGoals(String team,int year) {
		Response responseTeam1=getMatchesData(getTeam1Data().getData(),team);
		Response responseTeam2=getMatchesData(getTeam2Data().getData(),team);
		int totalGoals=responseTeam1.getGoals()+responseTeam2.getGoals();
		Response res=new Response(team,totalGoals);
		return res; 
	}
	public Response getMatchesData(Matches[] matches,String team) {
		int c=0;
		for (int i=0;i<matches.length;i++) {
				if(matches[i].getTeam1().equals(team))
					c+=Integer.parseInt(matches[i].getTeam1goals());
				else if(matches[i].getTeam2().equals(team))
					c+=Integer.parseInt(matches[i].getTeam2goals());
			}
		return new Response(team,c);
	}
}
