package DBtest;
 
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
 
public class DBConnection 
{
    public static Connection getConnection() throws SQLException, NamingException, 
    ClassNotFoundException{
            Context initCtx = new InitialContext();
            // 현재환경에서 naming context 획득하기
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            //DataSource 찾기
            DataSource ds = (DataSource) envCtx.lookup("jdbc/orcl");
            //Connection을  conn변수에 넣는다
            Connection conn = ds.getConnection();
            return conn; // Connection을 얻는다
    }
}


