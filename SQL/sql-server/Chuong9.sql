USE QuanLyNhanVienDB

-- tinh tong luong---
-- count(*)
SELECT  nhanvien.manv,  COUNT(*) AS 'demsoluong' FROM Nhanvien
JOIN THANNHAN ON Nhanvien.manv=THANNHAN.manv
GROUP BY nhanvien.manv

SELECT nhanvien.manv,  COUNT(*) AS 'demsoluong' FROM Nhanvien,THANNHAN
WHERE nhanvien.manv =THANNHAN.manv
GROUP BY nhanvien.manv
-- subqueries
SELECT manv,tennv FROM NHANVIEN 
WHERE manv IN (SELECT manv FROM THANNHAN )

SELECT distinct nhanvien.manv FROM Nhanvien,THANNHAN
WHERE nhanvien.manv =THANNHAN.manv

SELECT * FROM NHANVIEN 
WHERE  EXISTS (SELECT manv FROM THANNHAN )



-- inner join 
SELECT  Thannhan.manv FROM Nhanvien
JOIN THANNHAN ON Nhanvien.manv=THANNHAN.manv

-- left join 
SELECT  nhanvien.manv,Nhanvien.tennv FROM Nhanvien
left JOIN THANNHAN ON Nhanvien.manv=THANNHAN.manv

SELECT thannhan.manv,Nhanvien.tennv FROM Nhanvien
left JOIN THANNHAN ON Nhanvien.manv=THANNHAN.manv

-- right jion
SELECT nhanvien.manv,Nhanvien.tennv FROM Nhanvien
RIGHT JOIN THANNHAN ON Nhanvien.manv=THANNHAN.manv
-- cross join
SELECT nhanvien.manv,Nhanvien.tennv FROM Nhanvien
cross JOIN THANNHAN
