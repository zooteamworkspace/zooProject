-- THIS FILE WILL RE-CREATE TABLE, ONLY USE FOR DEV, EXECUTE WITH CAUTION
DROP TABLE IF EXISTS FIELD_BOOKINGS;

CREATE TABLE FIELD_BOOKINGS (
    id      SERIAL PRIMARY KEY,
    court_id INT NOT NULL,
    field_id INT NOT NULL,
    time_in  BIGINT NOT NULL,
    time_out BIGINT NOT NULL,
    status  SMALLINT,
    booker_user_id  INT,
    booker_name  VARCHAR(64),
    booker_email VARCHAR(254),
    booker_phone VARCHAR(15),
    price_amount   NUMERIC(19,4),
    currency_id    VARCHAR(8),
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);
