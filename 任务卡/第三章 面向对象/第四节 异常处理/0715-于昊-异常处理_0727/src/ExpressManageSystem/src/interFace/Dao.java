package interFace;

import bean.Express;

/**
 * @Author 0715-YuHao
 * @Description 数据接口
 * @Date 2020/7/28 11:11
 */
public interface Dao {
    Express[][] data = new Express[10][10];
    // 存储快递
    boolean add(Express e);
    // 通过Number查找快递
    Express findByNumber(String number);
    // 通过取件码查找快递
    Express findByCode(String code);
    // 删除快递
    void delete(Express e);
    // 输出所有快递
    Express[][] findAll();
}
