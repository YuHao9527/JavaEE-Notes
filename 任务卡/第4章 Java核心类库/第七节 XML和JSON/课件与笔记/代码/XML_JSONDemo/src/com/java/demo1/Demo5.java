package com.java.demo1;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Demo5 {
    public static void main(String[] args) throws IOException {
        //1.    通过文档帮助器，创建一个文档对象
        Document doc = DocumentHelper.createDocument();
        //2.    给文档添加第一个节点（根节点）
        Element books = doc.addElement("books");
        //3.    通过根节点， 丰富子节点
        for(int i=0;i<100;i++){
            Element book = books.addElement("book");
            Element name = book.addElement("name");
            name.setText(i+"种苹果的小姑娘~");
            Element info = book.addElement("info");
            info.setText(i+"辛勤种植苹果的故事~");
            book.addAttribute("id",100+i+"");
        }
        //4.    创建一个文件输出流
        FileOutputStream fos = new FileOutputStream("c://books.xml");
        //5.    将输出流转换为XML输出流
        XMLWriter xw = new XMLWriter(fos);
        //6.    写出文档
        xw.write(doc);
        //7.    释放资源
        xw.close();
        System.out.println("执行完毕");
    }
}
