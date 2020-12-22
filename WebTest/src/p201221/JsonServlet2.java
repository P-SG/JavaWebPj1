package p201221;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class JsonServlet2
 */
@WebServlet("/json2") 
public class JsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();

		JSONObject totalObject = new JSONObject(); // 제이슨 오브젝스 객체 생성
		JSONArray membersArray = new JSONArray(); // 제이슨 배열 객체 생성
		JSONObject memberInfo = new JSONObject();

		memberInfo.put("name", "박지성"); // key에 value를 넣어준다
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날쌘돌이");
        // 
		membersArray.add(memberInfo); // 제이슨 객체인 memberInfo를 배열에 저장

		memberInfo = new JSONObject(); // 새로운 제이슨 객체 생성
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "칼치");
		membersArray.add(memberInfo); // 배열에 새로운 객체 저장

		totalObject.put("members", membersArray); // totalObject에 배열을 저장

		String jsonInfo = totalObject.toJSONString(); // jsonInfo에 토탈오브젝트를 String 형식으로 저장
		System.out.print(jsonInfo); // 콘솔창에 jsonInfo를 출력
		writer.print(jsonInfo); // 화면에 jsonInfo를 출력
	}

}

