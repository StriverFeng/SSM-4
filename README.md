da
##Gradle SpringMVC Mybatis构建web应用

###框架组成

- Gradle
- Spring 4.25 > finished
- SpringMVC4.25
- MyBatis3.3.0
- Freemarker
- Druid数据库连接池(连接池监控) > finished
- Quartz2.1作业调度 > finished
- Lucene6.2.1全文信息检索
- Redis
- Ehcache
- sf4j日志->log4j日志引擎 > finished
- JUNIT单元测试
- Strman-java字符处理
- Tablesaw-伪“大数据”处理
- Dex-数据可视化
- Mysql

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

###详情
####关于Alibaba Druid数据源监控配置
关于Alibaba Druid数据源监控配置的信息详情，可以看
[Alibaba Druid数据源监控配置](https://github.com/silence940109/Java/tree/master/Alibaba_Druid)这里

运行结果

![](https://github.com/silence940109/Java/blob/master/Alibaba_Druid/1.png)

![](https://github.com/silence940109/Java/blob/master/Alibaba_Druid/2.png)