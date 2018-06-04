
USE [master]

DROP DATABASE QuanLyNhanVienDB
CREATE DATABASE QuanLyNhanVienDB
USE QuanlyNhanVienDB
CREATE TABLE NHANVIEN (
	honv NVARCHAR(10) NOT NULL,
	tenlot NVARCHAR(30) NOT NULL,
	tennv NVARCHAR(10) NOT NULL,
	manv INT NOT NULL PRIMARY KEY,
	ngaysinh DATE,
	diachi NVARCHAR(300),
	phai NVARCHAR(10),
	luong MONEY NOT NULL,
	maquanly INT NOT NULL,
	tenphong NVARCHAR(50) NOT NULL,
)

CREATE TABLE PHONGBAN(
	tenphong NVARCHAR(50) NOT NULL,
	maphong  INT NOT NULL PRIMARY KEY,
	truongphong INT NOT NULL,
	ngaynhanchuc DATE NOT NULL
	
)

CREATE TABLE DIADIEM_PHONG(
	maphong INT NOT NULL FOREIGN KEY REFERENCES PHONGBAN(maphong),
	diadiem NVARCHAR(100) NOT NULL,
	PRIMARY KEY( maphong,diadiem)
)

CREATE TABLE THANNHAN(
	manv INT NOT NULL FOREIGN KEY REFERENCES NHANVIEN(manv),
	tentn NVARCHAR(50) NOT NULL,
	phai NVARCHAR(10) NOT NULL,
	ngaysinh DATE,
	quanhe NVARCHAR(20) NOT NULL,
	PRIMARY KEY(manv,tentn)
)

CREATE TABLE DEAN(
	tenda NVARCHAR(100) NOT NULL,
	mada INT NOT NULL PRIMARY KEY,
	diadiemda NVARCHAR(100) NOT NULL,
	phong INT NOT NULL,
)
CREATE TABLE PHANCONG(
	manv INT NOT NULL FOREIGN KEY REFERENCES NHANVIEN(manv),
	soda INT NOT NULL FOREIGN KEY REFERENCES DEAN(mada),
	sogio INT NOT NULL,
	PRIMARY KEY (manv,soda)	
)

ALTER TABLE DEAN
ADD FOREIGN KEY (phong) REFERENCES PHONGBAN(maphong)
ALTER TABLE NHANVIEN
ALTER COLUMN maquanly INT NULL

INSERT INTO NHANVIEN VALUES (N'Đinh',N'Bá', N'Tiến',123456789,'1985-01-09',N'731,Trần Hưng Đạo,Q1,TPHCM',N'Nam',3000000,333445555,5)
INSERT INTO NHANVIEN VALUES (N'Nguyễn',N'Thanh',N'Tùng',333445555,'08/01/1975',N'638,Nguyễn Văn Cừ,Q5 TPHCM',N'Nam',4000000,888665555,5)
UPDATE NHANVIEN
SET ngaysinh='1975-01-08' WHERE manv=333445555
UPDATE NHANVIEN
SET diachi =N'638,Nguyễn Văn Cừ,Q5,TPHCM' WHERE manv=333445555
INSERT INTO NHANVIEN VALUES 
	(N'Bùi',N'Thùy',N'Vũ',999887777,'07/19/1988',N'332,Nguyễn Thái Học,Q1,TPHCM',N'Nữ',2500000,987654321,4),
	(N'Lê',N'Thị',N'Nhàn',987654321,'06/20/1961',N'291,Hồ Văn Huê,QPN,TPHCM',N'Nữ',4300000,888665555,4),
	(N'Nguyễn',N'Mạnh',N'Hùng',666884444,'09/15/1982',N'975,Bà Rịa,Vũng Tàu',N'Nam',3800000,333445555,5),
	(N'Trần',N'Thanh',N'Tâm',453453453,'07/31/1990',N'543,Mai Thị Lưu,Q1,TPHCM',N'Nam',2500000,333445555,5),
	(N'Trần',N'Hồng',N'Quang',987987987,'03/29/1986',N'980,Lê Hồng Phong,Q10,TPHCM',N'Nam',2500000,987654321,4),
	(N'Vương',N'Ngọc',N'Quyên',888665555,'10/10/1957',N'450,Trưng Vương,Hà Nội',N'Nữ',5500000,'',1)
	

INSERT INTO PHONGBAN VALUES 
	(N'Nghiên cứu',5,333445555,'05/22/2008'),
	(N'Điều hành',4,987987987,'01/01/2009'),
	(N'Quản lý',1,888665555,'06/19/2001')
	
INSERT INTO DIADIEM_PHONG VALUES 
	(1,N'TP Hồ Chí Minh'),
	(4,N'Hà Nội'),
	(5,N'Vũng Tàu'),
	(5,N'Nha Trang'),
	(5,'TP Hồ Chí Minh')
INSERT INTO DEAN VALUES 
	(N'Sản phẩm X',1,N'Vũng Tàu',5),
	(N'Sản phầm Y',2,N'Nha Trang',5),
	(N'Sản phẩm Z',3,N'TP Hồ Chí Minh',5),
	(N'Tin học hóa',10,N'Hà Nội',4),
	(N'Cáp quang',20,N'TP Hồ Chí Minh',1),
	(N'Đào tạo',30,N'Hà Nội',4)

INSERT INTO THANNHAN VALUES
	(333445555,N'Quang',N'Nữ','04/05/2006',N'Con gái')

INSERT INTO THANNHAN VALUES
	(333445555,N'Khang',N'Nam','10/25/2003',N'Con trai'),
	(333445555,N'Dương',N'Nữ','05/03/1978',N'Vợ chồng'),
	(987654321,N'Đăng',N'Nam','02/28/1962',N'Vợ chồng'),
	(123456789,N'Duy',N'Nam','01/01/2008',N'Con trai'),
	(123456789,N'Châu',N'Nữ','12/31/2008',N'Con gái'),
	(123456789,N'Phương',N'Nữ','05/05/1987',N'Vợ chồng')

ALTER TABLE PHANCONG
ALTER COLUMN sogio REAL NULL


DELETE FROM PHANCONG
INSERT INTO PHANCONG

VALUES
	(123456789,1,32.5),
	(123456789,2,7.5),
	(666884444,3,40.0),
	(453453453,1,20.0),
	(453453453,2,20.0),
	(333445555,3,10.0),
	(333445555,10,10.0),
	(333445555,20,10.0),
	(999887777,30,30.0),
	(999887777,10,10.0),
	(987987987,10,35.0),
	(987987987,30,5.0),
	(987654321,30,20.0),
	(987654321,20,15.0),
	(888665555,20,NULL)


-- cau 1 nhan vien ...
SELECT NHANVIEN.tennv FROM NHANVIEN,PHANCONG,PHONGBAN 
WHERE maphong=5 AND (nhanvien.manv=phancong.manv AND soda in (select mada from DEAN where tenda = N'Sản phẩm X')   AND sogio>10)

Select tennv from NHANVIEN, PHANCONG,PHONGBAN
Where maphong =5 and NHANVIEN.manv = PHANCONG.manv
and soda = (select mada from DEAN where tenda = N'Sản phẩm X') 
and sogio >10

-- cau 2 truong phong 1 toi thieu 1 nhan than
UPDATE PHONGBAN
SET truongphong =123456789 WHERE maphong=1

SELECT * FROM Nhanvien
WHERE NHANVIEN.manv in (SELECT truongphong FROM PHONGBAN, THANNHAN  WHERE THANNHAN.manv=PHONGBAN.truongphong)

SELECT truongphong FROM PHONGBAN JOIN THANNHAN 
ON PHONGBAN.truongphong= THANNHAN.manv
--cau 3

Select * from NHANVIEN where manv not in (select truongphong FROM PHONGBAN  )
-- cau 4 

SELECT * FROM NHANVIEN
WHERE (SELECT COUNT(*) FROM THANNHAN,NHANVIEN WHERE nhanvien.manv=THANNHAN.manv)>2

SELECT COUNT(*) FROM THANNHAN,NHANVIEN WHERE nhanvien.manv=THANNHAN.manv

-- cau 5
SELECT * FROM NHANVIEN 
WHERE maquanly = (SELECT manv FROM NHANVIEN WHERE honv=N'Nguyễn' AND tenlot=N'Thanh' AND tennv=N'Tùng')

-- câu 6
UPDATE NHANVIEN 
SET luong = (luong+luong*0.1) WHERE manv IN (SELECT manv FROM THANNHAN)
SELECT * FROM NHANVIEN WHERE manv IN (SELECT manv FROM THANNHAN)
--câu 7
UPDATE NHANVIEN 
SET luong = (luong + luong*0.2) 
WHERE manv IN ( SELECT truongphong FROM PHONGBAN, THANNHAN
               WHERE PHONGBAN.truongphong=THANNHAN.manv)
                                                
 SELECT * FROM NHANVIEN
 WHERE manv IN ( SELECT truongphong FROM PHONGBAN, THANNHAN
                  WHERE PHONGBAN.truongphong=THANNHAN.manv)

--câu 8
UPDATE NHANVIEN
SET luong= (luong + luong *0.3)
WHERE( manv IN (SELECT truongphong FROM PHONGBAN) AND( year(getdate())-YEAR(nhanvien.ngaysinh))>50 )
--câu 9 
SELECT phongban.tenphong, AVG(luong) as 'Lương trung bình' FROM PHONGBAN,NHANVIEN
WHERE Phongban.maphong=nhanvien.tenphong
GROUP BY PHONGBAN.tenphong
--câu 1

Select phongban.tenphong, count(manv) as 'So luong nhan vien', avg(luong) as 'Luong trung binh' FROM NHANVIEN, PHONGBAN where NHANVIEN.tenphong = PHONGBAN.maphong GROUP BY PHONGBAN.tenphong
HAVING avg(luong) > 4000000

--câu 11
SELECT TOP(3)* FROM NHANVIEN 
ORDER BY YEAR(GETDATE())-YEAR(nhanvien.ngaysinh) DESC
--câu 12
DECLARE @phong INT,
		@da NVARCHAR(50),
		@thoigian INT 
SET @phong=5
SET @da=N'Sản phẩm X'
SET	@thoigian = 10
SELECT * FROM NHANVIEN
WHERE nhanvien.tenphong=@phong 
	AND nhanvien.manv IN (SELECT PHANCONG.manv FROM PHANCONG WHERE PHANCONG.soda=(SELECT DEAN.mada FROM DEAN WHERE tenda=@da )AND sogio>@thoigian)
	
