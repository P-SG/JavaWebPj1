package ex02_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/member3")
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
        MemberDAO3 dao = new MemberDAO3();
        PrintWriter out = response.getWriter();
        String command = request.getParameter("command");


        if(command != null && command.equals("addMember")) { // 회원을 추가한다.
            String _id = request.getParameter("id"); // 각 파라미터값들을 추가해서 변수에 넣는다.
            String _pwd = request.getParameter("pwd");
            String _name = request.getParameter("name");
            String _email = request.getParameter("email");

            MemberVO vo = new MemberVO(); //MemberVO 생성
            vo.setId(_id); //vo의 setId값을 변수값 _id로 지정한다.
            vo.setPwd(_pwd);
            vo.setName(_name);
            vo.setEmail(_email);

            dao.addMember(vo);  //dao에 vo를 추가한다.          
        }else if(command != null && command.equals("delMember")) { //회원을 삭제한다.
            String id = request.getParameter("id"); //id의 파라미터값을 가져와 변수id에 넣는다.
            dao.delMember(id); //dao에 id를 삭제한다.
        }

       List list = dao.listMembers(); //dao의 리스트를 생성한다.

       out.print("<html><body>"); //html에 테이블을 생성한다.
       out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
       out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td >삭제</td></tr>");

        for (int i=0; i<list.size(); i++) {
            MemberVO memberVO = (MemberVO)list.get(i); //반복문으로 memberVO를 생성후 list의 값을 가져온다.
            String id = memberVO.getId(); //리스트의 각 변수의 컬럼의 값들을 추가한다.
            String name = memberVO.getName();
            String pwd = memberVO.getPwd();
            String email = memberVO.getEmail();
            Date joinDate = memberVO.getJoinDate();

             out.print("<tr><td>"+id+"</td><td>" //테이블에 컬럼값들을 출력하는 html문
                        +pwd+"</td><td>"
                        +name+"</td><td>"
                        +email+"</td><td>"
                        +joinDate+"</td><td>"
                        +"<a href='/member3?command=delMember&id="+id+"'>삭제 </a></td></tr>"); //멤버를 삭제하는 html문         
        }        
         out.print("</table></body></html>");
        out.print("<a href='/memberForm.html'>새 회원 등록하기</a"); //멤버를 생성하는 html문

    }

}
