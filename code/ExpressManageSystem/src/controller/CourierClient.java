package controller;

import bean.Express;
import view.Views;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * @ClassName CourierClient
 * @Description 快递员界面
 * @Author 0715-YuHao
 * @Date 2020/7/28 10:49
 */
public class CourierClient {
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Views view = new Views();

    public CourierClient(ObjectInputStream ois, ObjectOutputStream oos) {
        this.ois = ois;
        this.oos = oos;
    }

    public void start() throws IOException, ClassNotFoundException {
        while (true) {
            int menu = view.cMenu();
            oos.writeInt(menu);
            oos.flush();
            switch (menu) {
                case 0:
                    return;
                case 1: {
                    //1. 提示输入快递信息
                    Express e = view.insert();
                    oos.writeObject(e);
                    oos.flush();
                    Express e2 = (Express) ois.readObject();
                    //3. 存储快递
                    if (e2 == null) {
                        //未存储过
                        boolean insert = ois.readBoolean();
                        if (insert) {
                            view.success();
                            view.printExpress(e);
                        }else {
                            view.fail();
                        }
                    } else {
                        //单号在快递中已存在
                        view.expressExit();
                    }
                }
                break;
                case 2: {
                    //快递修改
                    //1. 提示输入快递信息
                    String number = view.findByNumber();
                    //2. 查找数据
                    oos.writeObject(number);
                    oos.flush();
                    Express e = (Express) ois.readObject();
                    if (e == null) {
                        view.printNull();
                    } else {
                        view.printExpress(e);
                        //4. 提示修改
                        Express e2 = view.update();
                        oos.writeObject(e2);
                        oos.flush();
                        boolean insert = ois.readBoolean();
                        if (insert) {
                            view.success();
                            view.printExpress(e2);
                        }else {
                            view.fail();
                        }
                    }
                }
                break;
                case 3: {
                    //删除快递
                    //1. 输入快递单号
                    String number = view.findByNumber();
                    //2. 查找快递对象
                    oos.writeObject(number);
                    oos.flush();
                    Express e = (Express) ois.readObject();
                    if (e == null) {
                        view.printNull();
                    } else {
                        view.printExpress(e);
                        int type = view.delete();
                        oos.writeInt(type);
                        oos.flush();
                        switch (type) {
                            case 0:
                                break;
                            case 1:
                                boolean insert = ois.readBoolean();
                                if (insert) {
                                    view.success();
                                }else {
                                    view.fail();
                                }
                                break;
                            default:
                        }
                    }
                }
                break;
                case 4: {
                    //查看所有
                    HashMap<Integer, Express> data = (HashMap<Integer, Express>) ois.readObject();
                    view.printAll(data);
                }
                break;
            }
        }
    }
}
