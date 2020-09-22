package com.test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * Administrator
 * mongodbDemo
 * 面向对象面向君  不负代码不负卿
 */
public class Demo1 {
    public static void main(String[] args) {
        //1.建立mongodb的连接
        MongoClient mongoClient = new MongoClient("192.168.197.132",27017);
        //2.得到数据源
        MongoDatabase mydb1 = mongoClient.getDatabase("mydb1");
        System.out.println( mydb1);//得到数据库信息
        //3.得到集合
       // mydb1.createCollection("users");//创建新集合
        MongoCollection<Document> users = mydb1.getCollection("users");
        //4.集合的增删改查
        //4.1 新增
       /* Document document = new Document("_id",1101);
        document.append("name","王五");
        document.append("age",30);
        users.insertOne(document);
        System.out.println("新增成功");*/

        //4.3 修改 需求:将张三的年龄改成88  updateMany
      //  users.updateOne(Filters.eq("name","zhangsan"),new Document("$set",new Document("age",88)));
        //4.4 删除操作 需求:删除李四的信息
        users.deleteOne(new Document("name","lisi"));
        //4.2 查询
        FindIterable<Document> documents = users.find();
        MongoCursor<Document> iterator = documents.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
