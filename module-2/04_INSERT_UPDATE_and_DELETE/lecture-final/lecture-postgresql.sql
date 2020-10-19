-- INSERT 

-- 1. Add Klingon as a spoken language in the USA
INSERT INTO countrylanguage (countrycode, isofficial, percentage, language) VALUES ('USA', false, .05, 'Klingon');

SELECT * FROM countrylanguage WHERE language='Klingon';

-- 2. Add Klingon as a spoken language in Great Britain
INSERT INTO countrylanguage VALUES ('GBR', 'Klingon', false, .08);

-- UPDATE

-- 1. Update the capital of the USA to Houston

-- 3813

SELECT * FROM city
WHERE id = 3813; 

SELECT * FROM city
WHERE name = 'Houston'; 
--3796

UPDATE country SET capital = 3796 WHERE 
code = 'USA';



-- 2. Update the capital of the USA to Washington DC and the head of state
SELECT id FROM city WHERE name = 'Washington';

SELECT * FROM country WHERE code = 'USA';

UPDATE country SET capital = (SELECT id FROM city WHERE name = 'Washington'),
headofstate = 'Barney' WHERE 
code = 'USA';


-- DELETE

SELECT * FROM countrylanguage WHERE
countrycode = 'GBR' AND language='English';

-- 1. Delete English as a spoken language in the USA
DELETE FROM countrylanguage WHERE
countrycode = 'USA' AND language='English';

-- 2. Delete all occurrences of the Klingon language
SELECT * FROM  countrylanguage WHERE
language='Klingon';

DELETE FROM countrylanguage WHERE
language='Klingon';


-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.
insert INTO countrylanguage VALUES ('USA', 'Elvish', false, .02);

SELECT * FROM countrylanguage WHERE language='Elvish';

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
insert INTO countrylanguage VALUES ('ZZZ', 'English', false, .02);

-- 3. Try deleting the country USA. What happens?
DELETE FROM country WHERE code='USA';


-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA
INSERT INTO countrylanguage VALUES ('USA', 'English', false, .70);

-- 2. Try again. What happens?
INSERT INTO countrylanguage VALUES ('USA', 'English', false, .70);

-- 3. Let's relocate the USA to the continent - 'Outer Space'
UPDATE country SET continent='Outer Space' WHERE code = 'USA';


-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.
START TRANSACTION;
SELECT * FROM countrylanguage;
DELETE FROM countrylanguage;
ROLLBACK;

-- 2. Try updating all of the cities to be in the USA and roll it back
START TRANSACTION;
UPDATE city SET countrycode='GBR';
ROLLBACK; -- OR COMMIT

SELECT * FROM city;


-- 3. Try updating a language (Elvish should work) and commit

-- 4. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.





--Random Tests

SELECT * FROM country WHERE capital IS (SELECT id FROM city WHERE id IS (SELECT id FROM city WHERE name ='Washington'));--can't do SELECT in a SELECT (I think)

START TRANSACTION
UPDATE countrylanguage SET language='Jibberish' WHERE language='English';
SELECT * from countrylanguage WHERE language='Jibberish';
SELECT * from countrylanguage;
ROLLBACK

-- For DELETE, do NOT forget the WHERE clause