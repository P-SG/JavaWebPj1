<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= request.getParameter("name") %>님 안녕하세요! <br> <%-- 이름을 출력해준다 --%>
회원님의 아이디는 <%= request.getParameter("id")%> 입니다!
</body>
</html>