1.模板模式
定义好 骨架（可以全是借口 面向接口，具体实现由相应的去实现）
比如 spring jdbc
 java规范 各个数据库由厂商自己去实现
 1 加载驱动类 DriverManager
 2 建立连接
 3 创建执行语句
 4 执行语句集
 5 结果集ResultSet返回
 ORM（？）