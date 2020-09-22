### maven任务卡

#### ProjectA

```
项目A添加了druid数据库连接池、mysql驱动两个依赖，并且添加工具类DruidUtil用于搭建JDBC环境。
然后通过maven的install指令导出jar包到本地仓库。
```

#### ProjectB

```
项目B导入项目A的jar包，编写测试类成功测试DruidUtil，编写SQL语句查询用户姓名，运行成功。
```

#### 相关Bug

- 不再支持源选项 5。请使用 6 或更高版本。(Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project myproject: Compilation failur)

  ```
  解决方法：
  	百度查询所有方法试过后没有解决，更换jdk版本1.8,我之前用的是jdk11,更换后问题解决。
  ```

- 新建maven项目时，从远程仓库下载依赖速度很慢

  ```
  解决办法:
  	导入阿里云镜像，方法如最后一个教学视频，先导入不影响学习。
  ```

  ​