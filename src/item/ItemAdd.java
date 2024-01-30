package item;


import utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class ItemAdd {

    // 商品新增启动类
    public static void main(String[] args) {

        Connection conn = null;

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;

        String sql = "insert into `item`(id,name,price) values (? ,? ,? )";

        String sql1 = "select id from item where name = ?";

        // 新增的数据
        String id = "5";
        String name = "荔枝";
        String price = "10";

        try {
            // 连接到数据库并创建Statement对象
            conn = JdbcUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql1);
            preparedStatement.setObject(1,name);
            // 新增之前先判断是否存在相同的id
            rs = preparedStatement.executeQuery();
            String id1 = "";
            while (rs.next()) {
                id1 = rs.getString("id");
            }
            if(!"".equals(id1)){
                System.out.println("商品名称已存在！");
            }else{
                preparedStatement = conn.prepareStatement(sql);
                // 配置新增数据
                preparedStatement.setObject(1,id);
                preparedStatement.setObject(2,name);
                preparedStatement.setObject(3, price);

                // 执行SQL 操作
                int i =  preparedStatement.executeUpdate();
                System.out.println(i>0?"插入成功":"插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭数据库
            JdbcUtils.release(conn, preparedStatement,rs);
        }
    }

}
