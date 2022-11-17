package presentation;
abstract class Bank{    
	abstract int getRateOfInterest();    
}    
class SBI extends Bank{    
	int getRateOfInterest(){
		return 7;
		}    
}    
class PNB extends Bank{    
	int getRateOfInterest(){
		return 8;
		}    
}    
   
public class Abstractexample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b=new SBI();  
		System.out.println("Rate of Interest is: "+b.getRateOfInterest()+" %");    
		Bank p=new PNB();  
		System.out.println("Rate of Interest is: "+p.getRateOfInterest()+" %");
	}

}
