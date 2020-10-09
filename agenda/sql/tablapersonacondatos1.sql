CREATE DATABASE `agenda`;
USE agenda;
CREATE TABLE `personas`
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Telefono` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Linkedin` varchar(30) NOT NULL,
  `Fechacumple` Date NOT NULL,
  `Calle` varchar(30) NOT NULL,
  `Altura` int(8) NOT NULL,
  `Piso` int(5) NOT NULL,
  `Depto` varchar(5) NOT NULL,
  `CP` int(5) NOT NULL,
  `TipoContacto` varchar(30) NOT NULL,
  `Localidad` varchar(50) NOT NULL,
  PRIMARY KEY (`idPersona`)
);

INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Jere medrano', 777777, 'jere@gmail', '@jere', '2020-09-01', 'siempreviva',777, 66, '66b', 1836, 'Familia', 'Lobos');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Marco Yu', 777777, 'marco@gmail', '@marco' , '2020-09-01', 'siempreviva',777, 66, '66b', 1836, 'Familia', 'Luján');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Apu Nahasapeemapetilon', 666666, 'Apu@gmail', '@Apu' ,'2020-09-01', 'pepito', 555, 66, '66b', 1836, 'Familia', 'Tigre');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'mona jimenez', 666666, 'lamona@gmail', '@lamona' , '2020-09-01', 'pepito', 555, 66, '66b', 1836, 'Familia', 'Moreno');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'bart simpson', 777777, 'bart@gmail', '@bart' , '2020-09-01', 'siempreviva',777, 66, '66b', 1836, 'Familia', 'Tandil');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Homero J Simpson', 777777, 'Homero@gmail' , '@Homero' , '2020-09-01', 'siempreviva',777, 66, '66b', 1836, 'Familia', 'Tigre');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Clancy Gorgori', 777777, 'Gorgori@gmail', '@Gorgori' , '2020-09-01', 'siempreviva',777, 66, '66b', 1836, 'Familia', 'Suipacha');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Milhouse Mussolini', 777777, 'Milhouse@gmail', '@Milhouse' , '2020-09-01', 'siempreviva',777, 66, '66b', 1836, 'Familia', 'San vicente');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Kent Brockman', 777777, 'Brockman@gmail', '@Brockman' , '2020-09-01', 'siempreviva',777, 66, '66b', 1663, 'Familia', 'Comodoro Py');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Diego Maradona', 777777, 'Maradona@gmail', '@Maradona' , '2020-09-01', 'siempreviva',777, 66, '66b', 1663, 'Familia', 'Chivilcoil');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Lionel Messi', 777777, 'Messi@gmail', '@Messi' , '2020-09-01', 'siempreviva',777, 66, '66b', 1663, 'Familia', 'Cañuelas');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Ricardo Darin', 777777, 'Darin@gmail', '@Darin' , '2020-09-01', 'siempreviva',777, 66, '66b', 1663, 'Familia', 'San Miguel');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Saul Goodman', 777777, 'Goodman@gmail', '@Goodman' , '2020-09-01', 'siempreviva',777, 66, '66b', 1663, 'Familia', 'Campana');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Walter White', 777777, 'White@gmail', '@White' , '2020-09-01', 'siempreviva',777, 66, '66b', 1663, 'Familia', 'Berazategui');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Jesse Pinkman', 777777, 'Pinkman@gmail', '@Pinkman' , '2020-09-01', 'siempreviva',777, 66, '66b', 1663, 'Familia', 'Bahía Blanca');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Gus Fring', 777777, 'Fring@gmail', '@Fring' , '2020-09-01', 'siempreviva',777, 66, '66b', 1663, 'Familia', 'Azul');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Hank', 777777, 'Hank@gmail', '@Hank' , '2020-09-01', 'siempreviva',777, 66, '66b', 1663, 'Familia', 'Avellaneda');
INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(0, 'Kim', 777777, 'Kim@gmail', '@Kim' , '2020-09-01', 'siempreviva',777, 66, '66b', 1663, 'Familia', 'Atalaya');