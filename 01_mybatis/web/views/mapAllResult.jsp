<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> ' . ' 으로 접근하기</h3>
	<table>
		<tr>
			<th>
				NO
			</th>
			<th>
				Name
			</th>
			
			<th>
				tel
			</th>
			
			<th>
				addr
			</th>
			
			<th>
				email
			</th>
			
			<th>
				regDate
			</th>
		</tr>
		<c:choose>	
			<c:when test="${requestScope.result.size()>0 }">
				<c:forEach var="i" items="${requestScope.result }" >
					<tr class = "rows">
						<td class="line"> <c:out value="${i.STUDENT_NO}"></c:out></td>
						<td class="line"> <c:out value="${i.STUDENT_NAME}"></c:out></td>
						<td class="line"> <c:out value="${i.STUDENT_TEL}"></c:out></td>
						
						<td class="line"> <c:out value="${i.STUDENT_ADDR}"></c:out></td>
						<td class="line"> <c:out value="${i.STUDENT_EMAIL}"></c:out></td>
						<td class="line"> <fmt:formatDate value="${i.REG_DATE}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:when test="${requestScope.result.size()==0 }">
					<tr>
						<td colspan="6">No DATA</td>
					</tr>
			</c:when>
		</c:choose>
	</table>


	<h3>[]로 접근하기</h3>
	
	<table>
		<tr>
			<th>
				NO
			</th>
			<th>
				Name
			</th>
			
			<th>
				tel
			</th>
			
			<th>
				addr
			</th>
			
			<th>
				email
			</th>
			
			<th>
				regDate
			</th>
		</tr>
		<c:choose>	
			<c:when test="${requestScope.result.size()>0 }">
				<c:forEach var="i" items="${requestScope.result }" >
					<tr class = "rows">
						<td class="line"> <c:out value="${i['STUDENT_NO']}"></c:out></td>
						<td class="line"> <c:out value="${i['STUDENT_NAME']}"></c:out></td>
						<td class="line"> <c:out value="${i['STUDENT_TEL']}"></c:out></td>
						
						<td class="line"> <c:out value="${i['STUDENT_ADDR']}"></c:out></td>
						<td class="line"> <c:out value="${i['STUDENT_EMAIL']}"></c:out></td>
						<td class="line"> <fmt:formatDate value="${i['REG_DATE']}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:when test="${requestScope.result.size()==0 }">
					<tr>
						<td colspan="6">No DATA</td>
					</tr>
			</c:when>
		</c:choose>
	</table>
	
</body>
</html>