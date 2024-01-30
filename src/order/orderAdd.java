package order;

import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class orderAdd {

    // 订单新增启动类
    public static void main(String[] args) {

        Connection conn = null;

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;

        String sql = "insert into `order`(id,code,itemid,price,ctime) values (? ,? ,? ,? ,? )";

        String sql1 = "select name, price from item where id = ?";

        // 新增的数据
        String code = String.valueOf((new Date()).getTime()); // 当前时间戳做编码
        String itemid = "5"; // 商品编码


        try {
            // 连接到数据库并创建Statement对象
            conn = JdbcUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql1);
            preparedStatement.setObject(1,itemid);


            // 新增之前先判断是否存在id
            rs = preparedStatement.executeQuery();

            String name1 = "";
            String price = "";
            while (rs.next()) {
                name1 = rs.getString("name");
                price = rs.getString("price");
            }
            if("".equals(name1)){
                System.out.println("商品编码不存在，添加订单失败！");
            }else{
                preparedStatement = conn.prepareStatement(sql);
                // 配置新增数据
                preparedStatement.setObject(1,null);
                preparedStatement.setObject(2,code);
                preparedStatement.setObject(3,itemid);
                preparedStatement.setObject(4, price);
                preparedStatement.setObject(5, new Date());

                // 执行SQL 操作
                int i =  preparedStatement.executeUpdate();
                System.out.println(i>0?"添加订单成功":"添加订单失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭数据库和ResultSet对象
            JdbcUtils.release(conn,preparedStatement,rs);
        }
    }

}
