package task1.ExpressManageSystem.dao;

import task1.ExpressManageSystem.bean.Express;
import task1.ExpressManageSystem.interFace.Dao;

import java.io.*;
import java.util.*;

/**
 * @ClassName ExpressIODao
 * @Description 快递数据
 * @Author 0715-YuHao
 * @Date 2020/8/1 18:27
 * @Version 1.0
 */
public class ExpressDao implements Dao {
    //快递数
    private static int size;
    File file = new File("src\\task1\\ExpressManageSystem\\dao\\data.properties");
    Reader reader = new FileReader(file);
    //生成随机数
    private Random random = new Random();


    public ExpressDao() throws IOException {
        FileWriter data = new FileWriter(file);
        //查看data.properties文件是否存在，不存在就创建
        if (!file.exists()) {
            //创建data.properties文件
            properties.store(data,"Express");
            data.close();
        }else {
            properties.load(reader);
        }
    }

    @Override
    public Express add(Express e) throws IOException {
        properties.load(reader);
        size = properties.size();
        if (size == 100) {
            return null;
        }
        //1. 随机生成1个0-99的数字
        int num;
        do {
            num = random.nextInt(100);
        } while (properties.containsKey(String.valueOf(num)));
        //2. 生成取件码，并录入
        String code = randomCode();
        e.setCode(code);
        //拼接字符串，/用于分割     单号/公司/取件码
        StringBuilder sb = new StringBuilder();
        sb.append(e.getNumber());
        sb.append("/");
        sb.append(e.getCompany());
        sb.append("/");
        sb.append(e.getCode());
        FileWriter fileWriter = new FileWriter(file, true);
        properties.put(String.valueOf(num), sb.toString());
        properties.store(fileWriter, "Express");
        fileWriter.close();
        return e;
    }

    /*
     * @Author 0715-YuHao
     * @Description 随机生成6位取件码
     * @Date 19:00 2020/8/1
     * @Param []
     * @return java.lang.String
     **/
    private String randomCode() {
        // 获取当前时间戳，并转为字符串
        String code = String.valueOf(System.currentTimeMillis());
        // 截取字符串6位号码，最低到秒，以免重复
        return code.substring(4, 10);
    }

    @Override
    public Express findByNumber(String number) throws IOException {
        Express express = new Express();
        properties.load(reader);
        // 获取到Map中所有的key ，key被放到了一个set集合中
        Set<Object> keySet = properties.keySet();
        // 获取到所有的key集合的 迭代器
        Iterator<Object> it = keySet.iterator();
        while (it.hasNext()) {
            // 遍历所有的key 并且获取到各个key
            String key = (String) it.next();
            // 获取Value
            String s = properties.getProperty(key);
            //分割字符串
            String[] strings = s.split("/");
            if (strings[0].equals(number)) {
                express.setNumber(strings[0]);
                express.setCompany(strings[1]);
                express.setCode(strings[2]);
                return express;
            }
        }
        return null;
    }

    @Override
    public Express findByCode(String code) throws IOException {
        Express express = new Express();
        properties.load(reader);
        // 获取到Map中所有的key ，key被放到了一个set集合中
        Set<Object> keySet = properties.keySet();
        // 获取到所有的key集合的 迭代器
        Iterator<Object> it = keySet.iterator();
        while (it.hasNext()) {
            // 遍历所有的key 并且获取到各个key
            String key = (String) it.next();
            // 获取Value
            String s = properties.getProperty(key);
            //分割字符串
            String[] strings = s.split("/");
            if (strings[2].equals(code)) {
                express.setNumber(strings[0]);
                express.setCompany(strings[1]);
                express.setCode(strings[2]);
                return express;
            }
        }
        return null;
    }

    @Override
    public void update(Express e) throws IOException {
        properties.load(reader);
        // 获取到Map中所有的key ，key被放到了一个set集合中
        Set<Object> keySet = properties.keySet();
        // 获取到所有的key集合的 迭代器
        Iterator<Object> it = keySet.iterator();
        while (it.hasNext()) {
            // 遍历所有的key 并且获取到各个key
            String key = (String) it.next();
            // 获取Value
            String s = properties.getProperty(key);
            //分割字符串
            String[] strings = s.split("/");
            if (strings[2].equals(e.getCode())) {
                //拼接字符串
                StringBuilder sb = new StringBuilder();
                sb.append(e.getNumber());
                sb.append("/");
                sb.append(e.getCompany());
                sb.append("/");
                sb.append(e.getCode());
                FileWriter data = new FileWriter(file);
                properties.put(key, sb.toString());
                properties.store(data, "update");
                data.close();
            }
        }
    }

    @Override
    public void delete(Express e) throws IOException {
        Express express = new Express();
        properties.load(reader);
        // 获取到Map中所有的key ，key被放到了一个set集合中
        Set<Object> keySet = properties.keySet();
        // 获取到所有的key集合的 迭代器
        Iterator<Object> it = keySet.iterator();
        while (it.hasNext()) {
            // 遍历所有的key 并且获取到各个key
            String key = (String) it.next();
            // 获取Value
            String s = properties.getProperty(key);
            //分割字符串
            String[] strings = s.split("/");
            if (strings[0].equals(e.getNumber())) {
                FileWriter data = new FileWriter(file);
                properties.remove(key);
                properties.store(data, "delete");
                data.close();
            }
        }
    }

    @Override
    public Properties findAll() {
        return properties;
    }
}
