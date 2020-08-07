## 泛型

### 概述

泛型，即“参数化类型”。就是将类型由原来的具体的类型参数化，类似于方法中的变量参数，此时类型也定义成参数形式（可以称之为类型形参），然后在使用/调用时传入具体的类型（类型实参）。

### 使用

#### 泛型类

```java
定义一个泛型类：
public class ClassName<T>{
	private T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
    }
}
```

#### 泛型接口

```java
public interface IntercaceName<T>{
	T getData();
}

实现接口时，可以选择指定泛型类型，也可以选择不指定， 如下：

指定类型：
	public class Interface1 implements IntercaceName<String> {
		private String text;
		@Override
		public String getData() {
			return text;
		}
    }

不指定类型：
	public class Interface1<T> implements IntercaceName<T> {
		private T data;
		@Override
		public T getData() {
			return data;
		}
    }
```

#### 泛型方法

```java 
private static <T> T 方法名(T a, T b) {}
```

### 泛型限制类型

```
1. 在使用泛型时，可以指定泛型的限定区域，
	例如： 必须是某某类的子类或 某某接口的实现类，格式：
		<T extends 类或接口1 & 接口2>
```

### 泛型中的通配符 ?

```
类型通配符是使用？代替方法具体的类型实参。

1 <? extends Parent> 指定了泛型类型的上届
2 <? super Child> 指定了泛型类型的下届
3 <?> 指定了没有限制的泛型类型
```

### 作用

1. 提高代码复用率
2. 泛型中的类型在使用时指定，不需要强制类型转换（类型安全，编译器会检查类型)

### 注意

```
在编译之后程序会采取去泛型化的措施。
也就是说java中的泛型，只在编译阶段有效
在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。也就是说，泛型信息不会进入到运行时阶段。
```

## 常用类库

#### java.util.Calendar

##### 概述

```java
Calendar类是一个抽象类，可以为在某一特定时刻和一组之间的转换的方法calendar fields如YEAR，MONTH，DAY_OF_MONTH，HOUR，等等，以及用于操纵该日历字段，如获取的日期下个星期。瞬间可以用毫秒值表示，该值是1970年1月1日格林威治标准时间1970年1月1日00:00:00.000（Gregorian）的偏移量。 

该类还提供了用于在包外实现具体日历系统的附加字段和方法。 这些字段和方法定义为protected 。 

与其他对区域设置敏感的类一样，Calendar提供了一个类方法getInstance，用于获取此类型的通用对象。 Calendar的getInstance方法返回一个Calendar对象，其日历字段已使用当前日期和时间初始化： 
     Calendar rightNow = Calendar.getInstance();
     
Calendar对象可以生成实现特定语言和日历样式的日期时间格式所需的所有日历字段值（例如，日语 - 格里高利语，日语 - 繁体语）。Calendar定义某些日历字段返回的值范围及其含义。例如，日历系统的第一个月的所有日历的值为MONTH == JANUARY 。 其他值由具体子类定义，例如ERA 。有关详细信息，请参阅各个字段文档和子类文档。 

从以下版本开始：
1.1
```

##### 获取和设置日历字段值

```
可以通过调用set方法来设置日历字段值。Calendar设置的任何字段值在需要计算其时间值（距Epoch的毫秒数）或日历字段的值之前不会被解释。调用get，getTimeInMillis，getTime，add和roll涉及这样的计算。
```

##### 宽松

```
Calendar具有解释日历字段，宽松，非宽松的两种模式。当Calendar处于宽松模式时，它接受比它产生的更广泛的日历字段值。当Calendar重新计算返回Calendar日历字段值时，get()所有日历字段进行规范化。例如，宽松GregorianCalendar解释 MONTH == JANUARY，DAY_OF_MONTH == 32如2月1日。 

当Calendar处于非宽松模式时，如果其日历字段中存在任何不一致，则会抛出异常。例如，GregorianCalendar始终生成介于1和月长之间的DAY_OF_MONTH值。如果已设置任何超出范围的字段值，则非宽松GregorianCalendar在计算其时间或日历字段值时抛出异常。
```

##### First Week

```
Calendar使用两个参数定义特定于语言环境的七天工作周：一周的第一天和第一周的最小天数（从1到7）。当构造Calendar时，这些数字取自语言环境资源数据或语言环境本身。 如果指定的区域设置包含“fw”和/或“rg” Unicode extensions，则将根据这些扩展名获取一周的第一天。 如果同时指定了“fw”和“rg”，则“fw”扩展名中的值将取代“rg”扩展名中的隐含值。 它们也可以通过设置其值的方法明确指定。 

设置或获取WEEK_OF_MONTH或WEEK_OF_YEAR字段时， Calendar必须将月份或年份的第一周确定为参考点。 一个月或一年的第一周被定义为从getFirstDayOfWeek()开始并且包含该月或年的至少getMinimalDaysInFirstWeek()天的最早的七天期。 周数在第一周之前编号为......，-1,0; 周数为2,3，......跟随它。 请注意， get()返回的规范化编号可能不同。 例如，特定的Calendar子类可以将一年的第1周之前的一周指定为前一年的第n周。
```

##### 嵌套类

| 变量和类型   | 类                 | 描述                                                 |
| ------------ | ------------------ | ---------------------------------------------------- |
| static class | `Calendar.Builder` | Calendar.Builder用于从各种日期时间参数创建Calendar。 |

##### 常用字段

|   变量和类型   |             字段              |                             描述                             |
| :------------: | :---------------------------: | :----------------------------------------------------------: |
|   static int   |          [ERA](#era)          |  `get`和 `set`字段编号表示时代，例如Julian日历中的AD或BC。   |
|   static int   |         [YEAR](#year)         |     字段编号为 `get`和 `set`表示年份；这是特定于日历的值     |
|   static int   |        [MONTH](#month)        |                `get`和 `set`字段编号表示月份                 |
|   static int   | [WEEK_OF_YEAR](#WEEK_OF_YEAR) |              `get`和`set`字段编号表示当年的周数              |
|   static int   | [WEEK_OF_YEAR](#WEEK_OF_YEAR) |              `get`和`set`字段编号表示当年的周数              |
|   static int   |         [DATE](#DATE)         |             `get`和 `set`字段编号表示当月的日期              |
|   static int   | [DAY_OF_MONTH](#DAY_OF_MONTH) |             `get`和 `set`字段编号表示当月的日期              |
|   static int   |  [DAY_OF_YEAR](#DAY_OF_YEAR)  |           `get`和 `set`字段编号表示当年的日期编号            |
|   static int   |  [DAY_OF_WEEK](#DAY_OF_WEEK)  |              字段编号为 `get`和 `set`表示星期几              |
|   static int   |         [HOUR](#HOUR)         |          `get`和 `set`字段编号表示上午或下午的小时           |
|   static int   |  [HOUR_OF_DAY](#HOUR_OF_DAY)  |             `get`和 `set`字段编号表示当天的小时              |
|   static int   |       [MINUTE](#MINUTE)       |            `get`和 `set`字段编号表示小时内的分钟             |
|   static int   |       [SECOND](#SECOND)       |           `get`和 `set`字段编号表示分钟内的第二个            |
|   static int   |  [MILLISECOND](#MILLISECOND)  |            `get`和 `set`字段编号表示秒内的毫秒数             |
| protected long |         [time](#time)         | 此日历的当前设置时间，以1970年1月1日格林威治标准时间`0:00:00`之后的毫秒数表示 |

##### 构造方法

| 变量      | 构造器                                       | 描述                                          |
| --------- | -------------------------------------------- | --------------------------------------------- |
| protected | `Calendar()`                                 | 使用默认时区和默认的`FORMART`语言环境构造日历 |
| protected | `Calendat(TimeZone timezone, Locale locale)` | 构造具有指定时区和语言环境的日历              |

##### 常用方法

|   变量和类型    |                方法                |                             描述                             |
| :-------------: | :--------------------------------: | :----------------------------------------------------------: |
| `abstract void` | [add(int field, int amount)](#add) |    根据日历的规则，将指定的时间量添加或减去给定的日历字段    |
|       int       |       [get(int field)](#get)       |                     返回给定日历字段的值                     |
|      void       | [set(int field, int value)](#set)  |                 将给定的日历字段设置为给定值                 |
|      Date       |        [getTime](#getTime)         | 返回此表示 Calendar的时间值（距离 Epoch的毫秒偏移量）的 Date对象。 |

##### 字段详细信息

###### ERA

```java
public static final int ERA = 0;
	get和set字段编号表示时代，例如Julian日历中的AD或BC。 这是特定于日历的值;
```

###### YEAR

```java
public static final int YEAR = 1;
	get和set字段编号表示年份。这是特定于日历的值;
```

###### MONTH

```java
public static final int MONTH = 2;
	get和set字段编号表示月份。这是特定于日历的值。格里高利和朱利安日历中的第一个月是JANUARY，即0; 最后一个取决于一年中的月份数。
```

###### WEEK_OF_YEAR

```java
public static final int WEEK_OF_YEAR = 3;
	get和set字段编号表示当年的周数。 由 getFirstDayOfWeek() 和getMinimalDaysInFirstWeek() 定义的一年中的第一周具有值:
	1.子类定义在一年的第一周之前的天数 WEEK_OF_YEAR 的值。
```

###### WEEK_OF_MONTH

```java
public static final int WEEK_OF_MONTH = 4;
	get和set字段编号表示get的周数。 由getFirstDayOfWeek()和getMinimalDaysInFirstWeek()定义的月份的第一周具有值:
	1.子类定义在该月的第一周之前的天数的值WEEK_OF_MONTH 。
```

###### DATE

```java
public static final int DATE = 5
	get和set字段编号表示当月的日期。这是 DAY_OF_MONTH 的同义词。该月的第一天的值为1
```

###### DAY_OF_MONTH

```java
public static final int DAY_OF_MONTH = 5;
	get和set字段编号表示当月的日期。这是DATE的同义词。该月的第一天的值为1。
```

###### DAY_OF_YEAR

```java
public static final int DAY_OF_YEAR = 6;
	get和set字段编号表示当年的日期编号。一年的第一天价值1。
```

###### DAY_OF_WEEK

```java
public static final int DAY_OF_WEEK = 7;
	get和set字段编号表示星期几。 此字段值SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY和SATURDAY 
```

###### HOUR

```java
public static final int HOUR = 10;
	get和set字段编号表示上午或下午的小时。HOUR用于12小时制（0 - 11）。中午和午夜由0表示，而不是由12表示。例如，在10:04:15.250 PM，HOUR为10。
```

###### HOUR_OF_DAY

```java
public static final int HOUR_OF_DAY = 11;
	get和set字段编号表示当天的小时。HOUR_OF_DAY用于24小时制。例如，在下午10:04:15.250, HOUR_OF_DAY是22。
```

###### MINUTE

```java
public static final int MINUTE = 12;
	get和set字段编号表示小时内的分钟。 例如，在下午 10:04:15.250，MINUTE是4。
```

###### SECOND

```java
public static final int SECOND = 13;
	get和set字段编号表示分钟内的第二个。例如，在下午 10:04:15.250，SECOND是15。
```

###### MILLISECOND

```java
public static final int MILLISECOND = 14;
	get和set字段编号表示秒内的毫秒数。 例如，在下午 10:04:15.250，MILLISECOND是250。
```

###### time

```java
protected long time
	此日历的当前设置时间，以1970年1月1日格林威治标准时间 0:00:00之后的毫秒数表示。 
```



##### 常用方法

###### add

```java
public abstract void add(int field, int amount)
	根据日历的规则，将指定的时间量添加或减去给定的日历字段。 例如，要从日历的当前时间减去5天，您可以通过调用以下方法来实现： 
	add(Calendar.DAY_OF_MONTH, -5) 。 

参数 :
filed - 日历字段。 
amount - 要添加到字段中的日期或时间量。
```

###### get

```java
public int get(int field)
	返回给定日历字段的值。 在宽松模式下，所有日历字段都已标准化。 在非宽松模式下，所有日历字段都经过验证，如果任何日历字段具有超出范围的值，则此方法将引发异常。 
	规范化和验证由 complete() 方法处理，该方法依赖于日历系统。 

参数 :
filed - 给定的日历字段。 
结果: 
给定日历字段的值。 

异常 :
ArrayIndexOutOfBoundsException - 如果指定的字段超出范围(field < 0 || field >= FIELD_COUNT)。 

```

###### set

```java
public void set(int field, int value)
	将给定的日历字段设置为给定值。无论宽松模式如何，此方法都不会解释该值。 

参数 :
filed - 给定的日历字段。 
value - 要为给定日历字段设置的值。 

异常: 
ArrayIndexOutOfBoundsException - 如果指定的字段超出范围(field < 0 || field >= FIELD_COUNT)。在非宽松模式。
```

###### getTime

```java
public final Date getTime()
    返回此表示 Calendar的时间值（距离 Epoch的毫秒偏移量）的 Date对象。
    结果：
    	Date表示时间值。
    	Wed Jul 29 10:41:22 CST 2020
```

### 任务：找到休息日

#### 任务概述：

某公司软件开发工程师孙工,作息规律为上三天班,休息一天,经常不确定休息日是否周末,为此,请你开发一个程序,当孙工输入年及月,以日历方式显示对应月份的休息日,用中括号进行标记.同时,统计出本月有几天休息,轮到周末休息有几天.(注:首次休息日是 2020 年 2 月 2 日)

![Task1](/images/Task1.bmp)

#### 代码

```java
package com.findOffDay.main;

import com.findOffDay.dao.CalendarDao;
import com.findOffDay.view.Views;

/**
 * @ClassName Main
 * @Description 主程序
 * @Author 0715-YuHao
 * @Date 2020/7/29 11:14
 */
public class Main {
    //初始化视图对象
    private static Views view = new Views();
    //初始化dao对象
    private static CalendarDao cd = new CalendarDao();

    public static void main(String[] args) {
        while (true) {
            //初始化视图对象
            Views view = new Views();
            //初始化dao对象
            CalendarDao cd = new CalendarDao();
            //输入年
            int year = view.insertYear();
            //输入月
            int month = view.insertMonth();
            //打印日历
            view.showCalendar(cd.showCalendar(year, month - 1));
            //打印总休息日数
            view.showOffDay(cd.getOffDayNum());
            //打印周末休息日数
            view.showWeekDay(cd.getWeekDayNum());
        }
    }
}

```

```java
package com.findOffDay.view;

import com.findOffDay.bean.MyCalendar;

import java.util.Scanner;

/**
 * @ClassName Views
 * @Description 视图
 * @Author 0715-YuHao
 * @Date 2020/7/29 10:58
 */
public class Views {
    private Scanner scanner = new Scanner(System.in);

    // 提示输入年
    public int insertYear() {
        System.out.println("请输入年：");
        String text = scanner.nextLine();
        return insertNum(text, 2020, 2100);
    }

    // 提示输入月
    public int insertMonth() {
        System.out.println("请输入月：");
        String text = scanner.nextLine();
        return insertNum(text, 1, 12);
    }

    /**
     * @Author 0715-YuHao
     * @Description 判断用户输入是否合法
     * @Date 2020/7/29 11:08
     * @Param [text, i, j]
     * @return int
     */
    private int insertNum(String text, int i, int j) {
        int num = -1;
        try {
            num = Integer.parseInt(text);
        } catch (NumberFormatException e) {

        }
        if (num < i || num > j) {
            System.out.println("输入有误，请重新输入");
            if (j == 12) {
                return insertMonth();
            }else {
                return insertYear();
            }
        }
        return num;
    }

    public void showCalendar(MyCalendar[][] calendars) {
        System.out.print("星期日\t");
        System.out.print("星期一\t");
        System.out.print("星期二\t");
        System.out.print("星期三\t");
        System.out.print("星期四\t");
        System.out.print("星期五\t");
        System.out.print("星期六\t\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(calendars[i][j].getDay());
            }
            System.out.println();
        }
    }

    // 显示本月休息天数
    public void showOffDay(int num) {
        System.out.println("本月休息天数有：" + num + "天");
    }

    // 显示本月周末休息天数
    public void showWeekDay(int num) {
        System.out.println("本月轮到周末休息天数：" + num + "天");
    }
}

```

```java
package com.findOffDay.bean;

/**
 * @ClassName MyCalendar
 * @Description 日历类
 * @Author 0715-YuHao
 * @Date 2020/7/29 11:13
 */
public class MyCalendar {
    // 天，String类型是为了方便加中括号
    private String day;
    // 星期
    private int week;

    public MyCalendar() {
    }

    public MyCalendar(String day, int week) {
        this.day = day;
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "MyCalendar{" +
                "day=" + day +
                ", week=" + week +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyCalendar that = (MyCalendar) o;

        return day != null ? day.equals(that.day) : that.day == null;
    }

    @Override
    public int hashCode() {
        return day != null ? day.hashCode() : 0;
    }
}

```

```java
package com.findOffDay.dao;

import com.findOffDay.bean.MyCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @ClassName CalendarDao
 * @Description 日历数据
 * @Author 0715-YuHao
 * @Date 2020/7/29 11:18
 */
public class CalendarDao {
    // 休息日数
    private int offDayNum;
    // 周末休息日数
    private int weekDayNum;
    // 实例化日历对象
    private Calendar calendar = Calendar.getInstance();
    // 新建日期格式化类
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // 首次休息日2020-2-2
    private long firstOffDay;
    {
        try {
            // 日期格式化得到时间戳
            firstOffDay = sdf.parse("2020-02-02").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    // 工作天数标记
    private int count = 0;

    /**
     * @Author 0715-YuHao
     * @Description 创建日历数组
     * @Date 2020/7/29 19:34
     * @Param [year, month] [年份, 月份]
     * @return 日历数组
     */
    public MyCalendar[][] showCalendar(int year, int month) {
        calendar.set(year, month, 1);
        MyCalendar[][] mc = new MyCalendar[5][7];
        int day = 1;
        //获取该月最大天数
        int maxDay = calendar.getActualMaximum(Calendar.DATE);
        //首次休息日标记
        boolean flag = true;
        //遍历数组，输入
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                //实例化MyCalendar对象
                MyCalendar myCalendar = new MyCalendar();
                //设置日历
                calendar.set(Calendar.DATE, day);
                // 打印第一行空白处
                if (i == 0 && j != calendar.get(Calendar.DAY_OF_WEEK) - 1) {
                    myCalendar.setDay("      \t");
                    mc[i][j] = myCalendar;
                }else {
                    // 查找该月首次休息的天数
                    if (flag && caculaterOffsetDay(firstOffDay, year, month + 1, day)) {
                        flag = false;
                        myCalendar.setDay("[" + day + "]  \t");
                        myCalendar.setWeek(calendar.get(Calendar.DAY_OF_WEEK) - 1);
                        mc[i][myCalendar.getWeek()] = myCalendar;
                        day++;
                        count = 1;
                        offDayNum++;
                        if (myCalendar.getWeek() == 6 || myCalendar.getWeek() == 0) {
                            weekDayNum++;
                        }
                    }else {
                        //判断该月天数是否输入完成，完成则输入空白
                        if (day > maxDay) {
                            myCalendar.setDay("     \t");
                            mc[i][j] = myCalendar;
                            continue;
                        }
                        // 判断相隔天数是否相隔3天
                        if (count == 4) {
                            myCalendar.setDay("[" + day + "]  \t");
                            myCalendar.setWeek(calendar.get(Calendar.DAY_OF_WEEK) - 1);
                            mc[i][myCalendar.getWeek()] = myCalendar;
                            day++;
                            count = 1;
                            // 休息日数加1
                            offDayNum++;
                            //判断是否在周末，在周末则加1
                            if (myCalendar.getWeek() == 6 || myCalendar.getWeek() == 0) {
                                weekDayNum++;
                            }
                        } else {
                            myCalendar.setDay(day + "    \t");
                            myCalendar.setWeek(calendar.get(Calendar.DAY_OF_WEEK) - 1);
                            mc[i][myCalendar.getWeek()] = myCalendar;
                            day++;
                            count++;
                        }
                    }
                }
            }
        }
        return mc;
    }

    /**
     * @Author 0715-YuHao
     * @Description 判断是否是休息日
     * @Date 2020/7/29 19:27
     * @Param [firstOffDay, year, month, day]
     * @return boolean
     */
    private boolean caculaterOffsetDay(long firstOffDay, int year, int month, int day) {
        // 计算天数差
        int baseMonth = month + 1;
        long endDay = 0;
        try {
            // 获取对应日期的时间戳
            endDay =  sdf.parse(year + "-" + month + "-" + day).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 计算相差天数，时间戳除以一天的毫秒数为天数
        long offsetDay = (endDay - firstOffDay)/(60*60*24*1000);
        // 能被四整除则代表为休息日，返回true
        if (offsetDay % 4 == 0) {
            return true;
        }
        return false;
    }

    //获取总休息日
    public int getOffDayNum() {
        return offDayNum;
    }

    // 获取轮到周末休息日数
    public int getWeekDayNum() {
        return weekDayNum;
    }
}
```

#### 效果

![Task2](/images/Task2.bmp)