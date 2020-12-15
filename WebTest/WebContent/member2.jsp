<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="java.util.*"
    import="p201215.*" %>
 <%
     request.setCharacterEncoding("UTF-8");
 %>
 <%
     String id = request.getParameter("id");
     String pwd = request.getParameter("pwd");
     String name = request.getParameter("name");
     String email = request.getParameter("email");

     MemberBean2 m = new MemberBean2(id, pwd, name, email);
     MemberDAO8 memberDAO = new MemberDAO8();
     memberDAO.addMember(m);
     //회원정보를 테이블에 추가합니다.
     List membersList = memberDAO.listMembers();
    //전체 회원정보를 조회합니다. 
     %>
 
 
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
  <%
      if(membersList.size()==0){
  %>
      <tr>
          <td colspan ="5">
              <p align = "center"><b><span style="font-szie:9pt;">
                          등록된 회원이 없습니다.</span></b></p>
         </td>
     </tr>

  <%
      } else{
          for(int i=0; i<membersList.size();i++){
              MemberBean2 bean = (MemberBean2) membersList.get(i);

  %>
      <tr align ="center">
          <td><%=bean.getId() %></td>
          <td><%=bean.getPwd() %></td>
          <td><%=bean.getName() %></td>
          <td><%=bean.getEmail() %></td>
          <td><%=bean.getJoinDate() %></td>
          </tr>
  <%
    } //end for
  }//end if
  %>
  <tr height = "1" bgcolor="#99ccff">
      <td colspan="5"></td>
      </tr>
  </table>
</body>
</html>