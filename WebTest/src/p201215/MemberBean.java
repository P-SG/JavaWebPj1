package p201215;

public class MemberBean {
	private String name; // 이름을 저장할 필드 선언
	private String userid; // 아이디를 저장할 필드 선언
	private String nickname; // 별명을 저장할 필드 선언
	private String pwd; // 비밀번호를 저장할 필드 선언
	private String email; // 이메일을 저장할 필드 선언
	private String phone; // 전화번호를 저장할 필드 선언
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
