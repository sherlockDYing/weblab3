SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (
  userID INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  email VARCHAR(100) DEFAULT NULL,
  phone VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (UserID)
);

INSERT INTO user (userID, username, password, email, phone) VALUES
  (1, 'kaiyudai', '12345678', 'kydai@fudan.edu.cn', '13666666666'),
  (2, 'fanliu', '12345678', 'liufan@fudan.edu.cn', '13888888888'),
  (3, 'xingyuzhang', '12345678', NULL, NULL);
