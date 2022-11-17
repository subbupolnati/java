
public class Product {
	int product_id;
	String product_name;
	int price;
	static int count=0;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Product(int product_id, String product_name, int price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
	}
	static int count() {
		count+=1;
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Product p=new Product(11,"system",20000);
		System.out.println("product_id is: "+p.getProduct_id());
		System.out.println("product_name is: "+p.getProduct_name());
		System.out.println("product_price is: "+p.getPrice());
		System.out.println("object  count is "+p.count());
		System.out.println("____________________________");
		Product p1=new Product(42,"keybaord",2000);
		System.out.println("product_id is: "+p1.getProduct_id());
		System.out.println("product_name is: "+p1.getProduct_name());
		System.out.println("product_price is: "+p1.getPrice());
		System.out.println("object  count is "+p1.count());
		System.out.println("____________________________");
		Product p2=new Product(13,"bike",60000);
		System.out.println("product_id is: "+p2.getProduct_id());
		System.out.println("product_name is: "+p2.getProduct_name());
		System.out.println("product_price is: "+p2.getPrice());
		System.out.println("object  count is "+p2.count());
		System.out.println("____________________________");
		Product p3=new Product(40,"car",600000);
		System.out.println("product_id is: "+p3.getProduct_id());
		System.out.println("product_name is: "+p3.getProduct_name());
		System.out.println("product_price is: "+p3.getPrice());
		System.out.println("object  count is "+p3.count());
		System.out.println("____________________________");
	}

}
