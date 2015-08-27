package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("<title>登陆页面</title>\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("body {\n");
      out.write("\tcolor: #000;\n");
      out.write("\tfont-size: 14px;\n");
      out.write("\tmargin: 20px auto;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tfunction check(form) {\n");
      out.write("\t\t//document.forms.form1.username.value取得form1中Username的值 并判断是否为空\n");
      out.write("\t\tif (document.forms.LoginForm.uname.value == \"\") {\n");
      out.write("\t\t\t//如果 为\"\"则弹出提示\n");
      out.write("\t\t\talert(\"请输入用户名！\");\n");
      out.write("\t\t\t//将输入焦点定位到没有输入的地方\n");
      out.write("\t\t\tdocument.forms.LoginForm.uname.focus();\n");
      out.write("\t\t\t//返回错误\n");
      out.write("\t\t\treturn false;\n");
      out.write("\t\t}\n");
      out.write("\t\tif (document.forms.LoginForm.upwd.value == \"\") {\n");
      out.write("\t\t\talert(\"请输入密码！\");\n");
      out.write("\t\t\tdocument.forms.LoginForm.upwd.focus();\n");
      out.write("\t\t\treturn false;\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<center>\n");
      out.write("\t\n");
      out.write("\t");

	
		Object obj = request.getAttribute("msg");
		if(obj != null){
			out.println(obj.toString());
		}else{
			out.println("无");
		}

	
      out.write("\n");
      out.write("\t\n");
      out.write("\t</center>\n");
      out.write("\t<br/>\n");
      out.write("\t\n");
      out.write("\t<form action=\"");
      out.print( request.getContextPath() );
      out.write("/LoginServlet\" method=\"post\" name=\"LoginForm\">\n");
      out.write("\t\n");
      out.write("\t\t");
 if(request.getAttribute("return_uri") != null) { 
      out.write("\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"return_uri\" value=\"");
      out.print( request.getAttribute("return_uri") );
      out.write("\">\n");
      out.write("\t\t");
 } 
      out.write("\n");
      out.write("\n");
      out.write("\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\" bordercolor=\"silver\" align=\"center\">\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td colspan=\"2\" align=\"center\" bgcolor=\"#E8E8E8\">用户登陆</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr >\n");
      out.write("\t\t\t\t<td>用户名：</td>\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"uname\" /></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>密码：</td>\n");
      out.write("\t\t\t\t<td><input type=\"password\" name=\"upwd\" /></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td colspan=\"2\" align=\"center\">\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"submit\" onclick=\"return check(this);\" />\n");
      out.write("\t\t\t\t\t<input type=\"reset\" name=\"reset\" />\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\n");
      out.write("\t</form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
