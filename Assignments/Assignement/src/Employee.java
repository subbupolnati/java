import java.util.Scanner;

public class Employee {
	int empid;
	String ename;
	int bsalary;
	int total_salary;
	
	public Employee(int empid, String ename, int bsalary) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.bsalary = bsalary;
		
	}
	public void display()
	{
		System.out.println("emp_id is: "+empid);
		System.out.println();
		System.out.println("Employee_name: "+ename);
		System.out.println();
		System.out.println("Acctuval salary: "+bsalary);
		System.out.println();
	}
	public static void main(String[] args) {
		
		/*Employee me=new Marketing_Executive(101,"subbu",10000);
		me.display();
		System.out.println("____________________________");
		Employee m=new Manager(102,"geetha",15000);
		m.display();*/
			Scanner sc=new Scanner(System.in);
			System.out.println("enter emp_id is: ");
			int empid=sc.nextInt();
			System.out.println("enter Employee_name: ");
			String ename=sc.next();
			System.out.println("enter basic salary: ");
			int bsalary=sc.nextInt();
			System.out.println("enter manager_id is: ");
			int empid1=sc.nextInt();
			System.out.println("enter manger_name: ");
			String ename1=sc.next();
			System.out.println("enter manager salary: ");
			int bsalary1=sc.nextInt();
			Employee me=new Marketing_Executive(empid,ename,bsalary);
			me.display();
			System.out.println("____________________________");
			
			Employee m=new Manager(empid1,ename1,bsalary1);
			m.display();

	}

}
class Marketing_Executive extends Employee{
	 int ma=200;
	 int comm;
	 int ta;
	
	
	public Marketing_Executive(int empid, String ename, int bsalary) {
		super(empid, ename, bsalary);
		this.ma = 200;
		this.comm = calcComm();
		this.ta = calcTa();
	}
	int  calcTa()
	{
		ta= (int)(bsalary*0.05);
		return ta;
	}
	int calcComm()
	{
		comm= (int)(bsalary*0.02);
		return comm;
	}
	int clacTotal_salary()
	{
		total_salary=bsalary+ta+comm+ma;
		return total_salary;
	}
	
	public void display()
	{
		super.display();
		System.out.println("Employee ta is :"+ta);
		System.out.println();
		System.out.println("Employee comm is "+comm);
		System.out.println();
		System.out.println("employee medical  allowance is "+ma);
		System.out.println();
		System.out.println("Total_salary is is: "+clacTotal_salary());
		System.out.println();
	}
}
class Manager extends Employee{
	 int insentive;
	 
	public Manager(int empid, String ename, int bsalary) {
		super(empid, ename, bsalary);
		this.insentive=calcInsentive();
	}
	int calcInsentive()
	{
		insentive=(int)(bsalary*0.1);
		
		return insentive;
	}
	int clacTotal_salary()
	{
		total_salary=bsalary+insentive;
		return total_salary;
	}
	public void display()
	{
		
		super.display();
		System.out.println("incentive is: "+insentive);
		System.out.println();
		System.out.println("Total_salary is: "+clacTotal_salary());
		System.out.println();
	}
	
}
