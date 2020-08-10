package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassName Book
 * @Description 书
 * @Author 0715-YuHao
 * @Date 2020/7/31 14:23
 */
public class Book implements Serializable {
    /**
     * @Author 0715-YuHao
     * @Description 书名
     * @Date 2020/8/4 13:34
     */
    private String title;
    /**
     * @Author 0715-YuHao
     * @Description 价格
     * @Date 2020/8/4 13:34
     */
    private String price;
    /**
     * @Author 0715-YuHao
     * @Description 出版日期
     * @Date 2020/8/4 13:35
     * @Param
     * @return
     */
    private Date date;

    public Book() {
    }

    public Book(String title, String price, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}
