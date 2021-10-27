CREATE TABLE account (
    id BIGSERIAL NOT NULL,
    document_number VARCHAR(14),
    CONSTRAINT pk_account PRIMARY KEY(id)
);

CREATE TABLE operation_type (
    id BIGINT NOT NULL,
    description VARCHAR(100) NOT NULL,
    CONSTRAINT pk_operation_type PRIMARY KEY(id)
);

CREATE TABLE transaction (
    id BIGSERIAL NOT NULL,
    account_id BIGINT NOT NULL,
    operation_type_id BIGINT NOT NULL,
    amount NUMERIC(19,2),
    event_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_transaction PRIMARY KEY (id),
    CONSTRAINT fk_transaction_01 FOREIGN KEY (account_id) REFERENCES account (id)
        ON UPDATE RESTRICT ON DELETE RESTRICT,
    CONSTRAINT fk_transaction_02 FOREIGN KEY (operation_type_id) REFERENCES operation_type (id)
        ON UPDATE RESTRICT ON DELETE RESTRICT
);