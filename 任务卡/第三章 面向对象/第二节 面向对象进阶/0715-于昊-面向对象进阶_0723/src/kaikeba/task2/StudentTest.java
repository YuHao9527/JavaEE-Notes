package com.kaikeba.task2;

/**
 * @ClassName StudentTest
 * @Description 测试Student类
 * @Author 0715-YuHao
 * @Date 2020/7/23 10:34
 */
public class StudentTest {

    public static void main(String[] args) {
        Student.company = "开课吧";
        Student.subject = "Java";

        Student student1 = new Student();
        student1.setName("张三");
        student1.setAge(18);
        student1.setGender('男');
        student1.setInterest("篮球");
        student1.show();
        System.out.println("-----------------------");
        Student student2 = new Student();
        student2.setName("刘亦菲");
        student2.setAge(26);
        student2.setGender('女');
        student2.setInterest("旅游");
        student2.show();
    }
}
