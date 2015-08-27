<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List,java.util.ArrayList,com.hand.entity.Film"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Films Page</title>
</head>
<body>
<br />
	<a href="index.jsp">返回主页面</a>
	<%
		List<Film> list = (List<Film>) request.getAttribute("list");

		if (list.size() == 0) {
	%>
	Film List Is Null！（电影列表为空！）
	<%
		} else {
	%>
	<table border="1" cellspacing="0" cellpadding="4" bordercolor="silver"
		align="center">
		<tr>
			<td colspan="1" align="center" bgcolor="#E8E8E8">film_id</td>
			<td colspan="1" align="center" bgcolor="#E8E8E8">title</td>
			<td colspan="1" align="center" bgcolor="#E8E8E8">description</td>
			<td colspan="1" align="center" bgcolor="#E8E8E8">language</td>
			<td colspan="1" align="center" bgcolor="#E8E8E8">delete</td>
			<td colspan="1" align="center" bgcolor="#E8E8E8">edit</td>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td colspan="1" align="center" bgcolor="#E8E8E8"><%=list.get(i).getId() %></td>
			<td colspan="1" align="center" bgcolor="#E8E8E8"><%=list.get(i).getTitle() %></td>
			<td colspan="1" align="center" bgcolor="#E8E8E8"><%=list.get(i).getDescription() %></td>
			<td colspan="1" align="center" bgcolor="#E8E8E8"><%=list.get(i).getLangusge() %></td>
			<td colspan="1" align="center" bgcolor="#E8E8E8"><a href="<%= request.getContextPath() %>/DeleteFilmServlet?id=<%=list.get(i).getId() %>">删除</a></td>
			<td colspan="1" align="center" bgcolor="#E8E8E8"><a href="<%= request.getContextPath() %>/GetInfoServlet?id=<%=list.get(i).getId() %>">编辑</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
	
</body>
</html>