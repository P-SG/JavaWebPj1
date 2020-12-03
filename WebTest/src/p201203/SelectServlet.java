package p201203;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SelectServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String job = request.getParameter("job"); // job의 파라미터 정보를 가져온다
        String interests[] = request.getParameterValues("interest"); // interest의 벨류값들을 불러와 interests의 배열에 넣는다
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.println("당신이 선택한 직업 : <b>");
		out.print(job); 
		out.println("</b><hr>당신이 선택한 관심 분야 : <b>");
		if(interests == null) { // interests가 null값일 경우 선택한 항목이 없다는 메시지를 표시하고
								// null값이 아닐경우 interests의 값들을 반복문을 통해 interest로 값들을 출력한다
			out.print("선택한 항목이 없습니다.");
		}else {
			for(String interest : interests) {
				out.print(interest + " ");
			}
		}
		out.print("</b><br><a href='javascript:history.go(-1)'>다시</a>");
		out.print("</body></html>");
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
