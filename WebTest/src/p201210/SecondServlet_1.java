package p201210;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet_1
 */
//@WebServlet("/SecondServlet12")
public class SecondServlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) {
		System.out.println("init 메서드 호출");
	}
	
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//한글인코딩
		response.setContentType("text/html;charset=utf-8");
		//브라우저상에 한글이 ??로 출력되지않도록 설정
		PrintWriter out = response.getWriter();
		//입출력 스트림
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		//각각의 파라미터값 가져오기
		out.println("<html><body>");
		if (user_id != null && user_id.length() != 0) {
			out.println("이미 로그인 상태입니다!<br><br>");
			out.println("첫 번째 서블릿에서 넘겨준 아이디: " + user_id + "<br>");
			out.println("첫 번째 서블릿에서 넘겨준 비밀번호: " + user_pw + "<br>");
			out.println("첫 번째 서블릿에서 넘겨준 주소: " + user_address + "<br>");
			out.println("</body></html>");
			
		}else {
			out.println("로그인 하지 않았습니다.<br><br>");
			out.println("다시 로그인하세요!!<br>");
			out.println("<a href='login_1.html'>로그인창으로 이동하기</>");
		}
		
	}
}
