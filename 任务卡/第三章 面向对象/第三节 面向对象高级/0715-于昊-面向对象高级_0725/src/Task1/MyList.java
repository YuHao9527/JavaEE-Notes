package Task1;

import java.util.Arrays;

/**
 * @ClassName MyList
 * @Description MyList
 * @Author 0715-YuHao
 * @Date 2020/7/24 22:23
 */
public class MyList {
    private Object[] element;
    //当前存储数据量 size
    private int size;

    // 默认创建对像必须定义数组长度
    public MyList(int size) {
        this.size = size;
        element = new Object[size];
    }

    /**
     * @Author 0715-YuHao
     * @Description 增加方法 add ： 可以根据索引数组属性中依次存储 Object，数组内容
     * 存满时，动态扩容
     * @Date 2020/7/25 13:31
     * @Param [o, size]
     * @return void
     */
    public void add(Object o, int index) {
        // 如果下标大于数组长度，动态扩容
        if (index > size - 1) {
            add(o);
        }else {
            element[index] = o;
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 增加方法 add ： 可以向数组属性中依次存储 Object，数组内容
     * 存满时，动态扩容
     * @Date 2020/7/25 13:17
     * @Param [o] [需增加的对象】
     * @return void
     */
    public void add(Object o) {
        // 创建新的大数组
        Object[] newElement = new Object[size + 1];
        // 将原数组内容复制到新的大数组
        for (int i = 0;i < element.length;i++) {
            newElement[i] = element[i];
        }
        // 添加Object
        newElement[size] = o;
        // 替换掉原数组
        this.element = newElement;
        // 数组长度加一
        this.size++;
    }

    /**
     * @Author 0715-YuHao
     * @Description . 删除方法 remove ：可以根据数据，从数组属性中删除
     * Object 数据，删除后，数组后续元素需前移。
     * @Date 2020/7/25 13:18
     * @Param [o] [需删除的数据]
     * @return void
     */
    public void remove(Object o) {
        boolean flag = true;
        // 创建新的小数组
        Object[] newElement = new Object[size - 1];
        // 将原数组的内容复制到小数组
        for (int i = 0;i < element.length;i++) {
            // 扫描需要删除的数据
            if (element[i].equals(o)) {
                // 找到需要删除的数据
                flag = false;
                // 原数组后续元素前移
                for (int j = i; j < element.length - 1; j++) {
                    newElement[i] = element[i + 1];
                }
                break;
            }
            newElement[i] = element[i];
        }
        if (flag) {
            // 未找到需要删除的数据
            System.out.println("没有找到你要删除的Object数据");
        }else {
            // 替换原数组
            this.element = newElement;
            // 数组长度减一
            this.size--;
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 重载：删除方法 remove ：可以根据下标，从数组属性中删除
     *      * Object 数据，删除后，数组后续元素需前移。
     * @Date 2020/7/25 13:19
     * @Param [index] [需删除数据的下标]
     * @return void
     */
    public void remove(int index) {
        // 判断下标是否超出数组范围
        if (index > size - 1 && index < 0) {
            System.out.println("错误：超出数组范围");
        }else {
            Object[] newElement = new Object[size - 1];
            for (int i = 0; i < element.length; i++) {
                if (i == index) {
                    for (int j = i; j < element.length - 1; j++) {
                        newElement[i] = element[i + 1];
                    }
                    break;
                }
                newElement[i] = element[i];
            }
            this.element = newElement;
            this.size--;
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 查询方法 get ：方法传入下标，返回数组中指定下标的数据。
     * @Date 2020/7/25 13:20
     * @Param [index]
     * @return java.lang.Object
     */
    public Object get(int index) {
        return this.element[index];
    }

    /**
     * @Author 0715-YuHao
     * @Description 获取当前存储的有效数据长度
     * @Date 2020/7/25 13:20
     * @Param []
     * @return int
     */
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "element=" + Arrays.toString(element) +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MyList myList = (MyList) o;
        if (size != myList.size)
            return false;
        return Arrays.equals(element, myList.element);
    }

}
