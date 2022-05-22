
drop table if exists department;
drop table if exists jobmove;
drop table if exists employee;
drop table if exists salary;
drop table if exists project;
drop table if exists ep;

create table if not exists department(
	id int not null,
	name varchar(100) not null,
	primary key(id)
);

create table if not exists jobmove(
	id int not null,
	eid int not null,
	department varchar(100),
	job varchar(100),
	time timestamp default CURRENT_TIMESTAMP,
	primary key(id)
);

create table if not exists salary (
	id int not null,
	eid int not null,
	salary float not null,
	rewards float not null,
	time timestamp default CURRENT_TIMESTAMP,
	primary key(id)
);

create table if not exists employee (
	id int not null,
	did int,
	gender int not null,
	age int not null,
	name varchar(100) not null,
	job varchar(100) not null,
	primary key(id)
);

create table if not exists project (
	id int not null,
	name varchar(100) not null,
	primary key(id)
);

create table if not exists ep (
	eid int not null,
	pid int not null,
	primary key(eid,pid)
);

-- 插入数据
-- department
insert into department values (1,'department1');
insert into department values (2,'department2');
insert into department values (3,'department3');
-- employee
insert into employee values (1,2,0,25,'wys1','job1');
insert into employee values (2,1,1,22,'wys2','job2');
insert into employee values (3,1,1,35,'wys3','job3');
insert into employee values (4,2,0,33,'wys4','job4');
insert into employee values (5,3,1,50,'wys5','job5');
-- jobmove
insert into jobmove(id,eid,department,job) values (1,5,'Finance','null');
-- salary
insert into salary(id,eid,salary,rewards) values (1,1,20,10);
insert into salary(id,eid,salary,rewards) values (2,2,20,10);
insert into salary(id,eid,salary,rewards) values (3,3,100,30);
insert into salary(id,eid,salary,rewards) values (4,4,100,30);
insert into salary(id,eid,salary,rewards) values (5,5,500,50);
--project
insert into project values (1,'project1');
insert into project values (2,'project2');
insert into project values (3,'project3');
-- ep
insert into ep values (1,1);
insert into ep values (2,1);
insert into ep values (5,2);