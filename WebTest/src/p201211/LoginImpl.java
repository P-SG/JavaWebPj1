package p201211;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class LoginImpl implements HttpSessionBindingListener {
	String user_id; 
	String user_pw;
	static int total_user = 0;
	
    public LoginImpl() {
    }
    
    public LoginImpl(String user_id, String user_pw) {
    	this.user_id = user_id; //매개변수에 전역변수 user_id를 넣는다
    	this.user_pw = user_pw; //매개변수에 전역변수 user_pw를 넣는다
    }
    
    @Override
    public void valueBound(HttpSessionBindingEvent arg0) {
    	System.out.println("사용자 접속");
    	++total_user;
    }
    
    @Override
    public void valueUnbound(HttpSessionBindingEvent arg0) {
    	System.out.println("사용자 접속 해제");
    	total_user--;
    }

}
