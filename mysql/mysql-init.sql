CREATE DATABASE IF NOT EXISTS dontcallme;
use dontcallme;

CREATE TABLE IF NOT EXISTS CCTV (
  userID            varchar(20) NOT NULL  PRIMARY KEY,
  userPassword      varchar(64) NULL,
  userName          varchar(20) NULL,
  userGender        varchar(20) NULL,
  userEmail         varchar(50) NULL,
  userEmailHash     varchar(64) NULL,
  userEmailChecked  tinyint(1)  NULL,
  userIP            varchar(50) NULL
);


LOCK TABLES CCTV WRITE;
INSERT INTO `CCTV` (`userID`, `userPassword`, `userName`, `userGender`, `userEmail`, `userEmailHash`, `userEmailChecked`, `userIP`) VALUES
('abcde', 'abcde', 'a1b2c3', 'ff', 'abcde@12345.com', 'abcde', 1, '192.168.0.1');
UNLOCK TABLES;
