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
    id      int not null auto_increment
        primary key,
    name    varchar(100) null,
    surname varchar(200) null,
    age     int          null,
    id_address int not null,
    CONSTRAINT `fk_person_address`
        FOREIGN KEY (id_address)
            REFERENCES `dao_task`.`address` (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

truncate table dao_task.address;
truncate table dao_task.people;

delete
from address
where id > 0;