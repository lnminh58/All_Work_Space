USE QuanLyNhanVienDB
CREATE VIEW V_table1 AS
SELECT N.MaNV, n.Tennv, t.TenTN FROM nhanvien n, thanNhan t
WHERE n.manv=t.manv	

CREATE VIEW V_table2 AS
SELECT manv,tennv FROM NHANVIEN

SELECT * FROM V_table1
SELECT * FROM V_table2
INSERT INTO V_table2(manv,tennv) VALUES ('915039147','minh',5)
/*Cannot insert the value NULL into column 'honv', table 'QuanLyNhanVienDB.dbo.NHANVIEN'; column does not allow nulls. INSERT fails.*/
DROP VIEW V_table1

EXEC sp_helptext V_table1

CREATE VIEW V_Sum AS
SELECT SUM(Luong) AS TongLuong, tennv FROM NHANVIEN AS n GROUP BY tennv
SELECT * FROM V_Sum

CREATE PROCEDURE SP_Cau1 AS
SELECT * FROM NHANVIEN
EXEC SP_Cau1

CREATE PROCEDURE SP_NHANVIEN 
@tennv NVARCHAR (50)
AS SELECT * FROM NHANVIEN
   WHERE tennv=@tennv
   
  EXEC SP_NHANVIEN N'Nh¿n'
  EXEC SP_NHANVIEN N'QUANG'
  
 