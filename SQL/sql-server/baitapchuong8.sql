USE QuanLyNhanVienDB

SELECT * FROM NHANVIEN AS n
WHERE  n.tenphong=5 AND n.phai=N'Nam'

SELECT * FROM 

--câu 9
 SELECT n.tennv,n.diachi FROM NHANVIEN AS n
WHERE n.tenphong= (SELECT maphong FROM PHONGBAN WHERE tenphong =N'Nghiên cứu')

--câu 10
ALTER TABLE PHANCONG ADD FOREIGN KEY (soda) REFERENCES DEAN(mada) ON DELETE CASCADE;
DELETE FROM DEAN 
WHERE mada in (SELECT p.soda FROM PHANCONG p WHERE sogio>30)


-- câu 11

UPDATE phancong
SET sogio = 5
WHERE sogio IS NULL
-- câu 6 
SELECT * FROM NHANVIEN n WHERE n.tennv IN ( SELECT t.tentn FROM THANNHAN AS t)
-- câu 7
SELECT n.honv +' '+n.tenlot+' '+n.tennv AS N'Họ và tên',n.ngaysinh,n.diachi, d.mada,d.phong
  FROM NHANVIEN n, DEAN d, PHONGBAN p
WHERE d.phong=p.maphong AND p.truongphong=n.manv AND d.diadiemda=N'Hà Nội'
--câu 12
SELECT TOP(3)* FROM NHANVIEN 
ORDER BY luong DESC
-- câu 13
SELECT n.tennv,COUNT(p.soda) FROM NHANVIEN AS n,PHANCONG p
WHERE n.manv=p.manv
GROUP BY n.tennv