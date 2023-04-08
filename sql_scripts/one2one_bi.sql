create table DOCTOR (
D_ID varchar(255) not null, -- not null means it will not allow null values
D_NAME varchar(255),
D_P_ID varchar(255), -- 
primary key (D_ID) -- The D_ID is unique column and treated as primary key of DOCTOR
);

create table PATIENT (
P_ID varchar(255) not null, -- not null means it will not allow null values
P_DESEASE varchar(255),
P_NAME varchar(255),
P_OP bigint,
primary key (P_ID) -- The P_ID is unique column and treated as primary key of PATIENT
);

alter table PATIENT drop index UK_ok75h9do3da6x76p9yaopqgri;
alter table PATIENT add constraint UK_ok75h9do3da6x76p9yaopqgri unique (P_OP); -- naturalId

-- In the below alter script foreign key column name(D_P_ID) mentioned in @JoinColumn
-- In the below alter script foreign key constraint name(FK_PATIENT) mentioned at @JoinColumn_@ForeignKey name
alter table DOCTOR add constraint FK_PATIENT foreign key (D_P_ID) references PATIENT (P_ID);

select * from Doctor;
select * from patient;

delete from Doctor;
delete from patient;
