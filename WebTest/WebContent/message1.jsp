<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 다국어 기능</title>
</head>
<body>
<fmt:setLocale value="en_US"/>
<%-- <fmt:setLocale value="ko_KR" /> --%>

<h1>
회원정보 <br><br>
<fmt:bundle basename="resource.member">
<%-- 태그 몸체에 사용할 리소스 번들 지정 --%>
이름:<fmt:message key="mem.name" /><br>
<%-- 메세지를 출력 --%>
주소:<fmt:message key="mem.address" /><br>
직업:<fmt:message key="mem.job" />
</fmt:bundle>
</h1>
</body>
</html>
<%-- 포매팅 태그 라이브러리
JSP 페이지에서 가격, 날짜, 문자열을 원하는 형식으로 표시할 수 있음
<fmt:timeZone>
<fmt:setTimeZone>
둘 다 지정한 국가의 시간을 지정하는 태그입니다. 그러나 <fmt:timeZone>
태그의 경우 태그를 열고 닫는 영역안에서만 적용된다는 차이점이 있습니다
<fmt:formatNumber> 표시할 숫자의 형식을 지정합니다.
<fmt:fomatDate> 지정한 형식의 날짜를 표시합니다.
--%>