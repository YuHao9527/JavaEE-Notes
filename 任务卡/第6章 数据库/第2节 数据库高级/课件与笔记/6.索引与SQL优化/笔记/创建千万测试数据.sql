-- 创建表
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;

-- 创建存储过程，插入1000万条数据
\d //
create procedure p1()
begin
set @i=1;
while @i<=10000000 do
insert into users values(
    null,
    concat('user:',@i),
    concat('user:',@i,'@qq.com'),
    concat('13701',FLOOR(RAND()*500000 + 500000)),
    floor(rand()*100),
    if(floor(rand() * 2) = 1 , '男' , '女')
    );
set @i=@i+1;
end while;
end;
//
\d ;

-- 调用存储过程，完成数据插入
call p1();


-- mysql> call p1();
-- Query OK, 0 rows affected (20 min 53.16 sec)


-- 查看数据
select count(id) from users;
-- +-----------+
-- | count(id) |
-- +-----------+
-- |  10000000 |
-- +-----------+
-- 1 row in set (2.18 sec)


-- 修改部分数据
 update users set name = 'zhangsan',email = 'zhangsan@qq.com',phone='13701383017',age=25 where id = 1000001;
 update users set name = 'lisi',email = 'lisi@qq.com',phone='17610195200',age=21 where id = 2000001;
 update users set name = 'wangwu',email = 'wangwu@qq.com',phone='17610195211',age=28 where id = 3000001;
 update users set name = 'zhaoliu',email = 'zhaoliu@qq.com',phone='17610195222',age=21 where id = 4000001;

-- 修改部分数据后进行查询
select * from users where name = 'zhangsan';
+---------+----------+-----------------+-------------+------+------+
| id      | name     | email           | phone       | age  | sex  |
+---------+----------+-----------------+-------------+------+------+
| 1000001 | zhangsan | zhangsan@qq.com | 13701383017 |   25 | 女   |
+---------+----------+-----------------+-------------+------+------+
1 row in set (3.73 sec)

-- 打开慢查询日志


