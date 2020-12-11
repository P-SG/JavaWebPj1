package p201211;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do") //.do형식으로 매핑
public class TestServlet3 extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String context = request.getContextPath();
        String url = request.getRequestURL().toString();
        String mapping = request.getServletPath();
        String uri = request.getRequestURI();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Test Servlet3</title>");
        out.println("</head>");
        out.println("<body bgcolor='red'>");
        out.println("<b>TestServlet3입니다. </b><br>");
        out.println("<b>컨텍스트명 : "+context+"</b><br>");
        out.println("<b>전체경로 : "+url+"</b><br>");
        out.println("<b>매핑명 :"+mapping+"</b><br>");
        out.println("<b>URI : "+uri+"</b>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
//확장명은 지정하지 않을 수도 있고, do 대신 자신이 원하는 이름으로 지정해서 사용할 수 있음
//확장명을 do로 요청하는 경우는 일반적으로 MVC나 프레임워크에서 많이 쓰는 확장명임