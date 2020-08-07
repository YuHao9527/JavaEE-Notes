package server;

import bean.Book;
import dao.Data;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Server
 * @Description 搭建服务器
 * @Author 0715-YuHao
 * @Date 2020/8/4 19:44
 */
public class Server {
    private static final File file = new File(Data.PATH_NAME);

    public static void main(String[] args) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        ServerSocket server = new ServerSocket(8080);
        System.out.println("服务器已启动...");
        //创建缓存线程池
        ExecutorService service = Executors.newCachedThreadPool();
        while (true) {
            Socket socket = server.accept();
            service.execute(() -> {
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

    /**
     * @Author 0715-YuHao
     * @Description 从文件中获取数据
     * @Date 2020/8/4 19:50
     * @Param []
     * @return java.lang.Object
     */
    public static Object getData() throws IOException, ClassNotFoundException {
        if (file.length() > 0) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            return ois.readObject();
        }else {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(new ArrayList<Book>());
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            return ois.readObject();
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 将数据存入文件
     * @Date 2020/8/4 19:50
     * @Param [o]
     * @return void
     */
    public static void putData(Object o) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(o);
    }
}
