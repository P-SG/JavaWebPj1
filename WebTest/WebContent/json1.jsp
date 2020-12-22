<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSON 테스트</title>
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(function() {
        $("#checkJson").click(function() {
        var jsonStr  = '{"name": ["홍길동", "이순신", "임꺽정"] }';
        // key:name value:"홍길동", "이순신", "임꺽정"
        var jsonInfo = JSON.parse(jsonStr);
        //  jsonStr의 문자열을 분석하고 자바스크립트 객체를 생성한다
        var output ="회원 이름<br>"; // 문자 출력
        output += "=======<br>"; // 
        for(var i in jsonInfo.name) { // i에 jsonInfo의 name의 배열값을 반복
            output += jsonInfo.name[i]+"<br>"; // jsonInfo의 name을 배열 출력
        }
        $("#output").html(output);
      });
    });
        
</script>
  </head>
  <body>
    <a id="checkJson" style="cursor:pointer">출력</a><br><br>
    <div id="output"></div>
  </body>
</html>
