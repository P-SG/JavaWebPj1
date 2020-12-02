package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Addition1")

public class Addition1 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// 직렬화와 역직렬화를 할때 사용한다. 

	public Addition1() {
		super(); // 부모클래스의 생성자를 호출한다
	}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int num1 = 20;
        int num2 = 10;
        int sum = num1 + num2;

        response.setContentType("text/html; charset=UTF-8"); // text의 타입을 html로 지정하고 UTF-8로 인코딩한다.

        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println( "<HEAD><TITLE>덧셈하기</TITLE></HEAD>");
        out.println("<BODY>");
        out.printf(num1+"+"+num2+"=" +sum);
        out.println("</BODY>");
        out.println("</HTML>");

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}

}