package p201209;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/cset")
public class SetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SetServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		
		List member = new ArrayList();
		member.add("이순신");
		member.add(30);
		context.setAttribute("member", member);
		
		out.print("<html><body>");
		out.print("이순신과 30 설정");
		out.print("</body></html>");
		
	}



}
