<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>name</th>
			<th>phone</th>
			<th>email</th>
			<th>address</th>
			<th>registrated date</th>
		</tr>
		
		<tr>
			<td>${student.studentName }</td>
			<td>${student.studentTel }</td>
			<td>${student.studentEmail }</td>
			<td>${student.studentAddr }</td>
			<td>${student.regDate }</td>
		</tr>
	</table>

</body>
</html>