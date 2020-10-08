## Mybatis

### 一、简介

![logo](img\logo.png)

```
MyBatis 本是apache的一个开源项目iBatis, 2010年这个项目由apache software foundation 迁移到了google
code，并且改名为MyBatis 。2013年11月迁移到Github。
iBATIS一词来源于"internet"和"abatis"的组合，是一个基于Java的持久层框架。iBATIS提供的持久层框架包括SQL
Maps和Data Access Objects(DAOs)
MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。MyBatis 避免了几乎所有的
JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口
和 Java 的 POJOs(Plain Ordinary Java Object,普通的 Java对象)映射成数据库中的记录。
```

### 二、搭建Mybatis

1. 添加Jar包

   ```xml
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis</artifactId>
       <version>3.4.6</version>
   </dependency>
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>5.1.46</version>
   </dependency>
   ```

2. 添加配置文件：mybatis-config.xml

   > 连接数据库的配置文件的作用：
   >
   > 1. 指定连接数据库的url,username,password,driver
   > 2. 由框架自动获取连接
   > 3. 指定了事务的管理对象

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
   "http://mybatis.org/dtd/mybatis-3-config.dtd">
   <configuration>
       <!--连接数据库的环境，default="环境的id"-->
       <environments default="development">
           <environment id="development">
               <transactionManager type="JDBC"/>
               <dataSource type="POOLED">
                   <property name="driver" value="com.mysql.jdbc.Driver"/>
                   <property name="url" value="jdbc:mysql://localhost:3306/dbName"/>
                   <property name="username" value="root"/>
                   <property name="password" value="123456"/>
                   <property name="maxActive" value="10"/>
           		<property name="minIdle" value="5"/> 
               </dataSource>
           </environment>
           <!--配置多数据源-->
           <environment id="a2">
               <transactionManager type="JDBC"/>
               <dataSource type="POOLED">
                   <property name="driver" value="com.mysql.jdbc.Driver"/>
                   <property name="url" value="jdbc:mysql://localhost:3306/dbName"/>
                   <property name="username" value="root"/>
                   <property name="password" value="123456"/>
                   <property name="maxActive" value="10"/>
           		<property name="minIdle" value="5"/> 
               </dataSource>
           </environment>
       </environments>
       <!-- 指定maper文件的路径（maven项目从resources源文件夹下找资源）-->
       <mappers>
           <mapper resource="包名/mapper文件名"/>
       </mappers>
   </configuration>

   <!--配置文件中default要和id值相同，default表示默认访问环境，但是也可以自己指定使用哪个id数据源,代码如下:
   	
   	SqlSession session = new SqlSessionFactoryBuilder().build(reader,"指定访问环境id").openSession();

   -->
   ```

3. 创建实体类和接口类

   - 一个`JavaBean`实体类表示一个数据库，一个对象代表一行数据，属性名=列名。

     ```java
     //例如：数据库 User(id, name, phone)

     //同名实体类
     public class User {
         private Integer id;

         private String name;

         private String phone;
         
         public Integer getId() {
             return id;
         }

         public void setId(Integer id) {
             this.id = id;
         }

         public String getName() {
             return name;
         }

         public void setNickname(String name) {
             this.name = name == null ? null : name.trim();
         }

         public String getPhone() {
             return phone;
         }

         public void setPhone(String phone) {
             this.phone = phone == null ? null : phone.trim();
         }

     }
     ```

   - 创建`dao`接口：添加增删改查等方法

     ```java
     import com.spring.bean.User;

     public interface UserDao {
         //添加一个用户
         int insert(User user);
         
         //根据id删除用户
         int delete(int id);
         
         //修改用户信息
         int update(User newUser);

         //查找所有用户
         List<User> selectAll();
         
     }
     ```

4. 添加Mapper文件、

   - Mapper文件格式

     ```xml
     <!--注：Mapper文件中保存Sql语句 -->

     <?xml version="1.0" encoding="UTF-8"?>
     <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
             "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
     <mapper namespace="接口的完整路径">
         <!--增删改返回的是受影响的行数，不需要配置resultType-->
         <insert id="方法名" parameterType="参数类型">
             <!--sql语句-->
         </insert>
         <!--查询的时候要添加resultType属性-->
         <select id="方法名" resultType="查询后的返回值类型">
             <!--sql语句---注：sql语句没有分号-->
         </select>
     </mapper>
     ```


   - 示例：

     ```xml
     <!--注：Mapper文件中保存Sql语句 -->

     <?xml version="1.0" encoding="UTF-8"?>
     <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
             "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
     <mapper namespace="com.spring.dao.UserDao">
         <insert id="insert" parameterType="com.spring.bean.User">
         	insert into user (name, phone) values (#{name,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR})
         </insert>
         <!--若只有一个参数时，parameterType可不指定-->
         <delete id="delete">
         	delete from user where id=#{id}
         </delete>
         <update id="update" parameterType="com.spring.bean.User">
         	update user set name=#{name}, phone=#{phone}
         </update>
         <select id="findAll" resultType="com.spring.bean.User">
         	select * from user
         </select>
     </mapper>
     ```

5. 修改`Mybatis`的配置文件,让该配置文件知道mapper文件的存在

   ```xml
   <configuration>
       ......
       <!-- 指定maper文件的路径（maven项目从resources源文件夹下找资源）-->
       <mappers>
           <mapper resource="UserMapper.xml"/>
       </mappers>
   </configuration>
   ```

6. 获得`SqlSession`，通过该对象进行数据的操作

   ```java
   //1.加载配置文件
   Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
   //2.创建SqlSessionFactoryBuilder对象
   SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
   //3.得到session工厂
   SqlSessionFactory factory = builder.build(reader);
   //4.得到session
   SqlSession session = factory.openSession();
   //5.调取sql语句,insert("方法的完整路径")，路径=namespace+id
   int rs = session.insert("com.spring.dao.UserDao.insert", new User);
   //6.对于增删改需要提交事务
   session.commit();
   //7.关闭资源
   reader.close();
   session.close();
   ```

### 三、Mybatis实现CRUD

#### 1. Mapper文件中参数的读取

   - **单个基本类型参数或 String 类型：**

     Mapper读取参数：#{参数名(也可以是自定义名称)}

   - **参数类型为对象类型：**

     读取参数的语法: #{对象中的属性名}

     insert,delete,update,select中的`parameterType`参数可以省略


   - **有多个参数值：**

     将参数封装到Map集合中，再将Map集合传递给Mapper文件取值的时候，#{map的key值}。

     处理结果没有和实体类做对应的时候，可以使用Map集合。

     ```xml
     <select id="find" resultType="map">
     </select>
     ```

#### 2. CRUD参数对应

**如果需要将查询的结果和实体类属性自动对应的话，要求：属性名=列名**

- 查询：

  - 单行

    ```java
    Object object = session.selectOne("namespace+id", [传递给sql的参数值]);
    ```

  - 多行

    ```java
    List list = session.selectList("namespace+id",[传递给sql的参数值]);
    ```

- 添加

  ```java
  session.insert("namespace+id", [传递给sql的参数值]);
  ```

- 修改

  ```java
  session.update("namespace+id", [传递给sql的参数值]);
  ```

- 删除

  ```java
  session.delete("namespace+id", [传递给sql的参数值]);
  ```

#### 3. 处理多个聚合函数

```
使用map作为方法的返回值，默认key是列名

注意：增删改的时候需要提交事务
	//事务提交
	session.commit();
	//事务回滚
	session.rollback();
```

#### 4. 调试接口和Mapper文件的插件

![plugin](img\FreeMybatisPlugin.jpg)

### 四、省略实现类

```java
//1.加载配置文件
Reader reader = Resources.getResourceAsReader("mybatis.xml");
//2.获得SqlSession对象
SqlSession session = new SqlSessionFactoryBuilder().build(reader).openSession();
//3.得到要调用的接口对象，参数是接口的class类
StudentDao dao = session.getMapper(StudentDao.class);
//4.调用方法
List<User> list = dao.findAll();
```

### 五、ThreadLocal处理SqlSession

#### 1. ThreadLocal是什么呢？

```
其实ThreadLocal并非是一个线程的本地实现版本，它并不是一个Thread，而是threadlocalvariable(线程局部变量)。也许把它命名为ThreadLocalVar更加合适。线程局部变量(ThreadLocal)其实的功用非常简单，就是为每一个使用该变量的线程都提供一个变量值的副本，是Java中一种较为特殊的线程绑定机制，是每一个线程都可以独立地改变自己的副本，而不会和其它线程的副本冲突。
```

#### 2. 示例

```java
class Test{
    private ThreadLocal<String> str = new ThreadLocal<String>();
    private List<String> list = new ArrayList<String>();
    class A extends Thread {
        public void run() {
            str.set("zhangsan");
            System.out.println("A...." + str.get());
            list.add("xxx");
            System.out.println("A<<<"+list.get(0));
        }
    }
    class B extends Thread {
        public void run() {
            System.out.println("B...." + str.get());
            list.add("xxx");
            System.out.println("B<<<"+list.get(0));
        }
    }
}
测试代码:
Test2 t=new Test2();
Test2.A a=t.new A();
Test2.B b=t.new B();
a.start();
b.start();
```

- SessionUtil类:

  ```java
  public class mybatisUtil {
      private static ThreadLocal<SqlSession> threadLcoal = new ThreadLocal<SqlSession>();
      private static SqlSessionFactory SqlSessionFactory;
      /**
      *
      * 加载配置文件
      */
      static{
          try{
              Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
              SqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
          }catch(IOException e){
              e.printStackTrace();
              throw new RuntimeException(e);
          }
      }
      /**
      *
      * 获取SqlSession
      *
      * @return
      */
      public static SqlSession getSqlSession(){
          //从当前线程获取
          SqlSession sqlSession = threadLcoal.get();
          if(sqlSession == null){
              sqlSession = SqlSessionFactory.openSession();
              //将sqlSession与当前线程绑定
              threadLcoal.set(sqlSession);
          }
          return sqlSession;
      }
      /**
      * 关闭Session
      */
      public static void closeSqlSession(){
          //从当前线程获取
          SqlSession sqlSession = threadLcoal.get();
          if(sqlSession != null){
              sqlSession.close();
              threadLcoal.remove();
          }
      }
  }
  ```

### 六、给类起别名

```xml
<typeAliases>
    <!--给实体类起别名 -->
    <!--<typeAlias alias="u" type="com.yhp.bean.Users"></typeAlias>-->
    <!--指定哪些包的类可以使用别名,默认别名:类名首字母小写（实际使用的时候，全部小写也可以做结果映射-->
    <package name="com.spring.bean"></package>
</typeAliases>
```

### 七、获得新增数据的id

```xml
<!--适用于可以自增的主键列上-->
<insert useGeneratedKeys="true" keyProperty="userid">
```

