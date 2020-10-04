## MySQL(5.7)常用关键字

### 一、常用关键字

#### 1.in 关键字 

```mysql
-- in关键字，用于判断某个字段的值，是否在指定的集合中
-- 如果字段的值在集合中，则满足条件，该字段所在的数据将会被查询出来。

-- 语法格式：
	select * from 表名 where 字段名 [not]in (元素1,元素2，...);
-- 参数说明：
	元素1，元素2，……表示集合中的元素，即指定的条件范围（注：这里也可以嵌套sql语句）
	not，可选参数，表示查询不在IN关键字指定集合，范围中的数据
```

#### 2. exists 关键字

```mysql
-- exists关键字，当 exists 里的条件语句能够返回记录时 (无论记录行多少，只要能返回)，条件就为真，返回当前循环到的这条记录。反之如果 exists 里的条件语句不能返回记录行，则条件为假，那么当前循环到的这条记录被丢弃。
-- exists 的条件就像是一个 boolean 条件，当有结果集则为 true，不能返回结果集则为 false。

-- 语法格式：
	select 字段名 from 表名 where [not] exists (sql语句);
-- 参数说明：
	sql... 条件语句，返回结果集
	not，可选参数，表示查询不在结果集中的数据
```

#### 3. distinct 关键字

```mysql
-- distinct关键字,用于数据去重
-- 常和聚合函数一起使用
-- 语法格式：
	select distinct 字段名 from 表名;
	-- 将会去掉两行完全一样的数据

-- 如果想去掉单一一列数据相同的数据，可以使用group by 进行分组
-- 如果我们只需要计算某一个字段去重复后的总记录数可以 用 count(distinct 列名)聚合函数的方式获取。
```

#### 4. union 关键字

```mysql
-- union关键字，MySQL 是从 4.0 版本起开始加入的UNION 这个关键字
-- MySQL也允许执行多个查询（多条SELECT语句），union可以将结果作为单个查询结果集返回。

-- 语法格式：
	select * from 表1 union [all] select * from 表2；
-- 加all表示不对直接合并，不加则会对合并后结果进行一次去重操作
-- union规则：
-- 1. UNION必须由两条或两条以上的SELECT语句组成，语句之间用关键字UNION分隔（因此，如果组合4条SELECT语句，将要使用3个UNION关键字）。
-- 2. UNION中的每个查询必须包含相同的列、表达式或聚集函数（不过各个列不需要以相同的次序列出）。
-- 3. 列数据类型必须兼容：类型不必完全相同，但必须是DBMS可以隐含地转换的类型（例如，不同的数值类型或不同的日期类型）
```

#### 5. limit 关键字

```mysql 
-- limit关键字，用于分页显示，常与排序order by 一起使用获取最大值或最小值

-- 语法格式：
	select 字段名 from 表名 limit m,n;

-- 参数说明：
	表示从第m行开始，共查询n行;
	如果只有一个m,则表名从索引0开始，(MySQL中第一条数据索引为0)
-- 注：MySQL5.0之后加入offset关键字，表示偏移量
	select 字段名 from 表名 limit m,n;
	select 字段名 from 表名 limit m offset n;
	-- 这两条sql语句效果是一样的。
```

#### 7. as 关键字

```mysql
-- as 关键字，用于取别名

-- 语法格式：
	select 字段名 as 别名 from 表名 as 别名；

-- 注意：表别名只在查询执行中使用。与列别名不一样，表别名不返回到客户机
-- 优点：缩短SQL语句；允许在单条SELECT语句中多次使用相同的表；
```

#### 8. like 关键字

```mysql
-- like关键字，在 WHERE 子句中使用，用于某个字段的模糊搜索
-- 使用 % 模糊搜索。%代表任意个任意字符
-- 语法格式：
	-- 查询name字段中包含五的
	select * from users where name like '%五%';
	-- 查询name字段中最后一个字符 为 五的
    select * from users where name like '%五';
    -- 查询name字段中第一个字符 为 王 的
    select * from users where name like '王%';
-- 使用 _ 单个的下划线。表示一个任意字符，使用和%类似
    -- 查询表中 name 字段为两个字符的数据
    select * from users where name like '__';
    -- 查询 name 字段最后为五，的两个字符的数据
    select * from users where name like '_五';
    
-- 注意：where子句中的like在使用%或者_进行模糊搜索时，效率不高。

```

#### 9. between 关键字

```mysql
-- between关键字，在 WHERE 子句中使用，用于选取介于两个值之间的数据范围

-- 语法格式：
	select 字段名 from 表名 where 字段名 [not] between m and n;
	
-- 参数说明：
	m,n 表示查询范围在[m,n]的数据，左右闭合
	not,可选参数, 表示查询范围为 <m 和 >n 的数据。
-- 如果要查询 某个字段值小于某个值和大于某个值时，就只能用 and 了
```

