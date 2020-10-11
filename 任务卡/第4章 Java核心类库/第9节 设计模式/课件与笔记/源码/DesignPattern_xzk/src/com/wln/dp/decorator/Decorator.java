package com.wln.dp.decorator;

public class Decorator extends ScoreReport{
    private ScoreReport report;

    public Decorator(ScoreReport report) {
        this.report = report;
    }

    @Override
    public void show() {
        this.report.show();
    }

    @Override
    public void sign(String name) {
        this.report.sign(name);
    }
}
