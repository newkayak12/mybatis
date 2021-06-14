<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.line{
		border:1px black solid;
	}
	
	#tableline {
		border-collapse: collapse;
		text-align : center;
	}
</style>
<body>
	<table id="tableline">
		<tr>
			<th>no</th>
			<th>name</th>
			<th>tel</th>
			<th>email</th>
			<th>addr</th>
			<th>date</th>
			
		</tr>
		<c:forEach var="i" items="${requestScope.list }">
			<tr class = "rows">
				<td class="line"><c:out value="${pageScope.i.studentNo}"></c:out></td>
				<td class="line"><c:out value="${pageScope.i.studentName}"></c:out></td>
				<td class="line"><c:out value="${pageScope.i.studentTel}"></c:out></td>
				
				<td class="line"><c:out value="${pageScope.i.studentAddr}"></c:out></td>
				<td class="line"><c:out value="${pageScope.i.studentEmail}"></c:out></td>
				<td class="line"><fmt:formatDate value="${pageScope.i.regDate}" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>
	
	</table>


</body>
</html>