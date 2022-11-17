import java.util.Scanner;

public class MiddleOfArray {
	public static int[] findArray(int[] num) {
		int[] midThree=new int[3];
		int n=num.length/2;
		for(int i=0;i<midThree.length;i++){
			midThree[i]=num[n-1+i];
		}
		return midThree;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter array size");
		int n=sc.nextInt();
		int[] num=new int[n];
		for(int i=0;i<n;i++) {
			System.out.println("enter value");
			num[i]=sc.nextInt();
		}
		int result[]=findArray(num);
		System.out.println("midThree ");
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
		
	}

}
