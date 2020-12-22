package p201222;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO12 memberDAO;

	public void init() throws ServletException {
		memberDAO = new MemberDAO12();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo(); //리퀘스트의 경로를 받아 action에 저장
		System.out.println("action:" + action);
		if (action == null || action.equals("/listMembers.do")) { //action이 null이고 listMembers.do일 경우
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/listMembers.jsp"; // 다음 페이지에 listMembers.jsp로 넘긴다
		} else if (action.equals("/addMember.do")) { //action이 addMember.do일 경우
			String id = request.getParameter("id"); //각 파라미터 값들을 변수에 저장하고
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email); 
			//멤버VO에 변수값들을 넣고 객체를 생성
			memberDAO.addMember(memberVO); //멤버다오에 멤버VO를 추가
			request.setAttribute("msg", "addMember"); //리퀘스트값을 키:msg 벨류:addMember로 설정
			nextPage = "/member/listMembers.do"; 
		} else if (action.equals("/memberForm2.do")) { //action이 memberForm2.do일경우
			nextPage = "/memberForm2.jsp"; //다음 페이지로 memberForm2.jsp로 넘긴다
		} else if (action.equals("/modMemberForm.do")) {
			String id = request.getParameter("id"); //id의 파라미터 값을 가져와
			MemberVO memInfo = memberDAO.findMember(id); //멤버다오의 id값의 멤버정보를 불러와 멤버VO에 저장
			request.setAttribute("memInfo", memInfo); //리퀘스트의 값들을 memInfo로 설정
			nextPage = "/modMemberForm.jsp"; //다음 페이지를 modMemberForm.jsp로 넘긴다
		} else if (action.equals("/modMember.do")) { 
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.modMember(memberVO);
			request.setAttribute("msg", "modified");
			nextPage = "/member/listMembers.do";
		} else if (action.equals("/delMember.do")) {
			String id = request.getParameter("id");
			memberDAO.delMember(id); //id값으로 멤버를 삭제
			request.setAttribute("msg", "deleted");
			nextPage = "/member/listMembers.do"; //listMembers.do로 돌아간다
		} else {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/listMembers.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}