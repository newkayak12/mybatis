<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "java.io.File" %>
    
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
	
	<h3>학생 이름 등록하기 </h3>
	<form action="${applicationScope.path}/paramMybatis" method="post">
		<input type="text" name = "name">
		<input type="submit" value= "이름 저장">
		
	</form>
	
	<h3>학생 이메일 등록하기 </h3>
	<form action="${applicationScope.path}/paramMybatis/email" method="post">
		<input type="text" name = "email">
		<input type="submit" value= "이메일 저장">
		
	</form>
	
	<h3>여러 개의 파라미터 등록하기</h3>
	<form action="${applicationScope.path}/paramMybatis/multi" method="post">
		이름 : <input type="text" name = "name"> <br>
		전화번호 : <input type="text" name = "phone"> <br>
		이메일 : <input type="text" name = "email"> <br>
		주소 : <input type="text" name = "addr"> <br>
		<input type="submit" value= "저장">
		
	</form>
	
	
	<h3>W3B!</h3>
	<form action = "${applicationScope.path }/web" method = "post">
		
	
	</form>
	
	
	
	<h3>등록된 회원 주소, 전화번호를 수정하기</h3>
	<form action="${applicationScope.path }/paramMybatis/update" method="post">
		이름 : <input type = "text" name = "name"><br>
		주소 : <input type = "text" name = "addr"><br>
		전화번호 : <input type = "text" name = "tel"><br>
		
		
		
		<input type="submit" value="수정">
	
	</form>
	
	
	<h3>등록된 회원 삭제하기</h3>
	<form action="${applicationScope.path }/paramMybatis/delete" method="post">
		이름 : <input type = "text" name = "name"><br>
		<input type="submit" value="수정">
	
	</form>
	
	<h3>등록된 회원 가져오기</h3>
		<pre>
			select문 사용하기
				1. 한 개의 row만 가져오는 select가 있고
				2. 여러 개의 row들을 가져오는 select가 있고
				3. 여러 개의 row들을 부분별로 가져오는 select문이 있다. >paging 처리 
		</pre>
		
		
	<h3>기본 select문 사용해서 데이터 가져오기</h3>
		<h4>student table의 학생 수 가져오기</h4>
		<a href="${applicationScope.path }/selectCount">학생수 내놔</a>
		<br>
		<a href="${applicationScope.path }/selectStudent?no=5">1번 학생 호출</a>
		
	<h3>여러 개를 데이터에서 가져오기 </h3>
		<a href="${applicationScope.path }/selectAllStu">학생 전체 호출</a>
		
	<h3>이름으로 검색하기</h3>
		<form action ="${applicationScope.path }/searchName">
			이름 : <input type="text" name="searchKeyword" >
			<input type="submit" value="제출">
		</form>	
		
		
		
	<h2>객체를 이용하지 않고 data가져오기</h2>	
	<pre>
		map으로 vo 대신 쓸 수 있다. 
		map ( 키 : 값 )
		
		Map > key컬럼명 value값
	</pre>
	
		<a href="${applicationScope.path }/searchMap?no=5">map으로 하나 가져오기</a>


	<h3>map으로 여러 개 받아오기</h3>
	
	<a href="${applicationScope.path }/mapandall">map으로 여러 개 받아오기</a>
</body>
</html>