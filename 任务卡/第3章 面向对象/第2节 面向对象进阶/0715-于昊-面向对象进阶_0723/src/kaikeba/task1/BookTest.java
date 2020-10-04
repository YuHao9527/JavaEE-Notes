package com.kaikeba.task1;

/**
 * @ClassName BookTest
 * @Description 测试Book类
 * @Author 0715-YuHao
 * @Date 2020/7/23 9:49
 */
public class BookTest {

    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("程序员的思维修炼");
        book.setPageNum(213);
        book.detail();
    }
}
