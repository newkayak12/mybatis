<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import = "com.board.model.vo.Board" %>
<%@ page import = "java.util.*" %>    
<!-- 해더파일불러오기 -->
<%@ include file="/views/common/header.jsp" %>





<style>
	section#board-container{width:600px; margin:0 auto; text-align:center;}
	section#board-container h2{margin:10px 0;}
	table#tbl-board{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
	table#tbl-board th, table#tbl-board td {border:1px solid; padding: 5px 0; text-align:center;} 
	/*글쓰기버튼*/
	input#btn-add{float:right; margin: 0 0 15px;}
	/*페이지바*/
	div#pageBar{margin-top:10px; text-align:center; background-color:rgba(0, 188, 212, 0.3);}
	div#pageBar span.cPage{color: #0066ff;}
	input#Boardcreate{display: flex; justify-content: right;}
	</style>
	<section id="board-container">
		<h2>게시판 </h2>
		
		<%if(loginMember!=null) {%>
		<div><input type="button" value ="작성하기" id="Boardcreate" onclick="location.assign('<%=request.getContextPath()%>/board/boardcreate?id=<%=loginMember.getUserId()%>')"></div>
		<%} %> 
		
		<table id="tbl-board">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>첨부파일</th>
				<th>조회수</th>
			</tr>
			<c:set value = "${requestScope.result }" var="result"></c:set>
			
			<c:choose>
				<c:when test="${pageScope.result !=null && pageScope.result.size()>0  }">
				
					<c:forEach var="i" items="${pageScope.result }">
						<tr>
							<td>${pageScope.i.boardNo}</td>					
							<td>${pageScope.i.boardTitle }</td>
							<td>${pageScope.i.boardWriter }</td>
							<td>${pageScope.i.boardDate }</td>
							<c:choose>
								<c:when test="${(pageScope.i.boardOriginalFileName)!=null && (fn:length( pageScope.i.boardOriginalFileName)>0)}">
									<td>
										<a href = "<%=request.getContextPath()%>/board/boarddownload?fileName=${pageScope.i.boardOriginalFileName }&no=${pageScope.i.boardNo}" ><img alt="" src="<%=request.getContextPath()%>/images/file.png" width="16px" height="16px"></a>
									</td>
								</c:when>
								<c:when test="${(pageScope.i.boardOriginalFileName)==null || (fn:length( pageScope.i.boardOriginalFileName)==0)}">
									<td>NO_FILE_EXIST</td>
								</c:when>
							</c:choose>
							<td>${pageScope.i.boardReadCount }</td>
						</tr>
					</c:forEach>
				</c:when>
				
				<c:when test="${pageScope.result ==null || pageScope.result.size()==0  }">
					<tr>
						<td colspan="6">검색 결과가 없습니다.</td>
					</tr>
				</c:when>
			
			</c:choose>
			<%-- <%List<Board> boardlist = (List<Board>) request.getAttribute("result");
			
			if( boardlist != null && boardlist.size()>0){ 
			
		
					for(Board b : boardlist){%>
			<tr>
			
				<td>
					<%=b.getBoardNo() %>
				</td>
				<td>
					<a href = "<%=request.getContextPath()%>/board/boarddetail?no=<%=b.getBoardNo()
					%>"> <%=b.getBoardTitle()%> </a>
					
					
				</td>
				<td>
					<%=b.getBoardWriter() %>
				</td>
				<td>
					<%=b.getBoardDate() %>
				</td>
				
				<%if(b.getBoardOriginalFileName()!=null && b.getBoardOriginalFileName().length()>0){
					%>
				
				<td>
					<a href = "<%=request.getContextPath()%>/board/boarddownload?fileName=<%=b.getBoardOriginalFileName()%>&no=<%=b.getBoardNo()%>" ><img alt="" src="<%=request.getContextPath()%>/images/file.png" width="16px" height="16px"></a>
				</td>
				
				<%} else { %>
				<td>
					<span> NO_FILE </span>
				</td>	
				<%} %>
				
				<td>
					<%=b.getBoardReadCount() %>
				</td>
				
				
			</tr>
			<%}
					} else { %>
				<tr>
					<td colspan="6">검색 결과가 없습니다.</td>
				</tr>
			<%} %> --%>
		</table>

		<div id="pageBar"><%= request.getAttribute("pageBar") %><div></div>
	</section>
	
	
	<style>
		div#pageBar{
			display:flex;
			justify-content: center;
			background-color: none;
		}
		a{
			text-decoration: none;
			color:black;
			margin-left:15px;
			margin-right:15px;
		}
		div#pageBar>span{
		margin-left:15px;
			margin-right:15px;
		}
	</style>
	<%@ include file="/views/common/footer.jsp" %>