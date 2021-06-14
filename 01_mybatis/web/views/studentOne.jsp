<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
		
			<tr class = "rows">
				<td class="line"><c:out value="${requestScope.i.studentNo}"></c:out></td>
				<td class="line"><c:out value="${requestScope.i.studentName}"></c:out></td>
				<td class="line"><c:out value="${requestScope.i.studentTel}"></c:out></td>
				
				<td class="line"><c:out value="${requestScope.i.studentAddr}"></c:out></td>
				<td class="line"><c:out value="${requestcope.i.studentEmail}"></c:out></td>
				<td class="line"><fmt:formatDate value="${requestScope.i.regDate}" pattern="yyyy-MM-dd"/></td>
			</tr>
		
	
	</table>
	
	
	<h3>map으로 출력</h3>
	
	<table id="tableline">
		<tr>
			<th>no</th>
			<th>name</th>
			<th>tel</th>
			<th>email</th>
			<th>addr</th>
			<th>date</th>
			
		</tr>
		
			<tr class = "rows">
				<td class="line"> <c:out value="${requestScope.map.STUDENT_NO}"></c:out></td>
				<td class="line"> <c:out value="${requestScope.map.STUDENT_NAME}"></c:out></td>
				<td class="line"> <c:out value="${requestScope.map.STUDENT_TEL}"></c:out></td>
				
				<td class="line"> <c:out value="${requestScope.map.STUDENT_EMAIL}"></c:out></td>
				<td class="line"> <c:out value="${requestScope.map.STUDENT_ADDR}"></c:out></td>
				<td class="line"> <fmt:formatDate value="${requestScope.map.REG_DATE}" pattern="yyyy-MM-dd"/></td>
			</tr>
		
	
	</table>


</body>
</html>