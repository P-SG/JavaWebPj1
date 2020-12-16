<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
<%
   request.setCharacterEncoding("UTF-8");
%>   
<jsp:useBean id="m" class="p201215.MemberBean2"/>
<jsp:setProperty name="m" property="*"/>
<%-- ${빈이름.속성이름} --%>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table border="1"   align="center">
    <tr align="center" bgcolor="#99ccff">
       <td width="20%"><b>아이디</b></td>
       <td width="20%"><b>비밀번호</b></td>
       <td width="20%" ><b>이름</b></td>
       <td width="20%"><b>이메일</b></td>
       <td width="20%" ><b>주소</b></td>
    </tr>
	<tr align=center>
       <td><%=m.getId() %></td> <%--빈이름.get:파라미터를 받아온다 --%>
       <td><%=m.getPwd() %></td>
       <td><%=m.getName() %></td>
       <td><%=m.getEmail() %></td>
   </tr>
   <tr align="center">
   	<td>${m.id }</td> <%--EL방식 --%>
   	<td>${m.pwd }</td>
   	<td>${m.name }</td>
   	<td>${m.email }</td>
</table>
</body>
</html>
