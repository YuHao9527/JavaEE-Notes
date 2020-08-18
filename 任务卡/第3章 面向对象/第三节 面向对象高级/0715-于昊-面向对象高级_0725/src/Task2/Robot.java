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
