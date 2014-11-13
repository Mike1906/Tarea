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
  PRIMARY KEY (`iddepto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departamento`
--

/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` (`iddepto`,`nombredepto`,`zonageografica`,`username`) VALUES 
 ('1','La Libertad','No se','Mike'),
 ('2','23','23','23');
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
INSERT INTO `jrv` (`idjrv`,`idmunicipio`,`iddepto`,`dui`,`username`) VALUES 
 (1,'1','1','1','m');
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
  PRIMARY KEY (`idmiembrojrv`),
  KEY `FK_miembrojrv_1` (`idtipomiembro`),
  KEY `FK_miembrojrv_2` (`idjrv`),
  CONSTRAINT `FK_miembrojrv_1` FOREIGN KEY (`idtipomiembro`) REFERENCES `tipomiembro` (`idtipomiembro`),
  CONSTRAINT `FK_miembrojrv_2` FOREIGN KEY (`idjrv`) REFERENCES `jrv` (`idjrv`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `miembrojrv`
--

/*!40000 ALTER TABLE `miembrojrv` DISABLE KEYS */;
INSERT INTO `miembrojrv` (`idmiembrojrv`,`nombres`,`apellidop`,`apellidom`,`idjrv`,`idtipomiembro`,`username`) VALUES 
 ('MI001','Vladimir','AA','AA',1,'TM003','Mike'),
 ('MI002','Miguel Enrique','Agustin','Alvayero',1,'TM001','Mike');
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
  PRIMARY KEY (`idmunicipio`),
  KEY `FK_municipio_1` (`iddepto`),
  CONSTRAINT `FK_municipio_1` FOREIGN KEY (`iddepto`) REFERENCES `departamento` (`iddepto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `municipio`
--

/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` (`idmunicipio`,`iddepto`,`nombmunicipio`,`username`) VALUES 
 ('1','1','Municipio','Mike');
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
  PRIMARY KEY (`dui`),
  KEY `FK_padronelectoral_1` (`idurna`),
  CONSTRAINT `FK_padronelectoral_1` FOREIGN KEY (`idurna`) REFERENCES `urna` (`idurna`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `padronelectoral`
--

/*!40000 ALTER TABLE `padronelectoral` DISABLE KEYS */;
INSERT INTO `padronelectoral` (`dui`,`nombre`,`apellidos`,`fechanac`,`domicilio`,`estadovotacion`,`idurna`,`username`) VALUES 
 ('1','mm','mm','0000-00-00','mm','1',1,'m'),
 ('2','nn','nn','0000-00-00','mm','0',1,'m');
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
  PRIMARY KEY (`idpartido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `partidopolitico`
--

/*!40000 ALTER TABLE `partidopolitico` DISABLE KEYS */;
INSERT INTO `partidopolitico` (`idpartido`,`nombpartido`,`fechafundac`,`nombsecretariogral`,`username`) VALUES 
 ('1','ARENA','1980-06-12','No se ','Mike');
/*!40000 ALTER TABLE `partidopolitico` ENABLE KEYS */;


--
-- Definition of table `tipomiembro`
--

DROP TABLE IF EXISTS `tipomiembro`;
CREATE TABLE `tipomiembro` (
  `idtipomiembro` varchar(5) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`idtipomiembro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipomiembro`
--

/*!40000 ALTER TABLE `tipomiembro` DISABLE KEYS */;
INSERT INTO `tipomiembro` (`idtipomiembro`,`descripcion`,`username`) VALUES 
 ('TM001','Descripcion 01','Mike'),
 ('TM002','Descripcion 02','Mike'),
 ('TM003','Descripcion 03','Mike'),
 ('TM004','Descripcion 04','Mike'),
 ('TM005','Descripcion 05','Mike'),
 ('TM006','Descripcion 06','Mike'),
 ('TM007','Descripcion 07','Mike');
/*!40000 ALTER TABLE `tipomiembro` ENABLE KEYS */;


--
-- Definition of table `urna`
--

DROP TABLE IF EXISTS `urna`;
CREATE TABLE `urna` (
  `idurna` int(10) unsigned NOT NULL,
  `idmunicipio` varchar(2) NOT NULL,
  `iddepto` varchar(2) NOT NULL,
  `numjunta` int(10) unsigned NOT NULL,
  `presidente` varchar(45) NOT NULL,
  `secretario` varchar(45) NOT NULL,
  `cantvotosnulos` int(10) unsigned NOT NULL,
  `cantvotosnovalid` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`idurna`),
  KEY `FK_urna_1` (`idmunicipio`),
  CONSTRAINT `FK_urna_1` FOREIGN KEY (`idmunicipio`) REFERENCES `municipio` (`idmunicipio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `urna`
--

/*!40000 ALTER TABLE `urna` DISABLE KEYS */;
INSERT INTO `urna` (`idurna`,`idmunicipio`,`iddepto`,`numjunta`,`presidente`,`secretario`,`cantvotosnulos`,`cantvotosnovalid`,`username`) VALUES 
 (1,'1','1',1,'dasd','22',2,'2','Mike'),
 (2,'1','1',2,'2','2',2,'2','2'),
 (3,'1','1',32,'3','3',3,'4','4');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id`,`nombre`,`apellido`,`username`,`password`,`tipo`) VALUES 
 (1,'Migue Enrique','Agustin','Mike','1234',1),
 (2,'Mike','Agustin','admin','admin',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;


--
-- Definition of table `votacion`
--

DROP TABLE IF EXISTS `votacion`;
CREATE TABLE `votacion` (
  `idvotacion` varchar(6) NOT NULL,
  `idurna` int(10) unsigned NOT NULL,
  `idpartido` varchar(3) NOT NULL,
  `cantvotosvalidos` int(10) unsigned NOT NULL,
  `username` varchar(45) NOT NULL,
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
INSERT INTO `votacion` (`idvotacion`,`idurna`,`idpartido`,`cantvotosvalidos`,`username`) VALUES 
 ('23',1,'1',23,'23');
/*!40000 ALTER TABLE `votacion` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
