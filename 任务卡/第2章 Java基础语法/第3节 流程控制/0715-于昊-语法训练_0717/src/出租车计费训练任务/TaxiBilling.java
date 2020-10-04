import java.util.Scanner;

public class TaxiBilling {

    /**
     * @Author 0715-YuHao
     * @Description //出租车计费训练任务
     * @Date 2020/7/16 22:07
     * @Param [args]
     * @return void
     */
    public static void main(String[] args) {
        // 定义单价、车费（由于燃油附加费初始为1）、里程数、上车时间、下车时间、低速行驶时间
        float price = 2.3f, carCost = 1, miles, startTime, endTime ,lowSpeedTime = 0, otherLowSpeedTime = 0;
        // 定义是否预约、预约时间是否超4小时、是否低速行驶、是否往返
        boolean appointment, appointmentTime = false, lowSpeed, comeGo;
        System.out.println("*****欢迎使用出租车计费系统*****");
        Scanner scanner = new Scanner(System.in);
        // 1 . 请用户输入数据
        System.out.println("请输入总里程数：");
        miles = scanner.nextFloat();
        if (miles > 15) {
            // 由题意不清楚往返对车费有什么影响？
            System.out.println("是否往返?(true/false)");
            comeGo = scanner.nextBoolean();
        }
        // 开始上车时间是为了判断是否在高峰时间与夜间(统一输入小时)
        System.out.println("请输入开始乘车时间(24h)：");
        startTime = scanner.nextFloat();
        // 下车时间是为了记录是否超过特殊时间，但由题意无法获知特殊时间段的里程与非特时的里程，暂定为只要上车时在特殊时段就改变单价
        System.out.println("请输入开始下车时间(24h)：");
        endTime = scanner.nextFloat();
        System.out.println("是否预约叫车?(true/false)");
        appointment = scanner.nextBoolean();
        if (appointment) {
            System.out.println("是否超过4小时?(true/false)");
            appointmentTime = scanner.nextBoolean();
        }
        System.out.println("是否有低速行驶?(true/false)");
        lowSpeed = scanner.nextBoolean();
        if (lowSpeed) {
            // 获取早晚高峰低速行驶时间(分钟)
            System.out.println("请输入早晚高峰低速行驶时间(分钟)：");
            lowSpeedTime = scanner.nextFloat();
            // 获取其他时间低速行驶时间(分钟)
            System.out.println("请输入其他时间段低速行驶时间(分钟)：");
            otherLowSpeedTime = scanner.nextFloat();
        }
        // 判断上车时间是否在早高峰时间7:00(含)-9:00(不含)
        if (startTime >= 7 & startTime < 9) {
            // 修改单价
            price = price * 1.2f;
            if (lowSpeed) {
                // 低速行驶每5分钟加价，未到5分钟不算
                carCost += 2 * price * (lowSpeedTime / 5);
                carCost += price * (otherLowSpeedTime / 5);
            }
        }else if (startTime > 17 & startTime < 19) { // 判断上车时间是否在晚高峰时间17:00(含)-19:00(不含)
            price = price * 1.2f;
            if (lowSpeed) {
                carCost += 2 * price * (lowSpeedTime / 5);
                carCost += price * (otherLowSpeedTime / 5);
            }
        }else if (startTime > 23) { // 判断上车时间是否在夜间时间7:00(含)-9:00(不含)
            price = price * 1.2f;
            if (lowSpeed) {
                carCost += price * (otherLowSpeedTime / 5);
            }
        }else { // 其他时间段上车
            if (lowSpeed) {
                carCost += price * (otherLowSpeedTime / 5);
            }
        }
        // 判断里程数是否大于15公里，大于15公里部分基本单价上调50%
        if (miles > 15) {
            carCost += 15 * price + (miles - 15) * 2.3f * 1.5f;
        }else {
            carCost += miles * price;
        }
        // 是否预约
        if (appointment) {
            if (appointmentTime) {
                // 大于4小时每次6元
                carCost += 6;
            }
            // 小于4小时每次5元
            carCost += 5;
        }
        // 车费四舍五入，使用Math库的round()函数
        carCost = Math.round(carCost);
        System.out.println("你的乘车价格为： " + carCost + "元");
    }

}
