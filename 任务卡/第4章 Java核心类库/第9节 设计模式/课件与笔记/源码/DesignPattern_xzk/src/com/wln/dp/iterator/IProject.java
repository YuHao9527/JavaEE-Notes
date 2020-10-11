package com.wln.dp.iterator;

public interface IProject {
    //boss通过这里查看项目信息
    String getProjectInfo();
    //添加项目
    void add(IProject pro);
    //获取一个可用于被遍历的对象
    IProjectIterator iterator();
}
