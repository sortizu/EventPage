-- MySQL Script generated by MySQL Workbench
-- Fri Oct 27 07:33:53 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema event_page
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema event_page
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `event_page` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `event_page` ;

-- -----------------------------------------------------
-- Table `event_page`.`categoriaevento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `event_page`.`categoriaevento` (
  `id_catevento` INT NOT NULL AUTO_INCREMENT,
  `nombre_catevento` VARCHAR(45) NOT NULL,
  `eliminado` TINYINT NOT NULL,
  PRIMARY KEY (`id_catevento`),
  UNIQUE INDEX `id_catevento_UNIQUE` (`id_catevento` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `event_page`.`invitado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `event_page`.`invitado` (
  `id_invitado` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `biografia` VARCHAR(300) NOT NULL,
  `eliminado` TINYINT NOT NULL,
  PRIMARY KEY (`id_invitado`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `event_page`.`evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `event_page`.`evento` (
  `id_evento` INT NOT NULL AUTO_INCREMENT,
  `nombre_evento` VARCHAR(45) NULL DEFAULT NULL,
  `costo` DOUBLE NULL DEFAULT NULL,
  `fecha` DATETIME NULL DEFAULT NULL,
  `capacidad` INT NULL DEFAULT NULL,
  `id_categoria` INT NULL DEFAULT NULL,
  `descripcion` VARCHAR(300) NULL DEFAULT NULL,
  `id_invitado` INT NULL DEFAULT NULL,
  `eliminado` VARCHAR(45) NOT NULL,
  `destacado` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`id_evento`),
  UNIQUE INDEX `id_evento_UNIQUE` (`id_evento` ASC) VISIBLE,
  INDEX `fk_evento_eventcat_idx` (`id_categoria` ASC) VISIBLE,
  INDEX `fk_evento_invitado_idx` (`id_invitado` ASC) VISIBLE,
  CONSTRAINT `fk_evento_eventcat`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `event_page`.`categoriaevento` (`id_catevento`),
  CONSTRAINT `fk_evento_invitado`
    FOREIGN KEY (`id_invitado`)
    REFERENCES `event_page`.`invitado` (`id_invitado`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `event_page`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `event_page`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NULL DEFAULT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  `dni` INT NULL DEFAULT NULL,
  `correo` VARCHAR(45) NULL DEFAULT NULL,
  `contraseña` VARCHAR(45) NULL DEFAULT NULL,
  `admin` TINYINT NULL DEFAULT NULL,
  `eliminado` TINYINT NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `id_usuario_UNIQUE` (`id_usuario` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `event_page`.`carrito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `event_page`.`carrito` (
  `id_usuario` INT NOT NULL,
  `id_evento` INT NOT NULL,
  INDEX `FK_CARRITO_USUARIO_idx` (`id_usuario` ASC) VISIBLE,
  INDEX `FK_CARRITO_EVENTO_idx` (`id_evento` ASC) VISIBLE,
  CONSTRAINT `FK_CARRITO_EVENTO`
    FOREIGN KEY (`id_evento`)
    REFERENCES `event_page`.`evento` (`id_evento`),
  CONSTRAINT `FK_CARRITO_USUARIO`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `event_page`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `event_page`.`ticket_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `event_page`.`ticket_usuario` (
  `id_ticket` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NOT NULL,
  PRIMARY KEY (`id_ticket`),
  INDEX `FK_TICKET_USUARIO_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `FK_TICKET_USUARIO`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `event_page`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `event_page`.`ticket_evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `event_page`.`ticket_evento` (
  `id_ticket` INT NOT NULL,
  `id_evento` INT NOT NULL,
  INDEX `FK_TICKET_EVENTO_idx` (`id_evento` ASC) VISIBLE,
  INDEX `FK_PK_TICKET_idx` (`id_ticket` ASC) VISIBLE,
  CONSTRAINT `FK_PK_TICKET`
    FOREIGN KEY (`id_ticket`)
    REFERENCES `event_page`.`ticket_usuario` (`id_ticket`),
  CONSTRAINT `FK_TICKET_EVENTO`
    FOREIGN KEY (`id_evento`)
    REFERENCES `event_page`.`evento` (`id_evento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
