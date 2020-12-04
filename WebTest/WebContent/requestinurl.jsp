<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
컨텍스트 패스 : <%= request.getContextPath() %> <br> <%-- 컨텍스트패스를 확인한다 (ContextPath: 웹 애플리케이션을 구분하기 위한 Path--%>
요청방식 : <%= request.getMethod() %> <br> <%-- 요청방식을 확인한다 --%>
요청한 URL : <%=request.getRequestURL() %> <br> <%-- URL을 확인한다 --%>
요청한 URI : <%= request.getRequestURI() %> <br> <%-- URI을 확인한다 --%>
서버의 이름 : <%= request.getServerName() %> <br> <%-- 서버이름을 확인한다 --%>
프로토콜 : <%= request.getProtocol() %> <br> <%-- 프로토콜을 확인한다 --%>
</body>
</html>