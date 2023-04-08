create table EMPLOYEE (
EMP_ID varchar(255) not null, 
EMP_NAME varchar(255), 
primary key (EMP_ID)
);
create table EMPLOYEE_PROJECT (
Employee_EMP_ID varchar(255) not null, 
listProjects_PRO_ID varchar(255) not null
);
create table PROJECT (
PRO_ID varchar(255) not null, 
PRO_NAME varchar(255), 
primary key (PRO_ID)
);

alter table EMPLOYEE_PROJECT add constraint FKgiipcmtf2pe47c47qa110at8r foreign key (listProjects_PRO_ID) references PROJECT (PRO_ID);
alter table EMPLOYEE_PROJECT add constraint FKogy6kx5mwg1gi5clqo22xx8ta foreign key (Employee_EMP_ID) references EMPLOYEE (EMP_ID);

select * from employee;
select * from EMPLOYEE_PROJECT;
select * from project;

-- Added bi directional scripts
create table PROJECT_EMPLOYEE (
Project_PRO_ID varchar(255) not null, 
listEmployees_EMP_ID varchar(255) not null
);
alter table PROJECT_EMPLOYEE add constraint FK75w0wl9kes1o54wvd80egn10 foreign key (listEmployees_EMP_ID) references EMPLOYEE (EMP_ID);
alter table PROJECT_EMPLOYEE add constraint FKnf6d3ij1ykj6qdvlenlrerwk foreign key (Project_PRO_ID) references PROJECT (PRO_ID);
