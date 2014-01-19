/*
MySQL Data Transfer
Source Host: localhost
Source Database: softeng
Target Host: localhost
Target Database: softeng
Date: 17/1/2014 1:06:04 μμ
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `ac` int(100) NOT NULL AUTO_INCREMENT,
  `cuser` char(50) CHARACTER SET utf8 DEFAULT NULL,
  `cpass` char(50) CHARACTER SET utf8 DEFAULT NULL,
  `cname` char(50) CHARACTER SET utf8 DEFAULT NULL,
  `clname` char(50) CHARACTER SET utf8 DEFAULT NULL,
  `caddress` char(50) CHARACTER SET utf8 DEFAULT NULL,
  `cstate` char(50) CHARACTER SET utf8 DEFAULT NULL,
  `cpost` char(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ac`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `aa` int(100) NOT NULL DEFAULT '0',
  `username` char(50) DEFAULT NULL,
  `password` char(50) DEFAULT NULL,
  PRIMARY KEY (`aa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for transfer
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer` (
  `at` int(100) NOT NULL AUTO_INCREMENT,
  `tname` char(50) CHARACTER SET utf8 DEFAULT NULL,
  `tlname` char(50) CHARACTER SET utf8 DEFAULT NULL,
  `taddress` char(50) CHARACTER SET utf8 DEFAULT NULL,
  `tstate` char(50) CHARACTER SET utf8 DEFAULT NULL,
  `tpost` char(50) CHARACTER SET utf8 DEFAULT NULL,
  `tvalue` double(50,1) DEFAULT NULL,
  `courrier` int(100) DEFAULT NULL,
  `ttime` int(100) DEFAULT NULL,
  PRIMARY KEY (`at`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `customer` VALUES ('1', 'test', 'test', 'test_name', 'test_last_name', 'test_address', 'test_state', 'test_post');
INSERT INTO `customer` VALUES ('2', 'test2', 'test2', 'test2', 'test2', 'test2', 'test2', 'test2');
INSERT INTO `login` VALUES ('1', 'admin', 'admin');
INSERT INTO `login` VALUES ('51', 'teste', 'teste');
INSERT INTO `login` VALUES ('101', 'testc', 'testc');
INSERT INTO `transfer` VALUES ('1', 'test', 'test', 'test', 'test', 'test', '4.0', '1', '5');
INSERT INTO `transfer` VALUES ('2', 'test2', 'test2', 'test2', 'test2', 'test2', '2.0', '1', '60');
