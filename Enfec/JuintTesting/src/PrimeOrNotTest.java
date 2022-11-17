import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrimeOrNotTest {
	PrimeOrNot p;
	@BeforeEach
	void init() {
		p=new PrimeOrNot();
	}
	@AfterEach
	void destroy(){
		p=null;
	}
	@Test
	void test() {
		assertTrue("Result",p.prime(5));
		assertEquals(false,p.prime(8));
	}
	
}
