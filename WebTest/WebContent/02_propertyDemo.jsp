<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html><head><meta charset=UTF-8">
<title>자바 빈 프로퍼티 값 얻고 변경(getProperty, setProperty 액션 태그)</title>
</head>
<body>
<jsp:useBean id="member" class="p201215.MemberBean"/> <!-- 유즈빈 액션 태그 사용 -->
<hr>
◎ 자바 빈 객체 생성 후 저장된 정보 출력하기 <br><br>
이름 : <jsp:getProperty name="member" property="name" /> <br> <!-- 유즈빈의 속성값을 불러온다 -->
아이디 : <jsp:getProperty name="member" property="userid" />
<hr>
◎ 정보 변경한 후 변경된 정보 출력하기 <br><br>
<jsp:setProperty name="member" property="name" value="박변경이"/> <!-- 유즈빈의 속성값을 변경한다 -->
<jsp:setProperty name="member" property="userid" value="pinkblue"/>
이름 : <jsp:getProperty name="member" property="name" /> <br>
아이디 : <jsp:getProperty name="member" property="userid" />
</body></html>