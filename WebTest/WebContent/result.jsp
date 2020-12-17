<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
<c:if test="${empty param.userID }">
<%--if는 조건문으로 자바처럼 else를 사용할 수 없다 참일 경우 아래의 조건을 출력 --%>
아이디를 입력하세요.<br>
<a href="login3.jsp">로그인 창</a>
</c:if>
<c:if test="${not empty param.userID }"> 
<%-- userID가 빈값이 아닐경우 아래 문자열을 출력 --%>
<h1>환영합니다. <c:out value="${param.userID }"/>님!!!</h1>
</c:if>
</body>
</html>