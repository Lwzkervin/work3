package test;

import utils.JdbcUtils; //导入JdbcUtils工具类
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test_transaction {
    public static void main(String[] args) {
        Connection conn=null; //声明连接对象
        PreparedStatement st=null; //声明PreparedStatement对象
        ResultSet rs=null; //声明结果集对象
        try {
            conn = JdbcUtils.getConnection(); //获取数据库连接
            conn.setAutoCommit(false);//开启事务同时关闭自动提交按钮
            String sql1 = "update account set money=money-1000 where name='张三'"; //sql语句1
            st = conn.prepareStatement(sql1); //预编译sql语句1
            st.executeUpdate(); //执行sql语句1

            String sql2 = "update account set money=money+1000 where name='李四'"; //sql语句2
            st = conn.prepareStatement(sql2); //预编译sql语句2
            st.executeUpdate(); //执行sql语句2

            //事务结束，提交
            conn.commit();
            System.out.println("事务执行成功！！");
        }catch (SQLException  e){
            try{conn.rollback();} //发生异常时回滚所有操作
            catch (SQLException e1){e1.printStackTrace();}
        }

    }
}

