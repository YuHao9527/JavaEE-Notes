package com.wln.principle.isp;

public abstract class AbstractSearcher {

    protected  IPettyGirl girl;

    public AbstractSearcher(IPettyGirl girl) {
        this.girl = girl;
    }

    public abstract void search();
}
