<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>셀렉트</title>
</head>
<body>
	<form method="get" action="SelectServlet"> <!-- 전송방식은 get이고 SelectServlet을 로 요청한다 -->
		<span style="float: left; margin-right: 20px"> <!-- 좌측에 배치하고 오른쪽 여백을 20px준다 -->
		<label for="job">직업</label>
			<select id="job" name="job" size="1"> 
				<option value="">선택하세요</option>
				<option value="학생">학생</option>
				<option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
				<option value="언론">언론</option>
				<option value="공무원">공무원</option>
				<option value="군인">군인</option>
				<option value="서비스업">서비스업</option>
				<option value="교육">교육</option>
			</select></span>
			<label for="interest" style="float: left;">관심분야</label> <!-- 좌측에 배치 -->
			<select id="interest" name="interest" size='5' multiple="multiple"> <!-- multiple:해당 속성을 선택하지 않으면 자동으로 false값을 가지게 된다. -->
				<option value="핸드드립">핸드드립</option>
				<option value="로스팅">로스팅</option>
				<option value="생두">생두</option>
				<option value="원두">원두</option>
				<option value="핸드드립">핸드드립</option>
			</select><br><br>
			<input type="submit" value="전송" style="float: tight; margin-right: 50px"> <!-- 좌측에 배치하고 오른쪽 여백을 50px준다 -->
	</form>
</body>
</html>