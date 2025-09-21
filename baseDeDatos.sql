CREATE DATABASE FloreriaDB;

GO
USE FloreriaDB;
GO


CREATE TABLE Usuarios (
    UsuarioID INT IDENTITY(1,1) PRIMARY KEY,
    Nombre NVARCHAR(100) NOT NULL,
    Email NVARCHAR(100) UNIQUE NOT NULL,
    PasswordHash NVARCHAR(200) NOT NULL,
    Telefono NVARCHAR(20),
    Direccion NVARCHAR(200)
);

CREATE TABLE Categorias (
    CategoriaID INT IDENTITY(1,1) PRIMARY KEY,
    Nombre NVARCHAR(50) NOT NULL
);

CREATE TABLE Productos (
    ProductoID INT IDENTITY(1,1) PRIMARY KEY,
    Nombre NVARCHAR(100) NOT NULL,
    Descripcion NVARCHAR(MAX),
    Precio DECIMAL(10,2) NOT NULL,
    Stock INT NOT NULL DEFAULT 0,
    ImagenURL NVARCHAR(300),
    CategoriaID INT FOREIGN KEY REFERENCES Categorias(CategoriaID)
);

CREATE TABLE Carrito (
    CarritoID INT IDENTITY(1,1) PRIMARY KEY,
    UsuarioID INT FOREIGN KEY REFERENCES Usuarios(UsuarioID),
    ProductoID INT FOREIGN KEY REFERENCES Productos(ProductoID),
    Cantidad INT NOT NULL
);

CREATE TABLE Pedidos (
    PedidoID INT IDENTITY(1,1) PRIMARY KEY,
    UsuarioID INT FOREIGN KEY REFERENCES Usuarios(UsuarioID),
    FechaPedido DATETIME DEFAULT GETDATE(),
    Estado NVARCHAR(50) DEFAULT 'Pendiente',
    Total DECIMAL(10,2) DEFAULT 0
);


CREATE TABLE DetallePedido (
    DetalleID INT IDENTITY(1,1) PRIMARY KEY,
    PedidoID INT FOREIGN KEY REFERENCES Pedidos(PedidoID),
    ProductoID INT FOREIGN KEY REFERENCES Productos(ProductoID),
    Cantidad INT NOT NULL,
    PrecioUnitario DECIMAL(10,2) NOT NULL
);