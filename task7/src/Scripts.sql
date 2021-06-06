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

DROP TABLE IF EXISTS `dao_task`.`person`;
CREATE TABLE IF NOT EXISTS `dao_task`.`person`
(
    id      int auto_increment
        primary key,
    name    varchar(100) null,
    surname varchar(200) null,
    age     int          null
);

truncate table dao_task.address;
truncate table dao_task.person;