-------------------------------------------- creates --------------------------------------------
create table user(i_id int not null auto_increment,
                  s_first_name varchar(255) unique,
                  s_last_name varchar(255),
                  s_password varchar(255),
                  s_role varchar(255),
                  primary key(i_id));

create table location(i_id int not null auto_increment,
                      s_address varchar(255),
                      primary key(i_id));

create table car(i_id int not null auto_increment,
                 i_current_location_id int not null,
                 s_name varchar(255),
                 i_status int default 0,
                 i_current_owner_id int default null,
                 primary key(i_id),
                 foreign key (i_current_location_id) references location(i_id),
                 foreign key (i_current_owner_id) references user(i_id));

create table reservation(i_id int not null auto_increment,
                         d_pickup_date date,
                         d_return_date date,
                         i_pickup_location_id int default null,
                         i_return_location_id int default null,
                         i_user_id int default null,
                         i_car_id int default null,
                         primary key(i_id),
                         foreign key(i_user_id) references user(i_id),
                         foreign key(i_car_id) references car(i_id),
                         foreign key(i_pickup_location_id) references location(i_id),
                         foreign key(i_return_location_id) references location(i_id));

-------------------------------------------- inserts --------------------------------------------

insert into location(s_address) values
                       ('balatovo'),
                       ('kompross'),
                       ('zakamsk');


insert into car(i_current_location_id, s_name, i_status) values
                (1, 'audi', 0),
                (2, 'bike', 0),
                (3, 'catafalc', 0),
                (1, 'onefour', 0),
                (2, 'tank', 0),
                (3, 'tsoi', 0);

/*
create table role(i_id int not null auto_increment,
                  s_role_name varchar(255),
                  primary key(i_id));

create table user_role(i_user_id int not null,
                       i_role_id int not null);

insert into role(name) values ("USER"), ("ADMIN");

insert into */
