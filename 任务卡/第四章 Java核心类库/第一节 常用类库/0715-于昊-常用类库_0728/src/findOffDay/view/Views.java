package com.findOffDay.view;

import com.findOffDay.bean.MyCalendar;

import java.util.Scanner;

/**
 * @ClassName Views
 * @Description 视图
 * @Author 0715-YuHao
 * @Date 2020/7/29 10:58
 */
public class Views {
    private Scanner scanner = new Scanner(System.in);

    // 提示输入年
    public int insertYear() {
        System.out.println("请输入年：");
        String text = scanner.nextLine();
        return insertNum(text, 2020, 2100);
    }

    // 提示输入月
    public int insertMonth() {
        System.out.println("请输入月：");
        String text = scanner.nextLine();
        return insertNum(text, 1, 12);
    }

    /**
     * @Author 0715-YuHao
     * @Description 判断用户输入是否合法
     * @Date 2020/7/29 11:08
     * @Param [text, i, j]
     * @return int
     */
    private int insertNum(String text, int i, int j) {
        int num = -1;
        try {
            num = Integer.parseInt(text);
        } catch (NumberFormatException e) {

        }
        if (num < i || num > j) {
            System.out.println("输入有误，请重新输入");
            if (j == 12) {
                return insertMonth();
            }else {
                return insertYear();
            }
        }
        return num;
    }

    public void showCalendar(MyCalendar[][] calendars) {
        System.out.print("星期日\t");
        System.out.print("星期一\t");
        System.out.print("星期二\t");
        System.out.print("星期三\t");
        System.out.print("星期四\t");
        System.out.print("星期五\t");
        System.out.print("星期六\t\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(calendars[i][j].getDay());
            }
            System.out.println();
        }
    }

    // 显示本月休息天数
    public void showOffDay(int num) {
        System.out.println("本月休息天数有：" + num + "天");
    }

    // 显示本月周末休息天数
    public void showWeekDay(int num) {
        System.out.println("本月轮到周末休息天数：" + num + "天");
    }
}
