package p201218;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxTest2")
public class AjaxTest2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AjaxTest2() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }
    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String result = "";
        PrintWriter writer = response.getWriter();
        result="<main><book>"+
                "<title><![CDATA[자바 프로그래밍]]></title>"+
                "<writer><![CDATA[저 | 박샘이]]></writer>"+
                "<image>![CDATA[http://localhost:8080/WebTest/image/image1.jpg]]"+
                "</image>"+"</book>"+ "<book>"+"<title><![CDATA[모두의 파이썬]]></title>"
                +"<writer><![CDATA[길벗 저 |주니샘]]></writer>"+"<image>![CDATA[http://localhost:8080/WebTest/image/image2.jpg]]"
                +"</image>"+"</book></main>"; //result에 메세지를 저장
        /* CDATA
    CDATA로 감싼 javascript 부분이 의도치않게 XML 
    Parser에 의해 잘못 인식되는 것을 막기 위해
    XHTML이 아닌 HTML로 인식되는 경우에도 
    javascript가 문제 없이 동작하도록 하기 위해*/
            System.out.println(result);
            writer.print(result);
    }

}
