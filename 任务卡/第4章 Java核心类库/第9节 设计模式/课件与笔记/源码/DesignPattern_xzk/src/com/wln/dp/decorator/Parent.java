package com.wln.dp.decorator;

public class Parent {
    public static void main(String[] args) {
        //拿到原始的成绩单
        ScoreReport report=new MyScoreRport();
        //加了成绩排名的成绩单
        report=new SortDecorator(report);
        //加了最高成绩修饰到的成绩单
       // report=new HighestScoreDecorator(report);
        report.show();
        report.sign("贾政");
    }
    public static void main1(String[] args) {
        ScoreReport report=new BeautifyMyScoreReport();
        report.show();
        report.sign("贾政");
    }
}
