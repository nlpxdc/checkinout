SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for check_in_out_record
-- ----------------------------
DROP TABLE IF EXISTS `check_in_out_record`;
CREATE TABLE `check_in_out_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openId` varchar(100) NOT NULL ,
  `type` int(11) NOT NULL ,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  key `idx_openId`(`openId`),
  key `idx_time`(`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1;
