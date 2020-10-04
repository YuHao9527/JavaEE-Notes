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
        int[][] students = new int[5][];
        System.out.println("共5位同学参加游戏！");
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
