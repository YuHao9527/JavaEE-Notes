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
        narcissisticNumber();

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
                    System.out.println(year + "年" + month + "月有29天");
                    break;
                default:
                    System.out.println("对不起，你的输入有误！");
                    break;
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
                default:
                    System.out.println("对不起，你的输入有误！");
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
