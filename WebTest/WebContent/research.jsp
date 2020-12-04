<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
b {
	font-size: 16pt;
}
</style>
</head>
<body>
	<h2>설문 조사 결과</h2>
<% 
	request.setCharacterEncoding("utf-8"); // 인코딩 방식은 utf-8
	String name = request.getParameter("name"); // name의 파라미터값을 받아서 name에 저장
	out.println("이름: <b>"+name+"</b><br>"); // 이름출력 - 여기서 <b>는 bold로 문자를 굵게 표시해줌
	String gender = request.getParameter("gender"); // gender의 파라미터값을 받아 gender에 저장
	out.println("성별: ");
	if(gender.equals("male")) { // gender가 male일 경우
		out.println("<b>남자</b><br>"); // 남자라는 문자 출력
	}else {
		out.println("<b>여자</b><br>"); // 아닐경우 여자라는 문자 출력 
	}
	String seasonArr[] = request.getParameterValues("season"); // season의 벨류값들을 받아 seasonArr[]의 배열에 저장
	out.println("당신이 좋아하는 계절은 ");
	for(String season : seasonArr) { // 반복문: season에 seasonArr의 값들을 반복해서 리스트로 만들어 넣는다
		int n = Integer.parseInt(season); // 정수형 변수 n 생성후 season변수를 int형으로 형변환하여 n에 넣는다
		switch (n) { // 조건문 switch 
		case 1: out.println("<b> 봄 </b>입니다."); // 1번일때 출력
		break; // 조건을 종료한다
		case 2: out.println("<b> 여름 </b>입니다."); // 2번일때 출력
		break; // 조건을 종료한다
		case 3: out.println("<b> 가을  </b>입니다."); // 3번일때 출력
		break; // 조건을 종료한다
		case 4: out.println("<b> 겨울  </b>입니다."); // 4번일때 출력
		break; // 조건을 종료한다
		}
	}
%>
<br>
<b><a href='javascript:history.go(-1)'>다시</a></b> <%-- history함수는 페이지 이동시 사용 go(-1)은 이전페이지로 이동 --%>
</body>
</html>