package com.databaseconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.customer.Address;
import com.customer.Customer;
import com.product.Cart;
import com.product.Orders;
import com.product.Product;
//database connection is establish method in products
public class ProductConn {
	public static String url="jdbc:oracle:thin:@localhost:1521:admin";
	public static String dbname="c##scott2";
	public static String dbpass="tiger";
	
	public static Connection dbconnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,dbname,dbpass);
		return con;
	}
	//Add product method and query this method using to Add_products Servlet. 
	public int product_RegisterConn(Product product) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="insert into products values(?,?,?,?,?,?)";//insert product details in database using prepare statement
		//System.out.println(sql);
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1,product.getProduct_id());
		stmt.setString(2,product.getProduct_name());
		stmt.setString(3,product.getProduct_category());
		stmt.setString(4,product.getActive());
		stmt.setFloat(5,product.getProduct_price());
		stmt.setString(6,product.getImage());
		 int n=stmt.executeUpdate();
		 return n;
	}
	//products updates in database based on product id using getter and setter methods this method using update_product servlet
	public int product_UpdateConn(Product product) throws ClassNotFoundException, SQLException {
			Connection con=dbconnection();//establish connection
			String sql="update products set product_name=?,category=?,active=?,price=?,image=? where product_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,product.getProduct_name());
			stmt.setString(2,product.getProduct_category());
			stmt.setString(3,product.getActive());
			stmt.setFloat(4,product.getProduct_price());
			stmt.setString(5,product.getImage());
			stmt.setInt(6,product.getProduct_id());
			int n=stmt.executeUpdate();
		 return n;
	}
	//in this method body retrive all products using getter and setter methods using products.html in customer module and admin protal 
	public List<Product>all_Product_Details() throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		List<Product> p=new ArrayList<Product>();
		String sql="select * from products";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			Product product=new Product();
			product.setProduct_id(rs.getInt("product_id"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_category(rs.getString("category"));
			product.setActive(rs.getString("active"));
			product.setProduct_price(rs.getFloat("price"));
			//product.setImage(rs.getString("image"));
			byte img[]=rs.getBytes("image");
			String image=Base64.getEncoder().encodeToString(img);
			product.setImage(image);
			p.add(product);
		}
		return p;
	}
	//in this method using to perform searching for sepecific product search unsing nav bar and method calling to search.jsp page 
	public List<Product> search_product(Product product) throws ClassNotFoundException, SQLException{
		List<Product> products=new ArrayList();
		Connection con=dbconnection();
		String sql="select * from products where product_name like '%"+product.getProduct_name()+"%' or category like '%"+product.getProduct_category()+"%'and active='yes'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			product.setProduct_id(rs.getInt("product_id"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_category(rs.getString("category"));
			product.setActive(rs.getString("active"));
			product.setProduct_price(rs.getFloat("price"));
			byte img[]=rs.getBytes("image");
			String image=Base64.getEncoder().encodeToString(img);
			product.setImage(image);
			products.add(product);
		}
		return products; 
	}
	//in this method selected product aleardy exist or not using to this method before item add to cart this method will be execute using add_to_cart servlet
	public int check_product(Product product) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		int n=0;
		PreparedStatement st=con.prepareStatement("select * from cart where product_id=?");
		st.setInt(1,product.getProduct_id());
		n=st.executeUpdate();
		return n;
	}
	// in this method implements the cart item adding and store cart item in database using getter and setter methods and this method calling to add_to_cart servlet
	public int cart_Item(Product product,Customer cust) throws SQLException, ClassNotFoundException {
		Connection con=ProductConn.dbconnection();
		int n=0;
		String sql="select * from products where product_id=? and active='yes'";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,product.getProduct_id());
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			String sql1="insert into cart values(?,?,?,?,?,?)";
			st=con.prepareStatement(sql1);
			st.setInt(1,rs.getInt("product_id"));
			st.setString(6,rs.getString("product_name"));
			st.setInt(2,1);
			st.setString(3, rs.getString("category"));
			st.setFloat(4,rs.getFloat("price"));
			st.setString(5,cust.getEmail());
			n=st.executeUpdate();
		}
		return n;
	}
	//in this method using display the all cart details in particular user in cart page using getter and setter methods and calling to this method in cart.jsp page 
	public List<Cart> getCart(Customer cust) throws ClassNotFoundException, SQLException{
		Connection con=dbconnection();
		List<Cart> c=new ArrayList();
		String sql="select * from cart where email=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,cust.getEmail());
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			Cart cart=new Cart();
			cart.setProduct_id(rs.getInt("product_id"));
			cart.setProduct_name(rs.getString("product_name"));
			cart.setProduct_category(rs.getString("category"));
			cart.setQuantity(rs.getInt("qunatity"));
			cart.setProduct_price(rs.getFloat("price"));
			c.add(cart);
		}
		return c;
	}
	//in this method remove the from the based on id and customer selection and this method calling to cart.jsp remove remove button
	public int removeCart(Product product) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="delete from cart where product_id=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,product.getProduct_id());
		 int n=st.executeUpdate();
		return n;
	}
	//in this method perfrom qunatity and price opertion in increment and decrement the qunantity using in cart.jsp
	public void qunatity_Search(Product product) throws ClassNotFoundException, SQLException{
		Connection con=dbconnection();
		PreparedStatement st=con.prepareStatement("select qunatity from cart where product_id=?");
		st.setInt(1,product.getProduct_id());
		ResultSet rs=st.executeQuery();
		int qunatity=0;
		while(rs.next()) {
			qunatity=rs.getInt("qunatity");
		}
		st=con.prepareStatement("select price from products where product_id=?");
		st.setInt(1,product.getProduct_id());
		rs=st.executeQuery();
		while(rs.next()) {
			Float price=(rs.getFloat("price")*qunatity);
			product.setProduct_price(price);
			String sql="update cart set price=? where product_id=?";
			st=con.prepareStatement(sql);
			st.setFloat(1,product.getProduct_price());
			st.setInt(2,product.getProduct_id());
			st.executeUpdate();
		}
		
	}
	//in this method update quanity and price using this method increse  the qunatity of item in cart.jsp page
	public void incrementQun(Product product) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="update cart set qunatity=qunatity+1 where product_id=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,product.getProduct_id());
		st.executeQuery();
		qunatity_Search(product);
		
	}
	//in this method update quantity and price using this method decrement the qulity 
		public void decrementQun(Product product) throws ClassNotFoundException, SQLException {
			Connection con=dbconnection();
			String sql="update cart set qunatity=qunatity-1 where product_id=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,product.getProduct_id());
			st.executeQuery();
			qunatity_Search(product);
		}
		//in this method perform all the cart list price total returns in cart.jsp
	public float getTotalCartPrice(List<Cart> cartProduct) throws ClassNotFoundException, SQLException {
	        Float sum = 0.0f;
	        Connection con=dbconnection();
	        if (cartProduct.size() > 0) {
	           for (Cart item : cartProduct) {
	        	   sum=sum+item.getProduct_price();
	                }
	            }
	        return sum;
	    }
	public void address_Register(Address address) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="select * from where product_id=? and email=?";
		PreparedStatement st=con.prepareStatement(sql);
	}
	//in this method is using to cart selected each item buy after its store the orders table
	public int order_Items(Cart cart) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		int n=0;
		String sql="select * from cart where product_id=? and email=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,cart.getProduct_id());
		st.setString(2,cart.getEmail());
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			sql="insert into orders(product_id,product_name,email,total_amount,qunatity) values(?,?,?,?,?)";
			st=con.prepareStatement(sql);
			st.setInt(1,rs.getInt("product_id"));
			st.setString(2,rs.getString("product_name"));
			st.setString(3,rs.getString("email"));
			st.setFloat(4,rs.getFloat("price"));
			st.setInt(5,rs.getInt("QUNATITY"));
			n=st.executeUpdate();
		}
		return n;	
	}
	// inthis method store the all the cared list item store into orders tabel based on the email.
	public int checkout_Items(Cart cart) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		int n=0;
		String sql="select * from cart where email=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,cart.getEmail());
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			sql="insert into orders(product_id,product_name,email,total_amount,qunatity) values(?,?,?,?,?)";
			st=con.prepareStatement(sql);
			st.setInt(1,rs.getInt("product_id"));
			st.setString(2,rs.getString("product_name"));
			st.setString(3,rs.getString("email"));
			st.setFloat(4,rs.getFloat("price"));
			st.setInt(5,rs.getInt("QUNATITY"));
			n=st.executeUpdate();
		}
		return n;	
	}
	//in this method once data insert ordertable delete related items in cart table
	public void getOrders(Customer cust) throws ClassNotFoundException, SQLException{
		Connection con=dbconnection();
		String sql="select product_id from orders where email=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,cust.getEmail());
		ResultSet rs=st.executeQuery();
		while(rs.next()){
			sql="delete from cart where product_id="+rs.getInt("product_id");
			st=con.prepareStatement(sql);
			st.executeUpdate();
		}
	}
	// in this method shows the all the orders in login customers view in the orders table in orders.jsp page
	public List<Orders> vieworders(Customer cust) throws ClassNotFoundException, SQLException{
		Connection con=dbconnection();
		List<Orders> ord=new ArrayList<Orders>();
		String sql="select * from orders where email=? order by order_id asc";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,cust.getEmail());
		ResultSet rs=st.executeQuery();
		while(rs.next()){
			Orders order=new Orders();
			order.setOrder_id(rs.getInt("order_id"));
			order.setProduct_name(rs.getString("product_name"));
			order.setQunatity(rs.getInt("qunatity"));
			order.setTotal_amount(rs.getFloat("total_amount"));
			ord.add(order);
		}
		return ord;
	}
}

