package server;

import bean.Express;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Server
 * @Description 搭建服务器
 * @Author 0715-YuHao
 * @Date 2020/8/4 14:10
 */
public class Server {

    private static final File file = new File("src//server//express.txt");

    public static void main(String[] args) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务器已启动...");
        while (true) {
            Socket socket = server.accept();
            //创建缓冲线程池
            ExecutorService service = Executors.newCachedThreadPool();
            service.submit(() -> {
                try {
                    OutputStream os = socket.getOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(os);
                    oos.writeObject(getData());
                    System.out.println(Thread.currentThread().getName() + "数据传输完成");
                    InputStream is = socket.getInputStream();
                    ObjectInputStream ois = new ObjectInputStream(is);
                    putData(ois.readObject());
                    System.out.println(Thread.currentThread().getName() + "数据上传成功");
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(Thread.currentThread().getName() + "连接异常");
                }
            });
        }
    }

    public static Object getData() throws IOException, ClassNotFoundException {
        if (file.length() > 0) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            return ois.readObject();
        }else {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(new HashMap<Integer, Express>());
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            return  ois.readObject();
        }
    }

    public static void putData(Object o) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(o);
    }
}
