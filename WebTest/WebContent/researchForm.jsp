<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>설문 조사</h2>
	<form action="research.jsp" method="post"> 
	<%-- submit을 눌렀을 때 research.jsp로 전송, 전송방법은 post --%>
		<table>
			<tr>
				<td>이름 :</td>
				<td><input type="text" name="name" size="20"></td>
				</tr>
				<tr>
					<td>성별 :</td>
					<td><input type="radio" name="gender" value="male"
						checked="checked">남자 
						<input type="radio" name="gender" value="female">여자</td>
						</tr>
						<tr>
							<td>좋아하는 계절 :</td>
							<td><input type="checkbox" name="season" value="1">봄
							<input type="checkbox" name="season" value="2">여름
							<input type="checkbox" name="season" value="3">가을
							<input type="checkbox" name="season" value="4">겨울 </td>
							</tr>
							<tr align="center"> <%-- 버튼위치를 center --%>
								<td><input type="submit" value="전송"></td>
								<td><input type="reset" value="취소"></td>
							</tr>
		</table>
	</form>
</body>
</html>