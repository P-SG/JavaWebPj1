<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*,p201215.*"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="p201215.MemberBean2" scope="page"></jsp:useBean> <!-- 유즈빈 액션태그 사용 -->
<jsp:setProperty name="m" property="*" />
<!-- 전송된 매개변수 이름과 빈 속성을 비교한 후 동일한 빈에 값을 자동으로 설정한다 -->
<%
MemberDAO8 memberDAO=new MemberDAO8();
memberDAO.addMember(m); //멤버다오에 멤버빈의 값들 추가
List membersList = memberDAO.listMembers();//리스트를 추가하는 메서드 호출
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
          for(int i=0; i<membersList.size();i++){ //for문을 이용해서 멤버빈의 리스트를 출력한다
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