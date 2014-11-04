-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.36


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema tarea
--

CREATE DATABASE IF NOT EXISTS tarea;
USE tarea;

--
-- Definition of table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `iddepto` varchar(2) NOT NULL,
  `nombredepto` varchar(25) NOT NULL,
  `zonageografica` varchar(15) NOT NULL,
  `username` varchar(45) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userm` varchar(45) DEFAULT NULL,
  `fecham` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`iddepto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departamento`
--

/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` (`iddepto`,`nombredepto`,`zonageografica`,`username`,`fecha`,`userm`,`fecham`) VALUES 
 ('1','La Libertad','No se','Mike','0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;


--
-- Definition of table `jrv`
--

DROP TABLE IF EXISTS `jrv`;
CREATE TABLE `jrv` (
  `idjrv` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idmunicipio` varchar(2) NOT NULL,
  `iddepto` varchar(2) NOT NULL,
  `dui` varchar(10) NOT NULL,
  `username` varchar(45) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userm` varchar(45) DEFAULT NULL,
  `fecham` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`idjrv`),
  KEY `FK_jrv_1` (`idmunicipio`),
  KEY `FK_jrv_2` (`dui`),
  CONSTRAINT `FK_jrv_1` FOREIGN KEY (`idmunicipio`) REFERENCES `municipio` (`idmunicipio`),
  CONSTRAINT `FK_jrv_2` FOREIGN KEY (`dui`) REFERENCES `padronelectoral` (`dui`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jrv`
--

/*!40000 ALTER TABLE `jrv` DISABLE KEYS */;
INSERT INTO `jrv` (`idjrv`,`idmunicipio`,`iddepto`,`dui`,`username`,`fecha`,`userm`,`fecham`) VALUES 
 (1,'1','1','1','m','0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00');
/*!40000 ALTER TABLE `jrv` ENABLE KEYS */;


--
-- Definition of table `miembrojrv`
--

DROP TABLE IF EXISTS `miembrojrv`;
CREATE TABLE `miembrojrv` (
  `idmiembrojrv` varchar(5) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidop` varchar(45) NOT NULL,
  `apellidom` varchar(45) NOT NULL,
  `idjrv` int(10) unsigned NOT NULL,
  `idtipomiembro` varchar(5) NOT NULL,
  `username` varchar(45) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userm` varchar(45) DEFAULT NULL,
  `fecham` varchar(45) NOT NULL,
  PRIMARY KEY (`idmiembrojrv`),
  KEY `FK_miembrojrv_1` (`idtipomiembro`),
  CONSTRAINT `FK_miembrojrv_1` FOREIGN KEY (`idtipomiembro`) REFERENCES `tipomiembro` (`idtipomiembro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `miembrojrv`
--

/*!40000 ALTER TABLE `miembrojrv` DISABLE KEYS */;
INSERT INTO `miembrojrv` (`idmiembrojrv`,`nombres`,`apellidop`,`apellidom`,`idjrv`,`idtipomiembro`,`username`,`fecha`,`userm`,`fecham`) VALUES 
 ('MI001','Miguel Enrique','Agustin','Alvayero',1,'TM001','Mike','0000-00-00 00:00:00',NULL,''),
 ('MI002','aa','aa','aa',1,'TM002','Mike','0000-00-00 00:00:00',NULL,'');
/*!40000 ALTER TABLE `miembrojrv` ENABLE KEYS */;


--
-- Definition of table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
CREATE TABLE `municipio` (
  `idmunicipio` varchar(2) NOT NULL,
  `iddepto` varchar(2) NOT NULL,
  `nombmunicipio` varchar(25) NOT NULL,
  `username` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `userm` varchar(45) DEFAULT NULL,
  `fecham` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idmunicipio`),
  KEY `FK_municipio_1` (`iddepto`),
  CONSTRAINT `FK_municipio_1` FOREIGN KEY (`iddepto`) REFERENCES `departamento` (`iddepto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `municipio`
--

/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` (`idmunicipio`,`iddepto`,`nombmunicipio`,`username`,`fecha`,`userm`,`fecham`) VALUES 
 ('1','1','Municipio','Mike','',NULL,'0000-00-00 00:00:00');
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;


--
-- Definition of table `padronelectoral`
--

DROP TABLE IF EXISTS `padronelectoral`;
CREATE TABLE `padronelectoral` (
  `dui` varchar(10) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `fechanac` date DEFAULT NULL,
  `domicilio` varchar(75) NOT NULL,
  `estadovotacion` varchar(1) NOT NULL,
  `idurna` int(10) unsigned NOT NULL,
  `username` varchar(45) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userm` varchar(45) DEFAULT NULL,
  `fecham` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`dui`),
  KEY `FK_padronelectoral_1` (`idurna`),
  CONSTRAINT `FK_padronelectoral_1` FOREIGN KEY (`idurna`) REFERENCES `urna` (`idurna`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `padronelectoral`
--

/*!40000 ALTER TABLE `padronelectoral` DISABLE KEYS */;
INSERT INTO `padronelectoral` (`dui`,`nombre`,`apellidos`,`fechanac`,`domicilio`,`estadovotacion`,`idurna`,`username`,`fecha`,`userm`,`fecham`) VALUES 
 ('1','mm','mm','0000-00-00','mm','1',1,'m','0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00'),
 ('2','nn','nn','0000-00-00','mm','0',1,'m','0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00');
/*!40000 ALTER TABLE `padronelectoral` ENABLE KEYS */;


--
-- Definition of table `partidopolitico`
--

DROP TABLE IF EXISTS `partidopolitico`;
CREATE TABLE `partidopolitico` (
  `idpartido` varchar(3) NOT NULL,
  `nombpartido` varchar(25) NOT NULL,
  `fechafundac` date NOT NULL,
  `nombsecretariogral` varchar(55) NOT NULL,
  `username` varchar(45) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userm` varchar(45) DEFAULT NULL,
  `fecham` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`idpartido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `partidopolitico`
--

/*!40000 ALTER TABLE `partidopolitico` DISABLE KEYS */;
/*!40000 ALTER TABLE `partidopolitico` ENABLE KEYS */;


--
-- Definition of table `tipomiembro`
--

DROP TABLE IF EXISTS `tipomiembro`;
CREATE TABLE `tipomiembro` (
  `idtipomiembro` varchar(5) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userm` varchar(45) DEFAULT NULL,
  `fecham` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`idtipomiembro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipomiembro`
--

/*!40000 ALTER TABLE `tipomiembro` DISABLE KEYS */;
INSERT INTO `tipomiembro` (`idtipomiembro`,`descripcion`,`username`,`fecha`,`userm`,`fecham`) VALUES 
 ('aa','aaaa','aa','2014-11-03 22:36:38',NULL,'2014-11-03 22:36:38'),
 ('as','as','as','2014-11-03 22:20:46',NULL,'2014-11-03 22:20:46'),
 ('TM000','No activo','Mike','0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00'),
 ('TM001','Activo','Mike','0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00'),
 ('TM002','Descripcion 02','Mike','0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00'),
 ('TM003','Descripcion 03','Mike','0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00'),
 ('TM004','Descripcion 04','Mike','0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00'),
 ('TM005','Descripcion 05','Mike','2014-11-03 17:26:57',NULL,'0000-00-00 00:00:00'),
 ('TM006','Descripcion 06','Mike','2014-11-03 17:29:34',NULL,'0000-00-00 00:00:00'),
 ('TM007','Descripcion 07','Mike','2014-11-03 17:31:23',NULL,'0000-00-00 00:00:00');
/*!40000 ALTER TABLE `tipomiembro` ENABLE KEYS */;


--
-- Definition of table `urna`
--

DROP TABLE IF EXISTS `urna`;
CREATE TABLE `urna` (
  `idurna` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idmunicipio` varchar(2) NOT NULL,
  `iddepto` varchar(2) NOT NULL,
  `numjunta` decimal(6,0) NOT NULL,
  `presidente` varchar(45) NOT NULL,
  `secretario` varchar(45) NOT NULL,
  `cantvotosnulos` decimal(6,0) NOT NULL,
  `cantvotosnovalid` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userm` varchar(45) DEFAULT NULL,
  `fecham` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`idurna`),
  KEY `FK_urna_1` (`idmunicipio`),
  CONSTRAINT `FK_urna_1` FOREIGN KEY (`idmunicipio`) REFERENCES `municipio` (`idmunicipio`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `urna`
--

/*!40000 ALTER TABLE `urna` DISABLE KEYS */;
INSERT INTO `urna` (`idurna`,`idmunicipio`,`iddepto`,`numjunta`,`presidente`,`secretario`,`cantvotosnulos`,`cantvotosnovalid`,`username`,`fecha`,`userm`,`fecham`) VALUES 
 (1,'1','1','1','dasd','22','2','2','Mike','0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00');
/*!40000 ALTER TABLE `urna` ENABLE KEYS */;


--
-- Definition of table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `tipo` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id`,`nombre`,`apellido`,`username`,`password`,`tipo`) VALUES 
 (1,'Migue Enrique','Agustin','Mike','1234',1),
 (2,'MMMMMMMM','AAAAAAAAAA','MA','AA',2),
 (3,'MMMAAA','AAAA','AA','BB',3),
 (4,'asdasd','sdsd','sd','sss',2);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;


--
-- Definition of table `votacion`
--

DROP TABLE IF EXISTS `votacion`;
CREATE TABLE `votacion` (
  `idvotacion` decimal(6,0) NOT NULL,
  `idurna` int(10) unsigned NOT NULL,
  `idpartido` varchar(3) NOT NULL,
  `cantvotosvalidos` decimal(6,0) NOT NULL,
  `username` varchar(45) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userm` varchar(45) DEFAULT NULL,
  `fecham` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`idvotacion`),
  KEY `FK_votacion_1` (`idpartido`),
  KEY `FK_votacion_2` (`idurna`),
  CONSTRAINT `FK_votacion_1` FOREIGN KEY (`idpartido`) REFERENCES `partidopolitico` (`idpartido`),
  CONSTRAINT `FK_votacion_2` FOREIGN KEY (`idurna`) REFERENCES `urna` (`idurna`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `votacion`
--

/*!40000 ALTER TABLE `votacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `votacion` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
