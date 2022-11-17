package com.databaseconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.customer.Customer;
import com.product.Cart;
import com.product.Product;

public class ProductConn {
	public static String url="jdbc:oracle:thin:@localhost:1521:admin";
	public static String dbname="c##scott";
	public static String dbpass="tiger";
	public static Connection dbconnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,dbname,dbpass);
		return con;
	}
	public int product_RegisterConn(Product product) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="insert into online_products values(?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement stmt=con.prepareCall(sql);
		stmt.setInt(1,product.getProduct_id());
		stmt.setString(2,product.getProduct_name());
		stmt.setInt(3,product.getProduct_category_id());
		stmt.setInt(4,product.getAvailble_qunatity());
		stmt.setDouble(5,product.getProduct_price());
		stmt.setString(6,product.getImage());
		 int n=stmt.executeUpdate();
		 System.out.println(n);
		 return n;
	}
	public int product_UpdateConn(Product product) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="update online_products set product_name=?,product_category_id=?,availabel_quantity=?,product_price=?,image=? where product_id=?";
		PreparedStatement stmt=con.prepareCall(sql);
		stmt.setString(1,product.getProduct_name());
		stmt.setInt(2,product.getProduct_category_id());
		stmt.setInt(3,product.getAvailble_qunatity());
		stmt.setDouble(4,product.getProduct_price());
		stmt.setString(5,product.getImage());
		stmt.setInt(6,product.getProduct_id());
		 int n=stmt.executeUpdate();
		 return n;
	}
	public List<Product>All_Product_Details() throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		List<Product> p=new ArrayList();
		String sql="select * from online_products";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			Product product=new Product();
			product.setProduct_id(rs.getInt("product_id"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_category_id(rs.getInt("PRODUCT_CATEGORY_ID"));
			product.setAvailble_qunatity(rs.getInt("AVAILABEL_QUANTITY"));
			product.setProduct_price(rs.getDouble("PRODUCT_PRICE"));
			product.setImage(rs.getString("image"));
			p.add(product);
		}
		return p;
	}
	public int deleteProduct(Product product) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="delete from online_products where product_id=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,product.getProduct_id());
		int n=st.executeUpdate();
		return n;
	}
	 public List<Cart> getCartProducts(ArrayList<Cart> cartList) throws ClassNotFoundException, SQLException {
	        List<Cart> ca = new ArrayList<Cart>();
	        Connection con=dbconnection();
	        try {
	            if (cartList.size() > 0) {
	                for (Cart item : cartList) {
	                    String sql = "select * from online_products where product_id=?";
	                    PreparedStatement pst=con.prepareStatement(sql);
	                    pst.setInt(1, item.getProduct_id());
	                   ResultSet rs = pst.executeQuery();
	                    while (rs.next()) {
	                       Cart cart = new Cart();
	           				cart.setProduct_id(rs.getInt("product_id"));
	           				cart.setProduct_name(rs.getString("product_name"));
	           				cart.setProduct_category_id(rs.getInt("PRODUCT_CATEGORY_ID"));
	           				cart.setProduct_price(rs.getDouble("PRODUCT_PRICE")*item.getQuantity());
	           				cart.setQuantity(item.getQuantity());
	           				ca.add(cart);
	                    }	
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
			return ca;
	       
	    }
		public double getTotalCartPrice(ArrayList<Cart> cartList) throws ClassNotFoundException, SQLException {
	        double sum = 0;
	        Connection con=dbconnection();
	        try {
	            if (cartList.size() > 0) {
	                for (Cart item : cartList) {
	                    String query = "select product_price from online_products where product_id=?";
	                   PreparedStatement pst = con.prepareStatement(query);
	                    pst.setInt(1, item.getProduct_id());
	                   ResultSet rs = pst.executeQuery();
	                    while (rs.next()) {
	                        sum+=rs.getDouble("PRODUCT_PRICE")*item.getQuantity();
	                    }

	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return sum;
	    }

}

