package com.wln.dp.flyweight;

import java.util.Random;

public class Client {
    private static final String departments[]={"研发部","人力资源部","财务部","新媒体运行部"};
    public static void main(String[] args) {
     for (int i=0;i<10;i++){
        String department=departments[new Random().nextInt(departments.length)];
        Manager manager= (Manager) EmployeeFactory.getMaanger(department);
        manager.report();
     }
    }
}
