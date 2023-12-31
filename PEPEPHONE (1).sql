

----CREATE DATABASE [PEPEPHONE]
--USE PEPEPHONE
-- CONTAINMENT = NONE
-- ON  PRIMARY 
--( NAME = N'PEPEPHONE', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PEPEPHONE.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
-- LOG ON 
--( NAME = N'PEPEPHONE_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PEPEPHONE_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
-- WITH CATALOG_COLLATION = DATABASE_DEFAULT
--GO
--ALTER DATABASE [PEPEPHONE] SET COMPATIBILITY_LEVEL = 150
--GO
--IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
--begin
--EXEC [PEPEPHONE].[dbo].[sp_fulltext_database] @action = 'enable'
--end
--GO
--ALTER DATABASE [PEPEPHONE] SET ANSI_NULL_DEFAULT OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET ANSI_NULLS OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET ANSI_PADDING OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET ANSI_WARNINGS OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET ARITHABORT OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET AUTO_CLOSE OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET AUTO_SHRINK OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET AUTO_UPDATE_STATISTICS ON 
--GO
--ALTER DATABASE [PEPEPHONE] SET CURSOR_CLOSE_ON_COMMIT OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET CURSOR_DEFAULT  GLOBAL 
--GO
--ALTER DATABASE [PEPEPHONE] SET CONCAT_NULL_YIELDS_NULL OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET NUMERIC_ROUNDABORT OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET QUOTED_IDENTIFIER OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET RECURSIVE_TRIGGERS OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET  DISABLE_BROKER 
--GO
--ALTER DATABASE [PEPEPHONE] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET DATE_CORRELATION_OPTIMIZATION OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET TRUSTWORTHY OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET ALLOW_SNAPSHOT_ISOLATION OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET PARAMETERIZATION SIMPLE 
--GO
--ALTER DATABASE [PEPEPHONE] SET READ_COMMITTED_SNAPSHOT OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET HONOR_BROKER_PRIORITY OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET RECOVERY FULL 
--GO
--ALTER DATABASE [PEPEPHONE] SET  MULTI_USER 
--GO
--ALTER DATABASE [PEPEPHONE] SET PAGE_VERIFY CHECKSUM  
--GO
--ALTER DATABASE [PEPEPHONE] SET DB_CHAINING OFF 
--GO
--ALTER DATABASE [PEPEPHONE] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
--GO
--ALTER DATABASE [PEPEPHONE] SET TARGET_RECOVERY_TIME = 60 SECONDS 
--GO
--ALTER DATABASE [PEPEPHONE] SET DELAYED_DURABILITY = DISABLED 
--GO
--ALTER DATABASE [PEPEPHONE] SET ACCELERATED_DATABASE_RECOVERY = OFF  
--GO
--EXEC sys.sp_db_vardecimal_storage_format N'PEPEPHONE', N'ON'
--GO
--ALTER DATABASE [PEPEPHONE] SET QUERY_STORE = OFF
--GO
USE [PEPEPHONE]
GO
/****** Object:  Table [dbo].[Almacen]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Almacen](
	[IdAlmacen] [int] NOT NULL,
	[Descripcion] [varchar](100) NULL,
	[Ciudad] [varchar](100) NULL,
	[Distrito] [varchar](100) NULL,
	[Direccion] [varchar](100) NULL,
	[Capacidad] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAlmacen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CategoriaCliente]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CategoriaCliente](
	[IdCategoriaCliente] [int] NOT NULL,
	[SegCliente] [nvarchar](50) NULL,
	[FrecCompra] [nvarchar](50) NULL,
	[Cuotas] [char](2) NULL,
	[CantCuotas] [nvarchar](50) NULL,
	[Estado] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCategoriaCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CategoriaProducto]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CategoriaProducto](
	[IdCategoria] [int] NOT NULL,
	[DescCategoria] [varchar](50) NULL,
	[Subcategoria] [int] NULL,
	[Garantia] [varchar](100) NULL,
	[Dimenciones] [varchar](100) NULL,
	[Observacion] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CategoriaServicio]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CategoriaServicio](
	[IdCategoriaServicio] [int] NOT NULL,
	[NombreServicio] [varchar](25) NULL,
	[CostoUnitario] [decimal](7, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCategoriaServicio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[IdCliente] [int] NOT NULL,
	[IdCategoriaCliente] [int] NULL,
	[NombCliente] [varchar](100) NULL,
	[ApellCliente] [varchar](100) NULL,
	[DocCliente] [int] NULL,
	[Telefono] [int] NULL,
	[Correo] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Compra]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Compra](
	[IdCompra] [int] NOT NULL,
	[FechaEntrega] [date] NULL,
	[IdEmpleado] [int] NULL,
	[IdProveedor] [int] NULL,
	[FechaCompra] [date] NULL,
	[TotalCompra] [decimal](7, 2) NULL,
	[Observación] [varchar](255) NULL,
	[Estado] [int] NULL,
	[TipoPago] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCompra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DetalleCompra]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetalleCompra](
	[IdDetalleCompra] [int] NOT NULL,
	[IdCompra] [int] NULL,
	[CostoUnitario] [int] NULL,
	[IdProducto] [int] NULL,
	[CantidadProducto] [int] NULL,
	[SubTotal] [decimal](7, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDetalleCompra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DetalleServicioCatServicio]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetalleServicioCatServicio](
	[IdDetalleServicio] [int] NOT NULL,
	[IdServicio] [int] NULL,
	[IdCategoriaServicio] [int] NULL,
	[Cantidad] [int] NULL,
	[CostoUnitario] [decimal](7, 2) NULL,
	[Subtotal] [decimal](7, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDetalleServicio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DetalleServicioProducto]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetalleServicioProducto](
	[IdDetalleServicio] [int] NOT NULL,
	[IdServicio] [int] NULL,
	[IdProducto] [int] NULL,
	[Cantidad] [int] NULL,
	[CostoUnitario] [decimal](7, 2) NULL,
	[Subtotal] [decimal](7, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDetalleServicio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DetalleVenta]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetalleVenta](
	[IdDetalleVenta] [int] NOT NULL,
	[IdVenta] [int] NULL,
	[IdProducto] [int] NULL,
	[CantidadProducto] [int] NULL,
	[CostoUnitario] [decimal](7, 2) NULL,
	[SubTotal] [decimal](7, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDetalleVenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Empleado]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Empleado](
	[IdEmpleado] [int] NOT NULL,
	[NomEmpleado] [nvarchar](50) NULL,
	[ApellEmpleado] [nvarchar](50) NULL,
	[DocEmpleado] [nvarchar](8) NULL,
	[Dirección] [nvarchar](50) NULL,
	[Telefono] [nvarchar](9) NULL,
	[Correo] [nvarchar](50) NULL,
	[FechaInicio] [date] NULL,
	[FechaFinal] [date] NULL,
	[Cargo] [nvarchar](50) NULL,
	[Estado] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEmpleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Inventario]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Inventario](
	[IdInventario] [int] NOT NULL,
	[IdProducto] [int] NULL,
	[IdAlmacen] [int] NULL,
	[CantidadStock] [int] NULL,
	[FechaActualizacion] [date] NULL,
	[MinimoStock] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdInventario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Producto]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Producto](
	[IdProducto] [int] NOT NULL,
	[IdCategoria] [int] NULL,
	[Marca] [varchar](25) NULL,
	[NombreProducto] [varchar](25) NULL,
	[CostoUnitario] [decimal](7, 2) NULL,
	[PrecioVenta] [decimal](7, 2) NULL,
	[FechaIngreso] [date] NULL,
	[Estado] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Proveedor]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Proveedor](
	[IdProveedor] [int] NOT NULL,
	[RUC] [int] NULL,
	[Nombre] [varchar](30) NULL,
	[Telefono] [int] NULL,
	[Correo] [varchar](20) NULL,
	[Dirección] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Servicio]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Servicio](
	[IdServicio] [int] NOT NULL,
	[IdEmpleado] [int] NULL,
	[IdCliente] [int] NULL,
	[FechaServicio] [date] NULL,
	[FechaEntrega] [date] NULL,
	[TotalServicio] [decimal](7, 2) NULL,
	[Observacion] [varchar](100) NULL,
	[Estado] [int] NULL,
	[TipoPago] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdServicio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[IdUsuario] [int] NOT NULL,
	[IdEmpleado] [int] NULL,
	[Usuario] [nvarchar](50) NULL,
	[Contraseña] [nvarchar](50) NULL,
	[UsrReg] [nvarchar](50) NULL,
	[FechReg] [date] NULL,
	[UsrMod] [nvarchar](50) NULL,
	[FechMod] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Venta]    Script Date: 27/11/2023 21:02:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Venta](
	[IdVenta] [int] NOT NULL,
	[IdEmpleado] [int] NULL,
	[IdCliente] [int] NULL,
	[FechaVenta] [date] NULL,
	[TotalVenta] [decimal](7, 2) NULL,
	[Observación] [varchar](100) NULL,
	[Estado] [int] NULL,
	[TipoPago] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_Cliente_CategoriaCliente1] FOREIGN KEY([IdCategoriaCliente])
REFERENCES [dbo].[CategoriaCliente] ([IdCategoriaCliente])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_Cliente_CategoriaCliente1]
GO
ALTER TABLE [dbo].[Compra]  WITH CHECK ADD  CONSTRAINT [FK_Compra_Empleado] FOREIGN KEY([IdEmpleado])
REFERENCES [dbo].[Empleado] ([IdEmpleado])
GO
ALTER TABLE [dbo].[Compra] CHECK CONSTRAINT [FK_Compra_Empleado]
GO
ALTER TABLE [dbo].[Compra]  WITH CHECK ADD  CONSTRAINT [FK_Compra_Proveedor] FOREIGN KEY([IdProveedor])
REFERENCES [dbo].[Proveedor] ([IdProveedor])
GO
ALTER TABLE [dbo].[Compra] CHECK CONSTRAINT [FK_Compra_Proveedor]
GO
ALTER TABLE [dbo].[DetalleCompra]  WITH CHECK ADD  CONSTRAINT [FK_DetalleCompra_Compra] FOREIGN KEY([IdCompra])
REFERENCES [dbo].[Compra] ([IdCompra])
GO
ALTER TABLE [dbo].[DetalleCompra] CHECK CONSTRAINT [FK_DetalleCompra_Compra]
GO
ALTER TABLE [dbo].[DetalleCompra]  WITH CHECK ADD  CONSTRAINT [FK_DetalleCompra_Producto] FOREIGN KEY([IdProducto])
REFERENCES [dbo].[Producto] ([IdProducto])
GO
ALTER TABLE [dbo].[DetalleCompra] CHECK CONSTRAINT [FK_DetalleCompra_Producto]
GO
ALTER TABLE [dbo].[DetalleServicioCatServicio]  WITH CHECK ADD  CONSTRAINT [FK_DetalleServicioCatServicio_CategoriaServicio] FOREIGN KEY([IdCategoriaServicio])
REFERENCES [dbo].[CategoriaServicio] ([IdCategoriaServicio])
GO
ALTER TABLE [dbo].[DetalleServicioCatServicio] CHECK CONSTRAINT [FK_DetalleServicioCatServicio_CategoriaServicio]
GO
ALTER TABLE [dbo].[DetalleServicioCatServicio]  WITH CHECK ADD  CONSTRAINT [FK_DetalleServicioCatServicio_Servicio] FOREIGN KEY([IdServicio])
REFERENCES [dbo].[Servicio] ([IdServicio])
GO
ALTER TABLE [dbo].[DetalleServicioCatServicio] CHECK CONSTRAINT [FK_DetalleServicioCatServicio_Servicio]
GO
ALTER TABLE [dbo].[DetalleServicioProducto]  WITH CHECK ADD  CONSTRAINT [FK_DetalleServicioProducto_Producto] FOREIGN KEY([IdProducto])
REFERENCES [dbo].[Producto] ([IdProducto])
GO
ALTER TABLE [dbo].[DetalleServicioProducto] CHECK CONSTRAINT [FK_DetalleServicioProducto_Producto]
GO
ALTER TABLE [dbo].[DetalleServicioProducto]  WITH CHECK ADD  CONSTRAINT [FK_DetalleServicioProducto_Servicio1] FOREIGN KEY([IdServicio])
REFERENCES [dbo].[Servicio] ([IdServicio])
GO
ALTER TABLE [dbo].[DetalleServicioProducto] CHECK CONSTRAINT [FK_DetalleServicioProducto_Servicio1]
GO
ALTER TABLE [dbo].[DetalleVenta]  WITH CHECK ADD  CONSTRAINT [FK_DetalleVenta_Producto] FOREIGN KEY([IdProducto])
REFERENCES [dbo].[Producto] ([IdProducto])
GO
ALTER TABLE [dbo].[DetalleVenta] CHECK CONSTRAINT [FK_DetalleVenta_Producto]
GO
ALTER TABLE [dbo].[DetalleVenta]  WITH CHECK ADD  CONSTRAINT [FK_DetalleVenta_Venta] FOREIGN KEY([IdVenta])
REFERENCES [dbo].[Venta] ([IdVenta])
GO
ALTER TABLE [dbo].[DetalleVenta] CHECK CONSTRAINT [FK_DetalleVenta_Venta]
GO
ALTER TABLE [dbo].[Inventario]  WITH CHECK ADD  CONSTRAINT [FK_Inventario_Almacen] FOREIGN KEY([IdAlmacen])
REFERENCES [dbo].[Almacen] ([IdAlmacen])
GO
ALTER TABLE [dbo].[Inventario] CHECK CONSTRAINT [FK_Inventario_Almacen]
GO
ALTER TABLE [dbo].[Inventario]  WITH CHECK ADD  CONSTRAINT [FK_Inventario_Producto] FOREIGN KEY([IdProducto])
REFERENCES [dbo].[Producto] ([IdProducto])
GO
ALTER TABLE [dbo].[Inventario] CHECK CONSTRAINT [FK_Inventario_Producto]
GO
ALTER TABLE [dbo].[Producto]  WITH CHECK ADD  CONSTRAINT [FK_Producto_CategoriaProducto] FOREIGN KEY([IdCategoria])
REFERENCES [dbo].[CategoriaProducto] ([IdCategoria])
GO
ALTER TABLE [dbo].[Producto] CHECK CONSTRAINT [FK_Producto_CategoriaProducto]
GO
ALTER TABLE [dbo].[Servicio]  WITH CHECK ADD  CONSTRAINT [FK_Servicio_Cliente] FOREIGN KEY([IdCliente])
REFERENCES [dbo].[Cliente] ([IdCliente])
GO
ALTER TABLE [dbo].[Servicio] CHECK CONSTRAINT [FK_Servicio_Cliente]
GO
ALTER TABLE [dbo].[Servicio]  WITH CHECK ADD  CONSTRAINT [FK_Servicio_Empleado] FOREIGN KEY([IdEmpleado])
REFERENCES [dbo].[Empleado] ([IdEmpleado])
GO
ALTER TABLE [dbo].[Servicio] CHECK CONSTRAINT [FK_Servicio_Empleado]
GO
ALTER TABLE [dbo].[Usuario]  WITH CHECK ADD  CONSTRAINT [FK_Usuario_Empleado] FOREIGN KEY([IdEmpleado])
REFERENCES [dbo].[Empleado] ([IdEmpleado])
GO
ALTER TABLE [dbo].[Usuario] CHECK CONSTRAINT [FK_Usuario_Empleado]
GO
ALTER TABLE [dbo].[Venta]  WITH CHECK ADD  CONSTRAINT [FK_Venta_Cliente] FOREIGN KEY([IdCliente])
REFERENCES [dbo].[Cliente] ([IdCliente])
GO
ALTER TABLE [dbo].[Venta] CHECK CONSTRAINT [FK_Venta_Cliente]
GO
ALTER TABLE [dbo].[Venta]  WITH CHECK ADD  CONSTRAINT [FK_Venta_Empleado] FOREIGN KEY([IdEmpleado])
REFERENCES [dbo].[Empleado] ([IdEmpleado])
GO
ALTER TABLE [dbo].[Venta] CHECK CONSTRAINT [FK_Venta_Empleado]
GO
USE [master]
GO
ALTER DATABASE [PEPEPHONE] SET  READ_WRITE 
GO
