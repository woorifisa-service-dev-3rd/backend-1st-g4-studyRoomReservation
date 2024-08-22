-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema weird_quiz
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema weird_quiz
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `weird_quiz` DEFAULT CHARACTER SET utf8 ;
USE `weird_quiz` ;

-- -----------------------------------------------------
-- Table `weird_quiz`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `weird_quiz`.`users` (
  `user_id` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  `game_attempt_count` BIGINT NOT NULL DEFAULT 0,
  `game_success_count` BIGINT NOT NULL DEFAULT 0,
  `quiz_solved_count` BIGINT NOT NULL DEFAULT 0,
  `quiz_correct_count` BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weird_quiz`.`quizzes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `weird_quiz`.`quizzes` (
  `quiz_id` BIGINT NOT NULL AUTO_INCREMENT,
  `quiz_content` VARCHAR(255) NOT NULL,
  `is_weird` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`quiz_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weird_quiz`.`quiz_options`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `weird_quiz`.`quiz_options` (
  `quiz_id` BIGINT NOT NULL,
  `quiz_option_id` INT NOT NULL,
  `quiz_option_content` VARCHAR(255) NOT NULL,
  `is_answer` TINYINT NOT NULL,
  `weird_answer_message` VARCHAR(255) NULL,
  PRIMARY KEY (`quiz_id`, `quiz_option_id`),
  CONSTRAINT `fk_quiz_options_quizzes`
    FOREIGN KEY (`quiz_id`)
    REFERENCES `weird_quiz`.`quizzes` (`quiz_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;