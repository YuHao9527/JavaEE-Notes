package com.wln.dp.template;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("H1型号悍马-------");
        System.out.println("是否需要鸣笛功能：0-不需要  1-需要");
        Scanner input=new Scanner(System.in);
        String type=input.next();

        HummerH1Model h1=new HummerH1Model();
        if("0".equals(type)){
            h1.setAlarmFlag(false);
        }
        h1.run();
        System.out.println("H2型号悍马-------");
        HummerH2Model h2=new HummerH2Model();
        h2.run();
    }
}
