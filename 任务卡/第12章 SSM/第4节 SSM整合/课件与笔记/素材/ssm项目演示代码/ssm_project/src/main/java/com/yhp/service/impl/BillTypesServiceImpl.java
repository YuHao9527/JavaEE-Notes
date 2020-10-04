package com.yhp.service.impl;

import com.yhp.bean.Billtype;
import com.yhp.dao.BilltypeMapper;
import com.yhp.service.BillTypesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Administrator
 * ssm_project
 * 面向对象面向君  不负代码不负卿
 */
@Service
public class BillTypesServiceImpl implements BillTypesService {
    @Resource
    private BilltypeMapper billtypeMapper;
    @Override
    public List<Billtype> getTypes() {
        return billtypeMapper.getTypes();
    }
}
