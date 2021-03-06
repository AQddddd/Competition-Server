CREATE DATABASE IF NOT EXISTS xpef DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

CREATE USER 'xpefadmin'@'localhost' IDENTIFIED BY 'Xpef@2021';
CREATE USER 'xpefadmin'@'%' IDENTIFIED BY 'Xpef@2021';
GRANT ALL ON xpef.* TO 'xpefadmin'@'localhost';
GRANT ALL ON xpef.* TO 'xpefadmin'@'%';

FLUSH PRIVILEGES;