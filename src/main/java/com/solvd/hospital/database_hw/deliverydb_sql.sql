-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema deliverydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema deliverydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `deliverydb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `deliverydb` ;

-- -----------------------------------------------------
-- Table `deliverydb`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deliverydb`.`customers` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `deliverydb`.`delivery_addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deliverydb`.`delivery_addresses` (
  `address_id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(255) NOT NULL,
  `city` VARCHAR(255) NOT NULL,
  `postal_code` VARCHAR(255) NOT NULL,
  `country` VARCHAR(255) NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`address_id`),
  INDEX `fk_delivery_addresses_customers1_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_delivery_addresses_customers1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `deliverydb`.`customers` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `deliverydb`.`delivery_vehicles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deliverydb`.`delivery_vehicles` (
  `vehicle_id` INT NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `year` INT NOT NULL,
  `license_plate` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`vehicle_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `deliverydb`.`delivery_drivers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deliverydb`.`delivery_drivers` (
  `driver_id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(255) NOT NULL,
  `vehicle_id` INT NOT NULL,
  PRIMARY KEY (`driver_id`),
  INDEX `vehicle_id` (`vehicle_id` ASC) VISIBLE,
  CONSTRAINT `delivery_drivers_ibfk_1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `deliverydb`.`delivery_vehicles` (`vehicle_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `deliverydb`.`delivery_orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deliverydb`.`delivery_orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `delivery_status` VARCHAR(255) NOT NULL,
  `order_date` DATE NOT NULL,
  `driver_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_delivery_orders_delivery_drivers1_idx` (`driver_id` ASC) VISIBLE,
  INDEX `fk_delivery_orders_customers1_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_delivery_orders_delivery_drivers1`
    FOREIGN KEY (`driver_id`)
    REFERENCES `deliverydb`.`delivery_drivers` (`driver_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_delivery_orders_customers1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `deliverydb`.`customers` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `deliverydb`.`delivery_packages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deliverydb`.`delivery_packages` (
  `package_id` INT NOT NULL,
  `package_type` VARCHAR(255) NULL DEFAULT NULL,
  `price` FLOAT NULL,
  PRIMARY KEY (`package_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `deliverydb`.`delivery_payments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deliverydb`.`delivery_payments` (
  `payment_id` INT NOT NULL,
  `payment_method` VARCHAR(255) NOT NULL,
  `amount` FLOAT NOT NULL,
  `order_id` INT NOT NULL,
  PRIMARY KEY (`payment_id`),
  INDEX `fk_delivery_payments_delivery_orders1_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_delivery_payments_delivery_orders1`
    FOREIGN KEY (`order_id`)
    REFERENCES `deliverydb`.`delivery_orders` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `deliverydb`.`delivery_reviews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deliverydb`.`delivery_reviews` (
  `review_id` INT NOT NULL AUTO_INCREMENT,
  `order_id` INT NOT NULL,
  `rating` INT NOT NULL,
  `review` VARCHAR(255) NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`review_id`),
  INDEX `order_id` (`order_id` ASC) VISIBLE,
  INDEX `fk_delivery_reviews_customers1_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `delivery_reviews_ibfk_1`
    FOREIGN KEY (`order_id`)
    REFERENCES `deliverydb`.`delivery_orders` (`order_id`),
  CONSTRAINT `fk_delivery_reviews_customers1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `deliverydb`.`customers` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `deliverydb`.`delivery_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deliverydb`.`delivery_products` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `price` FLOAT NOT NULL,
  `weight` FLOAT NOT NULL,
  PRIMARY KEY (`id_product`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `deliverydb`.`packaged_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deliverydb`.`packaged_product` (
  `id_product` INT NOT NULL,
  `package_id` INT NOT NULL,
  `packaged_product_id` INT NOT NULL,
  INDEX `fk_delivery_products_has_delivery_packages_delivery_package_idx` (`package_id` ASC) VISIBLE,
  INDEX `fk_delivery_products_has_delivery_packages_delivery_product_idx` (`id_product` ASC) VISIBLE,
  PRIMARY KEY (`packaged_product_id`),
  CONSTRAINT `fk_delivery_products_has_delivery_packages_delivery_products1`
    FOREIGN KEY (`id_product`)
    REFERENCES `deliverydb`.`delivery_products` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_delivery_products_has_delivery_packages_delivery_packages1`
    FOREIGN KEY (`package_id`)
    REFERENCES `deliverydb`.`delivery_packages` (`package_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `deliverydb`.`ordered_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deliverydb`.`ordered_products` (
  `packaged_product_id` INT NOT NULL,
  `order_id` INT NOT NULL,
  PRIMARY KEY (`packaged_product_id`, `order_id`),
  INDEX `fk_packaged_product_has_delivery_orders_delivery_orders1_idx` (`order_id` ASC) VISIBLE,
  INDEX `fk_packaged_product_has_delivery_orders_packaged_product1_idx` (`packaged_product_id` ASC) VISIBLE,
  CONSTRAINT `fk_packaged_product_has_delivery_orders_packaged_product1`
    FOREIGN KEY (`packaged_product_id`)
    REFERENCES `deliverydb`.`packaged_product` (`packaged_product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_packaged_product_has_delivery_orders_delivery_orders1`
    FOREIGN KEY (`order_id`)
    REFERENCES `deliverydb`.`delivery_orders` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
