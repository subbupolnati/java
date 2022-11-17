package com.employee.marketing;

import com.employee.Employee;


public class MarketingExecutive extends Employee {
	 int ma=200;
	 int comm;
	 int ta;
	 public MarketingExecutive (){
		super();
	}
	public MarketingExecutive (int eid,String ename,int bsal){
		super(eid,ename,bsal);
		this.ta=calcTa();
		this.comm=calcComm();
		this.ma=200;
	}
		int calcTa()
		{
			ta=(int)(bsal*0.05);
			return ta;
		}
		int calcComm()
		{
			comm=(int)(bsal*0.02);
			return comm;
		}
		public double calcSalary()
		{
			gross=bsal+ta+comm+ma;
			return gross;
		}
		
		public void showDetails()
		{
			super.showDetails();
			System.out.println("ta is: "+ta);
			System.out.println("Medical: "+ma);
			System.out.println("commision: "+comm);
		}
		
	}
