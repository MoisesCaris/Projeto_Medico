create table exam
(
    id binary(16) not null ,
    realization_date datetime not null ,
    result varchar(255) not null,
    exam_tyoe varchar(255) not null,
    pacient_id binary(16) not null references pacient(id),
    consultation_id binary(16) not null references consultation(id),
    created  datetime NULL,
    CONSTRAINT `PRIMARY` primary key (id)
);