import java.sql.*;
public class jdbcfirst {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.创建数据库连接对象
        String url="jdbc:mysql://localhost:3306/work3?useUnicode=true&characterEcoding=utf8&useSSL=true";
        String username="root";
        String password="lwz990764375";
        Connection connection = DriverManager.getConnection(url,username , password);
        // 3.创建执行sql语句的对象
        Statement st=connection.createStatement();
        //4.返回结果集
        String sql="select * from item";
        ResultSet rs=st.executeQuery(sql);
        //5.处理结果,打印table的数据
        while (rs.next()){
            System.out.println("id="+rs.getObject("id"));
            System.out.println("name="+rs.getObject("name"));
            System.out.println("price="+rs.getObject("price"));
        }
        //6.关闭资源
        rs.close();
        connection.close();
        st.close();
    }

}