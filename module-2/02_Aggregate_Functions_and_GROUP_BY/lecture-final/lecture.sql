-- ORDERING RESULTS

-- Populations of all countries in descending order
SELECT name, population FROM country ORDER BY population DESC;

--Names of countries and continents in ascending order
SELECT name, continent FROM country ORDER BY continent, name;

-- LIMITING RESULTS
-- The name and  life expectancy of the countries with the 10 highest life expectancies.
SELECT name, lifeexpectancy FROM country WHERE lifeexpectancy IS NOT NULL 
ORDER BY lifeexpectancy DESC LIMIT 10;

-- CONCATENATING OUTPUTS

-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city

-- we are also aliasing the concatenated column so it is more readable
SELECT name || ', ' || district AS city_and_state FROM city WHERE district = 'California' OR district = 'Oregon' OR district = 'Washington'
ORDER BY district, city;

--using IN
SELECT name || ', ' || district AS city_and_state FROM city WHERE district IN ('California', 'Oregon', 'Washington')
ORDER BY district, name;

-- subqueries
SELECT name, countrycode FROM city WHERE countrycode IN
(SELECT code FROM country WHERE continent='Europe');

-- note that since the subquery returns multiple results the query below will
-- cause an error since you can only compare one value using =
SELECT name, countrycode FROM city WHERE countrycode =
(SELECT code FROM country WHERE continent='Europe');

-- AGGREGATE FUNCTIONS
-- Average Life Expectancy in the World
SELECT MAX(lifeexpectancy) FROM country;

-- Total population in Ohio
SELECT SUM(population) FROM city WHERE district='Ohio';

-- The surface area of the smallest country in the world
SELECT MIN(surfacearea) FROM country;

-- The 10 largest countries in the world
SELECT name FROM country ORDER BY surfacearea DESC LIMIT 10;

-- The number of countries who declared independence in 1991
SELECT COUNT(*) FROM country WHERE indepyear=1991;

-- GROUP BY
-- Count the number of countries where each language is spoken, ordered from most countries to least
SELECT language, COUNT(countrycode) FROM countrylanguage GROUP BY language ORDER BY COUNT(countrycode) DESC;

-- Average life expectancy of each continent ordered from highest to lowest
SELECT continent, AVG(lifeexpectancy) FROM country
GROUP BY continent ORDER BY AVG(lifeexpectancy) DESC;

-- Exclude Antarctica from consideration for average life expectancy
SELECT continent, AVG(lifeexpectancy) FROM country
WHERE lifeexpectancy IS NOT NULL
GROUP BY continent ORDER BY AVG(lifeexpectancy) DESC;

-- Sum of the population of cities in each state in the USA ordered by state name
SELECT district AS State, SUM(population) FROM city
WHERE countrycode='USA' GROUP BY State ORDER BY State DESC;

-- The average population of cities in each state in the USA ordered by state name
SELECT district AS State, AVG(population) FROM city
WHERE countrycode='USA' GROUP BY State ORDER BY State;

-- SUBQUERIES
-- Find the names of cities under a given government leader

-- with one result in subquery
SELECT name FROM city WHERE countrycode =
(SELECT code FROM country WHERE headofstate='Heydär Äliyev');

-- with multiple results in subquery
SELECT name FROM city WHERE countrycode IN 
(SELECT code FROM country WHERE headofstate='Beatrix');


-- Find the names of cities whose country they belong to has not declared independence yet
SELECT name, (SELECT indepyear FROM country ctry WHERE code = countrycode) FROM city cty
WHERE countrycode IN (SELECT code FROM country WHERE indepyear IS NULL);

-- Additional samples
-- You may alias column and table names to be more descriptive

-- Alias can also be used to create shorthand references, such as "c" for city and "co" for country.

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)

-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip

-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. Only returns a single row of value(s) unless used with GROUP BY.

-- Counts the number of rows in the city table

-- Also counts the number of rows in the city table

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.

-- Gets the MIN population and the MAX population from the city table.

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.
