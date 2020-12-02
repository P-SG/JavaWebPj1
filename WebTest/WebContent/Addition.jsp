<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addition</title>
</head>
<body>
<%
int num1 = 20;
int num2 = 10;
int add = num1 + num2;
%>
<%= num1 %> + <%= num2 %> = <%= add %> 
</body>
</html>
<!-- %=은 함수의 결과값을 출력할때 사용한다. -->