package item;


import utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class ItemList {

    // 商品列表启动类
    public static void main(String[] args) {

        Connection conn = null;

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;

        String sql = "select id,name,price from item";

        try {
            // 连接到数据库并创建Statement对象
            conn = JdbcUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            // 执行查询语句
            rs = preparedStatement.executeQuery();
            System.out.println("===========商品列表=============");
            System.out.println("商品编码 商品名称 商品价格");
            // 获取查询的值
            while (rs.next()) {
                //  打印数据
                System.out.println(" \t"+rs.getString("id")
                        +" \t"+rs.getString("name")
                        +" \t"+rs.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭数据库
            JdbcUtils.release(conn,preparedStatement,rs);
        }
    }

}