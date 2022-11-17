import java.util.*;
public class Numbers {
	private int n;
	public Numbers(int n) {
		super();
		this.n=n;	
		}
	static boolean isZero(int n){
		if(n>0) {
			return false;
		}
		else
			return true;
	}
	static boolean isPositive(int n){
		if(n>=-1) {
			return true;
		}
		else
			return false;
	}
	static boolean isNegitive(int n){
		if(n<=-1) {
			return true;
		}
		else
			return false;
	}
	static boolean isOdd(int n){
		if(n%2==1) {
			return true;
		}
		else
			return false;
	}
	static boolean isEven(int n){
		if(n%2==0) {
			return true;
		}
		else
			return false;
	}
	static boolean isPrime(int n){
		if (n <= 1)
            return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
  
        return true;
		}
	static boolean isArmstrong(int n){
		int temp=n;
		int sum=0,rem;
		while(n>0)
		{
			rem=n%10;
			n=n/10;
			sum=sum+(rem*rem*rem);
		}
		if(temp==sum) {
			return true;
		}
		else
			return false;
	}
	static long getFact(int n){
		long fact=1;
		while(n>=1){
			fact=fact*n;
			n=n-1;
		}
		return fact;
	}
	static int getSqr(int n){
		int sqr=n*n;
		return sqr;
	}
	static int getSum(int n) {
		int rem, sum = 0;
		while(n!=0) {
			rem=n%10;
			sum=sum+rem;
			n=n/10;
		}
		return sum;
	}
	static int getRev(int n) {
		int rem, rev = 0;
		while(n!=0) {
			rem=n%10;
			rev=rev*10+rem;
			n=n/10;
		}
		
		return rev;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number");
		int n=sc.nextInt();
		
		Numbers ne=new Numbers(n);
		System.out.println(ne.isZero(n));
		System.out.println(ne.isPositive(n));
		System.out.println(ne.isNegitive(n));
		System.out.println(ne.isOdd(n));
		System.out.println(ne.isEven(n));
		System.out.println(ne.isPrime(n));
		System.out.println(ne.isArmstrong(n));
		System.out.println("Factorial of num : "+ne.getFact(n));
		System.out.println("Square of num : "+ne.getSqr(n));
		System.out.println("Sum of num : "+ne.getSum(n));
		System.out.println("Reverse of num : "+ne.getRev(n));
		/*boolean a=isZero(n);
		System.out.println(a);
		boolean b=isPositive(n);
		System.out.println(b);
		boolean c=isNegitive(n);
		System.out.println(c);
		boolean d=isOdd(n);
		System.out.println(d);
		boolean e=isEven(n);
		System.out.println(e);
		boolean p=isPrime(n);
		System.out.println(p);
		boolean ar=isArmstrong(n);
		System.out.println(ar);
		long f=getFact(n);
		System.out.println("Factorial of num : "+f);
		int s=getSqr(n);
		System.out.println("Square of num : "+s);
		int sum=getSum(n);
		System.out.println("Sum of num : "+sum);
		int rev=getRev(n);
		System.out.println("Reverse of num : "+rev);*/
	}

}
