# 初识MySQL

## JavaEE ：企业级JavaWeb开发 Web
- 前端（页面：展示，数据）
- 后台 （连接点：连接数据库JDBC，连接前端（控制 、 视图跳转、和给前端传递数据））
- 数据库（存数据，Txt，Excel，word）

只会写代码，学好数据库，基本混饭吃。操作系统，数据结构与算法!当一个不错的程序员！离散数学，数字电路，体系结构，编译原理。+实战经验，高级程序员~优秀程序员~

## 1.1为什么要学习数据库
1. 岗位需求
2. 现在的世界，大数据时代~得数据者得天下
3. 被迫需求：存数据、去IOE
4. 数据库是所有软件体系中最核心的存在 DBA

## 1.2什么是数据库
数据库（DB，DataBase）
- 概念：数据仓库，软件，安装在操作（Windows、Linux、Mac）系统之上的！
- 作用：存数据，管理数据 Excel

## 1.3 数据库分类
### 关系型数据库
- Excel 行、列（SQL）
- MySQL、Oracle、SqlServer、DB2、SQLlite
- 通过标和表之间，行和列之间的关系进行数据的存储；学员信息表，考勤表，

### 非关系型数据库
- {key:value} （No SQL）
- Redis，MongDB
- 非关系型数据库：对象存储，通过对象的自身的属性来决定。

DB（DataBase） 存数据
DBMS 管理和操作数据
- DBMS（DataBase Manager System）数据库管理系统
- 数据库的管理软件，科学有效的管理我们的数据。维护和获取数据；
- MySQL ，本质是数据库管理系统
# MySQL简介

## 1.4 MySQL 简介
MySQL是一个开源的关系型数据库管理系统，属于Oracle旗下产品。它具有体积小、速度快、总体拥有成本低的特点，适用于中小型网站或大型网站。

MySQL的历史：
- 前世：瑞典MySQL AB 公司
- 今生：属于Oracle旗下产品

MySQL的安装建议：
- 尽量不要使用ext安装，因为会将一些配置放到注册表中
- 尽可能使用压缩包进行安装

## 1.5 安装MySQL
可以参考博客[MySQL 5.7安装教程](https://blog.csdn.net/qq_42025798/article/details/119933631)进行详细安装步骤。

## 1.6 使用工具
我使用的是Navicat而不是SQLyong作为MySQL的客户端工具。

## 1.7 连接数据库
可以使用命令行连接MySQL数据库：


常用的一些操作：
- 查看所有数据库：`show databases;`
- 切换数据库：`use 数据库名;`
- 查看所有表：`show tables;`
- 创建一个数据库：`create database 数据库名;`
- 退出连接：`exit;`

注释：
- 单行注释：`-- 单行注释（SQL本来的注释）`
- 多行注释：`/* (SQL的多行注释) */`

数据库操作：
- DDL（Data Definition Language）定义
- DML（Data Manipulation Language）操作
- DQL（Data Query Language）查询
- DCL（Data Control Language）控制

继续学习数据库，掌握CRUD（增删改查）操作，成为一名优秀的程序员！

查看所有数据库show databases;

切换数据库use

数据库名查看所有的表show tables;

创建一个数据库create database westos(数据库名);

退出连接exit;


## 2. 操作数据库

### 2.1 创建数据库

创建数据库是SQL中的一个重要操作。可以使用以下语句来创建一个数据库：CREATE DATABASE database_name;


其中，`database_name`为要创建的数据库的名称。

### 2.2 数据库的列类型

在SQL中，每个数据表都由一系列列组成。每个列都有其特定的数据类型。以下是一些常见的列类型：

- `INT`：整数类型，用于存储整数值。
- `FLOAT`：浮点类型，用于存储带有小数点的数值。
- `VARCHAR(n)`：可变长度字符串类型，用于存储最多n个字符的文本。
- `DATE`：日期类型，用于存储日期值。

### 2.3 数据库的字段属性（重点）

在SQL中，每个列都可以拥有特定的字段属性。以下是一些常见的字段属性：

- `NOT NULL`：表示该列不允许为空值。
- `PRIMARY KEY`：表示该列是主键，用于唯一标识每行数据。
- `UNIQUE`：表示该列的值必须唯一。
- `DEFAULT`：为该列设置默认值。

### 2.4 数据表的类型

在SQL中，可以创建不同类型的数据表，以满足不同的需求。以下是一些常见的数据表类型：

- 普通表：用于存储数据的基本表格。
- 临时表：用于存储临时数据，当会话结束时会被自动删除。
- 视图：是一个虚拟的数据表，由查询语句定义，可以简化复杂的查询操作。

### 2.5 修改和删除表

在SQL中，可以使用`ALTER TABLE`语句来修改已有的数据表结构，使用`DROP TABLE`语句来删除已有的数据表。

- 修改表结构示例：
    ```sql
    ALTER TABLE table_name
    ADD column_name datatype;
    ```

- 删除表示例：
    ```sql
    DROP TABLE table_name;
    ```

### 3. MQL数据管理

### 3.1 外键

外键是用于关联两个表的字段，它创建一个表与另一个表的关联。外键约束用于防止破坏表之间的链接。

### 3.2 DML语言（全部记住）

DML（Data Manipulation Language）用于检索、插入、更新和删除数据。常见的DML语句包括`SELECT`、`INSERT`、`UPDATE`和`DELETE`。

### 3.3 添加

添加数据使用`INSERT INTO`语句，示例如下：

INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);

### 3.4 修改
修改数据使用UPDATE语句，示例如下：
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
### 3.5 删除
删除数据使用DELETE FROM语句，示例如下：

DELETE FROM table_name
WHERE condition;

```markdown
## 4. DQL查询数据（最重点）

### 4.1 DQL
DQL，或数据查询语言，是SQL的一部分，用于查询和操作数据库中的数据。最常用的DQL语句是SELECT。

```sql
SELECT * FROM table_name;
```

### 4.2 指定查询字段
你可以指定要查询的字段，而不是选择所有字段。

```sql
SELECT column1, column2 FROM table_name;
```

### 4.3 where 条件子句
WHERE子句用于过滤结果。

```sql
SELECT column1, column2 FROM table_name WHERE condition;
```

### 4.4 联表查询
你可以使用JOIN语句来查询多个表。

```sql
SELECT column1, column2 FROM table1 JOIN table2 ON table1.column = table2.column;
```

### 4.5 分页和排序
LIMIT和OFFSET用于分页，ORDER BY用于排序。

```sql
SELECT * FROM table_name ORDER BY column DESC LIMIT 10 OFFSET 20;
```

### 4.6 子查询
子查询是嵌套在其他SQL查询中的查询。

```sql
SELECT column1 FROM table1 WHERE column2 = (SELECT column2 FROM table2);
```

### 4.7 分组和过滤
GROUP BY用于将结果集按照一个或多个列进行分组。HAVING用于过滤分组。

```sql
SELECT column1, COUNT(*) FROM table_name GROUP BY column1 HAVING COUNT(*) > 1;
```

### 4.8 select 小结
SELECT语句是最常用的DQL语句，用于从数据库中选择数据。

```sql
SELECT column1, column2 FROM table_name WHERE condition ORDER BY column1 DESC LIMIT 10;
```

```markdown
## 5. MySQL 函数

### 5.1 常用函数
MySQL提供了许多内置函数，包括数学函数、字符串函数、日期函数等。以下是一些示例：

```sql
-- ABS() 返回一个数的绝对值
SELECT ABS(-7);

-- CONCAT() 连接两个或更多的字符串
SELECT CONCAT('Hello', ' World');

-- NOW() 返回当前的日期和时间
SELECT NOW();
```

### 5.2 聚合函数
聚合函数对多行的值进行操作，返回一个单一的汇总值。以下是一些常用的聚合函数：

```sql
-- COUNT() 返回匹配指定条件的行数
SELECT COUNT(column1) FROM table_name;

-- SUM() 返回指定列的所有值的总和
SELECT SUM(column2) FROM table_name;

-- AVG() 返回指定列的平均值
SELECT AVG(column3) FROM table_name;

-- MAX() 返回指定列的最大值
SELECT MAX(column4) FROM table_name;

-- MIN() 返回指定列的最小值
SELECT MIN(column5) FROM table_name;
```

## 6. 事务

### 6.1 什么是事务
事务是一个或多个SQL语句组成的一个工作单元，这些SQL语句要么全部执行成功，要么全部失败。事务提供了一种机制，可以保证数据的一致性和完整性。以下是一个事务的示例：

```sql
-- 开始一个新的事务
START TRANSACTION;

-- 插入一行到table1
INSERT INTO table1 (column1) VALUES ('value1');

-- 插入一行到table2
INSERT INTO table2 (column2) VALUES ('value2');

-- 提交事务，使其更改永久生效
COMMIT;
```

如果在事务中的任何地方出现错误，你可以使用ROLLBACK语句来撤销所有在事务中进行的更改。

```sql
-- 开始一个新的事务
START TRANSACTION;

-- 插入一行到table1
INSERT INTO table1 (column1) VALUES ('value1');

-- 插入一行到table2
INSERT INTO table2 (column2) VALUES ('value2');

-- 回滚事务，撤销所有更改
ROLLBACK;
```



## 7、索引
索引是数据库中对一列或多列的值进行排序的数据结构，可以快速地定位到表中的特定行。索引可以大大加快数据的检索速度。索引分为以下几类：

### 7.1 索引的分类
- 主键索引：用于唯一标识每一行数据，保证数据的唯一性和完整性。
- 唯一索引：确保列中的所有数值都是唯一的。
- 普通索引：最基本的索引，没有任何限制。
- 全文索引：用于全文搜索的索引类型，适合于大段文本的搜索。

### 7.2 测试索引
在实际应用中，需要根据具体的业务需求和查询频率来设计和测试索引，以达到提高查询效率的目的。

### 7.3 索引原则
- 不宜创建过多的索引，过多的索引会增加数据操作的时间和空间消耗。
- 对经常需要进行查询的列创建索引，可以加快查询速度。
- 考虑复合索引，将多个列组合起来创建索引，以满足特定的查询需求。

## 8、权限管理和备份
在数据库管理中，权限管理和备份是非常重要的工作，可以保证数据库的安全性和稳定性。

### 8.1 用户管理
合理的用户管理可以确保不同用户有不同的权限，可以使用以下命令进行用户管理：
- 创建用户
- 删除用户
- 修改用户权限

### 8.2 MySQL备份
数据库备份是防止数据丢失的重要手段，MySQL可以通过定时备份数据来保证数据的安全性。常见的备份方式有：
- 物理备份：直接复制数据文件到另一个位置。
- 逻辑备份：使用mysqldump工具将数据导出为文本文件。
- 远程备份：将数据备份到远程服务器，防止本地数据丢失。

## 9、规范数据库设计
良好的数据库设计是保证数据完整性和一致性的关键，遵循规范的数据库设计原则可以提高系统的稳定性和可维护性。

### 9.1 为什么需要设计
数据库设计可以确保数据存储的高效性和安全性，同时也为后续的数据操作提供便利。

### 9.2 三大范式
- 第一范式（1NF）：确保每一列的原子性，即每一列都是不可再分解的原子数据项。
- 第二范式（2NF）：在1NF的基础上，消除部分依赖，即非主属性完全依赖于候选关键字。
- 第三范式（3NF）：在2NF的基础上，消除传递依赖，即任何非主属性不依赖于其它非主属性。


