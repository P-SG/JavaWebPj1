package p201203;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginTest2")
public class LoginTest2 extends HttpServlet {
	public void init() {
		System.out.println("init 메서드 호출");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException{
		request.setCharacterEncoding("utf-8"); // 문자 인코딩 방식을 utf-8로 지정
		response.setContentType("text/html;charset=utf-8"); // content타입을 html로 지정하고 인코딩 방식을 utf-8로 지정
		String id = request.getParameter("user_id"); // user_id의 파라미터 값을 불러온다
		String pw = request.getParameter("user_pw"); // user_pw의 파라미터 값을 불러온다
		PrintWriter out = response.getWriter(); // 응답에 PrintWriter로 출력하게 해준다.
		System.out.println("아이디 : "+id); // 불러온 user_id 값을 출력
		System.out.println("비밀번호 : "+pw);
		
		if(id!=null && (id.length()!=0)) {
			if(id.contentEquals("admin")) {
				out.print("<html>");
				out.print("<body>");
				out.print("<font size='12'>관리자로 로그인 하셨습니다!! </font>");
				out.print("<br>");
				out.print("<input type=button value='회원정보 수정하기'>");
				out.print("<input type=button value='회원정보 삭제하기'>");
				out.print("</body>");
				out.print("</html>");		
			}else {
				out.print("<html>");
				out.print("<body>");
				out.print(id+" 님!! 로그인 하셨습니다.");
				out.print("</body>");
				out.print("</html>");
			}
		}else {
			out.print("<html>");
			out.print("<body>");
			out.print("ID와 비밀번호를 입력하세요!!!");
			out.print("<br>");
			out.print("<a href='http://localhost:8080/login.html'> 로그인창으로 이동");
			out.print("</body>");
			out.print("</html>");
		}
	}
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
