package p201203;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class IoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("utf-8"); // 문자열 인코딩을 utf-8로 변환
		response.setContentType("text/html;charset=utf-8"); // text타입을 html 인코딩방식을 utf-8
		PrintWriter out = response.getWriter(); 
		String id = request.getParameter("user_id"); // user_id의 파라미터 값을 가져온다
		String pw = request.getParameter("user_pw"); // user_pw의 파라미터 값을 가져온다
		
		String data = "<html>"; // String 형식의 변수 data에 "<html>" 입력
		data += "<body>"; // data 변수에 += 을 사용하여 값들을 추가 시켜준다
		data += "아이디: "+id;
		data += "<br>";
		data += "비밀번호 : "+pw;
		data += "</html>";
		data += "</body>";
		out.print(data); // data를 출력한다
	}
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
