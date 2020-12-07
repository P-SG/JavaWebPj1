package p201207;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first4")
public class FirstServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FirstServlet4() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("location.href='second4';"); // location은 url값으로 화면을 전환시켜준다.
		out.print("</script>");
	
	}
// 자바스크립트 location 객체의 href 속성을 이용
// 자바스크립트에서 재요청하는 방식
// 형식: location.href='요청할 서블릿 또는 JSP';
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
