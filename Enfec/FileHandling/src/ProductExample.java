
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product implements Serializable{
	int pid;
	String pname;
	double price;
	int quantity;
	public Product(int pid, String pname, double price, int quantity) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}
public class ProductExample {
	private static int pid;
	private static String pname;
	private static double price;
	private static int quantity;
	public static void getDetatils() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter product id");
		pid=sc.nextInt();
		System.out.println("enter product name");
		pname=sc.next();
		System.out.println("enter product price");
		price=sc.nextDouble();
		System.out.println("enter product quantity");
		quantity=sc.nextInt();
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//List a=new ArrayList();
		File f=new File("G://java1/product.txt");
		f.createNewFile();
		FileOutputStream fout=new FileOutputStream("G://java1/product.txt");
		ObjectOutputStream out=new ObjectOutputStream(fout);
		int j=0,n=2;
		while(j<n){
			getDetatils();
			Product p1=new Product(pid,pname,price,quantity);
			out.writeObject(p1);
			j++;
		}
		
		out.flush();
		out.close();
		System.out.println("state of objects written successfully");
		FileInputStream fin=new FileInputStream("G://java1/product.txt");
		ObjectInputStream oin=new ObjectInputStream(fin);
		for(int i=0;i<n;i++) {
			Product ar =(Product)oin.readObject();
			System.out.println("product id  "+ar.getPid());
			System.out.println("product name  "+ar.getPname());
			System.out.println("product price  "+ar.getPrice());
			System.out.println("product quantity  "+ar.getQuantity());
		}
		}
	}
