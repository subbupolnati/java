package presentation;
interface Printable3{  
	void print();  
}  
interface Showable{  
	void show();  
}  
class InterfaceEx2 implements Printable3,Showable{  
	public void print(){
	System.out.println("Hello");
	}  
public void show(){
	System.out.println("Welcome");
	}  
  
public static void main(String args[]){  
	InterfaceEx2 obj = new InterfaceEx2();  
	obj.print();  
	obj.show();  
 } 
}