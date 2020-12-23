package p201207;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/first6")
public class FirstServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FirstServlet6() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("type/html;charset=utf-8");
		request.setAttribute("address", "서울시 강남구 논현동");
		RequestDispatcher dispatcher = request.getRequestDispatcher("second6");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
