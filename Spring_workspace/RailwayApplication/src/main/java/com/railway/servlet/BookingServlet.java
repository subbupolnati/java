package com.railway.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.railway.Train;
import com.railway.dao.BookingDAO;
@WebServlet("/BookingServlet")

public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Beans.xml");
		BookingDAO bdao=(BookingDAO)ctx.getBean("bdao");
		Train t=new Train();
		t.setPname(request.getParameter("pname"));
		t.setAddress(request.getParameter("address"));
		t.setTrainno(Integer.parseInt(request.getParameter("trainno")));
		t.setTrainname(request.getParameter("trainname"));
		t.setTicketno(request.getParameter("ticketno"));
		t.setFrom(request.getParameter("from"));
		t.setTo(request.getParameter("to"));
		t.setCoach(request.getParameter("coach"));
		t.setPrice(Integer.parseInt(request.getParameter("price")));
		bdao.booking(t);
		
	}

}
