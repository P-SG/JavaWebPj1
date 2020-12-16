<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8"); 
// request방식으로 속성을 지정한다
  request.setAttribute("id", "hong");
  request.setAttribute("pwd", "1234");
  request.setAttribute("name", "홍길동");
  application.setAttribute("email", "hong@test.com"); 
  // application방식으로 속성을 지정한다
  request.setAttribute("address","서울시 서대문구");
%>    

<html>
<head>
   <meta charset="UTF-8">
   <title>forward4</title>
</head>
<body>
   <jsp:forward page="member2_7.jsp"></jsp:forward>
</body>
</html>
