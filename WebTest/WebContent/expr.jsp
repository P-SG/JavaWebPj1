<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%-- 지시자 --%>

<%!String str= "안녕하세요!"; // 선언부 : 변수나 메서드 선언시 사용
	int a = 5, b = -5;
	
	public int abs(int n) {
		if (n < 0) {
			n = -n;
		}
		return n;
	}%>
	<%!int global_cnt=0; %> <%-- 전역변수 --%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=str %><br> <%-- 표현식: 자바의 out.println()과 같은 역할 --%>
	<%=a %>
	의 절대값 :
	<%=abs(a) %><br>
	<%=b %>
	의 절대값 :
	<%=abs(b) %><br>
	
	<%-- 간단한 인삿말 출력하기 --%>
	<%-- 인삿말을 String 변수에 저장한다. --%>
	<% String name="Angel"; %>
	Hello <%= name %><br>
	
<%
Calendar date=Calendar.getInstance(); // getInstance로 캘린더 생성자를 만든다.
SimpleDateFormat today=new SimpleDateFormat("yyyy년 MM월 dd일"); 
SimpleDateFormat now=new SimpleDateFormat("hh시 mm분 ss초");
%> <%-- SimpleDateFormat() 안에 출력될 date형식을 지정하여 현재날짜를 불러온다.  --%>
오늘은 <b> <%= today.format(date.getTime()) %></b> 입니다. <br>
지금 시각은 <b> <%= now.format(date.getTime()) %></b> 입니다.

	<%
		int local_cnt = 0; // 지역변수
		out.print("<br> local_cnt : ");
		out.print(++local_cnt);
		out.print("<br> global_cnt : ");
		out.print(++global_cnt);
	%><br>
<%
int count=0;
out.print("count : ");
out.println(++count); // 변수 값 1증가
%>
</body>
</html>