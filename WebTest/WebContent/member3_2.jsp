<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*,p201216.*"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="membersList" class="java.util.ArrayList"/>
<jsp:useBean id="membersMap" class="java.util.HashMap"/>
<%
membersMap.put("id","park2"); // 해쉬맵을 이용해 벨류값을 저장
membersMap.put("pwd","4321"); 
membersMap.put("name","박지성");
membersMap.put("email","park2@test.com");
MemberBean3 m1 = new MemberBean3("son","1234","손흥민","son@test.com");
//멤버 빈으로 값 들을 저장
MemberBean3 m2 = new MemberBean3("ki","4321","기성용","ki@test.com");
	membersList.add(m1); //멤버즈리스트에 멤버빈 추가
	membersList.add(m2);
	membersMap.put("membersList",membersList); //멤버즈맵에 멤버즈 리스트 값을 추가
%>
<c:set var="membersList" value="${membersMap.membersList }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table border="1"  align="center" >
    <tr align="center" bgcolor="lightgreen">
      <td width="20%"><b>아이디</b></td>
      <td width="20%"><b>비밀번호</b></td>
      <td width="20%" ><b>이름</b></td>
      <td width="20%"><b>이메일</b></td>
   </tr>
   <tr align="center">
      <td>${membersMap.id }</td>
      <td>${membersMap.pwd }</td>
      <td>${membersMap.name }</td>
      <td>${membersMap.email }</td>
   </tr> 
   <tr align="center">
      	<td>${membersMap.membersList[0].id }</td>
      	<td>${membersMap.membersList[0].pwd }</td>
      	<td>${membersMap.membersList[0].name }</td>
      	<td>${membersMap.membersList[0].email }</td>
   </tr>
   <tr align=center>
      	<td>${membersMap.membersList[1].id }</td>
      	<td>${membersMap.membersList[1].pwd }</td>
      	<td>${membersMap.membersList[1].name }</td>
      	<td>${membersMap.membersList[1].email }</td>
   </tr>  
</table>
</body>
</html>