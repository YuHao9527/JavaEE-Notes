package com.wln.dp.decorator;

public class BeautifyMyScoreReport extends MyScoreRport{

    public void reportHighestScore(){
        System.out.println("这次考试最高成绩：语文 76  数学  79   自然  82  ");
    }

    public void repostSort(){
        System.out.println("我在班级的排名是：32名");
    }

    @Override
    public void show() {
        this.reportHighestScore();
        super.show();
        this.repostSort();
    }
}
