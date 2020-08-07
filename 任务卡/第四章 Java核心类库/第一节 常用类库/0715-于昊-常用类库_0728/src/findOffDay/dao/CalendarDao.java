package com.findOffDay.dao;

import com.findOffDay.bean.MyCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @ClassName CalendarDao
 * @Description 日历数据
 * @Author 0715-YuHao
 * @Date 2020/7/29 11:18
 */
public class CalendarDao {
    // 休息日数
    private int offDayNum;
    // 周末休息日数
    private int weekDayNum;
    // 实例化日历对象
    private Calendar calendar = Calendar.getInstance();
    // 新建日期格式化类
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // 首次休息日2020-2-2
    private long firstOffDay;
    {
        try {
            // 日期格式化得到时间戳
            firstOffDay = sdf.parse("2020-02-02").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    // 工作天数标记
    private int count = 0;

    /**
     * @Author 0715-YuHao
     * @Description 创建日历数组
     * @Date 2020/7/29 19:34
     * @Param [year, month] [年份, 月份]
     * @return 日历数组
     */
    public MyCalendar[][] showCalendar(int year, int month) {
        calendar.set(year, month, 1);
        MyCalendar[][] mc = new MyCalendar[5][7];
        int day = 1;
        //获取该月最大天数
        int maxDay = calendar.getActualMaximum(Calendar.DATE);
        //首次休息日标记
        boolean flag = true;
        //遍历数组，输入
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                //实例化MyCalendar对象
                MyCalendar myCalendar = new MyCalendar();
                //设置日历
                calendar.set(Calendar.DATE, day);
                // 打印第一行空白处
                if (i == 0 && j != calendar.get(Calendar.DAY_OF_WEEK) - 1) {
                    myCalendar.setDay("      \t");
                    mc[i][j] = myCalendar;
                }else {
                    // 查找该月首次休息的天数
                    if (flag && caculaterOffsetDay(firstOffDay, year, month + 1, day)) {
                        flag = false;
                        myCalendar.setDay("[" + day + "]  \t");
                        myCalendar.setWeek(calendar.get(Calendar.DAY_OF_WEEK) - 1);
                        mc[i][myCalendar.getWeek()] = myCalendar;
                        day++;
                        count = 1;
                        offDayNum++;
                        if (myCalendar.getWeek() == 6 || myCalendar.getWeek() == 0) {
                            weekDayNum++;
                        }
                    }else {
                        //判断该月天数是否输入完成，完成则输入空白
                        if (day > maxDay) {
                            myCalendar.setDay("     \t");
                            mc[i][j] = myCalendar;
                            continue;
                        }
                        // 判断相隔天数是否相隔3天
                        if (count == 4) {
                            myCalendar.setDay("[" + day + "]  \t");
                            myCalendar.setWeek(calendar.get(Calendar.DAY_OF_WEEK) - 1);
                            mc[i][myCalendar.getWeek()] = myCalendar;
                            day++;
                            count = 1;
                            // 休息日数加1
                            offDayNum++;
                            //判断是否在周末，在周末则加1
                            if (myCalendar.getWeek() == 6 || myCalendar.getWeek() == 0) {
                                weekDayNum++;
                            }
                        } else {
                            myCalendar.setDay(day + "    \t");
                            myCalendar.setWeek(calendar.get(Calendar.DAY_OF_WEEK) - 1);
                            mc[i][myCalendar.getWeek()] = myCalendar;
                            day++;
                            count++;
                        }
                    }
                }
            }
        }
        return mc;
    }

    /**
     * @Author 0715-YuHao
     * @Description 判断是否是休息日
     * @Date 2020/7/29 19:27
     * @Param [firstOffDay, year, month, day]
     * @return boolean
     */
    private boolean caculaterOffsetDay(long firstOffDay, int year, int month, int day) {
        // 计算天数差
        int baseMonth = month + 1;
        long endDay = 0;
        try {
            // 获取对应日期的时间戳
            endDay =  sdf.parse(year + "-" + month + "-" + day).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 计算相差天数，时间戳除以一天的毫秒数为天数
        long offsetDay = (endDay - firstOffDay)/(60*60*24*1000);
        // 能被四整除则代表为休息日，返回true
        if (offsetDay % 4 == 0) {
            return true;
        }
        return false;
    }

    //获取总休息日
    public int getOffDayNum() {
        return offDayNum;
    }

    // 获取轮到周末休息日数
    public int getWeekDayNum() {
        return weekDayNum;
    }
}
