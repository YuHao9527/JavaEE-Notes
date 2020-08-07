package task.task4.bookManage.main;

import task.task4.bookManage.view.Views;
import task.task4.bookManage.dao.BookDao;

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
        m: while (true) {
            int menu = view.menu();
            switch (menu) {
                case 0:
                    break m;
                case 1:
                    new ManagerClient(view, dao).start();
                    break;
            }
        }
    }
}
