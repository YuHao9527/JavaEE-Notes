package dao;

import bean.Express;
import interFace.Dao;

import java.util.Random;

/**
 * @ClassName ExpressDao
 * @Description 快递
 * @Author 0715-YuHao
 * @Date 2020/7/28 10:50
 */
public class ExpressDao implements Dao {
    //快递数
    private static int size = 0;
    // 随机数
    private Random random = new Random();


    /**
     * @Author 0715-YuHao
     * @Description 存储快递
     * @Date 2020/7/28 12:14
     * @Param [e]
     * @return boolean
     */
    @Override
    public boolean add(Express e) {
        if (size == 100) {
            return false;
        }
        //1. 随机生成2个0-9的下标
        int x = -1, y = -1;
        do {
            x = random.nextInt(10);
            y = random.nextInt(10);
        } while (data[x][y] != null);
        //2. 生成取件码，并录入
        String code = randomCode();
        e.setCode(code);
        data[x][y] = e;
        // 快递数加1
        size++;
        return true;
    }

    /**
     * @Author 0715-YuHao
     * @Description 随机生成6位取件码
     * @Date 2020/7/28 12:15
     * @Param []
     * @return java.lang.String
     */
    private String randomCode() {
        // 获取当前时间戳，并转为字符串
        String code = String.valueOf(System.currentTimeMillis());
        // 截取字符串6位号码，最低到秒，以免重复
        return code.substring(4, 10);
    }

    /**
     * @Author 0715-YuHao
     * @Description 快递员查找快递
     * @Date 2020/7/28 12:15
     * @Param [number] 要查询的快递单号
     * @return bean.Express 查询到结果，查询失败时返回null
     */
    @Override
    public Express findByNumber(String number) {
        Express e = new Express();
        e.setNumber(number);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (e.equals(data[i][j])) {
                    return data[i][j];
                }
            }
        }
        return null;
    }

    /**
     * @Author 0715-YuHao
     * @Description 用户取件查找快递
     * @Date 2020/7/28 12:19
     * @Param [code] 要查询的取件码
     * @return bean.Express 查询到结果，查询失败时返回null
     */
    @Override
    public Express findByCode(String code) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (data[i][j] != null)
                    if (data[i][j].getCode().equals(code)){
                        return data[i][j];
                    }
            }
        }
        return null;
    }

    /**
     * @Author 0715-YuHao
     * @Description 删除快递
     * @Date 2020/7/28 12:21
     * @Param [e] 需要删除的快递
     * @return void
     */
    @Override
    public void delete(Express e) {
        p: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (e.equals(data[i][j])){
                    data[i][j] = null;
                    // 快递数减1
                    size--;
                    break p;
                }
            }
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 输出所有快递
     * @Date 2020/7/28 12:22
     * @Param []
     * @return bean.Express[][]
     */
    @Override
    public Express[][] findAll() {
        return data;
    }

    /**
     * @Author 0715-YuHao
     * @Description 获取快递数
     * @Date 2020/7/28 12:23
     * @Param []
     * @return int
     */
    public static int size() {
        return size;
    }
}
