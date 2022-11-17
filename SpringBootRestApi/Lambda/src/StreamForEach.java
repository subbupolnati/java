import java.util.Arrays;
import java.util.List;

public class StreamForEach {
	
	public static void main(String[] args) {
		
		List<Integer> al=Arrays.asList(100,20,45,145,24);
		al.forEach(a->System.out.println(a));
	}
}
