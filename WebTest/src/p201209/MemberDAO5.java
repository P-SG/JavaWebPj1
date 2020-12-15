package p201209;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import ex01.MemberVO;

public class MemberDAO5 {

    private Connection con;
    private PreparedStatement pstmt;
    private DataSource dataFactory;
	/*
	 
	 - Statement 클래스의 기능 향상
	 - 인자와 관련된 작업이 특화(매개변수)
	 - 코드 안정성 높음. 가독성 높음.
	 - 코드량이 증가 -> 매개변수를 set해줘야하기 때문에..
	 - 텍스트 SQL 호출
	 
	 */

    public MemberDAO5() {
        try {
            Context ctx = new InitialContext();
            //웹로직 내부에서 JNDI를 이용할 경우
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            ////JNDI에 접근하기 위해 기본 경로(java:/comp/env)를 지정.
            // java : comp / env는 현재 Java EE 구성 요소 (웹 앱 또는 EJB)
            // 에 대한 속성을 찾을 수있는 JNDI 트리의 노드
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
            //톰캣 context.xml에 설정한 name값인 jdbc/oracle을 이용해
            //톰캣이 미리 연결한 DataSource를 받아옴.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    	public List listMembers() {
    		List list = new ArrayList();

        try {
            con = dataFactory.getConnection(); 
            //Connection - 데이터베이스와 연결하는 객체
           
            String query = "select* from t_member";
            // 질의문중 t_member 테이블의 모든 정보를 조회하는 
            // select * from 질의문을 query로 저장.
            System.out.println(query);
            // 질의문을 콘솔창으로 출력
            pstmt = con.prepareStatement(query);
            // PreparedStatement 객체
            //SQL문을 한번만 작성하고 데이터만 나중에 추가로 설정하면서 작업할 수 있는 API.
            ResultSet rs = pstmt.executeQuery(query);
            //ResultSet 클래스형 데이터 타임으로 객체 참조변수 rs를 선언하고
            //이 메소드는 ResultSet 오브젝트에서 결과 테이블을 리턴한다. 
            //결과 테이블을 가져온 후 ResultSet 메소드를 사용하여
            //결과 테이블을 통해 이동하고 각 행에서 개별 컬럼 값을 가져와야 한다..

            while(rs.next()) {
				// rs.next()는 re.next() == true 와 같은 뜻
				// rs.next()가 존재할때까지 즉, 
            	//한줄 한줄 읽어오면서 자료가 존재하면 계속 반복
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");
                //리설트셋에서 불러온 정보를 String,Data 형식으로 저장.
                
                MemberVO  vo = new MemberVO();
                //MemberVO 객체 생성
                
                vo.setId(id);
                vo.setPwd(pwd);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);
                //VO의 세터에 세팅
                list.add(vo);
                //리스트에 추가
            }
            rs.close();
            pstmt.close();
            con.close();
            //리설트셋,pstmt,커넥션 클로즈
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
        //결과가 정상일시 list 리턴.
    }


    public void addMember(MemberVO memberVO) {
        try {
            Connection con = dataFactory.getConnection();
            
            String id = memberVO.getId();
            String pwd = memberVO.getPwd();
            String name = memberVO.getName();
            String email = memberVO.getEmail();
            //MemberSerlvet에서 set된 정보들을 게터를 통해 불러온다.
            String query = "insert into t_member";
            //데이터 삽입을 위한 질의문을 따로 등록한다.
            query += "(id, pwd, name, email)";
            //삽입할 데이터들을 어떠한 열에 넣을지 정의한다.
            query += " values(?, ?, ?, ?)";
            // ?에 입력한 값들이 하나씩 들어간다.
            System.out.println("query=" + query);
            //질의문의 완성된 문장을 콘솔창에 표시한다.
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            //질의문의 ?와 대치되는 1,2,3,4열의 값들을
            //html파일에서 입력받은 값을 post로 servlet에서 넘겨받고 set한
            //데이터들을 get을 이용해 받오고 ?에 대입해 질의문에 하나씩 넣는다.
            pstmt.executeUpdate();
 		    //executeUpdate 메서드는 데이터베이스에서 데이터를 추가(Insert), 
 		    //삭제(Delete), 수정(Update)하는 SQL 문을 실행
 		    //메서드의 반환 값은 해당 SQL 문 실행에 영향을 받는 행 수를 반환
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
   
   public void delMember(String id) {
	   //servlet에서 삭제 버튼이 눌리면 servetl안에 delMember메서드에서
	   //requset.getParameter() 메서드를 이용해  id 값을 넘겨준다.
	   try {
		   con = dataFactory.getConnection();
           String query = "delete from t_member";
           //질의문 작성
           query += " where id=?";
           // 누구를 삭제하는가 
           System.out.println("prepareStatement : " + query);
           // 질의문을 보여준다.
		   pstmt = con.prepareStatement(query);
		   pstmt.setString(1, id);
		   // 첫번째 물음표에 Servlet으로 받은 id의 값을 넣는다.
		   pstmt.executeUpdate();
		   //질의문 수행
		   pstmt.close();
		   //pstmt 종료
		   
		   
	   }catch (Exception e) {
		   e.printStackTrace();
	   }
   }
   
}