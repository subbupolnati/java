import java.util.Scanner;

public class ReveserOfNum {
	public static void Reverse(int num)
    {
        if (num < 10) {
            System.out.println(num);
        }
        else {
            System.out.print(num % 10);
            Reverse(num / 10);
        }
    }
    public static void main(String args[])
    {
    	Scanner sc=new Scanner(System.in);
		System.out.println("enter  value");
		int num=sc.nextInt();
        System.out.print("Reversed Number: ");
        Reverse(num);
    }
}
