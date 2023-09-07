create database dbpuntodeventamendez;
use dbpuntodeventamendez;

create table folios(
id_folio int(10) unsigned NOT NULL auto_increment,
id_cajero int(3) unsigned NOT NULL,
name_cajero varchar(30),
total_ticket int(10),
pago_con int(10),
cambio int(10),
fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
primary key(id_folio)

);
create table ticket(
codigo BIGINT unsigned NOT NULL,
descripcion varchar(50) NOT NULL,
importe_unitario float(25) unsigned NOT NULL,
cantidad int(5) unsigned NOT NULL,
total float(10) unsigned NOT NULL,
id_folio int(10) unsigned NOT Null,
	FOREIGN KEY(id_folio) REFERENCES folios(id_folio) ON DELETE CASCADE
);

create table cajero(
id_cajero int(5) auto_increment primary key,
name_cajero varchar(30),
direccion varchar(60),
telefono varchar(11)
);

create table Productos(
codigo BIGINT unsigned NOT NULL,
descripcion varchar(40) NOT NULL,
departamento varchar(30) NOT NULL,
costo float(9) unsigned NOT NULL,
precio_publico float(9) unsigned NOT NULL,
Existencia float(9) unsigned NOT NULL,
Inv_min float(9) unsigned NOT NULL,
tipo_producto boolean NOT NULL,
primary key(codigo)
);
