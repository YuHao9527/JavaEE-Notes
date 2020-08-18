import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName TwoColorBall
 * @Description 双色球彩票训练任务
 * @Author 0715-YuHao
 * @Date 2020/7/17 13:14
 *
 * 思路：
 * 1. 系统随机生成 6 个 1—33 的数字（代表红色球）+1 个 1—16 数字（代表蓝色球），制作一期双色球号码数组。
 * 2. 请用户输入 6 个不重复的 1—33 数字（代表红色球）+1 个 1—16 数字（代表蓝色球）并制作彩票数组。
 * 3. 比较对比确认几等奖。
 */
public class TwoColorBall {
    /**
     * @Author 0715-YuHao
     * @Description 双色球彩票训练任务
     * 玩法规则：“双色球”每注投注号码由 6 个红色球号码和 1 个蓝色球号码组成。红色球号码从
     * 1—33 中选择，蓝色球号码从 1—16 中选择。球的数字匹配数量和颜色决定了是否中奖。
     * @Date 2020/7/20 15:29
     * @Param [args]
     * @return void
     */
    public static void main(String[] args) {
        // 1. 随机生成彩票大奖数组
        int[][] award = makeAward();
        // 2. 提示用户输入双色球号码、生成彩票
        // 红色球号码数组
        int[] redBall = new int[6];
        // 双色球号码
        int number;
        System.out.println("**********欢迎使用本彩票购买机**********");
        // 循环输入6位双色球号码
        for (int i = 1; i < 7; i++) {
            System.out.println("请输入第" + i + "位红色球号码(1-33)：");
            // 判断输入是否重复
            w:while (true) {
                // 输入红色球号码，并判断输入的数字是否在范围内
                number = inputNumber(0);
                // 循环遍历数组，检查是否重复
                for (int j = 0;j < redBall.length;j++) {
                    // 重复则重新输入
                    if (redBall[j] == number) {
                        System.out.println("这个数字你已经输过了，请重新输入：");
                        break;
                    }else if(j == redBall.length - 1 && redBall[j] != number){
                        // 无重复数字、结束while循环
                        redBall[i - 1] = number;
                        break w;
                    }
                }
            }
        }
        // 输入蓝色球号码
        System.out.println("请输入一位蓝色球号码(1-16)：");
        int blueBall = inputNumber(1);
        System.out.println("---------------------");
        // 打印彩票
        System.out.println("你的彩票为：");
        System.out.print("红色球：");
        for (int red : redBall) {
            System.out.print(red + " ");
        }
        System.out.println();
        System.out.println("蓝色球：" + blueBall);
        // 打印本期双色球号码
        System.out.println("本期双色球号码：");
        System.out.print("红色球：");
        for (int red : award[0]) {
            System.out.print(red + " ");
        }
        System.out.println();
        System.out.println("蓝色球：" + award[1][0]);
        // 3. 兑奖
        redeem(award, redBall, blueBall);
    }

    /**
     * @Author 0715-YuHao
     * @Description 判断用户输入的数字是否符合要求
     * @Date 2020/7/20 17:08
     * @Param [color] 0为红色球、1为蓝色球
     * @return 正确号码
     */
    public static int inputNumber(int color) {
        Scanner scanner = new Scanner(System.in);
        // 数组长度大于1表明为红色球
        if (color == 0) {
            while (true) {
                int number = scanner.nextInt();
                // 红色球号码取值范围（1-33）
                if (number > 33 | number < 0) {
                    System.out.println("你输入的数据有误，请重新输入：");
                    continue;
                }
                return number;
            }
        }else {
            while (true) {
                int number = scanner.nextInt();
                // 蓝色球号码取值范围（1-16）
                if (number > 16 | number < 0) {
                    System.out.println("你输入的数据有误，请重新输入：");
                    continue;
                }
                return number;
            }
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 制作一期双色球号码，为二维数组，分别添加红色球和蓝色球
     * @Date 2020/7/20 17:09
     * @Param []
     * @return int[][] 返回双色球号码二维数组
     */
    public static int[][] makeAward() {
        Random random = new Random();
        int number;
        int[][] award = new int[2][];
        int[] redBall = new int[6];
        for (int i = 0; i < redBall.length; i++) {
            // 生成随机数（1-33），并添加进数组
            number = random.nextInt(33) + 1;
            // 循环遍历数组，查找重复数字
            for (int j = 0; j < redBall.length; j++) {
                if (number == redBall[j]){
                    i--;
                }else if (j == redBall.length - 1 && number != redBall[j]){
                    redBall[i] = number;
                }
            }
        }
        // 添加红色球号码
        award[0] = redBall;
        int[] blueBall = new int[] {random.nextInt(16) + 1};
        // 添加蓝色球号码
        award[1] = blueBall;
        return award;
    }

    /**
     * @Author 0715-YuHao
     * @Description 比较对比确认几等奖。
     * @Date 2020/7/20 17:09
     * @Param [award, redBall, blueBall] [本期双色球号码数组, 红色球号码, 蓝色球号码]
     * @return void
     */
    public static void redeem(int[][] award, int[] redBall, int blueBall) {
        // 红色球相同数
        int redCount = 0;
        // 蓝色球是否相同
        boolean blue = false;
        // 遍历红色球数组
        for (int value : redBall) {
            // 循环与双色球数组红色球号码比对
            for (int j = 0; j < award[0].length; j++) {
                // 相等则加一
                if (value == award[0][j]) {
                    redCount++;
                }
            }
        }
        // 判断蓝色球是否相等
        if (award[1][0] == blueBall) {
            blue = true;
        }
        // 开始兑奖
        if (blue) {
            switch (redCount) {
                case 0:
                case 1:
                case 2:
                    System.out.println("恭喜你中了六等奖！");
                    break;
                case 3:
                    System.out.println("恭喜你中了五等奖！");
                    break;
                case 4:
                    System.out.println("恭喜你中了四等奖！");
                    break;
                case 5:
                    System.out.println("恭喜你中了三等奖！");
                    break;
                case 6:
                    System.out.println("恭喜你中了一等奖！");
                    break;
            }
        }else {
            switch (redCount) {
                case 4:
                    System.out.println("恭喜你中了五等奖！");
                    break;
                case 6:
                    System.out.println("恭喜你中了二等奖！");
                    break;
                default:
                    System.out.println("不好意思，大奖与你失之交臂！");
                    break;
            }
        }
    }

}
