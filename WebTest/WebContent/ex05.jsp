<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	respons 객체 메소드
	getCharacterEncoding() : 응답할 때 문자 인코딩을 얻어올때
	addCookie(Cookie) : 쿠키를 지정할 때
	sendRedirect(URL) : 이동하고자 하는 URL을 지정할 때
-->
<%! int age; %>
<%
	String str = request.getParameter("age"); // age의 파라미터값을 가져와 str에 넣는다
	age = Integer.parseInt(str); // String타입의 str을 Int타입으로 변환
	if(age >= 19){ // age 가 19보다 작거나 같을경우
		response.sendRedirect("a.jsp?age="+age); // a.jsp로 가고 age의 값을 넣어준다
	}else{
		response.sendRedirect("b.jsp?age="+age); // b.jsp로 가고 age의 값을 넣어준다
	}
	%>
</body>
</html>