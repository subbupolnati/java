/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.75
 * Generated at: 2022-03-12 17:33:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.*;
import java.util.*;
import com.customer.*;
import java.sql.*;
import com.databaseconnection.*;

public final class Shipping_005faddress_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

String fullname,address,city,country,state;int pincode;long mobileno; 
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/includes/head.jsp", Long.valueOf(1646815743117L));
    _jspx_dependants.put("/includes/navbar.jsp", Long.valueOf(1647072324530L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.customer");
    _jspx_imports_packages.add("com.databaseconnection");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");

String email3=(String)request.getSession(false).getAttribute("uname");
Customer cust=new Customer();
cust.setEmail(email3);

      out.write("      \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("	<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\r\n");
      out.write("	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\" />\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css\">\r\n");
      out.write("	\r\n");
      out.write("</head>");
      out.write("\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    ");
String email=(String)session.getAttribute("uname"); 
      out.write("\r\n");
      out.write("<div class=\"container-fluid p-3 bg-primary text-white text-center\">\r\n");
      out.write("<form  method=\"post\">\r\n");
      out.write("  <input type=\"search\"  name=\"search\" placeholder=\"Search \"><button type=\"submit\"formaction=\"search.jsp\"><i class=\"bi bi-search\"></i>Search</button></\r\n");
      out.write("  </form>\r\n");
      out.write(" <a href=\"products.jsp\" class=\"text-white p-3\">Home</a>\r\n");
      out.write(" <a href=\"loginpage.jsp\"class=\"text-white p-3\">Login</a>\r\n");
      out.write(" <a href=\"\" style=\"color:white\">");
out.println(email);
      out.write("</a>\r\n");
      out.write("<a href=\"LogOutServlet\"class=\"text-white p-3\">logout</a>\r\n");
      out.write("<a href=\"cart.jsp\" class=\"text-white p-3 text-decoration:none\">Cart <span class=\"badge badge-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cartProduct.size()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span></a><i class=\"bi bi-cart-fill\"></i>\r\n");
      out.write("</div>\r\n");
      out.write('\r');
      out.write('\n');
String msg=request.getParameter("msg");
if("success".equals(msg)){

      out.write("\r\n");
      out.write("<h2 align=\"center\" style=\"color:red\">Product ordered Successfully please entered delivery Address </h2>\r\n");
} 
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<div class=\"container my-3\">\r\n");
      out.write("		<div class=\"d-flex py-3\">\r\n");
      out.write("		<div class=\"input-group input-group-sm mb-3\">\r\n");
      out.write("		");

			Connection con=ProductConn.dbconnection();
			String sql="select * from user_register where email=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,cust.getEmail());
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				fullname=rs.getString("fullname");
				address=rs.getString("address");
	  			city=rs.getString("city");
	  			country=rs.getString("country");
	  			state=rs.getString("state");
	  			pincode=rs.getInt("pincode");
	  			mobileno=rs.getLong("mobileno");
			}
			
      out.write("\r\n");
      out.write("		  			<input type=\"radio\" class=\"form-control\" name=\"add\"><h5>");
 out.println(fullname); 
      out.write("</h5>\r\n");
      out.write("		  		\r\n");
      out.write("				</div>\r\n");
      out.write("			\r\n");
      out.write("		</div>\r\n");
      out.write("		</div>\r\n");
      out.write("<a href=\"Add_Address.jsp\">add ");
out.println(email3); 
      out.write("</a>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
