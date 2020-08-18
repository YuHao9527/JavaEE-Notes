# 流程控制

## 一、执行结构

​	1996 年，计算机科学家 Bohm 和 Jacopini 证明了：任何简单或复杂的算法都可以由**顺序结构**、**分支结构**和**循环结构**这三种基本结构组合而成。
	它们的共同点是都包含一个入口和一个出口，它们的每个代码都有机会被执行，不会出现死循环。

#### 顺序结构

​	顺序结构是一种基本的控制结构，它按照语句出现的顺序执行操作。

#### 分支结构

​	分支结构又被称为选择结构，根据条件成立与否来执行操作。

#### 循环结构

​	循环结构是一种重复结构，如果条件成立，它会重复执行某一循环体，直到出现不满足的条件为止。

## 二、 分支结构（选择结构）

### if 条件语句

**if 条件结构是根据条件判断之后再做处理**
if(条件语句){…}
if (条件语句){…}else{…}
if (条件语句){…}else if(条件语句){…}
if (条件语句){…}else if(条件语句){…}else{…}
例子：用户输入学生成绩，判断成绩是否及格，判断条件为 优良： > 90、良好：81-90、中：60-80、不及格：<60

```java
import java.util.Scanner;

public class Demo{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入成绩：");
		int score s= input.nextInt();
		// 91 优 81-90 良 60-80 中 60 差
		if(score >= 91){
			System.out.println("您的成绩是优秀！继续加油哦！");
		}else if(score >= 81 & score < 91){
			System.out.println("您的成绩是良好！还要努力哦！");
		}else if(score >= 60 & score <= 80){
			System.out.println("您的成绩是中等！还要加倍努力哦！");
		}else {
    		System.out.println("您的成绩是差！准备补考费吧！");
		}
	}
}
```

### switch语句

​	switch(表达式){
		case 取值 1: 语句块 1;break;
		case 取值 n: 语句块 n;break;
		default: 语句块 n+1;break;
	}

#### 相关规则

表达式的返回值必须是下述几种类型之一：int, byte, char, short,String；
case 子句中的取值必须是常量，且所有 case 子句中的取值应是不同的；
default 子句是可选的；
break 语句用来在执行完一个 case 分支后使程序跳出 switch 语句块；如果 case 后面没有写 break 则直接往下面执行！
case 后面的执行体可写{ }也可以不写{ }。

示例： 多分支月份输出天数（充分利用语句特性）

```java
import java.util.Scanner;

public class Demo6{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入月份：");
		int month = input.nextInt();
		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println(month + "月共有 31 天");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println(month + "月共有 30 天");
				break;
			case 2:
				System.out.println(month + "月共有 28 天");
        		break;
    		default:
        		System.out.println("友情提示，您输入有误！");
				break;
		}
    }
}
```

## 三、循环结构

- 循环语句功能

  在循环条件满足的情况下，反复执行特定代码

- 循环语句分类

  for 循环
  while 循环
  do/while 循环

### while循环

​	符合条件，循环继续执行；否则，循环退出
	特点：先判断，再执行

#### 语法：

```
while(条件表达式) {
	// 执行代码块;	
}
```

##### 示例：

​	录入班级人数和学员成绩，计算班级学员的平均成绩

```java
int sum = 0;
int score = 0;
int avg = 0;
int studentNum = 20;
while(i <= studentNum){
	System.out.print("请输入第" + i + "位同学的成绩：");
	score = input.nextInt();
	sum = sum + score;
	i++;
}
avg = sum / stuNum ;
```

### do-while 循环

​	先执行一遍循环操作，符合条件，循环继续执行；否则，循环退出
	特点：先执行，再判断

##### 语法：

```
do {
	// 执行代码块
}while(条件表达式);
```

#### while 循环和 do-while 循环的区别？

​	while: 先判断条件，如果条件满足，再执行循环操作。
	do while: 先执行一遍循环操作，然后再判读条件，如果条件满足，继续执行循环操作。

### for 循环

##### 语法：

```
for(初始化参数;判断条件;更新循环变量) {

	循环体;

}
```

##### 示例:

```java	
public class ForLoop {
	public static void main(String [] args){
		int result = 0;
		for(int i=1; i<=100; i++) {
			result += i;
		}
		System.out.println("result=" + result);
	}
}
```

输出： result=5050

## 四、任务

### JAVA 技术方向支线任务-出租车计费训练任务

#### 任务概述

​	本次任务一起来解决出租车计费问题。某市出租车计费标准如下图所示，
请根据此标准完成一个出租车计费模拟功能，能够计算总费用和列出产生费用
项目详细情况说明，帮助出租车师傅和乘客了解计费标准。

| 收费项目      | 收费标准 |
| :-----------: | :------: |
| 3公里以内收费 | 13元     |
| 基本单价 | 2.3元/公里 |
| 低速行驶和等候费 | 根据乘客要求停车等侯或者由于道路条件制，时速低于12 公里时，每5分钟早晚高峰期间加收2公里基本单价(不含空驶费)，其他时间段加收1公里基本单价(不含空驶费)。 |
| 预约叫车服务费 | 提前4小时及以上预约每次6元，4小时以内预约每次5元。 |
| 空驶费 | 单程载客行驶超过15公里部分，基本单价加收50%的费用；往返载客(即起点和终点在2公里(含)范围以内)不加收空驶费。 |
| 夜间收费 | 23:00(含)至次日5:00(不含)运营时，基本单价加收20%的费用 |
| 燃油附加费 | 每运次加收1元燃油附加费。 |
| 备注： |1.早高峰为7:00(含)-9:00(不含)；晚高峰17:00(含)-19:00(不含)；2.出租车结算以元为单位，元以下四舍五入。3.过路、过桥费由乘客负担。|

​	结合上述表格，可以得出：总车费=里程费用+低速行驶费（或者等候费）+预约叫车服务费+空驶费+夜间收费+燃油附加费。需要收集的数据有：里程数、低速行驶时长（早晚高峰期行驶时长和其他时间段行驶时长）、是否预约叫车（按四小时为标准）、开始乘坐出租车时间、出租车到达终点站时间，结合这些数据和表中提供的标准就可以使用程序进行计算总车费了。

###### 代码如下：

```java
import java.util.Scanner;

public class TaxiBilling {

    /**
     * @Author 0715-YuHao
     * @Description //出租车计费训练任务
     * @Date 2020/7/16 23:07
     * @Param [args]
     * @return void
     */
    public static void main(String[] args) {
        // 定义单价、车费（由于燃油附加费初始为1）、里程数、上车时间、下车时间、低速行驶时间
        float price = 2.3f, carCost = 1, miles, startTime, endTime ,lowSpeedTime = 0, otherLowSpeedTime = 0;
        // 定义是否预约、预约时间是否超4小时、是否低速行驶、是否往返
        boolean appointment, appointmentTime = false, lowSpeed, comeGo;
        System.out.println("*****欢迎使用出租车计费系统*****");
        Scanner scanner = new Scanner(System.in);
        // 1 . 请用户输入数据
        System.out.println("请输入总里程数：");
        miles = scanner.nextFloat();
        if (miles > 15) {
            // 由题意不清楚往返对车费有什么影响？
            System.out.println("是否往返?(true/false)");
            comeGo = scanner.nextBoolean();
        }
        // 开始上车时间是为了判断是否在高峰时间与夜间(统一输入小时)
        System.out.println("请输入开始乘车时间(24h)：");
        startTime = scanner.nextFloat();
        // 下车时间是为了记录是否超过特殊时间，但由题意无法获知特殊时间段的里程与非特时的里程，暂定为只要上车时在特殊时段就改变单价
        System.out.println("请输入开始下车时间(24h)：");
        endTime = scanner.nextFloat();
        System.out.println("是否预约叫车?(true/false)");
        appointment = scanner.nextBoolean();
        if (appointment) {
            System.out.println("是否超过4小时?(true/false)");
            appointmentTime = scanner.nextBoolean();
        }
        System.out.println("是否有低速行驶?(true/false)");
        lowSpeed = scanner.nextBoolean();
        if (lowSpeed) {
            // 获取早晚高峰低速行驶时间(分钟)
            System.out.println("请输入早晚高峰低速行驶时间(分钟)：");
            lowSpeedTime = scanner.nextFloat();
            // 获取其他时间低速行驶时间(分钟)
            System.out.println("请输入其他时间段低速行驶时间(分钟)：");
            otherLowSpeedTime = scanner.nextFloat();
        }
        // 判断上车时间是否在早高峰时间7:00(含)-9:00(不含)
        if (startTime >= 7 & startTime < 9) {
            // 修改单价
            price = price * 1.2f;
            if (lowSpeed) {
                // 低速行驶每5分钟加价，未到5分钟不算
                carCost += 2 * price * (lowSpeedTime / 5);
                carCost += price * (otherLowSpeedTime / 5);
            }
        }else if (startTime > 17 & startTime < 19) { // 判断上车时间是否在晚高峰时间17:00(含)-19:00(不含)
            price = price * 1.2f;
            if (lowSpeed) {
                carCost += 2 * price * (lowSpeedTime / 5);
                carCost += price * (otherLowSpeedTime / 5);
            }
        }else if (startTime > 23) { // 判断上车时间是否在夜间时间7:00(含)-9:00(不含)
            price = price * 1.2f;
            if (lowSpeed) {
                carCost += price * (otherLowSpeedTime / 5);
            }
        }else { // 其他时间段上车
            if (lowSpeed) {
                carCost += price * (otherLowSpeedTime / 5);
            }
        }
        // 判断里程数是否大于15公里，大于15公里部分基本单价上调50%
        if (miles > 15) {
            carCost += 15 * price + (miles - 15) * 2.3f * 1.5f;
        }else {
            carCost += miles * price;
        }
        // 是否预约
        if (appointment) {
            if (appointmentTime) {
                // 大于4小时每次6元
                carCost += 6;
            }
            // 小于4小时每次5元
            carCost += 5;
        }
        // 车费四舍五入，使用Math库的round()函数
        carCost = Math.round(carCost);
        System.out.println("你的乘车价格为： " + carCost + "元");
    }

}
```

###### 效果：

![效果](https://note.youdao.com/yws/api/personal/file/70576832D0B24B98818FB693EAA387FA?method=download&shareKey=faf842bfb450690e208c871b4fee8b81)



### JAVA 技术方向支线任务-人工智障训练任务

##### 任务概述：

人工智能的概念刚兴起时，网上流传了一段价值一个亿的代码，如下：

```java
public class AI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String question;
        while(true) {
            question = scanner.next();
            question = question.replace("吗", "");
            question = question.replace("我", "我也");
            question = question.replace("?", "!");
            System.out.println(question);
        }
    }
}
```

​	本节任务是学习循环，来让自己能默写出上述代码。并给上述每一行代码
添加合理注释。

###### 代码如下：

```java
import java.util.Scanner;

public class RobotTrain {
    /**
     * @Author 0715-YuHao
     * @Description // 人工智障训练
     * @Date 2020/7/16 23:09
     * @Param [args]
     * @return void
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String question;
        // 循环输入
        while (true) {
            // 用户输入问题
            question = input.next();
            // 将用户问题中的“吗”去除
            question = question.replace("吗","");
            // 将用户问题中的“我”替换成“我也”
            question = question.replace("我","我也");
            // 将用户问题中的“？”替换成“！”
            question = question.replace("?","!");
            System.out.println(question);}
    }

}
```

###### 效果：

![效果](https://note.youdao.com/yws/api/personal/file/870E172A248F4B2894E73ACE673DBD65?method=download&shareKey=26de22dd00a2ef1424e4d2eb394a5c33)

### JAVA 技术方向支线任务-流程控制的逻辑训练任务

##### 任务概述：

​	学习完毕分支与循环，很有必要锻炼一下大家的逻辑能力。所以本节任务
主要涉及了几个逻辑题，请一一完成。

1. 计算应缴金额

   商场根据会员积分打折：

   2000 分以内打 9 折，
   4000 分以内打 8 折，
   8000 分以内打 7.5 折，
   8000 分以上打 7 折，使用 if-else-if 结构，实现手动输入购物金额和积分，
   计算出应缴金额

2. 计算该年该月天数

   ​	一年中有 12 个月，而每个月的天数是不一样的。其中大月 31 天，分别为
   1,3,5,7,8,10,12 月，小月 30 天，分别 为 4,6,9,11 月。还有二月比较特殊，平
   年的二月只有 28 天，而闰年的二月有 29 天，由用户在控制台输入年份和月份，
   程序计算该年该月的天数。

3. 图形打印任务
   在控制台中，编写三个 Demo，分别输出如下图形：

   ```
   图形1：
        *
        **
        ***
        ****
        *****
   图形2：
        *****
        ****
        ***
        **
        *

    图形3：
            *
           ***
          *****
         *******
        *********
   ```

   ​

4. 打印九九乘法表 ，效果如图：

   ```
   乘法口诀表：
   1*1 
   1*2 2*2 
   1*3 2*3 3*3 
   1*4 2*4 3*4 4*4 
   1*5 2*5 3*5 4*5 5*5 
   1*6 2*6 3*6 4*6 5*6 6*6 
   1*7 2*7 3*7 4*7 5*7 6*7 7*7 
   1*8 2*8 3*8 4*8 5*8 6*8 7*8 8*8 
   1*9 2*9 3*9 4*9 5*9 6*9 7*9 8*9 9*9 
   ```

5. 打印三位数中的所有水仙花数

   所谓“水仙花数”即一个整数满足其值等于各个数位的立方和。
   如: 153 是一个水仙花数，因为 153= 1³+5³+3³


###### 代码：

```java
import java.util.Scanner;

public class ProcessControl {

    /**
     * @Author 0715-YuHao
     * @Description //流程控制的逻辑训练任务(分支+循环综合)
     * @Date 2020/7/16 22:12
     * @Param [args]
     * @return void
     */
    public static void main(String[] args) {
        // 1. 计算应缴金额
        // calculateAmount();

        // 2. 计算该年该月天数
        // calculateDays();

        // 3. 图形打印任务
        // shapeStamping();

        // 4. 打印九九乘法表
        // multiplicationTable();

        // 5. 打印三位数中的所有水仙花数
        // narcissisticNumber();

    }

    /**
     * 任务：计算出应缴金额
     * 商场根据会员积分打折：
     * 2000 分以内打 9 折，
     * 4000 分以内打 8 折，
     * 8000 分以内打 7.5 折，
     * 8000 分以上打 7 折，使用 if-else-if 结构，实现手动输入购物金额和积分，
     * 计算出应缴金额
     */
    public static void calculateAmount() {
        System.out.println("请输入会员积分：");
        Scanner input = new Scanner(System.in);
        int points = input.nextInt();
        System.out.println("请输入购物金额：");
        float amount = input.nextFloat();
        if (points < 0) {
            System.out.println("你输入的积分有误");
        }else if (points <= 2000) {
            System.out.println("你应付金额为：" + amount * 0.9 + "元");
        }else if (points < 4000) {
            System.out.println("你应付金额为：" + amount * 0.8 + "元");
        }else if (points < 8000) {
            System.out.println("你应付金额为：" + amount * 0.75 + "元");
        }else {
            System.out.println("你应付金额为：" + amount * 0.7 + "元");
        }
    }

    /**
     * 任务：
     *     计算该年该月天数
     * 一年中有 12 个月，而每个月的天数是不一样的。其中大月 31 天，分别为1,3,5,7,8,
     * 10,12 月，小月 30 天，分别 为 4,6,9,11月。还有二月比较特殊，平年的二月只有
     * 28 天，而闰年的二月有 29 天，由用户在控制台输入年份和月份，程序计算该年该月的
     * 天数。
     */
    public static void calculateDays() {
        System.out.println("请输入年份：");
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        System.out.println("请输入月份：");
        int month = input.nextInt();
        // 判断年份为闰年还是平年，true为闰年,false为平年
        if (year%4 == 0 || year%400 == 0) {
            if(month == 4 | month == 6 | month == 9 | month ==11) {
                System.out.println(year + "年" + month + "月有30天");
            }else if (month == 2) {
                System.out.println(year + "年" + month + "月有29天");
            }else {
                System.out.println(year + "年" + month + "月有31天");
            }
        }else {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println(year + "年" + month + "月有31天");
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println(year + "年" + month + "月有30天");
                    break;
                case 2:
                    System.out.println(year + "年" + month + "月有28天");
                    break;

            }
        }
    }

    /**
     * 任务：
     *     图形打印任务
     图形1：
     *
     **
     ***
     ****
     *****

     图形2：
     *****
     ****
     ***
     **
     *

     图形3：
         *
        ***
       *****
      *******
     *********
     */
    public static void shapeStamping() {
        System.out.println("图形1：");
        // 打印行，共5行
        for (int i = 0;i < 5;i++) {
            // 打印列，与行的关系为相等
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("图形2：");
        // 打印行，共5行
        for (int i = 0;i < 5;i++) {
            // 打印列，与列的关系为5-i,即第0行有5-0=5列，然后依次递减
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("图形3：");
        // 打印行，共5行
        for (int i = 0; i < 5; i++) {
            // 打印列(空格），与行的关系为4 - i
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            // 打印列(*），与行的关系为i*2 + 1,即1，3，5，7
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 任务：
     * 打印九九乘法表
     */
    public static void multiplicationTable() {
        System.out.println("乘法口诀表：");
        // 打印行，共9行
        for (int i = 1; i < 10; i++) {
            // 打印列，与行的关系为相等。
            for (int j = 1; j < i + 1; j++) {
                // 输出列与行的相乘
                System.out.print(j + "*" + i + " ");
            }
            System.out.println();
        }
    }

    /**
     * 任务：
     * 打印三位数中的所有水仙花数
     * 所谓“水仙花数”即一个整数满足其值等于各个数位的立方和。
     * 如: 153 是一个水仙花数，因为 153= 1³+5³+3³
     */
    public static void narcissisticNumber() {
        // 循环获取所有的三位数
        for (int i = 100;i < 1000;i++) {
            // 获取三位数的各位数字
            int hundred = i/100;
            int ten = i%100 /10;
            int one = i%100%10;
            // 判断该数字是否满足其值等于各个数位的立方和，Math.pow()可获取次方值，3代表立方。
            if (i == Math.pow(one, 3) + Math.pow(ten, 3) + Math.pow(hundred, 3)) {
                System.out.print(i + " ");
            }
        }
    }
}

```

###### 效果：

![计算应缴金额](https://note.youdao.com/yws/api/personal/file/C9E623708EB44806943F36BE4D578F8D?method=download&shareKey=1f62615dea71d4f6e2ff7a8106c267e3)

![计算该年该月天数](https://note.youdao.com/yws/api/personal/file/CF3A8A68B8664B06854DE8E04FC8DBAE?method=download&shareKey=a2dfa05c383b4716c404057df8219283)

![图形打印](https://note.youdao.com/yws/api/personal/file/0F1B7CEC34E7485F8C28830F1ECA4814?method=download&shareKey=83aafcff1baf777b8f64ee3defd49578)

![乘法表](https://note.youdao.com/yws/api/personal/file/863A7C9733E2482BB60746AE5004487E?method=download&shareKey=19dc803f2aed12a23d17b73ecc784d5a)

![水仙花数](https://note.youdao.com/yws/api/personal/file/3C4D97E97A8D470FA78A8BB7DAC24825?method=download&shareKey=b3e24afb748efbcf80e640a720b85043)

