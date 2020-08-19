--（1） 查询包含物品TNT2的所有订单编号
select order_num from orderitems where prod_id = 'TNT2';
+-----------+
| order_num |
+-----------+
|     20005 |
|     20007 |
+-----------+

-- (2) 查询对应订单编号的用户ID
select cust_id from orders where order_num in(20005,20007);
+---------+
| cust_id |
+---------+
|   10001 |
|   10004 |
+---------+

-- (3) 查询购买对应物品的用户信息
select cust_id,cust_name from customers where cust_id in(10001,10004);

+---------+----------------+
| cust_id | cust_name      |
+---------+----------------+
|   10001 | Coyote Inc.    |
|   10004 | Yosemite Place |
+---------+----------------+


-- 转换为嵌套SQL，子查询
SELECT cust_id, cust_name
FROM customers
WHERE cust_id IN (
    SELECT cust_id
    FROM orders
    WHERE order_num IN (
        SELECT order_num FROM orderitems WHERE prod_id = 'TNT2' )
    );

-- 什么是嵌套查询，子查询
就是在一个sql当中，它的where条件来源于另外一个sql，
或者反过来理解，一个sql语句的结果，作为外层sql语句的条件。







-- 作为计算字段使用子查询

-- 需要获取customers表中每个用户的订单总数

-- 1.从customers表中获取用户列表

select cust_id,cust_name from customers;
+---------+----------------+
| cust_id | cust_name      |
+---------+----------------+
|   10001 | Coyote Inc.    |
|   10002 | Mouse House    |
|   10003 | Wascals        |
|   10004 | Yosemite Place |
|   10005 | E Fudd         |
+---------+----------------+

-- 2.先获取一个用户在orders表中的订单数
select count(*) as orders_num from orders where cust_id = 10001;
+------------+
| orders_num |
+------------+
|          2 |
+------------+

-- 3.考虑如何获取每个客户的订单数，对每个客户进行count函数的统计计算
-- 把count()作为一个子查询
select cust_id,cust_name,
    (select count(*) from orders where orders.cust_id = customers.cust_id) as orders_num
from customers;

+---------+----------------+------------+
| cust_id | cust_name      | orders_num |
+---------+----------------+------------+
|   10001 | Coyote Inc.    |          2 |
|   10002 | Mouse House    |          0 |
|   10003 | Wascals        |          1 |
|   10004 | Yosemite Place |          1 |
|   10005 | E Fudd         |          1 |
+---------+----------------+------------+




### 关系表

> SQL最强大的功能之一就是能在数据检索查询的执行中联结（join）表。
>
> 在能够有效地使用联结前，必须了解关系表以及关系数据库设计的一些基础知识。



表关系：表与表之间的关系



外键：
    在一个表中，定义一个字段，这个字段中存储的数据是另外一张表中的主键
    就是在一个表中的字段，代表着这个数据属于谁

    了解：
        外键实现的方式，有两种：物理外键、逻辑外键
        物理外键：
            就是在创建表时，就指定这个表中的字段是一个外键，并且强关联某个表中的某个字段
            需要在定义字段时，使用sql语句来实现
        逻辑外键：
            就是在表中创建一个普通的字段，没有强关联关系，需要通过程序逻辑来实现

一对一
    就是在一个表中的数据，对应着另外一张表中的一个数据，只能有一个
    员工表：
        id，姓名、性别、年龄、籍贯、联系方式、学历、工龄、。。。。

    由上面的一个表，拆分成两个表

    员工表：
        id，姓名、联系方式、工龄、
        12  张三  1010    3
        13  李四  1020    2

    详情表：
       yid 性别、籍贯、学历、、、、、
        12    男    山东 本科
        13    男    山西 本科


    上面的表关系就是一对一的表关系，通过详情表中的yid这个字段来标记员工表中的主键。
    一个员工有着一个对应的详情信息，存储在详情表中，
    在详情表中的数据，也只属于某一个员工。





一对多
    在一个表中的一条数据对应着另外一个表中的多条数据
    在一个表中的多条数据，对应着另外一张表中一个数据

    商品分类
        id 分类名
        1  手机
        2  电脑

    商品
        id 所属分类id，商品名
        1  1         小米手机
        2  1         华为手机

    新闻分类
        id   分类名
        1    体育
        2    国际


    新闻
        id  title             分类id
        1   国足加油              1
        2   特朗普加油            2
        3   特朗普被网民称为特没谱  2

mysql> select * from orders;
+-----------+---------------------+---------+
| order_num | order_date          | cust_id |
+-----------+---------------------+---------+
|     20005 | 2005-09-01 00:00:00 |   10001 |
|     20006 | 2005-09-12 00:00:00 |   10003 |
|     20007 | 2005-09-30 00:00:00 |   10004 |
|     20008 | 2005-10-03 00:00:00 |   10005 |
|     20009 | 2005-10-08 00:00:00 |   10001 |
+-----------+---------------------+---------+
5 rows in set (0.00 sec)


mysql> select * from orderitems;
+-----------+------------+---------+----------+------------+
| order_num | order_item | prod_id | quantity | item_price |
+-----------+------------+---------+----------+------------+
|     20005 |          1 | ANV01   |       10 |       5.99 |
|     20005 |          2 | ANV02   |        3 |       9.99 |
|     20005 |          3 | TNT2    |        5 |      10.00 |
|     20005 |          4 | FB      |        1 |      10.00 |
|     20006 |          1 | JP2000  |        1 |      55.00 |
|     20007 |          1 | TNT2    |      100 |      10.00 |
|     20008 |          1 | FC      |       50 |       2.50 |
|     20009 |          1 | FB      |        1 |      10.00 |
|     20009 |          2 | OL1     |        1 |       8.99 |
|     20009 |          3 | SLING   |        1 |       4.49 |
|     20009 |          4 | ANV03   |        1 |      14.99 |
+-----------+------------+---------+----------+------------+
11 rows in set (0.01 sec)





多对多
    举例：
        例如一本书，有多个标签，同时每一个标签下又对应多本书

    books 图书
    id  name          author
    1   <跟川哥学编程>    川哥
    2   <跟川哥学数据分析> 川哥
    3   <川哥讲法律故事>   川哥

    tags 标签
    id   name
    1    编程
    2    计算机
    3    互联网
    4    法律
    5    文学

    从图书角度看，一本书有多个标签
    1   <跟川哥学编程>    川哥   ， 编程、计算机、互联网
    2   <跟川哥学数据分析> 川哥  ，  互联网、计算机
    3   <川哥讲法律故事>   川哥 ，  法律

    换一个角度，从标签这个角度看，一个标签包含多个图书
    计算机， <跟川哥学编程>， <跟川哥学数据分析>


    案例二：
        一个班级有多个老师来讲课（化学、物理、数学、、、）
        一个老师要带多个班级   （一班，二班，三班）



表联结
    就是一种查询的机制，用来在一个select语句中关联多个表进行查询，称为联结

需要查询出所有商品以及对应的供应商信息？
供应商名称，商品名称，商品价格

select vend_name,prod_name,prod_price
from vendors,products
where vendors.vend_id  = products.vend_id
order by vend_name

+-------------+----------------+------------+
| vend_name   | prod_name      | prod_price |
+-------------+----------------+------------+
| ACME        | Sling          |       4.49 |
| ACME        | Carrots        |       2.50 |
| ACME        | Safe           |      50.00 |
| ACME        | Bird seed      |      10.00 |
| ACME        | Detonator      |      13.00 |
| ACME        | TNT (5 sticks) |      10.00 |
| ACME        | TNT (1 stick)  |       2.50 |
| Anvils R Us | .5 ton anvil   |       5.99 |
| Anvils R Us | 2 ton anvil    |      14.99 |
| Anvils R Us | 1 ton anvil    |       9.99 |
| Jet Set     | JetPack 2000   |      55.00 |
| Jet Set     | JetPack 1000   |      35.00 |
| LT Supplies | Fuses          |       3.42 |
| LT Supplies | Oil can        |       8.99 |
+-------------+----------------+------------+
14 rows in set (0.01 sec)

假如没有where条件时会发生什么呢？
select vend_name,prod_name,prod_price
from vendors,products;

如果没有where条件，那么第一个表中的每一行数据会与第二个表中的每一行数据进行匹配，不管逻辑是否可以匹配
如果没有where条件，那么这种结果称为 笛卡尔积，第一个表的行数乘以第二个表中的行数。

所以千万不要忘记where条件！！！


除了使用where进行表的联结查询外，还可以使用另外一种联结方式，join

select vend_name,prod_name,prod_price
from vendors
inner join products on vendors.vend_id = products.vend_id;

上面这个sql就是使用了 join 的语法，进行了两个表的联结，在 on 后面 去定义了 联结的条件。



联结多个表

案例： 查询出订单号为20005的订单中购买的商品及对应的产品供应商信息

select prod_name,vend_name,prod_price,quantity
from orderitems,products,vendors
    where products.vend_id = vendors.vend_id
    and orderitems.prod_id = products.prod_id
    and order_num = 20005;


改写为 join 的语法

select prod_name,vend_name,prod_price,quantity
from orderitems
inner join products on orderitems.prod_id = products.prod_id
inner join vendors on products.vend_id = vendors.vend_id
where order_num = 20005;



自联结

自联结:当前这个表与自己这个表 做联结（join）

假如你发现某物品（其ID为DTNTR）存在问题，因此想知道生产该物品的供应商生产的其他物品是否也存在这些问题。
此查询要求首先找到生产ID为DTNTR的物品的供应商，然后找出这个供应商生产的其他物品。

-- 使用子查询（嵌套查询）
select prod_id,prod_name
from products
where vend_id = (select vend_id from products where prod_id = 'DTNTR');
+---------+----------------+
| prod_id | prod_name      |
+---------+----------------+
| DTNTR   | Detonator      |
| FB      | Bird seed      |
| FC      | Carrots        |
| SAFE    | Safe           |
| SLING   | Sling          |
| TNT1    | TNT (1 stick)  |
| TNT2    | TNT (5 sticks) |
+---------+----------------+

-- 使用 自联结方式查询
select p1.prod_id,p2.prod_name
from products as p1
join products as p2 on p1.vend_id = p2.vend_id
where p2.prod_id = 'DTNTR';

-- 改成where语句
select p1.prod_id,p2.prod_name
from products as p1, products as p2
where p1.vend_id = p2.vend_id and p2.prod_id = 'DTNTR';

+---------+-----------+
| prod_id | prod_name |
+---------+-----------+
| DTNTR   | Detonator |
| FB      | Detonator |
| FC      | Detonator |
| SAFE    | Detonator |
| SLING   | Detonator |
| TNT1    | Detonator |
| TNT2    | Detonator |
+---------+-----------+



-- 深入了解 join
select
p1.prod_id,p1.prod_name,p1.vend_id,
p2.prod_id,p2.prod_name,p2.vend_id
from products as p1,products as p2
where p1.vend_id = p2.vend_id
and p2.prod_id = 'DTNTR';


子查询（嵌套查询） 是目前可明确知道的 sql中运行效率最低的一种方式，尽可能不使用嵌套语句。


外部连接

# 使用 where 进行关联查询 （内部联结） 只能对两个表中相关联的数据进行查询
select customers.cust_id,orders.order_num from customers,orders where orders.cust_id = customers.cust_id;

select customers.cust_id,orders.order_num
from customers join orders
on orders.cust_id = customers.cust_id;

+---------+-----------+
| cust_id | order_num |
+---------+-----------+
|   10001 |     20005 |
|   10001 |     20009 |
|   10003 |     20006 |
|   10004 |     20007 |
|   10005 |     20008 |
+---------+-----------+
5 rows in set (0.00 sec)

# 查看所有用户
select  cust_id from customers;
| cust_id |
+---------+
|   10001 |
|   10002 |
|   10003 |
|   10004 |
|   10005 |
+---------+
5 rows in set (0.00 sec)

# 那什么是外部联结呢？
left join ： 是以 left join 左侧表为基准，去关联右侧的表进行联结，如果有未关联的数据，那么结果为null
right join ：是以 right join 右侧表为基准，去关联左侧的表进行联结，如果有未关联的数据，那么结果为null


以用户表为基准，去关联查询 订单表数据
select customers.cust_id,orders.order_num
from customers left join orders
on customers.cust_id = orders.cust_id;


select customers.cust_id,orders.order_num
from orders right join customers
on customers.cust_id = orders.cust_id;


# 对每个客户下了多少订单进行计数，包括那些至今尚未下订单的客户；

select customers.cust_id,count(orders.order_num) as nums
from customers left join orders
on customers.cust_id = orders.cust_id
group by customers.cust_id;

+---------+------+
| cust_id | nums |
+---------+------+
|   10001 |    2 |
|   10002 |    0 |
|   10003 |    1 |
|   10004 |    1 |
|   10005 |    1 |
+---------+------+



总结：

表联结

内部联结： where， inner join(join)
自联结 :  是在一个sql中，用当前这个表，连接自己这个表进行关联查询
外部联结： left join，right join


练习题：
列出所有产品以及订购数量，包括没有人订购的产品；










