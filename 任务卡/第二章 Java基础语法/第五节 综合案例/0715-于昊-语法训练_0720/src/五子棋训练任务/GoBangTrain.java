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
