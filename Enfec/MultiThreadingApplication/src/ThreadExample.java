class Addition extends Thread{
	public void run() {
		int a=10;
		int b=5;
		System.out.println("Add 2 numbers is :"+(a+b));
	}
}
class Subtraction extends Thread{
	public void run() {
		int a=10;
		int b=5;
		System.out.println("subtract 2 numbers is :"+(a-b));
	}
}
public class ThreadExample {
	public static void main(String[] args) {
		Addition a=new Addition(); 
		a.start();
		Subtraction s=new Subtraction();
		s.start();


	}

}
