package com.savingbank;

public class SavingAccount {
	static double annualInterestRate=0.04;
	private double savingBalance;
	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SavingAccount(double savingBalance) {
		super();
		this.savingBalance = savingBalance;
	}

	public double calcMonthlyInterest() {
		double monthint=annualInterestRate/12;
		savingBalance+=(monthint*savingBalance);
		return savingBalance;
	}
	
	public double getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(double savingBalance) {
		this.savingBalance = savingBalance;
	}

	static double modifyInterestRate() {
		annualInterestRate=0.05;
		return annualInterestRate;
	}
	public void nextMonth() {
		modifyInterestRate();
		calcMonthlyInterest();
		
	}

	public static void main(String[] args) {
		SavingAccount saver1=new SavingAccount(2000.00);
		SavingAccount saver2=new SavingAccount(3000.00);
		System.out.println("");
		saver1.calcMonthlyInterest();
		saver2.calcMonthlyInterest();
		System.out.println("saver1 new balance is 0.4% ="+saver1.savingBalance);
		System.out.println("saver2 new balance is 0.4% ="+saver2.savingBalance);
		System.out.println("_________________________________________________________");
		saver1.nextMonth();
		saver2.nextMonth();
		System.out.println("saver1 new in next month balance is 0.5% ="+saver1.getSavingBalance());
		System.out.println("saver2 new in next month balance is 0.5% ="+saver2.getSavingBalance());	

	}

}
