# create table
create table user(
id int(11) not null auto_increment,
username VARCHAR(32) not null COMMENT '用户名称',
birthday datetime DEFAULT null comment '生日',
sex char(1) DEFAULT null comment '性别',
addresss varchar(256) DEFAULT null COMMENT '地址',
PRIMARY key (id)
)ENGINE=INNODB DEFAULT charset=utf8

