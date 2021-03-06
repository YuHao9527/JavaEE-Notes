package main;

import dao.ExpressDao;
import view.Views;

import java.io.IOException;

/**
 * @ClassName Main
 * @Description 主程序
 * @Author 0715-YuHao
 * @Date 2020/7/28 10:46
 */
public class Main {
    /**
     * @Author 0715-YuHao
     * @Description 初始化视图对象
     * @Date 2020/8/4 13:51
     */
    private static final Views view = new Views();
    /**
     * @Author 0715-YuHao
     * @Description 初始化dao对象
     * @Date 2020/8/4 13:52
     */
    private static final ExpressDao dao = new ExpressDao();

    public static void main(String[] args) throws IOException {
        //1. 欢迎
        view.welcome();
        //从服务器下在数据
        System.out.print("与服务器建立连接中");
        while (true) {
            if (dao.getData()) {
                break;
            }else {
                System.out.print(".");
            }
        }
        System.out.println();
        m: while (true) {
            //2. 弹出身份选择菜单
            int menu = view.menu();
            switch (menu) {
                case 0:
                    //判断数据上传是否成功
                    if (!dao.putData()) {
                        view.storeDefeat();
                    }
                    //关闭套接字
                    dao.close();
                    break m;
                case 1:
                    new CourierClient(view, dao).start();
                    break;
                case 2:
                    new UserClient(view, dao).start();
                    break;
                default:
            }
        }
        view.bye();
    }

}
