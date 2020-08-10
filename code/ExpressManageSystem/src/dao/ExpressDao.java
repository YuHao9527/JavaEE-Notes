package dao;

import bean.Express;
import interFace.Dao;
import java.io.*;
import java.util.*;

/**
 * @ClassName ExpressDao
 * @Description 快递数据相关操作
 * @Author 0715-YuHao
 * @Date 2020/7/31 12:01
 */
public class ExpressDao implements Dao {
    /**
     * @Author 0715-YuHao
     * @Description 文件存储位置
     * @Date 2020/8/9 16:35
     */
    private static final File file = new File("src\\server\\express.txt");
    /**
     * @Author 0715-YuHao
     * @Description 快递集合
     * @Date 2020/8/5 10:38
     */
    private static HashMap<Integer, Express> data = new HashMap<>();
    /**
     * @Author 0715-YuHao
     * @Description 产生随机数
     * @Date 2020/8/9 16:35
     */
    private Random random = new Random();

    public ExpressDao() {
    }

    @Override
    public boolean add(Express e) {
        if (100 == data.size()) {
            return false;
        }
        //1. 随机生成1个0-99的数字
        int num = 0;
        do {
            num = random.nextInt(100);
        } while (data.containsKey(num));
        data.put(num, e);
        return true;
    }

    @Override
    public Express findByNumber(String number) {
        Set<Map.Entry<Integer, Express>> set = data.entrySet();
        Iterator<Map.Entry<Integer, Express>> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().getNumber().equals(number)) {
                return iterator.next().getValue();
            }
        }
        return null;
    }

    @Override
    public Express findByCode(String code) {
        Set<Map.Entry<Integer, Express>> set = data.entrySet();
        Iterator<Map.Entry<Integer, Express>> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().getCode().equals(code)) {
                return iterator.next().getValue();
            }
        }
        return null;
    }

    @Override
    public boolean delete(Express e) {
        Set<Map.Entry<Integer, Express>> set = data.entrySet();
        Iterator<Map.Entry<Integer, Express>> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().equals(e)) {
                data.remove(iterator.next().getKey());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updata(Express e, Express e2) {
        Set<Map.Entry<Integer, Express>> set = data.entrySet();
        Iterator<Map.Entry<Integer, Express>> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().equals(e)) {
                data.put(iterator.next().getKey(), e2);
                return true;
            }
        }
        return false;
    }

    @Override
    public HashMap<Integer, Express> findAll() {
        return data;
    }

    /**
     * @Author 0715-YuHao
     * @Description 从文件中读取数据
     * @Date 16:05 2020/8/9
     * @Param []
     * @return boolean
     **/
    @Override
    public boolean loadData() {
        /*if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }*/
        if (file.length() > 0) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                Object obj = ois.readObject();
                if (obj instanceof Map) {
                    data = (HashMap<Integer, Express>) obj;
                }
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * @Author 0715-YuHao
     * @Description 将数据写入文件
     * @Date 2020/8/9 16:50
     * @Param []
     * @return boolean
     */
    @Override
    public boolean storeData() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(data);
        }catch (IOException e) {
            return false;
        }
        return true;
    }
}
