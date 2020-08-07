package task1.ExpressManageSystem.interFace;

import task1.ExpressManageSystem.bean.Express;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

/**
 * @Author 0715-YuHao
 * @Description 数据接口
 * @Date 2020/7/28 11:11
 */
public interface Dao {
    //使用HashMap集合存储快递
    HashMap<Integer, Express> hashData = new HashMap<>();
    //存储数据到本地，使用Properties存储
    Properties properties = new Properties();
    // 存储快递
    Express add(Express e) throws IOException;
    // 通过Number查找快递
    Express findByNumber(String number) throws IOException;
    // 通过取件码查找快递
    Express findByCode(String code) throws IOException;
    //修改快递
    void update(Express e) throws IOException;
    // 删除快递
    void delete(Express e) throws IOException;
    // 输出所有快递
    Properties findAll();
}
