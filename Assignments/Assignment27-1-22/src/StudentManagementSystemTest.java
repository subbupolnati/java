import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagementSystemTest {
	StudentManagementSystem sms;
	StudentManagementSystem sms1;
	@BeforeEach
	void setUp() throws Exception {
		sms=new StudentManagementSystem(100,"subbu","hyd",700,"Mca");
		sms1=new StudentManagementSystem(101,"veera","ap",650,"Btech");
	}

	@Test
	void test1() {
		assertTrue(sms.address=="hyd");
	}
	@Test
	void test2() {
		assertTrue(sms1.branch=="Btech");
	}
	@Test
	void test3() {
		assertNotSame(sms,sms1);
	}
	@Test
	void test4() {
		assertTrue(sms.marks>=700);
	}
	@Test
	void test5() {
		assertFalse(sms.sid>sms1.sid);
	}
	@Test
	void test6() {
		assertEquals(sms.getMarks(),700);
	}
	@Test
	void test7() {
		assertEquals(sms1.getSid(),101);
	}
	@Test
	void test8() {
		assertEquals(sms1.getBranch(),"Btech");
	}
	@Test
	void test9() {
		assertEquals(sms.percentage(700),70.0);
	}
	@Test
	void test10() {
		assertEquals(sms1.getSname(),"veera");
	}
}
