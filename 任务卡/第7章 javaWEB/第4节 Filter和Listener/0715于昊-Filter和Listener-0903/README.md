## Filter与Listener

### 过滤器(Filter)

过滤器实际上就是对web资源进行拦截，做一些处理后交给下一个过滤器或servlet处理，通常都是用来拦截request进行处理的，也可以对返回的response进行拦截处理

![过滤器](/images/a1.png)

#### 过滤器的语法格式

##### 1. 创建一个类实现Filter接口

```java
public class FilterDemo implements Filter {}
```

##### 2. 重写接口中的方法

```java
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化方法
        //接收一个FilterConfig类型的参数，该参数是Filter的一些配置
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //过滤方法
        //主要是对request和response进行过滤处理，然后交给下一个过滤器或Servlet处理
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        //销毁Filter的方法
    }
```

##### 3. 在web.xml文件中配置

```xml
<filter>
    <filter-name>过滤器名称</filter-name>
    <filter-class>过滤器所在的路径</filter-class>
</filter>
<filter-mapping>
    <filter-name>过滤器名称</filter-name>
    <url-pattern>需要过滤的资源</url-pattern>
</filter-mapping>
```

#### 使用场景

```
1. 防止用户未登录就执行后续操作
	String name=(String)session.getAttribute("key");
    if(name==null){
    //跳转到登录页面
    }
2. 设置编码方式-统一设置编码
3. 加密解密(用户密码)
4. 非文字筛选
5. 下载资源的限制

过滤器特点:
	在servlet之前和之后都会执行
```

### 监听器(Listener)

监听器就是监听某个域对象的的状态变化的组件。

#### 监听器的相关概念：

- 事件源：被监听的对象(三个域对象request、session、servletContext)


- 监听器：监听事件源对象事件源对象的状态的变化都会触发监听器
- 注册监听器：将监听器与事件源进行绑定
- 响应行为：监听器监听到事件源的状态变化时所涉及的功能代码（程序员编写代码）

#### 监听器分类

- 第一维度按照监听对象划分:

  - ServletRequest域
  - HttpServlet域
  - ServletContext域

- 第二维度按照监听的内容划分:

  - 监听域对象的创建与销毁
  - 监听域对象的属性变化

  ![监听器分类](/images/a2.png)

####监听器的语法格式

##### 1. 编写一个类去实现监听器(Listener)接口(以HttpSessionListen为例)

```java
public class SessionListener implements HttpSessionListener {}
```

##### 重写接口的方法

```java
	@Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //监听Session创建的方法
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //监听Session销毁的方法
    }

HttpSeesion对象的生命周期:
	创建：第一次调用request.getSession()时创建
	销毁: 服务器关闭销毁、session过期(默认1800秒)、手动销毁
```

##### 3. 在web.xml文件中配置

```xml
<listener>
	<listener-class>监听器所在的路径</listener-class>
</listener>
```

#### 使用场景

```
1. ServletContextListener
	初始化工作: 初始化对象、初始化数据(加载数据库驱动、连接池初始化) 加载一些初始化配置文件(Spring的配置文件) 任务调度(定时器-Timer/TimerTask)
2. HttpSessionListen
	由于每次访问网站默认都会创建session对象，可以用于统计网站在线人数
3. ServletRequestListenr
	每一次请求都会创建request，可以统计网站的访问量
4. 监听域对象内部属性变化的监听器
	使用的很少，有特定需求可以使用；比如说实时更新网站数据
```

