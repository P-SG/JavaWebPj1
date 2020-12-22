package p201221;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p201221.MemberDAO11;

//@WebServlet("/mem.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberDAO11 memberDAO;

    public MemberController() {
        super();
    }
    
    public void init() throws ServletException {
    	memberDAO = new MemberDAO11(); //멤버다오 생성자
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<MemberVO> membersList = memberDAO.listMembers(); //멤버다오의 리스트멤버즈를 멤버즈리스트에 저장
		request.setAttribute("membersList", membersList); // 리퀘스트값을 멤버즈 리스트로 설정
		RequestDispatcher dispatch = request.getRequestDispatcher("listMembers.jsp"); //listMembers.jsp에 보낸다
		dispatch.forward(request, response);
	}

}
