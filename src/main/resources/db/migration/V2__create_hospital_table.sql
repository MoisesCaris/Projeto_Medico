CREATE TABLE hospital
(
    id      BINARY(16)         NOT NULL,
    address VARCHAR(255) NOT NULL,
    city    VARCHAR(255) NOT NULL,
    name    VARCHAR(255) NOT NULL,
    state   VARCHAR(255) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);
