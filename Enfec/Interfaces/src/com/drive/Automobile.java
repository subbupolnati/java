package com.drive;

public class Automobile implements Driveable {
	public void startEngine() {
		System.out.println("Automobile engine Start");
	}
	public void stopEngine() {
		System.out.println("Automobile engine Stop");
	}
	public void accelarate() {
		System.out.println("Automobile engine accelerate");
	}
	public void turn() {
		System.out.println("Automobile turn");
	}
	void honkHorn() {
		System.out.println("Automobile press horn");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driveable a=new Automobile();
		a.startEngine();
		a.accelarate();
		((Automobile) a).honkHorn();
		a.turn();
		a.stopEngine();
		
		System.out.println("_________________________________");
		Driveable l=new Lawnmower();
		l.startEngine();
		l.accelarate();
		((Lawnmower) l).cutGrass();
		l.turn();
		l.stopEngine();
		
	}

}
