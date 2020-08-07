import java.util.Scanner;

/**
 * @ClassName GameElectedCaptain
 * @Description 流程控制的逻辑训练任务(数组+逻辑)
 * @Author 0715-YuHao
 * @Date 2020/7/18 09:30
 */
public class ProcessControl {
    /**
     * @Author 0715-YuHao
     * @Description 流程控制的逻辑训练任务(数组+逻辑)
     * @Date 2020/7/18 09:32
     * @Param [args]
     * @return void
     */
    public static void main(String[] args) {
        //1. 查找某个整数
        //searchNum();

        // 2. 找出数组的最值
        //maxMin();

        // 3. 两数之和
        //numsSum();

        // 4、排序并查找
        //sortSearch();

        // 5、移动零
        //moveZero();

    }

    /**
     * @Author 0715-YuHao
     * @Description 1.查找某个整数
     * 定义一个长度为 10 的整型数组 nums ，循环输入 10 个整数。 然后将输入一个整数，
     * 查找此整数，找到输出下标， 没找到给出提示。
     * @Date 2020/7/18 10:46
     * @Param []
     * @return void
     */
    public static void searchNum() {
        // 定义一个长度为10的整数数组
        int[] nums = new int[10];
        boolean option = true;
        // 循环输入10个整数（不清楚是随机还顺序存储）
        // 1. 随机10个整数
        //for (int i = 0; i < 10; i++) {
        //    nums[i] = (int) (Math.random()*10 +1);
        //}
        // 2. 顺序输入10个整数
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        // 提示用户输入数字
        System.out.println("请输入一个1-10以内的任意整数：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        /* // 随机整数的查询方式
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 判断nums中元素是否等于num
            if (nums[i] == num) {
                // 相等则输出下标
                System.out.println("要查找的数据的下标为：" + i);
                // 因为随机数可能会出现重复，这是为了用于查找所有num的标记
                option = false;
            } else if (option && i == 9 && nums[i] != num) {
                // 如果查到最后都未查到，则输出查询不到
                System.out.println("查不到你输入的数字");
            }
        }
         */
        // 顺序数组采用二分查找
        // 最小范围下标
        int minIndex = 0;
        // 最大范围坐标
        int maxIndex = nums.length - 1;
        // 中间数据下标
        int centerIndex = (minIndex + maxIndex) / 2;
        while (true) {
            // 如果中间数据大于查找数据，则最大坐标变为中间坐标-1
            if (nums[centerIndex] > num) {
                maxIndex = centerIndex - 1;
            }else if(nums[centerIndex] < num) { // 如果中间数据小于查找数据，则最小坐标变为中间坐标+1
                minIndex = centerIndex + 1;
            }else {
                break;
            }
            // 如果最小坐标大于最大坐标，表明没有找到数据，标记为-1
            if (minIndex > maxIndex) {
                centerIndex = -1;
                break;
            }
            // 当边界发生变化时，需要更新中间下标
            centerIndex = (minIndex + maxIndex) / 2;
        }
        System.out.println("要查找的数据的下标为：" + centerIndex);
    }

    /**
     * @Author 0715-YuHao
     * @Description 2. 找出数组的最值
     * 定义一个长度为 10 的整型数组 nums ，循环输入 10 个整数。输出数组的最大值、最小
     * 值。
     * @Date 2020/7/18 10:47
     * @Param []
     * @return void
     */
    public static void maxMin() {
        // 定义一个长度为 10 的整型数组 nums
        int[] nums = new int[10];
        // 循环输入 10 个 随机整数（1~10）使用Math.random()函数
        for (int i = 0; i < 10; i++) {
            nums[i] = (int) (Math.random()*10 +1);
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        // 判断最大值
        int max = nums[0], min = nums[0];
        // 循环比较
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        // 判断最小值
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        System.out.println("最大值为：" + max);
        System.out.println("最小值为：" + min);
    }

    /**
     * @Author 0715-YuHao
     * @Description 3. 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两
     * 个整数，并输出他们的数组下标
     * 假设每种输入只会对应一个答案，不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以输出 0，1
     * @Date 2020/7/18 10:50
     * @Param []
     * @return void
     */
    public static void numsSum() {
        // 给定一个整数数组 nums 和一个目标值 target
        int[] nums = {2, 6, 7, 11, 15};
        int target = 13;
        // 输出数组和target
        for(int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("\ntarget：" + target);
        // 循环遍历数组
        for (int i = 0; i < nums.length - 1; i++) {
            // 数组中每个数都与它后面的数相加一遍，保证不会重复相加
            for (int j = i + 1; j < nums.length; j++) {
                // 判断相加之和是否与target相等
                if (target == nums[i] + nums[j]) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 4、排序并查找
     * 对数组{1，3，9，5，6，7，15，4，8}进行排序，然后使用二分查找6并输出排序后的下
     * 标。
     * @Date 2020/7/18 10:51
     * @Param []
     * @return void
     */
    public static void sortSearch() {
        int[] nums = {1, 3, 9, 5, 6, 7, 15, 4, 8};
        // 冒泡法排序
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    nums[j] = nums[j] ^ nums[j + 1];
                    nums[j + 1] = nums[j] ^ nums[j + 1];
                    nums[j] = nums[j] ^ nums[j + 1];
                    flag = false;
                }
            }
            // 如果未发生位置更换，表明排序完成了，无需继续排序
            if (flag) {
                break;
            }
        }
        // 输出排序后的数组
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        // 二分法查找6
        int maxIndex = nums.length, minIndex = 0;
        int middleIndex = (maxIndex + minIndex) / 2;
        while (true){
            if (nums[middleIndex] > 6) {
                maxIndex = middleIndex;
            }else if (nums[middleIndex] < 6) {
                minIndex = middleIndex;
            }else {
                break;
            }
            middleIndex = (maxIndex + minIndex) / 2;
        }
        System.out.println("下标：" + middleIndex);
    }

    /**
     * @Author 0715-YuHao
     * @Description 5、移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相
     * 对顺序。
     * 示例:
     * 输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
     * @Date 2020/7/18 10:48
     * @Param []
     * @return void
     */
    public static void moveZero() {
        int[] nums = {0, 1, 0, 3, 12};
        int len = nums.length;
        // 循环遍历数组
        for (int i = 0; i < len; i++) {
            // 判断元素是否为0
            if (nums[i] == 0) {
                // 如果为0，顺位替换
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                //替换完成后将数组最后一位赋值为0，并将循环次数减一，避免重复操作
                nums[--len] = 0;
            }
        }
        // 输出完成后的数组
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
