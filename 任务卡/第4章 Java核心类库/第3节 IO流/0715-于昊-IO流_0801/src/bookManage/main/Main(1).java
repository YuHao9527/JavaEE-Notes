package task2.bookManage.main;

import task2.bookManage.dao.BookDao;
import task2.bookManage.view.Views;

import java.io.IOException;

/**
 * @ClassName Main
 * @Description 主程序
 * @Author 0715-YuHao
 * @Date 2020/7/31 16:01
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //初始化
        Views view = new Views();
        BookDao dao = new BookDao();
        view.welcome();
        m: while (true) {
            int menu = view.menu();
            switch (menu) {
                case 0:
                    //退出时将数据存储到本地
                    dao.storeBook();
                    break m;
                case 1:
                    new ManagerClient(view, dao).start();
                    break;
            }
        }
    }
}
