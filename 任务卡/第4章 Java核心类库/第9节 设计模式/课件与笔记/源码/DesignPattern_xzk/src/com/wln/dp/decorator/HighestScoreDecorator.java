package com.wln.dp.decorator;

public class HighestScoreDecorator extends Decorator {
    public HighestScoreDecorator(ScoreReport report) {
        super(report);
    }

    public void reportHighestScore(){
        System.out.println("这次考试最高成绩：语文 76  数学  79   自然  82  ");
    }

    @Override
    public void show() {
        this.reportHighestScore();
        super.show();
    }
}
