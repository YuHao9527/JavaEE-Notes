package com.yhp.service;

import com.github.pagehelper.PageInfo;
import com.yhp.bean.Bills;

import java.util.List;

public interface BillsService {
    //查询所有的账单
    public PageInfo<Bills> getBills(int typeid, String begin, String end, int index, int size);
    int insert(Bills record);
    Bills selectByPrimaryKey(Integer id);//主键查询
    int updateByPrimaryKey(Bills record);//更新
    int deleteByPrimaryKey(Integer id);//主键删除

}
