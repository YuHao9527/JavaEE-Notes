package task.task3.dao;

import task.task3.bean.Express;
import task.task3.interFace.Dao;

import java.util.HashMap;
import java.util.Random;

/**
 * @ClassName ExpressDao
 * @Description 快递数据
 * @Author 0715-YuHao
 * @Date 2020/7/31 12:01
 */
public class ExpressDao implements Dao {
    //快递数
    private static int size = data.size();
    // 随机数
    private Random random = new Random();


    @Override
    public Express add(Express e) {
        if (size == 100) {
            return null;
        }
        //1. 随机生成1个0-99的数字
        int num = 0;
        do {
            num = random.nextInt(100);
        } while (data.containsKey(num));
        //2. 生成取件码，并录入
        String code = randomCode();
        e.setCode(code);
        data.put(num, e);
        return e;
    }

    /**
     * @return java.lang.String
     * @Author 0715-YuHao
     * @Description 随机生成6位取件码
     * @Date 2020/7/28 12:15
     * @Param []
     */
    private String randomCode() {
        // 获取当前时间戳，并转为字符串
        String code = String.valueOf(System.currentTimeMillis());
        // 截取字符串6位号码，最低到秒，以免重复
        return code.substring(4, 10);
    }

    @Override
    public Express findByNumber(String number) {
        Express e = new Express();
        e.setNumber(number);
        for (int key : data.keySet()) {
            if (data.get(key).equals(e)) {
                return data.get(key);
            }
        }
        return null;
    }

    @Override
    public Express findByCode(String code) {
        for (int key : data.keySet()) {
            if (data.get(key).getCode().equals(code)) {
                return data.get(key);
            }
        }
        return null;
    }

    @Override
    public void delete(Express e) {
        for (int key: data.keySet()) {
            if (data.get(key).equals(e)) {
                data.remove(key);
            }
        }
    }

    @Override
    public HashMap<Integer, Express> findAll() {
        return data;
    }
}
