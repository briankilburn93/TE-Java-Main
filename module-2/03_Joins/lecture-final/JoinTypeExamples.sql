--Table_One LEFT / Table_Two RIGHT

-- list LEFT INNER/OUTER / RIGHT INNER/INNER

-- INNER JOIN is default
-- PART THAT'S LIKE (INNER) ONLY
SELECT one.number AS one_number, one.description AS one_description, two.number AS two_number, two.description AS two_description
FROM one
JOIN two ON one.number = two.number;

--same as (shows inner is default)
SELECT one.number AS one_number, one.description AS one_description, two.number AS two_number, two.description AS two_description
FROM one
INNER JOIN two ON one.number = two.number;

--LEFT JOIN (Left outer join)
SELECT one.number AS one_number, one.description AS one_description, two.number AS two_number, two.description AS two_description
FROM one
LEFT JOIN two ON one.number = two.number;

--RIGHT JOIN (right outer join)
SELECT one.number AS one_number, one.description AS one_description, two.number AS two_number, two.description AS two_description
FROM one
RIGHT JOIN two ON one.number = two.number;

-- YOU COULD REVERSE THE RESULTS BY SWAPPING THE TABLES (LEFT OR RIGHT INDICATES WHICH ONE IS DRIVING THE RESULTS)
SELECT one.number AS one_number, one.description AS one_description, two.number AS two_number, two.description AS two_description
FROM two
RIGHT JOIN one ON one.number = two.number;

--FULL OUTER JOIN (full outer join)
SELECT one.number AS one_number, one.description AS one_description, two.number AS two_number, two.description AS two_description
FROM one
FULL OUTER JOIN two ON one.number = two.number;

--NOT NAMED (no longer named and not used often)
-- can filter in left/right join to leverage data 

--only entries in left table (which students don't have classes)
SELECT one.number AS one_number, one.description AS one_description, two.number AS two_number, two.description AS two_description
FROM one
LEFT JOIN two ON one.number = two.number
WHERE two.number IS NULL;

SELECT one.number AS one_number, one.description AS one_description, two.number AS two_number, two.description AS two_description
FROM one
RIGHT JOIN two ON one.number = two.number
WHERE one.number IS NULL;


-- could do this by swaping one for two above


--ALL DATA NOT LIKE (LEFT or RIGHT)
SELECT one.number AS one_number, one.description AS one_description, two.number AS two_number, two.description AS two_description
FROM one
FULL OUTER JOIN two ON one.number = two.number
WHERE one.number IS NULL OR two.number IS NULL;

--THERE ARE MORE THAT ARE LESS COMMON
---MOST OFTEN INNER and OCCASIONALLY LEFT OUTER






