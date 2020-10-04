package com.yhp.dao;

import com.yhp.bean.Husband;
import com.yhp.bean.Wife;

public interface WifeDao {
    //根据丈夫查询妻子
    public Husband findByhusId(int husid);
    //根据妻子查询丈夫
    public Wife findByWifeId(int wifeid);
}
