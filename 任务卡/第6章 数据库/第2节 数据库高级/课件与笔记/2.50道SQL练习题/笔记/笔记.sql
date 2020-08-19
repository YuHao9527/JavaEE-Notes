1.查询" 01 "课程比" 02 "课程成绩高的学生的信息及课程分数


-- 1. 先分别查询01和02课程的学员id和分数
select sid,score from sc where cid = '01';
select sid,score from sc where cid = '02';

-- 对比两个结果，发现两个结果中有一些sid是不对应，
-- 因此可以对两个结果做join联结，条件是 sid要相等
-- 并且01的成绩要大于02的

select s1.sid,s1.score from
(select sid,score from sc where cid = '01') as s1
join
(select sid,score from sc where cid = '02') as s2
on s1.sid = s2.sid
where s1.score > s2.score;
+------+-------+
| sid  | score |
+------+-------+
| 02   |  70.0 |
| 04   |  50.0 |
+------+-------+


-- 通过以上的sql，得到了符合条件的学员id和分数，再联结学生表，获取学员信息
select stu.sid,stu.sname,s.score
from student as stu
join
（
   select s1.sid,s1.score from
    (select sid,score from sc where cid = '01') as s1
    join
    (select sid,score from sc where cid = '02') as s2
    on s1.sid = s2.sid
    where s1.score > s2.score
） as s
on stu.sid = s.sid;




2. 查询同时存在" 01 "课程和" 02 "课程的情况
select s1.* from
(select sid,score from sc where cid = '01') as s1
join
(select sid,score from sc where cid = '02') as s2
on s1.sid = s2.sid;
+------+-------+
| sid  | score |
+------+-------+
| 01   |  80.0 |
| 02   |  70.0 |
| 03   |  80.0 |
| 04   |  50.0 |
| 05   |  76.0 |
+------+-------+
5 rows in set (0.00 sec)


3.查询存在" 01 "课程但可能不存在" 02 "课程的情况(不存在时显示为 null )

select s1.*,s2.* from
(select sid,score from sc where cid = '01') as s1
left join
(select sid,score from sc where cid = '02') as s2
on s1.sid = s2.sid;

+------+-------+------+-------+
| sid  | score | sid  | score |
+------+-------+------+-------+
| 01   |  80.0 | 01   |  90.0 |
| 02   |  70.0 | 02   |  60.0 |
| 03   |  80.0 | 03   |  80.0 |
| 04   |  50.0 | 04   |  30.0 |
| 05   |  76.0 | 05   |  87.0 |
| 06   |  31.0 | NULL |  NULL |
+------+-------+------+-------+



4.查询不存在" 01 "课程但存在" 02 "课程的情况

select * from sc
where sid not in (select sid from sc where cid = '01')
and cid = '02'

+------+------+-------+
| SId  | CId  | score |
+------+------+-------+
| 07   | 02   |  89.0 |
+------+------+-------+


5.查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩

select sc.sid,sname,round(avg(score),2) as avg_score
from sc,student
where sc.sid = student.sid
group by sc.sid,sname having avg_score >= 60;

+------+--------+-----------+
| sid  | sname  | avg_score |
+------+--------+-----------+
| 01   | 赵雷   |     89.67 |
| 02   | 钱电   |     70.00 |
| 03   | 孙风   |     80.00 |
| 05   | 周梅   |     81.50 |
| 07   | 郑竹   |     93.50 |
+------+--------+-----------+


6.查询在 SC 表存在成绩的学生信息
-- distinct  去重


select distinct stu.* from student as stu join sc on stu.sid = sc.sid;

+------+--------+---------------------+------+
| SId  | Sname  | Sage                | Ssex |
+------+--------+---------------------+------+
| 01   | 赵雷   | 1990-01-01 00:00:00 | 男   |
| 02   | 钱电   | 1990-12-21 00:00:00 | 男   |
| 03   | 孙风   | 1990-12-20 00:00:00 | 男   |
| 04   | 李云   | 1990-12-06 00:00:00 | 男   |
| 05   | 周梅   | 1991-12-01 00:00:00 | 女   |
| 06   | 吴兰   | 1992-01-01 00:00:00 | 女   |
| 07   | 郑竹   | 1989-01-01 00:00:00 | 女   |
+------+--------+---------------------+------+


7.查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为 null )


select stu.sid,stu.sname,count(sc.cid) as total,sum(sc.score) as sum_score
from student as stu
left join sc on stu.sid = sc.sid
group by stu.sid,stu.sname;

+------+--------+-------+-----------+
| sid  | sname  | total | sum_score |
+------+--------+-------+-----------+
| 01   | 赵雷   |     3 |     269.0 |
| 02   | 钱电   |     3 |     210.0 |
| 03   | 孙风   |     3 |     240.0 |
| 04   | 李云   |     3 |     100.0 |
| 05   | 周梅   |     2 |     163.0 |
| 06   | 吴兰   |     2 |      65.0 |
| 07   | 郑竹   |     2 |     187.0 |
| 09   | 张三   |     0 |      NULL |
| 10   | 李四   |     0 |      NULL |
| 11   | 李四   |     0 |      NULL |
| 12   | 赵六   |     0 |      NULL |
| 13   | 孙七   |     0 |      NULL |
+------+--------+-------+-----------+



11.查询至少有一门课与学号为" 01 "的同学所学相同的同学的信息

select distinct stu.*
from student as stu
join sc on sc.sid = stu.sid
where sc.cid in (select cid from sc where sid = '01');

+------+--------+---------------------+------+
| SId  | Sname  | Sage                | Ssex |
+------+--------+---------------------+------+
| 01   | 赵雷   | 1990-01-01 00:00:00 | 男   |
| 02   | 钱电   | 1990-12-21 00:00:00 | 男   |
| 03   | 孙风   | 1990-12-20 00:00:00 | 男   |
| 04   | 李云   | 1990-12-06 00:00:00 | 男   |
| 05   | 周梅   | 1991-12-01 00:00:00 | 女   |
| 06   | 吴兰   | 1992-01-01 00:00:00 | 女   |
| 07   | 郑竹   | 1989-01-01 00:00:00 | 女   |
+------+--------+---------------------+------+
7 rows in set (0.00 sec)


12.查询和" 01 "号的同学学习的课程完全相同的其他同学的信息

select s2.sid,student.sname
from sc as s1
join sc as s2
on s1.cid = s2.cid and s1.sid = '01' and s2.sid != '01'
join student on s2.sid = student.sid
group by s2.sid,student.sname
having count(s2.cid) = (select count(*) from sc where sid = '01');

+------+--------+
| sid  | sname  |
+------+--------+
| 02   | 钱电   |
| 03   | 孙风   |
| 04   | 李云   |
+------+--------+









#### 关于sql_mode
> sql_mode是MySQL数据中的一个环境变量
> 定义了MySQL应该支持的sql语法,数据校验等


# 指定列分组,而不是用全部列
select stu.sid,stu.sname,count(sc.cid)
from student as stu
left join sc on sc.sid = stu.sid
group by stu.sid;

# ERROR 1055 (42000): Expression #2 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'chuange.stu.Sname' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by


#  标准的SQL
select stu.sid,stu.sname,count(sc.cid)
from student as stu
left join sc on sc.sid = stu.sid
group by stu.sid,stu.sname;


# 查看当前数据库中的sql_mode

select @@sql_mode;
+-------------------------------------------------------------------------------------------------------------------------------------------+
| @@sql_mode                                                                                                                                |
+-------------------------------------------------------------------------------------------------------------------------------------------+
| ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION |
+-------------------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)

ONLY_FULL_GROUP_BY
-- 针对grouo by 聚合操作,如果在select中的列,没有在group by中出现,那么将认为sql不合法



# 更改mysql数据库的sql_mode
1. 临时修改(服务器重启后失效)
set @@sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';


2. 修改mysql配置文件(重启后生效) my.cnf
在my.cnf的[mysqld]的下面去配置
[mysqld]
xxx = xxx
sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';



总结建议:
1. 建议开启,符合SQL标准
2. 在MySQL中有一个函数 any_value(filed),允许返回非分组字段(和关闭only_full_group_by模式相同)


使用 any_value 函数
select stu.sid,any_value(stu.sname),any_value(stu.sage),count(sc.cid)
from student as stu
left join sc on sc.sid = stu.sid
group by stu.sid;











14.查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩

select stu.sid,stu.sname,round(avg(sc.score),2) as avg_score
from student as stu
join sc on stu.sid = sc.sid
where sc.score < 60
group by stu.sid,stu.sname having count(sc.cid) >= 2;



15.检索" 01 "课程分数小于 60，按分数降序排列的学生信息

select sc.sid,stu.sname,sc.score
from sc join student as stu
on sc.sid = stu.sid
where sc.cid = '01' and sc.score < 60
order by sc.score desc;




16.按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩

select sc.*,s2.avg_score
from sc
join (select sid,avg(score) as avg_score from sc group by sid) as s2
on sc.sid = s2.sid
order by s2.avg_score desc,sc.sid;

+------+------+-------+-----------+
| SId  | CId  | score | avg_score |
+------+------+-------+-----------+
| 07   | 03   |  98.0 |  93.50000 |
| 07   | 02   |  89.0 |  93.50000 |
| 01   | 01   |  80.0 |  89.66667 |
| 01   | 02   |  90.0 |  89.66667 |
| 01   | 03   |  99.0 |  89.66667 |
| 05   | 01   |  76.0 |  81.50000 |
| 05   | 02   |  87.0 |  81.50000 |
| 03   | 03   |  80.0 |  80.00000 |
| 03   | 01   |  80.0 |  80.00000 |
| 03   | 02   |  80.0 |  80.00000 |
| 02   | 03   |  80.0 |  70.00000 |
| 02   | 01   |  70.0 |  70.00000 |
| 02   | 02   |  60.0 |  70.00000 |
| 04   | 02   |  30.0 |  33.33333 |
| 04   | 03   |  20.0 |  33.33333 |
| 04   | 01   |  50.0 |  33.33333 |
| 06   | 03   |  34.0 |  32.50000 |
| 06   | 01   |  31.0 |  32.50000 |
+------+------+-------+-----------+

select
stu.sname,
a.score as '语文',
b.score as '数学',
c.score as '英语',
avg(d.score) as '平均成绩'
from student as stu
left join sc as a on stu.sid = a.sid and a.cid = '01'
left join sc as b on stu.sid = b.sid and b.cid = '02'
left join sc as c on stu.sid = c.sid and c.cid = '03'
left join sc as d on stu.sid = d.sid
group by stu.sname,语文,数学,英语
order by 平均成绩 desc;

+--------+--------+--------+--------+--------------+
| sname  | 语文   | 数学    | 英语    |  平均成绩     |
+--------+--------+--------+--------+--------------+
| 郑竹   |   NULL |   89.0 |   98.0 |     93.50000 |
| 赵雷   |   80.0 |   90.0 |   99.0 |     89.66667 |
| 周梅   |   76.0 |   87.0 |   NULL |     81.50000 |
| 孙风   |   80.0 |   80.0 |   80.0 |     80.00000 |
| 钱电   |   70.0 |   60.0 |   80.0 |     70.00000 |
| 李云   |   50.0 |   30.0 |   20.0 |     33.33333 |
| 吴兰   |   31.0 |   NULL |   34.0 |     32.50000 |
| 孙七   |   NULL |   NULL |   NULL |         NULL |
| 李四   |   NULL |   NULL |   NULL |         NULL |
| 赵六   |   NULL |   NULL |   NULL |         NULL |
| 张三   |   NULL |   NULL |   NULL |         NULL |
+--------+--------+--------+--------+--------------+
11 rows in set (0.00 sec)









































17.查询各科成绩最高分、最低分和平均分：
以如下形式显示：课程 ID，课程 name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90
要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列


CASE WHEN sc.score >= 60 THEN 1 ELSE 0 END
相当于编程中 if
if  sc.score >= 60:
    return 1
else:
    return 0

select
sc.cid,
c.cname,
max(sc.score) as '最高分',
min(sc.score) as '最低分',
round(avg(sc.score),2) as '平均分',
count(sc.cid) as '选修人数',
sum(CASE WHEN sc.score >= 60 THEN 1 ELSE 0 END) / count(sc.cid) as '及格率',
sum(CASE WHEN sc.score >= 70 and sc.score < 80 THEN 1 ELSE 0 END) / count(sc.cid) as '中等率',
sum(CASE WHEN sc.score >= 80 and sc.score < 90 THEN 1 ELSE 0 END) / count(sc.cid) as '优良率',
sum(CASE WHEN sc.score >= 90 THEN 1 ELSE 0 END) / count(sc.cid) as '优秀率'
from sc join course as c on sc.cid = c.cid
group by sc.cid,c.cname
order by '选修人数' desc,sc.cid;

+------+--------+-----------+-----------+-----------+--------------+-----------+-----------+-----------+-----------+
| cid  | cname  | 最高分     | 最低分     | 平均分     | 选修人数      | 及格率     | 中等率     | 优良率      | 优秀率    |
+------+--------+-----------+-----------+-----------+--------------+-----------+-----------+-----------+-----------+
| 01   | 语文   |      80.0 |      31.0 |     64.50 |            6 |    0.6667 |    0.3333 |    0.3333 |    0.0000 |
| 02   | 数学   |      90.0 |      30.0 |     72.67 |            6 |    0.8333 |    0.0000 |    0.5000 |    0.1667 |
| 03   | 英语   |      99.0 |      20.0 |     68.50 |            6 |    0.6667 |    0.0000 |    0.3333 |    0.3333 |
+------+--------+-----------+-----------+-----------+--------------+-----------+-----------+-----------+-----------+
3 rows in set (0.00 sec)






18.按各科平均成绩进行排序，并显示排名， Score 重复时保留名次空缺


-- 按照各学科进行分组,计算平均成绩
select cid,round(avg(score),2) as avg_sc from sc group by cid;
+------+--------+
| cid  | avg_sc |
+------+--------+
| 01   |  64.50 |
| 02   |  72.67 |
| 03   |  68.50 |
+------+--------+

-- 按照各学科的平均成绩,做自联结,进行比较

mysql> select s1.* ,s2.*
    -> from
    -> (select cid,round(avg(score),2) as avg_sc from sc group by cid) as s1
    -> join
    -> (select cid,round(avg(score),2) as avg_sc from sc group by cid) as s2;
    +------+--------+------+--------+
    | cid  | avg_sc | cid  | avg_sc |
    +------+--------+------+--------+
    | 01   |  64.50 | 01   |  64.50 |
    | 02   |  72.67 | 01   |  64.50 |
    | 03   |  68.50 | 01   |  64.50 |
--  | 01   |  64.50 | 02   |  72.67 |
    | 02   |  72.67 | 02   |  72.67 |
--  | 03   |  68.50 | 02   |  72.67 |
--  | 01   |  64.50 | 03   |  68.50 |
    | 02   |  72.67 | 03   |  68.50 |
    | 03   |  68.50 | 03   |  68.50 |
+------+--------+------+--------+


select s1.* ,s2.*
from
(select cid,round(avg(score),2) as avg_sc from sc group by cid) as s1
join
(select cid,round(avg(score),2) as avg_sc from sc group by cid) as s2
on s1.avg_sc >= s2.avg_sc;

+------+--------+------+--------+
| cid  | avg_sc | cid  | avg_sc |
+------+--------+------+--------+
| 01   |  64.50 | 01   |  64.50 | 01
| 02   |  72.67 | 01   |  64.50 | 01
| 03   |  68.50 | 01   |  64.50 | 01
| 02   |  72.67 | 02   |  72.67 | 02
| 02   |  72.67 | 03   |  68.50 | 03
| 03   |  68.50 | 03   |  68.50 | 03
+------+--------+------+--------+
6 rows in set (0.00 sec)

-- 按照s2进行分组,统计s1的平均分出现的次数,
select s2.cid,s2.avg_sc,count(distinct s1.avg_sc) as rank
from
(select cid,round(avg(score),2) as avg_sc from sc group by cid) as s1
join
(select cid,round(avg(score),2) as avg_sc from sc group by cid) as s2
on s1.avg_sc >= s2.avg_sc
group by s2.cid,s2.avg_sc
order by rank
+------+--------+------+
| cid  | avg_sc | rank |
+------+--------+------+
| 02   |  72.67 |    1 |
| 03   |  68.50 |    2 |
| 01   |  64.50 |    3 |
+------+--------+------+


-- 当修改完数据之后
update sc set score = 104.0 where sid = 01 and cid = 01;
insert into sc values('07','04',62.0);

----
+------+--------+------+
| cid  | avg_sc | rank |
+------+--------+------+
| 02   |  72.67 |    1 |
| 01   |  68.50 |    2 |
| 03   |  68.50 |    2 |
| 04   |  62.00 |    3 |
+------+--------+------+



19.按各科平均成绩进行排序，并显示排名， Score 重复时不保留名次空缺



select cid,round(avg(score),2) as avg_sc from sc group by cid order by avg_sc desc;
+------+--------+
| cid  | avg_sc |
+------+--------+
| 02   |  72.67 |
| 03   |  68.50 |
| 01   |  64.50 |
+------+--------+

-- @i 是sql中定义变量的意思
select b.cid,b.avg_sc,@i := @i+1 as rank
from (select @i := 0) as a,
(select cid,round(avg(score),2) as avg_sc from sc group by cid order by avg_sc desc) as b;

-- 同上一题,修改完数据后
+------+--------+------+
| cid  | avg_sc | rank |
+------+--------+------+
| 02   |  72.67 |    1 |
| 01   |  68.50 |    2 |
| 03   |  68.50 |    3 |
| 04   |  62.00 |    4 |
+------+--------+------+
4 rows in set (0.00 sec)








