/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.75
 * Generated at: 2022-03-30 15:15:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Add_005fAddress_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/includes/head.jsp", Long.valueOf(1647493714521L));
    _jspx_dependants.put("/includes/footer.jsp", Long.valueOf(1646544286766L));
    _jspx_dependants.put("/includes/navbar.jsp", Long.valueOf(1647509927874L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>address page</title>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("	<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\r\n");
      out.write("	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\" />\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css\">\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("	\r\n");
      out.write("</head>");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("body{\r\n");
      out.write("background-color:	#b3ecff;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<div class=\"container-fluid p-3 bg-primary text-white text-center\">\r\n");
      out.write("<form  method=\"post\">\r\n");
      out.write("  <input type=\"search\"  name=\"search\" placeholder=\"Search \"><button type=\"submit\"formaction=\"search.jsp\"><i class=\"bi bi-search\"></i>Search</button></\r\n");
      out.write("  </form>\r\n");
      out.write(" <a href=\"products.jsp\" class=\"text-white p-3\">Home</a>\r\n");
      out.write(" ");
String email=(String)session.getAttribute("uname");
 if(email==null){
 
      out.write("\r\n");
      out.write(" <a href=\"loginpage.jsp\"class=\"text-white p-3\">Login</a>\r\n");
      out.write(" ");
} else{ 
      out.write("\r\n");
      out.write(" <a href=\"\" style=\"color:white\">");
out.println(email);
      out.write("</a>\r\n");
      out.write("<a href=\"LogOutServlet\"class=\"text-white p-3\">logout</a>\r\n");
      out.write("<a href=\"cart.jsp\" class=\"text-white p-3 text-decoration:none\">Cart <span class=\"badge badge-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cartProduct.size()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span></a><i class=\"bi bi-cart-fill\"></i>\r\n");
      out.write("<a href=\"order.jsp\"class=\"text-white p-3\">Orders</a>\r\n");
} 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<nav>\r\n");
      out.write("<ul class=\"nav nav-pills\">\r\n");
      out.write("  <li class=\"nav-item\">\r\n");
      out.write("    <a class=\"nav-link active\"  href=\"products.jsp\"><i class=\"bi bi-house\"></i>Home</a>\r\n");
      out.write("  </li>\r\n");
      out.write("  <li class=\"nav-item\">\r\n");
      out.write("    <a class=\"nav-link\" href=\"grocery.jsp\">Grocery</a>\r\n");
      out.write("  </li>\r\n");
      out.write("  <li class=\"nav-item\">\r\n");
      out.write("    <a class=\"nav-link\" href=\"mobiles.jsp\">Mobiles</a>\r\n");
      out.write("  </li>\r\n");
      out.write("  <li class=\"nav-item dropdown\">\r\n");
      out.write("    <a class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Fashion</a>\r\n");
      out.write("    <div class=\"dropdown-menu\">\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"fashion.jsp\">All</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">Men's Top Wear</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">Men's Bottom Wear</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">Women Ethnic</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">>Women Western</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">men's Footwear</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">Womens Footwear</a>\r\n");
      out.write("      </div>\r\n");
      out.write("  </li>\r\n");
      out.write("  <li class=\"nav-item dropdown\">\r\n");
      out.write("    <a class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Eletronics</a>\r\n");
      out.write("    <div class=\"dropdown-menu\">\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"electonics.jsp\">All</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">Ear phones</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">Speakers</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">Laptop Accessories</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">Computer Peripherals</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">MobileAccessory</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">Powerbank</a>\r\n");
      out.write("      </div>\r\n");
      out.write("  </li>\r\n");
      out.write("  <li class=\"nav-item\">\r\n");
      out.write("    <a class=\"nav-link\" href=\"furinture.jsp\">Furniture</a>\r\n");
      out.write("  </li>\r\n");
      out.write("  <li class=\"nav-item\">\r\n");
      out.write("    <a class=\"nav-link\" href=\"applince.jsp\">Home Appliances</a>\r\n");
      out.write("  </li>\r\n");
      out.write(" </ul>\r\n");
      out.write(" </nav>\r\n");
      out.write(" ");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>");
      out.write('\r');
      out.write('\n');
String msg=request.getParameter("msg");
if("success".equals(msg)){

      out.write("\r\n");
      out.write("<h2 align=\"center\" style=\"color:red\">Product ordered Successfully please entered delivery Address </h2>\r\n");
} 
      out.write('\r');
      out.write('\n');

if("invalid".equals(msg)){

      out.write("\r\n");
      out.write("<h2 align=\"center\" style=\"color:red\"> entered Wrong details please re enter  </h2>\r\n");
} 
      out.write("\r\n");
      out.write("	<div class=\"container col-6 my-3\">\r\n");
      out.write("		<div class=\"d-flex py-3\"><h3>ADD New Address</h3></div>\r\n");
      out.write("			<form  method=\"post\">\r\n");
      out.write("				<div class=\"input-group input-group-sm mb-3\">\r\n");
      out.write("		  			<input type=\"hidden\" class=\"form-control\" name=\"email\"value=\"");
out.println(email);
      out.write("\">\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"input-group input-group-sm mb-3\">\r\n");
      out.write("		  			<input type=\"text\" class=\"form-control\" name=\"name\" placeholder=\"CustomerName\">\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"input-group input-group-sm mb-3\">\r\n");
      out.write("		  			<td><input type=\"tel\" pattern=\"[0-9]{10}\"class=\"form-control\" name=\"mobile\" placeholder=\"mobile\">\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"input-group mb-3\">\r\n");
      out.write("				  <input type=\"text\" name=\"address\"class=\"form-control\" placeholder=\"Street Address\">\r\n");
      out.write("				  <input type=\"text\"  class=\"form-control\"  name=\"city\" placeholder=\"City\">\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"input-group mb-3\">\r\n");
      out.write("					<label class=\"input-group-text\" for=\"inputGroupSelect01\">Country</label>\r\n");
      out.write("		  				<select class=\"form-select\" id=\"inputGroupSelect01\" name=\"country\">\r\n");
      out.write("			   				<option selected>Choose...</option>\r\n");
      out.write("							<option value=\"india\">INDIA</option>\r\n");
      out.write("							<option value=\"usa\">USA</option>\r\n");
      out.write("							<option value=\"uae\">UAE</option>\r\n");
      out.write("	 					</select>\r\n");
      out.write("	 				 <label class=\"input-group-text\" for=\"inputGroupSelect01\">State</label>\r\n");
      out.write("	  					<select class=\"form-select\" id=\"inputGroupSelect01\" name=\"state\">\r\n");
      out.write("			   				<option selected>Choose...</option>\r\n");
      out.write("							<option value=\"Andhra pradesh\">Andhra Pradesh</option>\r\n");
      out.write("							<option value=\"Telagana\">Telagana</option>\r\n");
      out.write("							<option value=\"Maharastra\">maharastra</option>\r\n");
      out.write("	 					</select>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"input-group input-group-sm mb-3\">\r\n");
      out.write("		  			<td><input type=\"text\" name=\"pincode\" placeholder=\"Pincode\"class=\"form-control\">\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"input-group input-group-sm mb-3\">\r\n");
      out.write("		  			<td><input type=\"submit\" formaction=\"AddressServlet\" value=\"submit\"class=\"btn btn-sm btn-success\">\r\n");
      out.write("				</div>\r\n");
      out.write("			</form>\r\n");
      out.write("		</div>\r\n");
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
