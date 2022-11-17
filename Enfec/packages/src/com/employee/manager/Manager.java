package com.employee.manager;
import com.employee.Employee;
public class Manager extends Employee{
	int incentive;

	public Manager(int eid, String ename, int bsal) {
		super(eid, ename, bsal);
		this.incentive = calcIncentive();
	}
	int calcIncentive(){
		incentive=(int)(bsal*0.1);
		return incentive;
	}
	public double calcSalary() {
		gross=bsal+incentive;
		return gross;
	}
}
