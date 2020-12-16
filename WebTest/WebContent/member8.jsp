<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*,p201215.*"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="p201215.MemberBean2" scope="page"></jsp:useBean> <!-- 유즈빈 액션태그 사용 -->
<jsp:setProperty name="m" property="*" />

<!-- null로 나오는 이유? -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록창</title>
</head>
<body>
  <table width='100%' align='center'>
      <tr align='center' bgcolor = '#99ccff'>
        <td width="7%">아이디</td>
        <td width="7%">비밀번호</td>
        <td width="5%">이름</td>
        <td width="11%">이메일</td>
        <td width="5%">가입일</td>
  </tr>
      <tr align="center">
          <td> <jsp:getProperty property="id" name="m"/> </td>
          <td> <jsp:getProperty property="pwd" name="m"/> </td>
          <td> <jsp:getProperty property="name" name="m"/> </td>
          <td> <jsp:getProperty property="email" name="m"/> </td>
          </tr>
          <tr height="1" bdcolor="#99ccff">
          <td colspan="5"></td>
          </tr>
  </table>
</body>
</html>