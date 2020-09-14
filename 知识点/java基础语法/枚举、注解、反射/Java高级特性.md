## 枚举、注解、反射

### 枚举类(Enum)

#### 1. 概述

```
枚举(enum)类是jdk1.5中引入的一种基本数据类型。

定义：是指将变量的值一一列出来,变量的值只限于列举出来的值的范围内。--百度百科
即用于定义一组有限个同类的常量，例如：
	Level {LOW,MEDIUM,HIGH};
	Color {RED,GREEN,BLUE};
	Season {SPRING,SUMMER,AUTUMN,WINTER};
	Week {SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY};
	Thread.State {NEW,RUNNABLE,BLOCKED,WAITING,TIMED_WAITING,TERMINATER};
	...
	
在枚举类型中定义的常量是该枚举类型的实例。

优点：
	jdk1.5之前我们定义常量都是:public static final...很难管理，jdk1.5引入枚举之后我们就可以将这些常量组织起来，统一管理，再加上Enum基类内置了一些方法很方便我们操作。
```

#### 2. 枚举类型定义格式

```
//枚举定义格式：
权限修饰符 enum 枚举名称 {
	实例1,实例2，实例3，实例4;
}

如果枚举类只有一个对象，则可以作为单例模式的实现方式。
```

```java
//jdk1.5之前,自定义枚举类
public class Level {
    //1.声明Level对象的所有属性:用private final修饰
    private final int levelValue;
    //2.私有化构造器
    private Level(int levelValue) {
        this.levelValue = levelValue;
    }
   	//3.提供Level枚举类的所有对象
    public static final Level LOW = new Level(1);
    public static final Level MEDIUM = new Level(5);
    public static final Level HIGH = new Level(10);
    //4.获取对象的属性
    public int getLevelValue() {
        return levelValue;
    }
}
//jdk1.5,使用enum关键字
public enum Level {
	LOW(1),MEDIUM(5),HIGH(10);
    private final int levelValue;
   	private Level(int levelValue) {
        this.levelValue = levelValue;
    }
    public int getLevelValue() {
        return levelValue;
    }
}
//对于常量的名称只要见名知意即可，由于值是由我们自己定义的，获取其值的意义不大。
public enum Level {
	LOW,MEDIUM,HIGH;
}
//如果枚举不添加任何方法，枚举值默认为从0开始的有序数值。以 Color 枚举类型举例，它的枚举常量依次为 RED：0，GREEN：1，BLUE：2
```

#### 3. 枚举的常用方法

```java
//所有用enum关键字实现的枚举类型都继承自一个公共基类Enum抽象类，它内置了一些方法可以帮助我们很方便的使用枚举。
public abstract class Enum<E extends Enum<E>>
        implements Comparable<E>, Serializable { ... }
```

- `values()`:

  返回枚举类型的对象数组。该方法可以很方便的遍历所有枚举值。

  ```java
  public class Test {
      public static void main(String[] args) {
          Level[] levels = Level.values();
          for (Level level:levels) {
              System.out.print(level + " ");
          }
          //输出:LOW MEDIUM HIGH
      }
  }
  ```

- `compareTo()`:

  比较此枚举与指定对象的顺序，返回int类型值。

  ```java
  public class Test {
      public static void main(String[] args) {
          System.out.println(Level.HIGH.compareTo(Level.LOW));
          System.out.println(Level.HIGH.compareTo(Level.MEDIUM));
          System.out.println(Level.MEDIUM.compareTo(Level.LOW));
          System.out.println(Level.LOW.compareTo(Level.HIGH));
          //输出： 2 1 1 -2
      }
  }
  ```

- `valueOf(Class<T> enumType, String name)`:

  获取具有指定名称的指定枚举类型的枚举常量。

  ```java
  public class Test {
      public static void main(String[] args) {
          Level level = Enum.valueOf(Level.class, "LOW");
          System.out.println(level.toString());
          //输出： LOW
          //如果name值不存在，则会报异常 java.lang.IllegalArgumentException
      }
  }
  ```

- 其他

  | 返回类型 | 方法名称             | 描述                                                        |
  | -------- | -------------------- | ----------------------------------------------------------- |
  | boolean  | equals(Object other) | 当指定枚举常量等于此枚举常量时，返回true                    |
  | String   | name()               | 返回此枚举常量的名称                                        |
  | int      | ordinal()            | 返回此枚举常量的序数（即它在枚举声明中的位置，初始位置为0） |

  **注：枚举可用于switch语句做判断**

#### 4. 枚举实现接口

```java
interface Info {
   void show();
}

public enum Level implements Info {
    LOW,MEDIUM,HIGH;
	
    @Override
    public void show() {
        System.out.println("这是一个等级枚举类");
    }
}

public enum Level implements Info {
    LOW{
        @Override
        public void show() {
            System.out.println("这是低等级");
        }
    },MEDIUM{
        @Override
        public void show() {
            System.out.println("这是中等级");
        }
    },HIGH{
        @Override
        public void show() {
            System.out.println("这是高等级");
        }
    };
}
```

#### 5. 注意事项

- 一旦定义好了枚举，最好不要修改里面的值，除非必要
- 枚举类默认继承Enum抽象类而不是Object类
- 枚举类不能被继承，因为其枚举常量默认被final修饰
- 只能有private修饰的构造方法
- 不能定义name属性，因为自带name属性
- 不需要提供set方法，不符合枚举设计的初衷

### 注解(Annotation)

#### 1. 概述 

```
注解(Annotation)也是jdk1.5引入的一种注释机制，又称java 标注。

Annotation其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，并执行相应的处理。通过使用Annotation，程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息。

结合注释理解：
	注释是给人看的，告诉我们这个方法或者这个类是什么，实现了怎么样的功能等等
	注解是给机器看的，告诉机器这个方法或者这个类是什么。由标注就很好理解（即标记），可以理解为我们给这个方法打上一个标签。
	
注解(Annotation)可以像修饰符一样被使用，可用于修饰包，类，构造器，方法，变量，参数。
```

#### 2. 内置注解

- @Override：重写

- @Deprecated: 废弃，已经过时了

- @FunctionalInterface:函数式接口

  - jdk1.8开始支持，标识一个匿名函数或函数式接口

- @SuppressWarnings:抑制编译时的警告信息

  - 三种使用方式

    ```
    1. @SuppressWarnings("unchecked") 抑制单类型的警告
    2. @SuppressWarnings("unchecked", "rawtypes") 抑制多类型的警告
    3. @SuppressWarnings("all") 抑制所有类型的警告
    ```

#### 4. 元注解

```
元注解是作用在其他注解上的注解
```

- @Retention:

  标记这个注解怎么保存，是只在代码中，还是编译到字节码文件，或者运行时(这时可以通过反射访问)

- @Documented

  标记这个注解是否包含在用户文档javadoc中。

- @Target

  标记这个注解可以作用的在哪些java成员，例如TYPE，METHOD...

- @Inherited

  标记这个注解可以自动继承

  ```
  注：
  	1.子类会继承父类使用的注解中被@Inherited修饰的注解
  	2. 接口继承关系中，子接口不会继承父接口中的任何注解，不管父接口中使用的注解有没有被@Inherited修饰
  	3. 类实现接口时不会继承任何接口中定义的注解
  ```

#### 5. 自定义注解

```java
注解格式：
public @interface 注解名称 {
}
```

##### 注解架构

![注解架构](/images/Annotation架构.jpg)

- `ElementType`(注解的用途类型)

  每一个注解可以有多个`ElementType`属性，例如一个注解它的`ElementType`属性是METHOD类型，则该注解只能用于修饰方法。

- `RetentionPolicy`（注解作用域策略）

  每一个注解都会有唯一的`RetentionPolicy`属性，来标记这个注解的保存方式。

  - 若`RetentionPolicy`属性为SOURCE，则意味着：注解仅存在于编译器处理期间，编译器处理完之后，该注解就没用了。例如：@Override
  - 若`RetentionPolicy`属性为CLASS,则意味着：编译器将注解存储于类对应的 .class 文件中，它是注解的默认行为。
  - 若`RetentionPolicy`属性为RUNTIME，则意味着：编译器将注解 存储于 class 文件中，并且可由`JVM`读入。

##### 注意事项

1. 定义的注解，自动继承了java.lang.annotation.Annotation接口
2. 注解中的每一个方法，实际是声明的注解配置参数
   - 方法的名称就是 配置参数的名称
   - 方法的返回值类型，就是配置参数的类型。只能是：基本类型/Class/String/enum
3. 可以通过default来声明参数的默认值
4.  如果只有一个参数成员，一般参数名为value
5. 注解元素必须要有值，我们定义注解元素时，经常使用空字符串、0作为默认值。

#####  举例

```java
@Documented // 可以出现在javadoc中
@Target(ElementType.TYPE) // 可用于修饰"类、接口、枚举"
@Retention(RetentionPolicy.RUNTIME) // 该注解存在.class文件中并且能被java虚拟机读取 
public @interface MyAnnotation {
	参数类型 参数名() default 默认值;
}

@MyAnnotation
public class Demo {
}
```

### 反射(Reflection)

#### 1. 概述

```
Java的反射（reflection）机制是指在程序的运行状态中，可以构造任意一个类的对象，可以了解任意一个对象所属的类，可以了解任意一个类的成员变量和方法，可以调用任意一个对象的属性和方法。这种动态获取程序信息以及动态调用对象的功能称为Java语言的反射机制。反射被视为动态语言的关键。 -- 百度百科
```

#### 2. 类加载器

```
Java类加载器（Java Classloader）是Java运行时环境（Java Runtime Environment）的一部分，负责动态加载Java类到Java虚拟机的内存空间中。
java默认有三种类加载器，BootstrapClassLoader、ExtensionClassLoader、App ClassLoader。
    BootstrapClassLoader（引导启动类加载器）：
    	嵌在JVM内核中的加载器，该加载器是用C++语言写的，主要负载加载JAVA_HOME/lib下的类库，引导启动类加载器无法被应用程序直接使用。
    ExtensionClassLoader（扩展类加载器）：
    	ExtensionClassLoader是用JAVA编写，且它的父类加载器是Bootstrap。是由sun.misc.Launcher$ExtClassLoader实现的，主要加载JAVA_HOME/lib/ext目录中的类库。它的父加载器是BootstrapClassLoader
    App ClassLoader（应用程序类加载器）：
    	App ClassLoader是应用程序类加载器，负责加载应用程序classpath目录下的所有jar和class文件。它的父加载器为Ext ClassLoader
```

![双亲委托机制](/images/双亲委托机制.jpg)

```
双亲委派模型：如果一个类加载器收到了一个类加载请求，它不会自己去尝试加载这个类，而是把这个请求转交给父类加载器去完成。每一个层次的类加载器都是如此。因此所有的类加载请求都应该传递到最顶层的启动类加载器中，只有到父类加载器反馈自己无法完成这个加载请求（在它的搜索范围没有找到这个类）时，子类加载器才会尝试自己去加载。委派的好处就是避免有些类被重复加载。
```

#### 3. 获得Class的3种方式

```
1. 如果在编写代码时, 指导类的名称, 且类已经存在, 可以通过
	包名.类名.class 得到一个类的 类对象
	
2. 如果拥有类的对象, 可以通过
	Class 对象.getClass() 得到一个类的 类对象
	
3. 如果在编写代码时, 知道类的名称 , 可以通过
	Class.forName(包名+类名): 得到一个类的 类对象
	
	上述的第三种方式, 你需要获取的Class可以不存在，只要在运行到这段代码前存在就行了，这样就实现了动态加载。
	(一个class文件,在内存中不会存在两个类对象 )
```

#### 4. 获取Method

##### 通过class对象 获取一个类的方法

```
1. getMethod(String methodName , class.. clss)
	根据参数列表的类型和方法名, 得到一个方法(public修饰的)
2. getMethods();
	得到一个类的所有方法 (public修饰的)
3. getDeclaredMethod(String methodName , class.. clss)
	根据参数列表的类型和方法名, 得到一个方法(除继承以外所有的:包含私有, 共有, 保护, 默认)
4. getDeclaredMethods();
	得到一个类的所有方法 (除继承以外所有的:包含私有, 共有, 保护, 默认)
```

##### 执行Method方法

```
invoke(Object o,Object... para) :
    调用方法。
    参数1. 要调用方法的对象
    参数2. 要传递的参数列表
getName()
	获取方法的方法名称
setAccessible(boolean flag)
	如果flag为true 则表示忽略访问权限检查 !(可以访问任何权限的方法)
```

#### 5. 获取Filed

##### 通过class对象 获取一个类的属性

```
1. getDeclaredField(String filedName)
	根据属性的名称, 获取一个属性对象 (所有属性)
2. getDeclaredFields()
	获取所有属性
3. getField(String filedName)
	根据属性的名称, 获取一个属性对象 (public属性)
4. getFields()
	获取所有属性 (public)
```

##### Field 属性的对象类型

```
常用方法：
	1. get(Object o );
		参数: 要获取属性的对象
		获取指定对象的此属性值
	2. set(Object o , Object value);
		参数1. 要设置属性值的 对象
		参数2. 要设置的值
		设置指定对象的属性的值
	3. getName()
		获取属性的名称
	4. setAccessible(boolean flag)
		如果flag为true 则表示忽略访问权限检查 !(可以访问任何权限的属性)
```

#### 6. 获取注解

##### 获取类/属性/方法对象的注解对象

```
1. getAnnotation(Class annotationClass)
	返回此元素上要查询的注释的类型，如果存在则返回指定类型的注释，否则返回null。
2. getAnnotations()
	返回此元素上所有存在的注解。 如果此元素上不存在注解，则返回值是长度为0的数组。
3. getDeclaredAnnotation(Class annotationClass)
	如果直接存在这样的注解，则返回指定类型的注解，否则返回null。此方法忽略继承的注解。（如果此元素上没有直接出现注释，则返回null）
4. getDeclaredAnnotations()
	返回直接出现在此元素上的注解。此方法忽略继承的注解。 如果此元素上没有直接存在注解，则返回值为长度为0的数组。
```



