package com.yhp.dao;

import com.yhp.bean.Billtype;

import java.util.List;

public interface BilltypeMapper {

    //查询所有的账单
    public List<Billtype> getTypes();

    int deleteByPrimaryKey(Integer id);

    int insert(Billtype record);

    int insertSelective(Billtype record);

    Billtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Billtype record);

    int updateByPrimaryKey(Billtype record);
}