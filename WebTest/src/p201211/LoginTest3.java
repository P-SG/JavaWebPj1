package p201211;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/LoginTest3/*")
public class LoginTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginTest3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");
		// post 방식으로 한글전송시 인코딩을 생략한다.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_name = request.getParameter("user_name"); //user_name의 파라미터값을 받아온다
		String user_pw = request.getParameter("user_pw"); //user_pw의 파라미터값을 받아온다
		out.println("<html><body>");
		out.println("이름은 "+user_name+"<br>");
		out.println("비밀번호는 "+user_pw+"<br>");
		out.println("</body></html>");
	}

}
