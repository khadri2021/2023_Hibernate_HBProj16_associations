create table ADHAAR (
A_ID varchar(255) not null, -- not null means it will not allow null values
COUNTRY varchar(255),
primary key (A_ID) -- The A_ID is unique column and treated as primary key of ADHAAR
);

create table CITIZEN (
C_ID varchar(255) not null, -- not null means it will not allow null values
C_NAME varchar(255),
ADHAAR_A_ID varchar(255), -- join column made by hibernate schema generation
primary key (C_ID)-- The C_ID is unique column and treated as primary key CITIZEN

);

-- In the below alter script foreign key column name(ADHAAR_A_ID) mentioned in @JoinColumn
-- In the below alter script foreign key constraint name(CITIZEN_ADHAAR_FK) mentioned at @JoinColumn_@ForeignKey name
alter table CITIZEN add constraint CITIZEN_ADHAAR_FK foreign key (ADHAAR_A_ID) references ADHAAR (A_ID);

select * from CITIZEN;
select * from ADHAAR;
drop table adhaar;
drop table citizen;