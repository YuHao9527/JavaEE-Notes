package easy.整数反转;

/**
 * @ClassName reverse
 * @Description 整数反转
 * @Author 0715-YuHao
 * @Date 2020/7/22 9:14
 */
public class Reverse {
    /**
     * @Author 0715-YuHao
     * @Description 整数反转：
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * @Date 2020/7/22 9:14
     * @Param [args]
     * @return void
     */
    public static void main(String[] args) {
        int x = -123;
        int res = reverse2(x);
        System.out.println(res);
    }

    /**
     * @Author 0715-YuHao
     * @Description 方法1、求余获取末尾数字
     * @Date 2020/7/22 9:16
     * @Param [x]
     * @return int
     */
    public static int reverse(int x) {
        // 反转后可能溢出，将结果定义成long类型
        long res = 0;
        // 不管整数还是符数求余结果都趋向于0，故将判断条件设为x != 0即可
        while (x != 0) {
            // 取模获取x的最后一位数字，并传入结果
            res = res * 10 + x % 10;
            // 整除运算，去除最后一位数字
            x /= 10;
        }
        // 对结果int类型转换，如若溢出则输出0
        return (int) res == res ? (int) res : 0;
    }

    /**
     * @Author 0715-YuHao
     * @Description 方法2、反转字符串
     * @Date 2020/7/22 9:19
     * @Param [x]
     * @return int
     */
    public static int reverse2(int x) {
        long res = 0;
        // 将int类型转换成String类型
        if (x > 0) {
            String s = String.valueOf(x);
            // 倒叙遍历获取数字
            for (int i = s.length() - 1; i > -1; i--) {
                // 因为字符串其实就相当于一个字符数组，字符转int为对应的Ascii码，我们
                // 我们要获取对应的Int值只需要减去0的Ascii码即可。
                res = res * 10 + s.charAt(i) - '0';
            }
            return (int) res == res ? (int) res : 0;
        }else {
            x *= -1;
            String s = String.valueOf(x);
            // 倒叙遍历获取数字
            for (int i = s.length() - 1; i > -1; i--) {
                // 因为字符串其实就相当于一个字符数组，字符转int为对应的Ascii码，我们
                // 我们要获取对应的Int值只需要减去0的Ascii码即可。
                res = res * 10 + s.charAt(i) - '0';
            }
            res *= -1;
            return (int) res == res ? (int) res : 0;
        }
    }
}
