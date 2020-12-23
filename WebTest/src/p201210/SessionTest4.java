package p201210;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/sesslogin")
public class SessionTest4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionTest4() {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doHandle(request,response);
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doHandle(request,response);
    }
    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	HttpSession session = request.getSession();
    	String user_id = request.getParameter("user_id"); //user_id의 파라미터값을 받아 user_id 변수에 넣는다.
    	String user_pw = request.getParameter("user_pw"); //user_pw의 파라미터값을 받아 user_pw 변수에 넣는다.
    	if(session.isNew()) { //세션을 새로 만들었을때
    		if(user_id != null) { //user_id가 null이 아닐경우
    			session.setAttribute("user_id", user_id); //세션에 user_id를 등록하고 아래 문자열을 출력한다.
    			out.println("<a href='sesslogin'>로그인 상태 확인</a>");
    		}else {
    			out.print("<a href='login3.html'>다시 로그인 하세요!!</a>");
    			session.invalidate(); //세션을 지운다.
    		}
    	}else {
    		user_id = (String) session.getAttribute("user_id"); //문자열 user_id로 설정된 세션값을 리턴한다.
    		if(user_id != null && user_id.length() != 0) { // user_id가 null이 아니거나 길이가 0이 아닐경우 아래 문자열을 실행
    			out.print("안녕하세요" + user_id + "님!!!");
    		} else { //맞을경우
    			out.print("<a href='login3.html'>다시 로그인 하세요!!!</a>"); //실행
    			session.invalidate(); //세션을 지운다.
    		}
    	}
    }
}
