package interFace;

import bean.Express;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Author 0715-YuHao
 * @Description 数据接口
 * @Date 2020/7/28 11:11
 */
public interface Dao {
    // 存储快递
    boolean add(Express e) throws IOException;
    // 通过Number查找快递
    Express findByNumber(String number) throws IOException;
    // 通过取件码查找快递
    Express findByCode(String code) throws IOException;
    // 删除快递
    void delete(Express e) throws IOException;
    // 输出所有快递
    HashMap<Integer, Express> findAll();
    //从文件中读取数据
    boolean loadData();
    // 上传数据到服务器
    boolean putData();
}
