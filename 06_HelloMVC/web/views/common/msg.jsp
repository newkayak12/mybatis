<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg=(String)request.getAttribute("msg");
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시스템메세지</title>
</head>
<body>
	<script>
		alert('<%=msg%>');
		
		<%=request.getAttribute("script")%>
		//페이지전환하는 로직구성
		location.replace('<%=request.getContextPath()%><%=request.getAttribute("loc")%>');
	</script>
</body>
</html>