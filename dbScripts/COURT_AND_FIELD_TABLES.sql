DROP TABLE IF EXISTS COURTS;
DROP TABLE IF EXISTS FIELDS;
DROP TABLE IF EXISTS FIELD_TYPES;

CREATE TABLE COURTS (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20),
    address_street VARCHAR(128),
    address_ward VARCHAR(20),
    address_district VARCHAR(20),
    address_city VARCHAR(20),
    address_country VARCHAR(10),
    phone_number VARCHAR(20),
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

CREATE TABLE FIELDS (
    id SERIAL PRIMARY KEY,
    court_id INT,
    name VARCHAR(20),
    field_type_id INT,
    sub_field_ids VARCHAR(128),
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

CREATE TABLE FIELD_TYPES (
    id SERIAL PRIMARY KEY,
    main_field_type INT,
    court_id INT,
    name VARCHAR(20),
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

GRANT ALL PRIVILEGES ON TABLE COURTS TO zoodb;
GRANT ALL PRIVILEGES ON TABLE courts_id_seq TO zoodb;

GRANT ALL PRIVILEGES ON TABLE FIELDS TO zoodb;
GRANT ALL PRIVILEGES ON TABLE fields_id_seq TO zoodb;

GRANT ALL PRIVILEGES ON TABLE FIELD_TYPES TO zoodb;
GRANT ALL PRIVILEGES ON TABLE field_types_id_seq TO zoodb;
