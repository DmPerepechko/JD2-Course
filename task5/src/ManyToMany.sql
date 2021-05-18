DROP SCHEMA IF EXISTS `dao_task`;
CREATE SCHEMA IF NOT EXISTS `dao_task` DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS `dao_task`.`address`;
CREATE TABLE IF NOT EXISTS `dao_task`.`address`
(
    id     int auto_increment
        primary key,
    street varchar(100) null,
    house  int          null
);

DROP TABLE IF EXISTS `dao_task`.`people`;
CREATE TABLE IF NOT EXISTS `dao_task`.`people`
(
    id      int auto_increment
        primary key,
    name    varchar(100) null,
    surname varchar(200) null,
    age     int          null
);

DROP TABLE IF EXISTS `dao_task`.`address_people`;
CREATE TABLE IF NOT EXISTS `dao_task`.`address_people`
(
    `id`         INT NOT NULL AUTO_INCREMENT,
    `id_address`  INT NOT NULL,
    `id_person` INT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_person_address`
        FOREIGN KEY (`id_person`)
            REFERENCES `dao_task`.`people` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT `fk_address_person`
        FOREIGN KEY (`id_address`)
            REFERENCES `dao_task`.`address` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

truncate table dao_task.address;
truncate table dao_task.people;
truncate table dao_task.address_people;