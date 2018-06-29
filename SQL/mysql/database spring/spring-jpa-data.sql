create database school;
create database school_test;

drop database school;
drop database school_test;
ALTER TABLE batch MODIFY id int AUTO_INCREMENT ;


create database jpa_db;
use jpa_db;

create table employee (
	id int not null auto_increment,
    full_name varchar(50) not null,
    primary key(id)
);

insert into employee (full_name) values ("minh");
insert into employee (full_name) values ("thiem");


create database test;
use test;

create table employee (
	id int not null auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) ,
    email varchar(50) ,
    primary key(id)
);

insert into employee (first_name,last_name,email) values ("minh","le","lnminh58@gmail.com");
insert into employee (first_name,last_name,email) values ("mary","alan","mary@test.com");

