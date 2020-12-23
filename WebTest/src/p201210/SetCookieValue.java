package p201210;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieValue
 */
//@WebServlet("/setcookie")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//브라우저상에 한글이 ??로 출력되지않도록 설정
		PrintWriter out = response.getWriter();
		Date d = new Date();
		Cookie c = new Cookie("cookieTest",
				//cookieTest라는이름의 쿠키객체 생성 
				//한글을 표현할 수 있도록 utf-8 데이터형식으로 처리하여 "JSP프로그래밍입니다" 값설정
				URLEncoder.encode("JSP프로그래밍입니다.", "utf-8"));
		c.setMaxAge(24 * 60 * 60);
		//c.setMaxAge(-1); //세션 쿠기를 생성합니다.
		response.addCookie(c);
		//쿠키를 추가한다.
		out.print("현재시간 : " + d);
		out.println("<br> 문자열을 Cookie에 저장합니다.");
	}

}
