<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var = "path" value="<%= request.getContextPath()%>" scope="application"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MyBatis_Dynamic_Query</title>
	</head>
	<body>
		<h2>전체 회원 조회</h2>
		<a href="${applicationScope.path}/selectall"> select All</a>
		
		
		<br><br>
		
		<a href="${applicationScope.path }/selectOneEmp?no=200">사원조회</a>
		
		
		<br><br>
		
		<a href="${applicationScope.path }/boardView?no=46">보드뷰</a>
		
	</body>
</html>