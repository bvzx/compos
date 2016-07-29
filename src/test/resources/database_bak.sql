drop table if exists `t_user`;

CREATE TABLE `bvzx`.`t_user` (
  `id` INT NOT NULL DEFAULT '主键',
  `age` VARCHAR(45) NULL DEFAULT '年纪',
  `addr` VARCHAR(45) NULL DEFAULT '地址',
  `phone` VARCHAR(45) NULL DEFAULT '手机号码',
  `nick` VARCHAR(45) NULL DEFAULT '昵称',
  `passwd` VARCHAR(45) NULL DEFAULT '密码',
  `create_time` VARCHAR(45) NULL DEFAULT '创建时间',
  `update_time` VARCHAR(45) NULL DEFAULT '修改时间',
  `is_freeze` VARCHAR(45) NULL DEFAULT '是否冻结',
  `is_valid` VARCHAR(45) NULL DEFAULT '是否有效',
  `acc_weibo` VARCHAR(45) NULL DEFAULT '微博关联账号',
  `acc_weixin` VARCHAR(45) NULL DEFAULT '微信关联账号',
  PRIMARY KEY (`id`));
