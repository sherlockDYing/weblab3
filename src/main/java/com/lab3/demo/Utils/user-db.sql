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

INSERT INTO comment (posttime,statuename,username,introduction) VALUES
  ('123333', 'kaiyudai', 'qqqq', 'kydai@fudan.edu.cn'),
  ('fanliu', '12345678', 'qqqq', '13888888888'),
  ('xingyuzhang', '12345678', 'qqqq', 'aaa');

  INSERT INTO user (username, password,gender ,role,location,introduction,workplace) VALUES
  ('qqq')

CREATE TABLE IF NOT EXISTS user (
  id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  gender VARCHAR (4) ,
  role INT DEFAULT NULL,
  location VARCHAR (100) ,
  introduction VARCHAR (400),
  workplace VARCHAR (100),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS comment (
  id INT(11) NOT NULL AUTO_INCREMENT,
  posttime VARCHAR (255) NOT NULL ,
  statuename VARCHAR (255) NOT  NULL ,
  username VARCHAR (255) NOT NULL,
  introduction VARCHAR (500),
  PRIMARY KEY (id)
);