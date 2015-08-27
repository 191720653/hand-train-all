建立user表
create table users(
id int(11) unsigned not null auto_increment,
name varchar(50) not null default "",
password varchar(50) default "",
primary key(id)) 
engine=InnoDB 
default charset=utf8;
复合主键
create table user(
    id int not null,
    name char(20),
    primary key (id,name)
);

修改表名
alter table tbl_user rename to user;
alter table user rename users;

insert into user values(1, "zehao", "zehao");
insert into user values("","ze","ze");

update user set password="nihao" where id=2;

增加表属性
alter table user add address varchar(50);

修改表属性
alter table user change address address varchar(50) not null default "";