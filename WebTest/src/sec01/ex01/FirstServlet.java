package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/aaa")
public class FirstServlet extends HttpServlet{
	public void init() throws ServletException {
		System.out.println("init 메소드 호출"); // 요청시 맨 처음만 호출됩니다
	}
	protected void doGet(HttpServletRequest req,
	HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메소드 호출"); //요청시 호출됩니다
	}
	public void destroy() { // 메모리에서 소멸될 때 호출됩니다
		System.out.println("destroy 메소드 호출");
	}
}

//서블릿 매핑하기
//http://주소:포트번호/프로젝트명/패키지명이 포함된 클래스명
//왜 하지? 클래스 이름이 길어지거나 보안에도 안좋아서
//서블릿 클래스에 대응하는 서블릿 매핑 이름으로 요청한다
//서블릿 매핑 방법
//각 프로젝트에 있는 web.xml에서 설정
//<servlet> 태그와 <servlet-mapping> 태그를 이용함.
//여러 개의 서블릿 매핑 시에는 <servlet> 태그를 먼저 정의하고
//<servlet-mapping> 태그를 정의함
