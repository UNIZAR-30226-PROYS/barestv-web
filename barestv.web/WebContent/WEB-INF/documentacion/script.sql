/*
Created		18/10/2016
Modified		18/10/2016
Project		
Model		
Company		
Author		
Version		
Database		mySQL 5 
*/

drop table IF EXISTS Comentario;
drop table IF EXISTS ProductoEtiqueta;
drop table IF EXISTS Etiqueta;
drop table IF EXISTS Imagen;
drop table IF EXISTS Compra;
drop table IF EXISTS Usuario;
drop table IF EXISTS Producto;
drop table IF EXISTS Historial;

Create table Producto (
	idProducto Int NOT NULL AUTO_INCREMENT,
	nombre Char(100) NOT NULL,
	descripcionCorta TEXT NOT NULL,
	descripcionLarga TEXT NOT NULL,
	precio Double NOT NULL,
	fechaPublicacion Datetime NOT NULL,
	idUsuario Int NOT NULL,
	UNIQUE (nombre),
 Primary Key (idProducto)) ENGINE = MyISAM;

Create table Usuario (
	idUsuario Int NOT NULL AUTO_INCREMENT,
	correo Char(100) NOT NULL,
	estado Char(20) NOT NULL,
	nick Char(20) NOT NULL,
	contrasenya Char(100) NOT NULL,
	apellido Char(100) NOT NULL,
	nombre Char(100) NOT NULL,
	fecha Datetime NOT NULL,
	imagen Char(250),
	UNIQUE (correo),
 Primary Key (idUsuario)) ENGINE = MyISAM;

Create table Compra (
	idProducto Int NOT NULL,
	idUsuario Int NOT NULL,
	valoracion Int NOT NULL,
	fecha Datetime NOT NULL,
 Primary Key (idProducto,idUsuario,fecha)) ENGINE = MyISAM;

Create table Imagen (
	idImagen Int NOT NULL AUTO_INCREMENT,
	url TEXT NOT NULL,
	idProducto Int NOT NULL,
 Primary Key (idImagen)) ENGINE = MyISAM;

Create table Etiqueta (
	idEtiqueta Int NOT NULL AUTO_INCREMENT,
	nombre Char(50) NOT NULL,
	UNIQUE (nombre),
 Primary Key (idEtiqueta)) ENGINE = MyISAM;

Create table ProductoEtiqueta (
	idProducto Int NOT NULL,
	idEtiqueta Int NOT NULL,
 Primary Key (idProducto,idEtiqueta)) ENGINE = MyISAM;

Create table Comentario (
	idProducto Int NOT NULL,
	fecha Datetime NOT NULL,
	comentario Char(255) NOT NULL,
	idUsuario Int NOT NULL,
	UNIQUE (fecha),
 Primary Key (idProducto,fecha)) ENGINE = MyISAM;


Create table Historial (
	idUsuario Int NOT NULL,
	idEvento Int NOT NULL AUTO_INCREMENT,
	fecha Datetime NOT NULL,
	evento Char(255) NOT NULL,
 Primary Key (idUsuario,idEvento)) ENGINE = MyISAM;


Alter table Producto add unique Alter_Key1 (nombre);
Alter table Usuario add unique Alter_Key2 (correo);
Alter table Etiqueta add unique Alter_Key4 (nombre);
Alter table Comentario add unique Alter_Key5 (fecha);






Alter table Compra add Foreign Key (idProducto) references Producto (idProducto) on delete  restrict on update  restrict;
Alter table Imagen add Foreign Key (idProducto) references Producto (idProducto) on delete  restrict on update  restrict;
Alter table ProductoEtiqueta add Foreign Key (idProducto) references Producto (idProducto) on delete  restrict on update  restrict;
Alter table Comentario add Foreign Key (idProducto) references Producto (idProducto) on delete  restrict on update  restrict;
Alter table Compra add Foreign Key (idUsuario) references Usuario (idUsuario) on delete  restrict on update  restrict;
Alter table Producto add Foreign Key (idUsuario) references Usuario (idUsuario) on delete  restrict on update  restrict;
Alter table Comentario add Foreign Key (idUsuario) references Usuario (idUsuario) on delete  restrict on update  restrict;
Alter table ProductoEtiqueta add Foreign Key (idEtiqueta) references Etiqueta (idEtiqueta) on delete  restrict on update  restrict;











/* Users permissions */






