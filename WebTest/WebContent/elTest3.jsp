<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>

<html>
<head>
   <meta charset="UTF-8">
   <title>여러가지 비교 연산자</title>
</head>
<body>
   <h2>여러가지 비교 연산자</h2><h3>
   ${10==10} : ${10==10 }<br>
   ${10 eq 10} : ${10 eq 10}<br><br>
   ${"hello"=="hello"} : ${"hello"=="hello"}<br>
   ${"hello" eq "hello"} : ${"hello" eq "hello"}<br><br>
<%-- 문장열이 서로 같은지 비교할때는 == 나 eq를 연산자로 사용한다. --%>
   ${20 != 10} : ${20 != 10}<br>
   ${20 ne 10} : ${20 ne 10}<br><br>
   ${"hello"!="apple"} :  ${"hello" != "apple"}<br><br>
   ${"hello" ne "apple"} : ${"hello" ne "apple"}<br><br>
<%--문자열이 서로 다른지 비교할때는 !=나 ne를 연산자로 사용한다. --%>
   ${10 < 10} : ${10 < 10}<br>
   ${10 lt 10} : ${10 lt 10}<br>
   ${100 > 10} : ${100 > 10}<br>
   ${100 gt 10} : ${100 gt 10}<br>
   ${100 <= 10} : ${100 <= 10}<br>
   ${100 le 10} : ${10 le 10}<br>
   ${100 >= 10} : ${100 >= 10}<br>
   ${100 ge 10} : ${100 ge 10}<br>
   </h3>
<%--  ne 에러를 없애려면 프로젝트탭 -> 프로퍼티스 -> 자바빌트패스탭 - > 라이브러리탭- > add라이브러리 -> 서버런타임
    -> 톰캣9.0설정
 $가 있어야  $가 문자로 화면에 출력됩니다.
        중요함${} : JSP가 실행될때 즉시 반영 된다. 꺼 낼떄 (객체의 프로퍼티 값을 get할때 주로 사용)
        중요함#{} : 시스템에서 필요하다고 판단될 때 값을 사용한다 담을 때 (객체의 프로퍼티의 값을 set할때 주로 사용)
    1) 산술연산자 : + - * / (div) % (mod) 
    2) 논리연산자 : &&(and) ||(or) !(not) 
    3) 관계연산자 : ==(eq) !=(ne) <(lt) >(gt) <=(le) >=(ge)
    4) 삼항연산자 : ?:
    예) ${colors == null ? "transparent" : colors} --%>
   </body>
</html>