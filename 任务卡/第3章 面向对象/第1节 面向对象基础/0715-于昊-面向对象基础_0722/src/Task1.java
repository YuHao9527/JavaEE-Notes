/**
 * @ClassName Task1
 * @Description 任务1
 * @Author 0715-YuHao
 * @Date 2020/7/22 15:06
 */
public class Task1 {

    public static void main(String[] args) {
        // 创建Car对象
        Car car = new Car("BMW", "red");
        // 调用show方法
        car.show();
    }
}

/**
 * @ClassName Car
 * @Description . 编写 Car 类，属性有品牌（brand）和颜色（color），show 方法打印
 * 所有属性。
 * @Author 0715-YuHao
 * @Date 2020/7/22 15:07
 */
class Car {
    // 无参构造方法
    public Car() {}
    // 全参构造方法
    public Car(String b, String c) {
        brand = b;
        color = c;
    }

    // 属性：品牌、颜色
    String brand, color;

    /**
     * @Author 0715-YuHao
     * @Description 打印所有属性
     * @Date 2020/7/22 15:14
     * @Param []
     * @return void
     */
    public void show() {
        System.out.println("品牌：" + brand);
        System.out.println("颜色：" + color);
    }
}
