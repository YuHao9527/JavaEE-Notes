package com.java.demo3;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static BaseUserDao dao = UserDaoFactory.get();
    public static void main(String[] args) {
        System.out.println("欢迎来到某某软件");
        System.out.println("请选择:");
        System.out.println("1.注册\t\t2.登陆\t\t3.查看所有用户");

        String menu = input.nextLine();
        switch (menu){
            case "1":
                reg();
                break;
            case "2":
                login();
                break;
            case "3":
                showUsers();
                break;
        }
    }

    private static void showUsers() {
        List<User> data = dao.findAll();
        System.out.println("所有用户信息如下:");
        System.out.println(data);
    }

    private static void login() {
        System.out.println("请输入账号:");
        String username = input.nextLine();
        System.out.println("请输入密码:");
        String password = input.nextLine();
        boolean flag = dao.findByPassword(username, password);
        System.out.println(flag?"恭喜你,登陆成功":"很遗憾,登陆失败");
    }

    private static void reg() {
        System.out.println("请输入要注册的账号:");
        String username = input.nextLine();
        System.out.println("请输入要注册的密码:");
        String password = input.nextLine();
        boolean flag = dao.insert(username, password);
        System.out.println(flag?"恭喜你,注册成功":"很遗憾,注册失败");
    }
}
