/**
 * @ClassName Task2
 * @Description 任务2
 * @Author 0715-YuHao
 * @Date 2020/7/22 15:10
 */
public class Task2 {

    public static void main(String[] args) {
        // 创建Game对象
        Game game = new Game("谁是卧底");
        // 输入属性值
        game.type = "聚会小游戏";
        game.size = "null";
        game.start = "五颗星";
        game.info = "参与游戏的人中，除一人外均拿同一词语，剩下1人拿到与之相关" +
                "的另一词语，即为卧底人选，得票多者每人用一句话描述自己的词语后" +
                "，进行投票选出卧底人选，得票多者出局。若卧底出局，则游戏结束。" +
                "反之，游戏继续。若卧底到最后一轮（场上剩3人时），则卧底获胜。";
        //调用show方法，打印游戏介绍
        game.show();
    }
}

/**
 * @ClassName Game
 * @Description 定义一个游戏类，包括游戏的属性包括：游戏名、类型、大小、星级、
 * 介绍等，可以调用方法输出游戏的介绍。
 * @Author 0715-YuHao
 * @Date 2020/7/22 15:10
 */
class Game {
    // 无参构造方法
    public Game() {}
    // 游戏名称构造方法
    public Game(String n) {
        name = n;
    }
    // 属性：游戏名称、类型、大小、星级、详情
    String name, type, size, start, info;

    /**
     * @Author 0715-YuHao
     * @Description 打印所有属性，输出游戏介绍
     * @Date 2020/7/22 15:13
     * @Param []
     * @return void
     */
    public void show() {
        System.out.println("游戏名称：" + name);
        System.out.println("游戏类型：" + type);
        System.out.println("游戏大小：" + size);
        System.out.println("星级：" + start);
        System.out.println("游戏简介：" + info);
    }
}
