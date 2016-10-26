
##Gradle SpringMVC Mybatis构建web应用

###框架组成

- Gradle
- Spring 4.25
- SpringMVC4.25
- MyBatis3.3.0
- Freemarker
- Druid数据库连接池(连接池监控)
- Quartz2.1作业调度
- Redis
- Ehcache
- sf4j日志

###要求

- Gradle 3.1
- JDK 1.7+
- Tomcat7+(关于gradle使用tomcat插件，你可以在[Gradle Tomcat plugin](https://plugins.gradle.org/plugin/com.bmuschko.tomcat))查看
- MySQL5.5+

###配置

- 在src/main/resources/db.properties配置数据库信息
- 在src/main/resources/spring-quartz-task.xml配置作业调度信息 

###运行

- git clone https://github.com/silence940109/SSM.git

- cd SSM 

- gradle tomcatRun

- 访问http://localhost:8080/SSM 