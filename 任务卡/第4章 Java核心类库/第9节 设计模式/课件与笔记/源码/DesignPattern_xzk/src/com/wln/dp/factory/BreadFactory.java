package com.wln.dp.factory;

public class BreadFactory extends AbstarctBreadFactory{
    @Override
    public Bread createBread(Class cls) {
        Bread bread=null;
        try {
            bread= (Bread) Class.forName(cls.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出错啦！");
        }
        return bread;
    }
}
