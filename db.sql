-- Crear la base de datos
CREATE DATABASE Caso2;


-- Crear el usuario y otorgar privilegios
CREATE USER 'usuario_caso2'@'%' IDENTIFIED BY 'Usuario_Clave.';
GRANT ALL PRIVILEGES ON Caso2.* TO 'usuario_caso2'@'%';
FLUSH PRIVILEGES;

-- Usar la base de datos
USE Caso2;

-- =========================
-- 1. TABLAS DE SEGURIDAD
-- =========================

CREATE TABLE usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(20) NOT NULL,
  password VARCHAR(512) NOT NULL,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(75),
  telefono VARCHAR(15),
  PRIMARY KEY (id_usuario)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE role (
  rol VARCHAR(20),
  PRIMARY KEY (rol)
);

CREATE TABLE rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20),
  id_usuario INT,
  PRIMARY KEY (id_rol),
  FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE ruta (
  id_ruta INT AUTO_INCREMENT NOT NULL,
  patron VARCHAR(255) NOT NULL,
  rol_name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_ruta)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE ruta_permit (
  id_ruta INT AUTO_INCREMENT NOT NULL,
  patron VARCHAR(255) NOT NULL,
  PRIMARY KEY (id_ruta)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


-- =========================
-- 2. cosas d la profe 
-- =========================

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


-- =========================
-- 3. INSERCIÓN DE DATOS
-- =========================

-- Usuarios
INSERT INTO usuario (id_usuario, username, password, nombre, apellidos, correo, telefono) VALUES 
(1, 'sebastian123', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'Sebastián', 'Mendez Artavia', 'seb.vargas@gmail.com', '6001-2234'),
(2, 'fio', '$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi', 'Fiorella', 'Jaen Artavia', 'fiorella.rj@hotmail.com', '7223-8855'),
(3, 'magnusx', '$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO', 'Magnus', 'Mendez Artavia', 'magnus.alvarado@gmail.com', '6044-9191');

-- Roles base
INSERT INTO role (rol) VALUES ('ADMIN'), ('VENDEDOR'), ('USER');

-- Relación usuario - roles
INSERT INTO rol (id_rol, nombre, id_usuario) VALUES
(1, 'ROLE_ADMIN', 1),
(2, 'ROLE_VENDEDOR', 2),
(3, 'ROLE_USER', 3),
(4, 'ROLE_VENDEDOR', 2),
(5, 'ROLE_USER', 2),
(6, 'ROLE_USER', 3);



-- Rutas protegidas
INSERT INTO ruta (patron, rol_name) VALUES
('/carrito/agregar/**', 'USER'),
('/carrito/listado', 'USER'),
('/carrito/eliminar/**', 'USER'),
('/carrito/modificar/**', 'USER'),
('/carrito/guardar', 'USER'),
('/facturar/carrito', 'USER');

-- Rutas públicas
INSERT INTO ruta_permit (patron) VALUES 
('/'),
('/index'),
('/errores/'),
('/carrito/'),
('/registro/'),
('/js/'),
('/webjars/');
-- =========================
-- 4. INSERCIÓN DE DATOS PROFE
-- =========================-- 
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