USE [master]
GO

IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'ProjectDB')
BEGIN
	ALTER DATABASE [ProjectDB] SET OFFLINE WITH ROLLBACK IMMEDIATE;
	ALTER DATABASE [ProjectDB] SET ONLINE;
	DROP DATABASE [ProjectDB];
END

CREATE DATABASE ProjectDB
GO

USE ProjectDB
GO
create table Categories(
Cid varchar(6) primary key,
name nvarchar(50)
)

INSERT [dbo].[Categories] ([Cid], [name]) VALUES (N'1', N'T-Shirt')
INSERT [dbo].[Categories] ([Cid], [name]) VALUES (N'2', N'Hoodie')
INSERT [dbo].[Categories] ([Cid], [name]) VALUES (N'3', N'Jacket')
INSERT [dbo].[Categories] ([Cid], [name]) VALUES (N'4', N'Pants')
GO

CREATE TABLE Products
(
	Pid VARCHAR(6) PRIMARY KEY,
	[name] NVARCHAR(30),
	Cid VARCHAR(6) FOREIGN KEY REFERENCES Categories(Cid),
	[image] VARCHAR(50),
	price float,
	[description] NVARCHAR(1000),
	dateCreated DATE,
)
INSERT INTO Products VALUES('A01', N'T-Shirt Phantom',1,'images/tee-phantom-black.jpg', 320000, N'Chất liệu đẹp, thoáng mát', '2021-06-15')
INSERT INTO Products VALUES('A02', N'Tết Sài Gòn',1,'images/tet-sg.jpg', 300000, N'Thiết kế độc đáo, vải co giãn ' ,'2021-06-15')
INSERT INTO Products VALUES('A03', N'Polo Mascot',1,'images/POLO-MASCOT_BLACK.jpg', 320000, N'Co giãn 4 chiều','2021-06-15')
INSERT INTO Products VALUES('A04' ,N'Icon Ant Blue',2,'images/hoodie-zip-icon-ant-blue_1.jpg', 400000, N'Chất liệu đẹp, thoáng mát','2021-06-15')
INSERT INTO Products VALUES('A05', N'Hoodie Character',2,'images/hoodie-characters-white.jpg', 590000, N'Thời trang','2021-06-15')
INSERT INTO Products VALUES('A06', N'Tee graffity',1,'images/TEE-GRAFFITY_tan.jpg', 320000,  N'Chất liệu đẹp, thời trang,....','2021-06-15')
INSERT INTO Products VALUES('A07', N'Jacket icon ant',3,'images/jacket-icon-ant_black.jpg', 400000, N'Chất liệu đẹp, thời trang,....','2021-06-15')
INSERT INTO Products VALUES('A08', N'Jacket Varsity ssssly',3,'images/jacket-Varsity-ssssly.jpg', 450000, N'Chất liệu đẹp, thời trang,....','2021-06-15')
INSERT INTO Products VALUES('Q01', N'Pant Logo',4,'images/Pant-logo-v2-1.jpg', 350000, N'Đẹp','2021-06-15')
INSERT INTO Products VALUES('Q02', N'Pant Sticker',4,'images/pant-sticker-tan.jpg', 350000, N'Thời trang, phong cách','2021-06-15')
GO

CREATE TABLE Size(
	Pid varchar(6)  FOREIGN KEY REFERENCES Products(Pid),
	[name] varchar(5),
	size_quantity int,
)
INSERT INTO Size VALUES('A01','M',8)
INSERT INTO Size VALUES('A01','L',12)
INSERT INTO Size VALUES('A01','XL',0)
INSERT INTO Size VALUES('A02','M',5)
INSERT INTO Size VALUES('A02','L',6)
INSERT INTO Size VALUES('A02','XL',11)
INSERT INTO Size VALUES('A03','M',5)
INSERT INTO Size VALUES('A03','L',9)
INSERT INTO Size VALUES('A03','XL',10)
INSERT INTO Size VALUES('A04','M',10)
INSERT INTO Size VALUES('A04','L',15)
INSERT INTO Size VALUES('A04','XL',20)
INSERT INTO Size VALUES('A05','M',12)
INSERT INTO Size VALUES('A05','L',21)
INSERT INTO Size VALUES('A05','XL',13)
INSERT INTO Size VALUES('A06','M',10)
INSERT INTO Size VALUES('A06','L',1)
INSERT INTO Size VALUES('A06','XL',7)
INSERT INTO Size VALUES('A07','M',4)
INSERT INTO Size VALUES('A07','L',9)
INSERT INTO Size VALUES('A07','XL',4)
INSERT INTO Size VALUES('A08','M',16)
INSERT INTO Size VALUES('A08','L',10)
INSERT INTO Size VALUES('A08','XL',6)
INSERT INTO Size VALUES('Q01','M',9)
INSERT INTO Size VALUES('Q01','L',11)
INSERT INTO Size VALUES('Q01','XL',10)
INSERT INTO Size VALUES('Q02','M',12)
INSERT INTO Size VALUES('Q02','L',10)
INSERT INTO Size VALUES('Q02','XL',14)

GO

Create table Users(
account varchar(30) primary key,
password varchar(100),
fullname nvarchar(50),
address nvarchar(100),
gender bit,
dob date,
role varchar(6),
points int
)
GO

INSERT [dbo].[Users] ([account], [password], [fullname], [address], [gender], [dob], [role], [points]) VALUES (N'admin', N'123', N'Triệu Văn Giang', N'Lạng Sơn City', 1, CAST(N'2000-01-02' AS Date), N'1', 0)
INSERT [dbo].[Users] ([account], [password], [fullname], [address], [gender], [dob], [role], [points]) VALUES (N'cuongnm', N'123', N'Cường Top', N'Thái Bình', 1, CAST(N'2000-08-03' AS Date), N'2', 0)
INSERT [dbo].[Users] ([account], [password], [fullname], [address], [gender], [dob], [role], [points]) VALUES (N'giangtv', N'123', N'Giang', N'Lạng Sơn', 1, CAST(N'2000-01-02' AS Date), N'2', 0)
INSERT [dbo].[Users] ([account], [password], [fullname], [address], [gender], [dob], [role], [points]) VALUES (N'thanhnm', N'123', N'Thành', N'Hưng Yên', 1, CAST(N'2000-06-07' AS Date), N'2', 0)

CREATE TABLE [Orders](
	id INT IDENTITY(1,1) PRIMARY KEY,
	[date] DATE,
	usernameCustomer varchar(30) REFERENCES Users(account),
	totalMoney MONEY,
)
INSERT INTO Orders VALUES('2020-12-22','cuongnm',900000)
INSERT INTO Orders VALUES('2021-01-29','giangtv',1200000)
INSERT INTO Orders VALUES('2021-02-13','admin',400000)
INSERT INTO Orders VALUES('2021-03-13','admin',600000)
INSERT INTO Orders VALUES('2021-03-14','cuongnm',400000)
INSERT INTO Orders VALUES('2021-03-15','giangtv',320000)
INSERT INTO Orders VALUES('2021-03-15','thanhnm',400000)
INSERT INTO Orders VALUES('2021-03-25','admin',400000)

GO

CREATE TABLE OrderLine(
	oid INT REFERENCES Orders(id),
	pid VARCHAR(6) FOREIGN KEY REFERENCES Products(Pid),
	[size] VARCHAR(5),
	quantity INT,
	price FLOAT,
)
INSERT INTO OrderLine VALUES(1,'A02','M',1,300000)
INSERT INTO OrderLine VALUES(1,'A02','L',1,300000)
INSERT INTO OrderLine VALUES(2,'A01','XL',1,320000)
INSERT INTO OrderLine VALUES(3,'A07','L',1,400000)
INSERT INTO OrderLine VALUES(4,'Q01','L',1,400000)
INSERT INTO OrderLine VALUES(5,'A04','M',1,400000)
INSERT INTO OrderLine VALUES(6,'A03','L',3,320000)
INSERT INTO OrderLine VALUES(7,'A08','XL',2,450000)
INSERT INTO OrderLine VALUES(8,'A04','M',1,400000)
