## 两数之和

​	给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

### 示例：

```
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

#### 方法一. 暴力解法

​	遍历每个元素 xx，并查找是否存在一个值与 target - xtarget−x 相等的目标元素。

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
```

#### 方法二. 哈希表

​	在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
```

### Class HashMap\<K, V>

##### 参数类型

K - 此映射维护的密钥类型

V - 映射值的类型

​	基于哈希表的`Map`接口的实现。 此实现提供了所有可选的映射操作，并允许`null`值和`null`键。 （ `HashMap`类大致相当于`Hashtable` ，除了它是不同步的并且允许空值。）此类不保证地图的顺序; 特别是，它不保证订单会随着时间的推移保持不变。 

##### 构造方法

| 构造器                                           | 描述                                                         |
| ------------------------------------------------ | ------------------------------------------------------------ |
| `HashMap()`                                      | 使用默认初始容量（16）和默认加载因子（0.75）构造一个空 `HashMap` 。 |
| `HashMap(int initialCapacity)`                   | 使用指定的初始容量和默认加载因子（0.75）构造一个空 `HashMap` 。 |
| `HashMap(int initialCapacity, float loadFactor)` | 使用指定的初始容量和加载因子构造一个空 `HashMap` 。          |
| `HashMap(Map<? extends K,? extends V> m)`        | 构造一个新的 `HashMap` ，其映射与指定的 `Map`相同。          |

##### 方法：

| 变量和类型 | 方法                                   | 描述                                                         |
| ---------- | -------------------------------------- | ------------------------------------------------------------ |
| void       | clear()                                | 从此映射中删除所有映射。                                     |
| boolean    | containsKey(Object key)                | 如果此映射包含指定键的映射，则返回 `true` 。                 |
| boolean    | containsValue(Object value)            | 如果此映射将一个或多个键映射到指定值，则返回 `true` 。       |
| V          | get(Object key)                        | 返回指定键映射到的值，如果此映射不包含键的映射，则返回 `null` 。 |
| V          | put(K key, V value)                    | 将指定的值与此映射中的指定键相关联。                         |
| boolean    | isEmpty                                | 如果此映射不包含键 - 值映射，则返回 `true` 。                |
| void       | putAll(Map<? extends K,? extends V> m) | 将指定映射中的所有映射复制到此映射。                         |
| V          | remove(Object key)                     | 从此映射中删除指定键的映射（如果存在）。                     |
| int        | size()                                 | 返回此映射中键 - 值映射的数量。                              |