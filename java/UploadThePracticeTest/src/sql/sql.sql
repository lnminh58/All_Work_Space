create database UploadThePracticeTest

create table users (
username varchar(30) not null, 
password varchar(50) not null 
primary key(username))

create table students (
username varchar(30) not null, 
studentname varchar(50) not null, 
batchID varchar(50) not null 
primary key(username))

create table roleofusers (
ID int IDENTITY(1,1),
keyrole varchar(50) not null, 
-- namerole varchar(50) not null,
primary key(ID))

insert into roleofusers
values 
('frmMainbtnLogin'),
('frmMainbtnLogout'),
('frmMainbtnUpload'),
('frmMainbtnCreateNewClass'),
('frmMainbtnCreateNewStudent'),
('frmMainbtnDeleteStudent'),
('frmMainbtnModifyStudent'),
('frmMainbtnCreateNewExamination')

create table usersrole (
ID int IDENTITY(1,1),
username varchar(30) not null, 
keyrole varchar(50) not null, 
-- namerole varchar(50) not null,
primary key(ID))

insert into usersrole
values 
('admin','frmMainbtnLogin'),
('admin','frmMainbtnLogout'),
('admin','frmMainbtnUpload'),
('admin','frmMainbtnCreateNewClass'),
('admin','frmMainbtnCreateNewStudent'),
('admin','frmMainbtnDeleteStudent'),
('admin','frmMainbtnModifyStudent'),
('admin','frmMainbtnCreateNewExamination')

create table batch (
batchID varchar(50) not null, 
batchname varchar(50) not null 
primary key(batchID))

insert into batch
values 
('batch129','Batch 129'),
('batch130','Batch 130')

