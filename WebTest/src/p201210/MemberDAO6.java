package p201210;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO6 {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO6() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/orcl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List listMembers() {
		List list = new ArrayList(); // 배열 list 생성
		try {
			// connDB();
			con = dataFactory.getConnection(); //데이터 베이스에 연결
			String query = "select * from t_member "; //쿼리문 생성
			System.out.println("prepareStatememt: " + query); //쿼리문 출력
			pstmt = con.prepareStatement(query); //쿼리문 실행 (빠른대신 재사용 불가)
			ResultSet rs = pstmt.executeQuery(); // select 구문을 수행할 때 사용된다.
			while (rs.next()) { // 다음 데이터로 넘어갈때
				String id = rs.getString("id"); // 각 컬럼의 값들을 가져와 변수에 넣는다.
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO(); //MemberVO를 생성
				vo.setId(id); //vo에 각 값들을 추가한다.
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo); //list에 vo를 추가한다.
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) { //오류가 발생하지 않으면 list를 리턴
			e.printStackTrace();
		}
		return list;
	}

	public void addMember(MemberVO memberVO) {
		try {
			Connection con = dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			String query = "insert into t_member";
			query += " (id,pwd,name,email)";
			query += " values(?,?,?,?)";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delMember(String id) {
		try {
			Connection con = dataFactory.getConnection();
			Statement stmt = con.createStatement();
			String query = "delete from t_member" + " where id=?";
			System.out.println("prepareStatememt:" + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isExisted(MemberVO memberVO) {
		boolean result = false;
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		try {
			con = dataFactory.getConnection();
			String query = "select decode(count(*),1,'true','false') as result from t_member";
			// 검색된 행의 갯수가 1일때 true 아닐경우 false
			query += " where id=? and pwd=?"; //id와 pwd값을 확인한다.
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id); //id 값을 설정
			pstmt.setString(2, pwd); //pwd 값을 설정
			ResultSet rs = pstmt.executeQuery();
			rs.next(); //커서를 첫번째 레코드로 위치시킵니다.
			result = Boolean.parseBoolean(rs.getString("result")); //result값을 boolean타입으로 변경
			System.out.println("result=" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
