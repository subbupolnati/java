package com.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Game{
	int game_id;
	String game_name;
	int no_of_players;
	String rules;
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public int getNo_of_players() {
		return no_of_players;
	}
	public void setNo_of_players(int no_of_players) {
		this.no_of_players = no_of_players;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	@Override
	public String toString() {
		return "Game [game_id=" + game_id + ", game_name=" + game_name + ", no_of_players=" + no_of_players + ", rules="
				+ rules + "]";
	}
	public Game(int game_id, String game_name, int no_of_players, String rules) {
		super();
		this.game_id = game_id;
		this.game_name = game_name;
		this.no_of_players = no_of_players;
		this.rules = rules;
	}
	
	
}
class GameComparatorByno_of_players implements Comparator<Game>{
	@Override
	public int compare(Game o1, Game o2) {
		if(o1.no_of_players<o2.no_of_players)
			return -1;
		else if(o1.no_of_players>o2.no_of_players)
			return 1;
		else
			return 0;
	}
	
}
class GameComparatorByname implements Comparator<Game>{
	@Override
	public int compare(Game o1, Game o2) {
		// TODO Auto-generated method stub
		return o1.game_name.compareTo(o2.game_name);
	}
}
public class GameSearchExample {
	public static int game_id;
	public static String game_name;
	public static int no_of_players;
	public static String rules;
	public static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter game id");
		game_id=sc.nextInt();
		System.out.println("enter game name");
		game_name=sc.next();
		System.out.println("enter game no of players");
		no_of_players=sc.nextInt();
		System.out.println("enter rules");
		rules=sc.next();		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList a =new ArrayList();
		System.out.println("how many games are entered");
		int n=sc.nextInt();
		int i=1;
		while(i<=n) {
			getDetails();
			a.add(new Game(game_id,game_name,no_of_players,rules));
			i++;
		}
		System.out.println("enter store elements options \n 1.store by game_name\n 2.store by no_of_players\n");
		int store=sc.nextInt();
		if(store==1) {
			Collections.sort(a,new GameComparatorByname());
			System.out.println("after store elements in name "+a);
		}
		else if(store==2) {
			Collections.sort(a,new GameComparatorByno_of_players());
			System.out.println("after store elements in no_of_players: "+a);
		}
		else
			System.out.println("enter valid store option");
		
		System.out.println("enter search options \n 1.search by game_name\n 2.search by no_of_players\n");
		int option=sc.nextInt();
		if(option==1) {
			System.out.println("enter game name for search");
			String nm=sc.next();
			Game g1=new Game(0,nm,0,null);
			int index=Collections.binarySearch(a,g1,new GameComparatorByname());
			if(index<0)
					System.out.println("enterd game name not found");
			else
				System.out.println("game name found in"+a.get(index));
		}
		else if(option==2) {
			System.out.println("enter no_of_players for search");
			int n1=sc.nextInt();
			Game g1=new Game(0,null,n1,null);
			int index=Collections.binarySearch(a,g1,new GameComparatorByno_of_players());
			if(index<0)
					System.out.println("entered no of players  not found");
			else
				System.out.println("no of players found in"+a.get(index));
		
		}
		else
			System.out.println("enter valid search option");

	}

}
