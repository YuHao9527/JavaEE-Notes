package server;

import bean.Book;
import bean.User;
import dao.BookDao;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @ClassName Server
 * @Description 搭建服务器
 * @Author 0715-YuHao
 * @Date 2020/8/4 19:44
 */
public class Server {
    private ServerSocket server = null;
    private final BookDao dao = new BookDao();

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    private void start() {
        try {
            server = new ServerSocket(8488);
            System.out.println("服务器已启动...");
            dao.getData();
            //创建缓存线程池
            ExecutorService service = Executors.newCachedThreadPool();
            while (true) {
                Socket socket = server.accept();
                System.out.println("一个客户端进入连接");
                service.submit(() -> receive(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
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
                        dao.putData();
                        System.out.println("客户端断开连接");
                        break m;
                    case 1:
                        User user = (User) ois.readObject();
                        boolean confirm = dao.confirm(user);
                        oos.writeBoolean(confirm);
                        oos.flush();
                        if (confirm) {
                            mindex(ois, oos);
                        }
                        break;
                    default:
                }
            }
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

    private void mindex(ObjectInputStream ois, ObjectOutputStream oos) throws IOException, ClassNotFoundException {
        while (true) {
            int index = ois.readInt();
            switch (index) {
                case 0:
                    return;
                case 1:
                    insert(ois, oos);
                    break;
                case 2:
                    updata(ois, oos);
                    break;
                case 3:
                    delete(ois, oos);
                    break;
                case 4:
                    search(ois, oos);
                    break;
                case 5:
                    printAll(ois, oos);
                    break;
            }
        }
    }

    private void insert(ObjectInputStream ois, ObjectOutputStream oos) throws IOException, ClassNotFoundException {
        Book book = (Book) ois.readObject();
        Book book1 = dao.findByTitle(book.getTitle());
        if (book1 == null) {
            boolean insert = dao.add(book);
            oos.writeBoolean(insert);
            oos.flush();
        }
    }

    private void updata(ObjectInputStream ois, ObjectOutputStream oos) throws IOException, ClassNotFoundException {
        String tite = (String) ois.readObject();
        Book book = dao.findByTitle(tite);
        oos.writeObject(book);
        oos.flush();
        if (book != null) {
            Book book1 = (Book) ois.readObject();
            boolean updata = dao.updata(book, book1);
            oos.writeBoolean(updata);
            oos.flush();
        }
    }

    private void delete(ObjectInputStream ois, ObjectOutputStream oos) throws IOException, ClassNotFoundException {
        String tite = (String) ois.readObject();
        Book book = dao.findByTitle(tite);
        oos.writeObject(book);
        oos.flush();
        if (book != null) {
            int dindex = ois.readInt();
            switch (dindex) {
                case 0:
                    return;
                case 1:
                    boolean delete = dao.delete(book);
                    oos.writeBoolean(delete);
                    oos.flush();
                    break;
                default:
            }
        }
    }

    private void search(ObjectInputStream ois, ObjectOutputStream oos) throws IOException, ClassNotFoundException {
        String word = (String) ois.readObject();
        List<Book> bookList = dao.fuzzySearch(word);
        oos.writeObject(bookList);
        oos.flush();
    }

    private void printAll(ObjectInputStream ois, ObjectOutputStream oos) throws IOException {
        while (true) {
            int menu = ois.readInt();
            switch (menu) {
                case 0:
                    return;
                case 1:
                case 2:
                case 3:
                    oos.writeObject(dao.findAll());
                    break;
                default:
            }
        }


    }

}
