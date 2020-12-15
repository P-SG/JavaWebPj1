package p201215;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO7 {

    private Connection con;
    private PreparedStatement pstmt;
    private DataSource dataFactory;

    public MemberDAO7() {
        try {
            Context ctx = new InitialContext();
            //웹로직 내부에서 JNDI를 이용할 경우
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            ////JNDI에 접근하기 위해 기본 경로(java:/comp/env)를 지정.
            // java : comp / env는 현재 Java EE 구성 요소 (웹 앱 또는 EJB)
            // 에 대한 속성을 찾을 수있는 JNDI 트리의 노드
            dataFactory = (DataSource) envContext.lookup("jdbc/orcl");
            //톰캣 context.xml에 설정한 name값인 jdbc/oracle을 이용해
            //톰캣이 미리 연결한 DataSource를 받아옴.
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    
    	public List listMembers(MemberVO7 memberVO) {
    		List memberList = new ArrayList();
    		String _name=memberVO.getName();
        try {
            con = dataFactory.getConnection(); 
            String query = "select * from t_member ";
            
            if((_name!=null && _name.length()!=0)) { //_name이 null이 아니고 길이가 0이 아닐때
            	query+="where name=?"; //쿼리문을 넣고
            	pstmt = con.prepareStatement(query); //db를 연동하고 쿼리문을 본낸다
            	pstmt.setString(1, _name); // ?에 _name을 넣는다
            }else {
            	pstmt = con.prepareStatement(query); 
            }
            System.out.println("prepareStatement: "+query); //쿼리문 콘솔창에 출력
            ResultSet rs = pstmt.executeQuery(); //
            while(rs.next()) {//next함수로 넘어갈 행이 있으면 다음행으로 넘어간다
            	String id = rs.getString("id"); //id의 문자열을 불어와 id에 저장
            	String pwd = rs.getString("pwd");
            	String name = rs.getString("name");
            	String email = rs.getString("email");
            	Date joinDate = rs.getDate("joinDate");
            	MemberVO7 vo = new MemberVO7(); //멤버VO 생성
            	vo.setId(id); //vo의 id값을 변수 id로 셋팅
            	vo.setPwd(pwd);
            	vo.setName(name);
            	vo.setEmail(email);
            	vo.setJoinDate(joinDate);
            	memberList.add(vo); //멤버리스트에 vo를 추가한다
            }
            rs.close();
            pstmt.close();
            con.close();
        }catch (Exception e) {
 		   e.printStackTrace();
 	   }
        return memberList;
    	}
    }