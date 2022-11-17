package presentation;
interface Printable2{  
	void print();  
}  
interface Showable1 extends Printable2{  
	void show();  
}  
class  TestInterface implements Showable1{  
	public void print(){
		System.out.println("Hello");
	}  
	public void show(){
		System.out.println("Welcome");
	}  
  
	public static void main(String args[]){  
		TestInterface obj = new TestInterface();  
		obj.print();  
		obj.show();  
	}  
}  

