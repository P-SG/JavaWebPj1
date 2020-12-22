package p201221;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO11 {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public MemberDAO11() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/orcl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public List<MemberVO> listMembers() {
			List<MemberVO> membersList = new ArrayList();
			try {
				conn = dataFactory.getConnection();
				String query = "select * from t_member order by joinDate desc ";
				System.out.println("prepareStatememt: " + query);
				pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					String id = rs.getString("id"); // 각 파라미터값들을 문자열로 받아온다
					String pwd = rs.getString("pwd");
					String name = rs.getString("name");
					String email = rs.getString("email");
					Date joinDate = rs.getDate("joinDate");
					MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
					// 생성자에 각 변수를 넣어 생성
					membersList.add(memberVO); // 멤버즈리스트에 멤버VO를 추가
			}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return membersList;
		}
			public void addMember(MemberVO m) {
				try {
					conn = dataFactory.getConnection();
					String id = m.getId();
					String pwd = m.getPwd();
					String name = m.getName();
					String email = m.getEmail();
					// 멤버 빈의 각 값들을 받아온다
					String query = "insert into t_member(id, pwd, name, email)"+"VALUES(?, ?, ?, ?)"; //쿼리문을 변수에 추가
					//쿼리문을 id,pwd,name,email순으로 입력받음
					System.out.println("prepareStatememt: " + query); //콘솔창에 쿼리문 출력
					pstmt = conn.prepareStatement(query); //쿼리문을 실행
					pstmt.setString(1, id); //values의 ?에 각 값들을 넣는다
					pstmt.setString(2, pwd);
					pstmt.setString(3, name);
					pstmt.setString(4, email);
					pstmt.executeUpdate(); 
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
