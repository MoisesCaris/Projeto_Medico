CREATE TABLE doctor
(
    id        BINARY(16)         NOT NULL,
    crm       VARCHAR(255) NOT NULL,
    specialty VARCHAR(255) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);
ALTER TABLE doctor
    ADD CONSTRAINT uk_crm UNIQUE (crm);