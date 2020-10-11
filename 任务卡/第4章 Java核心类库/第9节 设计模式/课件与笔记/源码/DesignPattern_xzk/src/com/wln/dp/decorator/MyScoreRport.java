package com.wln.dp.decorator;

public class MyScoreRport extends ScoreReport{
    @Override
    public void show() {
        System.out.println("尊敬的家长：");
        System.out.println("\t以下是您的孩子的本次考试成绩，请阅读之后在后面的家长处签名：");
        System.out.println("\t语文 60  数学  61   自然  62  体育  90");
        System.out.println("\t\t\t家长签名:");
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签名:"+name);
    }
}
