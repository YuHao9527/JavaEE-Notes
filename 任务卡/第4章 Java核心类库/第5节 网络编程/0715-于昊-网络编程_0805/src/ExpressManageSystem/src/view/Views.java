package view;

import bean.Express;


import java.util.*;

/**
 * @ClassName Views
 * @Description 视图展示
 * @Author 0715-YuHao
 * @Date 2020/7/28 10:49
 */
public class Views {
    private Scanner scanner = new Scanner(System.in);

    /**
     * @return void
     * @Author 0715-YuHao
     * @Description 欢迎
     * @Date 2020/7/28 11:26
     * @Param []
     */
    public void welcome() {
        System.out.println("欢迎使用xxx快递管理系统");
    }

    /**
     * @return void
     * @Author 0715-YuHao
     * @Description 再见
     * @Date 2020/7/28 11:27
     * @Param []
     */
    public void bye() {
        System.out.println("欢迎下次使用");
    }


    /**
     * @return int
     * @Author 0715-YuHao
     * @Description 选择身份菜单
     * @Date 2020/7/28 11:27
     * @Param []
     */
    public int menu() {
        System.out.println("请根据提示，输入功能序号：");
        System.out.println("1. 快递员");
        System.out.println("2. 普通用户");
        System.out.println("0. 退出");
        String text = scanner.nextLine();
        return insertNum(text, 2, 0);
    }

    /**
     * @return num
     * @Author 0715-YuHao
     * @Description 判断用户输入的是否合法
     * @Date 2020/7/28 11:31
     * @Param [text, i] [用户的输入, 最大索引, 菜单选项]
     */
    private int insertNum(String text, int i, int option) {
        int num = -1;
        try {
            num = Integer.parseInt(text);
        } catch (NumberFormatException ignored) {

        }
        if (num < 0 || num > i) {
            System.out.println("输入有误，请重新输入");
            switch (option) {
                case 0:
                    return menu();
                case 1:
                    return cMenu();
                case 2:
                    return delete();
            }
        }
        return num;
    }

    /**
     * @return int
     * @Author 0715-YuHao
     * @Description 快递员菜单
     * @Date 2020/7/28 11:33
     * @Param []
     */
    public int cMenu() {
        System.out.println("请根据提示，输入功能序号：");
        System.out.println("1. 快递录入");
        System.out.println("2. 快递修改");
        System.out.println("3. 快递删除");
        System.out.println("4. 查看所有快递");
        System.out.println("0. 退出");
        String text = scanner.nextLine();
        return insertNum(text, 4, 1);
    }

    /**
     * @return Express 包含了快递单号和快递公司的快递对象
     * @Author 0715-YuHao
     * @Description 快递员录入快递
     * @Date 2020/7/28 11:33
     * @Param []
     */
    public Express insert() {
        System.out.println("请跟据提示，输入快递信息：");
        System.out.println("请输入快递单号：");
        String number = scanner.nextLine();
        System.out.println("请输入快递公司：");
        String company = scanner.nextLine();
        Express e = new Express();
        e.setCompany(company);
        e.setNumber(number);
        return e;
    }

    /**
     * @return java.lang.String
     * @Author 0715-YuHao
     * @Description 提示用户输入快递单号
     * @Date 2020/7/28 11:35
     * @Param []
     */
    public String findByNumber() {
        System.out.println("请根据提示输入快递信息：");
        System.out.println("请输入要操作的快递单号：");
        return scanner.nextLine();
    }

    /**
     * @return void
     * @Author 0715-YuHao
     * @Description 输出显示快递信息
     * @Date 2020/7/28 11:36
     * @Param [e] 快递对象
     */
    public void printExpress(Express e) {
        System.out.println("快递信息如下：");
        System.out.println("快递公司：" + e.getCompany() + "，快递单号：" + e.getNumber() + "，取件码：" + e.getCode());
    }

    /**
     * @return void
     * @Author 0715-YuHao
     * @Description 快递空值打印
     * @Date 2020/7/28 11:36
     * @Param []
     */
    public void printNull() {
        System.out.println("快递不存在，请检查您的输入");
    }

    /**
     * @Author 0715-YuHao
     * @Description 修改快递信息
     * @Date 2020/7/28 11:37
     * @Param [e] 快递对象
     */
    public void update(Express e) {
        System.out.println("请输入新的快递单号：");
        String number = scanner.nextLine();
        System.out.println("请输入新的快递公司：");
        String company = scanner.nextLine();
        e.setNumber(number);
        e.setCompany(company);
    }

    /**
     * @return int 1.确认删除 2. 取消删除
     * @Author 0715-YuHao
     * @Description 询问是否确认删除
     * @Date 2020/7/28 11:38
     * @Param []
     */
    public int delete() {
        System.out.println("是否确认删除?");
        System.out.println("1. 确认删除");
        System.out.println("2. 取消操作");
        System.out.println("0. 退出");
        String text = scanner.nextLine();
        return insertNum(text, 2, 2);
    }

    /**
     * @return void
     * @Author 0715-YuHao
     * @Description 将给定的数组的快递信息，遍历显示
     * @Date 2020/7/28 11:40
     * @Param [data]
     */
    public void printAll(HashMap<Integer, Express> data) {
        if (data.size() == 0) {
            System.out.println("暂无快递信息");
        } else {
            for (int key : data.keySet()) {
                System.out.print("第" + (key / 10 + 1) + "排" + (key % 10 + 1) + "列快递,");
                printExpress(data.get(key));
            }
        }
    }

    /**
     * @return int
     * @Author 0715-YuHao
     * @Description 用户的菜单
     * @Date 2020/7/28 11:48
     * @Param []
     */
    public String uMenu() {
        System.out.println("请根据提示，进行取件：");
        System.out.println("请输入您的取件码：");
        String code = scanner.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(code);
        } catch (NumberFormatException ignored) {

        }
        if (num < 100000 || num > 999999) {
            System.out.println("输入有误，请重新输入");
            return uMenu();
        }
        return code;
    }

    // 重复提示
    public void expressExit() {
        System.out.println("此单号在快递柜中已存在，请勿重复存储");
    }

    // 操作成功提示
    public void success() {
        System.out.println("操作成功");
    }

    // 操作失败提示
    public void storeDefeat() {
        System.out.println("数据上传失败，与服务器断开连接");
    }

    // 快递箱溢出提示
    public void outOfExpress() {
        System.out.println("操作失败，快递箱已满，请及时取出，才能继续存入！");
    }
}
