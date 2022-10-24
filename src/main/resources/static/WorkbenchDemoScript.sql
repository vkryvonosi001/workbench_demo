-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema workbench_demo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema workbench_demo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `workbench_demo` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema workbench_demo
-- -----------------------------------------------------
USE `workbench_demo` ;

-- -----------------------------------------------------
-- Table `workbench_demo`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workbench_demo`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(60) NOT NULL,
  `last_name` VARCHAR(60) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `country` VARCHAR(60) NULL,
  `pwc_country_code` VARCHAR(6) NULL,
  `line_of_service` VARCHAR(10) NULL,
  `display_territory` VARCHAR(6) NULL,
  `username` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `workbench_demo`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workbench_demo`.`client` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(60) NOT NULL,
  `source` VARCHAR(20) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `workbench_demo`.`engagement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workbench_demo`.`engagement` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `searchable` TINYINT NOT NULL,
  `visible` TINYINT NOT NULL,
  `workspace_type` VARCHAR(45) NULL,
  `territory` VARCHAR(45) NULL,
  `line_of_service` VARCHAR(8) NULL,
  `engagement_type` VARCHAR(45) NULL,
  `period_start` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `period_end` TIMESTAMP NULL,
  `client_id` VARCHAR(36) NOT NULL,
  `created_by` INT NULL,
  `deleted_by` INT NULL,
  `leader_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_engagement_client1_idx` (`client_id` ASC) VISIBLE,
  INDEX `fk_engagement_user1_idx` (`created_by` ASC) VISIBLE,
  INDEX `fk_engagement_user2_idx` (`deleted_by` ASC) VISIBLE,
  INDEX `fk_engagement_team_member1_idx` (`leader_id` ASC) VISIBLE,
  CONSTRAINT `fk_engagement_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `workbench_demo`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_engagement_user1`
    FOREIGN KEY (`created_by`)
    REFERENCES `workbench_demo`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_engagement_user2`
    FOREIGN KEY (`deleted_by`)
    REFERENCES `workbench_demo`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_engagement_team_member1`
    FOREIGN KEY (`leader_id`)
    REFERENCES `workbench_demo`.`team_member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workbench_demo`.`team_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workbench_demo`.`team_member` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pwc_guid` VARCHAR(60) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `engagement_id` VARCHAR(36) NOT NULL,
  `user_id` INT NOT NULL,
  INDEX `fk_team_member_engagement1_idx` (`engagement_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_team_member_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_team_member_engagement1`
    FOREIGN KEY (`engagement_id`)
    REFERENCES `workbench_demo`.`engagement` (`id`)
    ON DELETE NO ACTION
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_team_member_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `workbench_demo`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workbench_demo`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workbench_demo`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `team_member_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_role_team_member1_idx` (`team_member_id` ASC) VISIBLE,
  CONSTRAINT `fk_role_team_member1`
    FOREIGN KEY (`team_member_id`)
    REFERENCES `workbench_demo`.`team_member` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workbench_demo`.`user_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workbench_demo`.`user_group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_user_group_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_group_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `workbench_demo`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
