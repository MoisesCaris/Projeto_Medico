create table consultation
(
    id binary(16) not null ,
    consultation_date datetime not null ,
    treatment_plan varchar(255) not null,
    diagnosed varchar(255) not null,
    symptoms varchar(255) not null,
    pacient_id binary(16) not null references pacient(id),
    doctor_id binary(16) not null references doctor(id),
    created  datetime NULL,
    CONSTRAINT `PRIMARY` primary key (id)
);