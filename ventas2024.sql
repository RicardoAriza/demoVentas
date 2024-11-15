-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-11-2024 a las 23:05:06
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ventas2024`
--
CREATE DATABASE IF NOT EXISTS `ventas2024` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ventas2024`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `sp_delete_cliente`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_cliente` (`xidcliente` INT)   begin
  update cliente
  set estaclie=0
  where idcliente=xidcliente;
end$$

DROP PROCEDURE IF EXISTS `sp_delete_distrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_distrito` (`xiddistrito` INT)   begin
  update distrito
  set estadist=0
  where iddistrito=xiddistrito;
end$$

DROP PROCEDURE IF EXISTS `sp_delete_empleado`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_empleado` (`xidempleado` INT)   begin
  update empleado
  set estaempl=0
  where idempleado=xidempleado;
end$$

DROP PROCEDURE IF EXISTS `sp_delete_factura`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_factura` (`xidfactura` INT)   begin
update factura
set estafactura=0
where idfactura=xidfactura;
end$$

DROP PROCEDURE IF EXISTS `sp_delete_producto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_producto` (`xidproducto` INT)   begin
update producto
  set estaprod=0
where idproducto=xidproducto;
end$$

DROP PROCEDURE IF EXISTS `sp_delete_provincia`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_provincia` (`xidprovincia` INT)   begin
update provincia
set estaprov=0
where idprovincia=xidprovincia;
end$$

DROP PROCEDURE IF EXISTS `sp_insert_cliente`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_cliente` (`xrucclie` CHAR(11), `xnombclie` VARCHAR(50), `xdireclie` VARCHAR(100), `xiddistrito` INT, `xtelfclie` VARCHAR(15), `xceluclie` VARCHAR(15), `xemaclie` VARCHAR(50), `xobsvclie` VARCHAR(100), `xidprovincia` INT)   begin
  insert into cliente(rucclie,nombclie,direclie,
  iddistrito,telfclie,celuclie,emaclie,obsvclie,estaclie,idprovincia)
  values(xrucclie,xnombclie,xdireclie,xiddistrito,
  xtelfclie,xceluclie,xemaclie,xobsvclie,1,xidprovincia);
end$$

DROP PROCEDURE IF EXISTS `sp_insert_detallefactura`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_detallefactura` (`xidfactura` INT, `xidproducto` INT, `xprecprod` DECIMAL(10,2), `xcantidad` INT, `ximporte` DECIMAL(10,2))   begin
insert into detallefactura
values(xidfactura,xidproducto,xprecprod,xcantidad,ximporte);
end$$

DROP PROCEDURE IF EXISTS `sp_insert_distrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_distrito` (`xnombdist` VARCHAR(50), `xobsvdist` VARCHAR(100), `xidprovincia` INTEGER)   begin
  insert into distrito(nombdist,obsvdist,estadist,idprovincia)
  values(xnombdist,xobsvdist,1,xidprovincia);
end$$

DROP PROCEDURE IF EXISTS `sp_insert_empleado`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_empleado` (`xnombempl` VARCHAR(30), `xapatempl` VARCHAR(30), `xamatempl` VARCHAR(30), `xsexoempl` CHAR(1), `xdireempl` VARCHAR(100), `xiddistrito` INT, `xtelfempl` VARCHAR(15), `xceluempl` VARCHAR(15), `xemaiempl` VARCHAR(50), `xobsvempl` VARCHAR(100), `xfotoempl` VARCHAR(80), `xidprovincia` INT)   begin
  insert into empleado(nombempl,apatempl,amatempl,
  sexoempl,direempl,iddistrito,telfempl,
  celuempl,emaiempl,obsvempl,fotoempl,estaempl,idprovincia)
  values(xnombempl,xapatempl,xamatempl,xsexoempl,
  xdireempl,xiddistrito,xtelfempl,xceluempl,xemaiempl,
  xobsvempl,xfotoempl,1,xidprovincia);
end$$

DROP PROCEDURE IF EXISTS `sp_insert_factura`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_factura` (`xidcliente` INT, `xidempleado` INT, `xstotfact` DECIMAL(10,2), `xigvfact` DECIMAL(10,2), `xtotafact` DECIMAL(10,2), `xobsvfact` VARCHAR(100))   begin
insert into factura
values(0,now(),xidcliente,xidempleado,xstotfact,xigvfact,xtotafact,xobsvfact,1);
end$$

DROP PROCEDURE IF EXISTS `sp_insert_producto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_producto` (`xnombprod` VARCHAR(50), `xprecprod` DECIMAL(10,2), `xobsvprod` VARCHAR(100))   begin
insert into producto(nombprod,precprod,obsvprod,estaprod)
values(xnombprod,xprecprod,xobsvprod,1);
end$$

DROP PROCEDURE IF EXISTS `sp_insert_provincia`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_provincia` (`xnombprov` VARCHAR(50))   begin
insert into provincia(nombprov,estaprov)
values (xnombprov,1);
end$$

DROP PROCEDURE IF EXISTS `sp_inser_detallefactura`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_inser_detallefactura` (`xidfactura` INT, `xidproducto` INT, `xprecprod` DECIMAL(10,2), `xcantidad` INT, `ximporte` DECIMAL(10,2))   begin
insert into detallefactura
values(xidfactura,xidproducto,xprecprod,ximporte);
end$$

DROP PROCEDURE IF EXISTS `sp_update_cliente`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_cliente` (`xidcliente` INT, `xrucclie` CHAR(11), `xnombclie` VARCHAR(50), `xdireclie` VARCHAR(100), `xiddistrito` INT, `xtelfclie` VARCHAR(15), `xceluclie` VARCHAR(15), `xemaclie` VARCHAR(50), `xobsvclie` VARCHAR(100), `xidprovincia` INT)   begin
  update cliente
  set
  rucclie=xrucclie,
  nombclie=xnombclie,
  direclie=xdireclie,
  iddistrito=xiddistrito,
  telfclie=xtelfclie,
  celuclie=xceluclie,
  emaclie=xemaclie,
  obsvclie=xobsvclie,
  idprovincia=xidprovincia
  where idcliente=xidcliente;
end$$

DROP PROCEDURE IF EXISTS `sp_update_distrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_distrito` (`xiddistrito` INT, `xnombdist` VARCHAR(50), `xobsvdist` VARCHAR(100), `xidprovincia` INT)   begin
update distrito
  set nombdist=xnombdist,obsvdist=xobsvdist,idprovincia=xidprovincia
  where iddistrito=xiddistrito;
end$$

DROP PROCEDURE IF EXISTS `sp_update_empleado`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_empleado` (`xidempleado` INT, `xnombempl` VARCHAR(30), `xapatempl` VARCHAR(30), `xamatempl` VARCHAR(30), `xsexoempl` CHAR(1), `xdireempl` VARCHAR(100), `xiddistrito` INT, `xtelfempl` VARCHAR(15), `xceluempl` VARCHAR(15), `xemaiempl` VARCHAR(50), `xobsvempl` VARCHAR(100), `xfotoempl` VARCHAR(80), `xidprovincia` INT)   begin
  update empleado
  set
  nombempl=xnombempl,
  apatempl=xapatempl,
  amatempl=xamatempl,
  sexoempl=xsexoempl,
  direempl=xdireempl,
  iddistrito=xiddistrito,
  telfempl=xtelfempl,
  celuempl=xceluempl,
  emaiempl=xemaiempl,
  obsvempl=xobsvempl,
  fotoempl=xfotoempl,
  idprovincia=xidprovincia
  where idempleado=xidempleado;
end$$

DROP PROCEDURE IF EXISTS `sp_update_factura`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_factura` (`xidfactura` INT, `xfechfact` DATE, `xidcliente` INT, `xidempleado` INT, `xstotfact` DECIMAL(10,2), `xigvfact` DECIMAL(10,2), `xtotafact` DECIMAL(10,2), `xobsvfact` VARCHAR(100))   begin
update factura
set
fechfact=xfechfact,
idcliente=xidcliente,
idempleado=xidempleado,
stotfact=xstotfact,
igvfact=xigvfact,
totafact=xtotafact,
obsvfact=xobsvfact
where idfactura=xidfactura;
end$$

DROP PROCEDURE IF EXISTS `sp_update_producto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_producto` (`xidproducto` INT, `xnombprod` VARCHAR(50), `xprecprod` DECIMAL(10,2), `xobsvprod` VARCHAR(100))   begin
update producto
  set nombprod=xnombprod,precprod=xprecprod,obsvprod=xobsvprod
where idproducto=xidproducto;
end$$

DROP PROCEDURE IF EXISTS `sp_update_provincia`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_provincia` (`xidprovincia` INT, `xnombprov` VARCHAR(50))   begin
update provincia
set nombprov=xnombprov
where idprovincia=xidprovincia;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `rucclie` char(11) DEFAULT NULL,
  `nombclie` varchar(50) DEFAULT NULL,
  `direclie` varchar(100) DEFAULT NULL,
  `iddistrito` int(11) DEFAULT NULL,
  `telfclie` varchar(15) DEFAULT NULL,
  `celuclie` varchar(15) DEFAULT NULL,
  `emaclie` varchar(50) DEFAULT NULL,
  `obsvclie` varchar(100) DEFAULT NULL,
  `estaclie` tinyint(4) DEFAULT NULL,
  `idprovincia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idcliente`, `rucclie`, `nombclie`, `direclie`, `iddistrito`, `telfclie`, `celuclie`, `emaclie`, `obsvclie`, `estaclie`, `idprovincia`) VALUES
(3, '123456789', 'MARTIN', 'LOS CIPRECES', 10, '72083400', '990576234', 'MARTINVA@HOTMAIL.COM', 'DEVELOPER', 1, 9),
(4, '123459876', 'LESLIE', 'PARAISO', 3, '7490452', '978564243', 'LESLIEPT@HOTMAIL.COM', '', 1, 1),
(5, '12312', 'ASDSAD', 'ASDAS', 10, '123124', '123123', 'ASDASD', '', 0, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallefactura`
--

DROP TABLE IF EXISTS `detallefactura`;
CREATE TABLE `detallefactura` (
  `idfactura` int(11) NOT NULL,
  `idproducto` int(11) NOT NULL,
  `precprod` decimal(10,2) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `importe` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detallefactura`
--

INSERT INTO `detallefactura` (`idfactura`, `idproducto`, `precprod`, `cantidad`, `importe`) VALUES
(6, 2, '55.00', 2, '110.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distrito`
--

DROP TABLE IF EXISTS `distrito`;
CREATE TABLE `distrito` (
  `iddistrito` int(11) NOT NULL,
  `nombdist` varchar(50) DEFAULT NULL,
  `obsvdist` varchar(100) DEFAULT NULL,
  `estadist` tinyint(4) DEFAULT NULL,
  `idprovincia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `distrito`
--

INSERT INTO `distrito` (`iddistrito`, `nombdist`, `obsvdist`, `estadist`, `idprovincia`) VALUES
(1, 'HUACHO', '', 1, 1),
(2, 'HUALMAY', '', 1, 1),
(3, 'CALETA DE CARQUIN', '', 1, 1),
(4, 'SANTA LEONOR', '', 0, 1),
(5, 'HUAURA', '', 0, 1),
(6, 'HUAURA', '', 1, 1),
(7, 'SANTA MARIA', '', 0, 1),
(8, 'VEGUETA', '', 1, 1),
(9, 'SANTA MARIA', '', 1, 1),
(10, 'PACHANGARA', '', 1, 9),
(11, 'AMBAR', '', 1, 1),
(12, 'LEONCIO PRADO', '', 1, 1),
(13, 'CHECRAS', '', 1, 1),
(14, 'PACCHO', '', 1, 1),
(15, 'SAYAN', '', 1, 1),
(16, 'TANGAMANDAPIO', '', 0, 4),
(17, 'TANGAMANDAPIO', 'LUGAR BONITO', 0, 2),
(18, 'SUPE', '', 1, 2),
(19, 'MEDIO MUNDO', '', 0, 2),
(20, 'BARRANCA', '', 1, 2),
(21, 'PARAMONGA', '', 1, 2),
(22, 'PATIVILCA', '', 1, 2),
(23, 'SUPE PUERTO', '', 1, 2),
(24, 'OYON', '', 1, 9),
(25, 'ANDAJES', '', 1, 9),
(26, 'CAUJUL', '', 1, 9),
(27, 'COCHAMARCA', '', 1, 9),
(28, 'NAVÁN', '', 1, 9),
(29, 'CAJATAMBO', '', 1, 4),
(30, 'COPA', '', 1, 4),
(31, 'GORGOR', '', 1, 4),
(32, 'HUANCAPON', '', 1, 4),
(33, 'MANAS', '', 1, 4),
(34, 'ARAHUAY', '', 1, 3),
(35, 'CANTA', '', 1, 3),
(36, 'HUAMANTANGA', '', 1, 4),
(37, 'HUAROS', '', 1, 4),
(38, 'LACHAQUI', '', 1, 3),
(39, 'SAN BUENAVENTURA', '', 1, 3),
(40, 'SANTA ROSA DE QUIVES', '', 1, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `idempleado` int(11) NOT NULL,
  `nombempl` varchar(30) DEFAULT NULL,
  `apatempl` varchar(30) DEFAULT NULL,
  `amatempl` varchar(30) DEFAULT NULL,
  `sexoempl` char(1) DEFAULT NULL,
  `direempl` varchar(100) DEFAULT NULL,
  `iddistrito` int(11) DEFAULT NULL,
  `telfempl` varchar(15) DEFAULT NULL,
  `celuempl` varchar(15) DEFAULT NULL,
  `emaiempl` varchar(50) DEFAULT NULL,
  `obsvempl` varchar(100) DEFAULT NULL,
  `estaempl` tinyint(4) DEFAULT NULL,
  `fotoEmpl` varchar(80) DEFAULT NULL,
  `idprovincia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idempleado`, `nombempl`, `apatempl`, `amatempl`, `sexoempl`, `direempl`, `iddistrito`, `telfempl`, `celuempl`, `emaiempl`, `obsvempl`, `estaempl`, `fotoEmpl`, `idprovincia`) VALUES
(1, 'OMAR MARTÍN', 'VARELA', 'ARANA', 'M', 'CALLE \"LOS CIPRECES\" MZ B LT 9', 6, '018349542', '990030493', '0333181031@UNJFSC.EDU.PE', 'GRUPO F - TALLER DE DESARROLLO DE SOFTWARE I', 1, 'omar martín.jpg', 1),
(2, 'LESLIE ANTUANÉ', 'PÉREZ', 'TICONA', 'F', 'PARAÍSO', 9, '016564428', '960154944', '0333181024@UNJFSC.EDU.PE', 'GRUPO F - TALLER DE DESARROLLO DE SOFTWARE I', 1, 'leslie antuané.jpg', 1),
(3, 'YHINO YASER', 'RODRIGUEZ', 'PÉREZ', 'M', 'CP. \"SANTA CRUZ\" MZ 62 LT 14', 21, '015552347', '929106850', '0333181027@UNJFSC,EDU,PE', 'GRUPO F - TALLER DE DESARROLLO DE SOFTWARE I', 1, 'yhino yaser.jpg', 2),
(4, 'ALDO JYOAN RODRIGO', 'FIGUEROA', 'ROMÁN', 'M', 'URB. VILLA CARRIÓN MZ D LT 4', 6, '013331815', '986711456', '0333181006@UNJFSC.EDU.PE', 'GRUPO F - TALLER DE DESARROLLO DE SOFTWARE I', 1, 'aldo jyoan rodrigo.jpg', 1),
(5, 'CARLOS', 'VARELA', 'RODRIGUEZ', 'M', 'ASDSAF', 1, '123123', '123214423', 'QWEQWEWQ', '', 0, 'carlos.jpg', 1),
(6, 'DIANA', 'SANCHEZ', 'TICONA', 'M', 'QWEQWRQWRE', 2, '', '', '', '', 0, 'diana.jpg', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE `factura` (
  `idfactura` int(11) NOT NULL,
  `fechfact` datetime DEFAULT NULL,
  `idcliente` int(11) DEFAULT NULL,
  `idempleado` int(11) DEFAULT NULL,
  `stotfact` decimal(10,2) DEFAULT NULL,
  `igvfact` decimal(10,2) DEFAULT NULL,
  `totafact` decimal(10,2) DEFAULT NULL,
  `obsvfact` varchar(100) DEFAULT NULL,
  `estafact` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`idfactura`, `fechfact`, `idcliente`, `idempleado`, `stotfact`, `igvfact`, `totafact`, `obsvfact`, `estafact`) VALUES
(6, '2020-09-14 16:09:51', 3, 2, '84.75', '15.25', '100.00', '', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL,
  `nombprod` varchar(30) DEFAULT NULL,
  `precprod` decimal(10,2) DEFAULT NULL,
  `obsvprod` varchar(100) DEFAULT NULL,
  `estaprod` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idproducto`, `nombprod`, `precprod`, `obsvprod`, `estaprod`) VALUES
(1, 'gel', '8.50', '', 0),
(2, 'MOUSE GTX300', '99.99', 'EL MEEJOR MOUSE', 1),
(3, 'DISCO DURO AMD', '499.99', 'SIN DESCRIPCIÓN', 1),
(4, 'DETERGENTE', '5.00', 'LIMPIA TODO', 0),
(5, 'PC GAMER', '3500.00', '', 1),
(6, 'DETERGENTE', '5.00', 'EL MAS RENDIDOR', 1),
(7, 'ARTEFACTO', '49.00', 'BUENO BARATO', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

DROP TABLE IF EXISTS `provincia`;
CREATE TABLE `provincia` (
  `idprovincia` int(11) NOT NULL,
  `nombprov` varchar(50) DEFAULT NULL,
  `estaprov` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`idprovincia`, `nombprov`, `estaprov`) VALUES
(1, 'HUAURA', 1),
(2, 'BARRANCA', 1),
(3, 'CANTA', 1),
(4, 'CAJATAMBO', 1),
(5, 'CAÑETE', 1),
(6, 'HUAROCHIRI', 1),
(7, 'HUARAL', 1),
(8, 'LIMA', 1),
(9, 'OYÓN', 1),
(10, 'YAUYOS', 0),
(11, 'PARAISO', 0),
(12, 'YAUYOS', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `nivel` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `usuario`, `clave`, `nivel`) VALUES
(1, '1234', '1234', '1');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vcliente`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vcliente`;
CREATE TABLE `vcliente` (
`idcliente` int(11)
,`rucclie` char(11)
,`nombclie` varchar(50)
,`direclie` varchar(100)
,`nombdist` varchar(50)
,`telfclie` varchar(15)
,`celuclie` varchar(15)
,`emaclie` varchar(50)
,`obsvclie` varchar(100)
,`nombprov` varchar(50)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vdistrito`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vdistrito`;
CREATE TABLE `vdistrito` (
`iddistrito` int(11)
,`nombdist` varchar(50)
,`nombprov` varchar(50)
,`obsvdist` varchar(100)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vempleado`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vempleado`;
CREATE TABLE `vempleado` (
`idempleado` int(11)
,`nombempl` varchar(30)
,`apatempl` varchar(30)
,`amatempl` varchar(30)
,`sexoempl` char(1)
,`direempl` varchar(100)
,`nombdist` varchar(50)
,`telfempl` varchar(15)
,`celuempl` varchar(15)
,`emaiempl` varchar(50)
,`obsvempl` varchar(100)
,`nombprov` varchar(50)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vfactura`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vfactura`;
CREATE TABLE `vfactura` (
`idfactura` int(11)
,`fechfact` datetime
,`nombclie` varchar(50)
,`nombempl` varchar(30)
,`apatempl` varchar(30)
,`amatempl` varchar(30)
,`stotfact` decimal(10,2)
,`igvfact` decimal(10,2)
,`totafact` decimal(10,2)
,`obsvfact` varchar(100)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vfactura_anulada`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vfactura_anulada`;
CREATE TABLE `vfactura_anulada` (
`idfactura` int(11)
,`fechfact` datetime
,`nombclie` varchar(50)
,`nombempl` varchar(30)
,`apatempl` varchar(30)
,`amatempl` varchar(30)
,`stotfact` decimal(10,2)
,`igvfact` decimal(10,2)
,`totafact` decimal(10,2)
,`obsvfact` varchar(100)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vproducto`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vproducto`;
CREATE TABLE `vproducto` (
`idproducto` int(11)
,`nombprod` varchar(30)
,`precprod` decimal(10,2)
,`obsvprod` varchar(100)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vprovincia`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vprovincia`;
CREATE TABLE `vprovincia` (
`idprovincia` int(11)
,`nombprov` varchar(50)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vcliente`
--
DROP TABLE IF EXISTS `vcliente`;

DROP VIEW IF EXISTS `vcliente`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vcliente`  AS SELECT `c`.`idcliente` AS `idcliente`, `c`.`rucclie` AS `rucclie`, `c`.`nombclie` AS `nombclie`, `c`.`direclie` AS `direclie`, `d`.`nombdist` AS `nombdist`, `c`.`telfclie` AS `telfclie`, `c`.`celuclie` AS `celuclie`, `c`.`emaclie` AS `emaclie`, `c`.`obsvclie` AS `obsvclie`, `p`.`nombprov` AS `nombprov` FROM ((`cliente` `c` join `distrito` `d` on(`c`.`iddistrito` = `d`.`iddistrito`)) join `provincia` `p` on(`c`.`idprovincia` = `p`.`idprovincia`)) WHERE `c`.`estaclie` = 1 ORDER BY 1 AS `ASC1` ASC  ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vdistrito`
--
DROP TABLE IF EXISTS `vdistrito`;

DROP VIEW IF EXISTS `vdistrito`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vdistrito`  AS SELECT `d`.`iddistrito` AS `iddistrito`, `d`.`nombdist` AS `nombdist`, `p`.`nombprov` AS `nombprov`, `d`.`obsvdist` AS `obsvdist` FROM (`distrito` `d` join `provincia` `p` on(`d`.`idprovincia` = `p`.`idprovincia`)) WHERE `d`.`estadist` = 1 ORDER BY 1 AS `ASC1` ASC  ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vempleado`
--
DROP TABLE IF EXISTS `vempleado`;

DROP VIEW IF EXISTS `vempleado`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vempleado`  AS SELECT `e`.`idempleado` AS `idempleado`, `e`.`nombempl` AS `nombempl`, `e`.`apatempl` AS `apatempl`, `e`.`amatempl` AS `amatempl`, `e`.`sexoempl` AS `sexoempl`, `e`.`direempl` AS `direempl`, `d`.`nombdist` AS `nombdist`, `e`.`telfempl` AS `telfempl`, `e`.`celuempl` AS `celuempl`, `e`.`emaiempl` AS `emaiempl`, `e`.`obsvempl` AS `obsvempl`, `p`.`nombprov` AS `nombprov` FROM ((`empleado` `e` join `distrito` `d` on(`e`.`iddistrito` = `d`.`iddistrito`)) join `provincia` `p` on(`e`.`idprovincia` = `p`.`idprovincia`)) WHERE `e`.`estaempl` = 1 ORDER BY 1 AS `ASC1` ASC  ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vfactura`
--
DROP TABLE IF EXISTS `vfactura`;

DROP VIEW IF EXISTS `vfactura`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vfactura`  AS SELECT `f`.`idfactura` AS `idfactura`, `f`.`fechfact` AS `fechfact`, `c`.`nombclie` AS `nombclie`, `e`.`nombempl` AS `nombempl`, `e`.`apatempl` AS `apatempl`, `e`.`amatempl` AS `amatempl`, `f`.`stotfact` AS `stotfact`, `f`.`igvfact` AS `igvfact`, `f`.`totafact` AS `totafact`, `f`.`obsvfact` AS `obsvfact` FROM ((`factura` `f` join `cliente` `c` on(`f`.`idcliente` = `c`.`idcliente`)) join `empleado` `e` on(`f`.`idempleado` = `e`.`idempleado`)) WHERE `f`.`estafact` = 11  ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vfactura_anulada`
--
DROP TABLE IF EXISTS `vfactura_anulada`;

DROP VIEW IF EXISTS `vfactura_anulada`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vfactura_anulada`  AS SELECT `f`.`idfactura` AS `idfactura`, `f`.`fechfact` AS `fechfact`, `c`.`nombclie` AS `nombclie`, `e`.`nombempl` AS `nombempl`, `e`.`apatempl` AS `apatempl`, `e`.`amatempl` AS `amatempl`, `f`.`stotfact` AS `stotfact`, `f`.`igvfact` AS `igvfact`, `f`.`totafact` AS `totafact`, `f`.`obsvfact` AS `obsvfact` FROM ((`factura` `f` join `cliente` `c` on(`f`.`idcliente` = `c`.`idcliente`)) join `empleado` `e` on(`f`.`idempleado` = `e`.`idempleado`)) WHERE `f`.`estafact` = 00  ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vproducto`
--
DROP TABLE IF EXISTS `vproducto`;

DROP VIEW IF EXISTS `vproducto`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vproducto`  AS SELECT `producto`.`idproducto` AS `idproducto`, `producto`.`nombprod` AS `nombprod`, `producto`.`precprod` AS `precprod`, `producto`.`obsvprod` AS `obsvprod` FROM `producto` WHERE `producto`.`estaprod` = 11  ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vprovincia`
--
DROP TABLE IF EXISTS `vprovincia`;

DROP VIEW IF EXISTS `vprovincia`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vprovincia`  AS SELECT `provincia`.`idprovincia` AS `idprovincia`, `provincia`.`nombprov` AS `nombprov` FROM `provincia` WHERE `provincia`.`estaprov` = 11  ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`),
  ADD KEY `fk_cliente` (`iddistrito`),
  ADD KEY `fk_cliente2` (`idprovincia`);

--
-- Indices de la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  ADD PRIMARY KEY (`idfactura`,`idproducto`),
  ADD KEY `fk_detalleproducto` (`idproducto`);

--
-- Indices de la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD PRIMARY KEY (`iddistrito`),
  ADD KEY `fk_distrito` (`idprovincia`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idempleado`),
  ADD KEY `fk_empleado` (`iddistrito`),
  ADD KEY `fk_empleado2` (`idprovincia`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`idfactura`),
  ADD KEY `fk_facturaempleado2` (`idempleado`),
  ADD KEY `fk_facturacliente` (`idcliente`) USING BTREE;

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idproducto`);

--
-- Indices de la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`idprovincia`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `distrito`
--
ALTER TABLE `distrito`
  MODIFY `iddistrito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idempleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `idfactura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idproducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `provincia`
--
ALTER TABLE `provincia`
  MODIFY `idprovincia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente` FOREIGN KEY (`iddistrito`) REFERENCES `distrito` (`iddistrito`),
  ADD CONSTRAINT `fk_cliente2` FOREIGN KEY (`idprovincia`) REFERENCES `provincia` (`idprovincia`);

--
-- Filtros para la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  ADD CONSTRAINT `fk_detallefactura` FOREIGN KEY (`idfactura`) REFERENCES `factura` (`idfactura`),
  ADD CONSTRAINT `fk_detallefactura1` FOREIGN KEY (`idfactura`) REFERENCES `factura` (`idfactura`),
  ADD CONSTRAINT `fk_detalleproducto` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`);

--
-- Filtros para la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD CONSTRAINT `fk_distrito` FOREIGN KEY (`idprovincia`) REFERENCES `provincia` (`idprovincia`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_empleado` FOREIGN KEY (`iddistrito`) REFERENCES `distrito` (`iddistrito`),
  ADD CONSTRAINT `fk_empleado2` FOREIGN KEY (`idprovincia`) REFERENCES `provincia` (`idprovincia`);

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `fk_facturacliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`),
  ADD CONSTRAINT `fk_facturaempleado2` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
