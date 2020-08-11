package dao;

import bean.Book;
import bean.User;

import java.io.*;
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
    private List<Book> data = new ArrayList<>();
    private static final File file = new File("src\\server\\book.txt");
    private final User admin = new User("user", "123456");

    public BookDao() {
    }

    @Override
    public boolean add(Book book) {
        return data.add(book);
    }

    @Override
    public boolean updata(Book b1, Book b2) {
        data.remove(b1);
        data.add(b2);
        return true;
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
    public boolean delete(Book book) {
        return data.remove(book);
    }

    @Override
    public List<Book> findAll() {
        return data;
    }

    /**
     * @Author 0715-YuHao
     * @Description 从文件中读取数据
     * @Date 22:25 2020/8/10
     * @Param []
     * @return boolean
     **/
    @Override
    public boolean getData() {
        if (file.length() > 0) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                data = (ArrayList<Book>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean putData() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(data);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean confirm(User user) {
        return admin.equals(user);
    }

}
