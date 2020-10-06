use agenda;

CREATE TABLE `ubicacion`
(
  `pais` varchar(45) NOT NULL,
  `provincia` varchar(45) NOT NULL,
  `localidad` varchar(45) NOT NULL,
  PRIMARY KEY (`localidad`)
);

insert into ubicacion (pais,provincia,localidad) values('Argentina','Buenos Aires','Avellaneda');
insert into ubicacion (pais,provincia,localidad) values('Argentina','Buenos Aires','San Miguel');
insert into ubicacion (pais,provincia,localidad) values('Argentina','Buenos Aires','La Matanza');

insert into ubicacion (pais,provincia,localidad) values('Argentina','Tierra Del Fuego','Ushuaia');
insert into ubicacion (pais,provincia,localidad) values('Argentina','Tierra Del Fuego','Río Grande');
insert into ubicacion (pais,provincia,localidad) values('Argentina','Tierra Del Fuego','Tolhuin');

insert into ubicacion (pais,provincia,localidad) values('Uruguay','Maldonado','PUnta Ballena');
insert into ubicacion (pais,provincia,localidad) values('Uruguay','Maldonado','Gerona');
insert into ubicacion (pais,provincia,localidad) values('Uruguay','Maldonado','Playa Hermosa');

insert into ubicacion (pais,provincia,localidad) values('Uruguay','Montevideo','Montevideo');
insert into ubicacion (pais,provincia,localidad) values('Uruguay','Montevideo','Montevideo rural');
insert into ubicacion (pais,provincia,localidad) values('Uruguay','Montevideo','Santiago Vázquez');

