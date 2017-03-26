## Gradle+Scala+Java+SpringMVC Web应用解决方案

### 框架组成(Project Architecture)

- Gradle > [init project](https://github.com/silence940109/Java/tree/master/Gradle_STS_Create) > finished > 2016-10-23
- Gretty Integration> Server Hot Deploy Scheme> [tomcat热部署方案](https://github.com/silence940109/Java/tree/master/Gradle_Gretty) > finished > 2016-11-05
- Spring 4.25 Integration > finished > 2016-10-23
- Spring Session
- Spring Security
- Message Queue
- [JWT](https://github.com/auth0/java-jwt) > Web API Security
- Scala 2.1 > Scala Java Compile At The Same Time > finished > 2016-11-06
- Spark 2.0.0 > 服务器平台搭建 > finished > 2016-11-04
- Spring-Aspects Transaction > finished > 2016-11-13
- Spark 2.0.0 任务提交
- Spring WebSocket API > Support Push Notification
- SpringMVC4.25 > finished > 2016-10-25
- MyBatis3.3.0 > finished > 2016-11-13
- Mybatis Generator > 自动生成配置文件 > finished > 2016-11-13
- Druid数据库连接池(连接池监控) > [Spring Druid](https://github.com/silence940109/Java/tree/master/Alibaba_Druid) > finished > 2016-10-26
- Quartz2.1 > Job Schedule > finished > 2016-10-27
- Lucene6.2.1全文信息检索
- Redis > finished > 2016-11-12
- Redis客户端开发包Jedis > finished > 2016-11-12
- Ehcache
- sf4j日志->log4j日志引擎 > finished > 2016-10-20
- Gradle Spring Junit单元测试 > finished > 2016-11-18
- Tablesaw-伪“大数据”处理
- Dex-数据可视化
- Swagger > API文档 > RESTFUL API TEST > finished 2016-11-03
- Alibaba Fastjson > [More Info](https://github.com/alibaba/fastjson) > finished > 2016--11-14
- Mysql5.1 > finished > 2016-10-24

### 要求

- Gradle 3.1
- Spark2.0.0
- JDK 1.8+
- Scala 2.1+
- Tomcat8+(关于gradle使用tomcat插件，你可以在[Gradle Tomcat plugin](https://plugins.gradle.org/plugin/com.bmuschko.tomcat))查看
- MySQL5.1+
- IDE > STS

### 配置

- 在src/main/resources/db.properties配置数据库信息
- 在src/main/resources/spring-quartz-task.xml配置作业调度信息
- 在src/main/resources/redis.properties中配置redis服务器所在地址和认证

### 运行

- git clone https://github.com/silence940109/SSM.git

- cd SSM 

- gradle -t appRun

- 访问http://localhost:8080/SSM 

- swagger-ui访问http://localhost:8080/SSM/swagger/index.html

- 阿里巴巴Druid数据源http://localhost:8080/SSM/druid

### 打包到自己服务器

- git clone https://github.com/silence940109/SSM.git

- cd SSM

- gradle buile

- 在./build/libs/SSM-*.war生成经过编译好的war包

- 丢到你自己的服务器即可

### 详情
<br>
#### 1.关于Java和Scala代码同时编译，以及spring mvc集成Scala问题，2016-11-06日完成,如下图，详细信息会在后面写出：

![](https://github.com/silence940109/Java/blob/master/SpringMVC_Scala/image/index.png)

spring mvc和scala集成测试代码

Scala Controller
```Java
	@Api(value = "ScalaController", description = "测试scala")
	@Controller
	@RequestMapping(value=Array {"/scala"})
	class Test1 @Autowired()(scalaTestService:ScalaTestService,userService:UserService){
	  
	  @ResponseBody
	  @ApiOperation(value = "Scala实现单词统计", httpMethod = "POST", notes = "scalaWordCount")
	  @RequestMapping(value=Array{"/scalaWordCount"},method=Array{RequestMethod.POST})
	  def scalaWorkCount(@ApiParam(required = true, name = "line", value = "给定的字符串") @RequestParam(value = "line") line:String,
	      @ApiParam(required = true, name = "pattern", value = "分隔符") @RequestParam(value = "pattern") pattern:String):String = {
	    scalaTestService.wordcount(line, pattern)
	  }
	  
	  @ResponseBody
	  @ApiOperation(value = "测试Scala2", httpMethod = "POST", notes = "testScala2")
	  @RequestMapping(value=Array{"/test2"},method=Array{RequestMethod.POST})
	  def test2(@ApiParam(required = true, name = "name", value = "用户姓名") @RequestParam(value = "name") name:String):String = {
	     println(scalaTestService.execute("value"))
	    "this is scala controller test"
	  }
```
Scala Service
```Java	
	@Service("scalaTestService")
	class ScalaTestService {
	
	  def execute(name: String): String = {
	    "Scala test service module return data"
	  }
	
	  def wordcount(line:String, pattern:String): String = {
	    //原始map
	    val map = line.split(pattern)
	      .foldLeft(Map.empty[String, Int]) {
	        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
	      }
	    val sortmap = map
	      .toList //转成List排序
	      //.filter(_._2 > 1) //过滤出数量大于指定数目的数据，这里是1
	      .sortWith(_._2 > _._2); //根据value值进行降序排序,( 降序（_._2 > _._2）升序(_._2 < _._2) )
	    for (pair <- sortmap) println(pair) //遍历Map，输出每一个kv对
	    sortmap.toString()
	  }
	}
```
<br>
#### 2.关于Gretty插件配置热部署方案，请看[这里](https://github.com/silence940109/Java/blob/master/Gradle_Gretty)

![](https://github.com/silence940109/Java/blob/master/Gradle_Gretty/image/1.png)

<br>
<br>
#### 3.关于Alibaba Druid数据源监控配置
关于Alibaba Druid数据源监控配置的信息详情，可以看

在web.xml中配置druid入口的用户名和密码，用户名和密码都配为druid

关于[Alibaba Druid数据源监控配置](https://github.com/silence940109/Java/tree/master/Alibaba_Druid)

运行结果

![](https://github.com/silence940109/Java/blob/master/Alibaba_Druid/1.png)

![](https://github.com/silence940109/Java/blob/master/Alibaba_Druid/2.png)

<br>
#### 4.关于Swagger UI API测试
系统已经集成了swagger，关于spring如何集成和配置swagger，请看[这里](https://github.com/silence940109/Java/tree/master/swagger)

服务器运行起来后，你可以在浏览器中打开`http://localhost:8080/SSM/swagger/index.html`

在输入框输入`http://localhost:8080/SSM/api-docs`,然后就可以看到以下的界面，你可以很方便的进行测试

![](https://github.com/silence940109/Java/blob/master/swagger/image/index.png)

![](https://github.com/silence940109/Java/blob/master/swagger/image/swagger-request.png)

<br>
### 5.关于Mybatis Generator自动生成配置文件,[具体配置过程](https://github.com/silence940109/Mybatis)
在/src/resources/generatorConfig.xml文件中

(1).修改数据库驱动本地路径

	<classPathEntry location="D:\mavenRepository\mysql\mysql-connector-java\5.1.30\mysql-connector-java-5.1.30.jar" />

(2).修改需要生成配置文件的数据库信息

	<jdbcConnection driverClass="com.mysql.jdbc.Driver"
		connectionURL="jdbc:mysql://localhost:3306/ssm?characterEncoding=utf8"
		userId="root" password="root">
	</jdbcConnection>

(3).需要生成哪些表的配置信息

	<!-- 要对那些数据表进行生成操作，必须要有一个. -->
	<table schema="mybatis" tableName="article" domainObjectName="Article"
		enableCountByExample="false" enableUpdateByExample="false"
		enableDeleteByExample="false" enableSelectByExample="false"
		selectByExampleQueryId="false">
	</table>
			<table schema="mybatis" tableName="user" domainObjectName="User"
		enableCountByExample="false" enableUpdateByExample="false"
		enableDeleteByExample="false" enableSelectByExample="false"
		selectByExampleQueryId="false">
	</table>

(4).执行以下命令生成

	gradle -Dtest.singlg=GeneratorMybatis test

<br>

### 6.[关于使用Gradle进行Spring单元测试](https://github.com/silence940109/Java/tree/master/Gradle_Test)

(1).执行单元测试

![](https://github.com/silence940109/Java/blob/master/Gradle_Test/image/2.png)

在项目的根目录下/build/reports/tests/test/index.html下查看单元测试的概要

(2).错误，不通过

![](https://github.com/silence940109/Java/blob/master/Gradle_Test/image/1.png)

(3).通过

![](https://github.com/silence940109/Java/blob/master/Gradle_Test/image/3.png)