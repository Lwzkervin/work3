package test;

import utils.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class TestInsert {
    public static void main(String[] args) {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        try{
            conn= JdbcUtils.getConnection();
            st=conn.createStatement();
            String sql="insert into item  (id, name, price) VALUES (3,'applepine',6)";
            int i=st.executeUpdate(sql);
            if(i>0){
                System.out.println("插入成功！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}