-- Crear usuario de conexión
CREATE USER 'usuario_Caso2'@'%' IDENTIFIED BY 'Usuar1o_ClaveCaso2.';

-- Crear base de datos
CREATE DATABASE cine_teatro_db;

-- Otorgar permisos
GRANT ALL PRIVILEGES ON cine_teatro_db.* TO 'usuario_Caso2'@'%';
FLUSH PRIVILEGES;

-- Seleccionar la base de datos
USE cine_teatro_db;

-- ============================================
-- 1. TABLAS DE SEGURIDAD
-- ============================================

-- Tabla de usuarios
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100) UNIQUE,
    contrasena VARCHAR(255),
    rol VARCHAR(20)
);

-- Tabla base de roles
CREATE TABLE role (
    rol VARCHAR(20),
    PRIMARY KEY (rol)
);

-- Tabla de relación usuario - rol (rol adicional)
CREATE TABLE usuario_rol (
    id_rol INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(20),
    id_usuario INT,
    PRIMARY KEY (id_rol),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- Tabla de rutas protegidas
CREATE TABLE ruta (
    id_ruta INT AUTO_INCREMENT NOT NULL,
    patron VARCHAR(255) NOT NULL,
    rol_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_ruta)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- Tabla de rutas públicas
CREATE TABLE ruta_permit (
    id_ruta INT AUTO_INCREMENT NOT NULL,
    patron VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_ruta)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


-- ============================================
-- 2. TABLAS GENERALES
-- ============================================

-- Tabla de películas u obras
CREATE TABLE peliculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150),
    tipo VARCHAR(20) -- 'PELICULA' o 'OBRA'
);

-- Tabla de funciones
CREATE TABLE funciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_pelicula INT,
    fecha DATE,
    hora TIME,
    sala VARCHAR(50),
    FOREIGN KEY (id_pelicula) REFERENCES peliculas(id)
);

-- Tabla de reservas
CREATE TABLE reservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_funcion INT,
    cantidad INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_funcion) REFERENCES funciones(id)
);


-- ============================================
-- 3. INSERCIÓN DE DATOS
-- ============================================

-- Insertar usuarios
INSERT INTO usuarios (nombre, correo, contrasena, rol) VALUES
('Sebastian', 'YZ@gmail.com', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'ADMIN'),
('Arthur', 'a@hotmail.com', '$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi', 'USUARIO'),
('Magnus', 'm@gmail.com', '$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO', 'USUARIO');

-- Insertar roles base (sin 'VENDEDOR')
INSERT INTO role (rol) VALUES ('ADMIN'), ('USER');

-- Insertar relación usuario-rol (tabla adicional)
INSERT INTO usuario_rol (nombre, id_usuario) VALUES
('ROLE_ADMIN', 1),
('ROLE_USER', 1),
('ROLE_VENDEDOR', 2),
('ROLE_USER', 2)

-- Insertar rutas protegidas
INSERT INTO ruta (patron, rol_name) VALUES
('/carrito/agregar/**', 'USER'),
('/carrito/listado', 'USER'),
('/carrito/eliminar/**', 'USER'),
('/carrito/modificar/**', 'USER'),
('/carrito/guardar', 'USER'),
('/facturar/carrito', 'USER');

-- Insertar rutas públicas
INSERT INTO ruta_permit (patron) VALUES 
('/'),
('/index'),
('/errores/'),
('/carrito/'),
('/registro/'),
('/js/'),
('/webjars/');

-- Insertar películas/obras
INSERT INTO peliculas (titulo, tipo) VALUES
('El Rey León', 'OBRA'),
('Avengers: Endgame', 'PELICULA'),
('La Bella y la Bestia', 'OBRA'),
('Spider-Man: No Way Home', 'PELICULA');

-- Insertar funciones
INSERT INTO funciones (id_pelicula, fecha, hora, sala) VALUES
(1, '2025-04-20', '18:00:00', 'Sala A'),
(2, '2025-04-21', '20:00:00', 'Sala B'),
(3, '2025-04-22', '17:00:00', 'Sala C'),
(4, '2025-04-23', '21:00:00', 'Sala D');

-- Insertar reservas
INSERT INTO reservas (id_usuario, id_funcion, cantidad) VALUES
(1, 1, 2),
(2, 2, 1),
(1, 4, 3);
