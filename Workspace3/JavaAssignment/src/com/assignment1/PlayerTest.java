package com.assignment1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

class Player{
	String name;
	int score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + "]";
	}
	public Player(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
class Checker implements Comparator<Player>{

	@Override
	public int compare(Player o1,Player o2) {
		if (o1.score<o2.score) {
			return 1;
		}
		else if (o1.score>o2.score) {
			return -1;
		} 
		else 
			return o1.name.compareTo(o2.name);
	}
}
public class PlayerTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("how many  players entered");
		int n=sc.nextInt();
		Player[] playerArray=new Player[n];
		for(int i=0;i<n;i++) {
			System.out.println("enter player name");
			String name=sc.next();
			System.out.println("enter score");
			int score=sc.nextInt();
			playerArray[i]=new Player(name, score);
		}
		Checker ch=new Checker();
		Arrays.sort(playerArray,ch);
		for(int i=0;i<playerArray.length;i++) {
			System.out.println(playerArray[i].name+" "+playerArray[i].score);
		}
	}

}
