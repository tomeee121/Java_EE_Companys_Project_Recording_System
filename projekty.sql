-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema projekty
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema projekty
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projekty` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci ;
USE `projekty` ;

-- -----------------------------------------------------
-- Table `projekty`.`rodzaj`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projekty`.`rodzaj` (
  `Id_rodzaj` INT NOT NULL AUTO_INCREMENT,
  `nazwa_rodzaj` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Id_rodzaj`),
  UNIQUE INDEX `nazwa_rodzaj_UNIQUE` (`nazwa_rodzaj` ASC) VISIBLE,
  UNIQUE INDEX `Id_rodzaj_UNIQUE` (`Id_rodzaj` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


-- -----------------------------------------------------
-- Table `projekty`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projekty`.`status` (
  `Id_status` INT NOT NULL AUTO_INCREMENT,
  `nazwa_status` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Id_status`),
  UNIQUE INDEX `nazwa_status_UNIQUE` (`nazwa_status` ASC) VISIBLE,
  UNIQUE INDEX `Id_status_UNIQUE` (`Id_status` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


-- -----------------------------------------------------
-- Table `projekty`.`projekt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projekty`.`projekt` (
  `Id_projekt` INT NOT NULL AUTO_INCREMENT,
  `Id_rodzaj` INT NOT NULL,
  `Id_status` INT NOT NULL,
  `nr_projekt` VARCHAR(15) NOT NULL,
  `temat_projekt` VARCHAR(150) NOT NULL,
  `data_rozpoczecia` DATE NOT NULL,
  `data_zakonczenia` DATE NOT NULL,
  `kwota` DECIMAL(10,2) NOT NULL,
  `uwagi` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`Id_projekt`),
  UNIQUE INDEX `Id_projekt_UNIQUE` (`Id_projekt` ASC) VISIBLE,
  UNIQUE INDEX `nr_projekt_UNIQUE` (`nr_projekt` ASC) VISIBLE,
  INDEX `fk_projekt_rodzaj1_idx` (`Id_rodzaj` ASC) VISIBLE,
  INDEX `fk_status_id_idx` (`Id_status` ASC) VISIBLE,
  CONSTRAINT `fk_rodzaj_id`
    FOREIGN KEY (`Id_rodzaj`)
    REFERENCES `projekty`.`rodzaj` (`Id_rodzaj`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_status_id`
    FOREIGN KEY (`Id_status`)
    REFERENCES `projekty`.`status` (`Id_status`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS
