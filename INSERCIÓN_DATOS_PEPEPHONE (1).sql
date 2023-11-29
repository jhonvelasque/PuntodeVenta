--TABLA CATEGORIA CLIENTE
INSERT INTO [dbo].[CategoriaCliente] 
VALUES 
	(1,'Joven','Poco Frecuente','Si','Sin cuotas',1),
	(2,'Adulto','Poco Frecuente', 'No','1 cuota',0),
	(3,'Joven','Frecuente','No','3 cuotas',0),
	(4,'Joven','Poco Frecuente','Si','1 cuota',1),
	(5,'Adulto','Poco Frecuente','No','Sin cuotas',0),
	(6,'Adulto','Frecuente','No','3 cuotas',1),
	(7,'Joven','Frecuente','Si','3 cuotas',0),
	(8,'Adulto','Poco Frecuente','Si','4 cuotas',0),
	(9,'Joven','Frecuente','No','4 cuotas',1),
	(10,'Adulto','Poco Frecuente','Si','2 cuotas',1);

--TABLA CATEGORIA SERVICIO
INSERT INTO [dbo].[CATEGORIASERVICIO]
VALUES 
    (1, 'Limpieza de Pantalla', 50.75),
    (2, 'Cambio de Batería', 75.50),
    (3,'Cambio de Cámara', 120.25),
    (4,'Reparación de Botones', 90.00),
    (5,'Actualización de Software', 65.99),
    (6, 'Cambio de Altavoz', 110.00),
    (7, 'Instalación de Aplicacion', 80.50),
    (8, 'Diagnóstico de Problemas', 55.25),
    (9, 'Reparación de Conexiones', 95.75),
    (10, 'Restauración de Fábrica', 70.20);

--- TABLA CATEGORIA PRODUCTO
INSERT INTO [dbo].[CategoriaProducto] 
VALUES
    (1, 'Teléfonos Celulares', 1, '1 año', 'Variables', 'Categoría general para teléfonos celulares'),
    (2, 'Smartphone', 2, '1 año', 'Variables', 'Categoría general para smartphones'),
    (3, 'Teléfono Básico', 2, '6 meses', 'Variables', 'Categoría general para teléfonos básicos'),
    (4, 'Accesorios', 0, 'Variables', '6 meses', 'Categoría general para accesorios de teléfonos celulares'),
    (5, 'Fundas', 0, 'Variables', '1 año', 'Fundas protectoras para teléfonos celulares'),
    (6, 'Cargadores', 1, 'Variables', '3 meses', 'Cargadores para teléfonos celulares'),
    (7, 'Protectores de Pantalla', 3, '3 meses', 'Pequeño', 'Protectores de pantalla para teléfonos celulares'),
    (8, 'Reparación', 3, 'Variables', '3 meses', 'Categoría general para servicios de reparación de teléfonos celulares');

--TABLA EMPLEADO
INSERT INTO Empleado VALUES (2000,'Victor Onan','Aguirre Saenz','72097534','Ventanilla- Santa Rosa Mz.F.LT.15','963214587','victor20@gmail.com', '2023-01-16','2024-10-16','Administrador', 1 )
INSERT INTO Empleado VALUES (2001,'Jhon Carlos','Velasque Durand','73057541','San Miguel-Eucaliptos-Mz.G.LT.14','900245436','JhonCarlo30@gmail.com', '2022-12-23','2023-02-15','Ventas',1)
INSERT INTO Empleado VALUES (2002,'Sofia Laura','Soto Albarracin','71045687','Los Olivos-Geranios MZ.H.LT.13-','900245436','sotoalva0100@gmail.com', '2022-12-23','2023-04-11' ,'Ventas', 1)
INSERT INTO Empleado VALUES (2003,'Alvaro ','Cochache Zacarias','73045365','Callao-Boca Negra Mz.F.LT.13','965698712','alvarocochache@gmail.com', '2022-07-16','2024-05-15','Servicio Técnico', 0)
INSERT INTO Empleado VALUES (2004,'Melany Nikole','Delgado Quispe','74059927','Callao-Boca Negra Mz.F.LT.15','965698712','melanydelgado40@gmail.com', '2022-09-16','2023-04-20' , 'Servicio Técnico', 0)
INSERT INTO Empleado VALUES (2005,'Carlos Enrique','Sanchez Regalado','71263454','Magadalena-Las Brisas Mz.B.LT.17','965698712','Carlosins2002@gmail.com', '2022-02-16','2023-01-23', 'Servicio Técnico', 1)


--TABLA PRODUCTO
INSERT INTO [dbo].[CategoriaProducto] 
VALUES
    (1, 'Teléfonos Celulares', 1, '1 año', 'Variables', 'Categoría general para teléfonos celulares'),
    (2, 'Smartphone', 1, '1 año', 'Variables', 'Categoría general para smartphones'),
    (3, 'Teléfono Básico', 0, '6 meses', 'Variables', 'Categoría general para teléfonos básicos'),
    (4, 'Accesorios', 0, 'Variables', '6 meses', 'Categoría general para accesorios de teléfonos celulares'),
    (5, 'Fundas', 0, 'Variables', '1 año', 'Fundas protectoras para teléfonos celulares'),
    (6, 'Cargadores', 0, 'Variables', '3 meses', 'Cargadores para teléfonos celulares'),
    (7, 'Protectores de Pantalla', 0, '3 meses', 'Pequeño', 'Protectores de pantalla para teléfonos celulares'),
    (8, 'Reparación', 0, 'Variables', '3 meses', 'Categoría general para servicios de reparación de teléfonos celulares');
    
--TABLA CLIENTE
INSERT INTO [dbo].[CLIENTE] 
VALUES 
	(1,1,'Maria', 'Ramirez', 70849402,933441231,'mar.ramirez@gmail.com'),
	(2, 2, 'Juan', 'Pérez', 80901234, 912345678, 'juan.perez@Yahoo.com'),
	(3, 3, 'Luis', 'Martínez', 80956789, 987654321, 'luis.martinez@outlook.com'),
	(4, 2, 'Ana', 'López', 89012345, 955544433, 'ana.lopez@gmail.com'),
	(5, 8, 'Roberto', 'Fernández', 67890123, 944433322, 'roberto.fernandez@gmail.com'),
	(6, 6, 'Carlos', 'Gómez', 76543210, 988877766, 'carlos.gomez@hotmail.com'),
	(7,2,'Monica', 'Rojas', 38475691,935920424,'mrojita@gmail.com'),
	(8, 10, 'Lauro', 'Soto', 48293041, 993843513, 'lauro.soto@gmail.com'),
	(9, 4, 'Jose', 'Paris', 83849120, 994953680, 'josepar1@outlook.com'),
	(10, 9, 'Cesar', 'Llontop', 761352491, 902839409, 'cesarLl3@outlook.com'),
	(11, 7, 'Aurora', 'Hernandez', 44559203, 924335562, 'AuroHernan35@gmail.com'),
	(12, 5, 'Raul', 'Ventura', 62940324, 912214560, 'rVentura3@hotmail.com')
	select * from Venta
--TABLA ALMACEN
INSERT INTO [dbo].[Almacen]
VALUES 
    (1, 'Almacen 1', 'Lima', 'San Isidro', 'Avenida Javier Prado 123', 1000),
    (2, 'Almacen 2', 'Arequipa', 'Cayma', 'Calle Misti 456', 800),
    (3, 'Almacen 3', 'Cusco', 'Wanchaq', 'Avenida El Sol 789', 1200),
    (4, 'Almacen 4', 'Trujillo', 'Victor Larco Herrera', 'Calle Huamachuco 101', 1500),
    (5, 'Almacen 5', 'Chiclayo', 'La Victoria', 'Avenida Balta 202', 600),
    (6, 'Almacen 6', 'Piura', 'Piura', 'Calle Tacna 303', 2000),
    (7, 'Almacen 7', 'Iquitos', 'Iquitos', 'Avenida Próceres 404', 900),
    (8, 'Almacen 8', 'Huancayo', 'Huancayo', 'Calle Real 505', 700),
    (9, 'Almacen 9', 'Tacna', 'Tacna', 'Avenida Bolognesi 606', 1100),
    (10, 'Almacen 10', 'Puno', 'Puno', 'Calle Lima 707', 1300);


---TABLA PROVEEDOR
INSERT INTO [dbo].[Proveedor]
VALUES 
    (201, 123456781, 'Proveedor A', 987654321, 'proveA@gmail.com', 'Calle Principal 123'),
    (202, 987654329, 'Proveedor B', 876543210, 'proveB@yahoo.com', 'Avenida Central 456'),
    (203, 456789014, 'Proveedor C', 765432109, 'proveC@hotmail.com', 'Calle Secundaria 789'),
    (204, 789012367, 'Proveedor D', 654321098, 'proveD@outlook.com', 'Avenida Norte 101'),
    (205, 234567892, 'Proveedor E', 543210987, 'proveE@gmail.com', 'Calle Sur 202');


-- TABLA PRODUCTO
INSERT INTO [dbo].[PRODUCTO]
VALUES
    (1, 1, 'Marca A', 'Teléfono', 150.00, 199.99, '2023-01-01', 1),
    (2, 2, 'Marca B', 'Smartphone', 250.00, 299.99, '2023-01-02', 1),
    (3, 3, 'Marca C', 'Teléfono Básico', 50.00, 79.99, '2023-01-03', 1),
    (4, 4, 'Marca D', 'Funda Protectora', 10.00, 19.99, '2023-01-04', 1),
    (5, 5, 'Marca E', 'Cargador', 15.00, 24.99, '2023-01-05', 1),
    (6, 6, 'Marca F', 'Protector de Pantalla', 5.00, 9.99, '2023-01-06', 1),
    (7, 7, 'Marca G', 'Funda elastica', 80.00, 129.99, '2023-01-07', 1);
--TABLA USUARIO
INSERT INTO [dbo].[Usuario] VALUES 
    (1, 2000, 'usuario1', 'contraseña1', 'admin', '2023-01-16', 'mod_user1', '2024-09-16'),
    (2, 2001, 'usuario2', 'contraseña2', 'ventas1', '2022-12-23', 'mod_user2', '2022-12-23'),
    (3, 2002, 'usuario3', 'contraseña3', 'ventas2', '2022-12-23', 'mod_user3', '2022-12-23'),
    (4, 2003, 'usuario4', 'contraseña4', 'tecnico1', '2022-07-16', 'mod_user5', '2022-12-23'),
    (5, 2004, 'usuario5', 'contraseña5', 'tecnico2', '2022-09-16', 'mod_user5', '2022-12-23'),
    (6, 2005, 'usuario6', 'contraseña6', 'tecnico3', '2022-02-16', 'mod_user6', '2022-02-16');


----TABLA DETALLE DE COMPRA
INSERT INTO [dbo].[DETALLECOMPRA]
VALUES 
    (1, 1, 20.00, 1, 25, 500.00),
    (2, 2, 45.50, 2, 12, 546.00),
    (3, 3, 10.25, 3, 40, 410.00),
    (4, 4, 120.75, 4, 10, 1207.50),
    (5, 5, 5.99, 5, 100, 599.00),
    (6, 6, 30.00, 6, 60, 1800.00),
    (7, 7, 90.10, 3, 10, 901.00),
    (8, 1, 15.25, 7, 45, 686.25),
    (9, 2, 50.75, 6, 20, 1015.00),
    (10, 2, 80.10, 5, 15, 1201.50);




---TABLA DetalleServicioCatServicio
INSERT INTO [dbo].[DetalleServicioCatServicio]
VALUES 
    (1, 1, 1, 2, 30.50, 61.00),
    (2, 2, 2, 1, 45.75, 45.75),
    (3, 3, 1, 3, 20.25, 60.75),
    (4, 4, 3, 1, 120.00, 120.00),
    (5, 5, 2, 5, 15.99, 79.95);

-- TABLA DetalleServicioProducto
INSERT INTO [dbo].[DetalleServicioProducto]
VALUES
    (1, 1, 1, 2, 30.50, 61.00),
    (2, 2, 2, 1, 50.75, 50.75),
    (3, 3, 3, 3, 15.00, 45.00),
    (4, 4, 4, 1, 80.25, 80.25),
    (5, 5, 5, 2, 40.00, 80.00);



---TABLA DETALLEVENTA
INSERT INTO [dbo].[DetalleVenta]
VALUES
    (1, 1, 1, 2, 25.50, 51.00),
    (2, 1, 2, 1, 30.00, 30.00),
    (3, 2, 5, 3, 15.75, 47.25),
    (4, 3, 3, 1, 110.00, 110.00),
    (5, 4, 1, 2, 40.25, 80.50),
    (6, 5, 1, 1, 70.20, 70.20);

---TABLA INVENTARIO
INSERT INTO [dbo].[Inventario]
VALUES
    (1, 1, 1, 50, '2023-01-01', 10),
    (2, 2, 2, 30, '2023-01-02', 15),
    (3, 5, 3, 100, '2023-01-03', 20),
    (4, 3, 4, 10, '2023-01-04', 5),
    (5, 1, 5, 25, '2023-01-05', 8),
    (6, 1, 6, 60, '2023-01-06', 12);

	---TABLA COMPRA
INSERT INTO [dbo].[COMPRA]
VALUES 
    (1, '2023-11-25', 2001, 201, '2023-11-24', 500.00, 'Compra de baterías y pantallas', 1, 1,1),
    (2, '2023-11-26', 2002, 202, '2023-11-25', 1200.75, 'Compra de circuitos y cámaras', 1, 2,1),
    (3, '2023-11-27', 2003, 201, '2023-11-26', 800.50, 'Compra de repuestos varios', 1, 1,1),
    (4, '2023-11-28', 2004, 203, '2023-11-27', 1500.25, 'Compra de celulares nuevos', 1, 2,1),
    (5, '2023-11-29', 2005, 202, '2023-11-28', 600.99, 'Compra de accesorios para celulares', 1, 1,1),
    (6, '2023-11-30', 2000, 201, '2023-11-29', 2000.00, 'Compra de piezas para reparaciones', 1, 2,1),
    (7, '2023-12-01', 2001, 203, '2023-11-30', 900.50, 'Compra de dispositivos móviles', 1, 1,1),
    (8, '2023-12-02', 2002, 201, '2023-12-01', 700.25, 'Compra de baterías y cargadores', 1, 2,1),
    (9, '2023-12-03', 2003, 202, '2023-12-02', 1100.75, 'Compra de pantallas y repuestos', 1, 1,1),
    (10, '2023-12-04', 2003, 203, '2023-12-03', 1300.20, 'Compra de celulares de gama alta', 1, 2,1);

	---TABLA VENTA
INSERT INTO [dbo].[Venta]
VALUES
    (1, 2001, 1, '2023-05-10', 150.50, 'Venta de productos varios', 1, 1,1),
    (2, 2003, 3, '2023-05-11', 95.75, 'Venta de accesorios', 1, 2,1),
    (3, 2005, 2, '2023-05-12', 220.00, 'Venta de smartphones', 1, 1,1),
    (4, 2002, 5, '2023-05-13', 80.50, 'Venta de servicios de reparación', 1, 2,1),
    (5, 2004, 4, '2023-05-14', 120.25, 'Venta de repuestos', 1, 1,1);


--TABLA SERVICIO
INSERT INTO [dbo].[SERVICIO]
VALUES
    (1, 2001, 1, '2023-01-20', '2023-01-25', 90.50, 'Reparación de pantalla', 1, 1,1),
    (2, 2002, 3, '2023-02-10', '2023-02-15', 120.25, 'Cambio de batería y cámara', 1, 2,1),
    (3, 2003, 2, '2023-03-05', '2023-03-10', 55.99, 'Actualización de software', 1, 1,1),
    (4, 2004, 4, '2023-04-15', '2023-04-20', 80.00, 'Reparación de botones', 1, 2,1),
    (5, 2005, 5, '2023-05-01', '2023-05-06', 110.75, 'Cambio de altavoz', 1, 1,1);
