package p201214;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/Sess01")
public class SessionTest01 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); 
		HttpSession session = request.getSession(); // 세션 객체 생성
		session.setAttribute("name", "이순신"); // 세션의 name값을 "이순신"으로 설정
		
		out.println("<html><body>");
		out.println("<h1>세션에 이름을 바인딩합니다.</h1>");
		out.println("<a href='session1.jsp'>첫번째 페이지로 이동하기</a>");
		out.println("</body></html>");
	}

}
