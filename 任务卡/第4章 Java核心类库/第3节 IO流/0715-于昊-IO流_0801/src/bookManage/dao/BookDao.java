package task2.bookManage.dao;

import task2.bookManage.bean.Book;

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

    //容器存储Book
    private ArrayList<Book> data;

    //无参构造方法
    public BookDao() throws IOException, ClassNotFoundException {
        //判断book.txt文件是否存在，不存在则新建
        if (!file.exists()) {
            file.createNewFile();
            //存入一个空容器对象
            ObjectOutputStream putData = new ObjectOutputStream(new FileOutputStream(file));
            putData.writeObject(data = new ArrayList<>());
            putData.close();
            //将本地数据加载到容器中
            loadBook();
        }else {
            //文件存在则直接将文件加载到容器中
            loadBook();
        }
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

    /**
     * @Author 0715-YuHao
     * @Description 输出数据到本地
     * @Date 22:28 2020/8/2
     * @Param []
     * @return void
     **/
    @Override
    public void storeBook() throws IOException {
        ObjectOutputStream putData = new ObjectOutputStream(new FileOutputStream(file));
        putData.writeObject(data);
        //必须close()
        putData.close();
    }

    /**
     * @Author 0715-YuHao
     * @Description 加载本地数据
     * @Date 22:26 2020/8/2
     * @Param []
     * @return void
     **/
    @Override
    public void loadBook() throws IOException, ClassNotFoundException {
        //判断本地文件是否为空，为空就写入一个空容器ArrayList
        //因为要使用ObjectInputStream时，文件内部必须要有一个对象
        if (file.length() == 0) {
            ObjectOutputStream putData = new ObjectOutputStream(new FileOutputStream(file));
            putData.writeObject(data = new ArrayList<>());
            putData.close();
            loadBook();
        }else {
            //加载本地数据到容器data中
            ObjectInputStream getData = new ObjectInputStream(new FileInputStream(file));
            //需要强转类型为ArrayList<Book>
            data = (ArrayList<Book>) getData.readObject();
            //必须close()
            getData.close();
        }
    }

}
