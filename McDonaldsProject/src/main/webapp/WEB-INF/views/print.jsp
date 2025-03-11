<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>굉장히 중요한 파일</title>
</head>
<body>
	<ul>
		<li>브랜드: ${ brand }, 인기메뉴: ${ bestSeller.name }, 가격: ${ bestSeller.price }원</li>
	</ul>
	
	두 개 이상의 Scope에 같은 키 값으로 값을 담은 경우
	<br/><br>
	<!--
		page -> request -> session -> application 순으로 키 값 검색
	-->
	
	Scope에 직접 접근 하는 법 <br><br>
	
	requestScope: ${ requestScope.brand } <br>
	sessionScope: ${ requestScope.brand } <br>
	
	<br>
	
	만약 없는 키 값 el구문으로 출력하려고 하면 어떻게 될까? <br><br>
	
	없는 값: ${ abc }
	
	<hr>
	
	연산은 어디서 하는게 좋은가? <br>
	1. SQL문 DB단 <br>
	2. Java Service단(Validation/Transaction)
	3. View
	
	<hr>
	
	<h3>1. 산술연산</h3>
	
	* EL구문을 이용한 산술 연산 <br><br>
	
	big + small = ${ bigNumber + smallNumber } <br>
	big - small = ${ bigNumber - smallNumber } <br>
	big * small = ${ bigNumber * smallNumber } <br>
	big / small = ${ bigNumber / smallNumber } 또는 ${ bigNumber div smallNumber } <br>
	big % small = ${ bigNumber % smallNumber } 또는 ${ bigNumber mod smallNumber } <br>
	
	<h3>2. 논리연산</h3>
	
	<p>
		AND: ${ true && true } 또는 ${ true and true } <br>
		OR: ${ true || true } 또는 ${ true or true } <br>
	</p>
	
	<h3>3. 비교연산</h3>
	
	<p>
		big이 small보다 작니?: ${ bigNumber < smallNumber } 또는 ${ bigNumber lt smallNumber } <br>
		big이 small보다 크니?: ${ bigNumber > smallNumber } 또는 ${ bigNumber gt smallNumber } <br>
		big이 small보다 작거나 같니?: ${ bigNumber <= smallNumber } 또는 ${ bigNumber le smallNumber } <br>
		big이 small보다 크거나 같니?: ${ bigNumber >= smallNumber } 또는 ${ bigNumber ge smallNumber } <br>
	</p>
	
	<p>
		big이 small과 같니?: ${ bigNumber == smallNumber } 또는 ${ bigNumber eq smallNumber } <br>
		big이 small과 다르니?: ${ bigNumber != smallNumber } 또는 ${ bigNumber ne smallNumber } <br>
		str과 집에 가고 싶다 가 같니?: ${ str == "집에 가고 싶다" } 또는 ${ str eq "집에 가고 싶다" } <br>
	</p>
	
	<h3>비어있는지 확인</h3>
	
	<p>
		bestSeller가 null과 같니? ${ bestSeller == null } 또는 ${ bestSeller eq null } 또는 ${ empty bestSeller } <br>
		list에 뭐라도 들었니?: ${ !empty list }
	</p>
</body>
</html>