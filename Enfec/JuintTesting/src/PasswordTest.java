import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordTest {

	@Test
	void test() {
		String pass="subbu8";
		int length=8;
		assertTrue(pass.length()>=length);
	}

}
