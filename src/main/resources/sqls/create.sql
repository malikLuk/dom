create table car(i_id int not null auto_increment,
                 s_name varchar(255),
                 i_status int default 0,
                 i_id_renter int default null,
                 i_id_geo_point int not null,
                 primary key(i_id),
                 foreign key (i_id_renter) references user(i_id),
                 foreign key (i_id_geo_point) references geo_points(i_id));

insert into car(s_name, i_status, i_id_geo_point) values
                ('audi', 0, 1),
                ('bike', 0, 2),
                ('catafalc', 0, 3),
                ('onefour', 0, 1),
                ('tank', 0, 2),
                ('tsoi', 0, 3);

create table user(i_id int not null auto_increment,
                  s_first_name varchar(255),
                  s_last_name varchar(255),
                  s_password varchar(255),
                  s_role varchar(255),
                  primary key(i_id));

create table geo_points(i_id int not null auto_increment,
                        s_name varchar(255),
                        primary key(i_id));

insert into geo_points(i_id, s_name) values
                       (1, 'balatovo'),
                       (2, 'kompross'),
                       (3, 'zakamsk');


/*
create table role(i_id int not null auto_increment,
                  s_role_name varchar(255),
                  primary key(i_id));

create table user_role(i_user_id int not null,
                       i_role_id int not null);

insert into role(name) values ("USER"), ("ADMIN");

insert into */
