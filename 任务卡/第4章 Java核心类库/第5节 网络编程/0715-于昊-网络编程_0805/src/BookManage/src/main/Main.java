package main;

import dao.BookDao;
import view.Views;

/**
 * @ClassName Main
 * @Description 主程序
 * @Author 0715-YuHao
 * @Date 2020/7/31 16:01
 */
public class Main {

    public static void main(String[] args) {
        //初始化
        Views view = new Views();
        BookDao dao = new BookDao();
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
                    if (view.login()) {
                        new ManagerClient(view, dao).start();
                    }else {
                        view.error();
                    }
                break;
                default:
            }
        }
        view.bye();
    }
}
