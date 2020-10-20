-- Create a database
CREATE DATABASE dblecture;
-- Drop a database
DROP DATABASE dblecture;
-- Create table
CREATE TABLE example_table (
        id              SERIAL PRIMARY KEY,
        username        VARCHAR(100) NOT NULL,
        first_name      VARCHAR(20),
        last_name       VARCHAR(20),
        address_id      INTEGER
);
-- Drop Table/Drop Table If It Exists
DROP TABLE IF EXISTS example_table;
-- Alter a table (constraints, structure)

-- Add a primary key
ALTER TABLE example_table ADD CONSTRAINT pk_example_table_id PRIMARY KEY (id);
-- Add a foreign key
CREATE TABLE address (
        address_id      SERIAL PRIMARY KEY
);
ALTER TABLE example_table ADD CONSTRAINT fk_example_table_address_id FOREIGN KEY (address_id) REFERENCES address(address_id);
--Add unique constraint
ALTER TABLE example_table ADD CONSTRAINT unique_example_table_username UNIQUE (username);
-- Add a check
ALTER TABLE example_table ADD CONSTRAINT check_example_table_username CHECK (username != 'test');
-- Sequences

-- Sequence created via serial

-- Sequence created manually
CREATE SEQUENCE sequence_name START 100 INCREMENT BY 3;
-- Getting next seaquence value
SELECT nextval('sequence_name');
-- Inserting using sequences
--alter sequence -- added manually for test
--ALTER SEQUENCE example_table_id_sequence FUCKING SOMETHING BUT I DONT KNOW BECAUSE I CANT SEE IT ANYMORE;
-- 1 using select nextval
INSERT INTO example_table VALUES ((SELECT nextval('sequence_name')), 'nocolumnuser', 'No', 'Column', NULL);

INSERT INTO example_table VALUES ((SELECT nextval('sequence_name')), 'nocolumnuser2', 'No', 'ColumnTwo', NULL);

SELECT * FROM example_table;

-- 2 using DEFAULT
INSERT INTO example_table VALUES (DEFAULT, 'defaultnuser', 'Example', 'Default', NULL);

SELECT * FROM example_table;
-- 3 omitting id field
INSERT INTO example_table (username, first_name, last_name) VALUES ('omituser', 'Example2', 'Omit');

SELECT * FROM example_table;
-- You can insert ids manually but that should be avoided if you are using sequences. Here's why:
ALTER SEQUENCE example_table_id_sequence RESTART 12;
SELECT * FROM example_table;
INSERT INTO example_table VALUES (11, 'manualsequence2', 'Example', NULL);
-- Insert a row using hardcoded id after last id value

-- Now Insert using the sequence... what happens?

-- How do you resolve this?


-- Sequences and rollbacks
SELECT * FROM example_table;

START TRANSACTION
INSERT INTO example_table(username, first_name, last_name) VALUES ('transact', 'exam', 'tansact');
ROLLBACK --long story short, if you rollback, the next sequence will still go up. So if the insert into sequence id was 3, ytou rollback, and then insert again, it'll be at 4, not back to 3
