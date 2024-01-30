package solveSQLinject;

import utils.JdbcUtils;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement st=null;
        conn= JdbcUtils.getConnection();
        //PreparedStatement 和Statement 区别
        String sql="insert into users(id, name, password, email,birthday) VALUES (?,?,?,?)";
        st=conn.prepareStatement(sql);
        //手动给参数赋值
        st.setInt(1,6);
        st.setString(2,"lwz");
        st.setString(3,"213");
        st.setString(4,"456465@.com");

        //注意点：sql.data  数据库
        st.setDate(5,new java.sql.Date(new Date().getTime()));
        //执行
        int i=st.executeUpdate();
        if(i>0) {
            System.out.println("插入成功");

        }
        JdbcUtils.release(conn,st,null);

    }
}
