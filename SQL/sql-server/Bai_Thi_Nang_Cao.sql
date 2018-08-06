USE ThueXeDB

-- câu 1
--a 
DROP VIEW V_nhacungcap
CREATE VIEW V_NhaCungCap AS
SELECT * FROM NHACUNGCAP WHERE DiaChi='Lien Chieu'

SELECT * FROM V_NhaCungCap
--b
UPDATE V_NhaCungCap
SET DiaChi='Thanh Khe'
-- câu 2
-- sửa lại khóa ngoại thêm on delete cascade để xóa được. Đầu tiên xóa rồi sau đó thêm lại
ALTER TABLE DANGKYCUNGCAP DROP CONSTRAINT FK__DANGKYCUN__DongX__1ED998B2 -- xóa khóa với fk... là tên của khóa
ALTER TABLE DANGKYCUNGCAP ADD CONSTRAINT  Myforeignkey FOREIGN KEY (dongxe) REFERENCES Dongxe(dongxe) ON DELETE CASCADE -- thêm lại khóa
 -- a
CREATE PROC Sp_1 
	@tendongxe CHAR (10)
AS DELETE FROM DONGXE
   WHERE DongXe=@tendongxe
   
EXEC Sp_1 'grand-i-10'
-- b chỗ này làm thì chạy được nhưng không hiểu chổ ràng buộc lắm.
CREATE PROC Sp_02 
	@MaDKCC char(5) ,@MaNhaCC char(6),@MaLoaiDV char(4), @DongXe varchar(30), @MaMP char(4),
	@NgayBatDauCungCap DATE, @NgayKetThucCungCap date, @SoLuongXeDangKy INT
AS
INSERT INTO DANGKYCUNGCAP VALUES (@MaDKCC,@MaNhaCC,@MaLoaiDV,@DongXe,@MaMP,@NgayBatDauCungCap,@NgayKetThucCungCap,@SoLuongXeDangKy)

EXEC Sp_02 'DK026','NCC004','DV01','Hiace','MP01','2015-11-20','2016-11-20',4

-- câu 3

