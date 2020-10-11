package com.wln.dp.flyweight;

import java.util.HashMap;
import java.util.Map;

public class EmployeeFactory {

    private static final Map<String,Employee> map=new HashMap<String,Employee>();

    public static Employee getMaanger(String department){
        Manager manager= (Manager) map.get(department);
        if(manager==null){
            manager=new Manager(department);
            System.out.println("创建部门经理："+department);
            String content=department+"部门汇报：此次汇报的主要内容有。。。。。。。。。。";
            manager.setReportContent(content);
            System.out.println("\t创建报告："+content);
            map.put(department, manager);
        }
        return manager;
    }
}
