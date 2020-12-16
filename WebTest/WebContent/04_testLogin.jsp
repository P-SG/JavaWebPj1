<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
당신이 입력한 정보입니다(고전적인 방식). <hr>
아이디 : <%= request.getParameter("id")%> <br> <%-- id의 파라미터값을 불러온다 --%>
비밀번호 : <%= request.getParameter("pwd")%> <br><br> <%-- pwd의 파라미터값을 불러온다 --%>
당신이 입력한 정보입니다(EL 방식). <hr>
아이디 : ${param.id} <br> <%-- el방식으로 param을 이용해 id값을 받아온다 --%>
비밀번호 : ${param["pwd"]}
</body>
</html>