<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 문법 배우기</title>
<style type="text/css">
	*{
		box-sizing:border-box;
	}

	a {
		text-decoration: none;
		font-weight: bold;
	}
	a:hover{
		color:red;
	}
	body{
		display: flex;
		flex-direction: column;
	}
	#linkGrammer{
		background-color: yellow;
		width: 300px;
		height: 100px;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	#linkGrammer:hover{
		cursor: pointer;
		border:1px solid red;
		color: red;
	}
</style>
</head>
<body>
	<h1>* EL(Expression Language)표현 언어</h1>
	
	<p>
		기존 JSP 상에 사용했던 &lt;%= %>(출력식) 같은 경우 사용이 복잡하고, <br/>
		컴파일 시 문제가 발생할 수 있기 때문에 <br/>
		이 문제를 대체할 수 있는 문법
	</p>
	
	<h3>1. EL구문 기본학습</h3>
	<!--
		절대 경로 방식: /MDP/sc
		상대 경로 방식: sc
	-->
	<div id="linkGrammer">
		<a  href="sc">링크</a>
	</div>
	
	<hr>
	
	<a href="include">포함</a> <br>
	
	<a href="forward">JSP로 포워딩</a> <br>
	
	<hr>
	
	<a href="/MDP/jstl">JSTL로 고고</a>
	
	<script>
		document.querySelector("#linkGrammer").addEventListener("click",()=>{
			window.location.href="sc";
			
		});
	</script>
</body>
</html>