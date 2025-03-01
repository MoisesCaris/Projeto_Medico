create table bill
(
    id binary(16) not null ,
    payment_date datetime not null ,
    value decimal(10,2) not null,
    status varchar(255) not null,
    pacient_id binary(16) not null references pacient(id),
    created  datetime NULL,
    CONSTRAINT `PRIMARY` primary key (id)
);