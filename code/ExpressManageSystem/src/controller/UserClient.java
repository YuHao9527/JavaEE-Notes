package controller;

import bean.Express;
import dao.ExpressDao;
import view.Views;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @ClassName UserClient
 * @Description 用户界面程序
 * @Author 0715-YuHao
 * @Date 2020/7/28 10:46
 */
public class UserClient {
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Views view = new Views();

    public UserClient(ObjectInputStream ois, ObjectOutputStream oos){
        this.ois = ois;
        this.oos = oos;
    }

    public void start() throws IOException, ClassNotFoundException {
        int menu = view.uMenu();
        oos.writeInt(menu);
        oos.flush();
        switch (menu) {
            case 0:
                return;
            case 1:
                //1. 取件码获取
                String code = view.getExpress();
                oos.writeObject(code);
                oos.flush();
                //2. 根据取件码 取出快递
                Express e = (Express) ois.readObject();
                oos.writeObject(e);
                oos.flush();
                if (e == null) {
                    view.printNull();
                }else {
                    boolean delete = ois.readBoolean();
                    if (delete) {
                        view.success();
                        view.printExpress(e);
                    }
                }
                break;
            default:
        }

    }
}
