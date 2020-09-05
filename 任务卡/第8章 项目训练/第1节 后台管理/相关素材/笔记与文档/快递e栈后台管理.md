

# 编写流程

## 管理员的登陆

## 快递管理

### 子模块

#### 快递的列表

- 分页查询的列表

#### 新增快递

- 用户输入内容，后台接收参数，向数据库存储

#### 删除快递

- 用户输入快递单号查询到快递信息
- 浏览快递信息的最后，可以点击删除按钮 ，删除快递

#### 修改快递

- 用户输入快递单号查询到快递信息
- 浏览（可修改）快递信息的最后，可以点击确认按钮 ，确认修改快递

### 编写的流程

#### 创建数据库表格（Express）

![image-20200720154809012](C:\Users\cdd\AppData\Roaming\Typora\typora-user-images\image-20200720154809012.png)

#### 编写DAO

#### 编写Service



#### 编写Controller



#### 前后端的交互





前端发起ajax→DispatcherServlet→Controller→Service→DAO→数据库

**标准流程**

- 前端发起ajax

  ```
  		$("按钮选择器").click(function(){
              //1.    先使用layer，弹出load（提示加载中...）
              var windowId = layer.load();
              //2.    ajax与服务器交互
              $.post("服务器地址",参数JSON,function(data){
                  //3.    关闭load窗口
                  layer.close(windowId);
                  //4.    将服务器回复的结果进行显示
                  layer.msg(data.result);
              },"JSON");
          });
  ```

- 编写Controller,用于处理ajax的请求

  - 在Controller中调用service处理
  - 处理完毕, 根据service返回的结果,给ajax返回

### api文档

#### 快递 部分

##### 1. 用于获取控制台所需的快递数据

```
请求地址：express/console.do
参数列表：无
返回的格式示例：
	{
		status:0,
		reuslt:"获取成功",
		data:[
			{//全部的快递
				size:1000,//快递总数
				day:100//今日新增
			},{//待取件快递
				size:500,//待取件数
				day:100//今日新增
			}
		]
	}
```

##### 2. 快件列表（分页）

```
请求地址：express/findAll.do
参数列表：
	1.	limit:
			值:0,表示开启分页(默认)
			值:1,表示查询所有
	2.	offset：
			值:数字，表示SQL语句起始索引
	3.	pageNumber：
			值：数字，表示获取的快递数量
			
返回的格式示例：
```

##### 3.根据单号查询快递信息

```
请求地址：express/findByNumber.do
参数列表：
	1.	number：快递单号
	
返回的格式示例：
```

##### 4. 根据取件码查询快递信息

```
请求地址：express/findByCode.do
参数列表：
	1.	code：取件码
	
返回的格式示例：
```

##### 5. 根据用户的手机号，查询快递信息

```
请求地址：express/findByUserPhone.do
参数列表：
	1.	phoneNumber：手机号码
	2.	status：
			值：0表示查询待取件的快递（默认）
			值：1表示查询已取件的快递
			值：2表示查询用户的所有快递
	
返回的格式示例：
```

##### 6.根据录入人的手机号，查询快递信息（快递员/柜子的历史记录）

```
请求地址：express/findBySysPhone.do
参数列表：
	1.	sysPhone：手机号码
	
返回的格式示例：
```

##### 7.进行快递数量的排序查询（用户表）

```
请求地址：express/lazyboard.do
参数列表：
	1.	type：
			值：0，表示查询总排名
			值：1，表示查询年排名
			值：2，表示查询月排名
	
返回的格式示例：
```

##### 8.快件录入

```
请求地址：express/insert.do
参数列表：
	1.	number：快递单号
	2.	company：快递公司
	3.	username：收件人姓名
	4.	userPhone：收件人手机号码
录入成功返回的格式示例：
	
录入失败返回的格式示例：
```

##### 

##### 9. 修改快递信息

```
请求地址：express/update.do
参数列表：
	1.	id：要修改的快递id
	2.	number：新的快递单号
	3.	company:新的快递公司
	4.	username：新的收货人姓名
	5.	userPhone:新的收件人手机号码，（手机号码更新，重新生成取件码，并发送短信）
	6.	status：新的快递的状态

返回的格式示例：
```

##### 10. 根据id删除快递信息

```
请求地址：express/delete.do
参数列表：
	1.	id：	要删除的快递的id
	
返回的格式示例：
	
```

##### 11.确认取件

```
请求地址：express/updateStatus.do
参数列表：
	number：要更改状态为已取件的快递单号
	
返回的格式示例：
```



## 用户的管理

## 快递员管理

## 控制台显示

