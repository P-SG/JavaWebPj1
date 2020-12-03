package p201203;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ParamServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			String id = request.getParameter("id");
			int age = Integer.parseInt(request.getParameter("age")); // age의 파라미터값을 불러와 parseInt로 int형으로 형변환시킨다
			PrintWriter out = response.getWriter();
			out.print("<html><body>");
			out.println("당신이 입력한 정보입니다.<br>");
			out.println("아 이 디 : ");
			out.println(id);
			out.println("<br> 나이 : ");
			out.println(age);
			// 자바스크립트로 이전 페이지로 이동하는 링크를 만들어줌
			out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
			// history: 브라우저의 현재 페이지를 불러온 탭이나 프레임의 방문기록을 조작한다.
			// go메서드는 -1로 바로 뒤의 페이지로 이동한다.(history.back() 메서드와 같은 효과를 준다.)
			out.print("</body></html");
			out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
