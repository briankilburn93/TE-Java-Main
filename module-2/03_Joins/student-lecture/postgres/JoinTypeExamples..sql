--Table_One LEFT / Table_Two RIGHT

-- list LEFT INNER/OUTER / RIGHT INNER/INNER

-- INNER JOIN is default
-- PART THAT'S LIKE (INNER) ONLY
SELECT one.number AS one_number, one.description AS one_description, two.number AS two_number, two.description AS two_description
FROM one
JOIN two ON one.number = two.number;

--same as (shows inner is default)


--LEFT JOIN (Left outer join)


--RIGHT JOIN (right outer join)


--FULL OUTER JOIN (full outer join)


--NOT NAMED (no longer named and not used often)
-- can filter in left/right join to leverage data 

--only entries in left table (which students don't have classes)


-- could do this by swaping one for two above


--ALL DATA NOT LIKE (LEFT or RIGHT)


--THERE ARE MORE THAT ARE LESS COMMON
---MOST OFTEN INNER and OCCASIONALLY LEFT OUTER






