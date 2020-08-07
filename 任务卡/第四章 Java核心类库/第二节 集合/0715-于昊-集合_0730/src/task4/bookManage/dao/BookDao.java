package task.task4.bookManage.dao;

import task.task4.bookManage.bean.Book;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName BookDao
 * @Description 图书数据
 * @Author 0715-YuHao
 * @Date 2020/7/31 14:39
 */
public class BookDao implements Dao {

    @Override
    public void add(Book book) {
        data.add(book);
    }

    @Override
    public Book findByTitle(String title) {
        for (Book book: data) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> fuzzySearch(String word) {
        //创建查询到书的集合
        List<Book> bookList = new ArrayList<>();
        //创建存储书名的集合
        List<String> titleList = new ArrayList<>();
        //遍历获取所有图书名称
        for (Book book: data) {
            titleList.add(book.getTitle());
        }
        //遍历查询包含关键字的书名
        for (String title: titleList) {
            //判断书名是否包含关键字
            if (title.contains(word)) {
                for (Book book: data) {
                    if (book.getTitle().equals(title)) {
                        bookList.add(book);
                    }
                }
            }
        }
        return bookList;
    }

    @Override
    public void delete(Book book) {
        data.remove(book);
    }

    @Override
    public List<Book> findAll() {
        return data;
    }
}
