package p201210;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieValue
 */
@WebServlet("/getcookie")
public class GetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//브라우저상에 한글이 ??로 출력되지않도록 설정
		PrintWriter out = response.getWriter();
		Cookie[] allValues=request.getCookies();
		//쿠리를 배열로 저장
		for(int i=0; i<allValues.length;i++) {
			if(allValues[i].getName().contentEquals("cookieTest")) {
				out.println("<h2>Cookie 값 가져오기 : "
				+URLDecoder.decode(allValues[i].getValue(),"utf-8"));
				//SetCookieValue에 저장된 쿠키값 출력
			}
		}
	}


}
