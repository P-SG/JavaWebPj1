package p201211;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginTest5")
public class LoginTest5 extends HttpServlet {
	ServletContext context = null;
	List user_list = new ArrayList();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/htnl;charset=utf-8");
		context = getServletContext(); // ServletContext 객체를 리턴한다.
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); // 세션 생성자
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		LoginImpl2 loginUser = new LoginImpl2(user_id, user_pw); // LoginImpl2 생성
		if (session.isNew()) { // 새로운 세션을 생성
			session.setAttribute("loginUser", loginUser); // 세션의 값을 loginUser로 지정
			user_list.add(user_id); // user_list에 user_id를 추가한다
			context.setAttribute("user_list", user_list); // context의 값을 user_list로 지정
		}
		out.println("<html><body>");
		out.println("아이디는 " + loginUser.user_id + "<br>");
		out.println("총 접속자수는 " + LoginImpl2.total_user + "<br><br>");
		out.println("접속 아이디:<br>");
		List list = (ArrayList) context.getAttribute("user_list"); 
		//context의 user_list값을 가져와 ArrayList로 만들고 list에 넣는다
		for (int i = 0; i < list.size(); i++) { //리스트의 길이만큼 반복한다
			out.println(list.get(i) + "<br>"); //반복문을 통해 리스트의 모든 값들을 출력
		}
		out.println("<a href='logout?user_id=" + user_id + "'>로그아웃</a>"); //로그아웃링크
		out.println("</body></html>");
	}

}
