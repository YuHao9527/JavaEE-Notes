# 综合案例

### 双色球彩票训练任务

#### 任务概述：

​	玩法规则：“双色球”每注投注号码由 6 个红色球号码和 1 个蓝色球号码组成。红色球号码从 1—33 中选择，蓝色球号码从 1—16 中选择。球的数字匹配数量和颜色决定了是否中奖，具体中奖规则：

![中奖规则](https://note.youdao.com/yws/api/personal/file/338447FD9A22400686414A2D662168C9?method=download&shareKey=828118899924f312cad6c8bfb48a91d0)

##### 代码如下：

```java
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
```

###### 总结：

1. 随机数生成：Random().netInt(num) 随机生成0(含) ~ num(不含)范围内一个随机整数
2. 判断是否有重复数字：
   - 第一种方法：先生成一个随机数，然后遍历数组，将随机数与数组内数字比较
   - 第二种方法：创建一个boolean类型的数组，默认值为false;通过索引值比较来修改值，例如生成随机数10，由于默认为false，我们可以使用if语句判断，false就执行赋值并将值修改为true，则下次生成10则不会进入赋值

##### 效果：

![ball1](https://note.youdao.com/yws/api/personal/file/DC4583BF28D44018974C43CA0B3A5B72?method=download&shareKey=27c278dc09cfb4942564ae4ab13a22e0)

![ball2](https://note.youdao.com/yws/api/personal/file/DA1842ADC2494273A0F22FC5D84F5EFA?method=download&shareKey=cb788d445d025573cdd76e1c1d090804)

### 五子棋训练任务

#### 任务概述：

​	五子棋是全国智力运动会竞技项目之一，是一种两人对弈的纯策略型棋类游戏。通常双方分别使用黑白两色的棋子，下在棋盘直线与横线的交叉点上，先形成五子连线者获胜。棋盘效果如下：

0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	
1	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
2	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
3	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
4	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
5	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
6	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
7	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
8	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
9	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
10	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
11	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
12	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
13	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
14	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
15	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0

##### 代码：

```java
import java.util.Scanner;

/**
 * @ClassName GoBangTrain
 * @Description 五子棋训练任务
 * @Author 0715-YuHao
 * @Date 2020/7/17 13:15
 */
public class GoBangTrain {

    /**
     * @Author 0715-YuHao
     * @Description // 五子棋是全国智力运动会竞技项目之一，是一种两人对弈的纯策略型棋类
     * 游戏。通常双方分别使用黑白两色的棋子，下在棋盘直线与横线的交叉点上，先形成五子连线
     * 者获胜。
     * @Date 2020/7/17 13:16
     * @Param [args]
     * @return void
     */
    public static void main(String[] args) {
        System.out.println("*****棋局开始*****");
        // 1. 绘制棋盘
        int[][] board = new int[16][16];
        checkerBoard(board, 0, 0, 0);// 初始化棋盘
        Scanner scanner = new Scanner(System.in);
        // 2. 提示黑方（用 1 表示）和白方（用 2 表示）分别下棋（X，Y 轴位置）并重新绘制棋盘。
        while (true) {

            System.out.println("黑方落子：");
            System.out.println("请输入坐标(x y):");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            checkerBoard(board, 1, x, y);
            // 3. 每当一方下棋后判断是否获胜。
            if (whoWinGame(board) == 1) {
                System.out.println("游戏结束，恭喜黑方获胜");
                break;
            }
            System.out.println("白方落子：");
            System.out.println("请输入坐标(x y):");
            x = scanner.nextInt();
            y = scanner.nextInt();
            checkerBoard(board, 2, x, y);
            // 3. 每当一方下棋后判断是否获胜。
            if (whoWinGame(board) == 2) {
                System.out.println("游戏结束，恭喜白方获胜");
                break;
            }
        }
    }
    /**
     * @Author 0715-YuHao
     * @Description 定义棋盘数组
     * @Date 2020/7/18 19:34
     * @Param [board, player, x, y] [棋盘数组, 棋手, 落子坐标]
     * @return 棋盘数组
     */
    public static void checkerBoard(int[][] board, int player, int x, int y) {
        // 判断棋手，0代表初始化棋盘、1代表黑方、2代表白方
        if (player == 0) {
            // 更新棋盘行数据
            for (int i = 0; i < board.length; i++) {
                // 绘制棋盘第一行
                if (i == 0) {
                    // 0 ~ 15
                    for (int j = 0; j < board[i].length; j++) {
                        board[i][j] = j;
                    }
                } else { // 更新棋盘列数据
                    for (int j = 0; j < board[i].length; j++) {
                        // 绘制棋盘第一列 0 ~ 15
                        if (j == 0) {
                            board[i][j] = i;
                        } else { // 其余棋盘数据为0
                            board[i][j] = 0;
                        }
                    }
                }
            }
            drawCheckerBoard(board);
        }else if (player == 1) {
            board[x][y] = '●'; // 对应Ascii码为9679
            drawCheckerBoard(board);
        }else if (player == 2) {
            board[x][y] = '○'; // 对应Ascii码为9675
            drawCheckerBoard(board);
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 绘制棋盘
     * @Date 2020/7/18 19:35
     * @Param [board] [棋盘数组]
     * @return void
     */
    public static void drawCheckerBoard(int[][] board) {
        // 循环棋盘行
        for (int[] ints : board) {
            // 循环棋盘列
            for (int anInt : ints) {
                // 打印棋盘
                // ●的Ascii码为9679、○的Ascii码为9675
                if (anInt == 9679){ // 打印黑子
                    String str = "●";
                    System.out.print(str + "\t");
                }else if (anInt == 9675){
                    String str = "○"; // 打印白子
                    System.out.print(str + "\t");
                }else {
                    System.out.print(anInt + "\t");
                }

            }
            System.out.println();
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 判断获胜方
     * @Date 2020/7/18 20:00
     * @Param [board] [棋盘数组]
     * @return int 1代表黑方胜、2代表白方胜、0代表棋局继续
     */
    public static int whoWinGame(int[][] board) {
        // 判断标记
        boolean flag;
        // 循环扫描棋盘
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[1].length; j++) {
                // 发现黑子，检查棋盘
                if (board[i][j] == 9679) {
                    flag = judgement(board, i, j, 9679);
                    if (flag) {
                        return 1;
                    }
                }else if (board[i][j] == 9675) { // 发现白子，检查棋盘
                    flag = judgement(board, i, j, 9675);
                    if (flag) {
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * @Author 0715-YuHao
     * @Description // 判断是否有五子相连
     * @Date 2020/7/19 13:10
     * @Param [board, x, y, color] [棋盘数组, 棋子的x坐标, 棋子的y坐标, 棋子颜色]
     * @return boolean // true代表有五子相连
     */
    public static boolean judgement(int[][] board, int x, int y, int color) {
        int count = 1;
        // 1. 横向检查（只改变x）
        // 先向左检查
        for (int i = x - 1; i > 0; i--) {
            // 棋子相连，count加1
            if (board[i][y] == color) {
                count++;
            }else { // 棋子连接断开，退出循环
                break;
            }
        }
        // 再向右检查
        for (int i = x + 1; i < 16; i++) {
            // 棋子相连，count加1
            if (board[i][y] == color) {
                count++;
            }else { // 棋子连接断开，退出循环
                break;
            }
        }
        // 判断连子数
        if (count > 4) {
            return true;
        }else {
            // 初始化count
            count = 1;
        }
        // 2.纵向扫描（只改变y）
        // 先向上检查
        for (int i = y - 1; i > 0; i--) {
            // 棋子相连，count加1
            if (board[x][i] == color) {
                count++;
            }else { // 棋子连接断开，退出循环
                break;
            }
        }
        // 再向下检查
        for (int i = y + 1; i < 16; i++) {
            // 棋子相连，count加1
            if (board[x][i] == color) {
                count++;
            }else { // 棋子连接断开，退出循环
                break;
            }
        }
        if (count > 4) {
            return true;
        }else {
            count = 1;
        }
        // 3.斜向扫描（左上、右下和左下、右上）（同时改变x, y）
        // 先左上检查
        for (int i = x - 1, j = y - 1; i > 0 && j > 0; i--,j--) {
            // 棋子相连，count加1
            if (board[i][j] == color) {
                count++;
            }else { // 棋子连接断开，退出循环
                break;
            }
        }
        // 再右下检查
        for (int i = x + 1, j = y + 1; i < 16 && j < 16; i++, j++) {
            // 棋子相连，count加1
            if (board[i][j] == color) {
                count++;
            }else { // 棋子连接断开，退出循环
                break;
            }
        }
        if (count > 4) {
            return true;
        }else {
            count = 1;
        }
        // 先右上检查
        for (int i = x - 1, j = y + 1; i > 0 && j < 16; i--,j++) {
            // 棋子相连，count加1
            if (board[i][j] == color) {
                count++;
            }else { // 棋子连接断开，退出循环
                break;
            }
        }
        // 再左下检查
        for (int i = x + 1, j = y - 1; i < 16 && j > 0; i++, j--) {
            // 棋子相连，count加1
            if (board[i][j] == color) {
                count++;
            }else { // 棋子连接断开，退出循环
                break;
            }
        }
        // 最后一次判断，未查询到五子相连直接false
        return count > 4;
    }
}
```

##### 总结:

1. 绘制棋盘：对于第一行和第一列的绘制，可以使用if语句获取然后按规律打印；其余遍历棋盘数组全部打印为0；

2. 胜利判定条件：解决方法:因为我们知道棋子的坐标，那我们就可以从3个方向考虑，第一是横向的判定，如果有五个棋子相连则胜利，第二是纵向，再是斜向（注意坐标的变化是x,y同时变化）。

   例如：横向判定

   ```java
   public void main(int[][] board, int x, int y) {
       int count = 1;
       // 先向右
       for (int i = x + 1;i<board.lenth;i++) {
           // y不变
           // 棋子相连，count加1
           if(board[i][y] == 棋子代表的值) {
               count++;
           }else {
               // 棋子连接断开，退出循环
               break;
           }
       }
       // 再向左
       for (int i = x - 1;i > 0;i--) {
           // y不变
           // 棋子相连，count加1
           if(board[i][y] == 棋子代表的值) {
               count++;
           }else {
               // 棋子连接断开，退出循环
               break;
           }
       }
       // 判断
       if (count > 4) {
           //胜利
       }else {
           count = 1;//初始化count
       }
       // 然后纵向、斜向判断
       
   }
   ```

##### 效果：

![gobang1](https://note.youdao.com/yws/api/personal/file/3F5CDE65A879495384F4EA0E845DF845?method=download&shareKey=c08629be70ffb62756b8cdbd33ee60ce)

![gobang2](https://note.youdao.com/yws/api/personal/file/0144588CC3FC4B8BB7D027FA537C5388?method=download&shareKey=817518c0a8e0ff38c9c35673d5a4bacf)

![gobang3](https://note.youdao.com/yws/api/personal/file/765186F8E23E4BB3A6FC1095DDB4C901?method=download&shareKey=0b5ecb0d6edb3ad5e07d99d2e8dacb38)

