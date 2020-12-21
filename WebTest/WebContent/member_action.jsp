<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*,p201216.*"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
   	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:useBean id="m" class="p201216.MemberBean3"/>
<jsp:setProperty name="m" property="*"/>
<%
MemberDAO9 memDAO = new MemberDAO9(); //멤버 다오 객체 생성
memDAO.addMember(m); //멤버다오에 멤버빈 m을 추가
List membersList = memDAO.listMembers(); //리스트를 생성하고 다오의 리스트멤버즈를 추가
request.setAttribute("membersList", membersList); //값을 멤버즈리스트로 설정
%>
</head>
<body>
<jsp:forward page="membersList.jsp"/> <%-- membersList.jsp로 forward로 전달 --%>
</body>
</html>