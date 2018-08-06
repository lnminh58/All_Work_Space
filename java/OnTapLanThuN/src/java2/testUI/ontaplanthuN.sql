CREATE DATABASE DBEmployee
USE DBEmployee

CREATE TABLE employee (
	id INT IDENTITY(1,1) PRIMARY KEY,
	name NVARCHAR(30) NOT NULL,
	gender BIT,
	age INT
)

CREATE PROCEDURE sp_loadEmployees AS
SELECT * FROM employee

CREATE PROCEDURE sp_addEmployee
	@name NVARCHAR(30),
	@gender BIT,
	@age INT
AS
INSERT INTO employee
(
	
	name,
	gender,
	age
)
VALUES
(
	@name ,
	@gender,
	@age 
)


CREATE PROCEDURE sp_updateEmployee
@id INT,
	@name NVARCHAR(30),
	@gender BIT,
	@age INT
AS
UPDATE employee
SET
	-- id -- this column value is auto-generated
	name =  @name,
	gender = @gender,
	age = @age
WHERE id = @id

DELETE FROM employee
DBCC CHECKIDENT ('[employee]', RESEED, 0);
GO