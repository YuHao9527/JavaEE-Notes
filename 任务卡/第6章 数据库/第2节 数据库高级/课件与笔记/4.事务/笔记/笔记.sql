

create table users(
    id int auto_increment primary key,
    name varchar(10),
    age  int,
    account int
)engine = innodb default charset=utf8mb4;

insert into users values(null,'张三',25,10000),(null,'李四',20,100),(null,'王五',23,0);


基本事务操作
1. start transaction;/ begin;
2. commit; 使得当前的修改确认
3. rollback; 使得当前的修改被放弃




--设置事务的隔离级别

-- 查看当前会话的隔离级别
select @@tx_isolation;

-- 读未提交
set session transaction isolation level read uncommitted;

-- 读已提交 READ_COMMITTED
set session transaction isolation level read committed;


-- 可重复读 REPEATABLE_READ
set session transaction isolation level repeatable read;


-- 顺序读 SERIALIZABLE
set session transaction isolation level SERIALIZABLE;














