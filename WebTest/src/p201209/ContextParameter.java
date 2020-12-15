package p201209;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/initMenu")
public class ContextParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ContextParameter() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		
		out.print("<html><body>");
		out.print("<table border = 1 cellspacing=0><tr>메뉴이름</tr>");
		out.print("<tr><td>" + menu_member + "</td></td>");
		out.print("<tr><td>" + menu_order + "</td></td>");
		out.print("<tr><td>" + menu_goods + "</td></td>");
		out.print("</table></body></html>");
		
		
	}
}
