
public class PrimeOrNot {
	public boolean prime(int num) {
		boolean flag=true;
		for(int i=2;i<=num/2;i++) {
			if(num%i==0) {
				flag=false;
				break;
			}
		}
	  return flag;
	 }
}
