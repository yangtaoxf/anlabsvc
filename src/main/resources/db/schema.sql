drop table if exists city;
drop table if exists hotel;

create table city (id int primary key auto_increment, name varchar, state varchar, country varchar);
create table hotel (city int, name varchar, address varchar, zip varchar);

drop table if exists t_category;

CREATE TABLE t_category (
	id int primary key auto_increment,
	cn_name varchar,
	en_name varchar
);