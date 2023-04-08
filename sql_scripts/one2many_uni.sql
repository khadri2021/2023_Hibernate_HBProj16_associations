create table SCHOOL (
S_ID varchar(255) not null,
S_ADDRESS varchar(255), 
S_NAME varchar(255), 
S_REG_NUMBER varchar(255), 
primary key (S_ID)
);

create table STUDENT (
ST_ID varchar(255) not null, 
ST_GRADE varchar(255), 
ST_NAME varchar(255), 
primary key (ST_ID)
);

create table SCHOOL_STUDENT (
School_S_ID varchar(255) not null, 
student_ST_ID varchar(255) not null
);
alter table SCHOOL_STUDENT add constraint UK_e3t0lqxdlmoelpkhmot4qcy51 unique (student_ST_ID);
alter table SCHOOL_STUDENT add constraint FKqqgpf88h4ro6vmhyxbu1xbe34 foreign key (student_ST_ID) references STUDENT (ST_ID);
alter table SCHOOL_STUDENT add constraint FKpic9u7end383yh0h7hc4bqght foreign key (School_S_ID) references SCHOOL (S_ID);

select * from school;
select * from school_student;
select * from student;
select * from headmaster;
 
create table HEADMASTER (
H_ID varchar(255) not null, 
H_AGE integer, 
H_NAME varchar(255), 
primary key (H_ID)
);
alter table SCHOOL add column headerMaster_H_ID varchar(255);
alter table SCHOOL add constraint FKqgvexjt1kebrfryre4pdco7jv foreign key (headerMaster_H_ID) references HEADMASTER (H_ID);

