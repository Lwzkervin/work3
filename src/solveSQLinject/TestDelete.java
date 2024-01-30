package solveSQLinject;

import utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
public class TestDelete {
    public static void main(String[] args) throws SQLException {
        //建立连接-预编译-
        Connection conn=null;
        PreparedStatement st=null;
        conn= JdbcUtils.getConnection();
        //PreparedStatement 和Statement 区别
        String sql="delete from users where id=2;";
        st=conn.prepareStatement(sql);

        //执行
        int i=st.executeUpdate();
        if(i>0) {
            System.out.println("删除成功！！");

        }
        JdbcUtils.release(conn,st,null);

    }
}
