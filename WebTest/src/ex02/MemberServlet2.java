package ex02;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member2")
public class MemberServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
                                                    throws ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out=response.getWriter();	
      // out 생성
      MemberDAO2 dao=new MemberDAO2();
      //다오 객체 만든다.
      List list=dao.listMembers();
      //list 맴버스를 가진 객체를 생성한다
	
      out.print("<html><body>");
      out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
      out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
     
     for (int i=0; i<list.size();i++){
    	 // 리스트 출력 포문
		MemberVO memberVO=(MemberVO) list.get(i);
		//리스트를 가져온다.
		String id=memberVO.getId();
		//아이디를 가져온다.
		String pwd = memberVO.getPwd();
		//비밀번호를 가져온다.
		String name=memberVO.getName();
		//이름을 가져온다.
		String email=memberVO.getEmail();
		//메일을 가져온다.
		Date joinDate = memberVO.getJoinDate();
		//날짜를 가져온다.
		out.print("<tr><td>"+id+"</td><td>"+
			                pwd+"</td><td>"+
			                name+"</td><td>"+
			                email+"</td><td>"+
			                joinDate+"</td></tr>");	
		//테이블로 출력한다.
      }
      out.print("</table></body></html>");
   }
}