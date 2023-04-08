create table BUS (
B_ID varchar(255) not null, 
B_BUS_NO varchar(255), 
B_DEST varchar(255), 
B_SOURCE varchar(255), 
primary key (B_ID)
);

create table BUS_PASSENGER (
Bus_B_ID varchar(255) not null, 
listPassenger_P_ID varchar(255) not null
);

create table PASSENGER (
P_ID varchar(255) not null, 
P_TNO varchar(255), 
bus_B_ID varchar(255), 
primary key (P_ID)
);

-- busNo is unique column because it is @NaturalId
alter table BUS add constraint UK_donrrsbf0vpcl2y3mjdh5v9wo unique (B_BUS_NO);

-- Adding column joincolumn from join table reference to Passender table (OneToMany)
alter table BUS_PASSENGER add constraint UK_36el1q8i33dtoq3mujlf1lv78 unique (listPassenger_P_ID);
alter table BUS_PASSENGER add constraint FK6gameau0npy1klbot47uu52eu foreign key (listPassenger_P_ID) references PASSENGER (P_ID);
alter table BUS_PASSENGER add constraint FKt45xhsuebch65yj9j6feh75y6 foreign key (Bus_B_ID) references BUS (B_ID);

-- Adding a joincolumn reference to Bus table from passenger (ManyToOne)
alter table PASSENGER add constraint FK156l504nhaba0lpg99vpp0ud5 foreign key (bus_B_ID) references BUS (B_ID);


select * from bus;
select * from passenger;
select * from BUS_PASSENGER;