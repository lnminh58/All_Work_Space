/************************************************************
 * Code formatted by SoftTree SQL Assistant © v9.1.261
 * Time: 1/1/2018 12:34:43 PM
 ************************************************************/

CREATE DATABASE ql_hanghangkhong
USE ql_hanghangkhong
CREATE TABLE nhanvien
(
	manv      CHAR(9) NOT NULL PRIMARY KEY,
	ten       VARCHAR(50) NOT NULL,
	luong     INT NOT NULL,
)
CREATE TABLE maybay
(
	mamb       INT NOT NULL PRIMARY KEY,
	loai       VARCHAR(50) NOT NULL,
	tambay     INT NOT NULL,
)
CREATE TABLE chungnhan
(
	manv     CHAR(9) NOT NULL FOREIGN KEY REFERENCES nhanvien(manv) ON DELETE CASCADE,
	mamb     INT NOT NULL FOREIGN KEY REFERENCES maybay(mamb) ON DELETE CASCADE,
	PRIMARY KEY(manv, mamb)
)
CREATE TABLE chuyenbay
(
	macb       CHAR(5) NOT NULL PRIMARY KEY,
	gadi       VARCHAR(50) NOT NULL,
	gaden      VARCHAR(50) NOT NULL,
	dodai      INT NOT NULL,
	giodi      TIME NOT NULL,
	gioden     TIME NOT NULL,
	chiphi     INT NOT NULL,
	manv       CHAR(9) NOT NULL FOREIGN KEY REFERENCES nhanvien(manv) ON DELETE CASCADE,
)

-- cau 1
-- insert nhan vien
INSERT INTO nhanvien
VALUES (123456789,'Do Hoang Nam',20000000) 
INSERT INTO nhanvien VALUES (242518965,'Tran Van Son',12000000) 
INSERT INTO nhanvien VALUES (141582651,'Doan Thi Mai',17000000)
INSERT INTO nhanvien VALUES (011564812,'Ton Van Quy',15000000)
INSERT INTO nhanvien VALUES (567354612,'Quan Cam Ly',25000000)
INSERT INTO nhanvien VALUES (550156548,'Nguyen Thi Cam Que',10000000)
-- insert maybay
INSERT INTO maybay VALUES (747,'Boeing 747 - 400',13488)
INSERT INTO maybay VALUES (767,'Boeing 737 - 800',5413)
INSERT INTO maybay VALUES (340,'Airbus A340 - 300',11392)
INSERT INTO maybay VALUES (757,'Boeing 757 - 300',6416)
-- insert chungnhan
INSERT INTO chungnhan VALUES (567354612,747)
INSERT INTO chungnhan VALUES (567354612,757)
INSERT INTO chungnhan VALUES (011564812,757)
INSERT INTO chungnhan VALUES (011564812,340)
INSERT INTO chungnhan VALUES (242518965,767)
-- insert chuyen bay
INSERT INTO chuyenbay VALUES('VN431','SGN','CAH',3693,'05:55','06:55',236,567354612)
INSERT INTO chuyenbay VALUES('VN320','SGN','DAD',2798,'06:00','07:10',221,242518965)
INSERT INTO chuyenbay VALUES('VN651','DAD','SGN',2798,'19:30','20:00',221,011564812)
INSERT INTO chuyenbay VALUES('VN276','DAD','CXR',1283,'09:00','12:00',203,011564812)
-- CAU 2
SELECT n.ten
      ,m.mamb
      ,m.loai
FROM   nhanvien   AS n
      ,maybay        m
      ,chungnhan     c
WHERE  n.manv = c.manv
       AND m.mamb = c.mamb
-- CAU 3
SELECT n.ten
FROM   nhanvien   AS n
      ,chungnhan     c
WHERE  n.manv = c.manv
       AND c.mamb IN (SELECT m.mamb
                      FROM   maybay m
                      WHERE  m.tambay>7000)
-- cach 2
SELECT n.ten
FROM   nhanvien AS n
WHERE  n.manv IN (SELECT c.manv
                  FROM   chungnhan AS c
                  WHERE  c.mamb IN (SELECT m.mamb
                                    FROM   maybay m
                                    WHERE  m.tambay>7000))
-- cau 4
SELECT c.macb
      ,c.giodi
      ,c.gioden
      ,n.ten
FROM   chuyenbay  AS c
      ,nhanvien      n
WHERE  n.manv = c.manv
       AND c.manv IN (SELECT cn.manv
                      FROM   chungnhan AS cn
                      WHERE  cn.mamb = 747)
-- Cau 5
DECLARE @a INT
SELECT @a = COUNT(*)
FROM   chungnhan AS c
GROUP BY
       c.manv
ORDER BY
       COUNT(*) ASC

SELECT manv
FROM   chungnhan AS c
GROUP BY
       c.manv
HAVING COUNT(*)=@a
-- cau 6
SELECT SUM(n.luong)
FROM   nhanvien AS n
WHERE  n.manv IN (SELECT c.manv
                  FROM   chungnhan AS c)
-- cau 7
SELECT m.mamb
FROM   maybay m
WHERE  m.tambay>= (
           SELECT dodai
           FROM   chuyenbay
           WHERE  gadi          = 'SGN'
                  AND gaden     = 'DAD'
       )
-- cau 8
SELECT m.mamb
      ,m.loai
      ,n.ten
      ,n.manv
FROM   maybay        m
      ,nhanvien   AS n
      ,chungnhan  AS c
WHERE  c.manv = n.manv
       EXCEPT

SELECT m.mamb
      ,m.loai
      ,n.ten
      ,n.manv
FROM   maybay        m
      ,nhanvien   AS n
      ,chungnhan  AS c
WHERE  c.manv = n.manv
       AND c.mamb = m.mamb
-- cau 9

CREATE VIEW V_NVluongcaonhat 
AS

SELECT TOP(1)*
FROM   nhanvien
ORDER BY
       luong DESC

SELECT *
FROM   V_NVluongcaonhat
-- cach 2
CREATE VIEW V_luongcaonhat 
AS

SELECT *
FROM   nhanvien
WHERE  luong = (
           SELECT MAX(luong)
           FROM   nhanvien
       )

SELECT *
FROM   V_luongcaonhat
-- cau 10


CREATE PROC sp_chuyenbay
@mcb CHAR(5)
AS
SELECT *
FROM   chuyenbay
WHERE  macb = @mcb

EXEC sp_chuyenbay 'VN651'
