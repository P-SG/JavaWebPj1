package p201215;


import java.util.Date;

public class MemberBean2 {
    private String name; // 이름을 저장할 필드 선언
    private String id; // 아이디를 저장할 필드 선언
    private String pwd; // 비밀번호를 저장할 필드 선언
    private String email; // 이메일을 저장할 필드 선언
    private Date joinDate; // 전화번호를 저장할 필드 선언

    public MemberBean2() {

    }

    public MemberBean2(String id, String pwd, String name, String email) {
        this.id = id; //this를 사용해 매개변수를 변수로 사용
        this.pwd = pwd;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }


}