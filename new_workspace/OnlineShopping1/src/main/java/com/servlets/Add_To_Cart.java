package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.Customer;
import com.databaseconnection.ProductConn;
import com.product.Cart;
import com.product.Product;

@WebServlet("/Add_To_Cart")
public class Add_To_Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Add_To_Cart() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//ArrayList<Cart> cartList=new ArrayList<>();
		ProductConn pcon=new ProductConn();
		int id = Integer.parseInt(request.getParameter("id"));
		String email=(String)request.getSession(false).getAttribute("uname");
		Customer cust=new Customer();
		Cart cart=new Cart();
		cust.setEmail(email);
        Product product=new Product();
        product.setProduct_id(id);
        try {
        	int row=pcon.check_product(product);
        	if(row>0) {
        		response.sendRedirect("cart.jsp?msg=exist");
        	}
        	else {
				int n=pcon.cart_Item(product,cust);
				if(n>0){
					response.sendRedirect("cart.jsp?msg=added");
				}
				else {
					response.sendRedirect("cart.jsp?msg=notexist");
				}
        	}
			/*while(row.next()) {
			cart.setProduct_id(row.getInt("product_id"));
			cart.setProduct_name(row.getString("product_name"));
			cart.setQuantity(row.getInt("QUNATITY"));
			cart.setProduct_category(row.getString("category"));
			cart.setProduct_price(row.getFloat("price")*row.getInt("qunatity"));
			cart.setEmail(row.getString("email"));
			}*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
