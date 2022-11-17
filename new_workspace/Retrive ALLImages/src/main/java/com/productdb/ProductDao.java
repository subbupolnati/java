package com.productdb;

import java.io.OutputStream;
import java.net.http.HttpResponse;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.model.Product;

public class ProductDao {
	
	public Connection getConnect() throws ClassNotFoundException, SQLException {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		return con;
	}
	public List<Product>view_All() throws ClassNotFoundException, SQLException{
		Connection con=getConnect();
		List<Product> p=new ArrayList<Product>();
		String sql="select * from image";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while (rs.next())
		{
		Product p1=new Product();
		p1.setPid(rs.getInt(1));
		byte img[]=rs.getBytes(2);
		String st=Base64.getEncoder().encodeToString(img);
		p1.setImage(st);
		p.add(p1);
	}
		return p;
	}
}