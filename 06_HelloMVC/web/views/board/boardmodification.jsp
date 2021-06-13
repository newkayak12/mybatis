<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.board.model.vo.Board" %>

<%@ include file="/views/common/header.jsp" %>
<style>
	div#board-container
	{
		width:600px;
		margin:0 auto;
		text-align:center;
	}
	div#board-container h2
	{
		margin:10px 0;
	}
	table#tbl-board
	{
		width:500px;
		margin:0 auto;
		border:1px solid black;
		border-collapse:collapse;
	}
	table#tbl-board th
	{
		width:125px;
		border:1px solid;
		padding:5px 0;
		text-align:center;
	}
	table#tbl-board td
	{
		border:1px solid;
		padding:5px 0 5px 10px;
		text-align:left;
	}

</style>
<script>
	내용입력여부 확인 후 전송
</script>

<%Board b = (Board) request.getAttribute("board"); %>
<%-- <%Member loginMember = (Member)session.getAttribute("loginMember"); %> --%>
	<div id='board-container'>
		<h2>게시판 작성</h2>
		<form action='<%=request.getContextPath() %>/board/boardcreateend' method="post" enctype="multipart/form-data">
			<table id='tbl-board'>
				<tr>
					<th>제목</th>
					<td><input type="text" name="boardTitle" id="boardTitle" required></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="boardWriter" id="boardWriter" value="<%=loginMember.getUserId()%>" readonly></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="boardFile"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="20" cols="50" name="boardContent"></textarea></td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="등록" onclick="<!--validation-->">
						<input type="reset" value="취소">
					</th>
				</tr>
			</table>
		</form>
	</div>

<%@ include file="/views/common/footer.jsp" %>