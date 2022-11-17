
import java.util.*;
class Product{
	int id;
	String name;
	double price;
	int avl_qunity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvl_qunity() {
		return avl_qunity;
	}
	public void setAvl_qunity(int avl_qunity) {
		this.avl_qunity = avl_qunity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", avl_qunity=" + avl_qunity + "]";
	}
	public Product(int id, String name, double price, int avl_qunity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.avl_qunity = avl_qunity;
	}
}

class ProductComparatorByavlquanity implements Comparator{

	@Override
	public int compare(Object ob1, Object ob2) {
		
		Product p1=(Product)ob1;
		Product p2=(Product)ob2;
		if(p1.avl_qunity<p2.avl_qunity)
			return -1;
		else if(p1.avl_qunity>p2.avl_qunity)
			return 1;
		else
			return 0;
	}
	
}
class ProductComparatorByname implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Product p1=(Product)o1;
		Product p2=(Product)o2;
		return p1.name.compareTo(p2.name);
	}
	
}
class ProductComparatorByprice implements Comparator{

	@Override
	public int compare(Object ob1, Object ob2) {
		
		Product p1=(Product)ob1;
		Product p2=(Product)ob2;
		if(p1.price<p2.price)
			return -1;
		else if(p1.price>p2.price)
			return 1;
		else
			return 0;
	}
	
}
public class ProductExample {
	public static int id;
	public static String name;
	public static double price;
	public static int avl_qunity;
	public static double total_amount;
	public static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		id=sc.nextInt();
		System.out.println("enter product name");
		name=sc.next();
		System.out.println("enter product price");
		price=sc.nextDouble();
		System.out.println("enter ava_qunity");
		avl_qunity=sc.nextInt();
	}
	public static double total_Amount()
	{
		total_amount=price*avl_qunity;
		return total_amount;
	}
	public static void billPrint() {
		System.out.println("product name :"+name);
		System.out.println("price of each one :"+price);
		System.out.println("qunity :"+avl_qunity);
		System.out.println("Total Amount :"+total_Amount());
	
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList a =new ArrayList();
		System.out.println("how many productes are entered");
		int n=sc.nextInt();
		int i=1;
		while(i<=n) {
			getDetails();
			a.add(new Product(id,name,price,avl_qunity));
			i++;
		}
		Collections.sort(a,new ProductComparatorByprice());
		System.out.println("after sorting "+a);
		System.out.println("enter product  name for search");
		String nm=sc.next();
		System.out.println("select product  quanity ");
		int qu=sc.nextInt();
		System.out.println("bill payment");
		System.out.println("product name :"+nm);
		System.out.println("price of each one :"+price);
		System.out.println("qunantity :"+qu);
		System.out.println("total amount :"+qu*price);
		
	}
}

