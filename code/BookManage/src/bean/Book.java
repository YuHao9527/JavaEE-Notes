package bean;

import java.io.Serializable;

/**
 * @ClassName Book
 * @Description 书
 * @Author 0715-YuHao
 * @Date 2020/7/31 14:23
 */
public class Book implements Comparable<Book>, Serializable {
    /**
     * @Author 0715-YuHao
     * @Description 书名
     * @Date 2020/8/4 13:34
     * @Param
     * @return
     */
    private String title;
    /**
     * @Author 0715-YuHao
     * @Description 价格
     * @Date 2020/8/4 13:34
     * @Param
     * @return
     */
    private String price;
    /**
     * @Author 0715-YuHao
     * @Description 出版日期
     * @Date 2020/8/4 13:35
     * @Param
     * @return
     */
    private String date;

    public Book() {
    }

    public Book(String title, String price, String date) {
        this.title = title;
        this.price = price;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + title + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) {
            return false;
        }
        if (price != null ? !price.equals(book.price) : book.price != null) {
            return false;
        }
        return date != null ? date.equals(book.date) : book.date == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    /**
     * @Author 0715-YuHao
     * @Description 按价格比较
     * @Date 2020/8/4 13:35
     * @Param [o]
     * @return int
     */
    @Override
    public int compareTo(Book o) {
        //默认升序
        if (Float.valueOf(this.price) > Float.valueOf(o.price)) {
            return 1;
        }else if (Float.valueOf(this.price).equals(Float.valueOf(o.price))) {
            //比较书名的首字符
            return this.getTitle().charAt(0) - o.getTitle().charAt(0);
        }else {
            return -1;
        }
    }
}
