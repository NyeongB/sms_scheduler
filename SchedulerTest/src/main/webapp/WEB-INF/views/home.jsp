<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>SMS Scheduler</h1>

	<P>현재 시간 : ${serverTime}.</P>
	<p>
		■설정 정보 : <Strong style="color: blue;">주중 매일 08:50</Strong>에 QR 체크 요청 SMS
		발송■
	</p>
	 <h1 class="clock">test</h1>

    <script src = "${path}/resources/js/test.js" ></script>
	
	<h1>${str }</h1>
	<h1>+ 잔액정보 발송</h1>
	<%-- <h1>${test_num }</h1> --%>
	<h1><a href="user">user</a></h1>
</body>
</html>
