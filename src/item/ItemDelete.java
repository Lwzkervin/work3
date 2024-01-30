package item;


import utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class ItemDelete {

    // 商品删除启动类
    public static void main(String[] args) {

        Connection conn = null;

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;

        String sql = "delete from `item` where id = ?";

        String sql1 = "select code from `order` where itemid = ?";

        // 新增的数据
        String code = "5";

        try {
            // 连接到数据库并创建Statement对象
            conn = JdbcUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql1);
            preparedStatement.setObject(1,code);
            // 新增之前先判断是否存在相同的CODE
            rs = preparedStatement.executeQuery();
            String code1 = "";
            while (rs.next()) {
                code1 = rs.getString("code");
            }
            if(!"".equals(code1)){
                System.out.println("该商品的订单已存在，不能删除！");
            }else{
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setObject(1,code);
                int i =  preparedStatement.executeUpdate();
                System.out.println(i>0?"删除成功":"删除失败，请检查商品编号是否正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭数据库
            JdbcUtils.release(conn,preparedStatement,rs);
        }
    }

}