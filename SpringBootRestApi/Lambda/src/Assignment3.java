import java.util.Scanner;

public class Assignment3 {
	
	public static boolean find(int[] unlucky) {
			  
			  if (unlucky.length == 2 && unlucky[0] == 1 && unlucky[1] == 3) {
			    return true;
			  }
			  
			  if (unlucky.length >= 3) {
			    for (int i = 0; i < 2; i++) {
			      if (unlucky[i] == 1 && unlucky[i+1] == 3) {
			        return true;
			      }
			      if (unlucky[unlucky.length - 2] == 1 && unlucky[unlucky.length - 1] == 3) {
			        return true;
			      }
			    }
			  }
			  return false;
			}
	public static void main(String[] args) {
		int i=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size");
		int size=sc.nextInt();
		int unlucky1[]=new int[size];
		for(i=0;i<size;i++) {
			System.out.println("Enter Array Elements");
			unlucky1[i]=sc.nextInt();
		}
		System.out.println("Given Array Unluccky: "+Assignment3.find(unlucky1));
	}
}
