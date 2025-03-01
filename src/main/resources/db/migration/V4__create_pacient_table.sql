create table pacient
(
    id binary(16) not null ,
    sex varchar(1) not null ,
    health_plan varchar(255) not null,
    id_user binary(16) not null references users(id),
    created  datetime NULL
    CONSTRAINT `PRIMARY` primary key (id)
);

