CREATE USER 'ap'@'localhost' IDENTIFIED BY 'xxx';
GRANT ALL PRIVILEGES ON * . * TO 'ap'@'localhost';
CREATE USER 'ap'@'%' IDENTIFIED BY 'xxx';
GRANT ALL PRIVILEGES ON *.* TO 'ap'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

