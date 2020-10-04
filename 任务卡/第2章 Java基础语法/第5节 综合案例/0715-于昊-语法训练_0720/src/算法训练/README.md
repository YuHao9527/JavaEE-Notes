## 两数之和 II - 输入有序数组

​	给定一个已按照**升序排列**的有序数组，找到两个数使得它们相加之和等于目标数。函数应该返回这两个下标值index1和index2，其中index1必须小于index2。

##### 说明:

- 返回的下标值（index1和index2）不是从零开始的。
- 你可以假设每个输入值对应唯一的答案，而且你不可以重复使用相同的元素。

##### 示例：

```
输入：numbers = [2, 7, 11, 15], target = 9
输出：[1, 2]
解释：2 与 7 之和等于目标数 9。因此 index = 1, index = 2 。
```

### 思路 1：暴力枚举法

- 算法

  1. 选定一个列表中的数作为index1
  2. 从index1 向右遍历到列表尾部
  3. 对于每个遍历的数，令其为index2，判断index1 与 index2的数字之和是否等于所给的target
  4. 如果相等，返回当前的index1 和 index2 作为结果
  5. 如果遍历结束还未找到结果，则将当前index1 的下一个数选为新的 index1，重新开始循环

- 代码：

  ```java
  class Solution {
      public int[] twoSum(int[] numbers, int target) {
          for (int i = 0; i < numbers.length; i++) {
              for (int j = i + 1; j < numbers.length; j++) {
                  if (numbers[i] + numbers[j] == target) {
                      return new int[] {i + 1, j + 1}
                  }
              }
          }
          return new int[] {-1, -1};
      }
  }
  ```

  ​

- 复杂度分析

  - 空间复杂度：只需要使用常数个局部变量，空间复杂度为$O(1)$
  - 时间复杂度：需要循环次数：n + (n - 1) + ... + 1 = n(n -1)/2;时间复杂度为$O(n^2)$

- 改进

  - 空间复杂度：已经是$O(1)$，改进空间不大

  - 时间复杂度：有一个条件没有使用 - **升序数组**

    如果numbers[i] + number[j] > target，那么 numbers[i] + number[j + 1] > target

    如果numbers[i] + number[j] < target，那么如果numbers[i - 1] + number[j] < target

  那么我们可以引入新的思路：双指针法

### 思路 2：双指针

- 算法

  1. 初始状态下，令left指向数组第一个元素，right指向最后一个元素
  2. 进入循环，控制循环退出条件为 left >= right
  3. 在每一次循环中，如果left与right的数字之和等于所给target，则返回当前的left、right
  4. 若 left 与 right 的数字之和小于所给的 target，left = left + 1，继续循环
  5. 若 left 与 right 的数字之和大于所给 target，right = right - 1，继续循环

- 代码：

  ```java
  class Solution {
      public int[] twoSum(int[] numbers, int target) {
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
  ```

- 复杂度分析：

  - 空间复杂度：只需要使用常数个局部变量，空间复杂度为$O(1)$
  - 时间复杂度：使用双指针只对数组进行了一次遍历，故时间复杂度为$O(n)$。可以看出，显著优于暴力法。

- 双指针本质

  - 并非是一种“算法”，更像是一种编程技巧
  - 利用问题本身所给的序列特性 （升序 or 降序）
  - 使用两个下标对序列进行扫描，可以同向，亦可反向

### 思路3. 二分查找

- 算法

  1. 固定一个数，然后寻找第二个数，第二个数等于目标值减去第一个数的差。
  2. 利用数组的有序性质，可以通过二分查找的方法寻找第二个数。
  3. 为了避免重复寻找，在寻找第二个数时，只在第一个数的右侧寻找。

- 代码

  ```java
  class Solution {
      public int[] twoSum(int[] numbers, int target) {
          // 为避免重复查找，从右边第一个数开始遍历到数组尾部
          for (int i = 0; i < numbers.length; ++i) {
              // 采用二分查找寻找第二个数
              int low = i + 1, high = numbers.length - 1;
              // 循环条件满足 low <= high
              while (low <= high) {
                  // 获取第二个数，为中间值
                  int mid = (high + low) / 2;
                  if (numbers[mid] == target - numbers[i]) {
                      return new int[] {i + 1, mid + 1};
                  }else if (numbers[mid] > target - numbers[i]) {
                      high = mid - 1;
                  }else {
                      low = mid + 1;
                  }
              }
          }
          return new int[] {-1, -1};
      }
  }
  ```

- 复杂度分析

  - 空间复杂度：只需要使用常数个局部变量，空间复杂度为$O(1)$
  - 时间复杂度：$O(n log n)$，其中 n 是数组的长度。需要遍历数组一次确定第一个数，时间复杂度是$O(n)$，寻找第二个数使用二分查找，时间复杂度是$O(logn)$，因此总时间复杂度是 $O(nlog n)$

