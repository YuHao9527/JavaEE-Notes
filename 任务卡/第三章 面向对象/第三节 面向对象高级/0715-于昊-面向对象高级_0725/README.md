# 面向对象高级

## 1、继承

```
继承：
	继承是Java面向对象编程技术的一块基石，它允许创建分等级层次的类。
	继承就是子类继承父类的特征和行为，使得子类对象(实例)具有父类的实例域和方法，使得子类具有父类相同的行为。
	格式：
		class 父类 {
         }
         class 子类 extends 父类 {
         }
继承的原则：
	Java中只有单继承，多重继承，没有多继承。
```

```java
// 人类
class Person {
    private String name;
    private int age;

    public Person() {
        super();
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void say() {
        System.out.println("我是："+name+"，我今年"+age+"岁了");
    }
}

// 学生
class Student extends Person {
}
```

#### super关键字

- 通过super，可以访问父类的构造方法
  - 调用super构造方法的代码，必须写在子类构造方法的第一行，且不能再调用当前子类的其他构造方法，这是不合乎逻辑的。
- 通过super，可以访问父类的属性
- 通过super，可以访问父类的方法

## 2、重写

```
重写(Override)规则：
	1. 参数列表必须完全与被重写方法的相同；
	2. 返回类型必须完全与被重写的方法的返回类型相同
	3. 访问权限不能比父类被重写方法的访问权限更低，例如：如果父类的一个方法被声明为public，那么在子类中重写该方法就不能声明为protected。
	4. 父类的成员方法只能被它的子类重写
	5. 声明为static和private的方法不能被重写，但是能够被再次声明。
	
面试题：
	Java中重写(Override)和重载(Overload)的区别
		1、发生的位置
				重载：一个类中
				重写：子父类中
		2、参数列表限制
				重载：必须不同
				重写：必须相同
		3、返回值类型
				重载：与返回值类型无关
				重写：返回值类型必须一致
		4、访问权限
				重载：与访问权限无关
				重写：子类的方法权限必须不能小于父类的方法权限
		5、异常处理
				重载：与异常无关
				重写：异常范围可以更小，但是不能抛出新的异常
```

```
class Person {
    public void say() {
        System.out.println("锄禾日当午，汗滴禾下土");
    }
}

class Student extends Person {
    @Override
    public void say() {
        System.out.println("床前明月光，玻璃好上霜。要不及时擦，整不好得脏！");
    }
}
```

## 3、final关键字

```
final用于修饰属性、变量。

		变量变为了常量，无法对其再次进行赋值。

		final修饰的局部变量只能赋值一次（可以先声明后赋值）

		final修饰的是成员属性，必须在声明时赋值。

		全局常量（public static final）

		

		常量的命名规范：

			由1个或多个单词组成，单词与单词之间必须使用下划线隔开，单词中所有字母大写

			例如：SQL_INSERT

	final用于修饰类

		final修饰的类，不能被继承。

	final用于修饰方法

		final修饰的方法，不能被子类重写。

全局常量（public static final）
```

## 4、抽象类(abstract)

#### 概念

```
抽象类必须使用abstract class声明
一个抽象类中可以没有抽象方法。抽象方法必须写在抽象类或者接口中。

格式：
	abstract class 类名{ // 抽象类

	}
```

```java
public abstract class Person { // 抽象类
    public abstract void say(); // 抽象方法
}
```



#### 抽象方法

```
只声明而未实现的方法称为抽象方法（未实现指的是：没有"{}"方法体），抽象方法必须使用abstract关键字声明。

格式：
	abstract class 类名{
        public abstract void 方法名(); // 抽象方法，只声明而未实现
	}
```

#### 不能被实例化

``` 
在抽象类的使用中有几个原则：
	· 抽象类本身是不能直接进行实例化操作的，即：不能直接使用关键字new完成。
	· 一个抽象类必须被子类所继承，被继承的子类（如果不是抽象类）则必须覆写(重写)抽象类中的全部抽象方法。
```

#### 常见问题

```
1、 抽象类能否使用final声明？
	不能，因为final属修饰的类是不能有子类的 ， 而抽象类必须有子类才有意义，所以不能。
2、 抽象类能否有构造方法？
	能有构造方法，而且子类对象实例化的时候的流程与普通类的继承是一样的，都是要先调用父类中的构造方法（默
认是无参的），之后再调用子类自己的构造方法。
```

#### 抽象类和普通类的区别

```
1、抽象类必须用public或protected修饰(如果为private修饰，那么子类则无法继承，也就无法实现其抽象方法）。
默认缺省为 public
2、抽象类不可以使用new关键字创建对象， 但是在子类创建对象时， 抽象父类也会被JVM实例化。
3、如果一个子类继承抽象类，那么必须实现其所有的抽象方法。如果有未实现的抽象方法，那么子类也必须定义为
abstract类
```

## 5、接口(interface)

#### 概念

```
如果一个类中的全部方法都是抽象方法，全部属性都是全局常量，那么此时就可以将这个类定义成一个接口。
定义格式：
	interface 接口名称{
		全局常量 ;
		抽象方法 ;
	}
```

```java
// Person接口
public interface Person {
    int SQL_VALUE = 10; // 全局常量
    void say(); // 抽象方法
}
```

#### 面向接口编程思想

```
这种思想是接口是定义（规范，约束）与实现（名实分离的原则）的分离。
优点：
	1、 降低程序的耦合性
	2、 易于程序的扩展
	3、 有利于程序的维护
```

#### 全局常量和抽象方法的简写

```
因为接口本身都是由全局常量和抽象方法组成 ， 所以接口中的成员定义可以简写：
1、全局常量编写时， 可以省略public static final 关键字，例如：
	public static final String INFO = "内容" ;
	简写后：
	String INFO = "内容" ;
2、抽象方法编写时， 可以省略 public abstract 关键字， 例如：
	public abstract void print() ;
	简写后：
	void print() ;
```

#### 接口的实现 implements

```
接口可以多实现：
格式：
	class 子类 implements 父接口1,父接口2...{
	}
以上的代码称为接口的实现。那么如果一个类即要实现接口，又要继承抽象类的话，则按照以下的格式编写即可：
	class 子类 extends 父类 implements 父接口1,父接口2...{
	}
```

##### 接口的继承

```
接口因为都是抽象部分， 不存在具体的实现， 所以允许多继承,例如：
	interface C extends A,B{
	}
```

注意：

```
如果一个接口要想使用，必须依靠子类。子类(如果不是抽象类的话)要实现接口中的所有抽象方法。
```

#### 接口和抽象类的区别

```
1、抽象类要被子类继承，接口要被类实现。
2、接口只能声明抽象方法，抽象类中可以声明抽象方法，也可以写非抽象方法。
3、接口里定义的变量只能是公共的静态的常量，抽象类中的变量是普通变量。
4、抽象类使用继承来使用， 无法多继承。 接口使用实现来使用， 可以多实现
5、抽象类中可以包含static方法 ，但是接口中不允许（静态方法不能被子类重写，因此接口中不能声明静态方法）
6、接口不能有构造方法，但是抽象类可以有
```

## 6、多态

#### 概念

```
多态: 就是对象的多种表现形式，（多种体现形态）
```

#### 多态的体现

```
对象的多态性，从概念上非常好理解，在类中有子类和父类之分，子类就是父类的一种形态 ，对象多态性就从此而来。
ps: 方法的重载 和 重写 也是多态的一种， 不过是方法的多态（相同方法名的多种形态）。
	重载： 一个类中方法的多态性体现
	重写： 子父类中方法的多态性体现。
```

#### 多态的使用：对象的类型转换

```
类似于基本数据类型的转换：
· 向上转型：将子类实例变为父类实例
	|- 格式：父类 父类对象 = 子类实例 ；
· 向下转型：将父类实例变为子类实例
	|- 格式：子类 子类对象 = （子类）父类实例 ；
```

## 7、instanceof

```
作用：
	判断某个对象是否是指定类的实例，则可以使用instanceof关键字
格式：
	实例化对象 instanceof 类 //此操作返回boolean类型的数据
```

## 8、Object类

#### 概念

```
Object类是所有类的父类（基类），如果一个类没有明确的继承某一个具体的类，则将默认继承Object类。

例如我们定义一个类：
public class Person{
}

其实它被使用时 是这样的：
public class Person extends Object{
}
```

#### Object的多态

```
使用Object可以接收任意的引用数据类型
```

```java
class Demo{
    public static void main(String[] args) {
        String text = "123";
        say(text);
        int a = 10;
        say(a);
    }
    
    public static void say(Object o) {
        System.out.println(o);
    }
}

输出：
123
10
```

#### toString

```
建议重写Object中的toString方法。此方法的作用：返回对象的字符串表示形式。
	Object的toString方法，返回对象的内存地址
```

#### equals

```
建议重写Object中的equals(Object obj)方法，此方法的作用：指示某个其他对象是否“等于”此对象。
	Object的equals方法：实现了对象上最具区别的可能等价关系; 也就是说，对于任何非空引用值x和y ，当且仅当
x和y引用同一对象（ x == y具有值true ）时，此方法返回true 。

equals方法重写时的五个特性：

	自反性 ：对于任何非空的参考值x ， x.equals(x)应该返回true 。
	对称性 ：对于任何非空引用值x和y ， x.equals(y)应该返回true当且仅当y.equals(x)回报true 。
	传递性 ：对于任何非空引用值x ， y和z ，如果x.equals(y)回报true个y.equals(z)回报true ，然后
x.equals(z)应该返回true 。
	一致性 ：对于任何非空引用值x和y ，多次调用x.equals(y)始终返回true或始终返回false ，前提是未修改对象上的equals比较中使用的信息。
	非空性 ：对于任何非空的参考值x ， x.equals(null)应该返回false 。
```

## 9、内部类

#### 概念

```
在Java中，可以将一个类定义在另一个类里面或者一个方法里面，这样的类称为内部类。
广泛意义上的内部类一般来说包括这四种：
	1、成员内部类
	2、局部内部类
	3、匿名内部类
	4、静态内部类
```

#### 成员内部类

```java
成员内部类是最普通的内部类，它的定义为位于另一个类的内部，形如下面的形式：
class Outer {
	private double x = 0;
	public Outer(double x) {
	this.x = x;
}
	class Inner { //内部类
		public void say() {
			System.out.println("x="+x);
		}
	}
}
特点： 成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）。
	不过要注意的是，当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问
的是成员内部类的成员。如果要访问外部类的同名成员，需要以下面的形式进行访问：
	外部类.this.成员变量
	外部类.this.成员方法
```

```java
外部使用成员内部类
	Outter outter = new Outter();
	Outter.Inner inner = outter.new Inner();
```

#### 局部内部类

```java
局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或
者该作用域内。
例如：
	class Person{
		public Person() {
		}
	}
	class Man{
		public Man(){
		
		}
		public People getPerson(){
			class Student extends People{ //局部内部类
				int age =0;
			}
			return new Student();
		}
	}
```

```
注意：局部内部类就像是方法里面的一个局部变量一样，是不能由public、protected、private以及static修饰符的。
```

#### 匿名内部类

```
匿名内部类由于没有名字，所以它的创建方式有点儿奇怪。创建格式如下：
	new 父类构造器（参数列表）|实现接口（）
	{
	//匿名内部类的类体部分
	}
在这里我们看到使用匿名内部类我们必须要继承一个父类或者实现一个接口，当然也仅能只继承一个父类或者实现一
个接口。同时它也是没有class关键字，这是因为匿名内部类是直接使用new来生成一个对象的引用。当然这个引用是隐
式的。
```

##### 注意：

```
在使用匿名内部类的过程中，我们需要注意如下几点：
	1、使用匿名内部类时，我们必须是继承一个类或者实现一个接口，但是两者不可兼得，同时也只能继承一个类或
者实现一个接口。
	2、匿名内部类中是不能定义构造函数的。
	3、匿名内部类中不能存在任何的静态成员变量和静态方法。
	4、匿名内部类为局部内部类，所以局部内部类的所有限制同样对匿名内部类生效。
	5、匿名内部类不能是抽象的，它必须要实现继承的类或者实现的接口的所有抽象方法。
	6、只能访问final型的局部变量
```

#### 静态内部类

```
静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。
静态内部类是不需要依赖于外部类对象的，这点和类的静态成员属性有点类似，并且它不能使用外部类的非static成员
变量或者方法.
```

```java
格式：
public class Test {
	public static void main(String[] args) {
		Outter.Inner inner = new Outter.Inner();
	}
}

class Outter {
	public Outter() {
	}
	static class Inner {
		public Inner() {
		}
	}
}
```

## 10、包装类

#### 概述

```
在Java中有一个设计的原则“一切皆对象”，那么这样一来Java中的一些基本的数据类型，就完全不符合于这种设计思
想，因为Java中的八种基本数据类型并不是引用数据类型，所以Java中为了解决这样的问题，引入了八种基本数据类型
的包装类。
```

| 序号 | 基本数据类型 | 包装类    |
| ---- | ------------ | --------- |
| 1    | int          | Integer   |
| 2    | char         | Character |
| 3    | float        | Float     |
| 4    | double       | Double    |
| 5    | boolean      | Boolean   |
| 6    | byte         | Byte      |
| 7    | short        | Short     |
| 8    | long         | Long      |

```
以上的八种包装类，可以将基本数据类型按照类的形式进行操作。
	但是，以上的八种包装类也是分为两种大的类型的：
		· Number：Integer、Short、Long、Double、Float、Byte都是Number的子类表示是一个数字。
		· Object：Character、Boolean都是Object的直接子类。
```

#### 装箱和拆箱操作

```
以下以Integer和Float为例进行操作
将一个基本数据类型变为包装类，那么这样的操作称为装箱操作。
将一个包装类变为一个基本数据类型，这样的操作称为拆箱操作，
因为所有的数值型的包装类都是Number的子类，Number的类中定义了如下的操作方法，以下的全部方法都是进行拆箱的操作。
```

| 序号 | 方法                                       | 描述               |
| ---- | ------------------------------------------ | ------------------ |
| 1    | public ***byte*** byteValue()              | 用于Byte->byte     |
| 2    | public abstract ***double*** doubleValue() | 用于Double->double |
|      | public abstract ***float*** floatValue()   | 用于Float->float   |
| 4    | public abstract ***int*** intValue()       | 用于integer->int   |
| 5    | public abstract ***long*** longValue()     | 用于Long->long     |
| 6    | public ***short*** shortValue()            | 用于Short->short   |

```java
装箱操作：
在JDK1.4之前 ，如果要想装箱，直接使用各个包装类的构造方法即可，例如：
	int temp = 10 ; // 基本数据类型
	Integer x = new Integer(temp) ; // 将基本数据类型变为包装类
在JDK1.5，Java新增了自动装箱和自动拆箱，而且可以直接通过包装类进行四则运算和自增自建操作。例如：
	Float f = 10.3f ; // 自动装箱
	float x = f ; // 自动拆箱
	System.out.println(f * f) ; // 直接利用包装类完成
	System.out.println(x * x) ; // 直接利用包装类完成
```

#### 字符串转换

```java
使用包装类还有一个很优秀的地方在于：可以将一个字符串变为指定的基本数据类型，此点一般在接收输入数据上使用
较多。
在Integer类中提供了以下的操作方法：
	public static int parseInt(String s) ：将String变为int型数据
在Float类中提供了以下的操作方法：
	public static float parseFloat(String s) ：将String变为Float
在Boolean 类中提供了以下操作方法：
	public static boolean parseBoolean(String s) ：将String变为boolean
	....
	....
```

## 11、可变参数

```
一个方法中定义完了参数，则在调用的时候必须传入与其一一对应的参数，但是在JDK 1.5之后提供了新的功能，可以根
据需要自动传入任意个数的参数。
语法：
	返回值类型 方法名称(数据类型…参数名称){
		//参数在方法内部 ， 以数组的形式来接收
	}
注意：
	可变参数只能出现在参数列表的最后。
```

## 12、递归

```
递归，在数学与计算机科学中，是指在方法的定义中使用方法自身。也就是说，递归算法是一种直接或者间接调用自身方
法的算法。
递归流程图如下：
```

![递归](https://note.youdao.com/yws/api/personal/file/DE4283D13D284C47BAE49AEFDD5A2033?method=download&shareKey=593e40ca5f4fda5fe1b7265b2e4d12e2)

```java
/**
 * 递归实现5的阶乘（一个正整数的阶乘(factorial)是所有小于及等于该数的正整数的乘积）
 */
class Demo {
    public static void main(String[] args) {
        
    }
    public static int fact(int n) {
        if (n == 1) {
            return 1;
        }else {
            return n * fact(n - 1);
        }
    }
}
输出：
120
```

### 13、任务1：面向对象高级训练任务

#### 任务概述：

本节任务主要涉及了几个面向对象类定义的题，请一一完成。

1. 试题：假设用户账号为：admin，密码为 123，编写用户登陆案例。 要
求：请将登陆定义为 login 方法， 并将 login 方法写在 UserService 类中
2. 试题：设置一个类， 命名为 MyList
类中包含属性：Object[] element
方法有如下几个：
1. 增加方法 add ： 可以向数组属性中依次存储 Object，数组内容
存满时，需实现动态扩容（详解在下面）。
2. 删除方法 remove ：可以根据数据或下标，从数组属性中删除
Object 数据，删除后，数组后续元素需前移。
5. 查询方法 get ：方法传入下标，返回数组中指定下标的数据。
  当前存储数据量 size ： 获取当前存储的有效数据长度
  动态扩容详解：无需真正增加原数组的容量，只用将原内容复制到新
  的大数组，然后让原数组名称重新等于大数组即可。由于原数组数据在堆中，
  失去引用会被 GC 自动回收。


#### 代码

```java
package Task1;

/**
 * @ClassName UserService
 * @Description 用户登录服务器
 * @Author 0715-YuHao
 * @Date 2020/7/24 22:19
 */
public class UserService {
    private String username;
    private int password;

    public UserService() {
        // 设置默认用户名和密码
        this("admin", 123);
    }

    public UserService(String username, int password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "username='" + username + '\'' +
                ", password=" + password +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserService other = (UserService) obj;
        if (password != other.password)
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    /**
     * @Author 0715-YuHao
     * @Description 登录方法
     * @Date 2020/7/25 12:29
     * @Param [username, password] [用户名称 密码]
     * @return void
     */
    public void login(String username, int password) {
        if (this.username.equals(username) && this.password == password) {
            System.out.println("登录成功！");
        }else {
            System.out.println("登录失败，用户名称或密码错误！");
        }
    }
}
```

```java
package Task1;

import java.util.Arrays;

/**
 * @ClassName MyList
 * @Description MyList
 * @Author 0715-YuHao
 * @Date 2020/7/24 22:23
 */
public class MyList {
    private Object[] element;
    //当前存储数据量 size
    private int size;

    // 默认创建对像必须定义数组长度
    public MyList(int size) {
        this.size = size;
        element = new Object[size];
    }

    /**
     * @Author 0715-YuHao
     * @Description 增加方法 add ： 可以根据索引数组属性中依次存储 Object，数组内容
     * 存满时，动态扩容
     * @Date 2020/7/25 13:31
     * @Param [o, size]
     * @return void
     */
    public void add(Object o, int index) {
        // 如果下标大于数组长度，动态扩容
        if (index > size - 1) {
            add(o);
        }else {
            element[index] = o;
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 增加方法 add ： 可以向数组属性中依次存储 Object，数组内容
     * 存满时，动态扩容
     * @Date 2020/7/25 13:17
     * @Param [o] [需增加的对象】
     * @return void
     */
    public void add(Object o) {
        // 创建新的大数组
        Object[] newElement = new Object[size + 1];
        // 将原数组内容复制到新的大数组
        for (int i = 0;i < element.length;i++) {
            newElement[i] = element[i];
        }
        // 添加Object
        newElement[size] = o;
        // 替换掉原数组
        this.element = newElement;
        // 数组长度加一
        this.size++;
    }

    /**
     * @Author 0715-YuHao
     * @Description . 删除方法 remove ：可以根据数据，从数组属性中删除
     * Object 数据，删除后，数组后续元素需前移。
     * @Date 2020/7/25 13:18
     * @Param [o] [需删除的数据]
     * @return void
     */
    public void remove(Object o) {
        boolean flag = true;
        // 创建新的小数组
        Object[] newElement = new Object[size - 1];
        // 将原数组的内容复制到小数组
        for (int i = 0;i < element.length;i++) {
            // 扫描需要删除的数据
            if (element[i].equals(o)) {
                // 找到需要删除的数据
                flag = false;
                // 原数组后续元素前移
                for (int j = i; j < element.length - 1; j++) {
                    newElement[i] = element[i + 1];
                }
                break;
            }
            newElement[i] = element[i];
        }
        if (flag) {
            // 未找到需要删除的数据
            System.out.println("没有找到你要删除的Object数据");
        }else {
            // 替换原数组
            this.element = newElement;
            // 数组长度减一
            this.size--;
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 重载：删除方法 remove ：可以根据下标，从数组属性中删除
     *      * Object 数据，删除后，数组后续元素需前移。
     * @Date 2020/7/25 13:19
     * @Param [index] [需删除数据的下标]
     * @return void
     */
    public void remove(int index) {
        // 判断下标是否超出数组范围
        if (index > size - 1 && index < 0) {
            System.out.println("错误：超出数组范围");
        }else {
            Object[] newElement = new Object[size - 1];
            for (int i = 0; i < element.length; i++) {
                if (i == index) {
                    for (int j = i; j < element.length - 1; j++) {
                        newElement[i] = element[i + 1];
                    }
                    break;
                }
                newElement[i] = element[i];
            }
            this.element = newElement;
            this.size--;
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 查询方法 get ：方法传入下标，返回数组中指定下标的数据。
     * @Date 2020/7/25 13:20
     * @Param [index]
     * @return java.lang.Object
     */
    public Object get(int index) {
        return this.element[index];
    }

    /**
     * @Author 0715-YuHao
     * @Description 获取当前存储的有效数据长度
     * @Date 2020/7/25 13:20
     * @Param []
     * @return int
     */
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "element=" + Arrays.toString(element) +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MyList myList = (MyList) o;
        if (size != myList.size)
            return false;
        return Arrays.equals(element, myList.element);
    }

}
```

## 14、任务2：猜拳游戏训练任务

#### 任务概述

今天的任务是通过控制台方式实现一个人机对战的猜拳游戏，用户通过输入（1.剪刀 2.石头 3.布），机器随机生成（1.剪刀 2.石头 3.布），胜者积分，n 局以后通过积分的多少判定胜负。

#### 代码

```java
package Task2;

/**
 * @ClassName main
 * @Description 主程序
 * @Author 0715-YuHao
 * @Date 2020/7/25 12:34
 */
public class main {

    public static void main(String[] args) {
        // 游戏开始
        GameWidows.start();
    }
}
```

```java
package Task2;

/**
 * @Author 0715-YuHao
 * @Description 数据类，用于存储数据
 * @Date 2020/7/25 14:44
 */
public abstract class Data {
	// 全局常量 剪刀、石头、布
    public static final String  SCISSORS = "剪刀";
    public static final String STONE = "石头";
    public static final String  PAPER = "布";
    // 全局变量：记录积分
    public static int PLAYER_POINT = 0;
    public static int ROBOT_POINT = 0;
}
```

```java
package Task2;

import java.util.Scanner;

/**
 * @ClassName GameWidows
 * @Description 猜拳游戏主界面
 * @Author 0715-YuHao
 * @Date 2020/7/25 13:57
 */
public class GameWidows {

    public static void start() {
        System.out.println("**********游戏开始**********");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要游戏的局数：");
        int round = scanner.nextInt();
        for (int i = 0;i < round; i++) {
            System.out.println("1." + Data.SCISSORS);
            System.out.println("2." + Data.STONE);
            System.out.println("3." + Data.PAPER);
            System.out.println("请输入：");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    Robot.playGame(1);
                    break;
                case 2:
                    Robot.playGame(2);
                    break;
                case 3:
                    Robot.playGame(3);
                    break;
                default:
                    System.out.println("你输入的数据有误，请重新输入，谢谢！");
                    break;
            }
        }
        // 游戏结束，比较得分
        if (Data.PLAYER_POINT > Data.ROBOT_POINT) {
            System.out.println("恭喜你，游戏胜利！");
        }else {
            // 平局，也是机器人胜
            System.out.println("不好意思，游戏失败！");
        }
    }
}
```

```java
package Task2;

import java.util.Random;

/**
 * @ClassName Robot
 * @Description 机器人类
 * @Author 0715-YuHao
 * @Date 2020/7/25 14:13
 */
public class Robot extends Data{

    public static void playGame(int num) {
        Random random = new Random();
        // 机器人随机生成1、2、3
        int robot = random.nextInt(3) + 1;
        // 相等为平局不加分
        if (num == robot){
            System.out.println("机器人：" + robot);
            System.out.println("平局");
        }else if (num - robot == 1 || num - robot == -2) { // 玩家赢的情况，玩家积一分
            System.out.println("机器人：" + robot);
            System.out.println("玩家积一分。");
            // 加分
            PLAYER_POINT += 1;
        }else { // 机器人赢，机器人积一分
            System.out.println("机器人：" + robot);
            System.out.println("机器人积一分。");
            ROBOT_POINT += 1;
        }
    }
}
```