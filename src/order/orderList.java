package order;

import utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class orderList {

    // 订单列表启动类
    public static void main(String[] args) {

        Connection conn = null;

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;

        // 根据商品编码左关联查询商品的名称
        String sql = "select o.code,o.itemid,i.name,o.price,o.ctime from `order` o LEFT JOIN item i ON o.itemid = i.id";

        try {
            // 连接到数据库并创建Statement对象
            conn = JdbcUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            // 执行查询语句
            rs = preparedStatement.executeQuery();
            System.out.println("=============================================订单列表===============================================");
            System.out.println("订单编号 \t\t商品编码 \t\t商品名称 \t\t订单价格 \t\t下单时间");
            // 获取查询的值
            while (rs.next()) {
                //  打印数据
                System.out.println(rs.getString("code")
                        +" \t\t"+rs.getString("itemid")
                        +"\t\t\t\t"+rs.getString("name")
                        +"  \t\t"+rs.getString("price")
                        +" \t\t"+rs.getString("ctime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭数据库
            JdbcUtils.release(conn,preparedStatement,rs);
        }
    }

}
