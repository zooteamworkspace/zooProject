DROP TABLE IF EXISTS COURTS;
DROP TABLE IF EXISTS COURT_CLAIM_OTPS;
DROP TABLE IF EXISTS COURT_USER_ROLES;
DROP TABLE IF EXISTS FIELDS;
DROP TABLE IF EXISTS FIELD_TYPES;
DROP TABLE IF EXISTS PRICE_CHARTS;

CREATE TABLE COURTS (
    id SERIAL PRIMARY KEY,
    court_name VARCHAR(20),
    address_street VARCHAR(128),
    address_ward VARCHAR(20),
    address_district VARCHAR(20),
    address_city VARCHAR(20),
    address_country VARCHAR(10),
    phone_number VARCHAR(20),
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

CREATE TABLE COURT_CLAIM_OTPS (
    court_id INT PRIMARY KEY,
    claim_key VARCHAR(32) UNIQUE,
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

CREATE TABLE COURT_USER_ROLES (
    uid VARCHAR(128),
    court_id INT,
    court_role INT,
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL,
    PRIMARY KEY(uid, court_id)
);

CREATE INDEX COURT_USER_ROLES_UID ON COURT_USER_ROLES(uid);
CREATE INDEX COURT_USER_ROLES_COURT_ID ON COURT_USER_ROLES(court_id);

CREATE TABLE FIELDS (
    id SERIAL PRIMARY KEY,
    court_id INT,
    field_name VARCHAR(20),
    main_field_type INT,
    field_type_id INT,
    sub_field_ids VARCHAR(128),
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

CREATE INDEX IX_FIELDS_COURT_ID ON FIELDS(court_id);
CREATE INDEX IX_FIELDS_FIELD_TYPE_ID ON FIELDS(field_type_id);
CREATE INDEX IX_FIELDS_MAIN_FIELD_TYPE ON FIELDS(main_field_type);

CREATE TABLE FIELD_TYPES (
    id SERIAL PRIMARY KEY,
    court_id INT,
    field_type_name VARCHAR(20),
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

CREATE INDEX IX_FIELD_TYPES_COURT_ID ON FIELD_TYPES(court_id);

CREATE TABLE PRICE_CHARTS (
    id SERIAL PRIMARY KEY,
    field_type_id INT,
    time_start INT,
    time_end INT,
    price_amount   NUMERIC(19,4),
    currency_id    VARCHAR(8),
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

CREATE INDEX IX_PRICE_CHARTS_FIELD_TYPE_ID ON PRICE_CHARTS(field_type_id);



