package dao;

import bean.Express;
import interFace.Dao;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

import java.util.Random;

/**
 * @ClassName ExpressDao
 * @Description 快递数据
 * @Author 0715-YuHao
 * @Date 2020/7/31 12:01
 */
public class ExpressDao implements Dao {
    /**
     * @Author 0715-YuHao
     * @Description 快递集合
     * @Date 2020/8/5 10:38
     */
    private static HashMap<Integer, Express> data;
    /**
     * @Author 0715-YuHao
     * @Description 搭建客户端
     * @Date 2020/8/5 10:38
     */
    private Socket socket;
    //快递数
    private int size;
    // 随机数
    private Random random = new Random();

    public ExpressDao() {
    }

    @Override
    public boolean add(Express e) {
        size = data.size();
        if (size == 100) {
            return false;
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
        return true;
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

    @Override
    public boolean getData() {
        try {
            socket = new Socket("127.0.0.1", 8888);
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            data = (HashMap<Integer, Express>) ois.readObject();
        } catch (IOException e) {
            return false;
        } catch (ClassNotFoundException ignored) {

        }
        return true;
    }


    @Override
    public boolean putData() {
        try {
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(data);
        }catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * @Author 0715-YuHao
     * @Description 关闭套接字
     * @Date 2020/8/5 10:53
     * @Param []
     * @return void
     */
    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
