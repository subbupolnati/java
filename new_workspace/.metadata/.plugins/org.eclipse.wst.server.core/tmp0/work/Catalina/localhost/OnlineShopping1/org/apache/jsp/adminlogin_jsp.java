/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.75
 * Generated at: 2022-03-08 09:04:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminlogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<title>Admin Login Page</title>\r\n");
      out.write("<style>\r\n");
      out.write("body{\r\n");
      out.write("	background-image:url(\"login1.jpg\");\r\n");
      out.write("	background-repeat: no-repeat;\r\n");
      out.write("  background-attachment: fixed; \r\n");
      out.write("  background-size: 100% 100%;\r\n");
      out.write("	color:white;\r\n");
      out.write("}\r\n");
      out.write(".login {\r\n");
      out.write("  border-radius: 5px;\r\n");
      out.write("  //background-color: #f2f2f2;\r\n");
      out.write("  padding:50px;\r\n");
      out.write("  border:1px solid black;\r\n");
      out.write("  width:25%;\r\n");
      out.write("  height:250px;\r\n");
      out.write("  margin-top:50px;\r\n");
      out.write("  margin-left:33.33%;\r\n");
      out.write("}\r\n");
      out.write("h1{\r\n");
      out.write("text-align:center\r\n");
      out.write("}\r\n");
      out.write("h3 a{\r\n");
      out.write("color:red;\r\n");
      out.write("text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("table tr td{\r\n");
      out.write("font-size:25px;\r\n");
      out.write("padding:15px;\r\n");
      out.write("}\r\n");
      out.write("input[type=submit] {\r\n");
      out.write("  width: 25%;\r\n");
      out.write("  background-color:blue;\r\n");
      out.write("  color: white;\r\n");
      out.write("  padding: 14px 20px;\r\n");
      out.write("  margin: 18px 0 0 75px;\r\n");
      out.write("  border: none;\r\n");
      out.write("  border-radius: 4px;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
 
String msg=request.getParameter("msg");
if("invalid".equals(msg)){

      out.write("\r\n");
      out.write("<h1 align=\"center\" style=color:red>Invalid login Details</h1>\r\n");
} 
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("<h1>Admin login page</h1>\r\n");
      out.write("</header>\r\n");
      out.write("<div class=\"login\">\r\n");
      out.write("\r\n");
      out.write("<form action=\"AdminValidateServlet\" method=\"post\">\r\n");
      out.write("<table>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Email</td>\r\n");
      out.write("<td><input type=\"email\" name=\"t1\" placeholder=\"admin email\" required></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Password</td>\r\n");
      out.write("<td><input type=\"password\" name=\"t2\" placeholder=\"admin password\" required></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<input type=\"submit\" value=\"submit\" >\r\n");
      out.write("<a href=\"#\" style=\"color:white\">forget password</a>\r\n");
      out.write("<h3>If you don't  have account\r\n");
      out.write("<a href=\"admin_register_page.jsp\">register</a></h3>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
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