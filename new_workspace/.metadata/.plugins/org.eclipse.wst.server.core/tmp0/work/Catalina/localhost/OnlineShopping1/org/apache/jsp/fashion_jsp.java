/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.75
 * Generated at: 2022-03-05 14:13:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fashion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>fashion</title>\r\n");
      out.write("meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write(" <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write(" <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("* {\r\n");
      out.write("  box-sizing: border-box;\r\n");
      out.write("}\r\n");
      out.write(".row{\r\n");
      out.write("	//padding-left:25px;\r\n");
      out.write("  //padding-right: 50px;\r\n");
      out.write("	margin-left:50px;\r\n");
      out.write("	margin-right:50px;\r\n");
      out.write("}\r\n");
      out.write("img {\r\n");
      out.write("	  width: 200px;\r\n");
      out.write("	  height:200px;\r\n");
      out.write("	}header{\r\n");
      out.write("	border: 2px solid black;\r\n");
      out.write("	background-color:#bbb;\r\n");
      out.write("}		\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header align=\"center\"><h1>Fashion products</h1></header>\r\n");
      out.write("<h3 align=\"right\"><a href=\"products.jsp\"  class=\"btn btn-success text-white \" style=\"color:black\">Go To Home</a></h3>\r\n");
      out.write("<br>\r\n");
      out.write("<div class=\"container-fluid mt-8\">\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("	<div class=\"card col-sm-2\">\r\n");
      out.write("    <img class=\"card-img-top\" src=\"images/shirt.jpeg\"  alt=\"image1\" style=\"width:100%\">\r\n");
      out.write("    <div class=\"card-body\">\r\n");
      out.write("      <h4 class=\"card-title\">Casual shirts</h4>\r\n");
      out.write("      <p class=\"card-text\">580 RS</p>\r\n");
      out.write("      <a href=\"#\" class=\"btn btn-primary\">add Cart</a>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"card col-sm-2\" >\r\n");
      out.write("    <img class=\"card-img-top\" src=\"images/jeans.jpeg\" alt=\"image1\">\r\n");
      out.write("    <div class=\"card-body\">\r\n");
      out.write("      <h4 class=\"card-title\">Slim Men Blue Jean</h4>\r\n");
      out.write("      <p class=\"card-text\">899 RS</p>\r\n");
      out.write("      <a href=\"#\" class=\"btn btn-primary\">add Cart</a>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write(" <div class=\"card col-sm-2\"  >\r\n");
      out.write("    <img class=\"card-img-top\" src=\"images/teashirt.jpeg\" alt=\"image1\"\">\r\n");
      out.write("    <div class=\"card-body\">\r\n");
      out.write("      <h4 class=\"card-title\">Solid Men Hooded Neck</h4>\r\n");
      out.write("      <p class=\"card-text\">480 RS</p>\r\n");
      out.write("      <a href=\"#\" class=\"btn btn-primary\">add Cart</a>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  <div class=\"card col-sm-2\"  >\r\n");
      out.write("    <img class=\"card-img-top\" src=\"images/sarees.jpeg\" alt=\"image1\">\r\n");
      out.write("    <div class=\"card-body\">\r\n");
      out.write("      <h4 class=\"card-title\">kashvi sareesPrinted Daily Wear Georgette</h4>\r\n");
      out.write("      <p class=\"card-text\">500 RS</p>\r\n");
      out.write("      <a href=\"#\" class=\"btn btn-primary\">add Cart</a>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"card col-sm-2\">\r\n");
      out.write("    <img class=\"card-img-top\" src=\"images/nike.jpeg\"  alt=\"image1\" style=\"width:100%\">\r\n");
      out.write("    <div class=\"card-body\">\r\n");
      out.write("      <h4 class=\"card-title\">Stride Walker Walking Shoe</h4>\r\n");
      out.write("      <p class=\"card-text\">1050 RS</p>\r\n");
      out.write("      <a href=\"#\" class=\"btn btn-primary\">add Cart</a>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"card col-sm-2\" >\r\n");
      out.write("    <img class=\"card-img-top\" src=\"images/footwear.jpeg\" alt=\"image1\">\r\n");
      out.write("    <div class=\"card-body\">\r\n");
      out.write("      <h4 class=\"card-title\">Slippers</h4>\r\n");
      out.write("      <p class=\"card-text\">430 RS</p>\r\n");
      out.write("      <a href=\"#\" class=\"btn btn-primary\">add Cart</a>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"card col-sm-2\" >\r\n");
      out.write("    <img class=\"card-img-top\" src=\"images/watch.jpeg\" alt=\"image1\">\r\n");
      out.write("    <div class=\"card-body\">\r\n");
      out.write("      <h4 class=\"card-title\">2048-BL Blue Day and Date</h4>\r\n");
      out.write("      <p class=\"card-text\">450 RS</p>\r\n");
      out.write("      <a href=\"#\" class=\"btn btn-primary\">add Cart</a>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"card col-sm-2\" >\r\n");
      out.write("    <img class=\"card-img-top\" src=\"images/glasses.jpeg\" alt=\"image1\">\r\n");
      out.write("    <div class=\"card-body\">\r\n");
      out.write("      <h4 class=\"card-title\">UV Protection Retro Square</h4>\r\n");
      out.write("      <p class=\"card-text\">300 RS</p>\r\n");
      out.write("      <a href=\"#\" class=\"btn btn-primary\">add Cart</a>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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