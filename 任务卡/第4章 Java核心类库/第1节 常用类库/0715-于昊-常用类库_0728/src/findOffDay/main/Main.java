package com.findOffDay.main;

import com.findOffDay.dao.CalendarDao;
import com.findOffDay.view.Views;

/**
 * @ClassName Main
 * @Description 主程序
 * @Author 0715-YuHao
 * @Date 2020/7/29 11:14
 */
public class Main {
    //初始化视图对象
    private static Views view = new Views();
    //初始化dao对象
    private static CalendarDao cd = new CalendarDao();

    public static void main(String[] args) {
        while (true) {
            //初始化视图对象
            Views view = new Views();
            //初始化dao对象
            CalendarDao cd = new CalendarDao();
            //输入年
            int year = view.insertYear();
            //输入月
            int month = view.insertMonth();
            //打印日历
            view.showCalendar(cd.showCalendar(year, month - 1));
            //打印总休息日数
            view.showOffDay(cd.getOffDayNum());
            //打印周末休息日数
            view.showWeekDay(cd.getWeekDayNum());
        }
    }
}
