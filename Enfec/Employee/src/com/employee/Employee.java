package com.employee;

public class Employee {
	 int eid;
	 String ename;
	 double bsal;
	 double gross_sal;
	 double net_sal;
	 Employee(int eid,String ename,double bsal){
		 super();
		 this.eid=eid;
		 this.ename=ename;
		 this.bsal=bsal;
	 }
	 
	
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
		 Employee e=new Employee(101,"subbu",10000);
		 Marketing_Executive1 me=new Marketing_Executive1(101,"subbu",10000);
		 me.calcTa();
		 me.calcComm();
		 me.clacGross_sal();
		 me.calcNet_sal();
		 me.display();
		 System.out.println("------------------------------");
		 Manager ma=new Manager(102,"s",12000);
		 ma.calcInsentive();
		 ma.clacGross_sal();
		 ma.calcNet_sal();
		 ma.display();

		}

	}
class Marketing_Executive1 extends Employee{
	 int ma=200;
	double comm;
	double ta;
	Marketing_Executive1(int eid,String ename,double bsal){
		super(eid,ename,bsal);
	}
	double calcTa()
	{
		ta=0.05*bsal;
		return ta;
	}
	double calcComm()
	{
		comm=0.02*bsal;
		return comm;
	}
	double clacGross_sal()
	{
		gross_sal=bsal+ta+comm+ma;
		return gross_sal;
	}
	double calcNet_sal()
	{
		net_sal=gross_sal;
		return net_sal;
	}
	void display()
	{
		System.out.println("emp_id is: "+eid);
		System.out.println();
		System.out.println("Employee_name: "+ename);
		System.out.println();
		System.out.println("Acctuval salary: "+bsal);
		System.out.println();
		System.out.println("gross_sal is: "+gross_sal);
		System.out.println();
		System.out.println("net_sal is: "+net_sal);
	}
}
class Manager1 extends Employee{
	 double insentive;
	Manager1(int eid,String ename,double bsal){
		super(eid,ename,bsal);
	}
	double calcInsentive()
	{
		insentive=0.1*bsal;
		
		return insentive;
	}
	double clacGross_sal()
	{
		gross_sal=bsal+insentive;
		return gross_sal;
	}
	double calcNet_sal()
	{
		net_sal=gross_sal;
		return net_sal;
	}
	void display()
	{
		System.out.println("emp_id is: "+eid);
		System.out.println();
		System.out.println("Employee_name: "+ename);
		System.out.println();
		System.out.println("Acctuval salary: "+bsal);
		System.out.println();
		System.out.println("gross_sal is: "+gross_sal);
		System.out.println();
		System.out.println("net_sal is: "+net_sal);
	}
	
}

	
