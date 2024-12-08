-- User setup
USE kanrichan;

DROP USER IF EXISTS shunuser@'%';
DROP USER IF EXISTS shunuser@'localhost';
CREATE USER shunuser@'%' IDENTIFIED BY 'mysql0710';
CREATE USER shunuser@'localhost' IDENTIFIED BY 'mysql0710';
GRANT SELECT, INSERT, UPDATE, DELETE ON kanrichan.* TO shunuser@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON kanrichan.* TO shunuser@'localhost';