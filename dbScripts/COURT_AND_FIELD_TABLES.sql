DROP TABLE IF EXISTS COURTS;
DROP TABLE IF EXISTS FIELDS;

CREATE TABLE COURTS (
    id SERIAL PRIMARY KEY,
    court_name  VARCHAR(20),
    court_address VARCHAR(256),
    court_phone VARCHAR(20),
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

CREATE TABLE FIELDS (
    id SERIAL PRIMARY KEY,
    court_id INT,
    field_name VARCHAR(20),
    field_type VARCHAR(20),
    sub_field_ids VARCHAR(128),
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

GRANT ALL PRIVILEGES ON TABLE COURTS TO zoodb;
GRANT ALL PRIVILEGES ON TABLE courts_id_seq TO zoodb;

GRANT ALL PRIVILEGES ON TABLE FIELDS TO zoodb;
GRANT ALL PRIVILEGES ON TABLE fields_id_seq TO zoodb;
