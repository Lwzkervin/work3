package item;


import utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class ItemUpdate {

    // 商品新增启动类
    public static void main(String[] args) {

        Connection conn = null;

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;

        String sql = "update `item` set name = ?, price = ? where id = ?";

        String sql1 = "select id from `item` where id = ?";

        // 新增的数据
        String code = "5";
        String title = "阿辉";
        String price = "66";

        try {
            // 连接到数据库并创建Statement对象
            conn = JdbcUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql1);
            preparedStatement.setObject(1,title);
            // 修改之前先判断是否存在相同的CODE
            rs = preparedStatement.executeQuery();
            String code1 = "";
            while (rs.next()) {
                code1 = rs.getString("code");
            }
            // 当查询出来的数据不为空，且与当前的商品编码不一致时，表示商品名称已存在
            if(!"".equals(code1)&&!code1.equals(code)){
                System.out.println("商品名称已存在！");
            }else{
                preparedStatement = conn.prepareStatement(sql);
                // 配置新增数据
                preparedStatement.setObject(1,title);
                preparedStatement.setObject(2, price);
                preparedStatement.setObject(3,code);

                // 执行SQL 操作
                int i =  preparedStatement.executeUpdate();
                System.out.println(i>0?"修改成功":"修改失败，请检查商品编号是否正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭数据库
            JdbcUtils.release(conn,preparedStatement,rs);
        }
    }

}