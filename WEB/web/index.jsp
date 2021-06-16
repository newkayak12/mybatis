<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<c:set var="root" value="<%=request.getContextPath() %>" scope="application"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> 1. 전체 회원 조회 </h2>
	<div > 
		<table id = "allOne">
		
		</table>
	</div>
<script>
	$(function(){
		
		view();
		
	})
	
	const view = () =>{
		$.ajax({
			url:"${applicationScope.root}/all",
			success:data=>{
					console.log(data)
					$("#allOne").append($("<tr>").append($("<th>").text("id"))
							.append( $("<th>").text("name"))
							.append( $("<th>").text("gender"))
							.append( $("<th>").text("age"))
							.append( $("<th>").text("email"))
							.append( $("<th>").text("address"))
							.append( $("<th>").text("phone"))
							.append( $("<th>").text("hobby"))
							.append( $("<th>").text("enrolldate"))
					
					)
					
					
					
					
						
				
					for(let i =0; i<data.length; i++){
						console.log(data[i]["userid"])
						$("#allOne").append( $("<tr>")
								.append( $("<td>").text( data[i]["userid"] ))
								.append( $("<td>").text(data[i]["username"]))
								.append( $("<td>").text(data[i]["gender"]))
								.append( $("<td>").text(data[i]["age"]))
								.append( $("<td>").text(data[i]["email"]))
								.append( $("<td>").text(data[i]["address"]))
								.append( $("<td>").text(data[i]["phone"]))
								.append( $("<td>").text(data[i]["hobby"]))
								.append( $("<td>").text(data[i]["enrolldate"]))
						
						)	
							
					}
					
					
				
				
				
			}
		})
		
	}

</script>
	
	<h2> 2. 검색조건 이름/주소 검색된 회원 조회 </h2>
	<input type="text" id ="keyword" placeholder="이름">
	<input type="button" onclick="fn_search()" value ="검색">
	<div>
		<table id="search">
		
		
		</table>
	
	</div>
	
	<script>
	const fn_search=()=>{
		$.ajax({
			url:"${applicationScope.root}/search",
			data:{"keyword":$("#keyword").val()},
			success:data=>{
					console.log(data)
					$("#search").append($("<tr>").append($("<th>").text("id"))
							.append( $("<th>").text("name"))
							.append( $("<th>").text("gender"))
							.append( $("<th>").text("age"))
							.append( $("<th>").text("email"))
							.append( $("<th>").text("phone"))
							.append( $("<th>").text("address"))
							.append( $("<th>").text("hobby"))
							.append( $("<th>").text("enrolldate"))
					
					)
					
					
					
					
						
				
					for(let i =0; i<data.length; i++){
						console.log(data[i]["userid"])
						$("#search").append( $("<tr>")
								.append( $("<td>").text( data[i]["userid"] ))
								.append( $("<td>").text(data[i]["username"]))
								.append( $("<td>").text(data[i]["gender"]))
								.append( $("<td>").text(data[i]["age"]))
								.append( $("<td>").text(data[i]["email"]))
								.append( $("<td>").text(data[i]["phone"]))
								.append( $("<td>").text(data[i]["address"]))
								.append( $("<td>").text(data[i]["hobby"]))
								.append( $("<td>").text(data[i]["enrolldate"]))
						
						)	
							
					}
					
				
			}
		})
		
	}

</script>



<input type="text" id ="keyword2" placeholder="주소">
	<input type="button" onclick="fn_searchaddr()" value ="검색">
	<div>
		<table id="searchtable">
		
		
		</table>
	
	</div>
	
	<script>
	const fn_searchaddr=()=>{
		$.ajax({
			url:"${applicationScope.root}/searchaddr",
			data:{"keyword":$("#keyword2").val()},
			success:data=>{
					console.log(data)
					$("#searchtable").append($("<tr>").append($("<th>").text("id"))
							.append( $("<th>").text("name"))
							.append( $("<th>").text("gender"))
							.append( $("<th>").text("age"))
							.append( $("<th>").text("email"))
							.append( $("<th>").text("phone"))
							.append( $("<th>").text("address"))
							.append( $("<th>").text("hobby"))
							.append( $("<th>").text("enrolldate"))
					
					)
					
					
					
					
						
				
					for(let i =0; i<data.length; i++){
						console.log(data[i]["userid"])
						$("#searchtable").append( $("<tr>")
								.append( $("<td>").text( data[i]["userid"] ))
								.append( $("<td>").text(data[i]["username"]))
								.append( $("<td>").text(data[i]["gender"]))
								.append( $("<td>").text(data[i]["age"]))
								.append( $("<td>").text(data[i]["email"]))
								.append( $("<td>").text(data[i]["phone"]))
								.append( $("<td>").text(data[i]["address"]))
								.append( $("<td>").text(data[i]["hobby"]))
								.append( $("<td>").text(data[i]["enrolldate"]))
						
						)	
							
					}
					
				
			}
		})
		
	}

</script>



	
	<h2> 3. 아이디 조회(단일값) </h2>
	<input type="text" id="checkid" placeholder="id">
	<input type="button" onclick = "fn_checkid()" value="search">
	
	<div id = "resultcontainer">
	
	</div>
	
	<script>
		const fn_checkid=()=>{
			$.ajax({
				url:"${applicationScope.root }/checkid",
				data:{"id":$("#checkid").val()},
				success:data=>{
					$("#resultcontainer").text(data)
				}
			
			})
		
		}
	
	</script>
	<h2> 4. 회원등록 </h2>
		<div id="enroll">
		 <p> id : <input type="text" id="id"> <p>
		 <p> password : <input type="text" id="password"> <p>
		 <p> username : <input type="text" id="username"> <p>
		 <p> gender : <input type="text" id="gender"> <p>
		 <p> age : <input type="text" id="age"> <p>
		 <p> email : <input type="text" id="email"> <p>
		 <p> phone : <input type="text" id="phone"> <p>
		 <p> address : <input type="text" id="address"> <p>
		
		 
		 	
		<input type="submit" value="전송" onclick = "fn_enroll()">
		</div>
		
		<div id="enrollresult"></div>
	<script>
		const fn_enroll =()=>{
			$.ajax({
				url:"${applicationScope.root}/enroll",
				data :{"id":$("#id").val(), "password":$("#password").val(), "username":$("#username").val(),
				"gender":$("#gender").val(), "age":$("#age").val(), "email:":$("#email").val(), 
				"phone":$("#phone").val(), "address":$("#address").val()},
				success:data=>{
					
					$("#enrollresult").text(data)
					
					
				}
				
			})
			
		}
	
	</script>	
		
		
		
		
	<h2> 5. 회원 수정</h2>
		<input type="text" id="name" placeholder="name"> <br>
		<input type="text" id="phone" placeholder="phone">
		<input type="button" value="modify" onclick ="fn_modify()">
		
		<div id="resultenroll">
		
		</div>
		
	 	<script>
	 		const fn_modify = () =>{
	 			$.ajax({
	 				url:"${applicationScope.root}/modify",
 	 				data:{"name":$("#name").val(), "phone":$("#phone").val()},
	 				success:data=>{
	 					$("#resultenroll").text(data)
	 					view();
	 				}
	 				
	 			})
	 			
	 		}
	 		
	 		
	 	
	 	</script>
	
	<h2> 6. 회원 삭제</h2>
	
	이름  : <input type="text" id="delName">
	<input type="button" onclick="fn_del()" value="삭제">
	<div id="deleteresult">
	</div>
	
	<script>
		const fn_del=()=>{
			$.ajax({
				url:"${applicationScope.root}/delete",
				data:{"name":$("#delName").val()},
				success:data=>{
					$("#deleteresult").text(data)
					
				}
			})	
		}
	</script>
	
	

</body>
</html>