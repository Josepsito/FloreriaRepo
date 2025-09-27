CREATE DATABASE FloreriaDB;
USE FloreriaDB;

CREATE TABLE Usuarios (
    usuarioid INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(200) NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(200)
);

CREATE TABLE Categorias (
    categoriaid INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE Productos (
    productoid INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    imagenURL VARCHAR(300),
    categoriaid INT,
    FOREIGN KEY (categoriaid) REFERENCES Categorias(categoriaid)
);

CREATE TABLE Carrito (
    carritoid INT AUTO_INCREMENT PRIMARY KEY,
    usuarioid INT,
    productoid INT,
    cantidad INT NOT NULL,
    FOREIGN KEY (usuarioid) REFERENCES Usuarios(usuarioid),
    FOREIGN KEY (productoid) REFERENCES Productos(productoid)
);

CREATE TABLE Pedidos (
    pedidoid INT AUTO_INCREMENT PRIMARY KEY,
    usuarioid INT,
    fecha_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) DEFAULT 'Pendiente',
    total DECIMAL(10,2) DEFAULT 0,
    FOREIGN KEY (usuarioid) REFERENCES Usuarios(usuarioid)
);

CREATE TABLE DetallePedido (
    detalleid INT AUTO_INCREMENT PRIMARY KEY,
    pedidoid INT,
    productoid INT,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (pedidoid) REFERENCES Pedidos(pedidoid),
    FOREIGN KEY (productoid) REFERENCES Productos(productoid)
);
