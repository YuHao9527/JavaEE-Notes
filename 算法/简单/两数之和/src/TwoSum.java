package easy.两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoSum
 * @Description 两数之和
 * @Author 0715-YuHao
 * @Date 2020/7/22 8:52
 */
public class TwoSum {

    /**
     * @Author 0715-YuHao
     * @Description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为
     * 目标值的那 两个 整数，并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但
     * 是，数组中同一个元素不能使用两遍。
     * @Date 2020/7/22 8:56
     * @Param [args]
     * @return void
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }

    /**
     * @Author 0715-YuHao
     * @Description //方法一：暴力解法
     * 遍历每个元素 x，并查找是否存在一个值与 target - x 相等的目标元素。
     * @Date 2020/7/22 8:56
     * @Param [nums, target]
     * @return int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    /**
     * @Author 0715-YuHao
     * @Description // 方法2：哈希表
     * 在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所
     * 对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。
     * @Date 2020/7/22 9:01
     * @Param [nums, target]
     * @return int[]
     */
    public static int[] twoSum2(int[] nums, int target) {
        // 创建一个HashMap实例化对象
        Map<Integer, Integer> map = new HashMap<>();
        // 循环遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 获取target与当前数字只差
            int complement = target - nums[i];
            // 检查目标元素是否在哈希表中
            if (map.containsKey(complement)) {
                // 如果在，就返回哈希表中目标元素的值和当前数组元素的
                return new int[] {map.get(complement), i};
            }
            // 如果不在，则将当前数组元素的值和索引添加进哈希表
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
