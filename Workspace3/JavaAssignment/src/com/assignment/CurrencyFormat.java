package com.assignment;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormat {
	public static void getCurrency(double payment) {
		String us=NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String india=NumberFormat.getCurrencyInstance(new Locale("en","IN")).format(payment);
        String china=NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france=NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        System.out.println("US :"+us);
        System.out.println("India :Rs."+india);
        System.out.println("China :"+china);
        System.out.println("France :"+france);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter payment");
        double payment = scanner.nextDouble();
        getCurrency(payment);
        
	}

}
