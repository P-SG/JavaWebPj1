package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/bbb")
public class SecondServlet extends HttpServlet{
	public void init() throws ServletException {
		System.out.println("init 메소드 호출>>>>"); // 요청시 맨 처음만 호출됩니다
	}
	protected void doGet(HttpServletRequest req,
	HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메소드 호출>>>>"); //요청시 호출됩니다
	}
	public void destroy() { // 메모리에서 소멸될 때 호출됩니다
		System.out.println("destroy 메소드 호출>>>>");
	}
}