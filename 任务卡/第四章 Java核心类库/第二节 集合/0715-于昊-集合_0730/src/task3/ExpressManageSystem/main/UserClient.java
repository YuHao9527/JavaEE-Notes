package task.task3.main;

import task.task3.bean.Express;
import task.task3.dao.ExpressDao;
import task.task3.view.Views;

/**
 * @ClassName UserClient
 * @Description 用户界面程序
 * @Author 0715-YuHao
 * @Date 2020/7/28 10:46
 */
public class UserClient {
    private Views view = new Views();
    private ExpressDao dao = new ExpressDao();

    public UserClient() {
    }

    public UserClient(Views view, ExpressDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void start() {
        //1. 取件码获取
        String  code = view.uMenu();
        //2. 根据取件码 取出快递
        Express e = dao.findByCode(code);
        if (e == null) {
            view.printNull();
        }else {
            view.success();
            view.printExpress(e);
            dao.delete(e);
        }
    }
}
