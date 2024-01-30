# 数据库驱动和JDBC笔记

## 1、数据库驱动
数据库驱动是用于连接数据库和执行SQL语句的程序，不同的数据库有不同的驱动程序。常见的数据库驱动有：
- JDBC驱动：用于连接Java应用程序和各种类型的关系数据库。
- ODBC驱动：用于连接Windows操作系统中的应用程序和各种类型的数据源。
- PHP驱动：用于连接PHP应用程序和MySQL、Oracle等类型的数据库。

## 2、JDBC
JDBC（Java Database Connectivity）是Java语言中用于连接和操作数据库的标准API，提供了一组用于执行SQL语句和查询结果的接口和类。通过JDBC，Java应用程序可以连接到各种类型的关系数据库，并进行数据访问和管理。

### 2.1 JDBC架构
JDBC架构由两部分组成：JDBC API和JDBC驱动程序。JDBC API提供了一组标准的接口和类，用于连接和操作各种类型的关系数据库。JDBC驱动程序则用于实现JDBC API中定义的接口和类，将JDBC API的调用转换为适合特定数据库的本地协议。

### 2.2 JDBC连接
JDBC连接是指Java应用程序与数据库之间建立的连接，需要使用JDBC驱动程序和JDBC API实现。连接过程包括以下几个步骤：
- 加载JDBC驱动程序：使用Class.forName()方法加载JDBC驱动程序。
- 建立数据库连接：使用DriverManager.getConnection()方法建立与数据库的连接。
- 创建Statement对象：使用Connection.createStatement()方法创建Statement对象，用于执行SQL语句。
- 执行SQL语句：使用Statement.executeQuery()或Statement.executeUpdate()方法执行SQL语句。
- 处理结果集：使用ResultSet对象处理查询结果集。

### 2.3 JDBC事务
JDBC事务是指一组相关操作的集合，要么全部执行成功，要么全部回滚到初始状态。JDBC提供了一组用于事务处理的接口和类，包括以下几个方面：
- 设置自动提交：通过Connection.setAutoCommit()方法设置是否自动提交事务。
- 开始事务：通过Connection.beginTranscation()方法开始一个新的事务。
- 提交事务：通过Connection.commit()方法提交一个事务。
- 回滚事务：通过Connection.rollback()方法回滚一个事务。

### 2.4 JDBC批处理
JDBC批处理是指将一组相关的SQL语句一次性提交到数据库执行，可以提高数据库的性能。JDBC提供了一组用于批处理的接口和类，包括以下几个方面：
- 添加SQL语句：通过Statement.addBatch()方法添加SQL语句。
- 执行SQL语句：通过Statement.executeBatch()方法执行SQL语句。
- 清除SQL语句：通过Statement.clearBatch()方法清除SQL语句。
- 设置批处理大小：通过Statement.setBatchSize()方法设置批处理大小。
- 获取批处理结果：通过Statement.getUpdateCount()方法获取批处理结果。
- 批处理事务：通过Connection.setAutoCommit()方法设置是否自动提交事务。
- 批处理提交：通过Connection.commit()方法提交一个事务。
- 批处理回滚：通过Connection.rollback()方法回滚一个事务。
- 批处理关闭：通过Statement.close()方法关闭Statement对象。

# 第一个JDBC程序和Statement对象详解

## 3、第一个JDBC程序
下面是一个简单的JDBC程序示例，用于连接数据库并查询数据：

```java
import java.sql.*;

public class FirstJDBC {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 加载JDBC驱动程序
            Class.forName("com.mysql.jdbc.Driver");

            // 建立数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");

            // 创建Statement对象
            stmt = conn.createStatement();

            // 执行SQL语句
            rs = stmt.executeQuery("SELECT * FROM user");

            // 处理结果集
            while (rs.next()) {
                System.out.println(rs.getString("name") + "\t" + rs.getInt("age"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

# 4、Statement 对象详解

Statement 对象是 Java 数据库编程中用于执行 SQL 语句的核心对象之一。它用于向数据库发送 SQL 语句并接收返回的结果。

Statement 对象的主要方法包括：
- `executeQuery(sql)`：用于执行查询语句，并返回一个 ResultSet 对象，该对象包含了查询结果的数据。
- `executeUpdate(sql)`：用于执行 INSERT、UPDATE 或 DELETE 等更新操作的 SQL 语句，并返回受影响的行数。
- `execute(sql)`：用于执行任意 SQL 语句，可以根据返回值来判断执行的是查询语句还是更新操作。

需要注意的是，使用 Statement 对象执行 SQL 语句存在一些安全风险，比如可能会遭受 SQL 注入攻击。

# 5、PreparedStatement 对象

PreparedStatement 对象继承自 Statement 对象，提供了一种更加高效和安全的执行 SQL 语句的方式。

## 5.1、新增

使用 PreparedStatement 对象执行 INSERT 语句时，可以通过占位符（`?`）的形式动态地设置参数值，避免了字符串拼接的安全风险。

示例代码：
```java
String sql = "INSERT INTO table_name (column1, column2) VALUES (?, ?)";
PreparedStatement statement = connection.prepareStatement(sql);
statement.setString(1, value1);
statement.setInt(2, value2);
statement.executeUpdate();
```

## 5.2、修改

使用 PreparedStatement 对象执行 UPDATE 语句时，可以通过占位符（`?`）的形式动态地设置参数值，避免了字符串拼接的安全风险。

示例代码：
```java

String sql = "UPDATE table_name SET column1 = ? WHERE column2 = ?";
PreparedStatement statement = connection.prepareStatement(sql);
statement.setString(1, value1);
statement.setInt(2, value2);
statement.executeUpdate();
```

## 5.3、删除

使用 PreparedStatement 对象执行 DELETE 语句时，可以通过占位符（`?`）的形式动态地设置参数值，避免了字符串拼接的安全风险。

示例代码：
```java
String sql = "DELETE FROM table_name WHERE column1 = ?";
PreparedStatement statement = connection.prepareStatement(sql);
statement.setString(1, value1);
statement.executeUpdate();
```

## 5.4、查询

使用 PreparedStatement 对象执行 SELECT 语句时，可以通过占位符（`?`）的形式动态地设置参数值，避免了字符串拼接的安全风险。

示例代码：
```java
String sql = "SELECT * FROM table_name WHERE column1 = ?";
PreparedStatement statement = connection.prepareStatement(sql);
statement.setString(1, value1);
ResultSet resultSet = statement.executeQuery();
```

# 6、ResultSet 对象

ResultSet 对象用于表示 SQL 查询的结果集，它是一个二维的表格，包含了查询结果的数据。

## 6.1、获取数据

ResultSet 对象提供了一系列的 `getXXX()` 方法用于获取查询结果的数据，其中 XXX 表示数据类型，比如 `getString()` 用于获取字符串类型的数据，`getInt()` 用于获取整数类型的数据。

示例代码：
```java
ResultSet resultSet = statement.executeQuery();
while (resultSet.next()) {
    String column1 = resultSet.getString("column1");
    int column2 = resultSet.getInt("column2");
}
```

## 6.2、更新数据

ResultSet 对象提供了一系列的 `updateXXX()` 方法用于更新查询结果的数据，其中 XXX 表示数据类型，比如 `updateString()` 用于更新字符串类型的数据，`updateInt()` 用于更新整数类型的数据。

示例代码：
```java
ResultSet resultSet = statement.executeQuery();
while (resultSet.next()) {
    resultSet.updateString("column1", "value1");
    resultSet.updateInt("column2", 100);
    resultSet.updateRow();
}
```

# 7、JDBC 事务

JDBC 事务是指一组相关操作的集合，要么全部执行成功，要么全部回滚到初始状态。JDBC 提供了一组用于事务处理的接口和类，包括以下几个方面：

- 设置自动提交：通过 `Connection.setAutoCommit()` 方法设置是否自动提交事务。

- 开始事务：通过 `Connection.beginTranscation()` 方法开始一个新的事务。
- 提交事务：通过 `Connection.commit()` 方法提交一个事务。
- 回滚事务：通过 `Connection.rollback()` 方法回滚一个事务。
- 事务隔离级别：通过 `Connection.setTransactionIsolation()` 方法设置事务隔离级别。
- 保存点：通过 `Connection.setSavepoint()` 方法设置保存点。
- 回滚到保存点：通过 `Connection.rollback(Savepoint)` 方法回滚到保存点。
- 释放保存点：通过 `Connection.releaseSavepoint()` 方法释放保存点。
- 事务关闭：通过 `Connection.close()` 方法关闭 Connection 对象。
- 事务恢复：通过 `Connection.rollback()` 方法恢复事务。
- 事务状态：通过 `Connection.getTransactionIsolation()` 方法获取事务状态。

# 8、JDBC 批处理

JDBC 批处理是指将一组相关的 SQL 语句一次性提交到数据库执行，可以提高数据库的性能。JDBC 提供了一组用于批处理的接口和类，包括以下几个方面：

- 添加 SQL 语句：通过 `Statement.addBatch()` 方法添加 SQL 语句。
- 执行 SQL 语句：通过 `Statement.executeBatch()` 方法执行 SQL 语句。
- 清除 SQL 语句：通过 `Statement.clearBatch()` 方法清除 SQL 语句。
- 设置批处理大小：通过 `Statement.setBatchSize()` 方法设置批处理大小。
- 获取批处理结果：通过 `Statement.getUpdateCount()` 方法获取批处理结果。
- 批处理事务：通过 `Connection.setAutoCommit()` 方法设置是否自动提交事务。
- 批处理提交：通过 `Connection.commit()` 方法提交一个事务。
- 批处理回滚：通过 `Connection.rollback()` 方法回滚一个事务。
- 批处理关闭：通过 `Statement.close()` 方法关闭 Statement 对象。