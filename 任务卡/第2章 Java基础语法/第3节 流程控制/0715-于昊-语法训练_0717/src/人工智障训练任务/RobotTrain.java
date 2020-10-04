import java.util.Scanner;

public class RobotTrain {
    /**
     * @Author 0715-YuHao
     * @Description // 人工智障训练
     * @Date 2020/7/16 22:09
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
