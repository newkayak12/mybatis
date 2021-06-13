<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%> 

  <div id="notice-container">
    <form action="<%=request.getContextPath()%>/notice/noticeWriteend" method="post" id="notice_write_Frm" enctype="multipart/form-data" >
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><input type="text" name = "noticeTitle" id = "noticeTitle" required></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type = "text" name = "noticeWriter" id="noticeWriter"  value= "<%=loginMember.getUserId() %>" readonly></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td><input type="file" name = "up_file"></td>
        </tr>
        <tr>
            <th>내 용</th>
            <td><textarea rows = "5" cols="50" name="content"></textarea></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="등록하기" onclick="fn_submit();">
            </th>
        </tr>
    </table>
    </form>
    </div>
    <script>
        const fn_submit= () =>{
            $("notice_write_Frm").submit();
        }

    </script>


    <style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    </style>

<%@ include file = "/views/common/footer.jsp"%>