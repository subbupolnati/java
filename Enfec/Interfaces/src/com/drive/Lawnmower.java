package com.drive;

public class Lawnmower implements Driveable {
	public void startEngine() {
		System.out.println("lawnmower engine Start");
	}
	public void stopEngine() {
		System.out.println("lawnmower engine Stop");
	}
	public void accelarate() {
		System.out.println("lawnmower engine accelerate");
		
	}
	public void turn() {
		System.out.println("lawnmower turn");
	}
	void cutGrass() {
		System.out.println("cutting Gross");
	}
}
