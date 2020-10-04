package com.yhp.dao;

import com.yhp.bean.Bills;

import java.util.List;
import java.util.Map;

public interface BillsMapper {
    //查询所有的账单
    public List<Bills> getBills(Map map);

    int deleteByPrimaryKey(Integer id);//主键删除

    int insert(Bills record);//新增

    int insertSelective(Bills record);//动态新增

    Bills selectByPrimaryKey(Integer id);//主键查询

    int updateByPrimaryKeySelective(Bills record); //动态更新语句

    int updateByPrimaryKey(Bills record);//更新
}