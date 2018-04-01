create database JTableDemo

create table users(
    ID int IDENTITY(1,1),
    username nvarchar(50) not null,
    password nvarchar(50) not null,
    gender bit,
    filename_avatar varchar(50),
    image_avatar image,
    primary key(ID))