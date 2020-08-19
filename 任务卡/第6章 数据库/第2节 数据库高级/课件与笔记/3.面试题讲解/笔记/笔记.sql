1. 用一条SQL语句查询出每门课都大于80分的学生姓名

+--------+--------+-------+
| name   | course | score |
+--------+--------+-------+
| 张三   | 语文   |    81 |
| 张三   | 数学   |    75 |
| 李四   | 语文   |    76 |
| 李四   | 数学   |    90 |
| 王五   | 语文   |    81 |
| 王五   | 数学   |   100 |
| 王五   | 英语   |    90 |
+--------+--------+-------+
7 rows in set (0.00 sec)

-- 先根据学员进行分组,看每个人的最低分
select name,min(score) from mst_stu group by name;
+--------+------------+
| name   | min(score) |
+--------+------------+
| 张三   |         75 |
| 李四   |         76 |
| 王五   |         81 |
+--------+------------+

-- 在使用分组过滤 having 筛选出最低分大于80
select name,min(score) as min_sc from mst_stu group by name having min_sc > 80;


-- 最终只需要符合要求的学员姓名
select min(score) as min_sc from mst_stu group by name having min_sc > 80;









2. 查询后一天 temperature 比前一天高的date
    比昨天温度高的ID

select * from mst_weather;
+----+------------+-------------+
| id | date       | temperature |
+----+------------+-------------+
|  1 | 2022-04-01 |          20 |
|  2 | 2022-04-02 |          25 |
|  3 | 2022-04-03 |          21 |
|  4 | 2022-04-04 |          24 |
+----+------------+-------------+

select s1.*,s2.*
from mst_weather as s1
join mst_weather as s2


+----+------------+-------------+----+------------+-------------+
| id | date       | temperature | id | date       | temperature |
+----+------------+-------------+----+------------+-------------+
-- |  1 | 2022-04-01 |          20 |  1 | 2022-04-01 |          20 |
|  2 | 2022-04-02 |          25 |  1 | 2022-04-01 |          20 |
-- |  3 | 2022-04-03 |          21 |  1 | 2022-04-01 |          20 |
-- |  4 | 2022-04-04 |          24 |  1 | 2022-04-01 |          20 |
-- |  1 | 2022-04-01 |          20 |  2 | 2022-04-02 |          25 |
-- |  2 | 2022-04-02 |          25 |  2 | 2022-04-02 |          25 |
-- |  3 | 2022-04-03 |          21 |  2 | 2022-04-02 |          25 |
-- |  4 | 2022-04-04 |          24 |  2 | 2022-04-02 |          25 |
-- |  1 | 2022-04-01 |          20 |  3 | 2022-04-03 |          21 |
-- |  2 | 2022-04-02 |          25 |  3 | 2022-04-03 |          21 |
-- |  3 | 2022-04-03 |          21 |  3 | 2022-04-03 |          21 |
|  4 | 2022-04-04 |          24 |  3 | 2022-04-03 |          21 |
-- |  1 | 2022-04-01 |          20 |  4 | 2022-04-04 |          24 |
-- |  2 | 2022-04-02 |          25 |  4 | 2022-04-04 |          24 |
-- |  3 | 2022-04-03 |          21 |  4 | 2022-04-04 |          24 |
-- |  4 | 2022-04-04 |          24 |  4 | 2022-04-04 |          24 |
+----+------------+-------------+----+------------+-------------+
16 rows in set (0.00 sec)

select s1.id
from mst_weather as s1
join mst_weather as s2
on datediff(s1.date,s2.date) = 1
and s1.temperature > s2.temperature;

+----+
| id |
+----+
|  2 |
|  4 |
+----+
2 rows in set (0.00 sec)





3. 查询每个主播的最大level以及对应的最小gap(注意:不是每个主播的最大level和最小gap)

select * from mst_zhubo;
+----------+-------+------+
| zhubo_id | level | gap  |
+----------+-------+------+
|      123 |     8 |   20 |
|      123 |     9 |   40 |
|      123 |     9 |   30 |
|      246 |     6 |   30 |
|      246 |     6 |   20 |
+----------+-------+------+
5 rows in set (0.00 sec)


-- 先查询每个主播的最大 level
select zhubo_id,max(level) from mst_zhubo group by zhubo_id;
+----------+------------+
| zhubo_id | max(level) |
+----------+------------+
|      123 |          9 |
|      246 |          6 |
+----------+------------+
2 rows in set (0.00 sec)

--在这个基础上,查询出每个主播所有符合最大level的数据

select * from mst_zhubo where (zhubo_id,level) in (select zhubo_id,max(level) from mst_zhubo group by zhubo_id)

+----------+-------+------+
| zhubo_id | level | gap  |
+----------+-------+------+
|      123 |     9 |   40 |
|      123 |     9 |   30 |
|      246 |     6 |   30 |
|      246 |     6 |   20 |
+----------+-------+------+
4 rows in set (0.01 sec)

-- 在这个基础上,按照主播分组,求最小的gap
select zhubo_id,level,min(gap)
from mst_zhubo where (zhubo_id,level) in (select zhubo_id,max(level) from mst_zhubo group by zhubo_id)
group by zhubo_id,level;

+----------+-------+----------+
| zhubo_id | level | min(gap) |
+----------+-------+----------+
|      123 |     9 |       30 |
|      246 |     6 |       20 |
+----------+-------+----------+
2 rows in set (0.01 sec)


4. 下表是每个课程class_id对应的年级(共有primary、middle、high三个),以及某种比率rate



mysql> select * from mst_class;
+----------+---------+------+
| class_id | grade   | rate |
+----------+---------+------+
| abc123   | primary | 70%  |
| abc123   | middle  | 65%  |
| abc123   | high    | 72%  |
| hjkk86   | primary | 69%  |
| hjkk86   | middle  | 63%  |
| hjkk86   | high    | 74%  |
+----------+---------+------+

select class_id,
max(CASE WHEN grade = 'primary' THEN rate ELSE 0 END) as 'primary',
max(CASE WHEN grade = 'middle' THEN rate ELSE 0 END) as 'middle',
max(CASE WHEN grade = 'high' THEN rate ELSE 0 END) as 'high'
from mst_class
group by class_id;

+----------+---------+--------+------+
| class_id | primary | middle | high |
+----------+---------+--------+------+
| abc123   | 70%     | 65%    | 72%  |
| hjkk86   | 69%     | 63%    | 74%  |
+----------+---------+--------+------+
2 rows in set (0.01 sec)

-- 使用IF()
select class_id,
max(IF(grade = 'primary',rate,0)) as 'primary',
max(IF(grade = 'middle',rate,0)) as 'middle',
max(IF(grade = 'high',rate,0)) as 'high'
from mst_class
group by class_id;





5.有两个表A和B，均有key和value两个字段，如果B的key在A中也有，就把B的value换为A中对应的value

这道题的SQL语句怎么写？

-- 先按照题设计表
create table `mst_a`(`key` varchar(10),`value` varchar(10));
create table `mst_b`(`key` varchar(10),`value` varchar(10));
insert into mst_a values('A','aaa'),('B','bbb'),('C','ccc');
insert into mst_b values('D','ddd'),('E','eee'),('A','abc');

mysql> select * from mst_a;
+------+-------+
| key  | value |
+------+-------+
| A    | aaa   |
| B    | bbb   |
| C    | ccc   |
+------+-------+
3 rows in set (0.00 sec)

mysql> select * from mst_b;
+------+-------+
| key  | value |
+------+-------+
| D    | ddd   |
| E    | eee   |
| A    | abc   |
+------+-------+
3 rows in set (0.00 sec)


-- 先查询出哪个key符合要求?
select mst_a.key,mst_a.value from mst_a join mst_b on mst_a.key = mst_b.key;

-- update mst_b set value = ? where key = ?
-- update mst_b as up ,(?) as b set up.value = ? where up.key = ?

update mst_b as up,(
    select mst_a.key,mst_a.value from mst_a join mst_b on mst_a.key = mst_b.key
    ) as b
set up.value = b.value where up.key = b.key


-- 注意事项
-- update 后面是可以进行任何查询语句,这个作用等同于 from
-- update 更新表,不能在set和where中用于子查询
-- update 也可以对多个表进行更新 (sqlserver不行)





















































