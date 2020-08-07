package task2.bookManage.bean;

import java.io.Serializable;

/**
 * @ClassName Book
 * @Description 书
 * @Author 0715-YuHao
 * @Date 2020/7/31 14:23
 */
public class Book implements Comparable<Book>, Serializable {
    //书名
    private String Title;
    //价格
    private String price;
    //出版日期
    private String date;

    public Book() {
    }

    public Book(String title, String price, String date) {
        Title = title;
        this.price = price;
        this.date = date;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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
                "Title='" + Title + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (Title != null ? !Title.equals(book.Title) : book.Title != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        return date != null ? date.equals(book.date) : book.date == null;
    }

    @Override
    public int hashCode() {
        int result = Title != null ? Title.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    //按价格比较
    @Override
    public int compareTo(Book o) {
        //默认升序
        if (Float.valueOf(this.price) > Float.valueOf(o.price)) {
            return 1;
        }else if (Float.valueOf(this.price) == Float.valueOf(o.price)) {
            //比较书名的首字符
            return this.getTitle().charAt(0) - o.getTitle().charAt(0);
        }else {
            return -1;
        }
    }
}
