package p201203;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/loginTest")
public class LoginTest extends HttpServlet{
	public void init() {
		System.out.println("init 메서드 호출");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("doGet 메서드 호출");
					}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException{
		request.setCharacterEncoding("utf-8"); // 문자 인코딩 방식을 utf-8로 지정
		response.setContentType("text/html;charset=utf-8"); // content타입을 html로 지정하고 인코딩 방식을 utf-8로 지정
		String id = request.getParameter("user_id"); // user_id의 파라미터 값을 불러온다
		String pw = request.getParameter("user_pw"); // user_pw의 파라미터 값을 불러온다
		PrintWriter out = response.getWriter(); // 응답에 PrintWriter로 출력하게 해준다.
		System.out.println("아이디 : "+id); // 불러온 user_id 값을 출력
		System.out.println("비밀번호 : "+pw); // 불러온 user_pw 값을 출력
		
		if(id!= null && (id.length()!=0)) { // id가 null이 아니거나 id의 길이가 0이 아닐경우 아래 문자열 출력
			out.print("<html>");
			out.print("<body>");
			out.print(id+" 님!! 로그인 하셨습니다.");
			out.print("</body>");
			out.print("</html>");
		}else { // 맞을 경우 아래 문자열을 출력, 로그인창으로 다시 돌아간다
				out.print("<html>");
				out.print("<body>");
				out.print("아이디를 입력하세요!!!");
				out.print("<br>");
				out.print("<a href='http://localhost:8080/Jst_Test/test01/login.html'>로그인창으로 이동");
				// server.xml의 path값을 수정하여 login.html로 되돌아간다.
				out.print("</body>");
				out.print("</html>");
			}
		}
		public void destroy() {
			System.out.println("destroy 메서드 호출");
		}
	}


