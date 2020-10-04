package com.yhp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhp.bean.Bills;
import com.yhp.dao.BillsMapper;
import com.yhp.service.BillsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Administrator
 * ssm_project
 * 面向对象面向君  不负代码不负卿
 */
@Service
public class BillsServiceImpl implements BillsService {
    @Override
    @Transactional
    public int insert(Bills record) {
        return billsMapper.insert(record);
    }

    @Override
    public Bills selectByPrimaryKey(Integer id) {
        return billsMapper.selectByPrimaryKey(id);
    }

    @Resource
    private BillsMapper billsMapper;

    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer id) {
        return billsMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(Bills record) {
        return billsMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Bills> getBills(int typeid, String begin, String end, int index, int size) {
        Map params=new HashMap();
        params.put("tid",typeid);
        params.put("begin",begin);
        params.put("end",end);
        //1.指定分页数据
        PageHelper.startPage(index,size);
        //2.查询数据
        List<Bills> bills = billsMapper.getBills(params);
        //3.创建分页工具类
        PageInfo<Bills> info = new PageInfo<>(bills);
        return info;
    }
}
