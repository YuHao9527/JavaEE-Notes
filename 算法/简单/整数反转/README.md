## 整数反转

​	给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

### 示例1:

```
输入: 123
输出：321
```

### 示例2：

```
输入：-123
输出：-321
```

### 示例3：

```
输入：120
输出：21
```

### 注意：

​	假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为$[2^{31}, 2^{31} -1]$请根据这个假设，如果反转后整数溢出那么就返回 0。

##### 方法一、求余获取末尾数字

```java
class Solution {
    public int reverse(int x) {
        // 反转后可能溢出，将结果定义成long类型
        long res = 0;
        // 不管整数还是符数求余结果都趋向于0，故将判断条件设为x != 0即可
        while(x != 0) {
            // 取模获取x的最后一位数字，并传入结果
            res = res * 10 + x % 10;
		   // 整除运算，去除最后一位数字
            x /= 10;
        }
        // 对结果int类型转换，如若溢出则输出0
        return (int) res == res ? (int) res : 0;
    }
}
```

##### 方法二、反转字符串

```java
class Solution {
    public int reverse(int x) {
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
```

##### 方法三、栈

暂时还没学。。

```java

```

