<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="p201215.*" %>
    <!-- 유틸클래스 전체 임포트   md1215패키지의 모든 클래스파일 임포트 -->
<!DOCTYPE html>
<html>
<head>
<style>
h1 {
text-align: center;
}
</style>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<h1>회원 정보 출력</h1>
<%
	request.setCharacterEncoding("utf-8");
 //한글 인코딩
  String _name = request.getParameter("name");
 //name파라미터값을 가져오는 _name 문자열 변수
  MemberVO7 memberVO = new MemberVO7();
  memberVO.setName(_name);
  MemberDAO7 dao = new MemberDAO7();
  List membersList=dao.listMembers(memberVO);
%>
  <table border='1' width='800' align='center'>
      <tr align='center' bgcolor = '#FFFF66'>
        <td>아이디</td>
        <td>비밀번호</td>
        <td>이름</td>
        <td>이메일</td>
        <td>가입일자</td>
  </tr>
  <%
  	for (int i=0; i < membersList.size(); i++){
         MemberVO7 vo =(MemberVO7) membersList.get(i);
         String id = vo.getId();
         String pwd = vo.getPwd();
         String name = vo.getName();
         String email = vo.getEmail();
         Date joinDate=vo.getJoinDate();
  %>
     <tr align=center>
       <td><%=id %></td>
       <td><%=pwd %></td>
       <td><%=name %></td>
       <td><%=email %></td>
       <td><%=joinDate %></td>
    </tr>
  <%
   }
  %>



  </table>
</body>
</html>