-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hsdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hsdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hsdb` ;

-- -----------------------------------------------------
-- Table `hsdb`.`departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`departments` (
  `department_id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `location` VARCHAR(45) NULL DEFAULT NULL,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`department_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`specialty`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`specialty` (
  `position_id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`position_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`doctors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`doctors` (
  `doctor_id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `contact_details` VARCHAR(45) NULL DEFAULT NULL,
  `departments_department_id` INT NOT NULL,
  `specialty_position_id` INT NOT NULL,
  PRIMARY KEY (`doctor_id`),
  INDEX `fk_doctors_departments1_idx` (`departments_department_id` ASC) VISIBLE,
  INDEX `fk_doctors_specialty1_idx` (`specialty_position_id` ASC) VISIBLE,
  CONSTRAINT `fk_doctors_departments1`
    FOREIGN KEY (`departments_department_id`)
    REFERENCES `hsdb`.`departments` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_doctors_specialty1`
    FOREIGN KEY (`specialty_position_id`)
    REFERENCES `hsdb`.`specialty` (`position_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`patients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`patients` (
  `patient_id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `date_of_birth` DATE NULL DEFAULT NULL,
  `insurance_info` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`patient_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`appointments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`appointments` (
  `appointment_id` INT NOT NULL,
  `date` DATE NULL DEFAULT NULL,
  `time` TIME NULL DEFAULT NULL,
  `doctors_doctor_id` INT NOT NULL,
  `patients_patient_id` INT NOT NULL,
  PRIMARY KEY (`appointment_id`),
  INDEX `fk_appointments_doctors1_idx` (`doctors_doctor_id` ASC) VISIBLE,
  INDEX `fk_appointments_patients1_idx` (`patients_patient_id` ASC) VISIBLE,
  CONSTRAINT `fk_appointments_doctors1`
    FOREIGN KEY (`doctors_doctor_id`)
    REFERENCES `hsdb`.`doctors` (`doctor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointments_patients1`
    FOREIGN KEY (`patients_patient_id`)
    REFERENCES `hsdb`.`patients` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`diagnoses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`diagnoses` (
  `diagnosis_id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`diagnosis_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`hospitals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`hospitals` (
  `hospital_id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `location` VARCHAR(45) NULL DEFAULT NULL,
  `contact_details` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`hospital_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`lab_tests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`lab_tests` (
  `test_id` INT NOT NULL,
  `patient_id` INT NULL DEFAULT NULL,
  `diagnosis_id` INT NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  `results` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`test_id`),
  INDEX `patient_id` (`patient_id` ASC) VISIBLE,
  INDEX `diagnosis_id` (`diagnosis_id` ASC) VISIBLE,
  CONSTRAINT `lab_tests_ibfk_1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `hsdb`.`patients` (`patient_id`),
  CONSTRAINT `lab_tests_ibfk_2`
    FOREIGN KEY (`diagnosis_id`)
    REFERENCES `hsdb`.`diagnoses` (`diagnosis_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`medications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`medications` (
  `medication_id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `dosage` VARCHAR(45) NULL DEFAULT NULL,
  `usage_instructions` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`medication_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`treatments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`treatments` (
  `treatment_id` INT NOT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  `duration` INT NULL DEFAULT NULL,
  PRIMARY KEY (`treatment_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`patient_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`patient_history` (
  `history_id` INT NOT NULL,
  `diagnosis_id` INT NULL DEFAULT NULL,
  `patients_patient_id` INT NOT NULL,
  `appointments_id` INT NOT NULL,
  `treatments_treatment_id` INT NOT NULL,
  PRIMARY KEY (`history_id`),
  INDEX `diagnosis_id` (`diagnosis_id` ASC) VISIBLE,
  INDEX `fk_patient_history_patients1_idx` (`patients_patient_id` ASC) VISIBLE,
  INDEX `fk_patient_history_appointments1_idx` (`appointments_id` ASC) VISIBLE,
  INDEX `fk_patient_history_treatments1_idx` (`treatments_treatment_id` ASC) VISIBLE,
  CONSTRAINT `patient_history_ibfk_2`
    FOREIGN KEY (`diagnosis_id`)
    REFERENCES `hsdb`.`diagnoses` (`diagnosis_id`),
  CONSTRAINT `fk_patient_history_patients1`
    FOREIGN KEY (`patients_patient_id`)
    REFERENCES `hsdb`.`patients` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_patient_history_appointments1`
    FOREIGN KEY (`appointments_id`)
    REFERENCES `hsdb`.`appointments` (`appointment_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_patient_history_treatments1`
    FOREIGN KEY (`treatments_treatment_id`)
    REFERENCES `hsdb`.`treatments` (`treatment_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`prescriptions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`prescriptions` (
  `prescription_id` INT NOT NULL,
  `patients_patient_id` INT NOT NULL,
  `medications_medication_id` INT NOT NULL,
  PRIMARY KEY (`prescription_id`),
  INDEX `fk_prescriptions_patients1_idx` (`patients_patient_id` ASC) VISIBLE,
  INDEX `fk_prescriptions_medications1_idx` (`medications_medication_id` ASC) VISIBLE,
  CONSTRAINT `fk_prescriptions_patients1`
    FOREIGN KEY (`patients_patient_id`)
    REFERENCES `hsdb`.`patients` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prescriptions_medications1`
    FOREIGN KEY (`medications_medication_id`)
    REFERENCES `hsdb`.`medications` (`medication_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`ambulatory_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`ambulatory_card` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patients_patient_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ambulatory_card_patients1_idx` (`patients_patient_id` ASC) VISIBLE,
  CONSTRAINT `fk_ambulatory_card_patients1`
    FOREIGN KEY (`patients_patient_id`)
    REFERENCES `hsdb`.`patients` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hsdb`.`hospitals_departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`hospitals_departments` (
  `departments_department_id` INT NOT NULL,
  `hospitals_hospital_id` INT NOT NULL,
  PRIMARY KEY (`departments_department_id`, `hospitals_hospital_id`),
  INDEX `fk_departments_has_hospitals_hospitals1_idx` (`hospitals_hospital_id` ASC) VISIBLE,
  INDEX `fk_departments_has_hospitals_departments1_idx` (`departments_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_departments_has_hospitals_departments1`
    FOREIGN KEY (`departments_department_id`)
    REFERENCES `hsdb`.`departments` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_departments_has_hospitals_hospitals1`
    FOREIGN KEY (`hospitals_hospital_id`)
    REFERENCES `hsdb`.`hospitals` (`hospital_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`treatments_medications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`treatments_medications` (
  `treatments_treatment_id` INT NOT NULL,
  `medications_medication_id` INT NOT NULL,
  PRIMARY KEY (`treatments_treatment_id`, `medications_medication_id`),
  INDEX `fk_treatments_has_medications_medications1_idx` (`medications_medication_id` ASC) VISIBLE,
  INDEX `fk_treatments_has_medications_treatments1_idx` (`treatments_treatment_id` ASC) VISIBLE,
  CONSTRAINT `fk_treatments_has_medications_treatments1`
    FOREIGN KEY (`treatments_treatment_id`)
    REFERENCES `hsdb`.`treatments` (`treatment_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_treatments_has_medications_medications1`
    FOREIGN KEY (`medications_medication_id`)
    REFERENCES `hsdb`.`medications` (`medication_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hsdb`.`patient_complains`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hsdb`.`patient_complains` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patients_patient_id` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_patient_complains_patients1_idx` (`patients_patient_id` ASC) VISIBLE,
  CONSTRAINT `fk_patient_complains_patients1`
    FOREIGN KEY (`patients_patient_id`)
    REFERENCES `hsdb`.`patients` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
