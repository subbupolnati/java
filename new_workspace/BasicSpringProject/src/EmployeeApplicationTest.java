

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.emp.Employee;

public class EmployeeApplicationTest {

	public static void main(String[] args) {
		Resource r=new ClassPathResource("Beans.xml");
		BeanFactory bf=new XmlBeanFactory(r);
		Employee e=(Employee) bf.getBean("e");
		System.out.println("Employee Id="+e.getEid());
		System.out.println("Employee Name="+e.getEname());
		System.out.println("Salary="+e.getSalary());

	}

}
