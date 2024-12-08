DROP DATABASE IF EXISTS kanrichan;
CREATE DATABASE IF NOT EXISTS kanrichan;
USE kanrichan;

-- Create position table
CREATE TABLE IF NOT EXISTS position (
    position_id INT PRIMARY KEY AUTO_INCREMENT,
    position_name VARCHAR(100)
);

-- Create gender table
CREATE TABLE IF NOT EXISTS gender (
    gender_id INT PRIMARY KEY AUTO_INCREMENT,
    gender_name VARCHAR(50)
);

-- Create employee table without foreign key constraints
CREATE TABLE IF NOT EXISTS employee (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(50),
    emp_kana VARCHAR(50),
    birth DATE,
    tel VARCHAR(50),
    mail VARCHAR(100),
    post_code VARCHAR(50),
    address VARCHAR(100),
    login_id VARCHAR(50) UNIQUE,
    pass VARCHAR(50),
    position_id INT NOT NULL,
    gender_id INT NOT NULL
);