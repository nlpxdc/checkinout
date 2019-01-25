SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `openId` varchar(50) NOT NULL,
  `nickname` varchar(100) NOT NULL ,
  `gender` int(11) NOT NULL default 0,
  `avatar_url` char(200),
  PRIMARY KEY (`openId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1;
