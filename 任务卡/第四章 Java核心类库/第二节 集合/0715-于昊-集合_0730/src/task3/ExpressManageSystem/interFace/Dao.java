package task.task3.interFace;

import task.task3.bean.Express;

import java.util.HashMap;

/**
 * @Author 0715-YuHao
 * @Description 数据接口
 * @Date 2020/7/28 11:11
 */
public interface Dao {
    //使用HashMap集合存储快递
    HashMap<Integer, Express> data = new HashMap<>();
    // 存储快递
    Express add(Express e);
    // 通过Number查找快递
    Express findByNumber(String number);
    // 通过取件码查找快递
    Express findByCode(String code);
    // 删除快递
    void delete(Express e);
    // 输出所有快递
    HashMap<Integer, Express> findAll();
}
