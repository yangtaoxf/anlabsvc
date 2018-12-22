Create Table: CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cn_name` varchar(50) DEFAULT NULL,
  `en_name` varchar(50) DEFAULT NULL
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;

insert into t_category (cn_name,en_name) values ('赛默飞','thermo');
insert into t_category (cn_name,en_name) values ('waters','waters');
insert into t_category (cn_name,en_name) values ('GE Explorer','GE Explorer');
