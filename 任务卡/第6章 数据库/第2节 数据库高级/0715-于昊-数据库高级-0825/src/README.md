## 财务管理系统-数据库模块

### 创建数据库和数据表

```mysql
# 1. 创建财务数据库
mysql> create database if not exists financial default charset=utf8mb4;
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| demo               |
| financial          | <----
| mysql              |
| performance_schema |
| students           |
| sys                |
+--------------------+

# 创建数据表

# 创建一个雇员表 employee
create table employee(
-- 创建ID字段，为正整数，不允许为空 主键，自动递增
empid int unsigned not null primary key auto_increment,
-- 创建姓名字段，为字符串类型，最大长度 5个字符，不允许为空
ename varchar(5) not null,
-- 创建性别字段，不允许为空，默认为男
sex char(1) not null default '男',
-- 创建职称字段
title varchar(8),
-- 创建出生日期字段
birthday date not null,
-- 创建所属部门字段
depid int unsigned not null
)engine=innodb default charset=utf8mb4;
+----------+------------------+------+-----+---------+----------------+
| Field    | Type             | Null | Key | Default | Extra          |
+----------+------------------+------+-----+---------+----------------+
| empid    | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| ename     | varchar(5)       | NO   |     | NULL    |                |
| sex      | char(1)          | NO   |     | 男      |                |
| title    | varchar(8)       | YES  |     | NULL    |                |
| birthday | date             | NO   |     | NULL    |                |
| depid    | int(10) unsigned | NO   |     | NULL    |                |
+----------+------------------+------+-----+---------+----------------+

# 创建一个部门表 department
create table department(
-- 创建ID字段，为正整数，不允许为空 主键，自动递增
depid int unsigned not null primary key auto_increment,
-- 创建部门名称字段
depname varchar(8)
)engine=innodb default charset=utf8mb4;
+---------+------------------+------+-----+---------+----------------+
| Field   | Type             | Null | Key | Default | Extra          |
+---------+------------------+------+-----+---------+----------------+
| depid   | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| depname | varchar(8)       | YES  |     | NULL    |                |
+---------+------------------+------+-----+---------+----------------+

# 创建一个工资表 salary
create table salary(
-- 创建雇员编号字段
empid int unsigned not null,
-- 创建基本工资字段
basesalary int not null default 0,
-- 创建职务工资字段
titlesalary int not null default 0,
-- 创建扣除字段
deduction int not null default 0
)engine=innodb default charset=utf8mb4;
+-------------+------------------+------+-----+---------+-------+
| Field       | Type             | Null | Key | Default | Extra |
+-------------+------------------+------+-----+---------+-------+
| empid       | int(10) unsigned | NO   |     | NULL    |       |
| basesalary  | int(11)          | NO   |     | 0       |       |
| titlesalary | int(11)          | NO   |     | 0       |       |
| deduction   | int(11)          | NO   |     | 0       |       |
+-------------+------------------+------+-----+---------+-------+
```

### 需求

1. 修改表结构，在部门表中添加部门简介字段

   ```mysql
   mysql> alter table department add info varchar(50);
   +---------+------------------+------+-----+---------+----------------+
   | Field   | Type             | Null | Key | Default | Extra          |
   +---------+------------------+------+-----+---------+----------------+
   | depid   | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
   | depname | varchar(8)       | YES  |     | NULL    |                |
   | info    | varchar(50)      | YES  |     | NULL    |                |<-------
   +---------+------------------+------+-----+---------+----------------+
   ```


2. 将李四的职称改为“工程师”，并将她的基本工资改成2000，职务工资为700

   ```mysql
   UPDATE employee AS e,
   salary AS s 
   SET title = '工程师',
   basesalary = 2000,
   titlesalary = 700 
   WHERE
   	e.ename = '李四' 
   	AND e.empid = s.empid;
   ```

3. 删除人事部门的部门记录

   ```mysql
   delete from department where depname='人事';
   ```

4. 查询出每个雇员的雇员编号，实发工资，应发工资

   ```mysql
   select e.empid,basesalary + titlesalary - deduction as '实发工资',basesalary + titlesalary as '应发工资'
   from employee as e
   inner join salary as s on s.empid=e.empid;
   ```

5. 查询姓张且年龄小于40的员工记录

   ```mysql
   select e.*
   from employee as e
   where ename like '张%'
   and TIMESTAMPDIFF(YEAR, e.birthday, CURDATE()) < 40;
   -- TIMESTAMPDIFF(YEAR, e.birthday, CURDATE()) 通过调用curdate获取当前时间然后比较出生日期通过timestampdiff计算差值，YEAR表名差值为年份的差值即年龄。
   ```

6. 查询雇员的雇员编号，姓名，职称，部门名称，实发工资

   ```mysql
   select e.empid,ename as '姓名',title as '职称',d.depname as '部门名称',basesalary + titlesalary - deduction as '实发工资'
   from employee as e
   inner join salary as s on s.empid=e.empid
   inner join department as d on e.depid=d.depid;
   ```

7. 查询销售部门的雇员姓名，工资

   ```mysql
   select ename as '姓名',basesalary + titlesalary as '工资'
   from employee as e
   inner join salary as s on s.empid=e.empid
   inner join department as d on e.depid=d.depid
   where depname='销售';
   ```

8. 统计各职称的人数

   ```mysql
   select title,count(*) as num
   from employee
   group by title;
   ```

9. 统计各部门的部门名称，实发工资总和，平均工资

   ```mysql
   select depname,sum(basesalary + titlesalary - deduction) as '实发工资总和',round(avg(basesalary + titlesalary - deduction), 2) as '平均工资'
   from salary as s
   inner join employee as e on e.empid=s.empid
   inner join department as d on d.depid=e.depid
   group by depname;
   ```

10. 查询比销售部门所有员工基本工资都高的雇员姓名

    ```mysql
    select ename
    from employee as e
    inner join salary as s on s.empid=e.empid
    inner join (
    select max(basesalary) as maxSalary
    from salary as s2
    inner join employee as e2
    on s2.empid=e2.empid
    inner join department as d2 on d2.depid=e2.depid
    where d2.depname='销售'
    ) as m
    where basesalary > maxSalary and e.depid!=2;
    ```