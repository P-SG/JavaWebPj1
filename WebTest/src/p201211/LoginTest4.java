package p201211;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/LoginTest4")
public class LoginTest4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginTest4() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pw); // LoginImpl 생성자
		if(session.isNew()) { //새로운 세션 생성
			session.setAttribute("loginUser",loginUser); //세션의 값을 loginUser로 지정
		}
		out.println("<head>");
		out.println("<script type='text/javascript'>");
		out.println("setTimeout('history.go(0);',5000"); 
		//5초가 지나면 history.go함수를 실행, 여기서 history.go(0)은 페이지를 리로드함
		out.println("</script>");
		out.println("</head>");
		out.println("<html><head>");
		out.println("아이디는 "+ loginUser.user_id + "<br>");
		out.println("총 접속자수는 "+LoginImpl.total_user + "<br>");
		out.println("</body></html>");
	}

}

