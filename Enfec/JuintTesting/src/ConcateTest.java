import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConcateTest {
	@Test
	void test() {
		//fail("Not yet implemented");
		String result="helloworld";
		assertEquals(Concate.concat("hello","world"),result);
	}
}
