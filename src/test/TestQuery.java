package test;

import utils.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class TestQuery {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        conn= JdbcUtils.getConnection();
        st=conn.createStatement();
        //sql
        String sql="select * from users";
        rs=st.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
    }
}
