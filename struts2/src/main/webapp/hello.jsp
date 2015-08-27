<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello page</title>
</head>
<body>
	Hello
	<s:property value="name" />
	!
	<br /> Now you can upload your file to the server!
	<br />
	<form action="upload" method="post" enctype="multipart/form-data">
		<label>*</label> <input type="file" name="file" /> <input
			type="submit" value="Upload" />
	</form>
</body>
</html>