package com.kaikeba.task2;

/**
 * @ClassName Student
 * @Description 开课吧的 Java 学员
 * @Author 0715-YuHao
 * @Date 2020/7/23 10:06
 */
class Student {
    private String name;
    private int age;
    private char gender;
    private String interest;
    static String  company;
    static String subject;

    Student() {}

    Student(String name, int age, String interest) {
        this.name = name;
        this.age = age;
        this.interest = interest;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("你设置的年龄有误，默认设为0");
            this.age = 0;
        }else {
            this.age = age;
        }
    }

    char getGender() {
        return gender;
    }

    void setGender(char gender) {
        if (gender != '男' && gender != '女') {
            System.out.println("你输入的性别有误，默认为：'无'");
            gender = '无';
        }else {
            this.gender = gender;
        }
    }

    String getInterest() {
        return interest;
    }

    void setInterest(String interest) {
        this.interest = interest;
    }

    /**
     * @Author 0715-YuHao
     * @Description 输出学员信息
     * @Date 2020/7/23 10:20
     * @Param []
     * @return void
     */
    void show() {
        System.out.println("姓名：" + this.name);
        System.out.println("年龄：" + this.age);
        System.out.println("性别：" + this.gender);
        System.out.println("爱好：" + this.interest);
        System.out.println("公司：" + company);
        System.out.println("学科：" + subject);
    }
}
