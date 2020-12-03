function check() {
	if(document.frm.id.value == "") {
		alert("아이디를 입력해주세요.");
		document.frm.id.focus();
		// focus: 해당 요소에 포커스를 부여하여 텍스트 창의 커서를 위치시켜 바로 입력이 가능하게 한다.
		return false;
	} else if (document.frm.age.value == "") {
		alert("나이를 입력해주세요.");
		document.frm.id.focus();
		return false;
	} else if (isNaN(document.frm.age.value)) { // isNaN: 매개변수가 숫자인지 확인하는 함수
		alert("숫자로 입력해주세요.");
		document.frm.id.focus(); 
		// focus: 해당 요소에 포커스를 부여하여 버튼에 엔터키를 눌렀을때 클릭 효과를 낸다.
		return false;
	} else {
		return true;
	}
}