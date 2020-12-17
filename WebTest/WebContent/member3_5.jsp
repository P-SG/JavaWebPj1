<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,p201216.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="id" value="hong" scope="page" />
<c:set var="pwd" value="1234" scope="page" />
<%-- <c:set var="name" value="${'홍길동' }" scope="page" /> --%>
<c:set var="age" value="${22 }" scope="page" />
<c:set var="height" value="${177 }" scope="page" />

<c:remove var="age" />
<c:remove var="height" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>나이</b></td>
			<td width="7%"><b>키</b></td>
		</tr>
		<c:choose> <%-- jstl choose사용 --%>
			<%-- <c:when test="${name==null}"> --%>
			<c:when test="${empty name }"> 
			<%--choose안에 여러개의 when사용가능 --%>
				<tr align="center">
					<td colspan=5>이름을 입력하세요!!</td>
				</tr>
			</c:when>
			<c:otherwise> 
			<%-- when중 만족한 조건을 찾지 못했을때 실행, 생략이 가능하다 --%>
				<tr align=center>
					<td>${id }</td>
					<td>${pwd }</td>
					<td>${name }</td>
					<td>${age }</td>
					<td>${height }</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>