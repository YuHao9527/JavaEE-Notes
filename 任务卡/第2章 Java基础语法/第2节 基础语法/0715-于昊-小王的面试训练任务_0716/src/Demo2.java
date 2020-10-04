public class Demo2 {
    /**
     * 任务：
     *     定义一个整型变量并赋任意五位正整数作为初始值，输出各位数字之和
     * （例如：12345 各位之和是：1+2+3+4+5 。也就是 15）
     * @param args
     */
    public static void main(String[] args) {
        int a = 12345;
        // 获取每位的数字
        int ten_thousand = a / 10000;
        int thousand = a % 10000 / 1000;
        int hundred = a % 10000 % 1000 / 100;
        int ten = a % 10000 % 1000 % 100 / 10;
        int one = a % 10000 % 1000 % 100 % 10;
        // 求和
        System.out.println(one + ten+ hundred + thousand + ten_thousand);
    }
}
