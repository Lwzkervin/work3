package order;

import utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class orderDelete {

    // 订单删除启动类
    public static void main(String[] args) {

        Connection conn = null;

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;

        String sql = "delete from `order` where code = ?";

        // 订单编号
        String code = "1706622061039";

        try {
            // 连接到数据库并创建Statement对象
            conn = JdbcUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setObject(1,code);
            int i =  preparedStatement.executeUpdate();
            System.out.println(i>0?"删除成功":"删除失败,请检查订单编号是否正确");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭数据库
            JdbcUtils.release(conn,preparedStatement,rs);
        }
    }

}
