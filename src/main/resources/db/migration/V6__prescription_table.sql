create table prescription
(
    id binary(16) not null ,
    medicine varchar(255) not null,
    dosage varchar(255) not null ,
    pacient_id binary(16) not null references pacient(id),
    consultation_id binary(16) not null references consultation(id),
    created  datetime NULL,
    CONSTRAINT `PRIMARY` primary key (id)
);