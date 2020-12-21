package p201218;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem4")
public class MemberServlet4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MemberServlet4() {
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
        PrintWriter writer = response.getWriter();
        
        String id = (String) request.getParameter("id");
        System.out.println("id= "+id);
        MemberDAO10 memberDAO = new MemberDAO10();
        boolean overlappedID = memberDAO.overlappedID(id);
        
        if(overlappedID == true) {
        	writer.print("not_usable");
        }else {
        	writer.print("usable");
        }
}
}