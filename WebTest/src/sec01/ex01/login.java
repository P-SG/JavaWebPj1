package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public login() {
        super(); // 부모클래스의 생성자를 호출한다.      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("user_id"); // getParameter는 name의 값을 가져와 변수에 넣는다. 
		String pw = request.getParameter("user_pw");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // PrintWriter: 자바에서 웹으로 데이터를 출력하기 위해 사용된다.
		
		out.print("아이디= "+id);
		out.print("비밀번호= "+pw);
		out.close();
	}
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
	

}
