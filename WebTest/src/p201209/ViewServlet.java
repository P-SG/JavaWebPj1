package p201209;

import ex01.MemberVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setCharacterEncoding("utf-8");        
          response.setContentType("text/html;charset=utf-8");
          PrintWriter out = response.getWriter();    

          List membersList = (List) request.getAttribute("membersList");
          //멤버 리스트를 getAttribute를 통해 넘겨 받음.

          out.print("<html><body>");
          out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
          out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td >삭제</td></tr>");

          for(int i=0; i < membersList.size(); i++) {
        	  // 멤버 리스트만큼 반복문 수행 
        	  
              MemberVO memberVO = (MemberVO) membersList.get(i);
              String id = memberVO.getId();
              String pwd = memberVO.getPwd();
              String name = memberVO.getName();
              String email = memberVO.getEmail();
              Date joinDate = memberVO.getJoinDate();
              //vo에 셋된 내용들을 get으로 받아와 String 변수로 저장 
			out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>"
		               + joinDate + "</td><td>" + "<a href='member2?command=delMember&id=" + id
		               ////삭제를 클릭하면 command 값과 회원 ID를 서블릿으로 전송합니다.
		               + "'> 삭제 </a></td><tr>");
		}
		
		out.print("</table></body></html>");
		out.print("<a href='memberForm.html'>새 회원 등록하기</a>");
		}
		
	}



