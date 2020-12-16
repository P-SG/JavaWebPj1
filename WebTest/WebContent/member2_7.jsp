<%@page import="p201215.MemberBean2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  %>
<%
   	request.setCharacterEncoding("UTF-8");
	pageContext.setAttribute("address", "서울시 강서구");
%>  
<%-- session에서 바인딩한 주소가 출력되는 것을 확인할 수 있습니다 --%>

<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table border="1"   align="center">
    <tr align="center" bgcolor="#99ccff">
       <td width="7%"><b>아이디</b></td>
       <td width="7%"><b>비밀번호</b></td>
       <td width="5%" ><b>이름</b></td>
       <td width="5%"><b>이메일</b></td>
       <td width="5%"><b>주소</b></td>
    </tr>
	<tr align=center>
      	<td>${id }</td>
      	<td>${pwd }</td>
      	<td>${name }</td>
      	<td>${email }</td>
      	<td>${address }</td>
   </tr>
   
</table>
</body>
</html>