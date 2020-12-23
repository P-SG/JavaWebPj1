package p201211;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/first/test")
public class TestServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        String context = request.getContextPath(); //컨텍스트의 주소를 받아온다
        String url = request.getRequestURL().toString(); //URL의 주소를 받아와 문자열로 변환한다
        String mapping = request.getServletPath(); //서블릿의 주소를 받아온다
        String uri = request.getRequestURI(); //URI의 주소를 받아온다
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Test Servlet1</title>");
        out.println("</head>");
        out.println("<body bgcolor='green'>");
        out.println("<b>TestServlet1입니다.</b><br>");
        out.println("<b>컨텍스트명 : " + context + "</b><br>");
        out.println("<b>전체경로 : " + url + "</b><br>");
        out.println("<b>매핑명 : " + mapping + "</b><br>");
        out.println("<b>URI : " + uri + "<b>");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }


}
