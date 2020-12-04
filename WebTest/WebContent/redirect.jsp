<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로드북 홈페이지로 이동
<%
response.sendRedirect("http://www.roadbook.co.kr");
%>
</body>
</html>
<!-- 포워드 기능
하나의 서블릿에서 다른 서블릿이나 JSP와 연동하는 기법
포워드 기능의 용도
요청(request)에 대한 추가 작업을 다른 서블릿에게 수행하게함
요철(request)에 포함된 정보를 다른 서블릿이나 JSP와 공유함
요청(request)에 정보를 포함시켜 다른 서블릿에 전달할 수 있음
모델2 개발 시 서블릿에서 JSP로 데이터를 전달하는 데 사용됨
서블릿의 포워드 방법
redirect 방법
HttpServletResponse 객체의 sendRedirect() 메서드를 이용
웹 브라우저에 재요청하는 방식
형식: sendRedirect("포워드할 서블릿 또는 JSP");
Refresh 방법
HttpServletResponse 객체의 addHeader() 메서드를 이용
웹 브라우저에 재요청하는 방식
형식: response.addHeader("Refresh","경과시간(초);url=요청할 서블릿 또는 JSP");
location 방법
자바스크립트 location 객체의 href 속성을 이용
자바스크립트에서 재요청하는 방식
형식: location.href='요청할 서블릿 또는 JSP';
dispatch 방법
일반적으로 포워딩 기능을 지칭
서블릿이 직접 요청하는 방법
RequestDispatcher 클래스의 forward() 메서드를 이용
형식: RequestDispatcher
	dis = request.getRequestDispatcher("포워드할 서블릿 또는 JSP");
	dis.forward(request,response);
	
redirect 방법은 서블릿의 요청이 클라이언트의 웹 브라우저를 다시 거쳐 요청되는 방식
클라이언트의 웹 브라우저에서 첫 번째 서블릿에 요청
첫 번째 서블릿은 sendRedirect() 메서드를 이용해
두 번째 서블릿을 웹 브라우저를 통해서 요청
웹 브라우저는 sendRedirect() 메서드가 지정한 두 번째 서블릿을 다시 요청
-->