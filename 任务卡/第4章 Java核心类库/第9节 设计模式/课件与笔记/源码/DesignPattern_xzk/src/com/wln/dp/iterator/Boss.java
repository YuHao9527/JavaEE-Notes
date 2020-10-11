package com.wln.dp.iterator;

import java.util.ArrayList;
import java.util.List;

public class Boss {

    public static void main(String[] args) {
        IProject project=new Project();
        //添加项目
        project.add(new Project("疫情下无接触快递柜项目", 8, 10000));
        project.add(new Project("开课吧新职课商城项目", 128, 10000000));
        project.add(new Project("开课吧在线课程管理系统", 1024, 1000000000));
        for(int i=4;i<=105;i++){
            project.add(new Project("第"+i+"个项目", i+3, i*10000000));
        }
        //遍历集合，展示所有的项目数据给老板
        /*for (IProject iProject : list) {
            System.out.println(iProject.getProjectInfo());
        }*/
        IProjectIterator iterator=project.iterator();
        while(iterator.hasNext()){
            IProject pro= (IProject) iterator.next();
            System.out.println(pro.getProjectInfo());
        }
    }
}
