package com.example;

import java.time.LocalDate;
import java.time.Period;

public class CalculateDate {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(1995, 3, 25);
	    LocalDate date2 = LocalDate.now();
	    System.out.println("date1 ::"+date1);
	    System.out.println("date2 ::"+date2);
		Period p=Period.between(date1, date2);
		System.out.println("years ::"+p.getYears());
		System.out.println("Months ::"+p.getMonths());
		System.out.println("Days ::"+p.getDays());
		}
}

