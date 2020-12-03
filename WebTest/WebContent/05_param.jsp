<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿</title>
<script type="text/javascript" src="param.js"></script> <!-- param.js파일을 불러온다 -->
</head>
<body>
<form method="get" action="ParamServlet" name="frm"> <!-- 전송방식은 get ParamServlet으로 전송한다. -->
아이디 : <input type="text" name="id"><br>
나 &nbsp; 이 : <input type="text" name="age"><br> <!-- &nbsp는 웹페이지의 공백을 나타낸다. -->
<input type="submit" value="전송" onclick="return check()">
</form>
</body>
</html>