<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
	<h2>首页，欢迎光临本站！</h2>
	<br />
	<a href="hello.jsp">访问hello页面</a>
	<br />
	<%
		if (session.getAttribute("flag")==null||!session.getAttribute("flag").equals("login_success")) {
	%>
	<a href="login.jsp">登录</a>
	<br />
	<%
		}
	%>
</body>
</html>
