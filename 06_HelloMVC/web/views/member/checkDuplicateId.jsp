<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.member.model.vo.Member"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<%

Member resultMember = (Member)request.getAttribute("result"); 



%>
<style>
	div#checkId-container{text-align:center; padding-top:50px}
	span#duplicated{color:red; font-weight:bolder;}
</style>



	
</head>
<body>
			<div id="checkId-container">
<%if (resultMember == null){ %>

				[<span> "<%= request.getParameter("userIdCheck") %>"</span>]는 사용가능합니다.	
				<br><br>
				<button type="button" onclick ="fn_close()" >닫기</button>
<%} else { %>
			[<span id="duplicated"> "<%= request.getParameter("userIdCheck") %>" </span>]는 사용불가능합니다.
						<br><br>
						<!-- 아이디 재입력창 구성 -->
						<form action="<%=request.getContextPath()%>/checkDuplicatedId" method="post">
							<input type="text" name="userIdCheck" id="userId">
							<input type="submit" value="중복검사">
						</form>
<%} %>
				</div>
				
				
				<script>
	const fn_close =()=>{
		//1.현재 값을 부모창에 주입
		
		console.log("test");
		const userId = "<%=request.getParameter("userIdCheck")%>";
		
		opener.memberEnroll.userId.value = userId;
		
		window.close();
	}
</script>
</body>
</html>