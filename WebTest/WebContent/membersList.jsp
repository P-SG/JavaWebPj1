<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*,p201216.*"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
   	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table border="1"  align="center" >
    <tr align="center" bgcolor="lightgreen">
      <td width="7%"><b>아이디</b></td>
      <td width="7%"><b>비밀번호</b></td>
      <td width="7%" ><b>이름</b></td>
      <td width="7%"><b>이메일</b></td>
      <td width="7%"><b>가입일</b></td>
   </tr>
   <c:choose>
   <%--
   ArrayList list = request.getAttribute("membersList");
    --%>
    <c:when test="${membersList==null }"> <%-- 리스트가 null일 경우 아래 문자열 출력 --%>
    <tr>
    <td colspan=5>
    <b>등록된 회원이 없습니다.</b>
    </td>
    </tr>
    </c:when>
    <c:when test="${membersList!= null }"> 
    <c:forEach var="mem" items="${membersList }">
    <%-- 자바의 for문과 같은 방식으로 반복문 출력 --%>
    <%-- membersList 저장된 memberBean을 mem에 순서대로 가져와 출력한다. --%>
    <tr align=center>
      <td>${mem.id }</td> <%--mem --%>
      <td>${mem.pwd }</td>
      <td>${mem.name }</td>
      <td>${mem.email }</td>
      <td>${mem.joinDate }</td>  
   </tr>
   </c:forEach>   
    </c:when>
   </c:choose>
</body>
</html>