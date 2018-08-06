﻿CREATE DATABASE ThongTinHangKhongDB
USE ThongTinHangKhongDB

CREATE TABLE NHANVIEN (
	MaNV CHAR(9) NOT NULL PRIMARY KEY,
	Ten VARCHAR(50) NOT NULL,
	Luong INT NOT NULL,
)
CREATE TABLE CHUYENBAY(
	MaCB CHAR(5) PRIMARY KEY,
	GaDi VARCHAR(50) NOT NULL,
	GaDen VARCHAR(50) NOT NULL,
	DoDai INT NOT NULL,
	GioDi TIME NOT NULL,
	GioDen TIME NOT NULL,
	ChiPhi INT NOT NULL,
	MaNV CHAR(9) NOT NULL FOREIGN KEY REFERENCES NHANVIEN(MaNV) ON DELETE CASCADE,
)


CREATE TABLE MAYBAY (
	MaMB INT NOT NULL PRIMARY KEY,
	Loai VARCHAR(50) NOT NULL,
	TamBay INT NOT NULL,

)
CREATE TABLE CHUNGNHAN(
	MaNV CHAR(9) NOT NULL FOREIGN KEY REFERENCES NHANVIEN(MaNV) ON DELETE CASCADE,
	MaMB INT  NOT NULL FOREIGN KEY REFERENCES MAYBAY(MaMB) ON DELETE CASCADE,
	PRIMARY KEY (MaNV,MaMB),
)

-- câu 1 
INSERT INTO NHANVIEN VALUES (123456789,'Do Hoang Nam',20000000) 
-- câu 2
SELECT n.Ten,m.MaMB,m.Loai FROM NHANVIEN n, MAYBAY m, CHUNGNHAN c
WHERE n.MaNV = c.MaNV AND m.MaMB=c.MaMB
-- câu 3
SELECT n.Ten FROM  NHANVIEN n
WHERE n.MaNV IN (SELECT MaNV FROM CHUNGNHAN WHERE MaMB IN 
					(SELECT MaMB FROM  MAYBAY WHERE TamBay > 7000))
-- câu 4
SELECT c.MaCB,c.GioDi,c.GioDen,n.Ten FROM NHANVIEN n,CHUYENBAY c
WHERE n.MaNV=c.MaNV AND n.MaNV IN ( SELECT MaNV FROM CHUNGNHAN WHERE MaMB=737)

-- câu 5
DECLARE @a INT
SELECT @a=COUNT(*) FROM CHUNGNHAN GROUP BY MaNV ORDER BY COUNT(*) ASC
SELECT DISTINCT MaNV FROM CHUNGNHAN c
WHERE MaNV IN ( SELECT MaNV FROM CHUNGNHAN GROUP BY MaNV HAVING COUNT(*)=@a ) 

-- câu 6
SELECT SUM(luong) AS N'Tổng Lương Phi Công' FROM NHANVIEN
WHERE MaNV IN (SELECT MaNV FROM CHUNGNHAN)

-- câu 7
SELECT m.MaMB FROM MAYBAY m
WHERE m.TamBay>=(SELECT DoDai FROM CHUYENBAY
				WHERE GaDi='SGN' AND GaDen='DAD')

-- câu 8
SELECT m.MaMB,m.Loai,m.TamBay, c.MaNV from MAYBAY  m, CHUNGNHAN c
EXCEPT
SELECT m.MaMB,m.Loai,m.TamBay, c.MaNV from MAYBAY  m, CHUNGNHAN c
WHERE m.MaMB=c.MaMB
ORDER BY m.MaMB

-- câu 9
CREATE VIEW V_NVluongcaonhat 
AS
SELECT TOP(1)* FROM NHANVIEN ORDER BY Luong DESC

SELECT * from V_NVluongcaonhat

-- câu 10 

CREATE PROC SP_ChuyenBay
@macb CHAR(5)
AS 
SELECT * FROM CHUYENBAY
WHERE MaCB=@macb

