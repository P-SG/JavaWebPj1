package ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ex02.MemberVO;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver"; // 드라이버
	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // db포트설정
	private static final String user = "scott"; // db계정
	private static final String pwd = "tiger"; // db계정 비밀번호
	private Connection con; // db드라이버로 연결하기 위한 변수
	private Statement stmt; // db와의 통신을 하기 위한 변수

	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();
			String query = "select * from t_member "; // 쿼리문 작성
			System.out.println(query); // query문을 출력
			ResultSet rs = stmt.executeQuery(query); // ResultSet의 객체의 값을 반환합니다.
			while (rs.next()) {
				String id = rs.getString("id");  // id에  VO의 id값을 받습니다.
				String pwd = rs.getString("pwd"); // pwd에  VO의 pwd값을 받습니다.
				String name = rs.getString("name");  // name에  VO의 name값을 받습니다.
				String email = rs.getString("email"); // email에  VO의 email값을 받습니다.
				Date joinDate = rs.getDate("joinDate"); // joinDate에  VO의 joinDate값을 받습니다.
				MemberVO vo = new MemberVO(); // MemberVo 생성
				vo.setId(id); // vo에 id값을 저장
				vo.setPwd(pwd); // vo에 pwd값을 저장
				vo.setName(name); // vo에 name값을 저장
				vo.setEmail(email); // vo에 email값을 저장
				vo.setJoinDate(joinDate); // vo 에 joinDate값을 저장
				list.add(vo); // 리스트에 vo를 추가한다
			}
			rs.close();
			stmt.close(); 
			con.close();
		} catch (Exception e) {
			e.printStackTrace(); // 에러 발생지를 찾아 단계별로 에러를 출석
		}
		return list; // 리스트를 리턴
	}

	private void connDB() {
		try {
			Class.forName(driver); // driver의 클래스를 반환한다
			System.out.println("Oracle 드라이버 로딩 성공"); 
			con = DriverManager.getConnection(url, user, pwd); // (연결문자열, DB_ID,DB_PW) Connection 객체 생성 
			System.out.println("Connection 생성 성공"); 
			stmt = con.createStatement(); // 데이터베이스로 SQL문을 보내기 위해 사용
			System.out.println("Statement 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//* PreparedStatement 와 Statement의 가장 큰 차이점은 캐시(cache) 사용여부이다.
//1) 쿼리 문장 분석
//2) 컴파일
//3) 실행
//Statement를 사용하면 매번 쿼리를 수행할 때마다 
//1) ~ 3) 단계를 거치게 되고, PreparedStatement는 처음 한 번만 세 단계를 거친 후 
//캐시에 담아 재사용을 한다는 것이다. 만약 동일한 쿼리를 반복적으로 수행한다면 
//PreparedStatment가 DB에 훨씬 적은 부하를 주며, 성능도 좋다.
//
//1. Statement 
//String sqlstr = "SELECT name, memo FROM TABLE WHERE num = " + num 
//
//Statement stmt = conn.credateStatement(); 
//
//ResultSet rst = stmt.executeQuerey(sqlstr); 
//
//sqlstr를 실행시 결과값을 생성
//
//Statement  executeQuery() 나 executeUpdate() 를 실행하는 시점에 파라미터로 SQL문을 전달하는데, 
//이 때 전달되는 SQL 문은 완성된 형태로 한눈에 무슨 SQL 문인지 파악하기 쉽다. 
//하지만, 이 녀석은 SQL문을 수행하는 과정에서 매번 컴파일을 하기 때문에 성능상 이슈가 있다. 
//
//2. PreparedStatement 
//String sqlstr = "SELECT name, memo FROM TABLE WHERE num = ? " 
//PreparedStatement stmt = conn.prepareStatement(sqlstr); 
//pstmt.setInt(1, num);
//ResultSet rst = pstmt.executeQuerey(); 
//
//sqlstr 은 생성시에 실행
//PreparedStatement 은 이름에서부터 알 수 있듯이 준비된 Statement 이다. 
//이 준비는 컴파일(Parsing) 을 이야기하며, 컴파일이 미리 되어있는 녀석이기에 
//Statement 에 비해 성능상 이점이 있다. 
//요 녀석은 보통 조건절과 함께 사용되며 재사용이 되는데, 
//? 부분에만 변화를 주어 지속적으로 SQL을 수행하기 때문에 
//한눈에 무슨 SQL 문인지 파악하기는 어렵다.
//
//2.와 같이 이용할 경우 해당 인자만 받아서 처리하는 구조로 갈 수 있는것입니다.
//내부적으로 상세하게 뜯어 보지는 않았지만, 
//2.는 생성시 메모리에 올라가게 되므로 동일한 쿼리의 경우 인자만 달라지게 되므로, 
//매번 컴파일 되지 않아도 된다는 결론이 날듯 합니다. 
