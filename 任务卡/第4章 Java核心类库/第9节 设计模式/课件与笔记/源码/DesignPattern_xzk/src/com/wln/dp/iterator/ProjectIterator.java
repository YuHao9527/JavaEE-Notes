package com.wln.dp.iterator;

import java.util.List;

public class ProjectIterator implements IProjectIterator{
    //存放所有项目的对象集合
    private List<IProject> list;
    private int currentIndex=0;

    public ProjectIterator(List<IProject> list) {
        this.list = list;
    }

    //判断是否还有元素，必须要实现的方法
    @Override
    public boolean hasNext() {
        boolean flag=true;
        if(this.currentIndex>=list.size()||this.list.get(this.currentIndex)==null){
            flag=false;
        }
        return flag;
    }
    //获取下一个元素值，必须要实现的方法
    @Override
    public Object next() {
        return this.list.get(this.currentIndex++);
    }
    //根据实际情况自行选择是否添加该方法
    public void remove(IProject pro){
        this.list.remove(pro);
    }
}
