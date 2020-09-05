package dao;

import bean.Husband;
import bean.Wife;

public interface WifeDao {
    //查询某位妻子(包含丈夫的信息)
    public Wife findByWifeId(int wid);
    //查询某位丈夫(包含妻子的信息)
    public Husband findByHid(int hid);
}
