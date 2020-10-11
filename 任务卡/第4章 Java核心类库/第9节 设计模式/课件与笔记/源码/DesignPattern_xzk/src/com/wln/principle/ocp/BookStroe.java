package com.wln.principle.ocp;

import java.util.ArrayList;

public class BookStroe {
    private static ArrayList<IBook> bookList=new ArrayList<>();

    static {
        bookList.add(new OffNovelBook("红楼梦", 9900, "曹雪芹"));
        bookList.add(new OffNovelBook("侠客行", 8900, "金庸"));
        bookList.add(new OffNovelBook("原则", 6900, "瑞达利欧"));
        bookList.add(new OffNovelBook("海贼王1", 4900, "尾田荣一郎"));
    }

    public static void main(String[] args) {
        System.out.println("卖书的记录如下----------------------");
        for (IBook book : bookList) {
            System.out.println("书籍名称："+book.getName()+"\t\t作者："+book.getAuthor()+"\t\t价格：￥"+book.getPrice()/100.0+"元");
        }
    }
}
