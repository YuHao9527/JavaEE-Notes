package task1.ExpressManageSystem.main;

import task1.ExpressManageSystem.bean.Express;
import task1.ExpressManageSystem.dao.ExpressDao;
import task1.ExpressManageSystem.view.Views;

import java.io.IOException;

/**
 * @ClassName UserClient
 * @Description 用户界面程序
 * @Author 0715-YuHao
 * @Date 2020/7/28 10:46
 */
public class UserClient {
    private Views view = new Views();
    private ExpressDao dao = new ExpressDao();

    public UserClient() throws IOException {
    }

    public UserClient(Views view, ExpressDao dao) throws IOException {
        this.view = view;
        this.dao = dao;
    }

    public void start() throws IOException {
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
