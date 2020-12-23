package p201203;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/input")
public class InputServlet extends HttpServlet {
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		request.setCharacterEncoding("utf-8"); //
		Enumeration enu=request.getParameterNames(); // request의 name값들을 enumeration으로 받아온다
		while(enu.hasMoreElements()) { 
			String name=(String)enu.nextElement(); // enu의 다음 요소를 (String)으로 형변환하여 반환한다
			String[] values=request.getParameterValues(name); //name의 value값들을 불러와 values에 담는다
			for(String value:values) { //반복문 for를 사용하여 values의 값들을 순차적으로 value에 넣는다
				System.out.println("name="+name+",value="+value); // name과 value의 값이 같이 나오게 한다
			}
		}
	}
public void destroy() {
	System.out.println("destroy 메서드 호출");
}
}
//서블릿의 응답처리 방법
//doGet()이나 doPost() 메서드 안에서 처리함
//javax.servlet.http.HttpServletResponse 객체를 이용함
//setContentType()을 이용해 클라이언트에게 전송할 데이터 종류(MIME-TYPE)를 지정함
//클라이언트(웹 브라우저)와 서블릿의 통신은 자바 I/O의 스트림을 이용함
//MIME-TYPE
//톰캣 컨테이너에 미리 지정해 놓은 데이터 종류로 서블릿에서 브라우저 전송 시 설정해서 사용함
//예>
//HTML로 전송시: text/html
//일반 텍스트로 전송 시: text/plain
//XML 데이터로 전송 시: application/xml

//HttpServletResponse를 이용한 서블릿 응답 실습 대략적인 순서
//1.setContentType()을 이용해 MIME-TYPE 지정
//2.데이터를 출력할 PrintWriter 객체 생성
//3.출력데이터를 HTML형식으로 만듬
//4.PrintWriter 의 print() 나 println()을 이용해 데이터를 출력한다


