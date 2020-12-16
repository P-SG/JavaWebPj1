<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
\${5+2} : ${5+2} <br> <%-- 계산식 --%>
\${5/2} : ${5/2} <br>
\${5 div 2} : ${5 div 2} <br> <%-- 나누기 --%>
\${5 mod 2} : ${5 mod 2}<br> <%-- 나머지구하기 --%>
\${5 > 2} : ${5 > 2}<br>
\${2 gt 10} : ${2 gt 10}<br>
\${(5 > 2) ? 5 : 2} : ${(5 > 2) ? 5 : 2}<br>
\${(5 > 2) || (2 < 10)} : ${(5 > 2) || (2 < 10)}<br>
<%
String input=null; // input값을 null로 지정
%>
\${empty input} : ${empty input}<br> <%-- input값이 null이기 때문에 true --%>
</body>
</html>