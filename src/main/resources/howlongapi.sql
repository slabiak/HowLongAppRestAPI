CREATE DATABASE  IF NOT EXISTS `howlongapi`;
USE `howlongapi`;

CREATE TABLE IF NOT EXISTS `restaurants` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(256),
	`address` VARCHAR(256),
    `google_id` VARCHAR(256),
    `photo_reference` VARCHAR(256),
    PRIMARY KEY (`id`)
)
;
CREATE TABLE IF NOT EXISTS `reports` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`created_at` DATETIME,
	`waiting_time` INT(11),
	`created_by` VARCHAR(256),
    `restaurant_id` INT(11),
    PRIMARY KEY (`id`),
	KEY `restaurant_id` (`restaurant_id`),
	CONSTRAINT `FK_reports_restaurant` FOREIGN KEY (`restaurant_id`) 
  REFERENCES `restaurants` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION

)