## 财务管理系统-数据库模块

### 创建数据库和数据表

```
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
empidid int unsigned not null primary key auto_increment,
-- 创建姓名字段，为字符串类型，最大长度 5个字符，不允许为空
name varchar(5) not null，
-- 创建性别字段，不允许为空，默认为男
sex char(1) not null default '男',
-- 创建职称字段
title，
-- 创建出生日期字段
birthday，
-- 创建所属部门字段
depid
)engine=innodb default charset=utf8mb4;

# 创建一个部门表 department
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

# 创建一个工资表 salary
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
```

### 需求

```mysql

```

