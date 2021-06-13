<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List,  com.member.model.vo.Member" %>    
<!DOCTYPE html>
 <thead>
                <tr>
                
                
                    <th>아이디</th>
				    <th>이름</th>
				    <th>성별</th>
				    <th>나이</th>
				    <th>이메일</th>
				    <th>전화번호</th>
				    <th>주소</th>
				    <th>취미</th>
				    <th>가입날짜</th>
				    
				    
				    
                </tr>
            </thead>
            <tbody>
            
            <%
            List<Member> result = ( List<Member> )request.getAttribute("list");
               
            if(result.size() >0){
                	for(Member m : result){
              
                  %> 
                  
                  <!--  -->
       			<tr>
       				<td><%=m.getUserId()%></td>
       				<td><%=m.getUserName()%></td>
       				<td><%=m.getGender()%></td>
       				<td><%=m.getAge()%></td>
       				<td><%=m.getEmail()%></td>
       				<td><%=m.getPhone()%></td>
       				<td><%=m.getAddress()%></td>
       				<td><%=m.getHobby()%></td>
       				<td><%=m.getEnrollDate()%></td>
       	
 				</tr>      	
	    
	   		 <%	}
   		 			
             } else{ %>
             
            	 
            	<p> 결과가 없습니다. </p> 
            	 
            <%  }%>
            </tbody>