USE [master]
GO
/****** Object:  Database [StudentsAndTeachers]    Script Date: 5/23/2022 1:01:40 AM ******/
CREATE DATABASE [StudentsAndTeachers]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'StudentsAndTeachers', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\StudentsAndTeachers.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'StudentsAndTeachers_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\StudentsAndTeachers_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [StudentsAndTeachers] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [StudentsAndTeachers].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [StudentsAndTeachers] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET ARITHABORT OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [StudentsAndTeachers] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [StudentsAndTeachers] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET  DISABLE_BROKER 
GO
ALTER DATABASE [StudentsAndTeachers] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [StudentsAndTeachers] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [StudentsAndTeachers] SET  MULTI_USER 
GO
ALTER DATABASE [StudentsAndTeachers] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [StudentsAndTeachers] SET DB_CHAINING OFF 
GO
ALTER DATABASE [StudentsAndTeachers] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [StudentsAndTeachers] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [StudentsAndTeachers] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [StudentsAndTeachers] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [StudentsAndTeachers] SET QUERY_STORE = OFF
GO
USE [StudentsAndTeachers]
GO
/****** Object:  User [hui]    Script Date: 5/23/2022 1:01:40 AM ******/
CREATE USER [hui] FOR LOGIN [JSUser] WITH DEFAULT_SCHEMA=[db_owner]
GO
/****** Object:  Table [dbo].[Principals]    Script Date: 5/23/2022 1:01:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Principals](
	[principalId] [int] IDENTITY(1,1) NOT NULL,
	[schoolName] [nvarchar](255) NOT NULL,
	[isVerified] [bit] NOT NULL,
	[userId] [int] NOT NULL,
 CONSTRAINT [PK_Principals] PRIMARY KEY CLUSTERED 
(
	[principalId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Projects]    Script Date: 5/23/2022 1:01:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Projects](
	[projectId] [int] IDENTITY(1,1) NOT NULL,
	[dueDate] [datetime2](7) NOT NULL,
	[startDate] [datetime2](7) NOT NULL,
	[title] [nvarchar](255) NOT NULL,
	[description] [ntext] NOT NULL,
 CONSTRAINT [PK_Projects] PRIMARY KEY CLUSTERED 
(
	[projectId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Students]    Script Date: 5/23/2022 1:01:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Students](
	[studentId] [int] IDENTITY(1,1) NOT NULL,
	[parentPhone] [varbinary](max) NOT NULL,
	[parentAddress] [varbinary](max) NOT NULL,
	[parentEmail] [varbinary](max) NOT NULL,
	[userId] [int] NOT NULL,
 CONSTRAINT [PK_Students] PRIMARY KEY CLUSTERED 
(
	[studentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Students-Teams]    Script Date: 5/23/2022 1:01:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Students-Teams](
	[studentId] [int] NOT NULL,
	[teamId] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tasks]    Script Date: 5/23/2022 1:01:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tasks](
	[taskId] [int] IDENTITY(1,1) NOT NULL,
	[teacherId] [int] NOT NULL,
	[studentId] [int] NOT NULL,
	[dueDate] [datetime2](7) NOT NULL,
	[description] [text] NOT NULL,
	[title] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK_Tasks] PRIMARY KEY CLUSTERED 
(
	[taskId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Teachers]    Script Date: 5/23/2022 1:01:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teachers](
	[teacherId] [int] IDENTITY(1,1) NOT NULL,
	[subjectName] [nvarchar](255) NOT NULL,
	[userId] [int] NOT NULL,
 CONSTRAINT [PK_Teachers] PRIMARY KEY CLUSTERED 
(
	[teacherId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Teams]    Script Date: 5/23/2022 1:01:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teams](
	[teamId] [int] IDENTITY(1,1) NOT NULL,
	[teamName] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK_Teams] PRIMARY KEY CLUSTERED 
(
	[teamId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Teams-Projects]    Script Date: 5/23/2022 1:01:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teams-Projects](
	[teamId] [int] NOT NULL,
	[projectId] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 5/23/2022 1:01:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[userId] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](255) NOT NULL,
	[firstName] [nvarchar](255) NOT NULL,
	[lastName] [nvarchar](255) NOT NULL,
	[password] [varbinary](max) NOT NULL,
	[address] [varbinary](max) NOT NULL,
	[phone] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK_Users] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Principals] ADD  CONSTRAINT [DF_Principals_isVerified]  DEFAULT ('FALSE') FOR [isVerified]
GO
ALTER TABLE [dbo].[Projects] ADD  CONSTRAINT [DF_Projects_startDate]  DEFAULT (getdate()) FOR [startDate]
GO
ALTER TABLE [dbo].[Principals]  WITH CHECK ADD  CONSTRAINT [FK_Principals_Users] FOREIGN KEY([userId])
REFERENCES [dbo].[Users] ([userId])
GO
ALTER TABLE [dbo].[Principals] CHECK CONSTRAINT [FK_Principals_Users]
GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD  CONSTRAINT [FK_Students_Users] FOREIGN KEY([userId])
REFERENCES [dbo].[Users] ([userId])
GO
ALTER TABLE [dbo].[Students] CHECK CONSTRAINT [FK_Students_Users]
GO
ALTER TABLE [dbo].[Students-Teams]  WITH CHECK ADD  CONSTRAINT [FK_Students-Teams_Students] FOREIGN KEY([studentId])
REFERENCES [dbo].[Students] ([studentId])
GO
ALTER TABLE [dbo].[Students-Teams] CHECK CONSTRAINT [FK_Students-Teams_Students]
GO
ALTER TABLE [dbo].[Students-Teams]  WITH CHECK ADD  CONSTRAINT [FK_Students-Teams_Teams] FOREIGN KEY([teamId])
REFERENCES [dbo].[Teams] ([teamId])
GO
ALTER TABLE [dbo].[Students-Teams] CHECK CONSTRAINT [FK_Students-Teams_Teams]
GO
ALTER TABLE [dbo].[Tasks]  WITH CHECK ADD  CONSTRAINT [FK_Tasks_Students] FOREIGN KEY([studentId])
REFERENCES [dbo].[Students] ([studentId])
GO
ALTER TABLE [dbo].[Tasks] CHECK CONSTRAINT [FK_Tasks_Students]
GO
ALTER TABLE [dbo].[Tasks]  WITH CHECK ADD  CONSTRAINT [FK_Tasks_Teachers] FOREIGN KEY([teacherId])
REFERENCES [dbo].[Teachers] ([teacherId])
GO
ALTER TABLE [dbo].[Tasks] CHECK CONSTRAINT [FK_Tasks_Teachers]
GO
ALTER TABLE [dbo].[Teachers]  WITH CHECK ADD  CONSTRAINT [FK_Teachers_Users1] FOREIGN KEY([userId])
REFERENCES [dbo].[Users] ([userId])
GO
ALTER TABLE [dbo].[Teachers] CHECK CONSTRAINT [FK_Teachers_Users1]
GO
ALTER TABLE [dbo].[Teams-Projects]  WITH CHECK ADD  CONSTRAINT [FK_Teams-Projects_Projects] FOREIGN KEY([projectId])
REFERENCES [dbo].[Projects] ([projectId])
GO
ALTER TABLE [dbo].[Teams-Projects] CHECK CONSTRAINT [FK_Teams-Projects_Projects]
GO
ALTER TABLE [dbo].[Teams-Projects]  WITH CHECK ADD  CONSTRAINT [FK_Teams-Projects_Teams] FOREIGN KEY([teamId])
REFERENCES [dbo].[Teams] ([teamId])
GO
ALTER TABLE [dbo].[Teams-Projects] CHECK CONSTRAINT [FK_Teams-Projects_Teams]
GO
ALTER TABLE [dbo].[Projects]  WITH CHECK ADD  CONSTRAINT [CK_Projects_dueDate] CHECK  (([dueDate]>=getdate()))
GO
ALTER TABLE [dbo].[Projects] CHECK CONSTRAINT [CK_Projects_dueDate]
GO
ALTER TABLE [dbo].[Tasks]  WITH CHECK ADD  CONSTRAINT [CK_dueDate] CHECK  (([dueDate]>=getdate()))
GO
ALTER TABLE [dbo].[Tasks] CHECK CONSTRAINT [CK_dueDate]
GO
/****** Object:  StoredProcedure [dbo].[insertStudent]    Script Date: 5/23/2022 1:01:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<poznai ot 3-tiq put>
-- Create date: <po-kusno no pak dnes>
-- Description:	<veche e tumno i ne sum ql>
-- =============================================
CREATE PROCEDURE [dbo].[insertStudent]
	@parentPhone varchar(50),
	@parentAddress nvarchar(255),
	@parentEmail varchar(255),
	@userId int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	INSERT INTO Students(parentPhone,parentAddress,parentEmail,userId)
	VALUES(CONVERT(varbinary(max),EncryptByPassPhrase('hui',@parentPhone),2),
	CONVERT(varbinary(max),EncryptByPassPhrase('hui',@parentAddress),2),
	CONVERT(varbinary(max),EncryptByPassPhrase('hui',@parentEmail),2),
	@userId)
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<poznai ot 3-tiq put>
-- Create date: <po-kusno no pak dnes>
-- Description:	<veche e tumno i ne sum ql>
-- =============================================
CREATE PROCEDURE [dbo].[insertTeacher]
	@subjectName nvarchar(255),
	@userId int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	INSERT INTO Teachers(subjectName,userId)
	VALUES(@subjectName,@userId)
END
GO
/****** Object:  StoredProcedure [dbo].[insertUser]    Script Date: 5/23/2022 1:01:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Martin Atanasov>
-- Create date: <dnes>
-- Description:	<nz kvo pravq navun e slunchevo a az pisha kod>
-- =============================================
Create PROCEDURE [dbo].[insertUser]
	@Username nvarchar(255),
	@FirstName nvarchar(255),
	@LastName nvarchar(255),
	@Password nvarchar(255),
	@Address nvarchar(255),
	@Phone varchar(50)
AS
BEGIN
	
	SET NOCOUNT ON;
	INSERT INTO Users(username,firstName,lastName,password,address,phone)
	VALUES(@Username,@FirstName,@LastName, CONVERT(varbinary(max),EncryptByPassPhrase('hui',@Password)   ,2),
	CONVERT(varbinary(max),EncryptByPassPhrase('hui',@Address)   ,2), @Phone);

END
GO
/****** Object:  StoredProcedure [dbo].[returnPassword]    Script Date: 5/23/2022 1:01:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<pak az>
-- Create date: <pak dnes>
-- Description:	<sushtoto>
-- =============================================
CREATE PROCEDURE  [dbo].[returnPassword]
	@username nvarchar(255)

AS
BEGIN
	SELECT username,CONVERT(nvarchar(max),DecryptByPassPhrase('hui',password)) as password
	FROM Users
	WHERE username=@username;
END
GO
/****** Object:  StoredProcedure [dbo].[returnStudentData]    Script Date: 5/23/2022 1:01:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<poznai ot 3-tiq put>
-- Create date: <po-kusno no pak dnes>
-- Description:	<veche e tumno i ne sum ql>
-- =============================================
CREATE PROCEDURE [dbo].[returnStudentData]
@userId int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	SELECT [studentId]
      ,CONVERT(varchar(max),DecryptByPassPhrase('hui',[parentPhone])) as [parentPhone]    
      ,CONVERT(nvarchar(max),DecryptByPassPhrase('hui',[parentAddress])) as [parentAddress]     
      ,CONVERT(varchar(max),DecryptByPassPhrase('hui',[parentEmail])) as [parentEmail]   
      ,[userId]
  FROM [StudentsAndTeachers].[dbo].[Students]
  WHERE userId=@userId
END
GO
USE [master]
GO
ALTER DATABASE [StudentsAndTeachers] SET  READ_WRITE 
GO
