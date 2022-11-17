import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculaterTest {

	@Test
	void testAdd() {
		//fail("Not yet implemented");
		assertEquals(Calculater.add(10, 20),30);
	}
	@Test
	void testSub() {
		//fail("Not yet implemented");
		assertEquals(Calculater.sub(20, 10),10);
	}
	@Test
	void testMul() {
		//fail("Not yet implemented");
		assertEquals(Calculater.mul(10,5),0);
	}
	@Test
	void testDiv() {
		//fail("Not yet implemented");
		assertEquals(Calculater.div(10,2),5);
	}

}
