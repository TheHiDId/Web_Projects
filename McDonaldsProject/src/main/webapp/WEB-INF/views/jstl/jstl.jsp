<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	h1{
		background-color: green;
		
	}
	

</style>


</head>
<body>
	<h1>JSTL의 정석</h1>
	
	<p>
		JSP Standard Tag Library의 약어: JSP에서 사용할 수 있는 커스텀 액션 태그 <br>
		공통적으로 사용해야하는 코드들을 보다 쉽게 사용할 수 있도록 태그화해서 표준으로 제공하는 라이브러리
	</p>
	
	<hr>
	
	<p>
		JSTL을 사용하기 위해선 먼저 라이브러리를 추가해준 후 <br>
		JSTL을 사용하고자 하는 JSP 페이지 상단에 선언을 해 주어야 함!
	</p>
	
	<% if(true) {%>
		ABCDE
	<% } %>
	
	<hr>
	
	<h2>Core 라이브러리 쓰는 법</h2>
	
	<p>
		prefix:if라는 태그를 작성하여 조건문을 만들 수 있음 <br>
		- Java에서의 단일 if문과 똑같은 역할을 할 수 있는 태그 <br>
		- 조건식은 test라는 속성에 작성
	</p>
	
	<c:if test="${ 1 lt 2 }">
		<strong>1이 2보다 작습니다.</strong>
	</c:if>
	
	<br>
	
	<c:if test="${ 1 gt 2 }">
		<strong>1이 2보다 큽니다.</strong>
	</c:if>
	
	<br>
	
	<c:if test="${ '안녕하세요' ne '반갑습니다' }">
		<strong>문자열 둘이 다릅니다.</strong>
	</c:if>
	
	<hr>
	
	<h3>choose, when, otherwise</h3>
	
	<!-- point라는 키 값으로 Value가 넘어옴
	
		포인트 사용량이 100 이하라면 일반회원 출력
		포인트 사용량이 300 이하라면 우수회원 출력
		앞의 두 케이스에 해당하지 않으면 최우수회원 출력
	 -->
	 
	 <c:choose>
	 	<c:when test="${ point le 100 }">
	 		일반회원 <br>
	 	</c:when>
	 	<c:when test="${ point le 300 }">
	 		우수회원 <br>
	 	</c:when>
	 	<c:otherwise>
	 		최우수회원 <br>
	 	</c:otherwise>
	 </c:choose>
	 
	 <hr>
	 
	 <h2>forEach</h2>
	 
	 <pre>
	 	표현법
	 	
	 	for loop문
	 	
	 	&lt;c:forEach var="속성명" begin="초기값" end="끝값" step="증가시킬값(생략가능)"&gt;
	 		반복적으로 실행할 내용
	 	&lt;c:/forEach&gt;
	 	
	 	&lt;c:forEach var="속성명" items="순차적으로 접근할 배열 또는 컬렉션"&gt;
	 		반복적으로 실행할 내용
	 	&lt;c:/forEach&gt;
	 </pre>
	 
	 <c:forEach var="i" begin="0" end="9">
	 	${ i }
	 </c:forEach>
	 
	 <br>
	 
	 <c:forEach var="i" begin="1" end="6">
	 	<h${ i }>이런거도 되지롱</h${ i }>
	 </c:forEach>
	 
	 <br>
	 
	 <ul>
	 	<c:forEach var="c" items="${ colors }">
	 		<li style="color:${ c }">${ c }</li>
	 	</c:forEach>
	 </ul>
	 
	 <h3>회원목록</h3>
	 
	 <!--
	 	caption, 
	 	thead, tbody, tfoot, 
	 	th, tr, td 
	  -->
	  
	 <table class="table table-striped">
	 	<thead>
	 		<tr>
	 			<th>번호</th>
	 			<th>이름</th>
	 			<th>아이디</th>
	 			<th>가입일</th>
	 		</tr>
	 	</thead>
	 	<tbody>
			<c:choose>
				<c:when test="${ !empty requestScope.userList }">
					<c:forEach var="user" items="${ userList }">
	 					<tr>
	 						<td>${ user.userNo }</td>
	 						<td>${ user.userId }</td>
	 						<td>${ user.userName }</td>
	 						<td>${ user.enrollDate }</td>
	 					</tr>
	 				</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4" >${ requestScope.msg }</td>
					</tr>
				</c:otherwise>
			</c:choose>
	 	</tbody>
	 </table>
</body>
</html>