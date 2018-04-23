create table car(i_id int not null auto_increment,
                  s_name varchar(255),
                  i_status int default 0,
                  primary key(i_id));

insert into car(s_name, i_status) values
                ('audi', 0),
                ('bike', 0),
                ('catafalc', 0),
                ('onefour', 0),
                ('tank', 0),
                ('tsoi', 0);

create table user(i_id int not null auto_increment,
                   s_first_name varchar(255),
                   s_last_name varchar(255),
                   s_password varchar(255),
                   s_role varchar(255),
                   primary key(i_id));

/*
create table role(i_id int not null auto_increment,
                  s_role_name varchar(255),
                  primary key(i_id));

create table user_role(i_user_id int not null,
                       i_role_id int not null);

insert into role(name) values ("USER"), ("ADMIN");

insert into */
