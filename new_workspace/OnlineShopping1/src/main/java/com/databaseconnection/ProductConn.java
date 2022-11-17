package com.databaseconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	//Add product method and query
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
		 //System.out.println(n);
		 return n;
	}
	//products updates in database based on product id using getter and setter methods
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
	//all products retrive all products using getter and setter methods
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
			product.setImage(rs.getString("image"));
			p.add(product);
		}
		return p;
	}
	public int check_product(Product product) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		int n=0;
		PreparedStatement st=con.prepareStatement("select * from cart where product_id=?");
		st.setInt(1,product.getProduct_id());
		n=st.executeUpdate();
		return n;
	}
	// in this method implements the cart item adding and stroe cart item in database using getter and setter methods
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
	//in this method using display the all cart setails in particular user in cart page using getter and setter methods
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
	//in this method remove the from the based on id and customer selection
	public int removeCart(Product product) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="delete from cart where product_id=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,product.getProduct_id());
		 int n=st.executeUpdate();
		return n;
	}
	//in this method update quanity and price using this method
	public void incrementQun(Product product) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="update cart set qunatity=qunatity+1 where product_id=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,product.getProduct_id());
		st.executeQuery();
		st=con.prepareStatement("select qunatity from cart where product_id=?");
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
			sql="update cart set price=? where product_id=?";
			st=con.prepareStatement(sql);
			st.setFloat(1,product.getProduct_price());
			st.setInt(2,product.getProduct_id());
			st.executeUpdate();
		}
	}
	//in this method update quantity and price using this method
		public void decrementQun(Product product) throws ClassNotFoundException, SQLException {
			Connection con=dbconnection();
			String sql="update cart set qunatity=qunatity-1 where product_id=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,product.getProduct_id());
			st.executeQuery();
			st=con.prepareStatement("select qunatity from cart where product_id=?");
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
				sql="update cart set price=? where product_id=?";
				st=con.prepareStatement(sql);
				st.setFloat(1,product.getProduct_price());
				st.setInt(2,product.getProduct_id());
				st.executeUpdate();
			}
		}
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
	public ResultSet getOrders(Customer cust) throws ClassNotFoundException, SQLException{
		Connection con=dbconnection();
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select product_id from orders where email"+cust.getEmail());
		while(rs.next()){
			Product product=new Product();
			product.setProduct_id(rs.getInt("product_id"));
			String sql="delete from cart where product_id=?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,product.getProduct_id());
			st.execute();
			st=con.prepareStatement("select * from orders where product_id=? and email="+cust.getEmail());
			st.setInt(1,product.getProduct_id());
			rs=st.executeQuery();
		}
		return rs;
	}
}

