package dao;

import bean.Book;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName BookDao
 * @Description 图书数据
 * @Author 0715-YuHao
 * @Date 2020/7/31 14:39
 */
public class BookDao implements Dao {
    //使用ArrayList集合存储图书
    private List<Book> data;
    private Socket socket;

    public BookDao() {
    }

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

    @Override
    public boolean getData() {
        try {
            //从服务器上下载数据
            socket = new Socket("127.0.0.1", 8080);
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            data = (ArrayList<Book>) ois.readObject();
        } catch (IOException e) {
            return false;
        } catch (ClassNotFoundException ignore) {

        }
        return true;
    }


    @Override
    public boolean putData() {
        try {
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(data);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
