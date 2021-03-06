package main;


import bean.Book;
import view.Views;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ManagerClient
 * @Description 管理员程序
 * @Author 0715-YuHao
 * @Date 2020/7/31 16:05
 */
public class ManagerClient {
    private final Views view = new Views();
    private final ObjectInputStream ois;
    private final ObjectOutputStream oos;

    public ManagerClient(ObjectOutputStream oos, ObjectInputStream ois) {
        this.ois = ois;
        this.oos = oos;
    }


    public void start() throws IOException, ClassNotFoundException {
        while (true) {
            int menu = view.cMenu();
            oos.writeInt(menu);
            oos.flush();
            switch (menu) {
                case 0:
                    return;
                case 1: {
                    //1. 提示输入图书信息
                    Book book = view.insert();
                    oos.writeObject(book);
                    oos.flush();
                    boolean insert = ois.readBoolean();
                    if (insert) {
                        view.success();
                    } else {
                        view.expressExit();
                    }
                }
                break;
                case 2: { //图书修改
                    //1. 提示输入图书信息
                    String title = view.findByTitle();
                    oos.writeObject(title);
                    oos.flush();
                    //2. 查找数据
                    Book book = (Book) ois.readObject();
                    //3. 打印快递信息
                    if (book == null) {
                        view.printNull();
                    } else {
                        view.printBook(book);
                        //4. 提示修改
                        Book book1 = view.update(book);
                        oos.writeObject(book1);
                        oos.flush();
                        boolean updata = ois.readBoolean();
                        if (updata) {
                            view.success();
                            view.printBook(book);
                        } else {
                            view.fail();
                        }
                    }
                }
                break;
                case 3: {
                    //图书删除
                    //1. 输入图书名称
                    String title = view.findByTitle();
                    //2. 查找快递对象
                    oos.writeObject(title);
                    oos.flush();
                    Book book = (Book) ois.readObject();
                    if (book == null) {
                        view.printNull();
                    } else {
                        view.printBook(book);
                        int type = view.delete();
                        oos.writeInt(type);
                        oos.flush();
                        switch (type) {
                            case 0:
                                break;
                            case 1:
                                boolean delete = ois.readBoolean();
                                if (delete) {
                                    view.success();
                                }
                                break;
                            default:
                        }
                    }
                }
                break;
                case 4: {
                    //模糊查找
                    String word = view.findByWord();
                    oos.writeObject(word);
                    oos.flush();
                    List<Book> bookList = (List<Book>) ois.readObject();
                    if (bookList.size() > 0) {
                        for (Book book :
                                bookList) {
                            view.printBook(book);
                        }
                    }else {
                        view.searchFail();
                    }
                }
                break;
                case 5:
                    // 查看所有图书
                    o: while (true) {
                        int type = view.printOption();
                        oos.writeInt(type);
                        oos.flush();
                        switch (type) {
                            case 0:
                                break o;
                            case 1:
                                List<Book> bookList = (List<Book>) ois.readObject();
                                if (bookList.size() > 0) {
                                    view.highPriceSort((ArrayList<Book>) ois.readObject());
                                }else {
                                    view.bookNull();
                                }
                                break;
                            case 2:
                                List<Book> bookList2 = (List<Book>) ois.readObject();
                                if (bookList2.size() > 0) {
                                    view.lowPriceSort((ArrayList<Book>) ois.readObject());
                                }else {
                                    view.bookNull();
                                }
                                break;
                            case 3:
                                List<Book> bookList3 = (List<Book>) ois.readObject();
                                if (bookList3.size() > 0) {
                                    view.dateSort((ArrayList<Book>) ois.readObject());
                                }else {
                                    view.bookNull();
                                }
                                break;
                            default:
                        }
                    }
                default:
            }
        }
    }
}
