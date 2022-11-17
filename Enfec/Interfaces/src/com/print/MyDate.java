package com.print;

public class MyDate implements Printable{
int day,mon,year;

public MyDate(int day, int mon, int year) {
	super();
	this.day = day;
	this.mon = mon;
	this.year = year;
}

public void printData() {
	System.out.println("print Date :"+day+"-"+mon+"-"+year);
}
}
