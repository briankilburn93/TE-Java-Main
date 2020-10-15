-- ********* INNER JOIN ***********

-- Let's find out who made payment 16666:
SELECT * FROM payment WHERE payment_id=16666;

-- Ok, that gives us a customer_id, but not the name. We can use the customer_id to get the name FROM the customer table
SELECT * FROM payment 
JOIN customer ON customer.customer_id = payment.customer_id
WHERE payment_id=16666;

-- We can see that the * pulls back everything from both tables. We just want everything from payment and then the first and last name of the customer:
SELECT payment.*, customer.first_name, customer.last_name FROM payment 
JOIN customer ON customer.customer_id = payment.customer_id
WHERE payment_id=16666;

-- USING ALIAS
SELECT p.*, c.first_name, c.last_name FROM payment p
JOIN customer  c ON c.customer_id = p.customer_id
WHERE payment_id=16666;

-- But when did they return the rental? Where would that data come from? From the rental table, so let's join that.
SELECT p.*, c.first_name, c.last_name, r.return_date FROM payment p
JOIN customer  c ON c.customer_id = p.customer_id
JOIN rental r ON r.rental_id = p.rental_id
WHERE payment_id=16666;

-- ALERNATE PATH (causes duplicates - due to bad data... multiple dates for 1 payment)
SELECT p.*, c.first_name, c.last_name, r.return_date FROM payment p
JOIN customer  c ON c.customer_id = p.customer_id
JOIN rental r ON r.customer_id = c.customer_id
WHERE payment_id=16666;

-- What did they rent? Film id can be gotten through inventory.
SELECT p.*, c.first_name, c.last_name, f.title, r.return_date FROM payment p
JOIN customer  c ON c.customer_id = p.customer_id
JOIN rental r ON r.rental_id = p.rental_id
JOIN inventory i ON i.inventory_id = r.inventory_id
JOIN film f ON f.film_id = i.film_id
WHERE payment_id=16666;

-- What if we wanted to know who acted in that film?
SELECT p.*, c.first_name, c.last_name, f.title, r.return_date, a.first_name, a.last_name FROM payment p
JOIN customer  c ON c.customer_id = p.customer_id
JOIN rental r ON r.rental_id = p.rental_id
JOIN inventory i ON i.inventory_id = r.inventory_id
JOIN film f ON f.film_id = i.film_id
JOIN film_actor fa ON f.film_id = fa.film_id
JOIN actor a ON fa.actor_id = a.actor_id
WHERE payment_id=16666;

-- check why this works
SELECT p.*, c.first_name, c.last_name, f.title, r.return_date, a.first_name, a.last_name FROM payment p
JOIN customer  c ON c.customer_id = p.customer_id
JOIN rental r ON r.rental_id = p.rental_id
JOIN inventory i ON i.inventory_id = r.inventory_id
JOIN film f ON f.film_id = i.film_id
--JOIN film_actor fa ON f.film_id = fa.film_id
JOIN film_actor fa ON i.film_id = fa.film_id
JOIN actor a ON fa.actor_id = a.actor_id
WHERE payment_id=16666;

-- What if we wanted a list of all the films and their categories ordered by film title
SELECT f.film_id, f.title, c.category_id, c.name FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
ORDER BY title;

-- Show all the 'Comedy' films ordered by film title
SELECT f.film_id, f.title, c.category_id, c.name FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
WHERE c.name = 'Comedy'
ORDER BY title;

-- Finally, let's count the number of films under each category
SELECT  COUNT(f.title), c.name FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
GROUP BY  c.name
ORDER BY c.name;

-- ********* LEFT JOIN ***********

-- (There aren't any great examples of left joins in the "dvdstore" database, so the following queries are for the "world" database)

-- A Left join, selects all records from the "left" table and matches them with records from the "right" table if a matching record exists.

-- Let's display a list of all countries and their capitals, if they have some.
SELECT country.name, city.name FROM country
JOIN city ON city.id = country.capital

-- Only 232 rows
-- But we're missing entries:

-- There are 239 countries. So how do we show them all even if they don't have a capital?
-- That's because if the rows don't exist in both tables, we won't show any information for it. If we want to show data FROM the left side table everytime, we can use a different join:
SELECT country.name, city.name FROM country
LEFT JOIN city ON city.id = country.capital


--extra example
SELECT countrylanguage.language, country.name FROM countrylanguage
JOIN country ON country.code = countrylanguage.countrycode;
-- *********** UNION *************

-- Back to the "dvdstore" database...

-- Gathers a list of all first names used by actors and customers
-- By default removes duplicates
SELECT first_name FROM actor
UNION
SELECT first_name FROM customer;

-- Gather the list, but this time note the source table with 'A' for actor and 'C' for customer
SELECT first_name, 'A' AS source FROM actor
UNION
SELECT first_name, 'C' AS source FROM customer
WHERE first_name LIKE 'E%';