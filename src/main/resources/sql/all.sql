CREATE TABLE `t_category` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`en_name` VARCHAR(50) NOT NULL DEFAULT '0',
	`cn_name` VARCHAR(50) NOT NULL DEFAULT '0',
	`node_level` INT NOT NULL DEFAULT '0',
	`node_id` VARCHAR(50) NOT NULL DEFAULT '0',
	`parent_node` VARCHAR(50) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
;

------------------------------LABORATORY-----------------------------
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('LABORATORY','LABORATORY','01-00-00',1,'-1');

insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('Analytical Instruments','Analytical Instruments','01-01-00',2,'01-00-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('Biotech & Life Science','Biotech & Life Science','01-02-00',2,'01-00-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('Clinical Laboratory','Clinical Laboratory','01-03-00',2,'01-00-00');

insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('HPLC','HPLC','01-01-01',3,'01-01-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('Mass Spectrometer','Mass Spectrometer','01-01-02',3,'01-01-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('NIR','NIR','01-01-03',3,'01-01-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('pH Meter','pH Meter','01-01-04',3,'01-01-00');

insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('Microplate','Microplate','01-02-01',3,'01-02-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('Antibodies/Reagens','Antibodies/Reagents','01-02-02',3,'01-02-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('PCR and DNA','PCR and DNA','01-02-03',3,'01-02-00');

insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('Hematology Analyzers','Hematology Analyzers','01-03-01',3,'01-03-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('Cell Counters','Cell Counters','01-03-00',3,'01-03-02');


------------------------------LIFE SCIENCE-----------------------------
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('LIFE SCIENCE','LIFE SCIENCE','02-00-00',1,'-1');

insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('Microplate Equipement','Microplate Equipement','02-01-00',2,'02-00-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('LIFE SCIENCE','LIFE SCIENCE','02-00-00',2,'02-02-00');


------------------------------CHROMATOGRAPHY-----------------------------
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('CHROMATOGRAPHY','CHROMATOGRAPHY','03-00-00',1,'-1');

insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('Gas Chromatography','Gas Chromatography','03-01-00',2,'03-00-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('Liquid Chromatography','Liquid Chromatography','03-02-00',2,'03-00-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('Other Chromatography','Other Chromatography','03-03-00',2,'03-00-00');

insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('GC Systems','GC Systems','03-01-01',3,'03-01-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('GC Autosamplers','GC Autosamplers','03-01-02',3,'03-01-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('GC Columns','GC Columns','03-01-03',3,'03-01-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('GC Accessories','GC Accessories','03-01-04',3,'03-01-00');

insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('HPLC Systems','HPLC Systems','03-02-01',3,'03-02-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('FPLC Systems','FPLC Systems','03-02-02',3,'03-02-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('UHPLC Systems','UHPLC Systems','03-02-03',3,'03-02-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('GPC Systems','GPC Systems','03-02-04',3,'03-02-00');
insert into t_category (cn_name,en_name,node_id,node_level,parent_node) values ('HPLC Columns','HPLC Columns','03-02-05',3,'03-02-00');



 CREATE TABLE `t_manufacturer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cn_name` varchar(50) DEFAULT NULL,
  `en_name` varchar(50) DEFAULT NULL,
  `logo_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;
insert into t_manufacturer (cn_name,en_name) values ('Thermo Fisher','Thermo Fisher');
insert into t_manufacturer (cn_name,en_name) values ('SHIMADZU','SHIMADZU');
insert into t_manufacturer (cn_name,en_name) values ('BRUKER','BRUKER');
insert into t_manufacturer (cn_name,en_name) values ('huber','huber');
insert into t_manufacturer (cn_name,en_name) values ('Metrohm','Metrohm');

insert into t_manufacturer (cn_name,en_name) values ('METTLER TOLEDO','METTLER TOLEDO');
insert into t_manufacturer (cn_name,en_name) values ('eppendorf','eppendorf');
insert into t_manufacturer (cn_name,en_name) values ('BIO RAD','BIO RAD');
insert into t_manufacturer (cn_name,en_name) values ('BERTHOLD','BERTHOLD');
insert into t_manufacturer (cn_name,en_name) values ('Agilent','Agilent');
