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
