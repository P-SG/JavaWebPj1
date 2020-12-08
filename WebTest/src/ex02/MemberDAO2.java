package ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO2 {
	
//	private static final String driver= "oracle.jdbc.driver.OracleDriver";
//	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//	private static final String user ="scott";
//	private static final String pwd = "tiger";  //더 이상 사용되지 않으므로 주석처리.
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	//private Statement stmt;

	public MemberDAO2() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env"); //JNDI에 접근하기 위해 기본 경로(java:/comp/env)를 지정한다.
			dataFactory = (DataSource)envContext.lookup("jdbc/orcl"); 
			//톰캣 context.xml에 설정한 name값인 jdbc/orcl을 이용해 DataSource를 받아온다.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listMembers() {
		List list = new ArrayList();
		try {
			//connDB(); //네가지 정보로 데이터베이스를 연결한다.
			con = dataFactory.getConnection(); //DataSource를 이용해 데이터베이스에 연결한다.
			String query = "select * from t_member ";  //쿼리문 작성
			System.out.println(query);
			//ResultSet rs = stmt.executeQuery(query); //SQL문으로 회원 정보 조회
			pstmt = con.prepareStatement(query); //prepareStatement()에 SQL문을 전달해 PrepareStatement 객체를 생성한다.
			ResultSet rs = pstmt.executeQuery(); //executeQuery()를 호출해 미리 지정한 SQL문을 실행한다.
			
			while(rs.next()) {
				String id = rs.getString("id"); //조회한 각 컬럼의 값들을 가져온다.
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate"); 
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate); //각 컬럼 값을 다시 MemberVO에 넣는다.
				list.add(vo); //설정된 MemberVO 객체를 다시 ArrayList에 넣는다.
			}
			
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list; //조회한 레코드의 개수만큼 MemberVO객체를 저장한 ArrayList를 반환한다.
	}
	
	
//	private void connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("Oracle 드라이버 로딩 성공");
//			con = DriverManager.getConnection(url, user, pwd);
//			System.out.println("Connection 생성 성공");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

}