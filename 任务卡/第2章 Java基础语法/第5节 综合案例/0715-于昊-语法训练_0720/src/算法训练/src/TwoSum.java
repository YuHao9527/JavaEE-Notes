package easy.两数之和2;

/**
 * @ClassName TwoSum
 * @Description 两数之和 II - 输入有序数组
 * @Author 0715-YuHao
 * @Date 2020/7/20 23:24
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明：
 *      1. 返回的下标值（index1 和 index2）不是从零开始的。
 *      2. 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(numbers, target);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }

    // 双指针
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[] {left + 1, right + 1};
            }else if (numbers[left] + numbers[right] < target) {
                left++;
            }else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }
}
