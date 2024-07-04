## Spring-Boot-SQLite
### 一、简介
~~~
  SpringBoot+mybatis-plus项目集成SQLite嵌入式数据库，支持Windows或Liunx系统等跨系统直接拷贝并运行。
  使用技术：
      spring-boot、mybatis-plus、dynamic-datasource、sqlite、Swagger;
  实现功能：
      1.实现离线的方式将数据持久化储存到硬盘上；
      2.使用多数据源方式实现上传db文件增量同步至本地数据库；
~~~
### 二、SQLite
#### 1.创建数据库
自行去官网操作就行：[SQLite使用文档](https://www.sqlite.org/quickstart.html)
#### 2.创建表
##### 方式一
使用命令创建
~~~
#进入程序
sqlite3
#打开或创建数据库
.open test.db
~~~
详细参考：[SQLite教程](https://www.runoob.com/sqlite/sqlite-create-table.html)
##### 方式二
推荐这种方式，操作简单。

下载可视化工具：[DB Browser for SQLite](https://sqlitebrowser.org/dl/)

### 三、Spring-Boot
**主要配置**
#### 1.pom.xml
~~~
   <!-- SQLite JDBC 驱动 -->
        <dependency>
            <groupId>org.xerial</groupId>
            <artifactId>sqlite-jdbc</artifactId>
            <version>3.46.0.0</version>
        </dependency>
~~~
#### 2.application.yml
~~~
#获取项目存放路径+当前操作系统分隔符+sqlite3+当前操作系统分隔符+数据库文件名
url: jdbc:sqlite:${user.dir}${file.separator}sqlite3${file.separator}huanbaoducha_db1.db   
~~~
**注：代码只是简单示例，更复杂的业务逻辑根据自己需求扩展；**

  
