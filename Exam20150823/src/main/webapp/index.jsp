<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<!-- <script src="Exam20150823/js/jquery.min.js"></script> -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<%
int pages = request.getParameter("page")==null?0:Integer.parseInt(request.getParameter("page"))+1;
%>
<div class="container">
    <div class="row">
        <div class="col-md-12 bg-success">
        <a href="#" class="pull-left"><h1>8836 郑泽豪</h1></a>
        <a href="Exam20150823/LogoutServlet" class="pull-right"><h1>Exit</h1></a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 bg-success">
        <a href="<%=request.getContextPath()%>/AddressServlet" class="pull-left"><h1>新建</h1></a>
        </div>
    </div>
    <div class="row">
    	
        <div class="col-md-3 bg-primary">
            <div class="panel panel-default" style="margin-top: 10px;">
                <div class="panel-heading" role="tab" id="headingFisrt">
                    <h4 class="panel-title">
                        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFirst" aria-expanded="true" aria-controls="collapseFirst">
                            Customer Manage
                        </a>
                        <span class="caret"></span>
                    </h4>
                </div>
                <div id="collapseFirst" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFirst">
                    <div class="panel-body list-unstyled">
                        <li>new customer</li>
                        <li>update customer</li>
                        <li>query customer</li>
                        <li>delete customer</li>
                    </div>
                </div>
            </div>
            <div class="panel panel-default" style="margin-top: 10px;">
                <div class="panel-heading" role="tab" id="headingSecond">
                    <h4 class="panel-title">
                        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSecond" aria-expanded="true" aria-controls="collapseSecond">
                            Film Manage
                        </a>
                        <span class="caret"></span>
                    </h4>
                </div>
                <div id="collapseSecond" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSecond">
                    <div class="panel-body">
                        <ul class="nav-pills list-unstyled">
                            <li>new customer</li>
                            <li>update customer</li>
                            <li>query customer</li>
                            <li>delete customer</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-8 col-md-offset-3 bg-danger">
            <table id="table" class="table table-bordered table-striped text-center table-hover">
                <thead>
                <th class="text-center">#</th>
                <th class="text-center">first name</th>
                <th class="text-center">last name</th>
                <th class="text-center">address</th>
                <th class="text-center">email</th>
                <th class="text-center">customer_id</th>
                <th class="text-center">last_update</th>
                </thead>
            </table>
            <div class="row">
            	<a href="index.jsp?page=<%=pages%>"><h4>下一页</h4></a>
                <a href="index.jsp?page=<%=pages-2%>"><h4>上一页</h4></a>
            </div>
        </div>
    </div>
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="exampleModalLabel">New message</h4>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="form-group">
                                        <label for="recipient-name" class="control-label">Recipient:</label>
                                        <input type="text" class="form-control" id="recipient-name">
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="control-label">Message:</label>
                                        <textarea class="form-control" id="message-text"></textarea>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Send message</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Button trigger modal 
                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#exampleModal">
                    Launch demo modal
                </button>-->
                
</div>
<script type="text/javascript">
	var page="<%=pages%>";
	if(page>10){
		page=page%10;
	}
	//alert(page);
    var xmlHttpRequest = null; //声明一个空的对象以接受XMLHttpRequest对象
    function ajaxRequest() {
        if(window.ActiveXObject) {   			//IE的
            xmlHttpRequest = new ActionXObject("Microsoft.XMLHTTP");
        }
        else if(window.XMLHttpRequest) {		//除IE外的
            xmlHttpRequest = new XMLHttpRequest();
        }
        if(xmlHttpRequest != null) {
            xmlHttpRequest.open("GET", "<%=request.getContextPath()%>/AllUaerServlet", true);
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
                //alert(text);
            	var arr = eval(text);
            	var table = document.getElementById("table");
            	for(var i=page*10;i<10+page*10;i++){
                    var tr = document.createElement("tr");
                    tr.innerHTML="<td>"+"<a id='delete' href='/Exam20150823/DeleteUserServlet?id="+arr[i].customer_id+"'>delete</a>|<a id='update'>update</a>"+"</td>"
                    +"<td>"+arr[i].first_name+"</td>"
                    +"<td>"+arr[i].last_name+"</td>"
                    +"<td>"+arr[i].address+"</td>"
                    +"<td>"+arr[i].email+"</td>"
                    +"<td>"+arr[i].customer_id+"</td>"
                    +"<td>"+arr[i].last_update+"</td>";
                    table.appendChild(tr);
            	}
            	table.addcss("table-striped");
            	alert("ajax over");
        }
        }
    }
    ajaxRequest();
</script>
</body>
</html>
