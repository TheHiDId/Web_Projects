<%@page import="com.kh.burgerking.model.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	// 자바코드 작성할 수 있음
	UserDTO user = (UserDTO)request.getAttribute("user");

	String userId = user.getUserId();
	String userName = user.getUserName();

	String message = (String)request.getAttribute("message");
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
		사용자가 입력한 userName님!
		
		회원가입에 성공 하셨습니다! 
		
		가입한 아이디: userId
	-->
	
	<%--
		<h1><%=userName%> 님!</h1>
	--%>
	<h1>${ user.userId } 님!</h1>
	<p>
		${ message }<br/><br/>
		
		가입한 아이디: ${ user.userId }
	</p>
</body>
</html>