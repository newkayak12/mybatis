<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.notice.model.vo.Notice" %>    
<%@ include file = "/views/common/header.jsp"%> 
<%

	Notice n = (Notice) request.getAttribute("notice");
%>
  <div id="notice-container">
    <form action="<%=request.getContextPath()%>/notice/noticeupdateend" method="post" id="notice_write_Frm" enctype="multipart/form-data" >
        <table id="tbl-notice">
        <tr>
        <input type="hidden" name="noticeNo" value="<%=n.getNoticeNo()%>">
            <th>제 목</th>
            <td><input type="text" name = "noticeTitle" id = "noticeTitle" required value=<%=n.getNoticeTitle() %>></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type = "text" name = "noticeWriter" id="noticeWriter"  value= "<%=n.getNoticeWriter() %>" readonly></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <%if(n.getFilepath() != null) {%>
            <td style="position:relative"><input type="file" name = "up_file">
            <input type="hidden" name = "oriFile" value="<%=n.getFilepath()%>">
            <span id="fname"><%=n.getFilepath() %></span></td>
            <%} else{%>
            <td><input type="file" name = "up_file"></td>
            <%} %>
        </tr>
        <tr>
            <th>내 용</th>
            <td><textarea rows = "5" cols="50" name="content"><%=n.getNoticeContent() %></textarea></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="수정하기" onclick="fn_submit();">
            </th>
        </tr>
    </table>
    </form>
    </div>
    <script>
        const fn_submit= () =>{
            $("notice_write_Frm").submit();
        }

        
        $(function(){
        	$("input[name=up_file]").change(e=>{
        		if($(e.target).val() == ""){
        			$("#fname").show();
        		}else {
        			$("#fname").hide();
        		}
        	})
        })
    </script>


    <style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
   	span#fname{position:absolute;left:80px;top:9px;width:300px;background-color:#f5f5f5;}
    </style>

<%@ include file = "/views/common/footer.jsp"%>