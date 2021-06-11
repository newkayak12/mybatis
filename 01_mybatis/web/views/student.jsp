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
			<td>${student.student_Name }</td>
			<td>${student.student_Tel }</td>
			<td>${student.student_Email }</td>
			<td>${student.student_Addr }</td>
			<td>${student.reg_Date }</td>
		</tr>
	</table>

</body>
</html>