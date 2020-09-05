package test;

import bean.Husband;
import bean.Student;
import bean.Wife;
import dao.impl.GradeDaoImpl;
import dao.impl.WifeDaoImpl;

import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        WifeDaoImpl wifeDao = new WifeDaoImpl();
        Wife wife = wifeDao.findByWifeId(1);
        System.out.println(wife.getWifeName()+"\t"+wife.getHusband().getHusName());

        Husband husband = wifeDao.findByHid(2);
        System.out.println(husband.getHusName()+"\t"+husband.getWife().getWifeName());

    }
}
