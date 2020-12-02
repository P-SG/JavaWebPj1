package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet{
	public void init() throws ServletException {
		System.out.println("ThirdServlet init 메소드 호출"); // 요청시 맨 처음만 호출됩니다
	}
	protected void doGet(HttpServletRequest req,
	HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ThirdServlet doGet 메소드 호출"); //요청시 호출됩니다
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		System.out.println("ThirdServlet destroy 메소드 호출");
	}
}
//애너테이션을 이용한 서블릿 매핑 시는 반드시 extends HttpServlet 상속받아야 한다
//web.xml에 여러 서블릿 매핑 설정 시 복잡해짐.
//따라서 서블릿 클래스에 직접 애너테이션으로 서블릿명을 설정하면 가독성이 좋아짐.
//@WebSerbvlet