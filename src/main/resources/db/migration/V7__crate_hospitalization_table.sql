create table hospitalization
(
    id binary(16) not null ,
    hospitalization_date datetime not null ,
    hospitalization_exit datetime null,
    reaseon_hospitalization varchar(255) not null,
    pacient_id binary(16) not null references pacient(id),
    created  datetime NULL,
    CONSTRAINT `PRIMARY` primary key (id)
);