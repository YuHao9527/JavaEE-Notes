package com.findOffDay.bean;

/**
 * @ClassName MyCalendar
 * @Description 日历类
 * @Author 0715-YuHao
 * @Date 2020/7/29 11:13
 */
public class MyCalendar {
    // 天，String类型是为了方便加中括号
    private String day;
    // 星期
    private int week;

    public MyCalendar() {
    }

    public MyCalendar(String day, int week) {
        this.day = day;
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "MyCalendar{" +
                "day=" + day +
                ", week=" + week +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyCalendar that = (MyCalendar) o;

        return day != null ? day.equals(that.day) : that.day == null;
    }

    @Override
    public int hashCode() {
        return day != null ? day.hashCode() : 0;
    }
}
