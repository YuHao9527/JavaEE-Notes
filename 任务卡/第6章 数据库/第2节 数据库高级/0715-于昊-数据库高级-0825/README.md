## 数据库高级

### 子查询与表联结

#### 子查询(Sql嵌套)

> SELECT语句是SQL的查询语句。之前数据基础操作我们所看到的所有一条SELECT语句都是简单查询，即从单个数据库表中检索数据的单条语句。
> SQL还允许创建子查询（subquery），即嵌套在其他查询中的查询。

##### 利用子查询进行过滤

```mysql
案例：订单查询
订单信息存储在三个表中：
表1：orders 存储订单信息，包括订单号、客户id、订单日期等
	+-----------+---------------------+---------+
    | order_num | order_date          | cust_id |
    +-----------+---------------------+---------+
    |     20005 | 2005-09-01 00:00:00 |   10001 |
    |     20006 | 2005-09-12 00:00:00 |   10003 |
    |     20007 | 2005-09-30 00:00:00 |   10004 |
    |     20008 | 2005-10-03 00:00:00 |   10005 |
    |     20009 | 2005-10-08 00:00:00 |   10001 |
    +-----------+---------------------+---------+
表2：orderitems 存储订单物品信息
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
表3：customers 存储客户信息
	只显示cust_id,cust_name
    +---------+----------------+
    | cust_id | cust_name      |
    +---------+----------------+
    |   10001 | Coyote Inc.    |
    |   10002 | Mouse House    |
    |   10003 | Wascals        |
    |   10004 | Yosemite Place |
    |   10005 | E Fudd         |
    +---------+----------------+
假如需要列出订购物品desk2的所有客户，之前的单表查询显然无法完成，那应该怎么检索？

-- 1. 首先我们可以先检索包含desk2的所有订单的编号。
select order_num from orderitems where prod_id='TNT2';
-- 2. 检索具有前一步骤列出的订单编号的所有客户的ID
select cust_id from orders where order_num IN (20005,20007);
-- 3. 检索前一步骤返回的所有客户ID的客户信息
select cust_name,cust_contact from customers where cust_id in (10001,10004);
上面这些sql查询都是单表查询，可以把其中的where子句转换为子查询
select cust_name,cust_contact
from customers
where cust_id in (
select cust_id
from orders
where order_num IN (select order_num
from orderitems
where prod_id = 'TNT2'));
-- 为了执行上述SELECT语句，MySQL实际上必须执行3条SELECT语句。
-- 最里边的子查询返回订单号列列表，此列表用于其外面的子查询的WHERE子句。
-- 外面的子查询返回客户ID列表，此客户ID列表用于最外层查询的WHERE子句。
-- 最外层查询确实返回所需的数据。
```

##### 作为计算字段使用子查询

> 使用子查询的另一个方法是创建计算字段

```mysql
-- 假如需要显示customers表中每个客户的订单总数。订单与相应的客户ID存储在orders表中。

-- 1. 从customers表中检索客户列表
select cust_id,cust_name from customers;
-- 2. 对于检索出每个客户，统计其在orders表中的订单数目
select count(*) as orders from orders where cust_id = 10001;
-- 为了对每个客户执COUNT()计算，应该将COUNT()作为一个子查询
select cust_id,cust_name,
 (select count(*)
 from orders
 where orders.cust_id = customers.cust_id) as orders
 )
from customers
order by cust_name;
```

> orders是一个计算字段，它是由圆括号中的子查询建立的。该子查询对检索出的每个客户执行一次。在此例子中，该子查询执行了5次，因为检索出了5个客户。
>
> > 注意:子查询中的WHERE子句与前面使用的WHERE子句稍有不同，因为它使用了完全限定列名，这种类型的子查询称为相关子查询。任何时候只要列名可能有多义性，就必须使用这种语法（表名和列名由一个句点分隔）。因为有两个cust_id列，一个在customers中，另一个在orders中，需要比较这两个列以正确地把订单与它们相应的顾客匹配。如果不完全限定列名，MySQL将假定你是对orders表中的cust_id进行自身比较。

#### 关系表