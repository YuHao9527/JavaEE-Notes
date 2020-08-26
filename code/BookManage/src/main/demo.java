package main;

import bean.Book;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName demo
 * @Description TODO
 * @Author 0715-YuHao
 * @Date 2020/8/22 18:11
 * @Version 1.0
 */
public class demo {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) throws ParseException, IOException {
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book("斗破", "12.5", format.parse("2010-10-1"));
        bookList.add(book1);
        String json = JSON.toJSONString(bookList);
        File file = new File("src\\book.json");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        bw.write(json);
        System.out.println(json);
        ArrayList<Book> list = (ArrayList<Book>) JSONArray.parseArray("[{\"date\":1285862400000,\"price\":\"12.5\",\"title\":\"斗破\"}]", Book.class);
        System.out.println(list.get(0));
    }
}
