## 项目: 基于 JSP 实现商品动态更新和展示

### 1. 创建数据库
```mysql
-- 创建product数据库
CREATE DATABASE IF NOT EXISTS product default charset=utf8mb4; 
-- 创建phone表
CREATE TABLE `phone` (
`pid` int unsigned not null auto_increment,
`pname` varchar(18) not null ,
`pimg` varchar(50) not null ,
`price` DECIMAL(8,2) not null ,
`info` varchar(100) not null, 
PRIMARY KEY (`pid`)
);
-- 导入数据
INSERT INTO phone VALUES
(null, 'iPhone11', '/images/iphone11.jpg', 5899.00, 'Apple iPhone 11 (A2223) 128GB 绿色 移动联通电信4G手机 双卡双待'),
(null, 'xiaomi10', '/images/xiaomi10.jpg', 6999.00, '小米10 至尊纪念版 双模5G 骁龙865 120HZ高刷新率 120倍长焦镜头 120W快充 16GB+512GB 亮银版 游戏手机'),
(null, 'xiaomi10pro', '/images/xiaomi10pro.jpg', 4999.00, '小米10 Pro 双模5G 骁龙865 1亿像素8K电影相机 50倍变焦 50W快充 8GB+256GB 星空蓝'),
(null, 'iPhone11pro', '/images/iPhone11pro.jpg', 10899.00, 'Apple iPhone 11 Pro Max (A2220) 256GB 银色 移动联通电信4G手机 双卡双待'),
(null, 'huaweiMate30', '/images/huaweiMate30.jpg', 4499.00, '华为 HUAWEI Mate 30 5G 麒麟990 4000万超感光徕卡影像双超级快充8GB+128GB亮黑色5G全网通游戏手机'),
(null, 'huaweiNova', '/images/huaweiNova.jpg', 2999.00, '华为 HUAWEI nova 7 5G 6400万后置四摄 5G SoC芯片 OLED极点全面屏 8GB+128GB 绮境森林全网通5G手机'),
(null, 'huweiP30', '/images/huaweiP30.jpg', 4288.00, '华为 HUAWEI P30 Pro 超感光徕卡四摄10倍混合变焦麒麟980芯片屏内指纹 8GB+256GB极光色全网通版双4G手机'),
(null, 'huaweiP40', '/images/huaweiP40.jpg', 4488.00, '华为 HUAWEI P40 麒麟990 5G SoC芯片 5000万超感知徕卡三摄 30倍数字变焦 8GB+128GB晨曦金全网通5G手机'),
(null, 'onePlus8', '/images/onePlus8.jpg', 3999.00, '一加 OnePlus 8 5G旗舰 90Hz高清柔性屏 高通骁龙865 180g轻薄手感 12GB+256GB 青空 超清超广角拍照游戏手机'),
(null, 'redmiK30', '/images/redmiK30.jpg', 2699.00, 'Redmi K30 Pro 5G先锋 骁龙865旗舰处理器 弹出式超光感全面屏 索尼6400万高清四摄 4700mAh长续航 33W闪充 8GB+128GB 太空灰 游戏智能手机 小米 红米');
```
[phone数据](web/phone.html)

### 2. 导入Jar包
```
1. MySQL数据库驱动--msysql-connector-java-5.1.37-bin.jar
2. Druid数据库连接池--druid-1.1.21.jar
3. JSTL标准标签库--jstl.jar、standard.jar
```

### 3. 创建util包(用于durid初始化)
```java
package com.java.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName com.java.util.DruidUtil
 * @Description 数据库连接池工具类
 * @Date 2020/9/2 10:05
 */
public class DruidUtil {

    private static DataSource ds;
    //创建数据库连接池
    static {
        try {
            Properties ppt = new Properties();
            ppt.load(DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(ppt);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * @Description 从数据库连接池中获取一个连接
     * @Date 2020/9/2 11:11
     * @Param []
     * @return java.sql.Connection
     */
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * @Description 释放资源
     * @Date 2020/9/2 11:11
     * @Param []
     * @return void
     */
    public static void close(Connection conn, Statement state, ResultSet res) {
        try {
            conn.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        try {
            state.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        try {
            res.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
```

### 3. 创建Phone类,用于存储手机信息
### 4. 从数据库中获取手机信息
```java
public class PhoneServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Phone> phoneList = new ArrayList<>();
        //1. 从数据库连接池中获取一个连接
        Connection conn = DruidUtil.getConnection();
        //2. 创建SQL执行对象
        try {
            Statement state = conn.createStatement();
            ResultSet res = state.executeQuery("select * from phone");
            while (res.next()) {
                phoneList.add(new Phone(
                        res.getString("pname"),
                        res.getFloat("price"),
                        res.getString("pimg"),
                        res.getString("info")
                ));
            }
            res.close();
            state.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //将数据存储到request作用域转发给phone_list.jsp进行显示
        req.setAttribute("productList", phoneList);
        req.getRequestDispatcher("/phone_list.jsp").forward(req, resp);
    }
}
```
### 5. jsp
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品展示</title>
    <style>
        .list-box {
            position: absolute;
            left: 5%;
            width: 90%;
            height: 100%;
        }

        .phone-box {
            background: #fff;
            width: 220px;
            margin: 0;
            padding: 12px 9px;
            border: #fff 1px solid;
            display: inline-block;
        }

        .phone-box:hover {
            border: gray 1px solid;
        }

        .phone-img {
            margin: 0;
            position: relative;
            height: 220px;
            padding: 0;
            overflow: hidden;
        }

        .phone-info {
            height: 60px;
            margin-bottom: 8px;
            overflow: hidden;
            padding: 0;
        }

        .phone-price {
            position: relative;
            line-height: 22px;
            height: 22px;
            overflow: hidden;
            width: 100%;
            margin: 0 0 8px;
            padding: 0;
        }

        a:hover {
            color: red;
        }
    </style>
</head>
<body>
    <div class="list-box">
        <h1>精选手机</h1>
        <c:forEach items="${phoneList}" var="phone">
            <div class="phone-box">
                <div class="phone-img">
                    <img src="${phone.pimg}" alt="${phone.pname}" width="220px";
            height="220px">
                </div>
                <div class="phone-info">
                    <a href="" style="text-decoration:none">${phone.info}</a>
                </div>
                <div class="phone-price">
                    <span style="color: #FF0000">¥${phone.price}</span>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
```