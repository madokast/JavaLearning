CREATE DATABASE day190909;
USE day190909;
CREATE TABLE province
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL
);

INSERT INTO province values ('北京');
INSERT INTO province(name) values ('上海');
INSERT INTO province(name) values ('广州');
INSERT INTO province(name) values ('陕西');