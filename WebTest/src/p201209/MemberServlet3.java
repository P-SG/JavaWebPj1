package p201209;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/mem")
public class MemberServlet3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        MemberDAO5 dao = new MemberDAO5();        
        List memberList = dao.listMembers();

        request.setAttribute("membersList", memberList);
        // MemberDAO5에 있는 listMembers() 호출
        // 에트리뷰트에 memeberList()를 키와 벨류로 setAttribute
        
        RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
        dispatch.forward(request, response);
        //디스패치에 memberList를 실어 디스패처를 통해
        //포워드 방식으로 viewMembers에 정송

    }

}