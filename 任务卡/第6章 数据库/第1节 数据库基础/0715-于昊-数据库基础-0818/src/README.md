## 学生管理系统-数据库模块

### 创建数据库和数据表

```mysql
# 创建学生数据库
mysql> create database if not exists students default charset=utf8mb4;
Query OK, 1 row affected (0.07 sec)

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| demo               |
| mysql              |
| performance_schema |
| students           |
| sys                |
+--------------------+
6 rows in set (0.00 sec)

# 创建数据表
# 创建一个年级表 grade
create table grade(
-- 创建ID字段，为正整数，不允许为空 主键，自动递增
id int unsigned not null primary key auto_increment,
-- 创建年级名称的字段，为字符串类型，最大长度 5个字符，不允许为空
gradename varchar(5) not null
)engine=innodb default charset=utf8mb4;
mysql> desc grade;
+-----------+------------------+------+-----+---------+----------------+
| Field     | Type             | Null | Key | Default | Extra          |
+-----------+------------------+------+-----+---------+----------------+
| id        | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| gradename | varchar(5)       | NO   |     | NULL    |                |
+-----------+------------------+------+-----+---------+----------------+

# 创建一个成绩表 achievement
create table achievement(
-- 创建ID字段，为正整数，不允许为空 主键，自动递增
id int unsigned not null primary key auto_increment,
-- 创建学员编号字段，为正整数，不允许为空
stuId int unsigned not null,
-- 创建科目id字段，为正整数，不允许为空
subjectId int unsigned not null,
-- 创建分数字段, 为正整数，不能为空，默认值为0
score int unsigned not null default 0,
-- 创建考试时间字段, 为年月日时分秒，不能为空，默认值为系统时间
examinationTime datetime not null default CURRENT_TIMESTAMP
)engine=innodb default charset=utf8mb4;
mysql> desc achievement;
+-----------------+------------------+------+-----+-------------------+----------------+
| Field           | Type             | Null | Key | Default           | Extra          |
+-----------------+------------------+------+-----+-------------------+----------------+
| id              | int(10) unsigned | NO   | PRI | NULL              | auto_increment |
| stuId           | int(10) unsigned | NO   |     | NULL              |                |
| subjectId       | int(10) unsigned | NO   |     | NULL              |                |
| score           | int(10) unsigned | NO   |     | 0                 |                |
| examinationTime | datetime         | NO   |     | CURRENT_TIMESTAMP |                |
+-----------------+------------------+------+-----+-------------------+----------------+

# 创建一个学生表 stu
create table stu(
-- 创建ID字段，为正整数，不允许为空 主键，自动递增
id int unsigned not null primary key auto_increment,
-- 创建名字字段，为字符串类型，最大长度 5个字符，不允许为空
name varchar(5) not null,
-- 创建密码字段，固定长度 32位字符， 不允许为空
password char(32) not null,
-- 创建性别字段，不允许为空，默认为男
sex char(1) not null default '男',
-- 创建年级id字段，不允许为空
gradeId int unsigned not null,
-- 创建电话字段, 固定长度11
phone char(11) not null,
-- 创建地址字段，为字符串类型，最大长度10 个字符，不允许为空
address varchar(10) not null,
-- 创建出生日期字段, 为年月日时分秒，不能为空，默认值为系统时间
bornDay datetime not null default CURRENT_TIMESTAMP,
-- 创建email字段
email varchar(50)
)engine=innodb default charset=utf8mb4;
mysql> desc stu;
+----------+------------------+------+-----+-------------------+----------------+
| Field    | Type             | Null | Key | Default           | Extra          |
+----------+------------------+------+-----+-------------------+----------------+
| id       | int(10) unsigned | NO   | PRI | NULL              | auto_increment |
| name     | varchar(5)       | NO   |     | NULL              |                |
| password | char(32)         | NO   |     | NULL              |                |
| sex      | char(1)          | NO   |     | 男                |                |
| gradeId  | int(10) unsigned | NO   |     | NULL              |                |
| phone    | char(11)         | NO   |     | NULL              |                |
| address  | varchar(10)      | NO   |     | NULL              |                |
| bornDay  | date	          | NO   |     | CURRENT_TIMESTAMP |                |
| email    | varchar(50)      | YES  |     | NULL              |                |
+----------+------------------+------+-----+-------------------+----------------+

# 创建一个科目表subjects
create table subjects(
-- 创建ID字段，为正整数，不允许为空 主键，自动递增
id int unsigned not null primary key auto_increment,
-- 创建科目名称字段
subjectName varchar(5) not null,
-- 创建学时字段
learnTime int unsigned not null default 0,
-- 创建年级 id字段
gradeId int unsigned not null
)engine=innodb default charset=utf8mb4;
mysql> desc subjects;
+-------------+------------------+------+-----+---------+----------------+
| Field       | Type             | Null | Key | Default | Extra          |
+-------------+------------------+------+-----+---------+----------------+
| id          | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| subjectName | varchar(5)       | NO   |     | NULL    |                |
| learnTime   | int(10) unsigned | NO   |     | 0       |                |
| gradeId     | int(10) unsigned | NO   |     | NULL    |                |
+-------------+------------------+------+-----+---------+----------------+
```

### 需求

```mysql
1. grade 表增加一个阶段，“就业期”
insert into grade(gradename) value('就业期');
mysql> select * from grade;
+----+--------------+
| id | gradename    |
+----+--------------+
|  1 | 第一阶段     |
|  2 | 第二阶段     |
|  3 | 第三阶段     |
|  4 | 就业期       |
+----+--------------+

2.将第三阶段的学生的 gradeid 改为就业期的 id
update stu set gradeId='1' where gradeId='3';

3.查询所有得了 100 分的学号
select stuId from achievement where score=100;

4.查询所有 1989 年出生的学生（1989-1-1~1990-1-1）
select * from stu where bornTime < 1990-1-1 and born > 1989-1-1;

5.查询学生姓名为“金蝶”的全部信息
select * from stu where name='金蝶';

6.查询 subjectid 为 8 的科目考试未及格（60 分）的学号和成绩
select stuId,score from achievement where id=8 and score < 60;

7.查询第 3 阶段课时大于 50 的课程全部信息
select * from subjects where id=3 and learnTime > 50;

8.查询 S1101001 学生的考试信息
select * from stu where name='S1101001';

9.查询所有第二阶段的女生信息
select * from stu where gradeId = 2 and sex="女";

10.“基于.NET 平台的软件系统分层开发”需要多少课时
selct learnTime from subjects where subjectName='基于.NET 平台的软件系统分层开发';

11.查询“设计 MySchool 数据库”和“面向对象程序设计”的课时(使用in)
selct learnTime from subjects where subjectName in ('设计 MySchool 数据库', '面向对象程序设计');

12 查询所有地址在山东的学生信息
select * from stu where address='山东';

13 查询所有姓凌的单名同学
select * from stu where name like '凌_';

14.查询 gradeid 为 1 的学生信息，按出生日期升序排序
select * from stu where gradeId=1 order by bornDay;

15.查询 subjectid 为 3 的考试的成绩信息，用降序排序
select score from achievement where subjectId = 3 order by score desc;

16.查询 gradeid 为 2 的课程中课时最多的课程信息
select max(learnTime) from subjects where gradeId=2; 

17.查询北京的学生有多少个
select count(address) from stu where address="北京";

18.查询有多少个科目学时小于 50
select count(learnTime) from subjects where learnTime<50;

19.查询 gradeid 为 2 的阶段总课时是多少
select sum(learnTime) as sum_learnTime from subjects where gradeId=2;

20.查询 subjectid 为 8 的课程学生平均分
select avg(score) as avg_score from achievement where subjectId=8;

21.查询 gradeid 为 3 的课程中最多的学时和最少的学时
select max(learnTime) as max_learnTime, min(learnTime) as min_learnTime from subjects where gradeId=3;
22.查询每个科目有多少人次考试
select count(subjectId) as count_subjectId from stu;

23.每个阶段课程的平均课时
select avg(leranTime) from subjects group by subjectId;

24.查询每个阶段的男生和女生个数（group by 两列）
select gradeId,sex,count(*) from stu group by gradeId,sex;
```

