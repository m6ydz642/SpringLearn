

create user 'spring5'@'localhost' identified by 'spring5';
grant all privileges on *.* to 'spring5'@'%' identified by 'spring5';
/*외부접속 가능하게*/

create database spring5fs character set=utf8;

show databases;
use spring5fs;
show tables;
select * from MEMBER;

grant all privileges on spring5fs.* to 'spring5'@'localhost';

create table spring5fs.MEMBER (
ID int auto_increment primary key,
EMAIL varchar(255),
PASSWORD varchar(100),
NAME varchar(100),
REGDATE datetime,
unique key(email)
)engine=InnoDB character set = utf8;
