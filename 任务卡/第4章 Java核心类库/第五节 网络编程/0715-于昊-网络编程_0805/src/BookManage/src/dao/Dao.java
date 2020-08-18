package dao;

import bean.Book;
import java.util.List;

/**
 * @Author 0715-YuHao
 * @Description 数据接口
 * @Date 2020/7/31 14:44
 */
public interface Dao {
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
    //从服务器下载数据
    boolean getData();
    //上传数据到服务器
    boolean putData();
    //关闭套接字
    void close();
}
