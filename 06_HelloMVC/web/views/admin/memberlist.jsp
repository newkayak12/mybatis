<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import =  "com.member.model.vo.*" %>    
    
<%@ include file="/views/common/header.jsp"%>    
    
<style type="text/css">
    section#memberList-container {text-align:center;}
    
    section#memberList-container table#tbl-member {width:100%; border:1px solid gray; border-collapse:collapse;}
    section#memberList-container table#tbl-member th, table#tbl-member td {border:1px solid gray; padding:10px; }
    div#pageBar *{text-decoration: none; color: black; margin-right: 20px; }
    div#pageBar span { font-weight : bolder;}
    /* 검색창에 대한 스타일 */
    div#search-container {margin:0 0 10px 0; padding:3px; 
    background-color: rgba(0, 188, 212, 0.3);}
    div#search-userId{display:inline-block;}
    div#search-userName{display:none;}
    div#search-gender{display:none;}
    div#numPerpage-container{float:right;}
    form#numperPageFrm{display:inline;}
    </style>
    <% 
             	 String	selected = (String) request.getAttribute("searchType");
  			 System.out.println("jsp :"+selected);
    			 String keyword = (String) request.getAttribute("searchKeyword"); 
    %>
    <script>
    /* 	$(function(){
    		if(selected != null && keyword != null){
    			
    			
    		}
    		
    	})
     */
    
    
       const fn_changeDetect = () =>{
            
                let selectValue = $("select#searchType").val();
               
                

                if(selectValue == "userId"){
                    $("#search-userId").css("display","inline-block");
                    $("#search-userName").css("display","none");
                    $("#search-gender").css("display","none");
                    
                    
                } else if(selectValue == "userName"){

                    $("#search-userId").css("display","none");
                    $("#search-userName").css("display","inline-block");
                    $("#search-gender").css("display","none");
                    
                    
                } else if (selectValue == "gender"){

                    $("#search-userId").css("display","none");
                    $("#search-userName").css("display","none");
                    $("#search-gender").css("display","inline-block");
                    
                    
                    
                    
                }
        }
/*                 내 코드 참 별로네...ㅋㅋ */
                
                
                /* 다 블록하고  */
                /* $("#search-"+value).css("display","inline-block"); */
          
       
                
           /* $(function () {
        	   let value = $("select#searchType").val();
        	   $("#search-userId").css("display","none");
               $("#search-userName").css("display","none");
               $("#search-gender").css("display","none");
               $("#search-"+value).css("display","inline-block");
           
           })  */
        
<%-- 
          const fn_numPerPageChange = () =>{
        	  $("#numPerPage_hiddenType").val('<%=selected%>')
        	  $("#numPerPage_hiddenSearch").val('<%=keyword%>')
        	  
        	  
        	  
        	 let numPerPage =  $("select#numPerPage").val();
        	  $("#numPerPage_numperhidden").val(numPerPage);
        	  console.log(numPerPage);
        	 let where = "";
        	 
        	 
        	 <% if(request.getAttribute("where").equals("MemberList")){
        	 %>
        	 		where = '<%=request.getContextPath()%>/admin/memberList';
        	 		
        	 <%} else {%>
        	 		where = '<%=request.getContextPath()%>/admin/searchmemberlist';
        	 <% }%>
        	 
        	 
        	  $("#numPerPage-form").attr("action",where);
              $("#numPerPage-form").submit();
        	  
          }
           --%>
              
         $(function(){
        	$("#numPerPage").chage((e)=>{
        		
        		$.ajax({
        			url:"<%=request.getContextPath()%>/admin/memberListAjax",
        			data"{cPage:<%=request.getParameter("cPage")%>,"numPerPage": $(e.target).val()},
        			success:data=>{
        				
        				console.log(data);
        				$("#tbl-member").html(data);
        				
        			}
        		})
        	}) 
         })
            
        
    </script>
    
    <section id="memberList-container">
        <h2>회원관리</h2>
        <div id="search-container">
        	검색타입:
        	<select id = "searchType"  onchange="fn_changeDetect()" >
        		<option value = "userId" <%=(selected!=null && selected.equals("userId"))? "selected":"" %>>아이디</option>
        		<option value = "userName" <%=(selected!=null && selected.equals("userName"))? "selected":"" %>>이름</option>
        		<option value = "gender" <%=(selected!=null && selected.equals("gender"))? "selected":"" %>>성별</option>
        	</select>
        		<div id="search-userId">
        			<form action  = "<%=request.getContextPath() %>/admin/searchmemberlist">
        				<input type="text" name="searchKeyword" size="25" placeholder="검색할 내용을 입력하세요."  value = "<%= (keyword != null)? keyword:"" %>" >
        				<input type="hidden" name="searchType" value="userId">
        				<button type = "submit">검색</button>
        			</form>
        		</div>
        		<div id="search-userName">
        			<form action  = "<%=request.getContextPath() %>/admin/searchmemberlist">
        				<input type="text" name="searchKeyword" size="25" placeholder="검색할 이름을 입력하세요." value = "<%=(keyword!=null)? keyword :"" %>" >
        				<input type="hidden" name="searchType" value="userName">
        				<button type = "submit">검색</button>
        			</form>
        		</div>
        		<div id="search-gender">
        			<form action  = "<%=request.getContextPath() %>/admin/searchmemberlist">
        				<label><input type="radio" name="searchKeyword" value="M" value = "   <%=keyword!=null&&keyword.equals("M")? "checked":"" %>" >남</label>
        				<label><input type="radio" name="searchKeyword" value="F" value = "   <%=(keyword!=null&&keyword.equals("M"))? "":"chcked" %>">여</label>
        				<input type="hidden" name="searchType" value="gender">
        				<button type = "submit">검색</button>
        			</form>
        		</div>
        </div>
         
        <div id = "numPerPage-container">
        	페이지당 회원수 : 
        	<form action="" id="numPerPage-form">
        		<select name = "numPerPage" id="numPerPage" ><!-- onchange="fn_numPerPageChange()" -->
        			<option value="10"<%--  <%=(request.getParameter("numPerPage")).equals("10")||request.getAttribute("nPerPage")==null? "selected":"" %> --%> >10</option>
        			<option value="5"<%-- "<%=(request.getParameter("numPerPage")).equals("5")&&request.getAttribute("nPerPage")!=null? "selected":"" %> --%> >5</option>
        			<option value="3"<%--  <%=(request.getParameter("numPerPage")).equals("3")&&request.getAttribute("nPerPage")!=null? "selected":"" %> --%>>3</option>
        		</select>
        		<input type="hidden" name="searchType" id="numPerPage_hiddenType">
        		<input type="hidden" name="searchKeyword" id="numPerPage_hiddenSearch">
        		<inpu type="hidden" name="numPerPage" id='numPerPage_numperhidden'> 
        	</form>
        </div>
        
        
        <table id="tbl-member">
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
        </table>
   			<div id = "pageBar"> <%= request.getAttribute("pageBar") %></div>
    </section>
    
    
    
    <%@ include file="/views/common/footer.jsp"%>