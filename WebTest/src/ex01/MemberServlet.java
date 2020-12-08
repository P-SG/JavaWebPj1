package ex01;

import jsp.member.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex02.MemberVO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
                                                    throws ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out=response.getWriter();	
      MemberDAO dao=new MemberDAO(); // MemberDAO 생성자
      List<MemberVO> list=dao.listMembers(); // MemberVO를 리스트로 만들고 dao의 멤버들을 불러온다
	  
      out.print("<html><body>");
      out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
      out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
      
      for(int i=0; i<list.size();i++){ // 반복문을 사용하여 list의 사이즈만큼 리스트를 만든타
		MemberVO memberVO=(MemberVO) list.get(i); // MemberVO를 만들고 list에 i를 넣는다.
		String id=memberVO.getId(); // memberVO의 Id를 불러온다
		String pwd=memberVO.getPwd(); // memberVO의 Pwd를 불러온다
		String name=memberVO.getName(); // memberVO의 Name를 불러온다
		String email=memberVO.getEmail(); // memberVO의 Email를 불러온다
		Date joinDate = memberVO.getJoinDate(); // memberVO의 JoinDate를 불러온다
		out.print("<tr><td>"+id+"</td><td>"+  // 테이블을 생성하는 print
			                pwd+"</td><td>"+
			                name+"</td><td>"+
			                email+"</td><td>"+
			                joinDate+"</td></tr>");		
      }
      out.print("</table></body></html>");
   }
}