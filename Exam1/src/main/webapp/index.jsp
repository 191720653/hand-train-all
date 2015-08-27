<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Index Page</title>

<style type="text/css">
body {
	color: #000;
	font-size: 14px;
	margin: 20px auto;
}
</style>
</head>

<body>
	<br />
	<%
		Object flag = request.getSession().getAttribute("flag");
		if (flag != null && flag.toString() == "success") {

		} else {
	%>
	<a href="login.jsp">登錄</a><br/>
	<%
		}
	%>
	<a href="<%= request.getContextPath() %>/ShowFilmsServlet">顯示film列表</a><br/>
	<a href="<%= request.getContextPath() %>/GetLanguageServlet">新增film</a><br/>
	<a href="<%= request.getContextPath() %>/ShowFilmsServlet">刪除film</a><br/>
	<a href="<%= request.getContextPath() %>/ShowFilmsServlet">編輯film</a><br/>
</body>
</html>
