-- SELCT FROM WHERE
SELECT id, name, countrycode FROM city WHERE countrycode='AFG' 

--IN 
SELECT id, name, countrycode FROM city WHERE countrycode='AFG' OR countrycode='USA'OR countrycode='GBR';
SELECT id, name, countrycode FROM city WHERE countrycode IN ('AFG', 'USA', 'GBR');

--DISTINCT
--REMOVES duplicate results.
--This returns countrycode for all cities. For instance, this includes 275 results with USA as the countrycode.
SELECT  countrycode FROM city ORDER BY countrycode;

--DISTINCT will select only unique results, so each countrycode will be returned. In this case, USA will only appear once
SELECT DISTINCT countrycode FROM city ORDER BY countrycode;

--AS
--lets you alias a column or table. This example will alias name as city_name
SELECT id, name AS city_name, countrycode FROM city WHERE countrycode IN ('AFG', 'USA', 'GBR');

--ORDER BY
-- DEFAULT ASCENDING
SELECT id, name AS city_name, countrycode FROM city WHERE countrycode IN ('AFG', 'USA', 'GBR') ORDER BY countrycode ASC;
--OR
SELECT id, name AS city_name, countrycode FROM city WHERE countrycode IN ('AFG', 'USA', 'GBR') ORDER BY countrycode;
-- DESCENDING
SELECT id, name AS city_name, countrycode FROM city WHERE countrycode IN ('AFG', 'USA', 'GBR') ORDER BY countrycode DESC;
-- include another sort column
SELECT id, name AS city_name, countrycode FROM city WHERE countrycode IN ('AFG', 'USA', 'GBR') ORDER BY countrycode, name;
-- each order by column can have its own ASC/DESC value
SELECT id, name AS city_name, countrycode FROM city WHERE countrycode IN ('AFG', 'USA', 'GBR') ORDER BY countrycode DESC, name;
SELECT id, name AS city_name, countrycode FROM city WHERE countrycode IN ('AFG', 'USA', 'GBR') ORDER BY countrycode DESC, name DESC;
--LIMIT (postgres specific - some db might use a different keyword like TOP instead of LIMIT)
SELECT id, name AS city_name, countrycode FROM city WHERE countrycode IN ('AFG', 'USA', 'GBR') ORDER BY countrycode DESC, name DESC LIMIT 10;
--CONCATENATION
SELECT id, name || ', ' || district AS city_district, countrycode FROM city WHERE countrycode IN ('AFG', 'USA', 'GBR') ORDER BY countrycode DESC, name;
--GROUP BY
SELECT countrycode FROM city GROUP BY countrycode;
SELECT countrycode, COUNT(countrycode) FROM city GROUP BY countrycode;
--COUNT(column) for a column excludes null values while using COUNT(*) does not

--AVG (Average)
SELECT countrycode, AVG(population) FROM city GROUP BY countrycode;

--SUM (Add)
SELECT countrycode, SUM(population) FROM city GROUP BY countrycode;

--MIN/MAX
SELECT countrycode, MIN(population), MAX(population) FROM city GROUP BY countrycode;

--SUBQUERIES
SELECT continent FROM country;

--only returns one value then can use =
SELECT * FROM country WHERE capital = (SELECT id FROM city WHERE name = 'Washington');

-- subquery returns  multiple values so must use IN
SELECT name FROM city WHERE countrycode IN (SELECT code FROM country WHERE continent='Europe');

--one-to-one (1:1), 1:M (one to many), M:N (many to many)

-- lEFT table in JOIN is after FROM and Right is after JOIN

-- UNION names of countries and cities
-- must same number of columns and same data types
-- duplicates in combined data will be filtered out
SELECT name FROM country
UNION
SELECT name FROM city;

--convet to join
SELECT name FROM city WHERE countrycode IN (SELECT code FROM country WHERE continent='Europe');

SELECT city.name, country.name FROM city
JOIN country ON country.code = city.countrycode
WHERE country.continent='Europe';
-- in above exampe city would be LEFT table because it come after FROM and country would be RIGHT table because it comes after JOIN

--TRANSACTION allows you roll back data if something goes wrong. 
--You MUST start a transaction by running START TRANSACTION if you want this
-- functionality
START TRANSACTION;

-- insert take a list of columns (can be ina any order) and the list of vlues to insert into those columns (value ordwe must match column order)
INSERT INTO city (countrycode, name, district, population) VALUES ('USA', 'NowhereUsa', 'Ohio', 20000);
-- without column names... requires values for ALL columnbs in correct order. SQL will let you omit the xolumns section but will assume
-- that the values you are passing are for all the rows in the order they appear in the table
INSERT INTO countrylanguage VALUES ('USA', 'Kilngon', false, .02);
COMMIT; -- COMMIT will end the Transaction and save data
--ROLLBACK; If you wanted to NOT save the data and go back to the state prior to transaction

SELECT * FROM city WHERE name = 'NowhereUsa';

-- make sure to remember the WHERE clause!!!!
UPDATE countrylanguage SET language='Jibberish' WHERE language='Kilngon';
SELECT * from countrylanguage WHERE language='Jibberish';

SELECT * from countrylanguage WHERE language='Kilngon';

--can update multiple columns at once
UPDATE countrylanguage SET language='Babble', countrycode='GBR' WHERE language='Jibberish';
SELECT * from countrylanguage WHERE language='Babble';

--DELETE
-- DON'T FORGET THE WHERE CLAUSE
SELECT * from countrylanguage WHERE language='Babble';
DELETE from countrylanguage WHERE language='Babble';

-- Related to Exercise #7 on yesterday's assignment:

START TRANSACTION;

-- Because we juse SELECT instead of VALUES in INSERT, the SELECT will be run and all results inserted into table
-- Your title might not match (case matter so use whatever case you used)
INSERT INTO inventory(film_id, store_id) SELECT (SELECT film_id FROM film WHERE title='Euclidean PI'), store_id FROM store;

-- Use this to verify it worked
SELECT s.store_id, i.inventory_id, f.film_id, f.title FROM store s
JOIN inventory i ON i.store_id = s.store_id
JOIN film f ON f.film_id = i.film_id 
WHERE f.title='Euclidean PI'; -- Your title might not match (case matter so use whatever case you used)

ROLLBACK; -- change this to COMMIT to make this permanent


