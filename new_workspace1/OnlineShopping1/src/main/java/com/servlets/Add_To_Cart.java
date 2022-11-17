package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.Cart;

@WebServlet("/Add_To_Cart")
public class Add_To_Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Add_To_Cart() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ArrayList<Cart> cartList=new ArrayList<>();
		int id = Integer.parseInt(request.getParameter("id"));
        Cart cm = new Cart();
        cm.setProduct_id(id);
        cm.setQuantity(1);
        HttpSession session = request.getSession();
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");
        if (cart_list == null) {
            cartList.add(cm);
            session.setAttribute("cart_list", cartList);
            //out.println("add to cart");
            response.sendRedirect("products.jsp");
        } else {
        	//out.println("add to cart");
            cartList = cart_list;

            boolean exist = false;
            for (Cart c : cart_list) {
                if (c.getProduct_id()== id) {
                    exist = true;
                    out.println("Item Already in Cart.");
                    response.sendRedirect("cart.jsp");
                }
            }
            if (!exist) {
                cartList.add(cm);
                response.sendRedirect("products.jsp");
            }
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
