<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   	<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드창</title>
</head>
<body>
	<form action="${contextPath }/upload.do" method="post"
	<%-- 보낼주소와 매핑명, 보낼방식 지정 --%>
	enctype="multipart/form-data">
	<%-- 폼 데이터가 서버로 갈때 인코딩되는 방식 설정, method가 post일 경우에만 사용가능 --%>
	파일1: <input type="file" name="file1"><br>
	파일2: <input type="file" name="file2"><br>
	파라미터1: <input type="text" name="param1"><br>
	파라미터2: <input type="text" name="param2"><br>
	파라미터3: <input type="text" name="param3"><br>
	<input type="submit" value="업로드">
	</form>
</body>
</html>