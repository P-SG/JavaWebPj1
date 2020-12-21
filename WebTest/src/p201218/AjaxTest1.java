package p201218;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxTest1")
public class AjaxTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doHandler(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doHandler(request, response);
	    }

	    private void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8"); 
	        response.setContentType("text/html; charset=utf-8");
	        String param = (String) request.getParameter("param");
	        System.out.println("param= "+param);
	        PrintWriter writer = response.getWriter();
	        writer.print("서버입니다."); //웹에서 메세지를 출력
	    }
}