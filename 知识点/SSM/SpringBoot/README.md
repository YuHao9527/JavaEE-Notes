## Spring Boot

### 一、简介

#### 1. 什么是Spring Boot？

springboot是spring快速开发脚手架，通过约定大于配置的方式，快速构建和启动spring项目。

#### 2. 为什么要学Spring Boot?

首先说一下Spring的缺点：

- 复杂的配置

  项目各种配置是开发时的损耗， 写配置挤占了写应用程序逻辑的时间。

- 混乱的依赖管理

  项目的依赖管理非常的繁琐。决定项目里要用哪些库就已经够让人头痛的了，你还要知道这些库的哪个版本
  和其他库不会有冲突，这是一个棘手的问题。并且，一旦选错了依赖的版本，随之而来的就是各种的不兼容
  的bug。

而Spring Boot正是为解决这两个问题而生的。

### 3. Spring Boot的特点

- 快速开发spring应用的框架
- 内嵌tomcat和jetty容器，不需要单独安装容器，jar包直接发布一个web应用
- 简化maven配置，parent这种方式，一站式引入需要的各种依赖
- 基于注解的零配置思想
- 和各种流行框架，spring web mvc，mybatis，spring cloud无缝整合

> 总结：
>
> spring boot 是spring快速开发脚手架，通过约定大于配置，优化了混乱的依赖管理，和复杂的配置，让我们用java -jar方式，运行启动java web项目。

### 二、Spring Boot入门案例

> 案例需求：创建一个web项目，在页面中显示Hello World。

#### 1. 创建工程

1. 新建一个空工程（springBoot_project）

   ![newProject](img\newProject.png)

   ![name](img\projectName.png)

2. 设置Jdk版本为1.8

   ![jdk](img\settingJdk.png)

3. 新建一个Module

   ![module](img\createModule.png)

4. 使用Maven来构建

   ![module2](img\createModule2.png)

5. 填写目录坐标

   ![module3](img\createModule3.png)

6. 项目结构

   ![目录结构](img\目录结构.png)

#### 2. 添加依赖

SpringBoot提供了一个名为spring-boot-starter-parent的构件，里面已经对各种常用依赖（并非全部）的版本进行了管理，我们的项目需要以这个项目为父工程，这样我们就不用操心依赖的版本问题了，需要什么依赖，直接引
入坐标即可！

##### 2.1. 添加父工程坐标

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.0.RELEASE</version>
</parent>
```

##### 2.2. 添加Web启动器

为了让SpringBoot帮我们完成各种自动配置，我们必须引入SpringBoot提供的自动配置依赖，我们称为启动器。
因为我们是web项目，这里我们引入web启动器：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

需要注意的是，我们并没有在这里指定版本信息。因为SpringBoot的父工程已经对版本进行了管理了。

##### 2.3 管理Jdk版本

默认情况下，maven工程的jdk版本是1.5，而我们开发使用的是1.8，因此这里我们需要修改jdk版本，只需要简单
的添加以下属性即可：

```xml
<properties>
    <java.version>1.8</java.version>
</properties>
```

##### 2.4 完整的pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.yh</groupId>
    <artifactId>spring-demo-project</artifactId>
    <version>1.0-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.0.RELEASE</version>
    </parent>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
</project>
```

#### 3. 创建启动类

Spring Boot项目通过main函数即可启动，我们需要创建一个启动类：

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

#### 4. 编写Controller

接下来，我们就可以像以前那样开发SpringMVC的项目了！

编写Controller类：

```java
@RestController
public class HelloController {
    @GetMapping("/test")
    public String test(){
        return "hello World";
    }
}
```

#### 5. 启动测试

直接启动main方法，查看控制台:

![console](img\console.png)

![console2](img\console2.png)

打开页面访问：[http://localhost:8080/test](http://localhost:8080/test)

![测试成功](img\chorme.png)

**测试成功！**

### 三、全注解配置和属性注入

#### 1. Spring全注解配置

spring全注解配置主要靠java类和一些注解，比较常用的注解有：

- @Configuration ：声明一个类作为配置类，代替xml文件
- @Bean ：声明在方法上，将方法的返回值加入Bean容器，代替<bean> 标签
- @value ：属性注入
- @PropertySource ：指定外部属性文件

> 例如：实现数据库连接池配置

1. 首先引入Druid连接池依赖

   ```xml
   <dependency>
       <groupId>com.alibaba</groupId>
       <artifactId>druid</artifactId>
       <version>1.1.21</version>
   </dependency>
   ```

2. 创建一个jdbc.properties文件，编写jdbc属性

   ```properties
   jdbc.driverClassName=com.mysql.jdbc.Driver
   jdbc.url=jdbc:mysql://127.0.0.1:3306/demo
   jdbc.username=root
   jdbc.password=
   ```

3. 编写配置类

   ```java
   @Configuration
   @PropertySource("classpath:jdbc.properties")
   public class JdbcConfig {
       @Value("${jdbc.url}")
       String url;
       @Value("${jdbc.driverClassName}")
       String driverClassName;
       @Value("${jdbc.username}")
       String username;
       @Value("${jdbc.password}")
       String password;
       @Bean
       public DataSource dataSource() {
           DruidDataSource dataSource = new DruidDataSource();
           dataSource.setUrl(url);
           dataSource.setDriverClassName(driverClassName);
           dataSource.setUsername(username);
           dataSource.setPassword(password);
           return dataSource;
       }
   }
   /*
       @Configuration ：声明我们JdbcConfig 是一个配置类
       
       @PropertySource ：指定属性文件的路径是: classpath:jdbc.properties
       
       通过@Value 为属性注入值
       
       通过@Bean将 dataSource() 方法声明为一个注册Bean的方法，Spring会自动调用该方法，将方法的返回值加入Spring容器中。默认的对象名id=方法名，也可以通过@Bean("自定义名字")，来指定新的对象名
    */
   ```

   然后我们就可以在任意位置通过`@Autowired` 注入DataSource了！

4. 测试

   ```java
   @RestController
   public class HelloController {
       @Autowired
       private DataSource dataSource;

       @GetMapping("/test")
       public String test() {
           return "Hello World!" + dataSource;
       }
   }
   ```

   Debug运行并查看：

   ![debug](img\debug.png)

   **属性注入成功！**

#### 2. Spring Boot属性注入

在上面的案例中，我们实验了java配置方式。不过属性注入使用的是@Value注解。这种方式虽然可行，但是不够
强大，因为它只能注入基本类型值。
在SpringBoot中，提供了一种新的属性注入方式，支持各种java基本数据类型及复杂类型的注入。

1. 首先我们新建一个类，用来进行属性注入：

   ```java
   @ConfigurationProperties(prefix = "jdbc")
   public class JdbcProperties {
       private String url;
       private String driverClassName;
       private String username;
       private String password;
       // getters 和 setters方法 略
   }
   ```

   - 在类上通过`@ConfigurationProperties`注解声明当前类为属性读取类
   - `prefix="jdbc" `读取属性文件中，前缀为`jdbc`的值。
   - 在类上定义各个属性，名称必须与属性文件中`jdbc.` 后面部分一致
   - 需要注意的是，这里我们并没有指定属性文件的地址，所以我们需要把`jdbc.properties`名称改为`application.properties`，这是SpringBoot默认读取的属性文件名。

2. 在JdbcConfig中使用这个属性：

   ```java
   @Configuration
   @EnableConfigurationProperties(JdbcProperties.class)
   public class JdbcConfig {
       @Bean
       public DataSource dataSource(JdbcProperties jdbc) {
           DruidDataSource dataSource = new DruidDataSource();
           dataSource.setUrl(jdbc.getUrl());
           dataSource.setDriverClassName(jdbc.getDriverClassName());
           dataSource.setUsername(jdbc.getUsername());
           dataSource.setPassword(jdbc.getPassword());
           return dataSource;
       }
   }
   ```

   - 通过`@EnableConfigurationProperties(JdbcProperties.class)`来声明要使用`JdbcProperties`这个类的对象

   - 注入JdbcProperties:

     - @Autowired注入

       ```java
       @Autowired
       private JdbcProperties prop;
       ```

     - 构造函数注入

       ```java
       private JdbcProperties prop;
       public JdbcConfig(Jdbcproperties prop){
           this.prop = prop;
       }
       ```

     - 声明@Bean的方法注入

       ```java
       @Bean
       public Datasource dataSource(@Autowired JdbcProperties prop){
           // ...
       }
       //这里的@Autowired可以省略
       ```

3. 测试

   ![debug](img\debug3.png)

> 相较于@Value()方式注入，SpringBoot 推荐的注入方式。
>
> 优势：Relaxed binding：松散绑定
>
> - 不严格要求属性文件中的属性名与成员变量名一致。支持驼峰，中划线，下划线等等转换，甚至支持对象引导。比如：user.friend.name：代表的是user对象中的friend属性中的name属性，显然friend也是对象。@value注解就难以完成这样的注入方式。
> - meta-data support：元数据支持，帮助IDE生成属性提示（写开源框架会用到）。

#### 3. 更优雅的注入

事实上，如果一段属性只有一个Bean需要使用，我们无需将其注入到一个类（JdbcProperties）中。而是直接在需要的地方声明即可：

```java
@Configuration
public class JdbcConfig {
    @Bean
    // 声明要注入的属性前缀，SpringBoot会自动把相关属性通过set方法注入到DataSource中
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
}
```

我们直接把`@ConfigurationProperties(prefix = "jdbc")` 声明在需要使用的@Bean 的方法上，然后SpringBoot就会自动调用这个Bean（此处是DataSource）的set方法，然后完成注入。使用的前提是：**该类必须有对应属性的set方法！**

- 测试

  ![debug](img\debug2.png)

### 四、自动配置原理

#### 1. @SpringBootApplication

- 源码

  ```java
  @Target({ElementType.TYPE})
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  @Inherited
  @SpringBootConfiguration
  @EnableAutoConfiguration
  @ComponentScan(
      excludeFilters = {@Filter(
      type = FilterType.CUSTOM,
      classes = {TypeExcludeFilter.class}
  ), @Filter(
      type = FilterType.CUSTOM,
      classes = {AutoConfigurationExcludeFilter.class}
  )}
  )
  public @interface SpringBootApplication {
  }
  ```

  - @SpringBootConfiguration

    ```java
    /**
     * Indicates that a class provides Spring Boot application
     * {@link Configuration @Configuration}. Can be used as an alternative to the Spring's
     * standard {@code @Configuration} annotation so that configuration can be found
     * automatically (for example in tests).
     * <p>
     * Application should only ever include <em>one</em> {@code @SpringBootConfiguration} and
     * most idiomatic Spring Boot applications will inherit it from
     * {@code @SpringBootApplication}.
     *
     * @author Phillip Webb
     * @since 1.4.0
     */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Configuration
    public @interface SpringBootConfiguration {
    }
    ```

    通过这段我们可以看出，在这个注解上面，又有一个@Configuration 注解。这个注解的作用就是声明当前类是一个配置类，然后Spring会自动扫描到添加了@Configuration 的类，并且读取其中的配置信息。

  - @EnableAutoConfiguration

    ```
    启用Spring应用上下文的自动配置，尝试猜测和配置您可能需要的bean类。自动配置类通常基于您的classpath和您定义的bean类来应用。
    ```

  - @ComponentScan

    ```java
    /**
     * Configures component scanning directives for use with @{@link Configuration} classes.
     * Provides support parallel with Spring XML's {@code <context:component-scan>} element.
     *
     * <p>Either {@link #basePackageClasses} or {@link #basePackages} (or its alias
     * {@link #value}) may be specified to define specific packages to scan. If specific
     * packages are not defined, scanning will occur from the package of the
     * class that declares this annotation.
     *
     * <p>Note that the {@code <context:component-scan>} element has an
     * {@code annotation-config} attribute; however, this annotation does not. This is because
     * in almost all cases when using {@code @ComponentScan}, default annotation config
     * processing (e.g. processing {@code @Autowired} and friends) is assumed. Furthermore,
     * when using {@link AnnotationConfigApplicationContext}, annotation config processors are
     * always registered, meaning that any attempt to disable them at the
     * {@code @ComponentScan} level would be ignored.
     *
     * <p>See {@link Configuration @Configuration}'s Javadoc for usage examples.
     *
     * @author Chris Beams
     * @author Juergen Hoeller
     * @author Sam Brannen
     * @since 3.1
     * @see Configuration
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Documented
    @Repeatable(ComponentScans.class)
    public @interface ComponentScan {
    }
    ```

    翻译一下注释：

    > 配置组件扫描指令与@Configuration类一起使用。
    > 提供与Spring XML的\<context:component-scan>元素并行的支持。
    > 可以指定basePackageClasses或basePackages（或其别名值）来定义要扫描的特定包。如果没有定义特定的包，扫描将从声明该注解的类的包中进行。

    而我们的@SpringBootApplication注解声明的类就是main函数所在的启动类，因此扫描的包是该类所在包及其子包。因此，一般启动类会放在一个比较前的包目录中。

### 五、整合SpringMVC

#### 1. 修改端口

查看`SpringBoot`的全局属性可知，端口通过以下修改全局配置文件application.properties的方式配置：

```properties
# 映射端口
server.port=80
```

#### 2. 访问静态资源

`ResourceProperties`的类，里面就定义了静态资源的默认查找路径：

```java
/**
 * Properties used to configure resource handling.
 *
 * @author Phillip Webb
 * @author Brian Clozel
 * @author Dave Syer
 * @author Venil Noronha
 * @author Kristine Jetzke
 * @since 1.1.0
 */
@ConfigurationProperties(prefix = "spring.resources", ignoreUnknownFields = false)
public class ResourceProperties {

	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
			"classpath:/META-INF/resources/", "classpath:/resources/",
			"classpath:/static/", "classpath:/public/" };
	// 。。。
}
```

默认的静态资源路径为：

- classpath:/META-INF/resources/
- classpath:/resources
- classpath:/static/
- classpath:/public/

只要静态资源放在这些目录中任何一个，`SpringMVC`都会帮我们处理。
我们习惯会把静态资源放在classpath:/static/ 目录下。我们创建目录，并且添加一些静态资源：

![staticResource](img\staticResource.png)

重亲运行启动器测试：

![staticResourceTest](img\staticResourceTest.png)

#### 3. 拦截器的配置

- 首先我们定义一个拦截器

  ```java
  public class InterceptorDemo implements HandlerInterceptor {
      private Logger logger = LoggerFactory.getLogger(InterceptorDemo.class);

      @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
          logger.debug("拦截器开始");
          return true;
      }

      @Override
      public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
          logger.debug("拦截器结束");
      }

      @Override
      public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
          logger.debug("拦截器跳转后执行");
      }
  }
  ```

- 通过实现`WebMvcConfigurer`并添加`@Configuration`注解来实现自定义部分`SpringMVC`配置：

  ```java
  @Configuration
  public class MvcConfigurer implements WebMvcConfigurer {

      //通过 @Bean 注解，将我们定义的拦截器注册到Spring容器
      @Bean
      public InterceptorDemo interceptorDemo() {
          return new InterceptorDemo();
      }

      //重写接口中的addInterceptors方法，添加自定义拦截器
      @Override
      public void addInterceptors(InterceptorRegistry registry) {
          //通过registry来注册拦截器，通过addPathPatterns来添加拦截路径
          registry.addInterceptor(this.interceptorDemo()).addPathPatterns("/**");
      }
  }
  ```

  **Ant Path路径匹配通配符：**

  - "?" 匹配任何单字符
  - "*" 匹配0或者任意数量的字符
  - "**" 匹配0或者更多的目录

- 测试

  你会发现日志中什么都没有，因为我们记录的log级别是debug，默认是显示info以上，我们需要进行配置。
  `SpringBoot`通过`logging.level.*=debug` 来配置日志级别，*填写包名

  ```properties
  # 设置com.lxs包的日志级别为debug
  logging.level.com.yh=debug
  ```

  ![logDebug](img\logDebug.png)

### 六、整合JDBC

> 创建数据库
>
> CREATE DATABASE IF NOT EXISTS \`springboot`;
>
> USE \`springboot`;
>
> DROP TABLE IF EXISTS `tb_user`;
>
> CREATE TABLE \`tb_user` (
>
>   \`id` bigint(20) NOT NULL AUTO_INCREMENT,
>
>   \`user_name` varchar(50) DEFAULT NULL,
>
>   \`password` varchar(50) DEFAULT NULL,
>
>   \`name` varchar(50) DEFAULT NULL,
>
>   \`age` int(11) DEFAULT NULL,
>
>   \`sex` int(11) DEFAULT NULL,
>
>   \`birthday` date DEFAULT NULL,
>
>   \`created` date DEFAULT NULL,
>
>   \`updated` date DEFAULT NULL,
>
>   \`note` varchar(2000) DEFAULT NULL,
>
>   PRIMARY KEY (\`id`)
>
> ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
>
> insert  into \`tb_user\`(\`id\`,\`user_name\`,\`password\`,\`name\`,\`age\`,\`sex\`,\`birthday\`,\`created\`,\`updated\`,\`note`) values (1,'zhangsan','1','张三',18,1,'2019-02-27','2019-02-27','2019-02-27','在学习Java...'),(2,'lisi','1','李四',18,1,'2019-02-27','2019-02-27','2019-02-27','在学习Java...'),(3,'wangwu','1','王五',18,1,'2019-02-27','2019-02-27','2019-02-27','在学习Java...'),(4,'fanbingbing','1','范冰冰',18,2,'2019-02-27','2019-02-27','2019-02-27','在学习Java...'),(5,'guodegang','1','郭德纲',18,1,'2019-02-27','2019-02-27','2019-02-27','在学习Java...');

#### 1. 导入依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<!--测试-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
</dependency>
<!--数据库驱动，SpringBoot并不知道我们用的什么数据库，这里我们选择MySQL-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.46</version>
</dependency>
```

#### 2. 配置数据库连接池

在引入`jdbc`启动器的时候，`SpringBoot`已经自动帮我们引入了一个连接池：

![jdb](img\jdbc.png)

`HikariCP`应该是目前速度最快的连接池了，我们看看它与`c3p0`的对比：

![connectPool](img\connectPool.png)

因此，我们只需要配置连接池参数即可：

```properties
# 连接数据库四大参数
spring.datasource.url=jdbc:mysql://localhost:3306/springboot
spring.datasource.username=root
spring.datasource.password=
# 可省略，SpringBoot自动推断
spring.datasource.driverClassName=com.mysql.jdbc.Driver 

# 连接池连接超时时间
spring.datasource.hikari.idle-timeout=60000
# 最大连接数
spring.datasource.hikari.maximum-pool-size=30
# 最小连接数
spring.datasource.hikari.minimum-idle=10
```

#### 3. 创建数据库对应实体类

```java
public class User implements Serializable {
    // id
    private Long id;
    // 用户名
    //自动转换下换线到驼峰命名user_name -> userName
    private String userName;
    // 密码
    private String password;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 性别，1男性，2女性
    private Integer sex;
    // 出生日期
    private Date birthday;
    // 创建时间
    private Date created;
    // 更新时间
    private Date updated;
    // 备注
    private String note;
    
    // get 和 set 方法省略

}
```

#### 4. dao

```java
@Repository
public class JdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        //BeanPropertyRowMapper:可以把同名字段赋值给属性
        return jdbcTemplate.query("select * from tb_user", new BeanPropertyRowMapper<>(User.class));
    }

}
```

#### 5. 测试

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcDaoTest extends TestCase {

    @Autowired
    private JdbcDao jdbcDao;

    @Test
    public void testFindALl() {
        jdbcDao.findAll().forEach(user -> {
            System.out.println(user);
        });
    }

}
```

![data](img\data.png)

### 七、整合MyBatis

#### 1. MyBatis

`SpringBoot`官方并没有提供`Mybatis`的启动器，不过`Mybatis`官网自己实现了：

```xml
<!--mybatis -->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.0.1</version>
</dependency>
```

**全局配置：**

```properties
# mybatis 别名扫描
mybatis.type-aliases-package=com.yh.bean
# mapper.xml文件位置,如果没有映射文件，请注释掉
mybatis.mapper-locations=classpath:mappers/*.xml
```

#### 2. 实体类

同`jdbc`实体类，注意`MyBatis`不会自动转换下换线到驼峰命名`user_name -> userName`

```java
public class User implements Serializable {
    private String user_name;
}
```

#### 3. dao

```java
public interface UserDao {
    //查询所有User
    List<User> findAll();
}
```

#### 4. Mapper映射文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.yh.dao.UserDao">
    <select id="findAll" resultType="com.yh.bean.User">
        select * from tb_user
    </select>
</mapper> 
```

#### 5. 加载接口代理对象

Mapper的加载接口代理对象方式有2种:

- 第一种：使用`@Mapper`注解(不推荐)

  需要注意，这里没有配置mapper接口扫描包，因此我们需要给每一个Mapper接口添加@Mapper 注解，才能被识别。

  ```java
  @Mapper
  public interface UserDao {
  }
  ```

- 第二种：设置`MapperScan`，注解扫描的包(推荐)

  `@MapperScan("dao所在的包")`，自动搜索包中的接口，产生`dao`的代理对象。

  ```java
  @SpringBootApplication
  @MapperScan("com.yh.dao")
  public class Application {
      public static void main(String[] args) {
          SpringApplication.run(Application.class, args);
      }
  }
  ```

#### 6. 测试

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    
    @Test
    public void testFindAll() {
        List<User> list = userDao.findAll();
    }
}
```

![data](img\data2.png)

#### 7. 通用Mapper

使用`Mybatis`时，最大的问题是，要写大量的重复`SQL`语句在`xml`文件中，除了特殊的业务逻辑`SQL`语句之外，还有大量结构类似的增删改查`SQL`。而且，当数据库表结构改动时，对应的所有`SQL`以及实体类都需要更改。这大量增加了程序员的负担。避免重复书写CRUD映射的框架有两个：

- 通用`mybatis`（`tk-mybatis`）
- `mybatis plus`，功能更加强大

通用Mapper的作者为自己的插件编写了启动器，我们直接引入即可：

```xml
<!-- 通用mapper -->
<dependency>
    <groupId>tk.mybatis</groupId>
    <artifactId>mapper-spring-boot-starter</artifactId>
    <version>2.0.2</version>
</dependency>
```

##### 实体类

> tk-mybatis 实体类使用的注解是jpa注解

```java
@Table(name = "tb_user")
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 用户名
    private String userName;
    // ....
}
```

**注意事项：**

1. 默认表名=类名，字段名=属性名
2. 表名可以使用`@Table(name = "tableName")`进行指定
3. `@Column(name = "fieldName")` 指定
4. 使用`@Transient`注解表示跟字段不进行映射

不需要做任何配置即可使用。

```java
public interface UserDao extends tk.mybatis.mapper.common.Mapper<User>{
    //自定义复杂Sql方法，可不写直接使用继承的简单Sql方法
    List<User> findByUser(User user);
}
```

##### 自定义映射文件

> 映射复杂方法 resources/mappers/UserMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.yh.dao.UserDao">

    <select id="findByUser" resultType="com.yh.bean.User">
        SELECT
        *
        FROM
        tb_user
        <where>
            <if test="name != null">
                name like '%${name}%'
            </if>
            <if test="note != null">
                and note like '%${note}%'
            </if>
        </where>
    </select>

</mapper>
```

##### 通用方法

一旦继承了Mapper，继承的Mapper就拥有了Mapper所有的通用方法：

- **Select方法：**

  | 方法                                | 说明                                                         |
  | ----------------------------------- | ------------------------------------------------------------ |
  | `List<T> select(T record);`         | 根据实体中的属性值进行查询，查询条件使用等号                 |
  | `T selectByPrimaryKey(Object key);` | 根据主键字段进行查询，方法参数必须包含完整的主键属性，       |
  | `List<T> selectAll();`              | 查询全部结果，select(null)方法能达到同样的效果               |
  | `T selectOne(T record);`            | 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异 |
  | `int selectCount(T record);`        | 根据实体中的属性查询总数，查询条件使用等号                   |

- **Insert方法：**

  | 方法                             | 说明                                                   |
  | -------------------------------- | ------------------------------------------------------ |
  | `int insert(T record);`          | 保存一个实体，null的属性也会保存，不会使用数据库默认值 |
  | `int insertSelective(T record);` | 保存一个实体，null的属性不会保存，会使用数据库默认值   |

- **Update方法：**

  | 方法                                         | 说明                                     |
  | -------------------------------------------- | ---------------------------------------- |
  | `int updateByPrimaryKey(T record);`          | 根据主键更新实体全部字段，null值会被更新 |
  | `int updateByPrimaryKeySelective(T record);` | 根据主键更新属性不为null的值             |

- **Delete方法：**

  | 方法                                  | 说明                                                 |
  | ------------------------------------- | ---------------------------------------------------- |
  | `int delete(T record);`               | 根据实体属性作为条件进行删除，查询条件使用等号       |
  | `int deleteByPrimaryKey(Object key);` | 根据主键字段进行删除，方法参数必须包含完整的主键属性 |

- **Example方法(用于复杂Sql语句)：**

  | 方法                                                         | 说明                                                         |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | `List<T> selectByExample(Object example);`                   | 根据Example条件进行查询 重点：这个查询支持通过`Example`类指定查询列，通过`selectProperties`方法指定查询列 |
  | `int selectCountByExample(Object example);`                  | 根据Example条件进行查询总数                                  |
  | `int updateByExample(@Param("record") T record, @Param("example") Object example);` | 根据Example条件更新实体`record`包含的全部属性，null值会被更新 |
  | `int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);` | 根据Example条件更新实体`record`包含的不是null的属性值        |
  | `int deleteByExample(Object example);`                       | 根据Example条件删除数据                                      |

  > 注意要把`MapperScan`类改成`tk-mybatis`构件的类

  ```java
  import tk.mybatis.spring.annotation.MapperScan;

  @SpringBootApplication
  @MapperScan("com.yh.dao")
  public class Application {
      public static void main(String[] args) {
          SpringApplication.run(Application.class, args);
      }
  }
  ```

##### 测试

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest extends TestCase {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSelectAll() {
        userDao.selectAll().forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void testSelectById() {
        User user = userDao.selectByPrimaryKey(3);
        System.out.println(user);
    }
    
    @Test
    public void testSelectByExample() {
        //创建Example类用于添加查询条件
        Example example = new Example(User.class);
        //添加查询条件相当于Sql语句：select * from tb_user where user_name like "%a%";
        example.createCriteria().andLike("user_name", "%a%");
        userDao.selectByExample(example).forEach(user -> {
            System.out.println(user);
        });
    }
}
```

### 八、Thymeleaf

#### 1. 概述

`Thymeleaf`是一个跟`FreeMarker`类似的模板引擎，它可以完全替代 JSP 。相较与其他的模板引擎，它有如下特
点：

- 动静结合：`Thymeleaf`在有网络和无网络的环境下皆可运行，无网络显示静态内容，有网络用后台得到数据替换静态内容
- 与`SpringBoot`完美整合，`SpringBoot`默认整合`Thymeleaf`

#### 2. 入门案例 

##### 导入依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

`SpringBoot`会自动为`Thymeleaf`注册一个视图解析器：

```java
/**
 * <p>
 *   Implementation of the Spring WebMVC {@link org.springframework.web.servlet.ViewResolver}
 *   interface.
 * </p>
 * <p>
 *   View resolvers execute after the controller ends its execution. They receive the name
 *   of the view to be processed and are in charge of creating (and configuring) the
 *   corresponding {@link View} object for it.
 * </p>
 * <p>
 *   The {@link View} implementations managed by this class are subclasses of 
 *   {@link AbstractThymeleafView}. By default, {@link ThymeleafView} is used.
 * </p>
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 3.0.3
 *
 */
public class ThymeleafViewResolver extends AbstractCachingViewResolver implements Ordered {
        
}
```

与解析`JSP`的`InternalViewResolver`类似，`Thymeleaf`也会根据前缀和后缀来确定模板文件的位置：

```java
/**
 * Properties for Thymeleaf.
 *
 * @author Stephane Nicoll
 * @author Brian Clozel
 * @author Daniel Fernández
 * @author Kazuki Shimizu
 * @since 1.2.0
 */
@ConfigurationProperties(prefix = "spring.thymeleaf")
public class ThymeleafProperties {

	private static final Charset DEFAULT_ENCODING = StandardCharsets.UTF_8;

	public static final String DEFAULT_PREFIX = "classpath:/templates/";

	public static final String DEFAULT_SUFFIX = ".html";
    
    
}
```

- 默认前缀：`classpath:/templates/`
- 默认后缀：`.html`

所以如果我们返回视图： users ，会指向到 `classpath:/templates/users.html`

##### 编写Service

- UserService,调用UserDao中的查询所有方法

  ```java
  @Service
  public class UserService {

      @Autowired
      private UserDao dao;
      
      public List<User> selectAll() {
          return dao.selectAll();
      }

  }
  ```

##### 编写Controller

```java
//编写一个controller，返回一些用户数据，放入模型中，等会在页面渲染 编写一个controller，返回一些用户数据，放入模型中，等会在页面渲染

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/listAll")
    public String findAll(Model model) {
        List<User> users = service.selectAll();
        model.addAttribute("users", users);
        //返回模板名称（就是classpath:/templates/目录下的html文件名
        return "users";
    }
}
```

##### 静态页面

根据上面的文档介绍，模板默认放在`classpath`下的`templates`文件夹，我们新建一个`html`文件放入其中：

注意，把`html`的名称空间，改成：`xmlns:th="http://www.thymeleaf.org"` 

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <style type="text/css">
        table {border-collapse: collapse; font-size: 14px; width: 80%; margin: auto}
        table, th, td {border: 1px solid darkslategray;padding: 10px}
    </style>
</head>
<body>
<div style="text-align: center">
    <span style="color: darkslategray; font-size: 30px">欢迎光临！</span>
    <hr/>
    <table class="list">
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>用户名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>生日</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        <tr th:each="user, status : ${users}" th:object="${user}">
            <td th:text="${user.id}">1</td>
            <td th:text="*{name}">张三</td>
            <td th:text="*{userName}">zhangSan</td>
            <td th:text="${user.age}">20</td>
            <td th:text="${user.sex} == 1 ? '男': '女'">男</td>
            <td th:text="${#dates.format(user.birthday, 'yyyy-MM-dd')}">1980-02-30</td>
            <td th:text="${user.note}">1</td>
            <td>
                <a th:href="@{/delete(id=${user.id}, userName=*{userName})}">删除</a>
                <a th:href="|/update/${user.id}|">修改</a>
                <a th:href="'/approve/' + ${user.id}">审核</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
```

- ${} ：这个类似与el表达式，但其实是`ognl`的语法，比el表达式更加强大
- th- 指令： th- 是利用了`HTML5`中的自定义属性来实现的。如果不支持`H5`，可以用data-th- 来代替
  - th:each：类似于`c:foreach`遍历集合，但是语法更加简洁
  - th:text：声明标签中的文本
    - 例如`<td th-text='${user.id}'>1</td>` ，如果user.id有值，会覆盖默认的1
    - 如果没有值，则会显示`td`中默认的1。这正是`thymeleaf`能够动静结合的原因，模板解析失败不影响页面的显示效果，因为会显示默认值！

##### 测试

启动服务器，打开页面：

![table](img\table.png)

##### 模板缓存

`Thymeleaf`会在第一次对模板解析之后进行缓存，极大的提高了并发处理能力。但是这给我们开发带来了不便，修改页面后并不会立刻看到效果，我们开发阶段可以关掉缓存使用：

```properties
# 开发阶段关闭thymeleaf的模板缓存, 默认为关闭的
spring.thymeleaf.cache=true
```

**注意：**

关闭缓存后，修改页面需要重新编译才能生效。

#### 3. Thymeleaf详解

##### 表达式

共分为三类：

1. 变量表达式

   变量表达式即`OGNL`表达式或`Spring EL`表达式(在`Spring`中用来获取`model attribute`的数据)。如下所示：

   ```html
   <!--格式:${session.user.name}-->

   <h5>表达式</h5>
   <span>${text}</span>
   <span th:text="${text}">Hello thymleaf</span>
   ```

2. 选择或星号表达式

   选择表达式很像变量表达式，不过它们用一个预先选择的对象来代替上下文变量容器(map)来执行，如下：`{customer.name}`

   被指定的object由th:object属性定义：

   ```html
   <tr th:each="user : ${users}" th:object="${user}">
       <td th:text="${user.id}">1</td>
       <td th:text="*{name}">张三</td>
       <td th:text="*{userName}">zhangsan</td>
       ....
   ```

3. URL表达式

   URL表达式指的是把一个有用的上下文或回话信息添加到URL，这个过程经常被叫做URL重写。 `@{/order/list}`
   URL还可以设置参数：`@{/order/details(id=${orderId}, name=*{name})}`

   相对路径：`@{../documents/report}`

   让我们看看这些表达式：

   ```html
   <form th:action="@{/createOrder}">
       <a href="main.html" th:href="@{/main}"></a>
       <!--url表达式-->
       <a th:href="@{/delete(id=${user.id}, userName=*{userName})}">删除</a>
       <!--文本替换-->
       <a th:href="|/update/${user.id}|">修改</a>
   	<!--字符串拼接-->
       <a th:href="'/approve/' + ${user.id}">审核</a>
   </form>
   ```

##### 表达式常见用法

- 字面（Literals）
  - 文本文字（Text literals）：`'one text', 'Another one!',…`
  - 数字文本（Number literals）: `0, 34, 3.0, 12.3,…`
  - 布尔文本（Boolean literals）: `true, false`
  - 空（Null literal）: `null`
  - 文字标记（Literal tokens）: `one, sometext, main,…`
- 文本操作（Text operations）
  - 字符串连接（String concatenation）：`+`
  - 文本替换（Literal substitutions）：|The name is ${name}|`
- 算术运算（Arithmetic operations）
  - 二元运算符（Binary operators）: `+, -, *, /, %`
  - 减号（单目运算符）Minus sign（unary operator）：`-`
- 布尔操作（Boolean operations）
  - 二元运算符（Binary operators）: `and, or`
  - 布尔否定（一元运算符）Boolean negation（unary operator）：`!, not`
- 比较和等价
  - 比较（Comparators）：`>, <, >=, <= (gt, lt, ge, le)`
  - 等值运算符（Equality operators）：`==, != (eq, ne)`
- 条件运算符
  - If-then：`(if) ? (then)`
  - If-then-else：`(if) ? (then) : (else)`
  - Default：` (value) ?: (defaultvalue)`

##### 常用th标签

| 关键字  | 功能介绍 | 案例                                                  |
| ------- | -------- | ----------------------------------------------------- |
| th:text | 文本替换 | `<p th:text="${collect.description}">description</p>` |

##### 基本用法

1. 赋值、字符串拼接
2. 条件判断 if/Unless
3. for循环
4. 内联文本
5. 内联js
6. 内嵌变量

##### 使用Thymeleaf布局

### 九、Mybatis Plus

> `Mybatis-Plus`（简称MP）是一个 `Mybatis` 的增强工具，在 `Mybatis` 的基础上只做增强不做改变，避免了我们重复CRUD语句。

#### 1. 快速入门





