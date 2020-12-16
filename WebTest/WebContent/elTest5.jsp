<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.util.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
    
<jsp:useBean  id="m1"  class="p201215.MemberBean2" scope="page"  /> <%-- 유즈빈 생성 --%>
<jsp:setProperty  name="m1"  property="name" value="이순신"/> <%-- 빈의 name에 속성을 "이순신"으로 설정 --%>
<jsp:useBean  id="m2"  class="java.util.ArrayList" scope="page"  /> <%-- ArrayList를 빈으로 생성 --%>

<html>
<head>
   <meta charset="UTF-8">
   <title>표현언어의 여러 가지 연산자들</title>
</head>
<body>
   empty 연산자
 <h2>
   \${empty m1 } : ${empty m1 } <br> <%-- m1의 name에 속성이 있으므로 false --%>
   \${not empty m1 } : ${not empty m1 } <br><br>

   \${empty m2 } : ${empty m2 } <br> <%-- m2는 비어있으므로 true --%>
   \${not empty m2} : ${not empty m2 } <br><br>

   \${empty "hello"} : ${empty "hello" }<br> <%-- 문자열에 대해 false를 반환 --%>
   \${empty null} : ${empty null } <br> <%-- null은 true --%>
   \${empty ""} : ${empty "" } <br> <%-- 빈문자열 true --%>
</h2>
</body>
</html>
