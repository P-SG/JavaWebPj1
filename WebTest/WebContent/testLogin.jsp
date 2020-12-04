<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id="park"; // id값 park으로 지정
String pwd="1234"; // pwd값 park으로 지정
String name="박상군"; // name값 박상군으로 지정, 보낼값
request.setCharacterEncoding("utf-8"); // 인코딩방식 utf-8
if(id.equals(request.getParameter("id")) && // 로그인폼의 id값을 받아 변수인 id와 값을 비교
	pwd.equals(request.getParameter("pwd"))) { // 로그인폼의 pwd값을 받아 변수인 pwd와 값을 비교
	response.sendRedirect("main2.jsp?name="+ // redirect로 main2.jsp에 utf-8로 인코딩 하여 name의 값을 보낸다 
	URLEncoder.encode(name,"utf-8")+"&id="+id); // 여러 값을 보내려면 &을 붙여서 값을 추가해준다.
}else{
	response.sendRedirect("loginForm.jsp"); // 위의 id와 pwd 값이 일치하지 않을 경우 로그인폼으로 되돌아간다.
}
%>
</body>
</html>