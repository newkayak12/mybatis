<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%> 
<%@ page import = "com.notice.model.vo.Notice" %>
<%@ page import = "java.util.*" %>

<style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both;}
    table#tbl-notice th, table#tbl-notice td {border:1px solid; padding: 5px 0; text-align:center;}
    div#pageBar{display:flex; justify-content: center;} 
    a{text-decoration: none;color: black;   }
    input#btn-add{ float:right; margin: 0 0 15px;}
</style>



<section id="notice-container">
        <h2>공지사항</h2>
        <input type = "button" value = "글쓰기" id="btn-add" onclick = "fn_noticeWrite()">
        <table id="tbl-notice">
            <tr>
            
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>첨부파일</th>
                <th>작성일</th>
            </tr>
            
            <%List<Notice> result = (List<Notice>) request.getAttribute("result");
            	if(result!= null && result.size()>0){
            		for(Notice notice :result){
            			%>
       			<tr>
       				<td><%=notice.getNoticeNo() %></td>
       				<td>
       				
       					<a href ="<%=request.getContextPath()%>/notice/noticedetail?notice_no=<%=notice.getNoticeNo() %>&notice_writer=<%=notice.getNoticeWriter() %>"  target="_blank"><%=notice.getNoticeTitle() %></a>
      				
      				</td>
       				<td><%=notice.getNoticeWriter() %></td>
       				<td>
		       				<%if(notice.getFilepath() != null){
		       				System.out.println(notice.getNoticeNo()+"\n--------\n"+notice.getFilepath()+"   nn");
		       				%>
		       				
		       						<img alt="" src="<%=request.getContextPath()%>/images/file.png" width="16px" height="16px">
		       				
		       				<% } else {
		       				
		       				System.out.println(notice.getFilepath()+"   null\n--------");%>
		       				
		       						<span>NO_FILE</span>
		       				
		       				<%} %>
       				</td>
       				<td><%=notice.getNoticeDate() %></td>
       			
       			
       			</tr>
            			
            			
            			
            			
            			<%
            		}
            	}
            %>
	
        </table>
    </section>

	<script>
	
		// 공지사항 글쓰기 버튼에 클릭이벤트에 연결된 함수 
		const fn_noticeWrite = () => {
			location.assign("<%=request.getContextPath()%>/notice/noticeForm");
		}
	
	</script>

<div id="pageBar">
	<%=request.getAttribute("pageBar") %>
</div>
<%@ include file = "/views/common/footer.jsp"%>