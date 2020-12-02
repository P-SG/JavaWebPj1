package sec01.ex01;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class input extends HttpServlet {
           
	public void init() throws ServletException {
		System.out.println("init 메소드 호출"); // 요청시 맨 처음만 호출됩니다
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("user_id"); // 변수 id user_id의 파라미터를 가져와 넣는다
		String pw = request.getParameter("user_pw");
		String[] sj = request.getParameterValues("subject"); // sj에 subject의 벨류 값들을 가져와 넣는다
		response.setContentType("text/html; charset=UTF-8");			
		System.out.println("아이디= "+id);
		System.out.println("비밀번호= "+pw);
		System.out.println("선택한 과목= "+Arrays.toString(sj)); // 배열을 문자열로 표현한다.
		System.out.close();
	}
	public void destroy() {
		System.out.println("destroy 메서드 호출"); // 요청시 맨 마지막에만 호출된다.
	}
	

}
