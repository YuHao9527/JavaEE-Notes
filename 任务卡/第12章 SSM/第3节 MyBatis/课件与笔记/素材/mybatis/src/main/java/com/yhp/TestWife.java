package com.yhp;

import com.yhp.bean.Husband;
import com.yhp.bean.Wife;
import com.yhp.dao.WifeDao;
import com.yhp.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class TestWife {
    public static void main(String[] args) {
        SqlSession session = SqlSessionUtil.getSession();
        WifeDao mapper = session.getMapper(WifeDao.class);
        Wife wife = mapper.findByWifeId(1);
        System.out.println(wife.getWifeName()+","+wife.getHusband().getHusName());
        Husband husband = mapper.findByhusId(1);
        System.out.println(husband.getHusName()+","+husband.getWife().getWifeName());
        SqlSessionUtil.closeSession();
    }
}
