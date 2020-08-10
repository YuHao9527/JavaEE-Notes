package view;


import bean.Book;
import bean.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName Views
 * @Description 视图层
 * @Author 0715-YuHao
 * @Date 2020/7/31 13:55
 */
public class Views {
    private Scanner scanner = new Scanner(System.in);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    //欢迎
    public void welcome() {
        System.out.println("欢迎使用xxx图书管理系统");
    }

    //再见
    public void bye() {
        System.out.println("谢谢你的使用，再见！");
    }

    /**
     * @Author 0715-YuHao
     * @Description 主菜单
     * @Date 2020/7/31 14:09
     * @Param []
     * @return int
     */
    public int menu() {
        System.out.println("请根据提示，输入功能序号：");
        System.out.println("1. 管理员");
        System.out.println("0. 退出");
        String text = scanner.nextLine();
        return insertNum(text, 1, 0);
    }

    public int insertNum(String text, int i, int option) {
        int num = -1;
        try {
            num = Integer.parseInt(text);
        } catch (NumberFormatException ignore) {

        }
        if (num < 0 || num > i) {
            System.out.println("输入有误，请重新输入");
            switch (option) {
                case 0:
                    return menu();
                case 1:
                    return cMenu();
                case 2:
                    return delete();
                case 3:
                    return printOption();
            }
        }
        return num;
    }

    /**
     * @Author 0715-YuHao
     * @Description 管理员菜单
     * @Date 2020/7/31 14:16
     * @Param []
     * @return int
     */
    public int cMenu() {
        System.out.println("请根据提示，输入功能序号：");
        System.out.println("1. 图书新增");
        System.out.println("2. 图书修改");
        System.out.println("3. 图书删除");
        System.out.println("4. 模糊查找");
        System.out.println("5. 查看所有图书");
        System.out.println("0. 退出");
        String text = scanner.nextLine();
        return insertNum(text, 5, 1);
    }

    /**
     * @Author 0715-YuHao
     * @Description 图书新增菜单
     * @Date 2020/7/31 14:20
     * @Param []
     * @return boolean
     */
    public Book insert() {
        System.out.println("请跟据提示，输入图书信息：");
        while (true) {
            try {
                System.out.println("请输入图书名称：");
                String title = scanner.nextLine();
                System.out.println("请输入图书价格：");
                String  price = scanner.nextLine();
                System.out.println("请输入图书出版日期(yyyy-MM-dd)：");
                Date date = format.parse(scanner.nextLine());
                return new Book(title, price, date);
            }catch (ParseException e) {
                System.out.println("你的输入有误，请重新输入！");
            }
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 提示修改图书信息
     * @Date 2020/7/31 14:35
     * @Param [book]
     * @return void
     */
    public Book update(Book book) {
        while (true) {
            try {
                System.out.println("请输入新的图书名称：");
                String title = scanner.nextLine();
                System.out.println("请输入新的图书价格：");
                String price = scanner.nextLine();
                System.out.println("请输入新的图书出版日期(yyyy-MM-dd)：");
                Date date = format.parse(scanner.nextLine());
                book.setTitle(title);
                book.setPrice(price);
                book.setDate(date);
                return book;
            } catch (ParseException e) {
                System.out.println("你的输入有误，请重新输入");
            }
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 提示用户输入图书名称
     * @Date 2020/7/31 16:14
     * @Param []
     * @return java.lang.String
     */
    public String findByTitle() {
        System.out.println("请根据提示输入图书信息：");
        System.out.println("请输入要操作的图书名称：");
        return scanner.nextLine();
    }

    /**
     * @Author 0715-YuHao
     * @Description 模糊查找提示
     * @Date 2020/7/31 16:45
     * @Param []
     * @return java.lang.String
     */
    public String findByWord() {
        System.out.println("请输入你要查找图书的关键字：");
        return scanner.nextLine();
    }

    /**
     * @Author 0715-YuHao
     * @Description 删除菜单
     * @Date 2020/7/31 14:37
     * @Param [book]
     * @return void
     */
    public int delete() {
        System.out.println("是否确认删除?");
        System.out.println("1. 确认删除");
        System.out.println("2. 取消操作");
        System.out.println("0. 退出");
        String text = scanner.nextLine();
        return insertNum(text, 2, 2);
    }

    /**
     * @Author 0715-YuHao
     * @Description 打印图书信息
     * @Date 2020/7/31 15:07
     * @Param []
     * @return void
     */
    public void printBook(Book book) {
        System.out.println("书名: " + book.getTitle() + "\t价格: " + book.getPrice() + "\t出版日期: " + book.getDate());
    }

    /**
     * @Author 0715-YuHao
     * @Description 查询失败显示
     * @Date 2020/7/31 15:19
     * @Param []
     * @return void
     */
    public void printNull() {
        System.out.println("你查找的图书不存在，请检查你的输入");
    }

    /**
     * @Author 0715-YuHao
     * @Description 排序方式选择菜单
     * @Date 2020/7/31 15:20
     * @Param []
     * @return void
     */
    public int printOption() {
        System.out.println("请跟据提示，输入功能序号：");
        System.out.println("1. 价格从高到低排序");
        System.out.println("2. 价格从低到高排序");
        System.out.println("3. 新旧排序(出版日期排序)");
        System.out.println("0. 返回上一层");
        String text = scanner.nextLine();
        return insertNum(text, 3, 3);
    }

    //从高到低排序
    public void highPriceSort(List<Book> bookList) {
        //数组排序
        bookList.sort((o1, o2) -> {
            if (Float.valueOf(o1.getPrice()) > Float.valueOf(o2.getPrice())) {
                return 1;
            }else if (Float.valueOf(o1.getPrice()) < Float.valueOf(o2.getPrice())){
                return -1;
            }else {
                return 0;
            }
        });
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            printBook(iterator.next());
        }
    }

    //从低到高排序
    public void lowPriceSort(List<Book> bookList) {
        bookList.sort((o1, o2) -> {
            if (Float.valueOf(o1.getPrice()) > Float.valueOf(o2.getPrice())) {
                return -1;
            }else if (Float.valueOf(o1.getPrice()) < Float.valueOf(o2.getPrice())){
                return 1;
            }else {
                return 0;
            }
        });
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            printBook(iterator.next());
        }
    }

    //新旧排序(出版日期排序)
    public void dateSort(List<Book> bookList) {
        bookList.sort((o1, o2) -> {
            if (o1.getDate().getTime() > o2.getDate().getTime()) {
                return 1;
            }else if (o1.getDate().getTime() < o2.getDate().getTime()) {
                return -1;
            }else {
                return 0;
            }
        });
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            printBook(iterator.next());
        }
    }

    // 重复提示
    public void expressExit() {
        System.out.println("此图书已存在，请勿重复存储");
    }

    // 操作成功提示
    public void success() {
        System.out.println("操作成功");
    }

    // 操作失败提示
    public void fail() {
        System.out.println("操作失败");
    }

    //登录
    public User login() {
        User user = new User();
        System.out.println("请输入用户名(user)：");
        String username = scanner.nextLine();
        System.out.println("请输入密码(123456)：");
        String password = scanner.nextLine();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    //数据上传失败提示
    public void storeDefeat() {
        System.out.println("数据上传失败，与服务器断开连接");
    }

    //登录失败
    public void loginFail() {
        System.out.println("对不起，你输入的用户名或密码有误！");
    }
}
