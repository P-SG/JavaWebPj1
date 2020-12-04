<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%-- 지시자 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!String str= "안녕하세요!"; // 선언부 : 변수나 메서드 선언시 사용
	int a = 5, b = -5;
	
	public int abs(int n) {
		if (n < 0) {
			n = -n;
		}
		return n;
	}%>
	<% // 스크립틀릿
		out.print(str + "<br>");
		out.print(a + "의 절대값 : " + abs(a) + "<br>");
		out.print(b + "의 절대값 : " + abs(b) + "<br>");
	%>

</body>
</html>