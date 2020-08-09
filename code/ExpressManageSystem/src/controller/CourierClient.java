package controller;

import bean.Express;
import dao.ExpressDao;
import view.Views;
import java.util.HashMap;

/**
 * @ClassName CourierClient
 * @Description 快递员界面
 * @Author 0715-YuHao
 * @Date 2020/7/28 10:49
 */
public class CourierClient {
    private Views view;
    private ExpressDao dao;

    public CourierClient(){
    }

    public CourierClient(Views view, ExpressDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void start() {
        int menu = view.cMenu();
        switch (menu) {
            case 0:
                return;
            case 1:{
                //1. 提示输入快递信息
                Express e = view.insert();
                //2，此快递是否已经存储过
                Express e2 = dao.findByNumber(e.getNumber());
                //3. 存储快递
                if (e2 == null) {
                    //未存储过
                    if (dao.add(e)) {
                        view.printExpress(e);
                    }else {
                        view.outOfExpress();
                    }
                }else {
                    //单号在快递中已存在
                    view.expressExit();
                }
            }
            break;
            case 2:{ //快递修改
                //1. 提示输入快递信息
                String number = view.findByNumber();
                //2. 查找数据
                Express e = dao.findByNumber(number);
                //3. 打印快递信息
                if (e == null) {
                    view.printNull();
                }else {
                    view.printExpress(e);
                    //4. 提示修改
                    view.update(e);
                    view.printExpress(e);
                }
            }
            break;
            case 3:{
                //删除快递
                //1. 输入快递单号
                String number = view.findByNumber();
                //2. 查找快递对象
                Express e = dao.findByNumber(number);
                if (e == null) {
                    view.printNull();
                }else {
                    view.printExpress(e);
                    int type = view.delete();
                    if (type == 1) {
                        dao.delete(e);
                        view.success();
                    }
                }
            }
            break;
            case 4:{
                //查看所有
                HashMap<Integer, Express> data = dao.findAll();
                view.printAll(data);
            }
            break;
        }
    }
}
