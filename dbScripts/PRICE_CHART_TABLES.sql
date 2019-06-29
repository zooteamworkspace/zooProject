DROP TABLE  IF EXISTS PRICE_CHARTS CASCADE;
DROP TABLE  IF EXISTS FIELD_TYPES CASCADE;

CREATE TYPE "main_field_type" AS ENUM (
  'SOCCER_5',
  'SOCCER_7',
  'SOCCER_11'
);

CREATE TYPE "day_of_week" AS ENUM (
  'MON',
  'TUE',
  'WED',
  'THU',
  'FRI',
  'SAT',
  'SUN'
);

CREATE TABLE "FIELD_TYPES" (
  "id" SERIAL PRIMARY KEY,
  "main_type" "main_field_type",
  "court_id" int,
  "field_type_name" varchar(20),
  "created_at" bigint NOT NULL,
  "updated_at" bigint NOT NULL
);

COMMENT ON COLUMN "field_types"."main_type" IS 'should be index because will be looked up a lot';

COMMENT ON COLUMN "field_types"."created_at" IS 'When court created for monitor, epoch timestamp';

COMMENT ON COLUMN "field_types"."updated_at" IS 'When court updated for monitor, epoch timestamp';

CREATE TABLE "PRICE_CHARTS" (
  "id" SERIAL PRIMARY KEY,
  "field_type_id" int,
  "time_start" bigint,
  "time_end" bigint,
  "day" "day_of_week",
  "price_amount" numeric,
  "currency_id" varchar(8),
  "created_at" bigint NOT NULL,
  "updated_at" bigint NOT NULL
);

COMMENT ON COLUMN "price_charts"."field_type_id" IS 'should be index because will be looked up a lot';

COMMENT ON COLUMN "price_charts"."created_at" IS 'When court created for monitor, epoch timestamp';

COMMENT ON COLUMN "price_charts"."updated_at" IS 'When court updated for monitor, epoch timestamp';

ALTER TABLE "fields" ADD CONSTRAINT "court_to_fields" FOREIGN KEY ("court_id") REFERENCES "courts" ("id");

ALTER TABLE "fields" ADD CONSTRAINT "field_type_to_fields" FOREIGN KEY ("field_type_id") REFERENCES "field_types" ("id");

ALTER TABLE "price_charts" ADD CONSTRAINT "field_type_to_price_charts" FOREIGN KEY ("field_type_id") REFERENCES "field_types" ("id");

ALTER TABLE "field_types" ADD CONSTRAINT "court_to_field_types" FOREIGN KEY ("court_id") REFERENCES "courts" ("id");

GRANT ALL PRIVILEGES ON TABLE PRICE_CHART TO zoodb;
GRANT ALL PRIVILEGES ON TABLE price_chart_id_seq TO zoodb;
GRANT ALL PRIVILEGES ON TABLE FIELD_TYPES TO zoodb;
GRANT ALL PRIVILEGES ON TABLE field_type_id_seq TO zoodb;