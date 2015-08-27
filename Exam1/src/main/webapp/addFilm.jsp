<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List,java.util.ArrayList,com.hand.entity.Film"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Film Page</title>
</head>
<script type="text/javascript">
	function check(form) {
		//document.forms.form1.username.value取得form1中Username的值 并判断是否为空
		if (document.forms.AddForm.title.value == "") {
			//如果 为""则弹出提示
			alert("请输入电影标题！");
			//将输入焦点定位到没有输入的地方
			document.forms.AddForm.title.focus();
			//返回错误
			return false;
		}
		if (document.forms.AddForm.description.value == "") {
			//如果 为""则弹出提示
			alert("请输入电影描述！");
			//将输入焦点定位到没有输入的地方
			document.forms.AddForm.description.focus();
			//返回错误
			return false;
		}
		if (document.forms.AddForm.language.value == "") {
			//如果 为""则弹出提示
			alert("请输入语言种类！");
			//将输入焦点定位到没有输入的地方
			document.forms.AddForm.language.focus();
			//返回错误
			return false;
		}

	}
</script>
<body>
	<form action="<%=request.getContextPath()%>/AddFilmServlet"
		method="post" name="AddForm">
		<%
			if (request.getAttribute("return_uri") != null) {
		%>
		<input type="hidden" name="return_uri"
			value="<%=request.getAttribute("return_uri")%>">
		<%
			}
		%>
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver"
			align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8">新增电影</td>
			</tr>
			<tr>
				<td>电影标题：</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>电影描述：</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>语言：</td>
				<td><select name="language">
						<%
							List<String> list = (List<String>) request.getAttribute("lan");
							for (int i = 0; i < list.size(); i++) {
						%>
						<option><%=list.get(i)%></option>
						<%
							}
						%>

				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="submit" onclick="return check(this);" /> <input type="reset"
					name="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>