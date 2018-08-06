USE [master]
DROP DATABASE CUS_PROPERTY
CREATE DATABASE CUS_PROPERTY 
USE CUS_PROPERTY

CREATE TABLE CUSTOMER(
	CNo		VARCHAR(10) NOT NULL,
	CName	NVARCHAR(50) NOT NULL,
	Tel		VARCHAR(10),
	CAddress	NVARCHAR(150),
	PRIMARY KEY (CNo)
)
CREATE TABLE OWNERS(
	ONo		VARCHAR(10) NOT NULL,
	OName	NVARCHAR(50) NOT NULL,
	OTel	VARCHAR(10) ,
	OAddress	NVARCHAR(150),
	PRIMARY KEY (ONo)
	
)

CREATE TABLE PROPERTY(
	Property_No VARCHAR(10)		NOT NULL,
	Paddress	NVARCHAR(150)	NOT NULL,
	RentPrice	INT				NOT NULL,
	OwnerNo		VARCHAR(10)		NOT NULL FOREIGN KEY REFERENCES OWNERS(ONo) ON DELETE CASCADE,
	PRIMARY KEY (Property_No)
	
)

CREATE TABLE RENTAL(
	CNo			VARCHAR(10)	NOT NULL FOREIGN KEY REFERENCES CUSTOMER(CNo) ON DELETE CASCADE,
	Property_No VARCHAR(10)	NOT NULL FOREIGN KEY REFERENCES PROPERTY(Property_No) ON DELETE CASCADE,
	RentStart	DATE		NOT NULL,
	RentFinish	DATE,
	PRIMARY KEY (CNo,Property_No,RentStart)

)
--cau a

CREATE VIEW cus_rental_vw AS
SELECT c.CNo, c.CName,r.Property_No,r.RentStart,r.RentFinish FROM CUSTOMER AS c,RENTAL AS r
WHERE c.CNo=r.CNo
--cau b
SELECT * FROM cus_rental_vw c
ORDER BY c.CName desc

SELECT TOP(3)*FROM cus_rental_vw c
ORDER BY c.CName ASC

--cau c
DROP VIEW cus_rental_vw
CREATE VIEW cus_rental_vw AS
SELECT c.CNo, c.CName,r.RentStart,r.RentFinish FROM CUSTOMER AS c,RENTAL AS r
WHERE c.CNo=r.CNo

--câu g
DROP VIEW property_VW
CREATE VIEW property_vw AS
SELECT * FROM PROPERTY
WHERE PROPERTY.RentPrice>300
WITH CHECK OPTION  -- b? cái này thì ko còn check ?c n?u insert or update

SELECT*FROM property_vw
--câu h
DELETE FROM PROPERTY
WHERE Property_No='P011'
INSERT INTO property_vw VALUES (
'P011', '15 Chau Van Liem street, 2 dist, HCM city', 370, 'W002' 
)
UPDATE property_vw
SET
	RentPrice=250
WHERE Property_No='P011'