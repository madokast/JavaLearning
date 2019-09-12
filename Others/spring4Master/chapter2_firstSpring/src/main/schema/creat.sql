DROP DATABASE IF EXISTS sampledb;
CREATE DATABASE sampledb DEFAULT CHARACTER SET utf8;
USE sampledb;

-- 创建用户表
CREATE TABLE t_user(
    user_id INT AUTO_INCREMENT PRIMARY KEY ,
    user_name VARCHAR(30),
    credits INT,
    password VARCHAR(32),
    last_visit DATETIME,  -- 最近登录时间
    last_ip VARCHAR(23)  -- 最近登录的ip
)ENGINE = InnoDB;

-- 创建用户登录日志表
CREATE TABLE t_login_log(
    login_log_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    ip VARCHAR(23),
    login_datetime DATETIME
)ENGINE = InnoDB;

-- 插入初始数据
INSERT INTO t_user(user_name, password) VALUES ('admin','123456');
COMMIT ;
