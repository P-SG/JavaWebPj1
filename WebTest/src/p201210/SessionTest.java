package p201210;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); // 이미 세션이 있다면 그 세션을 돌려주고, 세션이 없으면 null을 돌려준다.
		out.println("세션 아이디: "+ session.getId()+"<br>"); // 세션 고유의 id를 문자열로 리턴한다.
		out.println("최초 세션 생성 시각: "+ new Date(session.getCreationTime())+"<br"); //세션이 생성된 시간을 리턴한다.
		out.println("최초 세션 접근 시각: "+ new Date(session.getLastAccessedTime())+"<br"); //마지막 세션 시간을 리턴한다.
		out.println("세션 유효 시간: "+session.getMaxInactiveInterval()+"<br>"); //세션의 유효시간을 초로 반환한다.
		if(session.isNew()) { 
			out.print("새 세션이 만들어졌습니다.");
		}
		
	}
//톰캣 컨테이너의 web.xml에 세션 기본 유효 시간이 설정된 것을 확인
//<session-config>
//<session-timeout>30</session-timeout>
//</session-config>
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
