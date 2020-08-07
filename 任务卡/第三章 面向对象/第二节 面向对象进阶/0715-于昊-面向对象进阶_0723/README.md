# 面向对象进阶

## 1、封装

```java
我们观察如下代码：
	class Person{
		private String name ; // 表示姓名
		private int age ; // 表示年龄
		void tell(){
			System.out.println("姓名：" + name + "；年龄：" + age) ;
		}
	}
	public class Demo{
		public static void main(String args[]){
			Person per = new Person() ;
			per.name = "张三" ;
			per.age = -30 ;
			per.tell() ;
		}
	}
以上的操作代码并没有出现了语法错误，但是出现了逻辑错误 （年龄-30岁）
在开发中， 为了避免出现逻辑错误， 我们建议对所有属性进行封装，并为其提供setter及getter方法进行设置和取得
操作。

修改代码为：
class Person{
	private String name ; // 表示姓名
	private int age ; // 表示年龄
	void tell(){
		System.out.println("姓名：" + getName() + "；年龄：" + getAge()) ;
	}
	public void setName(String str){
		name = str ;
	}
	public void setAge(int a){
		if (a>0&&a<150) {
			age = a ;
		}
	}
	public String getName(){
		return name ;
	}
	public int getAge(){
		return age ;
	}
}
public class OODemo10{
	public static void main(String args[]){
		Person per = new Person() ;
    	per.setName("张三") ;
		per.setAge(-30) ;
		per.tell() ;
	}
}
```

## 2、this

在Java基础中，this关键字是一个最重要的概念。使用this关键字可以完成以下的操作：

- 调用类中的属性
- 调用类中的方法或构造方法
- 表示当前对象

```java
class Demo {
    String name;
    
    String getName() {
        return name;
    }
    
    void setName(String name) {
        this.name = name;
    }
}
```

## 3、static

### 概述：

​	static表示“静态”的意思，可以用来修饰成员变量和成员方法(后续还会学习 静态代码块 和 静态内部类)。
	static的主要作用在于创建独立于具体对象的域变量或者方法
		简单理解：
			被static关键字修饰的方法或者变量不需要依赖于对象来进行访问，只要类被加载了，就可以通过类		 名去进行访问。
			并且不会因为对象的多次创建 而在内存中建立多份数据

### 重点

1. 静态成员在类加载时加载并初始化
2. 无论一个类存在多少个对象，静态的属性，永远在内存中只有一份（可以理解为所有对象公用）
3. 在访问时：**静态不能访问非静态，非静态可以访问静态**

## 4、代码块

```
普通代码块
	在执行的流程中出现的代码块， 我们称其为普通代码块。
构造代码块
	在类中的成员代码块， 我们称其为构造代码块， 在每次对象创建时执行， 执行在构造方法之前。
静态代码块
	在类中使用static修饰的成员代码块， 我们称其为静态代码块， 在类加载时执行。 每次程序启动到关闭 ，只会执行一次的代码块。
同步代码块
	在后续多线程技术中学习。
面试题：
	构造方法 与 构造代码块 以及 静态代码块的执行顺序：
	静态代码块 --> 构造代码块 --> 构造方法
```

```java
class Demo1 {
    {
        // 构造代码块
    }
    
    static {
        // 静态代码块
    }
    public static void main(String[] args) {
        {
            // 普通代码块
        }
    }
    
}
```

## 5、包

### 简介

1. 把功能相似或相关的类或接口组织在同一个包中，方便类的查找和使用。
2. 包如同文件夹一样，不同的包中的类的名字是可以相同的，当同时调用两个不同包中相同类名的类时，应该加上包名加以区别。因此，包可以避免名字冲突。


3. 包也限定了访问权限，拥有包访问权限的类才能访问某个包中的类。

### 使用规则

- 包中Java文件的定义：

  在.Java文件的首部，必须编写类所属那个包，格式：

  package 包名;

- 包的定义：

  通常由多个单词组成，所有单词的字母小写，单词与单词之间使用.隔开，一般命名为"com.公司名.项目名.模块名..."。

  规范由来：

  ​	由于Java面向对象的特性，每名Java开发人员都可以编写属于自己的Java Package，为了保障每个Java
  Package命名的唯一性，在最新的Java编程规范中，要求开发人员在自己定义的包名前加上唯一的前缀。由于互联网上的域名称是不会重复的，所以多数开发人员采用自己公司在互联网上的域名称作为自己程序包的唯一前缀。例如：com.java.xxx

- import 关键字

  用于导包

  import 包名.类名;

  ```java
  import java.util.Scanner;
  或者
  java.util.Scanner scanner = new java.util.Scanner();
  ```

  ## 6、权限修饰符

  | 修饰符    | 类   | 包   | 子类 | 其他包 |
  | --------- | ---- | ---- | ---- | ------ |
  | public    | ✔    | ✔    | ✔    | ✔      |
  | protected | ✔    | ✔    | ✔    | ×      |
  | default   | ✔    | ✔    | ×    | ×      |
  | private   | ✔    | ×    | ×    | ×      |

  ## 7、main方法详解

  ```
  main()方法一直写到了今天：
  public static void main(String args[])
  	以上的各个参数的含义如下：
  		· public：表示公共的内容，可以被所有操作所调用
  		· static：表示方法是静态的，可以由类名称直接调用。java StaticDemo09
  		· void：表示没有任何的返回值操作
  		· main：系统规定好的方法名称。如果main写错了或没有，会报错：NoSuchMethodError: main
  		· String[] args：字符串数组，接收参数的

  public class StaticDemo10{
  	public static void main(String args[]){
  		for(int i=0;i<args.length;i++){
  		System.out.println(args[i]) ;
  		}
  	}
  };
  】所有的参数在执行类的时候以空格进行分割。
  java StaticDemo10 1 2 3 4 5 6 7
  	但是，如果现在我要输入的是以下几种参数“hello world”、“hello vince”、“hello mjw”。
      因为以空格分割，所以以上的三组参数会当做六组参数输入，那么此时如果要想完成有空格的内容输入，则参数需要使用“"”括起来。
  java StaticDemo10 "hello world" "hello vince" "hello mjw"
  ```

  ## 8、单例设计模式

  ```
  单例设计模式是我们学习的第一个设计模式，也是比较重要的一个设计模式，单例设计模式会伴随这你的开发生涯，不管你是初级程序员，还是以后晋级到高级程序员，你都会接触到单例设计模式，今天，我们就学习单例设计模式的两种

  实现方式。
  单例设计模式：保证程序在内存中只有一个对象存在（被程序所共享)

  单例设计模式的两种实现方式：
  一、懒汉式：随着类的加载在内存中对象为null，当调用 getInstance 方法时才创建对象（延迟加载）
  二、饿汉式：随着类的加载直接创建对象（推荐开发中使用）

  单例设计模式的实现步骤：
  1．保证一个类只有一个实例，实现方式：构造方法私有化
  2．必须要自己创建这个实例，实现方式：在本类中维护一个本类对象（私有，静态）
  3．必须向整个程序提供这个实例，实现方式：对外提供公共的访问方式（getInstance方法，静态）

  懒汉式实现如下：
  class Single{
  	private Single(){}
  	private static Single s1 = null;
  	public static Single getInstance(){
  		if(s1 == null){
  			s1 = new Single();
  		}
  		return s1;
  	}
  }
  饿汉式实现如下：
  class Single2{
  	private Single2(){}
  	
  	private static Single2 s = new Single2();
  	public static Single getInstance(){
  		return s;
  	}
  	void print(){
  		System.out.println("Hello World!");
  	}
  }
  ```

  ## 9、任务：面向对象进阶训练任务

  ### 任务概述：

  本节任务主要涉及了几个面向对象类定义的题，请一一完成。

  1. **编写一个类 Book，代表图书**
     具有属性： 名称（title）、页数（pageNum），其中页数不能少于 200页，否则输出错误信息，并赋予默认值 200。

     具有方法: 为各属性设置赋值和取值方法。 detail，用来在控制台输出每本图书的名称和页数

     编写测试类 BookTest 进行测试：为 Book 对象的属性赋予初始值，并调用 Book 对象的 detail 方法，看看输出是否正确

  2. **通过类描述开课吧的 Java 学员**
     具有属性： 姓名，年龄，性别，爱好，公司（都是：开课吧），学科（都
     是：Java 学科）。
     思考：请结合 static 修饰属性进行更好的类设计。

  3. **通过类描述衣服， 每个衣服对象创建时需要自动生成一个序号值**
     要求：每个衣服的序号是不同的， 且是依次递增 1 的。

  ### 代码：

  ```java
  package com.kaikeba.task1;

  /**
   * @ClassName Book
   * @Description 类Book，代表图书
   * @Author 0715-YuHao
   * @Date 2020/7/23 9:49
   */
  class Book {

      private String title;
      private int pageNum;

      Book() {}

      String getTitle() {
          return title;
      }

      void setTitle(String title) {
          this.title = title;
      }

      int getPageNum() {
          return pageNum;
      }

      void setPageNum(int pageNum) {
          if (pageNum < 200) {
              System.out.println("你设置的页数小于200，默认设置为200");
              this.pageNum = 200;
          }else {
              this.pageNum = pageNum;
          }
      }

      /**
       * @Author 0715-YuHao
       * @Description 输出本图书的名称和页数
       * @Date 2020/7/23 10:02
       * @Param []
       * @return void
       */
      void detail() {
          System.out.println("图书名称：" + this.title + "，页数：" + this.pageNum);
      }

  }
  ```

  ```java
  package com.kaikeba.task1;

  /**
   * @ClassName BookTest
   * @Description 测试Book类
   * @Author 0715-YuHao
   * @Date 2020/7/23 9:49
   */
  public class BookTest {

      public static void main(String[] args) {
          Book book = new Book();
          book.setTitle("程序员的思维修炼");
          book.setPageNum(213);
          book.detail();
      }
  }

  ```

  ```java
  package com.kaikeba.task2;

  /**
   * @ClassName Student
   * @Description 开课吧的 Java 学员
   * @Author 0715-YuHao
   * @Date 2020/7/23 10:06
   */
  class Student {
      private String name;
      private int age;
      private char gender;
      private String interest;
      static String  company;
      static String subject;

      Student() {}

      Student(String name, int age, String interest) {
          this.name = name;
          this.age = age;
          this.interest = interest;
      }

      String getName() {
          return name;
      }

      void setName(String name) {
          this.name = name;
      }

      int getAge() {
          return age;
      }

      void setAge(int age) {
          if (age < 0 || age > 150) {
              System.out.println("你设置的年龄有误，默认设为0");
              this.age = 0;
          }else {
              this.age = age;
          }
      }

      char getGender() {
          return gender;
      }

      void setGender(char gender) {
          if (gender != '男' && gender != '女') {
              System.out.println("你输入的性别有误，默认为：'无'");
              gender = '无';
          }else {
              this.gender = gender;
          }
      }

      String getInterest() {
          return interest;
      }

      void setInterest(String interest) {
          this.interest = interest;
      }

      /**
       * @Author 0715-YuHao
       * @Description 输出学员信息
       * @Date 2020/7/23 10:20
       * @Param []
       * @return void
       */
      void show() {
          System.out.println("姓名：" + this.name);
          System.out.println("年龄：" + this.age);
          System.out.println("性别：" + this.gender);
          System.out.println("爱好：" + this.interest);
          System.out.println("公司：" + company);
          System.out.println("学科：" + subject);
      }
  }

  ```

  ```java
  package com.kaikeba.task2;

  /**
   * @ClassName StudentTest
   * @Description 测试Student类
   * @Author 0715-YuHao
   * @Date 2020/7/23 10:34
   */
  public class StudentTest {

      public static void main(String[] args) {
          Student.company = "开课吧";
          Student.subject = "Java";

          Student student1 = new Student();
          student1.setName("张三");
          student1.setAge(18);
          student1.setGender('男');
          student1.setInterest("篮球");
          student1.show();
          System.out.println("-----------------------");
          Student student2 = new Student();
          student2.setName("刘亦菲");
          student2.setAge(26);
          student2.setGender('女');
          student2.setInterest("旅游");
          student2.show();
      }
  }

  ```

  ```java
  package com.kaikeba.task3;

  /**
   * @ClassName Clothes
   * @Description 衣服类
   * @Author 0715-YuHao
   * @Date 2020/7/23 10:28
   */
  class Clothes {
      private String brand;
      private String color;
      private String size;
      // 静态属性count，用于记录衣服对象创建的序号值
      static int count;

      Clothes() {
          System.out.println("衣服序号：" + ++count);
      }

      Clothes(String brand, String color, String size) {
          this.brand = brand;
          this.color = color;
          this.size = size;
          System.out.println("衣服序号：" + ++count);
      }

      String getBrand() {
          return brand;
      }

      void setBrand(String brand) {
          this.brand = brand;
      }

      String getColor() {
          return color;
      }

      void setColor(String color) {
          this.color = color;
      }

      String getSize() {
          return size;
      }

      void setSize(String size) {
          this.size = size;
      }
  }

  ```

  ```java
  package com.kaikeba.task3;

  /**
   * @ClassName ClothesTest
   * @Description 测试类Clothes
   * @Author 0715-YuHao
   * @Date 2020/7/23 10:38
   */
  public class ClothesTest {

      public static void main(String[] args) {
          // 创建Clothes对象
          Clothes clothes1 = new Clothes();
          Clothes clothes2 = new Clothes();
          new Clothes();
          Clothes clothes4 = new Clothes("海澜之家", "白色", "XXL");
      }
  }

  ```

  #### 效果：

  ![Task1](https://note.youdao.com/yws/api/personal/file/0300E8FF00D0476E967F81D2765F05A1?method=download&shareKey=7075e076ca65bbb2ff288b6cbd62fdda)

  ![Task2](https://note.youdao.com/yws/api/personal/file/1676DA9E8F6348A48E69B7A0652DBD38?method=download&shareKey=bf5c0f4bed5d7d0911b2087be8195e24)

  ![Task3](https://note.youdao.com/yws/api/personal/file/76FAADE7515B4EB7BB0981B619988562?method=download&shareKey=e99e8408d5b7ae5d38e256b8af5868a5)
