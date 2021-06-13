<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<section id=enroll-container>
      <h2>회원 가입 정보 입력</h2>
      <form name = "memberEnroll" action="<%=request.getContextPath() %>/memberenrollend.do" method="post" onsubmit="return fn_enroll_validate();" >
       <table>
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" placeholder="4글자이상" name="userId" id="userId_" required>
				<input type="button" value = "중복검사" onclick="fn_id_duplicate();">
			</td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td>
				<input type="password" name="password" id="password_" required><br>
			</td>
		</tr>
		<tr>
			<th>패스워드확인</th>
			<td>	
				<input type="password" id="password_2" ><br>
			</td>
		</tr>  
		<tr>
			<th>이름</th>
			<td>	
			<input type="text"  name="userName" id="userName" required><br>
			</td>
		</tr>
		<tr>
			<th>나이</th>
			<td>	
			<input type="number" name="age" id="age"><br>
			</td>
		</tr> 
		<tr>
			<th>이메일</th>
			<td>	
				<input type="email" placeholder="abc@xyz.com" name="email" id="email" required><br>
			</td>
		</tr>
		<tr>
			<th>휴대폰</th>
			<td>	
				<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" required><br>
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>	
				<input type="text" placeholder="" name="address" id="address"><br>
			</td>
		</tr>
		<tr>
			<th>성별 </th>
			<td>
				<input type="radio" name="gender" value="M" id="gender0"  >
				<label for="gender0">남</label>
				<input type="radio" name="gender" value="F" id="gender1">
				<label for="gender1">여</label>
			</td>
		</tr>
		<tr>
			<th>취미 </th>
			<td>
				<input type="checkbox" name="hobby" value="운동" id="hobby0"><label for="hobby0">운동</label>
				<input type="checkbox" name="hobby" value="등산" id="hobby1" ><label for="hobby1">등산</label>
				<input type="checkbox" name="hobby" value="독서" id="hobby2" ><label for="hobby2">독서</label><br />
				<input type="checkbox" name="hobby" value="게임" id="hobby3"><label for="hobby3">게임</label>
				<input type="checkbox" name="hobby" value="여행" id="hobby4" ><label for="hobby4">여행</label><br />
			</td>
		</tr>
	</table>
	<input type="submit" value="가입" >
	<input type="reset" value="취소">
       </form>
   </section>
   
   	<form action = "" name = "checkDuplicateId">
   		<input type = "hidden" name = "userIdCheck" id="">
  	</form>
   
   
	<script>
		$(function(){
			//비밀번호와 비밀번호확인의 값이 일치하는지 ㅊcheck
			$("#password_2").blur((e)=>{
				const pwck=$(e.target).val();
				const pw=$("#password_").val();
				if(pwck!=pw){
					alert("패스워드가 일치하지 않습니다.");
					$("#password_").focus();
				}
			});
		});
		
		//입력한 아이디값이 4글자 이상이 아니면 전송금지
		const fn_enroll_validate=()=>{
			const userId=$("#userId_");
			if(userId.val().length<4){
				alert("아이디는 최소 4자리 이상이여야 합니다.");
				userId.focus();
				return false;
			}
		}
		
		const fn_id_duplicate = () =>{
			//
			const url = "<%=request.getContextPath()%>/checkDuplicatedId";
			const title = "checkDuplicateId";
			const status = "left = 500px, top = 100px, width = 300px, height =300px";
			
			open(" ",title,status);
			
			//form에 있는 input의 값을 채우고 윈도우(새 창)에서 그 결과를 받는 로직으로 설정
			//form 은 name을 설정하면 그 name으로 직접 접근이 가능하다. 
			
			console.log(checkDuplicateId);
			
			//form의 name속성으로필요한 데이터 세팅하기
			
			checkDuplicateId.userIdCheck.value = $("#userId_").val();
			checkDuplicateId.method = "post";
			checkDuplicateId.action = "<%=request.getContextPath()%>/checkDuplicatedId";
			//이 form이 제출되는 window를 지정할 수가 있다.
			
			checkDuplicateId.target = title;
			
			//제출
			
			checkDuplicateId.submit();
			
			
		}
	</script>


<%@ include file="/views/common/footer.jsp"%>









