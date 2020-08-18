package task2.bookManage.dao;

import task2.bookManage.bean.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 0715-YuHao
 * @Description 数据接口
 * @Date 2020/7/31 14:44
 */
public interface Dao {
    File file = new File("book.txt");
    //使用ArrayList集合存储图书
//    List<Book> data = new ArrayList<>();
    // 新增图书
    void add(Book book);
    // 通过图书名称精确查找图书
    Book findByTitle(String title);
    //模糊查找
    List<Book> fuzzySearch(String word);
    // 删除图书
    void delete(Book book);
    // 查看所有图书
    List<Book> findAll();
    // 存储到本地内存
    void storeBook() throws IOException;
    //读取本地问价
    void loadBook() throws IOException, ClassNotFoundException;
}
