CREATE DATABASE DBStudent
USE DBStudent
CREATE TABLE student(
	ID NVARCHAR(5) NOT NULL PRIMARY KEY,
	Name NVARCHAR(50) NOT NULL,
	Gender BIT NOT NULL,
	ClassID NVARCHAR(4) NOT NULL) 
	DELETE FROM student
SELECT * FROM student AS s

INSERT INTO student VALUES 
	('SV001',N'Lê Ngọc Minh',1,'B001'),
	('SV002',N'Trần Đình Hùng',1,'B002'),
	('SV003',N'Trương Tấn',1,'B001'),
	('SV004',N'Đào Diễn',0,'B003'),
	('SV005',N'Nguyễn Thành Phát',1,'B002'),
	('SV006',N'Hà Hương Thủy',0,'B001'),
	('SV007',N'Nguyễn Ánh Khuê',0,'B003'),
	('SV008',N'Trương Minh',1,'B002'),
	('SV009',N'Lê Đình Phi Hoàng',1,'B003'),
	('SV010',N'Võ Cẩm Vy',0,'B001'),
	('SV011',N'Hoàng Kiều Ân',0,'B002')
	