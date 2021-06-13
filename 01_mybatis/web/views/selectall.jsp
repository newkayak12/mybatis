<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>no</th>
			<th>name</th>
			<th>tel</th>
			<th>email</th>
			<th>addr</th>
			<th>date</th>
			
		</tr>
		<c:forEach var="i" items="${requestScope.list }">
			<tr>
				<td><c:out value="${pageScope.i.studentNo}"></c:out></td>
				<td><c:out value="${pageScope.i.studentName}"></c:out></td>
				<td><c:out value="${pageScope.i.studentTel}"></c:out></td>
				
				<td><c:out value="${pageScope.i.studentAddr}"></c:out></td>
				<td><c:out value="${pageScope.i.studentEmail}"></c:out></td>
				<td><c:out value="${pageScope.i.regDate}"></c:out></td>
				
			</tr>
		</c:forEach>
	
	</table>


</body>
</html>