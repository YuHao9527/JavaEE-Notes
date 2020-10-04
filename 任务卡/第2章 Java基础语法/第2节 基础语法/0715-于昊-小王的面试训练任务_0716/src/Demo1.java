public class Demo1 {
    /**
     * 任务：
     *      定义一个整型变量并赋任意五位正整数作为初始值，判断它是不是五位
     * 回文数
     * （五位回文数：个位与万位相同，十位与千位相同，例如：12321）：
     * @param args
     */
    public static void main(String[] args) {
        int a = 12321;
        // 获取每位的数字
        int ten_thousand = a / 10000;
        int thousand = a % 10000 / 1000;
        int hundred = a % 10000 % 1000 / 100;
        int ten = a % 10000 % 1000 % 100 / 10;
        int one = a % 10000 % 1000 % 100 % 10;
        // 判断个位与万位相同，十位与千位相同
        if (one == ten_thousand) {
            if (thousand == ten) {
                System.out.println(a + "是回文数。");
            }else {
                System.out.println(a + "不是回文数");
            }
        }else {
            System.out.println(a + "不是回文数。");
        }
    }

}
