package com.yhp.service;

import com.yhp.bean.Bills;
import com.yhp.bean.Billtype;

import java.util.List;

public interface BillTypesService {
    //查询所有的账单
    public List<Billtype> getTypes();
}
