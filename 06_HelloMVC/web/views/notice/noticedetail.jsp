<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.notice.model.vo.Notice" %>
<%@ page import = "com.member.model.vo.Member" %>
<%!   Notice notice = null; %>
<% if(request.getAttribute("result2") != null){
	notice = (Notice) request.getAttribute("result2");
	System.out.println("야");
}
	
%>
<%
Member loginMember=(Member)session.getAttribute("loginMember");
%>

<% System.out.println(notice); %>

<div id="notice-container">
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><%=notice.getNoticeTitle() %></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><%=notice.getNoticeWriter() %></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td>
           	<% if(notice.getFilepath() != null){ %>
           		
           		<a href ="<%=request.getContextPath() %>/notice/fileDownload?fName=<%=notice.getFilepath() %>" ><img alt="" src="<%=request.getContextPath()%>/images/file.png" width="16px" height="16px"></a>
           		
           	<%} else { %>
           		<div>
           			NO_FILE
           		</div>
           		
           	<%} %>
            </td>
        </tr>
        <tr>
            <th>내 용</th>
            <td><%=notice.getNoticeContent() %></td>
        </tr>
       
       <%if(loginMember!=null  &&  loginMember.getUserId().equals("admin")){ %>
        <tr>
        
        <!--  분기처리, 관리자만 가능하게  -->
        
        
            <th colspan="2">
                <input type="button" value="수정하기" onclick="location.assign('<%=request.getContextPath() %>/notice/noticeupdate?no=<%=notice.getNoticeNo()%> ')">
                <input type="button" value="삭제하기" onclick="location.assign('<%=request.getContextPath()%>/notice/noticedelete?no=<%=notice.getNoticeNo()%>')">
            </th>
        </tr>
    </table>
    </div>

<%} %>

<form id="delormodi_Frm" name="delormodi_Frm"> 
	<input type="hidden" name="noticeNo" id="noticeNo">
</form>


<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script>



</script>

     <style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    </style>