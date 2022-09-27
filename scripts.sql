/*Creating DB*/
CREATE DATABASE IF NOT EXISTS `crm-db`;

/*Using DB*/
USE `crm-db`;

/*Creating customer table*/
CREATE TABLE IF NOT EXISTS customer(
id int primary key NOT NULL AUTO_INCREMENT,
firstName varchar(255) NOT NULL,
lastName varchar(255),
eMail varchar(255) NOT NULL
);

/*Inserting into customer table*/
INSERT INTO customer(firstName, lastName, eMail) VALUES('Prabhu','Chinnasamy','prabhu_tc@yahoo.com');
INSERT INTO customer(firstName, lastName, eMail) VALUES('Sathya','Saravanan','ps_sathya@yahoo.com');
INSERT INTO customer(firstName, lastName, eMail) VALUES('Dhinesh Babu','Selvam','dhinesh_bs@yahoo.com');