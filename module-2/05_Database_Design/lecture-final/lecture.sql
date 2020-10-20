-- start fresh by recreating the db
DROP DATABASE IF EXISTS ddlexamples;
-- other form
-- DROP DATABASE ddlexamples;

-- Create a database
CREATE DATABASE ddlexamples;


-- Create table

CREATE TABLE example_table (
        id              SERIAL,
        -- id   SERIAL PRIMARY KEY, you could do this but we will add the primary key constaint manually
        username        VARCHAR(100) NOT NULL,
        first_name      VARCHAR(20),
        last_name       VARCHAR(20),
        address_id      INTEGER   
);

-- this is just a dummy table we will use to create a foreign key constraint
CREATE TABLE address (
        address_id      SERIAL PRIMARY KEY
);

-- Alter a table (constraints, structure)

-- Add a primary key
ALTER TABLE example_table ADD CONSTRAINT pk_example_table_id PRIMARY KEY (id);

-- Add a foreign key
ALTER TABLE example_table ADD CONSTRAINT fk_example_table_address_id FOREIGN KEY (address_id) REFERENCES address(address_id);

-- Add unique constraint
ALTER TABLE example_table ADD CONSTRAINT uniq_example_table_username UNIQUE(username);

-- Add a check  constraint

ALTER TABLE example_table ADD CONSTRAINT chk_example_table_username CHECK (username != 'test');

-- Sequences

-- Sequence created via serial

-- Sequence created manually
CREATE SEQUENCE custom_seq START 100 INCREMENT BY 1;

-- Getting next seaquence value
SELECT nextval('custom_seq');

--alter sequence

-- could change 1 to a number other than 1 if you wanted to.. this is just for an example
ALTER SEQUENCE example_table_id_seq RESTART 1;

-- Inserting using sequences

-- 1 using select nextval
INSERT INTO example_table VALUES ( (SELECT nextval('example_table_id_seq')) , 'nocolumnuser', 'No', 'Column', NULL);

SELECT * FROM example_table;

INSERT INTO example_table VALUES ( (SELECT nextval('example_table_id_seq')) , 'nocolumnuser2', 'No', 'ColumnTwo', NULL);

-- 2 using DEFAULT
INSERT INTO example_table VALUES ( DEFAULT , 'dwfaultsequser', 'Example', 'Default', NULL);

SELECT * FROM example_table;

-- 3 omitting id field

INSERT INTO example_table (username, first_name, last_name) VALUES ('omituser', 'Example', 'Omit');

-- should fail due to check constraint
INSERT INTO example_table (username, first_name, last_name) VALUES ('test', 'Example', 'Omit');

-- You can insert ids manually but that should be avoided if you are using sequences. Here's why:


-- Insert a row using hardcoded id after last id value
INSERT INTO example_table VALUES ( 6 , 'manualsequser1', 'Example', 'Manual1', NULL);

-- Now Insert using the sequence... what happens?
-- will fail when sequence matches value you already inserted (6)
INSERT INTO example_table (username, first_name, last_name) VALUES ('collisionuser', 'Example', 'Collison');

-- if you try agian though, the sequence will advance again and it should work
INSERT INTO example_table (username, first_name, last_name) VALUES ('collisionuser', 'Example', 'Collison');

SELECT * FROM example_table;


-- Sequences and rollbacks
START TRANSACTION;
INSERT INTO example_table (username, first_name, last_name) VALUES ('transactionuser', 'Example', 'Transaction');
ROLLBACK;
-- sequence doesn't oll back even though table data does
SELECT * FROM example_table;



