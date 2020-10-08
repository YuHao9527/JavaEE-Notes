## SpringMVC

### 一、 简介

`Spring MVC`属于`SpringFrameWork`的后续产品，已经融合在`Spring Web Flow`里面。`Spring `框架提供了构建
Web 应用程序的全功能 `MVC` 模块。 使用 `Spring` 可插入的 `MVC` 架构，可以选择是使用内置的 `Spring Web` 框架还是` Struts`这样的 Web 框架。通过策略接口，`Spring` 框架是高度可配置的，而且包含多种视图技术，例如`JavaServer Pages（JSP）`技术、`Velocity`、`Tiles`、`iText` 和 `POI`。`Spring MVC` 框架并不知道使用的视图，所以不会强迫您只使用 `JSP`技术。`Spring MVC` 分离了控制器、模型对象、分派器以及处理程序对象的角色，这种分离让它们更容易进行定制。

- `MVC`架构的应用：`webwork,struts1,struts2,springmvc...`

#### 1. Spring MVC 组件介绍

- `DispatcherServlet`：作为前端控制器，整个流程控制的中心，控制其它组件执行，统一调度，降低组件之间的耦合性，提高每个组件的扩展性。


- `HandlerMapping`：通过扩展处理器映射器实现不同的映射方式，例如：配置文件方式，实现接口方式，注解方式等。


- `HandlAdapter`：通过扩展处理器适配器，支持更多类型的处理器,调用处理器传递参数等工作!
- `ViewResolver`：通过扩展视图解析器，支持更多类型的视图解析，例如：jsp、freemarker、pdf、excel等。

#### 2. MVC 执行过程

![mvc流程](img\mvc流程.png)

##### DispatcherServlet

`DispatcherServlet`主要用作职责调度工作，本身主要用于控制流程，主要职责如下：

1. 文件上传解析，如果请求类型是`multipart`将通过`MultipartResolver`进行文件上传解析；
2. 通过`HandlerMapping`，将请求映射到处理器（返回一个`HandlerExecutionChain`，它包括一个处理器、多个
  `HandlerInterceptor`拦截器）；
3. 通过`HandlerAdapter`支持多种类型的处理器(`HandlerExecutionChain`中的处理器)；
4. 通过`ViewResolver`解析逻辑视图名到具体视图实现；
5. 本地化解析；
6. 渲染具体的视图等；
7. 如果执行过程中遇到异常将交`HandlerExceptionResolver`来解析。

![DispatcherServlet](img\DispatcherServlet.png)

##### DispatcherServlet辅助类

spring中的DispatcherServlet使用一些特殊的bean来处理request请求和渲染合适的视图。

| bean类型                                                     | 说明                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| Controller                                                   | 处理器/页面控制器，做的是`MVC`中的C的事情，但控制逻辑转移到前端控制器了，用于对请求进行处理。 |
| HandlerMapping                                               | 请求到处理器的映射，如果映射成功返回一个`HandlerExecutionChain`对象（包含一个`Handler`处理器（页面控制器）对象、多个`HandlerInterceptor`拦截器）对象；如`BeanNameUrlHandlerMapping`将URL与Bean名字映射，映射成功的Bean就是此处的处理器。 |
| HandlerAdapter                                               | `HandlerAdapter`将会把处理器包装为适配器，从而支持多种类型的处理器，即适配器设计模式的应用，从而很容易支持很多类型的处理器；如`SimpleControllerHandlerAdapter`将对实现了Controller接口的Bean进行适配，并且掉处理器的`handleRequest`方法进行功能处理。 |
| HandlerExceptionResolver（处理器异常解析器）                 | 处理器异常解析，可以将异常映射到相应的统一错误界面，从而显示用户友好的界面（而不是给用户看到具体的错误信息）。 |
| ViewResolver（视图解析器）                                   | `ViewResolver`将把逻辑视图名解析为具体的View，通过这种策略模式，很容易更换其他视图技术；如`InternalResourceViewResolver`将逻辑视图名映射为`jsp`视图。 |
| LocaleResolver & LocaleContextResolver（地区解析器和地区Context解析器） | 解析客户端中使用的地区和时区，用来提供不同的国际化的view视图。 |
| ThemeResolver                                                | 主题解析器,解析web应用中能够使用的主题，比如提供个性化的网页布局。 |
| MultipartResolver                                            | 多部件解析器,主要处理multi-part(多部件)request请求，例如：在HTML表格中处理文件上传。 |
| FlashMapManager                                              | `FlashMap`管理器储存并检索在"input"和"output"的`FlashMap`中可以在request请求间(通常是通过重定向)传递属性的`FlashMap`。 |

### 二、Spring MVC 搭建

#### 1. 实现过程

1. 添加jar包

   ```xml
   <dependency>
       <groupId>javax.servlet</groupId>
       <artifactId>javax.servlet-api</artifactId>
       <version>3.1.0</version>
       <scope>provided</scope>
   </dependency>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-webmvc</artifactId>
       <version>5.0.8.RELEASE</version>
   </dependency>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-context</artifactId>
       <version>5.0.8.RELEASE</version>
   </dependency>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-context-support</artifactId>
       <version>5.0.8.RELEASE</version>
   </dependency>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-web</artifactId>
       <version>5.0.8.RELEASE</version>
   </dependency>
   <dependency>
       <groupId>javax.servlet</groupId>
       <artifactId>jstl</artifactId>
       <version>1.2</version>
   </dependency>
   ```

2. 修改web.xml

   ```xml
   <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns="http://java.sun.com/xml/ns/javaee"
            xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
   http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" version="2.5">
     
     <servlet>
       <servlet-name>dispatcher</servlet-name>
       <servlet-class>
         org.springframework.web.servlet.DispatcherServlet
       </servlet-class>
       <init-param>
         <param-name>contextConfigLocation</param-name>
         <param-value>classpath:spring-mvc.xml</param-value>
       </init-param>
     </servlet>
     <servlet-mapping>
       <servlet-name>dispatcher</servlet-name>
       <url-pattern>/</url-pattern>
     </servlet-mapping>
   </web-app>
   ```

   - / 和 /* 的区别

     `<url-pattern> / </url-pattern>` 不会匹配到`*.jsp`，即：`*.jsp`不会进入`Spring`的 `DispatcherServlet`类 。
     `<url-pattern> /* </url-pattern>` 会匹配`*.jsp`，会出现返回`jsp`视图时再次进入`Spring`的`DispatcherServlet` 类，导致找不到对应的controller，所以报404错。
     可以配置 `/ `，此工程 所有请求全部由`SpringMVC`解析，此种方式可以实现 `RESTful`方式，需要特殊处理对静态文件的解析不能由`SpringMVC`解析
     可以配置`.do`或`.action`，所有请求的`url`扩展名为`.do`或`.action`由`SpringMVC`解析，此种方法常用。
     不可以`/*`，如果配置`/*`，返回`jsp`也由`SpringMVC`解析，这是不对的。

   - url-pattern有5种配置模式

     - `/xxx`:完全匹配`/xxx`的路径
     - `/xxx/*`:匹配以`/xxx`开头的路径，请求中必须包含`xxx`。
     - `/*`：匹配`/`下的所有路径,请求可以进入到`action`或`controller`，但是转发`jsp`时再次被拦截，不能访问`jsp`界面。
     - `.xx`:匹配以`xx`结尾的路径，所有请求必须以`.xx`结尾，但不会影响访问静态文件。
     - `/`:默认模式，未被匹配的路径都将映射到`servlet`，对`jpg`，`js`，`css`等静态文件也将被拦截，不能访问。

3. 修改ApplicationContext配置文件

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:p="http://www.springframework.org/schema/p"
          xmlns:aop="http://www.springframework.org/schema/aop"
          xmlns:context="http://www.springframework.org/schema/context"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
                              http://www.springframework.org/schema/beans/spring-beans.xsd
                              http://www.springframework.org/schema/context
                              http://www.springframework.org/schema/context/spring-context.xsd
                              http://www.springframework.org/schema/aop
                              http://www.springframework.org/schema/aop/spring-aop.xsd"
          >
       <!-- 扫描包注解(包括子孙包)-->
       <context:component-scan base-package="com.spring.controller"/>
       <!-- 视图解析器ViewResolver -->
       <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
           <!-- jsp所在的位置-->
           <property name="prefix" value="/" />
           <!-- jsp文件的后缀名-->
           <property name="suffix" value=".jsp" />
       </bean>
   </beans>
   ```

4. 创建控制器类

   - @Controller：注解创建控制器类对象

   - @RequestMapping("请求地址")

     - 设置@RequestMapping method属性

       @RequestaMapping(method=RequestMethod.GET, value="请求名")

### 三、接参

- 前端请求：

  ```html
  <html>
      <head></head>
      <body>
          <a href="请求地址?username=zhangsan&age=18">test</a>
      </body>
  </html>
  ```


- 接收方式：

  1. HttpServletRequest

     ```java
     @Controller
     public class Controller {
     	
         @RequestMapping("请求地址")
         public String test(HttpServletRequest request) {
     		//弊端：接收的为字符串类型，其他类型需要转换
     		String username = request.getParameter("username");
         }
     }
     ```

  2. 页面传值时的key=处理请求的方法的参数名

     ```java
     @Controller
     public class Controller {
     	
         @RequestMapping("请求地址")
         public String test(String username, int age) {
     		//必须与页面传入的key值相同才能接收
         }
     }
     ```

     **方法的参数名与传参的key值不同：**

     ```java
     @Controller
     public class Controller {
     	
         @RequestMapping("请求地址")
         public String test(@RequestParam(value = "username") String name, int age) {
     		//value值为页面key值
         }
         
         @RequestMapping("请求地址")
         public String test(@RequestParam(default = "zhangsan") String name, int age) {
     		//也可设置默认值
         }
     }
     ```

  3. 使用控件名和对象的属性名一致的方式进行接收（常用）

     - 创建`JavaBean`对象(属性名与页面key值相同，生成getter、setter方法)

       ```java
       public class User {
       	private String username;
           private int age;
           
           //getter、setter方法省略
       }
       ```

     - 填入参数

       ```java
       @Controller
       public class Controller {
       	
           @RequestMapping("请求地址")
           public String test(User user) {
               //通过getter、setter方法取值
       		String username = user.getUsername();
           }
       }
       ```

> 控制台乱码问题：

![编码](img\编码.png)

> 常见错误：

 					![400](img\400.png)

**错误原因：给定的数据无法由框架转换成目标类型**

>解决日期格式问题方式：
>
>`springmvc`框架默认支持转换得日期格式:`yyyy/MM/dd`
>
>1. 使用string接受日期，接收后，再通过 `SimpleDataFormate`转换
>
>2. 使用工具类处理日期       
>
>   - 导包
>
>     ```xml
>     <dependency>
>         <groupId>joda-time</groupId>
>         <artifactId>joda-time</artifactId>
>         <version>2.9.9</version>
>     </dependency>
>     ```
>
>   - 配置文件
>
>     ```xml
>     <!--配置注解驱动-->
>     <mvc:annotation-driven/>
>     ```
>
>   - 使用
>
>     ```java
>     @RequestMapping("请求地址")
>     public String test1(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday){
>         
>     }
>     ```
>
>     **补充:**参数类型使用引用数据类型，基本数据类型使用包装类

### 四、返参

- 首先修改`web.xml`文件版本,用来支持`jsp`操作EL表达式

```xml
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns="http://java.sun.com/xml/ns/javaee"
xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" version="2.5">

   
</web-app>
```

- 返参方式：

  1. `HttpServletRequest`

     ```java
     @RequestMapping("请求地址")
     public String test1(HttpServletRequest request, String username){
         //转发时显示，重定向丢失
         request.setAttribute("username", username);
         return "success";
     }
     ```

     **前端：**

     ```jsp
     <html>
         <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        	<body>
            	<h2>姓名:${username}</h2>
         </body>
     </html>
     ```

  2. `ModelMap`,默认作用域request

     ```java
     @RequestMapping("请求地址")
     public String test1(ModelMap map, String username){
         //转发时显示，重定向丢失
         map.addAttribute("username", username);
         return "success";
     }
     ```

  3. `ModelAndView` 对象需要new,同时作为返回值类型

     ```java
     @RequestMapping("请求地址")
     public ModelAndView test1(HttpServletRequest request, String username){
         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("username", username);
         modelAndView.setViewName("success");
         return modelAndView;
     }
     ```

  4. `Model`类保存数据

     ```java
     @RequestMapping("请求地址")
     public String test1(Model model, String username){
         //转发时显示，重定向丢失
         model.addAttribute("username" + username);
         return "success";
     }
     ```

### 五、Session存值

1. 使用`HttpSession`

   - request.getSession();

     ```java
     @RequestMapping("请求地址")
     public String test1(HttpServletRequest request, String username){
         HttpSession session = request.getSession();
         session.setAttribute("username", username);
         return "success";
     }
     ```

   - HttpSession session

     ```java
     @RequestMapping("请求地址")
     public String test1(HttpSession session, String username){
         session.setAttribute("username", username);
         return "success";
     }
     ```

2. 使用`@sessionAttributes("key值")`

   ```
   key值写的是ModelMap中定义的key值

   注：该注解和ModelMap结合使用,当使用ModelMap存值时,会在session中同时存储一份数据

   @SessionAttributes()的小括号中如果是一个值，不要加{}
   示例：
       @SessionAttributes("key")
       @SessionAttributes({"key1","key2"})

   清除注解session:
       SessionStatus类
       status.setComplete();
   ```

   ```java
   @Controller
   @SessionAttributes("username")
   public class Controller {
       @RequestMapping("请求地址")
       public String test1(ModelMap map,String username){
           map.addAttribute("username", username);
           return "success";
       }
       
       //清除@SessionAttributes注解的值
       @RequestMapping("请求地址")
       public String test1(SessionStatus status){
           status.setComplete();
           return "success";
       }
   }
   ```

### 六、弹窗响应

输出流的问题（返回值必须是void）

```java
@RequestMapping("请求地址")
public void test(HttpServletResponse response) throws IOException{
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter pw = response.getWriter();
    pw.print("<script type='text/javascript'>alert('test');</script>");
}
```

##### get请求乱码

`tomcat8`已经默认配置，不需要我们处理

![get乱码](img\get乱码.png)

##### **post请求乱码**

注意:这里只能处理接收后数据的编码，如果是其他位置的编码问题还需要再考虑处理方案

```xml
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns="http://java.sun.com/xml/ns/javaee"
xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" version="2.5">

    <!--处理post乱码-->
    <filter>
        <filter-name>charset</filter-name>
        <filter-class>
            org.springframework.web.filter.CharacterEncodingFilter
        </filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>charset</filter-name>
        <url-pattern>*.do</url-pattern>
    </filter-mapping>
   
</web-app>
```

### 七、转发和重定向

- 默认转发跳转

  ```java
  @RequestMapping("请求地址")
  public String test(){
      return "forward:/WEB_INF/success.jsp";
  }
  ```

- 重定向

  ```java
  @RequestMapping("请求地址")
  public String test(){
      return "redirect:success.jsp";//或者重定向到一个请求:"redirect:login.do"
  }

  //注意：重定向时地址栏会发生拼接modelmap中值的问题
  ```

### 八、异常处理

- 方法一、在`web.xml`响应状态码配置一个对应页面

  ```xml
  <error-page>
      <error>404</error>
      <location>/404.html</location>
  </error-page>
  ```

- 方法二、@ExceptionHandler()

  ```java
  //异常测试
  @RequestMapping("请求地址")
  public String test(){
      String a = null;
      System.out.println(a.charAt(0));
      return "success.jsp";
  }
  //配置异常结果界面
  @ExceptionHandler(NullPointerException.class)
  public String execeptionResult(){
      return "exception";
  }
  ```

- 全局异常：@ControllerAdvice

  ```java
  //@ControllerAdvice使一个Contoller成为全局的异常处理类，类中用@ExceptionHandler方法注解的方法可以处理所有Controller发生的异常。

  @ControllerAdvice
  public class ExceptionController {
  	//处理全局异常
      @ExceptionHandler(NullPointerException.class)
      public String execeptionResult(){
          return "exception";
      }
  }
  ```

### 九、Cookie与头信息

- @CookieValue("key值")获取Cookie信息

  ```java
  @RequestMapping("请求地址")
  public String testCookie(@CookieValue("JSESSIONID")String cookie){
      System.out.println("cookie:"+cookie);
      return "success";
  }
  ```

- @RequestHeader("key值")获取头信息

  ```java
  @RequestMapping("请求地址")
  public String testHeader(@RequestHeader("User-Agent")String header){
      System.out.println("Header:" + header)
      return "success";
  }
  ```

### 十、RestFul

REST:即Representational State Transfer ,(资源)表现层状态转化,是目前最流行的一种互联网软件架构。

具体说，就是HTTP协议里面,四个表示操作方式的动词:
GET POST PUT DELETE
它们分别代表着四种基本操作:

- GET用来获取资源

- POST用来创建新资源

- PUT用来更新资源

- DELETE用来删除资源

示例:

```
1. order?method=insert&id=1
	/order/1 HTTP POST : 新增 order

2. order?method=delete&id=1
	/order/1 HTTP DELETE: 删除 id=1 的order
  
3. order?method=update&id=1
	/order/1 HTTP PUT : 更新id = 1的 order

4. order?method=select&id=1
	/order/1 HTTP GET :得到id = 1 的 order
	
通过修改http的状态值来标记请求的目的。
```

#### Spring中实现`RestFul`风格

`HiddenHttpMethodFilter:`浏览器form表单只支持GET和POST,不支持DELETE和PUT请求,Spring添加了一个过滤器,可以将这些请求转换为标准的HTTP方法,支持GET,POST,DELETE,PUT请求!

##### 实现步骤：

1. `web.xml`添加`HiddenHttpMethodFilter`配置

   ```xml
   <filter>
       <filter-name>HiddenHttpMethodFilter</filter-name>
       <filter-class>
           org.springframework.web.filter.HiddenHttpMethodFilter
       </filter-class>
   </filter>
   <filter-mapping>
       <filter-name>HiddenHttpMethodFilter</filter-name>
       <url-pattern>/*</url-pattern>
   </filter-mapping>
   ```

2. 实现查,改,删 框架

   ```java
   @RequestMapping(value = "/list",method = RequestMethod.GET)
   @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
   @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
   ```

3. `Jsp`代码

   ```html
   <!--删除操作-->
   <a href="javascript:void(0)" onclick="deleteById()">删除</a>
   <form action="/order/1" method="post" id="deleteForm">
       <input type="hidden" name="_method" value="DELETE" />
   </form>

   <!--修改操作-->
   <a href="javascript:void(0)" onclick="updateById()">修改</a>
   <form action="/order/1" method="post" id="updateForm">
       <input type="hidden" name="_method" value="PUT" />
   </form>

   <!--表单提交-->
   <script>
       function updateById() {
           var form = document.getElementById("updateForm");
           form.submit();
       }
       function deleteById() {
           var form = document.getElementById("deleteForm");
           form.submit();
       }
   </script>
   ```

   **注意：**

   由于`doFilterInternal`方法只对method为post的表单进行过滤，所以在页面中必须如下设置：

   ```html
   <form action="..." method="post">
   	<input type="hidden" name="_method" value="put" />
   </form>
   ```

   代表post请求,但是`HiddenHttpMethodFilter`将把本次请求转化成标准的put请求方式。`name="_method"`固定写法!

4. Controller

   - **`@PathVariable`获取路径参数**

   ```java
   @RequestMapping("/user/list/{id}")
   public String getData(@PathVariable(value = "id") Integer id){
   	System.out.println("id = " + id);
   	return "list" ;
   }
   ```

   - **其他请求**

     ```java
     @RequestMapping(value = "/order",method = RequestMethod.POST)
     @RequestMapping(value = "/order/{id}",method = RequestMethod.DELETE)
     @RequestMapping(value = "/order/{id}",method = RequestMethod.PUT)
     @RequestMapping(value = "/order",method = RequestMethod.GET)

     //注意:如果访问put和delete请求的时候，报405：method not allowed。处理方式是将过滤器的请求地址改成/，而不是/*
     ```

### 十一、静态资源访问

需要注意`DispatcherServlet`拦截资源设置成了 / 避免了死循环,但是 / 不拦截`jsp`资源,但是它会拦截其他静态资源,例如 `html`, `js `, `css`,`image`等等, 那么我们在使用`jsp`内部添加 静态资源就无法成功,所以,我们需要单独处理下静态资源!

**处理方案:** 在`SpringMVC`的配置文件中添加`mvc`命名空间下的标签!

1. 修改`Spring MVC`对应配置文件,添加`mvc`命名空间和约束

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xmlns:context="http://www.springframework.org/schema/context"
   xmlns:mvc="http://www.springframework.org/schema/mvc"
   xsi:schemaLocation="http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans.xsd
   http://www.springframework.org/schema/context
   http://www.springframework.org/schema/context/spring-context.xsd
   http://www.springframework.org/schema/mvc
   http://www.springframework.org/schema/mvc/spring-mvc.xsd
   ">
   ```

2. 添加处理标签

   ```xml
   <!--注解驱动-->
   <mvc:annotation-driven /> 
   <!--配置静态资源请求地址与本地地址映射-->
   <mvc:resources mapping="/img/**" location="/images/"/>
   <mvc:resources mapping="/css/**" location="/css/"/>
   ```

   或者

   ```xml
   <!--注解驱动-->
   <mvc:annotation-driven /> 
   <!--配置所有静态资源访问地址-->
   <mvc:default-servlet-handler/>
   ```

### 十二、Json处理

1. 添加Jar包

   ```xml
   <dependency>
       <groupId>com.fasterxml.jackson.core</groupId>
       <artifactId>jackson-databind</artifactId>
       <version>2.9.5</version>
   </dependency>
   ```

2. @ResponseBody注解实现

   ```java
   @RequestMapping("请求地址")
   public @ResponseBody User test() {
       //自动转化为JSON格式
       return new User();
   }

   //注意：需要在web.xml配置文件添加 <mvc:annotation-driven/>
   ```

### 十三、SpringMVC拦截器

#### 实现过程

1. 创建拦截器类

   ```java
   //实现接口HandlerInterceptor
   public class MyInterceptor implements HandlerInterceptor {

       //拦截器开始
       @Override
       public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
           //执行顺序：preHandle-->Controller-->postHandle-->afterCompletion
           //return: true--继续执行 false--不继续往后执行
           return false;
       }

       //拦截器结束
       @Override
       public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

       }

       //无论是否发生异常都要执行
       @Override
       public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

       }
   ```

2. 配置拦截器

   ```xml
   <!--拦截所有请求-->
   <mvc:interceptors>
   	<bean id="interceptor" class="util.MyInterceptor"/>
   </mvc:interceptors>

   <!--拦截指定请求-->
   <mvc:interceptors>
       <mvc:interceptor >
           <mvc:mapping path="/请求名" />
           <mvc:mapping path="/请求名" />
           <bean id="interceptor" class="util.MyInterceptor"/>
       </mvc:interceptor>
   </mvc:interceptors>
   ```

**补充：**`SpringMVC`拦截器使用场景

1. 日志记录：记录请求信息的日志
2. 权限检查：如登录检查
3. 性能检测：检测方法执行时间

#### SpringMVC的拦截器（Interceptor）和过滤器（Filter）的区别与联系

- 过滤器

   ```
     依赖于servlet容器。在实现上基于函数回调，可以对几乎所有请求进行过滤，但是缺点是一个过滤器实例只能在容器初始化时调用一次。使用过滤器的目的是用来做一些过滤操作，获取我们想要获取的数据，比如：在过滤器中修改字符编码；在过滤器中修改HttpServletRequest的一些参数，包括：过滤低俗文字、危险字符等
   ```

- 拦截器

  ```
  依赖于web框架，在SpringMVC中就是依赖于SpringMVC框架。在实现上基于Java的反射机制，属于面向切面编程
  （AOP）的一种运用。由于拦截器是基于web框架的调用，因此可以使用Spring的依赖注入（DI）进行一些业务操
  作，同时一个拦截器实例在一个controller生命周期之内可以多次调用。但是缺点是只能对controller请求进行拦截，对其他的一些比如直接访问静态资源的请求则没办法进行拦截处理。
  ```

  **多个过滤器与拦截器的代码执行顺序:**

   1. 过滤器的运行是依赖于`servlet`容器的，跟`SpringMVC`等框架并没有关系。并且，多个过滤器的执行顺序跟`xml`文件中定义的先后关系有关

   2. 对于多个拦截器它们之间的执行顺序跟在`SpringMVC`的配置文件中定义的先后顺序有关

   3. 最终顺序：

      ![拦截器](img\拦截器.png)

### 十四、文件上传和下载

  ```
Spring MVC为文件上传提供了直接支持,这种支持是通过即插即用的MultipartResolver实现。

Spring使用Jakarta Commons FileUpload技术实现了一个MultipartResolver实现类:CommonsMultipartResolver。

在SpringMVC上下文中默认没有装配MultipartResolver,因此默认情况下不能处理文件上传工作。
如果想使用Spring的文件上传功能,则需要先在上下文中配置MultipartResolver。
  ```

#### 文件上传

##### 实现步骤

1. 添加Jar包

   ```xml
   <dependency>
       <groupId>commons-fileupload</groupId>
       <artifactId>commons-fileupload</artifactId>
       <version>1.3.1</version>
   </dependency>
   <dependency>
       <groupId>commons-io</groupId>
       <artifactId>commons-io</artifactId>
       <version>2.4</version>
   </dependency>
   ```

2. 配置`MultipartResolver`

   ```xml
   <mvc:annotation-driven/>
   <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
   	<!-- 指定编码格式 -->
       <property name="defaultEncoding" value="UTF-8"/>
       <!-- 指定上传文件大小 -->
       <property name="maxUploadSize" value="9999999" />
   </bean>
   ```

3. 页面表单,提交方式必须是post

   ```html
   <form action="/upload" method="post" enctype="multipart/form-data">
       文件：<input type="file" name="myFile">
       <input type="submit" value="上传">
   </form>
   ```

4. 配置Java代码(注意要创建文件夹保存上传之后的文件)

   ```java
   @RequestMapping("/upload")
   public String saveFile(HttpServletRequest request, MultipartFile myFile) {
       //1. 将上传文件夹转换成服务器路径
       String path = request.getServletContext().getRealPath("/uploadImg");
      	//2. 得到上传的文件名
       String fileName = myFile.getOriginalFilename();
       //3. 上传
       if (!myFile.isEmpty()){
           try {
               myFile.transferTo(new File(path + "/" + fileName));
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return "success";
   }
   ```


| 方法名称                     | 方法解释                                          |
| ---------------------------- | ------------------------------------------------- |
| byte [] getBytes()           | 获取文件数据                                      |
| String getContentType()      | 获取文件`MIMETYPE`类型,如image/jpeg，text/plain等 |
| InputStream getInputStream() | 获取文件输入流                                    |
| String getName()             | 获取表单中文件组件的名称 name 值                  |
| String getOriginalFilename() | 获取文件上传的原名                                |
| long getSize()               | 获取文件的字节大小,单位为byte                     |
| boolean isEmpty()            | 是否有长传的文件                                  |
| void transferTo(File dest)   | 可以将上传的文件保存到指定的文件中                |

#### 文件下载

##### 实现步骤

1. 添加Jar包

   ```xml
   <dependency>
       <groupId>commons-io</groupId>
       <artifactId>commons-io</artifactId>
       <version>2.4</version>
   </dependency>
   ```

2. 配置处理类方法

   ```java
   @RequestMapping("/download")
   public ResponseEntity<byte[]> downloadFile(String fileName, HttpServletRequest request) throws IOException {
       //1. 转换服务器地址
       String path = request.getServletContext().getRealPath("/uploadImg");
       //2. 得到要下载的文件路径
       String filePath = path + "/" + fileName;
       //3. 设置响应头信息
       HttpHeaders httpHeaders = new HttpHeaders();
       httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       //给用户弹窗的方式进行下载
       //attachment 用来表示以附件的形式响应给客户端
       httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode(fileName, "UTF-8"));
       //4. 创建文件
       File file = new File(filePath);
       //5. 将文件进行返回
       ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.CREATED);
       return responseEntity;
   }
   ```