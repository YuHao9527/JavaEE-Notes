package com.wln.dp.decorator;

public class SortDecorator extends Decorator{
    public SortDecorator(ScoreReport report) {
        super(report);
    }

    private void reportSort(){
        System.out.println("我在班级的排名是：32名");
    }

    @Override
    public void show() {
        this.reportSort();
        super.show();

    }
}
