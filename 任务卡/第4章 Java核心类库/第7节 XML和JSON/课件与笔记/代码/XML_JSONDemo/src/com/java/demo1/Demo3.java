package com.java.demo1;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) throws IOException, DocumentException {
        //1.    获取输入流
        FileInputStream fis = new FileInputStream("c://Demo1.xml");
        //2.    创建XML读取对象
        SAXReader sr = new SAXReader();
        //3.    读取并得到文档对象
        Document doc = sr.read(fis);
        //4.    通过文档对象+xpath，查找所有的name节点
        /*List<Node> names = doc.selectNodes("//book[@id='1001']//name");
        for (int i=0;i<names.size();i++){
            System.out.println(names.get(i).getName());
            System.out.println(names.get(i).getText());
        }*/
        Node n = doc.selectSingleNode("//book[@id='1002']//name");
        System.out.println(n.getName()+":"+n.getText());

        fis.close();
    }
}
