CREATE DATABASE SCHOOLDB
USE SCHOOLDB

CREATE TABLE LOP (
	malop CHAR(3) NOT NULL PRIMARY KEY,
	tenlop NVARCHAR(15) NOT NULL,
)
CREATE TABLE HOCSINH(
	mahs CHAR(4) NOT NULL PRIMARY KEY,
	hoten NVARCHAR(50) NOT NULL,
	ngaysinh DATE,
	dienthoai CHAR(6),
	malop CHAR(3) FOREIGN KEY REFERENCES lop(malop),
)
CREATE TABLE MONHOC (
	tenmonhoc NVARCHAR(15) NOT NULL PRIMARY KEY,
	sotiethoc INT NOT NULL,
	diemdat REAL,
	diemtoida REAL DEFAULT 10,
)
CREATE TABLE BANGDIEM(
	mahs CHAR(4) NOT NULL FOREIGN KEY REFERENCES HOCSINH(mahs),
	tenmonhoc NVARCHAR(15) NOT NULL FOREIGN KEY REFERENCES MONHOC(tenmonhoc),
	diemthi REAL ,
	ngaythi DATE NOT NULL,
	lanthi INT NOT NULL,
	PRIMARY KEY(mahs,tenmonhoc),
	
)
	
INSERT INTO LOP VALUES	('L01',N'Lớp 11A')
INSERT INTO LOP VALUES	('L02',N'Lớp 11B')
INSERT INTO LOP VALUES	('L03',N'Lớp 11C')

INSERT INTO HOCSINH VALUES ('M001',N'Nguyễn Quốc Oai','09-07-2000','117654','L01')
INSERT INTO HOCSINH VALUES	('M002',N'Trần Thanh',		'12-04-2000','548932','L02')
INSERT INTO HOCSINH VALUES	('M003',N'Phạm Văn Dương',	'01-09-2000','347690','L03')


-- cau 1
-- cau 2
UPDATE monhoc 
SET sotiethoc = 25 WHERE tenmonhoc=N'Toán'
-- câu 3
SELECT * FROM HOCSINH AS h
WHERE malop='L02'
-- câu 4
SELECT h.hoten, l.tenlop from HOCSINH AS h,LOP AS l
WHERE h.malop=l.malop AND h.malop='L01'
-- câu 5
SELECT h.hoten,m.tenmonhoc,m.sotiethoc FROM HOCSINH h, MONHOC m
WHERE h.mahs IN (SELECT mahs FROM BANGDIEM) AND m.tenmonhoc IN (SELECT tenmonhoc FROM BANGDIEM)
-- câu 6

select COUNT (*) FROM BANGDIEM AS b
WHERE b.tenmonhoc = N'Văn' AND b.diemthi<(SELECT diemdat FROM MONHOC WHERE tenmonhoc=N'Văn')

-- câu 7
SELECT h.hoten,b.diemthi FROM HOCSINH h,BANGDIEM b
WHERE b.diemthi = (SELECT MAX(diemthi) FROM BANGDIEM WHERE ngaythi='2016/9/25') AND h.mahs=b.mahs AND ngaythi='2016/9/25'
-- câu 8
SELECT h.hoten, b.tenmonhoc,b.lanthi FROM HOCSINH h
LEFT JOIN BANGDIEM AS b ON ngaythi ='2016/9/29' AND h.mahs=b.mahs
-- câu 9
CREATE VIEW bangdiem_vw AS
SELECT * FROM bangdiem
 SELECT * from bangdiem_vw
 -- câu 10
 CREATE PROC bangdiem_sp
 @mahs CHAR(4) 
 AS
 SELECT * FROM BANGDIEM b WHERE b.mahs = @mahs
 
 EXEC bangdiem_sp M001
 
 -- cau 11
CREATE VIEW V_testview AS
SELECT * FROM HOCSINH 
WHERE dienthoai = '347690'

SELECT * FROM V_testview

UPDATE HOCSINH
SET dienthoai='347690'
WHERE mahs='M003'

UPDATE V_testview
SET dienthoai='347699'

-- cau 12
DROP VIEW V_testview

CREATE VIEW V_testview AS
SELECT * FROM HOCSINH 
WHERE ngaysinh >= '2000-02-01'
WITH CHECK OPTION

SELECT * FROM V_testview
INSERT INTO V_testview VALUES('M005',N'Nguyễn Tuân','2000-03-10','345876','L01')

DELETE FROM HOCSINH
WHERE hoten=N'Nguyễn Tuân'