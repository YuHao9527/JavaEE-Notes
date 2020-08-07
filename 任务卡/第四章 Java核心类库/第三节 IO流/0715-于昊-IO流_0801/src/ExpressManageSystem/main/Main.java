package task1.ExpressManageSystem.main;

import task1.ExpressManageSystem.dao.ExpressDao;
import task1.ExpressManageSystem.view.Views;

import java.io.IOException;

/**
 * @ClassName Main
 * @Description 主程序
 * @Author 0715-YuHao
 * @Date 2020/7/28 10:46
 */
public class Main {
    //初始化视图对象
    private static Views view = new Views();
    //初始化dao对象
    private static ExpressDao dao;

    static {
        try {
            dao = new ExpressDao();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //1. 欢迎
        view.welcome();
        m: while (true) {
            //2. 弹出身份选择菜单
            int menu = view.menu();
            switch (menu) {
                case 0:
                    break m;
                case 1:
                    new CourierClient(view, dao).start();
                    break;
                case 2:
                    new UserClient(view, dao).start();
                    break;
            }
        }
        view.bye();
    }

}
