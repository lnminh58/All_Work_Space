USE education;

CREATE TABLE role(
	id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	name VARCHAR(50) NOT NULL
)

CREATE TABLE users (
	username VARCHAR(50) NOT NULL PRIMARY KEY,
	password VARCHAR(100) NOT NULL
)

CREATE TABLE user_role(
	username VARCHAR(50) NOT NULL FOREIGN KEY REFERENCES users(username),
	role_id int NOT NULL FOREIGN KEY REFERENCES role(id)
)
