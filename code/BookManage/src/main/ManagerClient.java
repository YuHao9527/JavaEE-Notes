package main;


import bean.Book;
import dao.BookDao;
import view.Views;

import java.util.List;

/**
 * @ClassName ManagerClient
 * @Description 管理员程序
 * @Author 0715-YuHao
 * @Date 2020/7/31 16:05
 */
public class ManagerClient {
    private Views view;
    private BookDao dao;

    public ManagerClient() {
    }

    public ManagerClient(Views view, BookDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void start() {
        while (true) {
            int menu = view.cMenu();
            switch (menu) {
                case 0:
                    return;
                case 1: {
                    //1. 提示输入图书信息
                    Book book = view.insert();
                    //2，此图书是否已经存储过
                    Book book2 = dao.findByTitle(book.getTitle());
                    //3. 存储图书
                    if (book2 == null) {
                        //未存储过
                        dao.add(book);
                        view.printBook(book);
                    } else {
                        //图书已存在
                        view.expressExit();
                    }
                }
                break;
                case 2: { //图书修改
                    //1. 提示输入图书信息
                    String title = view.findByTitle();
                    //2. 查找数据
                    Book book = dao.findByTitle(title);
                    //3. 打印快递信息
                    if (book == null) {
                        view.printNull();
                    } else {
                        view.printBook(book);
                        //4. 提示修改
                        view.update(book);
                        view.printBook(book);
                    }
                }
                break;
                case 3: {
                    //图书删除
                    //1. 输入图书名称
                    String title = view.findByTitle();
                    //2. 查找快递对象
                    Book book = dao.findByTitle(title);
                    if (book == null) {
                        view.printNull();
                    } else {
                        view.printBook(book);
                        int type = view.delete();
                        if (type == 1) {
                            dao.delete(book);
                            view.success();
                        }
                    }
                }
                break;
                case 4: {
                    //模糊查找
                    String word = view.findByWord();
                    List<Book> bookList = dao.fuzzySearch(word);
                    if (bookList.size() == 0) {
                        view.printNull();
                    } else {
                        view.success();
                        for (Book book : bookList) {
                            view.printBook(book);
                        }
                    }
                }
                break;
                case 5:
                    // 查看所有图书
                    int type = view.printOption();
                    switch (type) {
                        case 0:
                            return;
                        case 1:
                            view.highPriceSort(dao.findAll());
                            break;
                        case 2:
                            view.lowPriceSort(dao.findAll());
                            break;
                        case 3:
                            view.dateSort(dao.findAll());
                            break;
                    }
                break;
            }
        }
    }
}
