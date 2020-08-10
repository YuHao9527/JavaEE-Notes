package main;

import controller.CourierClient;
import controller.UserClient;
import view.Views;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName Client
 * @Description 主程序
 * @Author 0715-YuHao
 * @Date 2020/7/28 10:46
 */
public class Client {
    private static final Views view = new Views();
    private static Socket socket;

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.start();
    }

    private void start() {
        OutputStream os;
        InputStream is;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
            System.out.println("服务器连接成功");
            os = socket.getOutputStream();
            is = socket.getInputStream();
            oos = new ObjectOutputStream(os);
            ois = new ObjectInputStream(is);
            //1. 欢迎
            view.welcome();
            //从服务器下在数据
            System.out.println("与服务器建立连接中");
            m: while (true) {
                //2. 弹出身份选择菜单
                int menu = view.menu();
                oos.writeInt(menu);
                oos.flush();
                switch (menu) {
                    case 0:
                        break m;
                    case 1:
                        new CourierClient(ois, oos).start();
                        break;
                    case 2:
                        new UserClient(ois, oos).start();
                        break;
                    default:
                }
            }
            view.bye();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
