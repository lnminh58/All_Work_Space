USE QuanLyNhanVienDB

SELECT * FROM NHANVIEN
WHERE tenphong=5
ORDER BY manv
-- union hợp , intersect giao, except hợp
SELECT * FROM NHANVIEN as n
WHERE n.diachi LIKE N'%TPHCM'
INTERSECT
SELECT *  FROM NHANVIEN AS n
WHERE n.phai !=N'Nam'

-- câu 3
SELECT * FROM NHANVIEN as n
WHERE n.diachi LIKE N'%TPHCM'
INTERSECT
SELECT *  FROM NHANVIEN AS n
WHERE (YEAR(GETDATE())-YEAR(n.ngaysinh))>22
-- câu 4
SELECT * FROM nhanvien AS n
WHERE n.diachi LIKE N'%Đà Nẵng'
UNION 
SELECT *FROM nhanvien AS n
WHERE n.diachi LIKE N'%Hà Nội'

-- câu 5
 SELECT p.tenphong,n.tenphong,COUNT(n.manv),SUM(n.luong) AS tongluong FROM nhanvien n, PHONGBAN p
 WHERE p.maphong=n.tenphong
 GROUP BY p.tenphong,n.tenphong
 -- câu 8
 SELECT n.honv+' '+n.tenlot+' '+n.tennv AS N'Họ Và Tên' FROM NHANVIEN n
 WHERE n.manv IN (SELECT TOP(1)n.manv FROM NHANVIEN n ORDER BY n.ngaysinh ASC)
 -- câu 9
 SELECT n.honv+' '+n.tenlot+' '+n.tennv AS N'Họ Và Tên' FROM NHANVIEN n
 WHERE n.manv IN (SELECT TOP(1)n.manv FROM NHANVIEN n ORDER BY n.ngaysinh DESC)
 
 SELECT n.honv+' '+n.tenlot+' '+n.tennv AS N'Họ Và Tên' FROM NHANVIEN n
 WHERE ngaysinh=  (SELECT Max(ngaysinh) FROM NHANVIEN n )
 
 --câu 10
 SELECT COUNT(DISTINCT tennv) FROM NHANVIEN 
-- câu 13

SELECT * FROM nhanvien 
WHERE manv IN ( SELECT manv FROM PHANCONG WHERE
									 soda = (SELECT mada FROM DEAN WHERE tenda=N'Nghiên cứu tài nguyên'))
		AND (manv!=01 or manv!=03)
		
SELECT n.manv,n.tennv,n.phai,n.ngaysinh, tentn, t.phai,t.ngaysinh  FROM NHANVIEN n ,THANNHAN t
WHERE n.manv=t.manv

