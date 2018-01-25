/* ==== CREATE DATABASE ==== */
CREATE DATABASE DemoStruts
GO
USE DemoStruts
GO
-- USE MASTER
-- GO
/* ==== CREATE TABLE ==== */
-- 1. User
CREATE TABLE Account
(
	AccountID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	Username VARCHAR(50) NULL,
	[Password] VARCHAR(100) NULL
)
GO
INSERT INTO Account VALUES
('admin','e10adc3949ba59abbe56e057f20f883e'),
('customer','e10adc3949ba59abbe56e057f20f883e')
GO
-- 2: Book
CREATE TABLE Book
(
	BookID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	BookName VARCHAR(60) NULL,
	BookPrice FLOAT NULL,
	Publish DATETIME NULL
)
GO
INSERT INTO Book VALUES
('Book 1',1000,'2015-08-05'), ('Book 2',2000,'2015-08-05'),
('Book 3',3000,'2015-08-05'), ('Book 4',1000,'2015-08-05')
GO

/* ==== CREATE PROC ==== */
-- 1: procBookSelect
CREATE PROC procBookSelect
AS
	SELECT BOOK.BookID, BOOK.BookName, BOOK.BookPrice, BOOK.Publish
	FROM Book BOOK
GO
-- 2: procBookInsert
CREATE PROC procBookInsert
(@BookName VARCHAR(60), @BookPrice FLOAT, @Publish DATETIME)
AS BEGIN
	INSERT INTO Book VALUES(@BookName, @BookPrice, @Publish)
END
GO
-- 3: procBookUpdate
CREATE PROC procBookUpdate
(@BookID INT, @BookName VARCHAR(60), @BookPrice FLOAT, @Publish DATETIME)
AS BEGIN
	UPDATE Book SET BookName = @BookName, BookPrice = @BookPrice, Publish = @Publish
	WHERE BookID = @BookID
END
GO
-- 4: procBookDelete
CREATE PROC procBookDelete
(@BookID INT)
AS BEGIN
	DELETE FROM Book WHERE BookID = @BookID
END
GO
-- 5: procBookSelectByID
CREATE PROC procBookSelectByID
(@BookID INT)
AS BEGIN
	SELECT BOOK.BookID, BOOK.BookName, BOOK.BookPrice, BOOK.Publish
	FROM Book BOOK
	WHERE BookID = @BookID
END
GO
-- 6: procBookSelectByName
CREATE PROC procBookSelectByName
(@BookName VARCHAR(60))
AS BEGIN
	SELECT BOOK.BookID, BOOK.BookName, BOOK.BookPrice, BOOK.Publish
	FROM Book BOOK
	WHERE BookName LIKE '%' + @BookName + '%'
END
GO