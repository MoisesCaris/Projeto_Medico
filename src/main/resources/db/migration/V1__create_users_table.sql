CREATE TABLE users
(
    id       BINARY(16)   NOT NULL,
    cpf      VARCHAR(14)  NOT NULL,
    created  datetime NULL,
    email    VARCHAR(255) NOT NULL,
    fone     VARCHAR(20)  NOT NULL,
    name     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    `role`   VARCHAR(255) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uk_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uk_cpf UNIQUE (cpf);
