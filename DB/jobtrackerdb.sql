-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jobtrackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jobtrackerdb` ;

-- -----------------------------------------------------
-- Schema jobtrackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jobtrackerdb` DEFAULT CHARACTER SET utf8 ;
USE `jobtrackerdb` ;

-- -----------------------------------------------------
-- Table `job`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `job` ;

CREATE TABLE IF NOT EXISTS `job` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `position` VARCHAR(100) NULL,
  `applied` TINYINT NULL,
  `interview_notes` VARCHAR(200) NULL,
  `salary` DECIMAL(10,2) NULL,
  `job_offer` TINYINT NULL,
  `created` DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP,
  `company_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `company` ;

CREATE TABLE IF NOT EXISTS `company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(300) NULL,
  `benefits` VARCHAR(400) NULL,
  `address` VARCHAR(120) NULL,
  `phone_number` VARCHAR(12) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS user@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user'@'localhost';
GRANT SELECT, INSERT, TRIGGER ON TABLE * TO 'user'@'localhost';
GRANT SELECT ON TABLE * TO 'user'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `job`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobtrackerdb`;
INSERT INTO `job` (`id`, `position`, `applied`, `interview_notes`, `salary`, `job_offer`, `created`, `company_id`) VALUES (1, 'Junior Software Developer', 1, 'fun', 25000.00, 1, '2018-11-10 00:00:00', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `company`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobtrackerdb`;
INSERT INTO `company` (`id`, `name`, `description`, `benefits`, `address`, `phone_number`) VALUES (1, 'Skill Distillery', 'Full-Stack Java boot camp', 'insurance steve rob alex paul as my new bff', 'Denver Co', '');

COMMIT;

