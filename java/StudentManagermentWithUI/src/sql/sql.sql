create database studentmanagerment

use
private String code;

create table batch (batchcode nvarchar(10), batchname nvarchar(50), primary key(batchcode))

insert into batch values 
('batch00130','Batch 130'),
('batch00131','Batch 131'),
('batch00132','Batch 132'),
('batch00133','Batch 133'),
('batch00134','Batch 134'),
('batch00135','Batch 135');

create table student (studentCode nvarchar(10), studentName nvarchar(50), studentGender bit, studentBirthday date, batchCode nvarchar(10), studentEnglishMark float, studentMathMark float, studentComputerMark float, filename_avatar nvarchar(50), image_avatar image, primary key(studentCode))

insert into student values 
('st00000001','student 01',1,'1991-01-01','batch00131',4,5,6,'st00000001_avatar.jpg',null),
('st00000002','student 02',1,'1992-01-02','batch00132',4,5,6,'st00000002_avatar.jpg',null),
('st00000003','student 03',0,'1993-01-03','batch00133',4,5,6,'st00000003_avatar.jpg',null),
('st00000004','student 04',0,'1994-01-04','batch00134',4,5,6,'st00000004_avatar.jpg',null),
('st00000005','student 05',1,'1995-01-05','batch00135',4,5,6,'st00000005_avatar.jpg',null);


