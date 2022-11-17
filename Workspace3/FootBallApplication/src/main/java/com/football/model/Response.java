package com.football.model;

public class Response {

	private String team;
	private int goals;
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals = goals;
	}
	public Response(String team, int goals) {
		super();
		this.team = team;
		this.goals = goals;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Response [team=" + team + ", goals=" + goals + "]";
	}
	
}
