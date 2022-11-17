package com.bank;

public class Bank {
	int acno;
	int dep;
	int bal;
	@Override
	public String toString() {
		return "Bank [acno=" + acno + ", dep=" + dep + ", bal=" + bal + "]";
	}
	public int getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	public int getDep() {
		return dep;
	}
	public void setDep(int dep) {
		this.dep = dep;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
}
