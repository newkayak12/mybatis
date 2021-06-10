<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <c:set var ="path" value ="${pageContext.request.contextPath }" scope="application"/>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyBatis</title>
</head>
<body>
	<h2>마이 바티스 체험해보기</h2>
	<a href="${applicationScope.path}/insertStudentTest" >학생입력</a>

</body>
</html>