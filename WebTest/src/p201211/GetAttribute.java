package p201211;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAttribute() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext(); //서블릿의 컨텍스트값을 받아온다
		HttpSession sess = request.getSession(); //세션값을 받아온다
		
		String ctxMesg = (String) ctx.getAttribute("context"); //ctx의 context값을 받아온다.
		String sesMesg = (String) sess.getAttribute("session"); //sess의 session값을 받아온다.
		String reqMesg = (String) request.getAttribute("request"); //request의 request값을 받아온다.
		
		out.print("context값 : "+ ctxMesg + "<br>");
		out.print("session값 : "+ sesMesg + "<br>");
		out.print("request값 : "+ reqMesg + "<br>");
	}
}