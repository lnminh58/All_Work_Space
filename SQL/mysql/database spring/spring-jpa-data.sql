create database jpa_db;
use jpa_db;

create table employee (
	id INT NOT NULL AUTO_INCREMENT,
    full_name varchar(50) not null,
	primary key (id)
);

insert into employee (full_name) values ("Minh");
insert into employee (full_name) values ("Tinh");

create database test;
use test;

create table employee (
	id INT NOT NULL AUTO_INCREMENT,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) not null,
	primary key (id)
);

insert into employee (first_name,last_name,email) values ("Minh","Le","lnminh58@gmail.com");
insert into employee (first_name,last_name,email) values ("mary","lan","lanmary@gmail.com");


