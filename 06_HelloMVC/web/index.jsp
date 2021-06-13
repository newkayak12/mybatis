<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 해더파일불러오기 -->
<%@ include file="views/common/header.jsp" %>
<section id="content" style="height:auto !important;">
	<h1 align="center" style="margin:200px;">안녕하세요,mvc입니다.</h1>
	
	
	<div style="margin-left:360px;">
		<div id="insertarea">
			<textarea id ="inputarea" cols="20" rows="1"></textarea>
			<input type="button" onclick = "fn_repl()" value = "전송">
		</div>
		<div>
		 	<table id = "repl">
		 	</table>
		</div>
	</div>
</section>


<script>
	$(function () {
		fn_show();
		
		
	})
	
	const fn_show =()=>{
			
			$.ajax({
				url:"<%=request.getContextPath()%>/replajax",
				data:{"sort":"select"},
				success:data=>{
					$("#repl").html("");
					if(data.length>0){
						$("#repl").append( $("<tr>").append($("<th>").text("check")).append($("<th>").text("글번호")).append($("<th>").text("내용"))  )
					}
					for(let i =0; i<data.length; i++){
						console.log(data[i])
						
						
						$("#repl").append($("<tr>")
								.append( $("<td>").append($("<input>").attr({"type":"checkbox","onclick":'fn_del('+data[i]["seq"]+')'}) ))
								.append( $("<td>").text(data[i]["seq"]) )
								.append($("<td>").text(data[i]["content"]) ))

					}
						
					
					
					
				}
			})
			
		}
	
	
	const fn_repl = () =>{
		
		$.ajax({
			url:"<%=request.getContextPath()%>/replajax",
			data:{"sort":"insert", "content":$("#inputarea").val()},
			success:data=>{
				$("#inputarea").val("");
				
				fn_show();
				
				
			}
		})
		
	}
	
	const fn_del = (e) =>{
		
		$.ajax({
			url:"<%=request.getContextPath()%>/replajax",
			data:{"sort":"delete","seq":e },
			success:data=>{
					
				
				fn_show();
				
			}
		})
		
	}


</script>

<%@ include file="views/common/footer.jsp" %>