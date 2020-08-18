public class Demo3 {
    /**
     * 任务：
     *     定义整型变量 a、b，写出将 a、b 两个变量值进行互换的程序
     *  （要求不能使用第三个变量）
     * @param args
     */
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        // 求和再求差
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("***求和再求差互换***");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        // 异或
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println("***异或互换***");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

}
