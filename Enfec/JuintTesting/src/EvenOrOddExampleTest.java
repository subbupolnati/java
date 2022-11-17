import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class EvenOrOddExampleTest {

	@Test
	void test() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number");
		int num=sc.nextInt();
		assertTrue(num%2==0);
		if(true)
			System.out.println("even number");
		
	}

}
