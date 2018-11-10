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
-- Table `jobtracking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jobtracking` ;

CREATE TABLE IF NOT EXISTS `jobtracking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company` VARCHAR(45) NOT NULL,
  `company_description` VARCHAR(120) NOT NULL,
  `position` VARCHAR(100) NULL,
  `applied` TINYINT NULL,
  `interview_notes` VARCHAR(200) NULL,
  `salary` DECIMAL(10,2) NULL,
  `benefits` VARCHAR(200) NULL,
  `job_offer` TINYINT NULL,
  `created` DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS user@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `jobtracking`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobtrackerdb`;
INSERT INTO `jobtracking` (`id`, `company`, `company_description`, `position`, `applied`, `interview_notes`, `salary`, `benefits`, `job_offer`, `created`) VALUES (1, 'Skill Distillery', 'Coding bootcampt for the STARS', 'Junior Software Developer', 1, 'fun', 25000.00, 'Insurance paid time off', 1, '2018-11-09 00:00:00');

COMMIT;

