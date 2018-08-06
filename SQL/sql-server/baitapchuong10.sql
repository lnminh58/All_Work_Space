create database QL_hocsinh
use QL_hocsinh
create table hocsinh
(
	mahs char(6) primary key not null,
	hoten nvarchar(120) null,
	ngaysinh datetime not null,
	dienthoai int null
	)

create table monhoc
(
	tenmonhoc nvarchar(120) primary key not null,
	sosession int not null,
	diemdat float not null,
	diemtoida float not null
	)

create table bangthi
(
	mahs char(6) foreign key references hocsinh(mahs) not null,
	monhoc nvarchar(120) foreign key references monhoc(tenmonhoc) not null,
	diemthi float null,
	ngaythi datetime null,
	lanthi int null,
	primary key(mahs,monhoc)
	)
insert into hocsinh(mahs,hoten,ngaysinh,dienthoai)
values('M001',N'Nguyễn Quốc Oai','07-29-1995','117654'),
	  ('M002',N'Trần Thanh','04-12-1996','548932'),
	  ('M003',N'Phạm Văn Dương','09-21-1990','347690')


insert into monhoc(tenmonhoc,sosession,diemdat,diemtoida)
values(N'Toán','20','4.5','10.0'),
	  (N'Văn','40','5.0','9.0'),
	  (N'Ngoại ngữ','60','4.5','10.0')

insert into bangthi(mahs,monhoc,diemthi,ngaythi,lanthi)
values('M001',N'Toán','4','9/24/2007','1'),
	  ('M001',N'Ngoại ngữ','8','9/29/2007','1'),
	  ('M002',N'Văn','6.5','9/25/2007','1'),
	  ('M003',N'Toán','9.5','9/24/2007','1'),
	  ('M001',N'Văn','8','9/25/2007','2'),
	  ('M003',N'Ngoại ngữ','7.5','9/29/2007','1'),
	  ('M002',N'Toán','8.5','9/24/2007','1'),
	  ('M002',N'Ngoại ngữ','10','9/29/2007','2'),
	  ('M003',N'Văn','3.5','12/05/2008','2')


-- câu 1
DROP PROC sp1

CREATE PROC sp1 AS
SELECT m.tenmonhoc,m.sosession+4 AS 'New sosession',m.diemdat,m.diemtoida 
 FROM monhoc m

EXEC sp1
SELECT * FROM monhoc

CREATE PROC sp1 AS
UPDATE monhoc
SET sosession=sosession+4

EXEC sp1
SELECT * FROM monhoc 

-- câu 2 
DROP PROC sp2
CREATE PROC sp2
@tenmonhoc NVARCHAR(30), @sosessiontang INT
as
UPDATE monhoc
SET
	sosession = sosession + @sosessiontang 
WHERE tenmonhoc=@tenmonhoc


EXEC sp2 N'Toán',7
EXEC sp2 N'Văn',30
SELECT * FROM monhoc

-- câu 3
DROP PROC sp3
DROP VIEW V_sp3

CREATE VIEW V_sp3 AS
SELECT * FROM bangthi WHERE ngaythi='9-24-2007'
CREATE PROC sp3 AS
SELECT h.hoten  FROM hocsinh AS h
WHERE mahs = (SELECT TOP(1)mahs from V_sp3  ORDER BY diemthi desc )

EXEC sp3

CREATE PROC sp3_2 AS
SELECT h.hoten  FROM hocsinh AS h
WHERE mahs = (SELECT TOP(1)mahs from bangthi WHERE ngaythi='9-29-2007'  ORDER BY diemthi desc )
EXEC sp3_2
DROP PROC sp3_2

-- câu 4
DROP PROC sp4

CREATE PROC sp4
@tenmonhoc NVARCHAR(20)
AS 
SELECT h.hoten FROM hocsinh h
WHERE mahs = (SELECT TOP(1)mahs FROM bangthi WHERE monhoc=@tenmonhoc ORDER BY diemthi DESC)

EXEC sp4 N'NGoại NGữ'

-- câu 5
CREATE PROC sp5 as
SELECT COUNT(*) AS N'Số thằng tạch toán' FROM bangthi WHERE monhoc=N'Toán' AND diemthi<5
EXEC sp5
-- câu 6
CREATE PROC sp6
@tenmonhoc NVARCHAR(30) AS
SELECT COUNT(*) AS N'Số Khí đậu môn mày tìm' FROM bangthi WHERE monhoc=@tenmonhoc AND diemthi>=5

EXEC sp6 N'Ngoại Ngữ'
-- câu 7
CREATE PROC sp7 AS
SELECT * FROM hocsinh WHERE hoten LIKE N'T%'

EXEC sp7

-- câu 8
DROP proc sp8
CREATE PROC sp8 AS
DELETE FROM bangthi WHERE ngaythi='12-5-2008'

EXEC sp8

