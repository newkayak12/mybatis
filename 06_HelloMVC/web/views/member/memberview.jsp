<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%

	Member m = (Member)request.getAttribute("member");

%>

<style>
	section#enroll-container input[readonly]{
		background-color:lightgray;
	}

</style>

<section id=enroll-container>
		<h2>회원 정보 수정</h2>
		<form id="memberFrm" method="post" >
			<table>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="userId" id="userId_" value="<%=m.getUserId() %>" readonly required>
					</td>
				</tr>
				<%-- <tr>
					<th>패스워드</th>
					<td>
						<input type="password" name="password" id="password_" value="<%=m.getPassword() %>">
					</td>
				</tr>
				<tr>
					<th>패스워드확인</th>
					<td>	
						<input type="password" id="password_2"><br>
					</td>
				</tr>   --%>
				<tr>
					<th>이름</th>
					<td>	
					<input type="text"  name="userName" id="userName" value="<%=m.getUserName() %>" required><br>
					</td>
				</tr>
				<tr>
					<th>나이</th>
					<td>	
					<input type="number" name="age" id="age" value="<%=m.getAge() %>"><br>
					</td>
				</tr> 
				<tr>
					<th>이메일</th>
					<td>	
						<input type="email" placeholder="abc@xyz.com" name="email" id="email" value="<%=m.getEmail() %>"><br>
					</td>
				</tr>
				<tr>
					<th>휴대폰</th>
					<td>	
						<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" value="<%=m.getPhone() %>"><br>
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>	
						<input type="text" placeholder="" name="address" id="address" value="<%=m.getAddress() %>" ><br>
					</td>
				</tr>
				<tr>
					<th>성별 </th>
					<td>
					
					<%-- 
						<%if(m.getGender().equals("M")){ %>
							<input type="radio" name="gender" id="gender0" value="M" checked >
							<label for="gender0">남</label>
							<input type="radio" name="gender" id="gender1" value="F">
							<label for="gender1">여</label>
						<%} else { %>
							<input type="radio" name="gender" id="gender0" value="M" >
							<label for="gender0">남</label>
							<input type="radio" name="gender" id="gender1" value="F" checked s>
							<label for="gender1">여</label>
							
						<%} %> --%>
						
						
						
							<input type="radio" name="gender" id="gender0" value="M" <%=m.getGender().equals("M")? "checked" : " "%> >
							<label for="gender0">남</label>
							<input type="radio" name="gender" id="gender1" value="F" <%=m.getGender().equals("F")? "checked" : " "%>>
							<label for="gender1">여</label>
							
							
							
						
					</td>
				</tr>
				<tr>
					<th>취미 </th>
					<td>
					
					
						<input type="checkbox" name="hobby" id="hobby0" value="운동" <%=(m.getHobby().contains("운동"))? "checked": "" %>><label for="hobby0">운동</label>
						<input type="checkbox" name="hobby" id="hobby1" value="등산" <%=(m.getHobby().contains("등산"))? "checked": "" %> ><label for="hobby1">등산</label>
						<input type="checkbox" name="hobby" id="hobby2" value="독서" <%=(m.getHobby().contains("독서"))? "checked": "" %> ><label for="hobby2">독서</label><br/>
						<input type="checkbox" name="hobby" id="hobby3" value="게임" <%=(m.getHobby().contains("게임"))? "checked": "" %>><label for="hobby3">게임</label>
						<input type="checkbox" name="hobby" id="hobby4" value="여행" <%=(m.getHobby().contains("여행"))? "checked": "" %>><label for="hobby4">여행</label><br/>
						

					</td>
				</tr>
			</table>
			<input type="button" value="정보수정" onclick="fn_update()"/>
			<button type = "button" onclick = "fn_password_update()">  비밀번호 변경 </button>
			<input type="button" value="탈퇴" onclick = "fn_delete()"/>
		</form>
	</section>
	
	<script>
		
		const fn_update=()=>{
			
			if($("#password_").val() == $("#password_2").val()){
				//동적으로 form을 전송할 수 있
				memberFrm.method = "post";
				memberFrm.action = "<%=request.getContextPath()%>/memberupdate.do";
				memberFrm.submit();
				
			} else {
				$("#password_2").focus();
				alert('비밀번호를 확인하세요');
			}
			
			
			
		}
		
		const fn_delete = () =>{
			
			if($("#password_").val() == $("#password_2").val()){
				
				if(confirm("정말로 탈퇴하시겠습니까??"))

					location.replace("<%=request.getContextPath()%>/memberdelete.do?userId=<%=m.getUserId()%>");
					<%-- memberFrm.method = "post";
					memberFrm.action = "<%=request.getContextPath()%>/memberdelete.do";
					memberFrm.submit(); --%>
					
					// $("<form>").append 해서아예 폼을 만들어서 쿼리스트링 안쓰고 한 번 보내보자
					
			} else {
				$("#password_2").focus();
				alert('탈퇴를 하려면 비밀번호를 확인해주세요');
			}
			
		}
		
		
		const fn_password_update= () =>{
			 const url = '<%=request.getContextPath()%>/passwordUpdate?userId=<%=m.getUserId()%>';
			 const status = 'width = 400px, height = 210px left =  500px top = 200px';
			 
			 open(url, "_blank", status);
			 
			 <%-- 
			 memberFrm.action = '<%=request.getContextPath()%>/views/member/passwordupdate.jsp';
			 memberFrm.target = title;
			 memberFrm.submit(); --%>
			
		}
		
		
	
	</script>
	
	
<%@ include file="/views/common/footer.jsp"%>
	