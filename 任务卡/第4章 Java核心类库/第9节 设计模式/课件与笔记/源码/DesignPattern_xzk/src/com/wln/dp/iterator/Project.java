package com.wln.dp.iterator;

import java.util.ArrayList;
import java.util.List;

public class Project implements IProject{
    //存放所有项目的对象的集合
    private List<IProject> list=new ArrayList<>();
    private String name;
    private int num;
    private int cost;

    public Project() {
    }

    public Project(String name, int num, int cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    @Override
    public String getProjectInfo() {
        String info="项目名称："+name+",\t\t项目人数："+num+"，\t\t项目费用："+cost+"。";
        return info;
    }

    @Override
    public void add(IProject pro) {
        this.list.add(pro);
    }

    @Override
    public IProjectIterator iterator() {
        // todo 返回迭代器对象
        return new ProjectIterator(list);
    }
}
