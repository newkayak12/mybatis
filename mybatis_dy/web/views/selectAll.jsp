<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var = "path" value="${request.getContextPath()}" scope="application"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>result</h2>


<style>
 .tds{
 	border:1px black solid;
 }
 
 
 #tables{
 	
 	border-collapse: collapse;
 	text-align: center;
 }
 
</style>


	<div id="search-container">
		<form action="<%=request.getContextPath() %>/searchemp" method="post">
		<table>
			<tr>
				<th>
					검색타입
				</th>
				<td colspan="2">
					<select name = "searchType"  >
						<option value="" disabled selected>검색타입</option>
						<%-- <option value="emp_id" ${(requestScope.type != null)&&fn:contains(requestScope.type,"emp_id")? "selected":""}>empid</option>
						<option value="emp_name" ${(requestScope.type != null)&&fn:contains(requestScope.type,"emp_name")? "selected":""}>empname</option>
						<option value="email" ${(requestScope.type != null)&&fn:contains(requestScope.type,"email")? "selected":""}>email</option>
						<option value="phone" ${(requestScope.type != null)&&fn:contains(requestScope.type,"phone")? "selected":""}>phone</option> --%>
						
						<option value="emp_id" >empid</option>
						<option value="emp_name" >empname</option>
						<option value="email" >email</option>
						<option value="phone" >phone</option>
					</select>
					<input type="search" name="searchKeyword"  value='${(requestScope.keyword != null)? requestScope.keyword:""}'>
				</td>

			</tr>	
			<tr>
				<th>
					검색타입
				</th>
				<td colspan="2"> 
					<input type="radio" name="gender" value="F">F
					<input type="radio" name="gender" value="M">M
				</td>
			</tr>
			<tr>
				<th>
					급여
				</th>
				<td colspan="2">
					급여 : <input type="number" name = "salary" min="1000000" step="100000">
					<label>
						<input type="radio" name="le_ge" value="le">이하
					</label>
					<label>
						<input type="radio" name="le_ge" value="ge">이상
					</label>
				</td>
			
			</tr>
			
			<tr>
				<th>
					입사일
				</th>
				<td colspan="2">
					<input type="date" name = "hiredate">
					<label>
						<input type="radio" name="h_le_ge" value="le">이하
					</label>
					<label>
						<input type="radio" name="h_le_ge" value="ge">이상
					</label>
				</td>
			
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="조회">
				</td>
			</tr>
			
			
		</table>
		</form>
	
	</div>
	
	<div id="emp-container">
		<table id="tables">
			<tr >
				<th>empid</th>
				<th>empname</th>
				<th>empno</th>
				<th>email</th>
				<th>phone</th>
				<th>deptCode</th>
				<th>jobCode</th>
				<th>salLevel</th>
				<th>salary</th>
				<th>bonus</th>
				<th>managerId</th>
				<th>hireDate</th>
				<th>entDate</th>
				<th>ent_yn</th>
				<th>gender</th>
			</tr>
			
				<c:choose>
				
					<c:when test="${requestScope.list !=null }">		
						<c:forEach var="i" items="${requestScope.list }">
							<tr>
								<td class="tds"><c:out value="${i.empId }"/></td>
								<td class="tds"><c:out value="${i.empName }"/></td>
								<td class="tds"><c:out value="${i.empNo }"/></td>
								<td class="tds"><c:out value="${i.email }"/></td>
								<td class="tds"><c:out value="${i.phone }"/></td>
								<td class="tds"><c:out value="${i.deptCode }"/></td>
								<td class="tds"><c:out value="${i.jobCode }"/></td>
								<td class="tds"><c:out value="${i.salLevel }"/></td>	
								<td class="tds"><fmt:formatNumber value="${i.salary }" type="currency" /></td>
								<td class="tds"><fmt:formatNumber value="${i.bonus }" type="percent" /></td>
								<td class="tds"><c:out value="${i.managerId }"/></td>
								<td class="tds"><fmt:formatDate value="${i.hireDate }" pattern="yy/MM/dd" /></td>
								<td class="tds"><fmt:formatDate value="${i.entDate }" pattern="yy/MM/dd" /></td>
								<td class="tds"><c:out value="${i.entYN }"/></td>
								<td class="tds"><c:out value="${i.gender }"/></td>
							</tr>	
						</c:forEach>
					</c:when>
					<c:otherwise>
						<td colspan="14"></td>
					</c:otherwise>
				</c:choose>
				
				
		</table>
	</div>
</body>
</html>