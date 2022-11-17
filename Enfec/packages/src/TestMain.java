import java.util.Scanner;

import com.employee.Employee;
import com.employee.manager.Manager;
import com.employee.marketing.MarketingExecutive;

public class TestMain {

	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter employee id: ");
			int eid=sc.nextInt();
			System.out.println("enter employee name: ");
			String ename=sc.next();
			System.out.println("enter employee Salary: ");
			int bsal=sc.nextInt();
			Employee e=new MarketingExecutive(eid,ename,bsal);
			e.showDetails();
			System.out.println("gross salary is: "+e.calcSalary());
			System.out.println("________________");
			System.out.println("enter manager id: ");
			int id=sc.nextInt();
			System.out.println("enter manager name: ");
			String name=sc.next();
			System.out.println("enter manager Salary: ");
			int sal=sc.nextInt();
			Employee m= new Manager(id,name,sal);
			m.showDetails();
			System.out.println("gross salary is: "+m.calcSalary());

		}

	}

