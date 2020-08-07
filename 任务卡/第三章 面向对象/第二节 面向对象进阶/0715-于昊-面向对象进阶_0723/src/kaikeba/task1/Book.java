package com.kaikeba.task1;

/**
 * @ClassName Book
 * @Description 类Book，代表图书
 * @Author 0715-YuHao
 * @Date 2020/7/23 9:49
 */
class Book {

    private String title;
    private int pageNum;

    Book() {}

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    int getPageNum() {
        return pageNum;
    }

    void setPageNum(int pageNum) {
        if (pageNum < 200) {
            System.out.println("你设置的页数小于200，默认设置为200");
            this.pageNum = 200;
        }else {
            this.pageNum = pageNum;
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 输出本图书的名称和页数
     * @Date 2020/7/23 10:02
     * @Param []
     * @return void
     */
    void detail() {
        System.out.println("图书名称：" + this.title + "，页数：" + this.pageNum);
    }

}
