<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.lang.Integer" %>
<%@ page import="java.lang.Math" %>
<%@ page import="java.lang.Number" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정수를 순서대로</title>
</head>
<body>
	<h3>정수를 순서대로</h3>
	<%
		String str = request.getParameter("MAX");
		int max = Integer.parseInt(str);
		for(int cnt=1; cnt <= max; cnt++)
			out.println(cnt+"<br>");		
		%>
</body>
</html>