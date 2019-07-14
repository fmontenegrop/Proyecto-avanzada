-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-07-2019 a las 01:22:20
-- Versión del servidor: 5.7.25-log
-- Versión de PHP: 7.1.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_universidad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_curso`
--

CREATE TABLE `tb_curso` (
  `id` int(2) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_profesor` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tb_curso`
--

INSERT INTO `tb_curso` (`id`, `nombre`, `codigo_profesor`) VALUES
(1, 'bases de datos', 2),
(2, 'calculo', 1),
(3, 'fisica', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_estudiante`
--

CREATE TABLE `tb_estudiante` (
  `codigo` int(2) NOT NULL,
  `nombre` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `clave` int(8) NOT NULL,
  `cc` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tb_estudiante`
--

INSERT INTO `tb_estudiante` (`codigo`, `nombre`, `apellido`, `correo`, `clave`, `cc`) VALUES
(1, 'martin', 'martinez', 'martin.m@correo.com', 2345, 23456785),
(2, 'fredy', 'cardenas', 'cardenas@correo.com', 123455, 34567896),
(3, 'adrea', 'leon', 'andreita@correo.com', 5678, 45678321);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_notas`
--

CREATE TABLE `tb_notas` (
  `id` int(4) NOT NULL,
  `id_r` int(4) NOT NULL,
  `cod_profesor` int(2) NOT NULL,
  `nota` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_profesor`
--

CREATE TABLE `tb_profesor` (
  `codigo` int(2) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `cc` int(10) NOT NULL,
  `clave` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tb_profesor`
--

INSERT INTO `tb_profesor` (`codigo`, `nombre`, `cc`, `clave`) VALUES
(1, 'andres gomez', 23456732, 12345),
(2, 'carlos gonzalez', 79456733, 11111),
(3, 'julian blanco', 1008453674, 23451);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_registro`
--

CREATE TABLE `tb_registro` (
  `id` int(4) NOT NULL,
  `fecha` date NOT NULL,
  `cod_e` int(2) NOT NULL,
  `id_c` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_curso`
--
ALTER TABLE `tb_curso`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_profesor` (`codigo_profesor`);

--
-- Indices de la tabla `tb_estudiante`
--
ALTER TABLE `tb_estudiante`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `cc` (`cc`);

--
-- Indices de la tabla `tb_notas`
--
ALTER TABLE `tb_notas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_r` (`id_r`),
  ADD UNIQUE KEY `cod_profesor` (`cod_profesor`);

--
-- Indices de la tabla `tb_profesor`
--
ALTER TABLE `tb_profesor`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `cc` (`cc`);

--
-- Indices de la tabla `tb_registro`
--
ALTER TABLE `tb_registro`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cod_e` (`cod_e`),
  ADD UNIQUE KEY `id_c` (`id_c`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_curso`
--
ALTER TABLE `tb_curso`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tb_estudiante`
--
ALTER TABLE `tb_estudiante`
  MODIFY `codigo` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tb_notas`
--
ALTER TABLE `tb_notas`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_profesor`
--
ALTER TABLE `tb_profesor`
  MODIFY `codigo` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `tb_registro`
--
ALTER TABLE `tb_registro`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_curso`
--
ALTER TABLE `tb_curso`
  ADD CONSTRAINT `tb_curso_ibfk_1` FOREIGN KEY (`codigo_profesor`) REFERENCES `tb_profesor` (`codigo`);

--
-- Filtros para la tabla `tb_notas`
--
ALTER TABLE `tb_notas`
  ADD CONSTRAINT `tb_notas_ibfk_1` FOREIGN KEY (`id_r`) REFERENCES `tb_registro` (`id`),
  ADD CONSTRAINT `tb_notas_ibfk_2` FOREIGN KEY (`cod_profesor`) REFERENCES `tb_profesor` (`codigo`);

--
-- Filtros para la tabla `tb_registro`
--
ALTER TABLE `tb_registro`
  ADD CONSTRAINT `tb_registro_ibfk_1` FOREIGN KEY (`id_c`) REFERENCES `tb_curso` (`id`),
  ADD CONSTRAINT `tb_registro_ibfk_2` FOREIGN KEY (`cod_e`) REFERENCES `tb_estudiante` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
