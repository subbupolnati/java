import java.util.function.Predicate;

@FunctionalInterface
interface I1{
	void add(int x,int y);
}

public class TestLambdaExpression {

	public static void main(String[] args) {
		Predicate<Integer> p1=(a)->a<10;
		System.out.println(p1.test(6));

	}

}
