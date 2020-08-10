package server;

import bean.Express;
import dao.ExpressDao;

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

    private ServerSocket server;
    private ExpressDao dao = new ExpressDao();

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start() {
        try {
            server = new ServerSocket(8080);
            System.out.println("服务器已启动...");
            dao.loadData();
            while (true) {
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress() + "客户端已连接");
                //创建缓冲线程池
                ExecutorService service = Executors.newCachedThreadPool();
                service.submit(() -> {
                    receive(socket);
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void receive(Socket socket) {
        InputStream is;
        OutputStream os;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            ois = new ObjectInputStream(is);
            oos = new ObjectOutputStream(os);
            m: while (true) {
                switch (ois.readInt()) {
                    case 0:
                        dao.storeData();
                        System.out.println(socket.getInetAddress() + "客户端断开连接");
                        break m;
                    case 1:
                        cindex(ois, oos);
                        break;
                    case 2:
                        uindex(ois, oos);
                        break;
                    default:
                }
            }
        } catch (Exception e) {
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

    private void cindex(ObjectInputStream ois, ObjectOutputStream oos) throws Exception {
        while (true) {
            switch (ois.readInt()) {
                case 0:
                    return;
                case 1:
                    insert(ois, oos);
                    break;
                case 2:
                    update(ois, oos);
                    break;
                case 3:
                    delete(ois, oos);
                    break;
                case 4:
                    printAll(ois, oos);
                    break;
                default:
            }
        }
    }

    private void printAll(ObjectInputStream ois, ObjectOutputStream oos) throws IOException {
        HashMap<Integer, Express> data = dao.findAll();
        oos.writeObject(data);
        oos.flush();
    }

    private void delete(ObjectInputStream ois, ObjectOutputStream oos) throws IOException, ClassNotFoundException {
        String number = (String) ois.readObject();
        Express e = dao.findByNumber(number);
        oos.writeObject(e);
        oos.flush();
        if (e != null) {
            if (ois.readInt() == 1) {
                boolean delete = dao.delete(e);
                oos.writeBoolean(delete);
                oos.flush();
            }
        }
    }

    private void update(ObjectInputStream ois, ObjectOutputStream oos) throws IOException, ClassNotFoundException {
        String number = (String) ois.readObject();
        Express e = dao.findByNumber(number);
        oos.writeObject(e);
        oos.flush();
        if (e != null) {
            Express e2 = (Express) ois.readObject();
            boolean insert = dao.updata(e, e2);
            oos.writeBoolean(insert);
            oos.flush();
        }
    }


    private void insert(ObjectInputStream ois, ObjectOutputStream oos) throws Exception {
        Express e = (Express) ois.readObject();
        Express e2 = dao.findByNumber(e.getNumber());
        oos.writeObject(e2);
        oos.flush();
        if (e2 == null) {
            boolean insert = dao.add(e);
            oos.writeBoolean(insert);
            oos.flush();
        }
    }

    private void uindex(ObjectInputStream ois, ObjectOutputStream oos) throws IOException, ClassNotFoundException {
        while (true) {
            switch (ois.readInt()) {
                case 1:
                    String code = (String) ois.readObject();
                    Express e = dao.findByCode(code);
                    oos.writeObject(e);
                    oos.flush();
                    if (e != null) {
                        boolean delete = dao.delete(e);
                        oos.writeBoolean(delete);
                        oos.flush();
                    }
                    break;
                case 0:
                    return;
            }
        }
    }

}
