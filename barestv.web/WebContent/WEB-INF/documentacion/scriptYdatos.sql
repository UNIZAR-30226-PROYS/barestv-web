CREATE DATABASE  IF NOT EXISTS `gdosteamio` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gdosteamio`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gdosteamio
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `idProducto` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `comentario` char(255) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idProducto`,`fecha`),
  UNIQUE KEY `fecha` (`fecha`),
  UNIQUE KEY `Alter_Key5` (`fecha`),
  KEY `idUsuario` (`idUsuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
INSERT INTO `comentario` VALUES (1,'2016-12-01 16:01:00','Hola',1),(1,'2016-12-02 13:53:03','me ha encatado sisisisi',3),(1,'2016-12-02 13:06:29','Me ha encantado, llegue hasta el nivel 5 y consegui reventar al demonio! 5de 5!',2);
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `idProducto` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `valoracion` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`idProducto`,`idUsuario`,`fecha`),
  KEY `idUsuario` (`idUsuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,1,1,'2016-12-01 16:08:32'),(1,2,0,'2016-12-02 13:06:40'),(1,3,0,'2016-12-02 13:51:42');
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etiqueta`
--

DROP TABLE IF EXISTS `etiqueta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `etiqueta` (
  `idEtiqueta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` char(50) NOT NULL,
  PRIMARY KEY (`idEtiqueta`),
  UNIQUE KEY `nombre` (`nombre`),
  UNIQUE KEY `Alter_Key4` (`nombre`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etiqueta`
--

LOCK TABLES `etiqueta` WRITE;
/*!40000 ALTER TABLE `etiqueta` DISABLE KEYS */;
INSERT INTO `etiqueta` VALUES (4,'Accion'),(5,'action'),(6,'sigilo');
/*!40000 ALTER TABLE `etiqueta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial`
--

DROP TABLE IF EXISTS `historial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial` (
  `idUsuario` int(11) NOT NULL,
  `idEvento` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `evento` char(255) NOT NULL,
  PRIMARY KEY (`idUsuario`,`idEvento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial`
--

LOCK TABLES `historial` WRITE;
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
INSERT INTO `historial` VALUES (1,1,'2016-12-01 15:43:46','Creado usuario'),(1,2,'2016-12-01 15:53:09','Creado producto #1'),(1,3,'2016-12-01 15:58:47','Editado producto #1'),(1,4,'2016-12-01 16:00:32','Editado producto #1'),(1,5,'2016-12-01 16:01:00','Comentado producto #1'),(1,6,'2016-12-01 16:03:17','Comentado producto #1'),(1,7,'2016-12-01 16:04:18','Comentado producto #1'),(1,8,'2016-12-01 16:04:25','Eliminado comentario de producto #1'),(1,9,'2016-12-01 16:04:31','Eliminado comentario de producto #1'),(1,10,'2016-12-01 16:05:00','AÃ±adido etiqueta a producto #1'),(1,11,'2016-12-01 16:05:16','AÃ±adido etiqueta a producto #1'),(1,12,'2016-12-01 16:05:40','Eliminado etiqueta del producto #1'),(1,13,'2016-12-01 16:08:32','Comprado producto #1'),(1,14,'2016-12-01 16:09:15','AÃ±adido etiqueta a producto #1'),(1,15,'2016-12-01 16:09:58','Eliminado etiqueta del producto #1'),(1,16,'2016-12-01 16:10:02','Eliminado etiqueta del producto #1'),(1,17,'2016-12-01 16:10:11','AÃ±adido etiqueta a producto #1'),(1,18,'2016-12-01 16:10:30','AÃ±adido etiqueta a producto #1'),(1,19,'2016-12-01 16:16:09','Actualizado cuenta usuario'),(1,20,'2016-12-01 16:17:43','Actualizado cuenta usuario'),(1,21,'2016-12-01 16:18:05','Actualizado cuenta usuario'),(2,1,'2016-12-02 12:39:07','Creado usuario'),(2,2,'2016-12-02 13:06:29','Comentado producto #1'),(2,3,'2016-12-02 13:06:40','Comprado producto #1'),(2,4,'2016-12-02 13:06:52','AÃ±adido etiqueta a producto #1'),(2,5,'2016-12-02 13:11:10','Actualizado cuenta usuario'),(2,6,'2016-12-02 13:16:41','Actualizado cuenta usuario'),(2,7,'2016-12-02 13:22:20','Creado producto #2'),(3,1,'2016-12-02 13:51:03','Creado usuario'),(3,2,'2016-12-02 13:51:42','Comprado producto #1'),(3,3,'2016-12-02 13:52:50','Comentado producto #1'),(3,4,'2016-12-02 13:53:03','Editado comentario de producto #1');
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagen`
--

DROP TABLE IF EXISTS `imagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imagen` (
  `idImagen` int(11) NOT NULL AUTO_INCREMENT,
  `url` text NOT NULL,
  `idProducto` int(11) NOT NULL,
  PRIMARY KEY (`idImagen`),
  KEY `idProducto` (`idProducto`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagen`
--

LOCK TABLES `imagen` WRITE;
/*!40000 ALTER TABLE `imagen` DISABLE KEYS */;
INSERT INTO `imagen` VALUES (11,'https://i.ytimg.com/vi/T4KW7hotM6o/maxresdefault.jpg',2),(12,'http://i11b.3djuegos.com/juegos/5065/grand_theft_auto_v/fotos/set/grand_theft_auto_v-2658340.jpg',2),(7,'http://img1.meristation.com/files/imagenes/juegos/360/action/sandbox/assassins_creed_rogue/1407255521-northernlight-in-sapphire-watermark-grey.jpg',1),(8,'http://www.hackswork.com/wp-content/uploads/2015/09/asao.jpg',1),(9,'http://img1.meristation.com/files/imagenes/juegos/360/action/sandbox/assassins_creed_rogue/1407255525-templarvsassassincaptain-watermark-grey.jpg',1),(10,'http://www.bajalodemega.com/wp-content/uploads/2015/08/Grand-Theft-Auto-V.jpg',2);
/*!40000 ALTER TABLE `imagen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` char(100) NOT NULL,
  `descripcionCorta` text NOT NULL,
  `descripcionLarga` text NOT NULL,
  `precio` double NOT NULL,
  `fechaPublicacion` datetime NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `nombre` (`nombre`),
  UNIQUE KEY `Alter_Key1` (`nombre`),
  KEY `idUsuario` (`idUsuario`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Assassin Creed Rogue CD-key','Presentamos Assassin Creed Rogue','ARGUMENTO\r\n\r\nSiglo XVIII. América del Norte. Entre el caos y la violencia de la Guerra franco-india, Shay Patrick Cormac, un joven y valiente miembro de la orden de los Assassin, experimenta una oscura transformación que afectará de forma definitiva al devenir de la Hermandad. Tras una dura pelea por una misión que fracasa trágicamente, Shay decide acabar con todos aquellos que le traicionaron y convertirse por tanto en el cazador de Assasins más temido de la historia. \r\nPresentamos Assassin Creed Rogue, el capítulo más oscuro de la franquicia Assassin Creed hasta la fecha. Vivirás en la piel de Shay la lenta transformación que le llevará de ser un Assassin a un cazador de Assassins. Sigue tu propio credo y emprende un extraordinario viaje en el que recorrerás la ciudad de Nueva York, valles y ríos en plena naturaleza salvaje, hasta llegar a las heladas aguas del océano Atlántico Norte en busca de tu gran objetivo: acabar con los Assassins.\r\nCARACTERÍSTICAS PRINCIPALES\r\n\r\nConviértete en el cazador de Assassins definitivo - Experimenta por primera vez el universo de Assassin Creed desde la perspectiva de un Templario. Adopta el rol de Shay, quien además de sus letales habilidades como Maestro Assassin posee también habilidades y armas nunca vistas hasta hoy: \r\no	Usa el letal rifle de aire de Shay en combates de corto y largo alcance. Distrae, elimina o confunde a tus enemigos usando distintos tipos de munición, incluyendo balas y granadas especiales. \r\no	Protégete de los Assassins ocultos entre la multitud con tu vista del águila mejorada. Usa tu vista del águila para controlar en todo momento el espacio a tu alrededor y detecta a los Assassins ocultos en las sombras, en los tejados, o entre la gente. \r\n\r\nAdéntrate lentamente en la Oscuridad - Sé testigo de la transformación de Shay, de un Assassin fiel seguidor del credo a un sombrío y entregado templario. Experimenta en primera persona todas las vivencias que harán tomar a Shay un oscuro camino hacia una maldición que cambiará para siempre el destino de la Hermandad de los Assassins. \r\n',15.99,'2016-12-01 15:53:09',1),(2,'Grand Theft Auto V','Convierte las calles de Los Santos en una batalla a muerte digital con la última actualización de GTA Online. Alcanza la hipervelocidad en la Nagasaki Shotaro y destroza a los enemigos con tu haz de luz en el nuevo modo Adversario No te pases de la raya. ','\r\nAcerca de este juego\r\nCuando un joven estafador callejero, un ladrón de bancos retirado y un psicópata aterrador se ven involucrados con lo peor y más desquiciado del mundo criminal, del gobierno de los EE. UU. y de la industria del espectáculo, tendrán que llevar a cabo una serie de peligrosos golpes para sobrevivir en una ciudad implacable en la que no pueden confiar en nadie. Y mucho menos los unos en los otros.\r\n\r\nGrand Theft Auto V para PC ofrece a los jugadores la opción de explorar el galardonado mundo de Los Santos y el condado de Blaine con una resolución de 4K y disfrutar del juego a 60 fotogramas por segundo.\r\n\r\nEl juego cuenta con múltiples y variadas opciones de personalización específicas para ordenadores, con más de 25 ajustes configurables distintos para la calidad de las texturas, shader, teselado, antialiasing y muchos otros elementos, además de opciones de personalización del ratón y el teclado. También es posible modificar la densidad de población para controlar el tráfico de vehículos y peatones, y es compatible con dos y tres monitores, 3D y mandos plug-and-play.\r\n\r\nGrand Theft Auto V para PC también incluye Grand Theft Auto Online, compatible con 30 jugadores y dos espectadores. Grand Theft Auto Online para PC incluirá todas las mejoras y contenidos creados por Rockstar desde la fecha de lanzamiento de Grand Theft Auto Online, incluidos los golpes y los modos Adversario.\r\n\r\nLa versión para PC de Grand Theft Auto V y Grand Theft Auto Online incluye la vista en primera persona, que ofrece a los jugadores la posibilidad de explorar todos los detalles del mundo de Los Santos y el condado de Blaine de una forma totalmente nueva.\r\n\r\nGrand Theft Auto V para PC también cuenta con el nuevo editor Rockstar, un conjunto de herramientas que permite grabar, editar y compartir vídeos de Grand Theft Auto V y Grand Theft Auto Online de manera rápida y sencilla. Gracias al modo director del editor Rockstar, los jugadores pueden dar vida a sus ideas y crear escenas con personajes del juego, peatones e incluso animales. El editor cuenta con técnicas avanzadas de movimiento de cámara, efectos de edición como imágenes a cámara lenta o rápida, varios filtros de cámara, la posibilidad de añadir canciones de las emisoras de radio de GTA V o controlar de forma dinámica la intensidad de la música del juego. Los vídeos terminados pueden subirse directamente a YouTube y al Social Club de Rockstar Games desde el editor Rockstar para compartirlos de manera sencilla.\r\n\r\nThe Alchemist y Oh No, compositores de la banda sonora, son los locutores de la nueva radio del juego, The Lab FM, que emite canciones nuevas y exclusivas de estos dos artistas inspiradas en la música original del juego. También colaboran otros artistas invitados como Earl Sweatshirt, Freddie Gibbs, Little Dragon, Killer Mike y Sam Herring de Future Islands, por mencionar algunos. Los jugadores también pueden descubrir Los Santos y el condado de Blaine mientras escuchan su propia música en Tu radio, una nueva emisora con una banda sonora creada y personalizada por el jugador.\r\n\r\nLos jugadores de PlayStation®3, PlayStation®4, Xbox 360 y Xbox One pueden transferir los personajes de Grand Theft Auto Online y los progresos realizados a su PC. Para obtener más información, visita rockstargames.com/gtaonline/charactertransfer.\r\n',59.99,'2016-12-02 13:22:20',2);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productoetiqueta`
--

DROP TABLE IF EXISTS `productoetiqueta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productoetiqueta` (
  `idProducto` int(11) NOT NULL,
  `idEtiqueta` int(11) NOT NULL,
  PRIMARY KEY (`idProducto`,`idEtiqueta`),
  KEY `idEtiqueta` (`idEtiqueta`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productoetiqueta`
--

LOCK TABLES `productoetiqueta` WRITE;
/*!40000 ALTER TABLE `productoetiqueta` DISABLE KEYS */;
INSERT INTO `productoetiqueta` VALUES (1,4),(1,5),(1,6);
/*!40000 ALTER TABLE `productoetiqueta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `correo` char(100) NOT NULL,
  `estado` char(20) NOT NULL,
  `nick` char(20) NOT NULL,
  `contrasenya` char(100) NOT NULL,
  `apellido` char(100) NOT NULL,
  `nombre` char(100) NOT NULL,
  `fecha` datetime NOT NULL,
  `imagen` char(250) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `correo` (`correo`),
  UNIQUE KEY `Alter_Key2` (`correo`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'xian@unizar.com','active','Xian','202cb962ac59075b964b07152d234b70','Pan','Xian','2016-12-01 00:00:00','null'),(2,'lechuzaposeida@gmail.com','active','Raoner','70b783251225354e883a5bef3c011843','Martinez','Daniel','2016-12-02 00:00:00','http://1.bp.blogspot.com/_ydHiK1gnQ2w/TDpxOBCEfVI/AAAAAAAAABY/fJ9ZkIfDm8k/s1600/HomerSimpson3.gif'),(3,'ra@ra','active','Ratas','db26ee047a4c86fbd2fba73503feccb6','ra','ra','2016-12-02 13:51:03','null');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-02 22:24:17
