create type posting_type as enum ('PIX', 'TED', 'DOC', 'SALARY', 'BANK_SLIP');

create table posting (
    id varchar(200) not null,
    client_id varchar(200) not null,
    description text,
    p_value numeric(20, 2) not null,
    p_type posting_type not null,
    p_timestamp timestamp without time zone not null,
    constraint posting_pkey primary key (client_id, p_type, p_timestamp)
);