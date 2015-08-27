<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.html" %>

<jsp:useBean id="userEntity" scope="page" class="com.zehao.entitys.UserEntity"/>

<jsp:setProperty property="*" name="userEntity"/>
<%
out.print(userEntity.getUserName());
out.print(userEntity.getPassword());
out.print("over!");
%>
<jsp:forward page="header.html"></jsp:forward>
</body>
</html>