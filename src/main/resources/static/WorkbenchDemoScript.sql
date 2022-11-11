-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema workbench_demo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `workbench_demo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `workbench_demo` ;

-- -----------------------------------------------------
-- Table `workbench_demo`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workbench_demo`.`client` (
  `id` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `source` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `workbench_demo`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workbench_demo`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(255) NULL DEFAULT NULL,
  `display_territory` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `is_external` BIT(1) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `line_of_service` VARCHAR(255) NULL DEFAULT NULL,
  `pwc_country_code` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `workbench_demo`.`engagement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workbench_demo`.`engagement` (
  `id` VARCHAR(255) NOT NULL,
  `engagement_type` VARCHAR(255) NULL DEFAULT NULL,
  `line_of_service` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `period_end` DATE NULL DEFAULT NULL,
  `period_start` DATE NULL DEFAULT NULL,
  `searchable` BIT(1) NULL DEFAULT NULL,
  `territory` VARCHAR(255) NULL DEFAULT NULL,
  `visible` BIT(1) NULL DEFAULT NULL,
  `workspace_type` VARCHAR(255) NULL DEFAULT NULL,
  `client_id` VARCHAR(255) NULL DEFAULT NULL,
  `created_by` BIGINT NULL DEFAULT NULL,
  `deleted_by` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKfnw2vrkdtd7wgn2kb5a9srepo` (`client_id` ASC) VISIBLE,
  INDEX `FKiusqcs65l4ndv4olcdwchb11i` (`created_by` ASC) VISIBLE,
  INDEX `FKs1xfpmlh233132flotor7v3um` (`deleted_by` ASC) VISIBLE,
  CONSTRAINT `FKfnw2vrkdtd7wgn2kb5a9srepo`
    FOREIGN KEY (`client_id`)
    REFERENCES `workbench_demo`.`client` (`id`),
  CONSTRAINT `FKiusqcs65l4ndv4olcdwchb11i`
    FOREIGN KEY (`created_by`)
    REFERENCES `workbench_demo`.`user` (`id`),
  CONSTRAINT `FKs1xfpmlh233132flotor7v3um`
    FOREIGN KEY (`deleted_by`)
    REFERENCES `workbench_demo`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `workbench_demo`.`domain`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workbench_demo`.`domain` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `engagement_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKt0fa0m40ke279n92lqaxq4p3x` (`engagement_id` ASC) VISIBLE,
  CONSTRAINT `FKt0fa0m40ke279n92lqaxq4p3x`
    FOREIGN KEY (`engagement_id`)
    REFERENCES `workbench_demo`.`engagement` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `workbench_demo`.`team_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workbench_demo`.`team_member` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `pwc_guid` VARCHAR(255) NULL DEFAULT NULL,
  `engagement_id` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKe8ogkd4il8e4vy92t6t825qo3` (`engagement_id` ASC) VISIBLE,
  INDEX `FKg24qjftfifisxhilscl0vmrb1` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKe8ogkd4il8e4vy92t6t825qo3`
    FOREIGN KEY (`engagement_id`)
    REFERENCES `workbench_demo`.`engagement` (`id`),
  CONSTRAINT `FKg24qjftfifisxhilscl0vmrb1`
    FOREIGN KEY (`user_id`)
    REFERENCES `workbench_demo`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `workbench_demo`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workbench_demo`.`role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `team_member_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK6i0hubth3uupm8nfa9wlauo6w` (`team_member_id` ASC) VISIBLE,
  CONSTRAINT `FK6i0hubth3uupm8nfa9wlauo6w`
    FOREIGN KEY (`team_member_id`)
    REFERENCES `workbench_demo`.`team_member` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `workbench_demo`.`user_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workbench_demo`.`user_group` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK1c1dsw3q36679vaiqwvtv36a6` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK1c1dsw3q36679vaiqwvtv36a6`
    FOREIGN KEY (`user_id`)
    REFERENCES `workbench_demo`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
