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

@WebServlet("/set")
public class SetAttribute extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SetAttribute() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String ctxMesg = "context에 바인딩 됩니다."; //문자열들을 변수에 넣는다.
        String sesMesg = "session에 바인딩 됩니다.";
        String reqMesg = "request에 바인딩 됩니다.";

        ServletContext ctx = getServletContext(); //서블릿의 컨텍스트값을 받아서 넣는다
        HttpSession session = request.getSession(); //세션값을 받아서 넣는다
        ctx.setAttribute("context", ctxMesg); // ctx의 값을 ctxMesg값으로 설정
        session.setAttribute("session", sesMesg); //session값을 sesMesg값으로 설정
        request.setAttribute("request", reqMesg); //request값을 reqMesg값으로 설정
        out.print("바인딩을 수행합니다.");

    }
}
