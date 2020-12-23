package p201210;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/loginservlet4")
public class LoginServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet4() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	private void doHandle (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		  MemberVO memberVO = new MemberVO();
	        //받아온 아이디와 비밀번호 설정
	        memberVO.setId(user_id);
	        memberVO.setPwd(user_pw);
	        MemberDAO6 dao = new MemberDAO6();
	        //MemberDAO6의 isExisted메소드 호출, memverVO전달
	        boolean result = dao.isExisted(memberVO);
	        //result값을 dao의 isExisted함수를 호출하여 매개변수를 memberVO로 설정
	        dao.listMembers(); //dao에 listMembers를 추가


	        if(result) {
	            HttpSession session = request.getSession(); // 세션을 생성한다.
	            session.setAttribute("isLogon", true); //세션 값에 isLogon을 true로 지정
	            session.setAttribute("login_id", user_id); //세션 값에 login_id를 user_id로 지정
	            session.setAttribute("login_pwd", user_pw); //세션 값에 login_pw를 user_pw로 지정
	            
	            out.print("<html><body>");
	            out.print("아이디: "+user_id+"<br>");
	            out.print("비밀번호: "+user_pw+"<br>");
	            out.print("</body></html>");
	        }else {
	        	out.print("<html><body>회원 아이디가 틀립니다.");
	        	out.print("<a href='login4.html'>다시 로그인하기</a>");
	        	out.print("</body></html>");
	        }
		}
		
	}


