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
        <artifactId>spring-boot-stater-web</artifactId>
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

### 六、整合JDBC

### 七、整合MyBatis

### 八、Thymeleaf

### 九、Mybatis Plus



