<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int age=Integer.parseInt(request.getParameter("age"));
if(age<=19){
%>
<script type="text/javascript">
alert("19세 미만이므로 입장 불가능")
history.go(-1) // 이전화면으로 돌아간다.
</script>
<%
}else{
	request.setAttribute("name", "박상군"); // name의 벨류를 박상군으로 지정한다.
	RequestDispatcher dispatcher // Dispatcher는 파라미터를 post타입으로 전송할때 사용한다.
	=request.getRequestDispatcher("forwardResult.jsp"); // 코드가 실행되면 리다이렉트시켜 forwardResult.jsp에 넘긴다
	dispatcher.forward(request, response); // forward에 객체를 담아서 넘겨준다
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>