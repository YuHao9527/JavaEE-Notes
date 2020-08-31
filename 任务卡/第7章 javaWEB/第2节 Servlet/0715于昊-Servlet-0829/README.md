## Servlet

### Servlet概述

1. Servlet(Server Applet)，全称Java Servlet。是用Java编写的服务器端程序，其主要功能在于交互式地浏览和修改数据，生成动态Web内容。狭义的Servlet是指Java语言实现的一个接口，广义的Servlet是指任何实现了这个Servlet接口的类，一般情况下，人们将Servlet理解为后者。

2. Servlet运行于支持Java的应用服务器中。从实现上讲，servlet可以响应任何类型的请求，但绝大多数情况下Servlet只用来扩展基于HTTP协议的Web服务器。

3. Servlet工作模式：

   ```
   1. 客户端发送请求至服务器
   2. 服务器启动并调用Servlet，Servlet根据客户端请求生成响应内容并将其传给服务器
   3. 服务器将响应返回客户端
   ```

### Servlet API

![servlet](/images/servlet.png)

### 第一个Servlet

1. 创建一个类实现Servlet接口，重写方法。(或者继承HttpServlet)

   ```java
   class LoginServlet implements Servlet {
       @Override
       public void init(ServletConfig servletConfig) throws ServletException {
           //这是初始化方法
       }
       
       @Override
       public ServleConfig getServletConfig() {
           return null;
       }
       
       @Override
       public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
           //处理get/post请求的方法
       }
       
       @Override
       public String getServletInfo() {
           return null;
       }
       
       @Override
       public void destroy() {
           //销毁Servlet的方法
       }
       
   }
   ```

2. 在web.xml文档中配置映射关系

   ```xml
   XML中配置好这个Servlet的映射关系：

       <servlet>
           <servlet-name>自定义名称</servlet-name>
           <servlet-class>处理请求的类的完整路径</servlet-class>
       </servlet>
       <servlet-mapping><!-- mapping 表示映射 -->
           <servlet-name>自定义名称</servlet-name>
           <url-pattern>请求名</url-pattern>
       </servlet-mapping>

   标签的执行顺序：
   	请求过来以后->web.xml->servlet-mapping标签中的url-pattern标签中的内容和请求名进行匹配->匹配成功后找对应的servlet-mapping标签中的servlet-name->去servlet标签中找和上一个servlet-name相同的name值->去找servlet标签中的servlet-class中处理类的完整路径。
   ```

3. 启动tomcat，在浏览器中输入[http://localhost:8080/](http://localhost:8080/)工程名/访问服务器的路径

### Servelt工作原理

- Servelt接口口定义了**Servlet与Servlet容器**之间的约定。这个约定是：Servlet容器将Servlet类载入内存，并产生Servlet实例和调用它具体的方法。但是要注意的是，**在一个应用程序中，每种Servlet类型只能有一个实例**。
- 用户请求致使Servlet容器调用Servlet的Service()方法，**并传入一个ServletRequest对象和一个ServletResponse对象。ServletRequest对象和ServletResponse对象都是由Servlet容器（例如TomCat）封装好的，并不需要程序员去实现，程序员可以直接使用这两个对象**。
- ServletRequest中封装了当前的Http请求，因此，开发人员不必解析和操作原始的Http数据。ServletResponse表示当前用户的Http响应，程序员只需直接操作ServletResponse对象就能把响应轻松的发回给用户。
- 对于每一个应用程序，**Servlet容器还会创建一个ServletContext对象。这个对象中封装了上下文（应用程序）的环境详情。每个应用程序只有一个ServletContext。每个Servlet对象也都有一个封装Servlet配置的ServletConfig对象**。

### Servlet的生命周期

```
1. 当客户端首次发送第一次请求后，由容器(web服务器(tomcat))去解析请求, 根据请求找到对应的servlet,判断该类的对象是否存在，不存在则创建servlet实例，调取init()方法 进行初始化操作,初始化完成后调取service()方法,由service()判断客户端的请求方式，如果是get，则执行doGet(),如果是post则执行doPost().处理方法完成后,作出相应结果给客户端.单次请求处理完毕。

2. 当用户发送第二次以后的请求时,会判断对象是否存在,但是不再执行init()，而直接执行service方法,调取doGet()/doPost()方法。

3. 当服务器关闭时调取destroy()方法进行销毁。
```

简单来说就是四个过程：

1. 实例化-->先创建servlet实例
2. 初始化-->调用init()方法
3. 处理请求-->调用service()方法
4. 服务终止-->调用destroy()方法销毁

![生命周期](/images/生命周期.png)

### 请求

