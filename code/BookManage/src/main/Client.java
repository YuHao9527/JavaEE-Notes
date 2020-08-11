package main;

import bean.User;
import view.Views;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName Client
 * @Description 主程序
 * @Author 0715-YuHao
 * @Date 2020/7/31 16:01
 */
public class Client {
    private static final Views view = new Views();
    private Socket socket;

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    private void start() {
        OutputStream os;
        InputStream is;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            socket = new Socket("127.0.0.1", 8488);
            System.out.println("服务器连接成功");
            os = socket.getOutputStream();
            is = socket.getInputStream();
            oos = new ObjectOutputStream(os);
            ois = new ObjectInputStream(is);
            //1. 欢迎
            view.welcome();
            m: while (true) {
                int menu = view.menu();
                oos.writeInt(menu);
                oos.flush();
                switch (menu) {
                    case 0:
                        break m;
                    case 1:
                        User user = view.login();
                        oos.writeObject(user);
                        oos.flush();
                        boolean confirm = ois.readBoolean();
                        if (confirm) {
                            new ManagerClient(oos, ois).start();
                        }else {
                            view.loginFail();
                        }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            start();
        }finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (ois != null) {
                    ois.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        view.bye();
    }
}
