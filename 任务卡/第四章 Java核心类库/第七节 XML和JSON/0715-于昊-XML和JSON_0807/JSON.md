## JSON

### 简介

```json
	JSON(JavaScript Object Notation, JS 对象简谱) 是一种轻量级的数据交换格式。它基于 ECMAScript (欧洲计算机协会制定的js规范)的一个子集，采用完全独立于编程语言的文本格式来存储和表示数据。简洁和清晰的层次结构使得 JSON 成为理想的数据交换语言。 易于人阅读和编写，同时也易于机器解析和生成，并有效地提升网络传输效率。                           ---百度百科
	实例：
        {
            "name":"小明",
            "age":18,
            "friends":["张三","李四","王二","麻子",{
                "name":"小红",
                "info":"我很喜欢"
            }],
        }

这个对象包含三个属性(name、age、friends),属性friends包含一个数组,数组里面又包含一个对象(属性：name、info)
```

### java与JSON

```
做什么?
    将Java中的对象 快速的转换为 JSON格式的字符串。
    将JSON格式的字符串, 转换为Java的对象。
```

### java中常用JSON解析方式

#### Gson

- 将对象转换为JSON字符串

  ```java
  转换JSON字符串的步骤:
  1. 引入JAR包
  2. 在需要转换JSON字符串的位置编写如下代码即可:
  	String json = new Gson().toJSON(要转换的对象);
  案例:
      Book b = BookDao.find();
      String json = new Gson().toJson(b);
      System.out.println(json);
  ```

- 将JSON字符串转换为对象

  ```java
  1. 引入JAR包
  2. 在需要转换Java对象的位置, 编写如下代码:
  	对象 = new Gson().fromJson(JSON字符串,对象类型.class);
  案例:
  	//JSON字符串{"id":1,"name":"金苹果","author":"小明","info":"嘿嘿","price":198.0}
      String json = "{\"id\":1,\"name\":\"金苹果\",\"author\":\"小明
  \",\"info\":\"嘿嘿\",\"price\":198.0}";
      Book book = new Gson().fromJson(json, Book.class);
      System.out.println(book);
  ```

#### FastJson

- 将对象转换为JSON字符串

  ```java
  转换JSON字符串的步骤:
  1. 引入JAR包
  2. 在需要转换JSON字符串的位置编写如下代码即可:
  	String json=JSON.toJSONString(要转换的对象);
  案例:
      Book b = BookDao.find();
      String json=JSON.toJSONString(b);
      System.out.println(json);
  ```

- 将JSON字符串转换为对象

  ```java
  1. 引入JAR包
  2. 在需要转换Java对象的位置, 编写如下代码:
  	类型 对象名=JSON.parseObject(JSON字符串, 类型.class);
  		或
  	List<类型> list=JSON.parseArray(JSON字符串,类型.class);
  案例:
  	//JSON字符串{"id":1,"name":"金苹果","author":"小明","info":"嘿嘿","price":198.0}
      String json = "{\"id\":1,\"name\":\"金苹果\",\"author\":\"小明
  \",\"info\":\"嘿嘿\",\"price\":198.0}";
      Book book = JSON.parseObject(json, Book.class);
      System.out.println(book);
  ```

