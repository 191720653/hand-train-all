<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<script type="text/javascript">
    var xmlHttpRequest = null; //声明一个空的对象以接受XMLHttpRequest对象
    function ajaxRequest() {
        if(window.ActiveXObject) {   			//IE的
            xmlHttpRequest = new ActionXObject("Microsoft.XMLHTTP");
        }
        else if(window.XMLHttpRequest) {		//除IE外的
            xmlHttpRequest = new XMLHttpRequest();
        }
        var str="userName=zehao&password=123"; 
        if(xmlHttpRequest != null) {
            xmlHttpRequest.open("POST", "<%=request.getContextPath()%>/loginServlet?"+str, true);
            //关联好ajax的回调函数
            xmlHttpRequest.onreadystatechange = ajaxCall;

            //真正向服务器发送请求
            xmlHttpRequest.send();
        }
    }

    function ajaxCall() {
        if(xmlHttpRequest.readyState == 4 ) {  		//完全得到服务器的响应
            if(xmlHttpRequest.status == 200) {		//没有异常
                var text = xmlHttpRequest.responseText;
                document.getElementById("result").innerHTML = text;
        }
        }
    }
    ajaxRequest();
</script>
	<form action="<%=request.getContextPath()%>/loginServlet" method="get">
		账号：<input type="text" name="userName" /> <br /> 密码：<input type="text"
			name="password" /> <br /> <input type="submit" value="提交" /> <input
			type="reset" value="重置" />
	</form>
<div id="result"></div>
</body>
</html>