create table client (
    id varchar(200) primary key,
    email varchar(200) not null,
    full_name varchar(200) not null,
    date_of_bith date
);