import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand=new Random();
		List<Integer> al=new ArrayList<Integer>();
		rand.ints(5, 5,100).forEach(a->al.add(a));
		List<Integer> sortedList=al.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
	}

}
