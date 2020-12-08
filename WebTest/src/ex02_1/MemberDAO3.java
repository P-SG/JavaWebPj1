package ex02_1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO3 {

   private Connection con;
   private PreparedStatement pstmt;
   private DataSource dataFactory;
   
   public MemberDAO3() {
      try {
         Context ctx = new InitialContext();
         Context envContext = (Context) ctx.lookup("java:/comp/env"); //JNDI에 접근하기 위해 기본 경로(java:/comp/env)를 지정한다.
         
         dataFactory = (DataSource) envContext.lookup("jdbc/orcl");
       //톰캣 context.xml에 설정한 name값인 jdbc/orcl을 이용해 DataSource를 받아온다.
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   public List<MemberVO> listMembers() {
       List<MemberVO> list = new ArrayList<MemberVO>();
      try {
         //connDB();
         con=dataFactory.getConnection(); //  커넥션 풀
         String query = "select * from t_member";
         System.out.println(query);
         pstmt = con.prepareStatement(query); //prepareStatement()에 SQL문을 전달해 PrepareStatement 객체를 생성한다.
         ResultSet rs = pstmt.executeQuery(); //executeQuery()를 호출해 미리 지정한 SQL문을 실행한다.
         
         while(rs.next()) {
            String id = rs.getString("id"); // 각 컬럼의 값들을 가져온다.
            String pwd = rs.getString("pwd");
            String name = rs.getString("name");
            String email = rs.getString("email");
            Date joinDate = rs.getDate("joinDate");
            MemberVO vo= new MemberVO();
            vo.setId(id);
            vo.setPwd(pwd);
            vo.setName(name);
            vo.setEmail(email);
            vo.setJoinDate(joinDate); // 각 컬럼의 값들을 vo에 넣는다.
            list.add(vo); //vo를 list에 추가한다.
            
         }
         rs.close();
         pstmt.close();
         con.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
      return list;
   }
   
   public void addMember(MemberVO memberVO) { //멤버를 추가하는 함수
      try {
    	  Connection con = dataFactory.getConnection();
          String id = memberVO.getId();
          String pwd = memberVO.getPwd();
          String name = memberVO.getName();
          String email = memberVO.getEmail();
          String query = "insert into t_member";

          query += "(id, pwd, name, email)"; // 쿼리문에 값들을 추가시킨다.
          query += " values(?, ?, ?, ?)";
          System.out.println("query=" + query); 

          pstmt = con.prepareStatement(query); //prepareStatement()에 SQL문을 전달해 PrepareStatement 객체를 생성한다.
          pstmt.setString(1, id); //해당 필드의 타입이 문자열이라 setString 사용
          pstmt.setString(2, pwd);
          pstmt.setString(3, name);
          pstmt.setString(4, email);
          pstmt.executeUpdate(); //executeQuery()를 호출해 미리 지정한 SQL문을 실행한다.
          pstmt.close();
         
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   public void delMember(String id) { //멤버를 삭제하는 함수
	   try {
           con = dataFactory.getConnection();            
           String query = "delete from t_member" + " where id=?"; // 쿼리문 작성
           System.out.println("prepareStatement=" + query); 
           pstmt = con.prepareStatement(query); //prepareStatement()에 SQL문을 전달해 PrepareStatement 객체를 생성한다.
           pstmt.setString(1, id); //해당 필드의 타입이 문자열이라 setString 사용
           pstmt.executeUpdate(); //executeQuery()를 호출해 미리 지정한 SQL문을 실행한다.
           pstmt.close();
         
         
      }catch (Exception e) {
         e.printStackTrace();
      }
   }
   
}
