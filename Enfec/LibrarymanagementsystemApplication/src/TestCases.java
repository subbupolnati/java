import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TestCases{

	BookDeatails book=Mockito.mock(BookDeatails.class);
	Librerain l=Mockito.mock(Librerain.class);
	Person p=Mockito.mock(Person.class);
	@BeforeAll
	void setUp() throws Exception {
		Author a=new Author(101,"james");
		book=new BookDeatails(10,"java",a);
	}
	@Test
	void test1() {
		assertNotNull(book.getBook_name(),"java");
		System.out.println("Test case1 passed ");
	}
	void test2() {
		ArrayList<Author> b=Mockito.spy(ArrayList.class);
		b.add(new Author(101,"james"));
		assertEquals(1,b.size());
	}
}
