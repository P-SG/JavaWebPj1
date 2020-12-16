<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
자바 코드 : <%=request.getParameter("id") %> <br> <%-- id값을 받아와 출력 --%>
EL 식 : ${param.id} <%-- el방식으로 id값을 받아와 출력 --%>
</body>
</html>