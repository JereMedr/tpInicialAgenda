use agenda;

CREATE TABLE `TipoContacto`
(
  
  `TipoContacto` varchar(45) NOT NULL,

  PRIMARY KEY (`TipoContacto`)
);

insert into TipoContacto (TipoContacto) values('Amigo');
insert into TipoContacto (TipoContacto) values('Familia');
insert into TipoContacto (TipoContacto) values('Trabajo');