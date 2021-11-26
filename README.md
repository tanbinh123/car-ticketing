# car-ticketing
 基于SpringBoot框架开发的长途汽车售票系统，同时是大三上学期软件设计与编程实践的大实验作业，可以用户提供长途汽车信息查询、购买的功能，以及管理员的后台统计等业务。

## 项目用到的技术：

- SpringBoot2.5.6
- Mybatis
- Mysql
- Redis
- Druid
- Mybatis generator
- html、css、js
- JQuery
- Bootstrap



## 部署项目

### 1、还原数据库
运行Mysql数据库，创建数据库rail-ticketing-system，导入项目中根目录下sql文件下的数据库还原文件`rail-ticketing-system.sql`。

### 2.导入项目
打开IDEA，打开car-ticketing文件夹

### 3、加载maven
等待maven加载，大概5分钟左右

### 4、配置项目路径
配置属性文件路径：src/main/resources/application.properties
注：只需配置和修改sql主机地址，数据库名，用户名，密码， 项目访问路径，这几个属性，项目即可正常运行访问。
```
# DataSource
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/rail-ticketing-system?useUnicode=true&characterEncoding=utf8&useSSL=false
jdbc.username=root
jdbc.password=123456
```

### 5、运行项目
IDEA运行项目，  
打开浏览器http://localhost:8080  ，进入乘客页面，用户名chz，密码123456  
打开浏览器http://localhost:8080/admin  ，进入管理员页面，管理员用户名admin，密码123456













































