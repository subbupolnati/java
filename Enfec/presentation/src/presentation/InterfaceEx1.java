package presentation;
interface printable{  
public abstract void print();  
}  

public class InterfaceEx1  implements printable {
	public void print(){
		System.out.println("Hello");
		}    
	public static void main(String args[]){  
		InterfaceEx1  obj = new InterfaceEx1 ();  
		obj.print(); 
	}
}

