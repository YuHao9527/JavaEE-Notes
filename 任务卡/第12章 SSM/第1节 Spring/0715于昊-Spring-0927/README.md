## Spring

### 1. 简介

Spring框架是由于软件开发的复杂性而创建的。Spring使用的是基本的`JavaBean`来完成以前只可能由`EJB`完成的事情。然而，Spring的用途不仅仅限于服务器端的开发。从简单性、可测试性和松耦合性角度而言，绝大部分Java应用都可以从Spring中受益。

- 目的：解决企业应用开发的复杂性
- 功能：使用基本的`JavaBean`代替`EJB`，并提供了更多的企业应用功能
- 范围：任何Java应用

Spring是一个轻量级控制反转`IOC`和面向切面`AOP`的容器框架。

#### Spring组织架构

![spring组织架构](img/spring组织架构.png)

- **ORM-**Object relation mapping
- **OXM-**Object xml mapping
- **JMS-**Java消息服务(Java Message Service)
- **WebSocket protocol-**是HTML5一种新的协议。它实现了浏览器与服务器全双工通信（full-duplex)。
- **Portlet-**是一种Web组件，就像servlets是专为将合成页面里的内容聚集在一起而设计的。通常请求一个portal页面会引发多个portlets被调用。每个portlet都会生成标记段，并与别的portlets生成的标记段组合在一起嵌入到portal页面的标记内。
- spring全家桶：Spring、Spring Data、Spring MVC、Spring Boot、Spring Clound（微服务）

#### 下载地址

官网：[https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/index.html](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/index.html)

官网下载:[https://repo.spring.io/release/org/springframework/spring](https://repo.spring.io/release/org/springframework/spring/)

GitHub:[https://github.com/spring-projects/spring-framework](https://github.com/spring-projects/spring-framework)

#### Spring 核心模块

- spring-core：依赖注入`IOC`和`DI`的最基本实现
- spring-beans：Bean工厂与bean的装配
- spring-context：spring的context上下文即`IOC`容器
- spring-context-support
- spring-expression：spring表达式语言

### 2. IOC

```
IOC是 Inverse of Control 的简写，意思是控制反转。是降低对象之间的耦合关系的设计思想。
```

#### 实现过程

- 步骤一：添加jar包

  ```xml
  <!-- Spring的核心工具包-->
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-core</artifactId>
          <version>5.0.8.RELEASE</version>
      </dependency>
  <!--在基础IOC功能上提供扩展服务，还提供许多企业级服务的支持，有邮件服务、任务调度、远程访问、缓存以及多种视图层框架的支持-->
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context</artifactId>
          <version>5.0.8.RELEASE</version>
      </dependency>
  <!-- Spring IOC的基础实现，包含访问配置文件、创建和管理bean等 -->
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-beans</artifactId>
          <version>5.0.8.RELEASE</version>
      </dependency>
  <!-- Spring context的扩展支持，用于MVC方面 -->
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context-support</artifactId>
          <version>5.0.8.RELEASE</version>
      </dependency>
  <!-- Spring表达式语言 -->
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-expression</artifactId>
          <version>5.0.8.RELEASE</version>
      </dependency>
  ```

- 步骤二：创建配置文件`applicationContext.xml`

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.springframework.org/schema/beans
  http://www.springframework.org/schema/beans/spring-beans.xsd">
      
  </beans>
  ```

- 步骤3：在配置文件中创建对象

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.springframework.org/schema/beans
  http://www.springframework.org/schema/beans/spring-beans.xsd">
      
      <!-- 创建对象 -->
      <bean id="对象名" class="类的完整路径">
          <!--基本类型属性-->
      	<property name="属性名" value="属性值"></property>
          <!--引用类型属性-->
      	<property name="属性名" ref="对象的id值"></property>
      </bean>
  </beans>
  ```

- 步骤4：加载配置文件，获得对象

  ```java
  ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
  //需要强转对象类型
  Object obj = (Object) app.getBean("配置文件中对象id");
  ```

#### bean标签的属性介绍

|      属性      |                             说明                             |
| :------------: | :----------------------------------------------------------: |
|     class      |                    指定bean对应类的全路径                    |
|      name      |                    bean对应对象的一个标识                    |
|       id       |             bean对象的唯一标识，不能添加特殊字符             |
|     scope      | 执行bean对象创建模式和生命周期,scope="singleton"(默认)和scope="prototype" |
|   lazy-init    | 是否延时加载 默认值:false。true 延迟加载对象,当对象被调用的时候才会加载，测试的时候，通过`getbean()`方法获得对象。lazy-init="false" 默认值，不延迟，无论对象是否被使用，都会立即创建对象,测试时只需要加载配置文件即可。注意:测试的时候只留下id,class属性 |
|  init-method   |             只需要加载配置文件即可对象初始化方法             |
| destroy-method |                         对象销毁方法                         |

#### 对象创建的方式

1. 默认为无参构造

2. 有参构造

   ```java
   // Person类
   public class Person {
       private String name;
       private int age;
   	// 无参构造方法
       public Person(){}
       // 有参构造方法
       public Person(String name, int age) {
           this.name = name;
           this.age = age;
       }
   }
   ```

   ```xml
   <bean name="person" class="com.spring.bean.Person">
   	<constuctor-arg name="name" value="zhangsan"/>
   	<constuctor-arg name="age" value="18"/>
   </bean>
   ```

3. 静态方法创建对象

   ```java
   //静态工厂模式
   public class PersonFactory {
   	public static Person creatPerson() {
   		return new Person();
   	}
   }
   ```

   ```xml
   <bean name="personFac" class="com.spring.PersonFactory" factory-method="creatPerson"/>
   ```

   #### 非静态工厂方法

   ```java
   public class Users {
   	public Person creatPerson() {
   		return new Person();
       }
   }
   ```

   ```xml
   <bean id="users" class="com.spring.bean.Users"/>
   <bean id="person" factory-method="createPerson" factory-bean="users"/>
   ```

   #### springBean生命周期

   ![生命周期](img\生命周期.png)

### 3. DI注入值

```
DI是Dependency Injection的缩写，意思是依赖注入,说的是创建对象实例时，同时为这个对象注入它所依赖的属性。

分类：
	1.调取属性的set方法赋值；
	2.使用构造方法赋值。
```

#### set注入值

- 基本类型属性值注入

  ```xml
  <property name="属性名" value="属性值"/>
  ```

- 引用类型属性值注入

  ```xml
  <property name="属性名" ref="引用对象id"/>
  ```

#### 构造注入

- 通过name属性，按照参数名赋值

  ```java
  //有参构造方法
  public Person(String name, int age) {
  	this.name = name;
      this.age = age;
  }
  ```

  ```xml
  <bean id="person" class="com.spring.bean.Person">
      <constructor-arg name="name" value="lisi"/>
      <constructor-arg name="age"  value="20"/>
  </bean>
  ```

- 通过index属性，按照参数索引注入

  ```xml
  <bean id="person" class="com.spring.bean.Person">
      <constructor-arg index="0" value="lisi"/>
      <constructor-arg index="1"  value="20"/>
  </bean>
  ```

- 使用type注入

  ```xml
  <bean id="person" class="com.spring.bean.Person">
      <constructor-arg index="0" value="lisi"/>
      <constructor-arg index="1"  value="20" type="int"/>
      <!--默认数据类型为String，若有三个属性，下标为1的属性类型为int,下标为2的属性类型为String，有两个有参构造方法(name,int age)和(name, String ages)，如果不指定下标1的数据类型，则进后者的构造方法-->
  </bean>
  ```

#### Spring表达式

```xml
<bean id="person" name="person" class="com.spring.Person">
    <property name="name" value="张三"/>
    <property name="age" value="18"/>
</bean>

<bean id="person1" class="com.spring.bean.Person">
    <constructor-arg name="name" value="#{person.name}"/>
    <constructor-arg name="age"  value="#{person.age}"/>
</bean>

<!--注：#{对象id(或对象name).属性值} bean类对应属性必须有get方法-->
```

#### p命名空间注入值

使用`p:属性名 `完成注入,走set方法。

- 基本数据类型

  `P:属性名="值"`

- 引用类型

  `p:属性值-ref="对象id"`

- 实现步骤

  1. 配置文件中，添加命名空间p

     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns:p="http://www.springframework.org/schema/p"
            xsi:schemaLocation="http://www.springframework.org/schema/beans
     http://www.springframework.org/schema/beans/spring-beans.xsd">
     </beans>
     ```

  2. 添加对象

     ```xml
     <bean id="person" name="person" class="com.spring.Person" p:name="张三" p:age="30"/>
     ```

#### 复杂类型注入

- Object[]数组

  ```xml
  <!-- 数组变量注入 -->
  <property name="arrs">
      <array>
          <!--基本数据类型(默认String,可用type修改)-->
          <value>值1</value>
          <!--引用类型-->
          <ref bean="对象id"/>
      </array>
  </property>
  ```

- List

  ```xml
  <!-- List集合变量赋值-->
  <property name="list">
      <list>
          <!--基本数据类型(默认String,可用type修改)-->
          <value>值1</value>
          <!--集合变量内部包含集合-->
          <list>
              <value>集合中的值1</value>
              <value>集合中的值2</value>
              <value>集合中的值3</value>
          </list>
          <!--引用类型-->
          <ref bean="对象id" />
      </list>
  </property>
  ```

- Set

  ```xml
  <!-- Set集合变量赋值（同List）-->
  <property name="list">
      <set>
          <!--基本数据类型(默认String,可用type修改)-->
          <value>值1</value>
          <!--引用类型-->
          <ref bean="对象id" />
      </set>
  </property>
  ```

- Map

  ```xml
  <!--Map集合赋值 -->
  <property name="map">
      <map>
          <entry key="张三" value="18"/>
          <entry key="李四" value="28"/>
          <entry key="王五" value="38"/>
      </map>
  </property>
  ```

- Properties

  ```xml
  <!-- Properties赋值 -->
  <property name="properties">
      <props>
          <prop key="name">张三</prop>
          <prop key="age">18</prop>
      </props>
  </property>
  ```

#### 自动注入(autowire)

- `autowire`:

  参数列表：

  | 参数        | 说明                                                         |
  | ----------- | ------------------------------------------------------------ |
  | no          | 不自动装配(默认值)                                           |
  | byName      | 当属性名=id名,调用对应set方法赋值                            |
  | byType      | 当属性的类型和bean对象的类型相同时，调取set方法赋值(当找到多个同类型的bean对象时报错) |
  | constructor | 当构造方法的参数类型和bean对象的类型相同时，调取构造方法赋值(无构造方法报错) |

- 示例：

  ```xml
  <bean id="userdao" class="com.spring.dao.UserDao"></bean>
  <bean id="service" class="com.spring.service.UserService" autowire="byName"></bean>
  ```

- 配置全局自动装配

  ```xml
  <beans default-autowire="constructor/byName/byType/no">
  </beans>
  ```

### 4. 注解实现IOC

#### 实现过程

1. 步骤一：配置文件中添加约束

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:context="http://www.springframework.org/schema/context"
          xsi:schemaLocation="http://www.springframework.org/schema/context
   http://www.springframework.org/schema/context/spring-context.xsd">
   </beans>
   ```

2. 配置注解扫描:指定扫描包下所有类中的注解,扫描包时,会扫描包下所有的子孙包

   ```xml
   <!--扫描注解包-->
   <context:component-scan base-packpage="com.spring.bean"></context:component-scan>
   ```

3. 注解

   - 添加到类上

     ```java
     @Component("对象id") //创建对象
     @Service("person") //service层
     @Controller("person") //controller层
     @Repository("person") //dao层
     @Scope(scopeName="singleton") // 单例对象
     @Scope(scopeName="prototype") // 多例对象
     ```

   - 添加到属性上

     ```java
     @Value("属性值")
     private String name;

     @Autowired //如果一个接口类型，同时有两个实现类，则报错，此时可以借助@Qualifier("beanname")
     @Qualifier("bean name")
     private Object obj;

     //说明:@Resource 是java的注释,但是Spring框架支持,@Resource指定注入哪个名称的对象
     //@Resource(name="对象名") == @Autowired + @Qualifier("name")
     @Resource(name="beanname")
     private Object obj;
     ```

   - 添加到方法上

     ```java
     @PostConstruct //等价于init-method属性
     public void init(){
     	System.out.println("初始化方法");
     }
     @PreDestroy //等价于destroy-method属性
     public void destroy(){
     	System.out.println("销毁方法");
     }
     ```

### 5. AOP

```
AOP（Aspect Oriented Programming)即面向切面编程。即在不改变原程序的基础上为代码段增加新的功能。应用在权限认证、日志、事务。

AOP的作用在于分离系统中的各种关注点，将核心关注点和横切关注点分离开来。
```

![aop](img\aop.png)

#### AOP实现机制

```
JDK 的动态代理：针对实现了接口的类产生代理。InvocationHandler接口

CGlib 的动态代理：针对没有实现接口的类产生代理，应用的是底层的字节码增强的技术 生成当前类的子类对象，MethodInterceptor接口
```

![代理机制](img\代理.png)

##### Jdk动态代理实现

1. 创建接口和对应实现类

   ```java
   //接口
   public interface UserService {
       public void login();
   }

   //实现类
   public class UserServiceImpl implements UserService {
       @override
       public void login() {

       }
   }
   ```

2. 创建动态代理类，实现InvocationHandler接口

   ```java
   public class agency implements InvocationHandler {
       private UserService target; //目标对象
       public agency(UserService target){
           this.target = target;
       }
       public Object invoke(Object proxy, Method method, Object[] args) throws
           Throwable {
           //本方法中的其他输出输入增强
           //proxy 代理方法被调用的代理实例
           System.out.println("方法触发了");
           //执行被代理类 原方法
           Object invoke = method.invoke(target, args);
           System.out.println("执行完毕了");
           return invoke;
       }
   }
   ```

测试：

```java
@Test
public void test1(){
    //测试JDK动态代理技术
    UserService us = new UserServiceImpl();
    agency ag = new agency(us);
    //这里不能转换成一个实际的类，必须是接口类型
    UserService uservice = (UserService)
        Proxy.newProxyInstance(us.getClass().getClassLoader(),
                               us.getClass().getInterfaces(),ag);
    uservice.login();
}
```

##### CGlib实现代理

```
> 使用JDK创建代理有一个限制,它只能为接口创建代理实例.这一点可以从Proxy的接口方法
newProxyInstance(ClassLoader loader,Class [] interfaces,InvocarionHandler h)中看的很清楚
> 第二个入参 interfaces就是需要代理实例实现的接口列表.
> 对于没有通过接口定义业务方法的类,如何动态创建代理实例呢? JDK动态代理技术显然已经黔驴技穷,CGLib作为一个替代者,填补了这一空缺.
> CGLib采用底层的字节码技术,可以为一个类创建子类,在子类中采用方法拦截的技术拦截所有父类方法的调用并顺势织入横切逻辑.
```

1. 添加依赖包

   ```xml
   <dependency>
       <groupId>cglib</groupId>
       <artifactId>cglib</artifactId>
       <version>3.2.5</version>
   </dependency>
   ```

2. 创建普通类

   ```java
   public class Users{
   	public void login(){}
   }
   ```

3. 创建`CGlib`代理器

   ```java
   class CgProxy implements MethodInterceptor {
       public Object intercept(Object o, Method method, Object[] objects,
                               MethodProxy methodProxy) throws Throwable {
           System.out.println("输出语句1");
           //参数：Object为由CGLib动态生成的代理类实例，Method为上文中实体类所调用的被代理的方法
           //引用，Object[]为参数值列表，MethodProxy为生成的代理类对方法的代理引用。
           Object obj= methodProxy.invokeSuper(o,objects);
           System.out.println("输出语句2");
           return obj;
       }
   }
   ```

测试：

```java
public static void main(String[] args) {
    //1.创建真实对象
    Users users = new Users();
    //2.创建代理对象
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(users.getClass());
    enhancer.setCallback(new CglibProxy());
    Users o = (Users) enhancer.create();//代理对象
    o.login();
}
```

##### 两者区别：

1. `jdk`动态代理生成的代理类和委托类实现了相同的接口；
2. `cglib`动态代理中生成的字节码更加复杂，生成的代理类是委托类的子类，且不能处理被final关键字
   修饰的方法；
3. `jdk`采用反射机制调用委托类的方法，`cglib`采用类似索引的方式直接调用委托类方法；



#### spring中使用AOP

##### 实现过程

1. 步骤一：添加jar包

   ```xml
   <dependency>
       <groupId>aopalliance</groupId>
       <artifactId>aopalliance</artifactId>
       <version>1.0</version>
   </dependency>
   <dependency>
       <groupId>org.aspectj</groupId>
       <artifactId>aspectjweaver</artifactId>
       <version>1.8.13</version>
   </dependency>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-aspects</artifactId>
       <version>5.0.8.RELEASE</version>
   </dependency>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-aop</artifactId>
       <version>5.0.8.RELEASE</version>
   </dependency>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-core</artifactId>
       <version>5.0.8.RELEASE</version>
   </dependency>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-context</artifactId>
       <version>5.0.8.RELEASE</version>
   </dependency>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-beans</artifactId>
       <version>5.0.8.RELEASE</version>
   </dependency>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-context-support</artifactId>
       <version>5.0.8.RELEASE</version>
   </dependency>
   ```

2. 步骤二：添加项目原有的调取过程

3. 步骤三：创建增强类(本质上就是一个普通类)

   - 前置通知：目标方法运行之前调用 aop:before
   - 后置通知(如果出现异常不会调用)：在目标方法运行之后调用 aop:after-returning
   - 环绕通知：在目标方法之前和之后都调用 aop:around
   - 最终通知(无论是否出现 异常都会调用)：在目标方法运行之后调用 aop:after
   - 异常增强:程序出现异常时执行(要求：程序代码中不要处理异常) aop:after-throwing

   环绕增强：

   ```java
   public Object around(ProceedingJoinPoint point) throws Throwable{
       point.proceed();
   }
   ```

4. 步骤四：添加`aop`命名空间

   ```xml
   xmlns:aop="http://www.springframework.org/schema/aop"
   http://www.springframework.org/schema/aop
   http://www.springframework.org/schema/aop/spring-aop.xsd
   ```

5. 步骤五：设置配置文件

   ```xml
   <!--1.创建目标类对象-->
   <bean name="userService" class="com.xzk.spring.service.UserServiceImpl" />
   <!--2.配置增强类对象-->
   <bean name="myAdvice" class="com.xzk.spring.aop.MyAdivce" />
   <!-- 3.配置将增强织入目标对象-->
   <aop:config>
       <aop:pointcut id="pc"
                     expression="execution(* com.xzk.spring.service.ServiceImpl.*.*
                                 (..))"/>
       <aop:aspect ref="myAdvice">
           <aop:before method="before" pointcut-ref="pc" />
           <aop:after-returning method="afterReturning" pointcut-ref="pc"
                                />
           <aop:around method="around" pointcut-ref="pc" />
           <aop:after-throwing method="afterException" pointcut-ref="pc"
                               />
           <aop:after method="after" pointcut-ref="pc" />
       </aop:aspect>
   </aop:config>
   ```

