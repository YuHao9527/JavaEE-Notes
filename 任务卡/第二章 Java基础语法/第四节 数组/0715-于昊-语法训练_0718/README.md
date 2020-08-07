# 数组

​	数组是相同数据类型的**多个数据的容器**。

​	这些元素按**线性顺序排列**。所谓线性顺序排列指除第一个元素外，每一个元素都有唯一的前驱元素;除最后一个元素外，每一个元素都有唯一的后继元素。(**"简单理解：一个跟一个顺序排列"**)

### 创建格式

​	格式1 . 数据类型[] 数组名称 = new 数据类型[数组长度];

​	格式2. 数据类型[] 数组名称  = {数组内容1, 数组内容2, 数组内容3... 数组内容n};

​	格式3. 数据类型[] 数组名称;

​			格式 3属于只创建了数组引用名， 并未在内存创建数组空间。 

​	格式4. 数据类型[] 数组名称 = new 数据类型[] {内容1, 内容2, 内容 3...内容 n};

​	**常用前两种格式**

### 下标

​	可以理解为数组中内容的数字序号为，从0开始，对于长度为n的数组，下标的范围为0~n-1。

​	可以通过下标的方式访问数组中的每一个元素。

​	例如：创建int类型数组arr，给数组arr的5下标赋值数据，然后打印。

```java
int[] arr = new int[10];
arr[5] = 123;
System.out.println(arr[5]);
```

### 数组长度的获取

​	数组名称.length

### 注意

​	使用数组不当，会出现如下问题:

1. 数组未赋值：空指针异常
2. 超出长度的下标操作：数组越界异常
3. **注意：**数组的长度在创建时就固定了。

## 数组常用算法

### 冒泡排序

#### 原理：

- 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
- 对每一对相邻元素做同样的工作，从开始第一对到结尾最后一对。在这一点，最后的元素应该会是最大的数。
- 针对所有的元素重复以上的步骤，除最后一个。
- 持续每次对越来越少的元素重复上面的步骤，知道没有任何一对数字需要比较。

#### 名字由来：

​	是因为最小（或最大）的元素会经由交换慢慢“浮”到数列的顶端（降序或升序），就如同水中的气泡最终会上浮到顶端一样，故名“冒泡排序”。

#### 口诀：

##### 升序排序口诀：

​	N个数字来排队，
	两两相比小靠前。
	外层 循环length-1，
	内层循环length-i-1。

##### 降序排序口诀：

​	N个数字来排队，
	两两相比大靠前。
	外层 循环length-1，
	内层循环length-i-1。

### 二分查找

#### 概述:

​	二分查找也称折半查找（Binary Search），它是一种效率较高的查找方法。但是，二分查找要求数组数据必须采用顺序存储结构有序排列。

#### 原理：

首先，假设数组中元素是按升序排列，将数组中间位置的数据与查找数据比较，如果两者相等，则查找成功；否则利用中间位置记录将数组分成前、后两个子数组，如果中间位置数据大于查找数据，则进一步查找前子数组，否则进一步查找后子数组。
重复以上过程，直到找到满足条件的数据，则表示查找成功，直到子数组不存在为止，表示查找不成功。

## 支线任务

### 1、选队长游戏训练任务

#### 任务概述：

​	今天同学们相约一起爬山游玩，为了更好的进行这场活动，大家准备推举一个人作为出游的临时队长。为了体现合理公平，大家提出了一个比较有趣的规则。所有人围成一圈，顺序排号。从第一个人开始报数（从 1 到 3 报数），凡报到 3 的人退出圈子，剩下的人继续报数，最后留下的当选为队长。
	请你通过编写程序，求出一组人中的队长是原来第几位同学。

##### 代码如下：

```java
/**
 * @ClassName GameElectedCaptain
 * @Description 选队长游戏训练任务
 * @Author 0715-YuHao
 * @Date 2020/7/18 09:25
 */
public class GameElectedCaptain {
    /**
     * @Author 0715-YuHao
     * @Description 选队长游戏训练任务
     *      今天同学们相约一起爬山游玩，为了更好的进行这场活动，大家准备推举
     * 一个人作为出游的临时队长。为了体现合理公平，大家提出了一个比较有趣的
     * 规则。所有人围成一圈，顺序排号。从第一个人开始报数（从 1 到 3 报数），
     * 凡报到 3 的人退出圈子，剩下的人继续报数，最后留下的当选为队长。
     * 请你通过编写程序，求出一组人中的队长是原来第几位同学。
     * @Date 2020/7/18 9:31
     * @Param [args]
     * @return void
     */
    public static void main(String[] args) {
        // 定义学生数组，二维数组
        int[][] students = new int[8][];
        System.out.println("共8位同学参加游戏！");
        // count为报数，num用于记录报数非3的同学数量，number标记第几位同学
        int count = 0, num = 0, number = 1;
        // 学生数组初始化，为每位同学编号
        for (int i = 0; i < students.length; i++) {
            students[i] = new int[]{number++, 0};
        }
        while (true) {
            // 开始报数，count初始值为0
            reported(students, count);
            // 记录最后一位同学报数，形成闭环
            count = students[students.length - 1][1];
            // 统计报数非3的同学数
            for (int[] student : students) {
                // 如果count非3，num加1
                if (student[1] != 3) {
                    num++;
                }
            }
            // 删除报3同学，返回新的数组
            students = sort(students, num);
            // 如果报数非3的同学只剩下一位，队长产生
            if (num == 1){
                System.out.println("队长是第" + students[0][0] + "位同学");
                break;
            }
            // 复位
            num = 0;
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 用于记录学生报数
     * @Date 2020/7/18 09:40
     * @Param [students, count] [学生数组, 最后一位学生报的数]
     * @return void
     */
    public static void reported(int[][] students, int count) {
        // 如果报数为3，应改为0否则自加为4，形成死循环。
        if (count == 3) {
            count = 0;
        }
        // 循环报数, 并添加进数组
        for (int i = 0; i < students.length; i++) {
            students[i][1] = ++count;
            // 如果报数为3，应改为0否则自加为4，形成死循环。
            if (count == 3) {
                count = 0;
            }
        }
    }
    
    /**
     * @Author 0715-YuHao
     * @Description 删除报3的同学,并返回新的学生数组
     * @Date 2020/7/18 09:42
     * @Param [students, num] [学生数组， 报数非3的同学数]
     * @return int[][] students
     */
    public static int[][] sort(int[][] students,int num) {
        // 定义新的学生数组，长度为报数非3的同学数num
        int[][] newStudents = new int[num][];
        int i = 0;
        for (int[] student : students) {
            // 将报数非3的同学加入新的数组
            if (student[1] != 3) {
                newStudents[i++] = student;
            }
        }
        return newStudents;
    }

}
```

##### 效果如下：

![captain1](https://note.youdao.com/yws/api/personal/file/AB27EC0E57EF48E6A7642F77A7C7AE02?method=download&shareKey=b58e26e1304b7c820b31251c8b90453b)

![captain](https://note.youdao.com/yws/api/personal/file/D4C63AA0F8F5444CA511CF9785F58607?method=download&shareKey=a3ddca3bae45b7791dd5373da8b8bce0)



### 2、流程控制的逻辑训练任务(数组+逻辑)

#### 任务概述：

数组学习完毕，又到了有必要锻炼大家逻辑能力的时候了。本节任务主要
涉及了几个逻辑题，请一一完成。

1. 查找某个整数

   定义一个长度为 10 的整型数组 nums ，循环输入 10 个整数。 然后将输入一个整数，查找此整数，找到输出下标， 没找到给出提示。


2. 找出数组的最值

   定义一个长度为 10 的整型数组 nums ，循环输入 10 个整数。输出数组的最大值、最小值。


3. 两数之和

   给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并输出他们的数组下标假设每种输入只会对应一个答案，不能重复利用这个数组中同样的元素。

   示例:

   给定 nums = [2, 7, 11, 15], target = 9

   因为 nums[0] + nums[1] = 2 + 7 = 9

   所以输出 0，1


4. 排序并查找

   对数组{1，3，9，5，6，7，15，4，8}进行排序，然后使用二分查找 6 并输出排序后的下标。


5. 移动零

   给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

   示例:

   输入: [0,1,0,3,12] 输出: [1,3,12,0,0]

##### 代码如下：

```java
import java.util.Scanner;

/**
 * @ClassName GameElectedCaptain
 * @Description 流程控制的逻辑训练任务(数组+逻辑)
 * @Author 0715-YuHao
 * @Date 2020/7/18 09:30
 */
public class ProcessControl {
    /**
     * @Author 0715-YuHao
     * @Description 流程控制的逻辑训练任务(数组+逻辑)
     * @Date 2020/7/18 09:32
     * @Param [args]
     * @return void
     */
    public static void main(String[] args) {
        //1. 查找某个整数
        //searchNum();

        // 2. 找出数组的最值
        // maxMin();

        // 3. 两数之和
        //numsSum();

        // 4、排序并查找
        //sortSearch();

        // 5、移动零
        //moveZero();


    }

    /**
     * @Author 0715-YuHao
     * @Description 1.查找某个整数
     * 定义一个长度为 10 的整型数组 nums ，循环输入 10 个整数。 然后将输入一个整数，
     * 查找此整数，找到输出下标， 没找到给出提示。
     * @Date 2020/7/18 10:46
     * @Param []
     * @return void
     */
    public static void searchNum() {
        // 定义一个长度为10的整数数组
        int[] nums = new int[10];
        boolean option = true;
        // 循环输入10个整数（不清楚是随机还顺序存储）
        // 1. 随机10个整数
        //for (int i = 0; i < 10; i++) {
        //    nums[i] = (int) (Math.random()*10 +1);
        //}
        // 2. 顺序输入10个整数
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        // 提示用户输入数字
        System.out.println("请输入一个1-10以内的任意整数：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        /* // 随机整数的查询方式
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 判断nums中元素是否等于num
            if (nums[i] == num) {
                // 相等则输出下标
                System.out.println("要查找的数据的下标为：" + i);
                // 因为随机数可能会出现重复，这是为了用于查找所有num的标记
                option = false;
            } else if (option && i == 9 && nums[i] != num) {
                // 如果查到最后都未查到，则输出查询不到
                System.out.println("查不到你输入的数字");
            }
        }
         */
        // 顺序数组采用二分查找
        // 最小范围下标
        int minIndex = 0;
        // 最大范围坐标
        int maxIndex = nums.length - 1;
        // 中间数据下标
        int centerIndex = (minIndex + maxIndex) / 2;
        while (true) {
            // 如果中间数据大于查找数据，则最大坐标变为中间坐标-1
            if (nums[centerIndex] > num) {
                maxIndex = centerIndex - 1;
            }else if(nums[centerIndex] < num) { // 如果中间数据小于查找数据，则最小坐标变为中间坐标+1
                minIndex = centerIndex + 1;
            }else {
                break;
            }
            // 如果最小坐标大于最大坐标，表明没有找到数据，标记为-1
            if (minIndex > maxIndex) {
                centerIndex = -1;
                break;
            }
            // 当边界发生变化时，需要更新中间下标
            centerIndex = (minIndex + maxIndex) / 2;
        }
        System.out.println("要查找的数据的下标为：" + centerIndex);
    }

    /**
     * @Author 0715-YuHao
     * @Description 2. 找出数组的最值
     * 定义一个长度为 10 的整型数组 nums ，循环输入 10 个整数。输出数组的最大值、最小
     * 值。
     * @Date 2020/7/18 10:47
     * @Param []
     * @return void
     */
    public static void maxMin() {
        // 定义一个长度为 10 的整型数组 nums
        int[] nums = new int[10];
        // 循环输入 10 个 随机整数（1~10）使用Math.random()函数
        for (int i = 0; i < 10; i++) {
            nums[i] = (int) (Math.random()*10 +1);
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        // 判断最大值
        int max = nums[0], min = nums[0];
        // 循环比较
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        // 判断最小值
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        System.out.println("最大值为：" + max);
        System.out.println("最小值为：" + min);
    }

    /**
     * @Author 0715-YuHao
     * @Description 3. 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两
     * 个整数，并输出他们的数组下标
     * 假设每种输入只会对应一个答案，不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以输出 0，1
     * @Date 2020/7/18 10:50
     * @Param []
     * @return void
     */
    public static void numsSum() {
        // 给定一个整数数组 nums 和一个目标值 target
        int[] nums = {2, 6, 7, 11, 15};
        int target = 13;
        // 输出数组和target
        for(int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("\ntarget：" + target);
        // 循环遍历数组
        for (int i = 0; i < nums.length - 1; i++) {
            // 数组中每个数都与它后面的数相加一遍，保证不会重复相加
            for (int j = i + 1; j < nums.length; j++) {
                // 判断相加之和是否与target相等
                if (target == nums[i] + nums[j]) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 4、排序并查找
     * 对数组{1，3，9，5，6，7，15，4，8}进行排序，然后使用二分查找6并输出排序后的下
     * 标。
     * @Date 2020/7/18 10:51
     * @Param []
     * @return void
     */
    public static void sortSearch() {
        int[] nums = {1, 3, 9, 5, 6, 7, 15, 4, 8};
        // 冒泡法排序
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    nums[j] = nums[j] ^ nums[j + 1];
                    nums[j + 1] = nums[j] ^ nums[j + 1];
                    nums[j] = nums[j] ^ nums[j + 1];
                    flag = false;
                }
            }
            // 如果未发生位置更换，表明排序完成了，无需继续排序
            if (flag) {
                break;
            }
        }
        // 输出排序后的数组
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        // 二分法查找6
        int maxIndex = nums.length, minIndex = 0;
        int middleIndex = (maxIndex + minIndex) / 2;
        while (true){
            if (nums[middleIndex] > 6) {
                maxIndex = middleIndex;
            }else if (nums[middleIndex] < 6) {
                minIndex = middleIndex;
            }else {
                break;
            }
            middleIndex = (maxIndex + minIndex) / 2;
        }
        System.out.println("下标：" + middleIndex);
    }

    /**
     * @Author 0715-YuHao
     * @Description 5、移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相
     * 对顺序。
     * 示例:
     * 输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
     * @Date 2020/7/18 10:48
     * @Param []
     * @return void
     */
    public static void moveZero() {
        int[] nums = {0, 1, 0, 3, 12};
        int len = nums.length;
        // 循环遍历数组
        for (int i = 0; i < len; i++) {
            // 判断元素是否为0
            if (nums[i] == 0) {
                // 如果为0，顺位替换
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                //替换完成后将数组最后一位赋值为0，并将循环次数减一，避免重复操作
                nums[--len] = 0;
            }
        }
        // 输出完成后的数组
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
```

##### 效果如下：

##### 1.查找某个整数

![process1](https://note.youdao.com/yws/api/personal/file/9691FEA216E74A898DD833994EFF7AF0?method=download&shareKey=5fa9988779422481cd139fedbe6608d1)

##### 2. 找出数组的最值

![process2](https://note.youdao.com/yws/api/personal/file/9E875C436E414988954003CE3DFB7FF6?method=download&shareKey=c00ee40d2a6a3a304aea0e5ea7d37882)

##### 3. 两数之和

![process3](https://note.youdao.com/yws/api/personal/file/D59279B4BAF049ADADE0EFC5CFA6660F?method=download&shareKey=1188454fcc66e019675bd79c4e132f2c)

##### 4、排序并查找

![process4](https://note.youdao.com/yws/api/personal/file/62031D66EFD84B7F906ECE25973C4537?method=download&shareKey=fb694f79abc6090054159eed5ebc877f)

##### 5、移动零

![process5](https://note.youdao.com/yws/api/personal/file/66210DFC769B47499B68481536387F20?method=download&shareKey=33de4d5c6dfaaf130672bbb573f8073b)

