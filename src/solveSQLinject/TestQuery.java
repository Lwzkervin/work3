package solveSQLinject;


import utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestQuery {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        conn= JdbcUtils.getConnection();
        String sql="select *from users where id=?";
        st=conn.prepareStatement(sql);
        st.setInt(1,7);//(第几个参数，参数值为多少)
        rs=st.executeQuery();
        if(rs.next()){
            System.out.println(rs.getString("name"));
        }
        JdbcUtils.release(conn,st,rs);
    }

}
