package p201203;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheckboxServlet() {
        super();     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); // 출력 문자타입html 인코딩방식 UTF-8
		PrintWriter out = response.getWriter(); // PrintWriter메서드로 브라우저에 출력한다
		out.print("<html><body>"); 
		String items[] = request.getParameterValues("item"); // item의 파라미터 값들을 가져와 items[] 배열에 넣어준다.
		if (items == null) { // items가 null값일 경우 선택학 항목이 없다는 문자열 출력
		out.print("선택한 항목이 없습니다."); 
		} else { // null값이 아닐경우
		out.println("당신이 선택한 항목입니다.<hr>"); // 문자열과 items의 값들을 반복문을 통해 item에 저장하여 값들을 출력한다. 
		for (String item : items) {
		out.print(item + " ");
		}
		}
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>"); // 자바스크립트의 history 메서드는 이전 페이지로 이동시켜준다.
		out.print("</body></html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}


