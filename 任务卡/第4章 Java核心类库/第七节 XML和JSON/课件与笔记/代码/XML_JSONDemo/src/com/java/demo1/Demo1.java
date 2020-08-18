package com.java.demo1;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) throws IOException, DocumentException {
        //1.    获取输入流
        FileInputStream fis = new FileInputStream("c://Demo1.xml");
        //2.    创建XML读取对象
        SAXReader sr = new SAXReader();
        //3.    读取并得到文档对象
        Document doc = sr.read(fis);
        //4.    通过文档获取根元素
        Element root = doc.getRootElement();
        //5.    开始解析元素
        System.out.println(root.getName());

        //操作一波
        //Element book = root.element("book");
        //Element name = book.element("name");
        //System.out.println(name.getText());
        List<Element> es = root.elements();
        for(int i=0;i<es.size();i++){
            Element book = es.get(i);
            System.out.println(book.attributeValue("id"));
            System.out.println(book.elementText("name"));
            System.out.println(book.elementText("info"));
            System.out.println("-----------------------------");
        }

        fis.close();
    }
}
