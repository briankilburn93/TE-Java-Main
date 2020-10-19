-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
START TRANSACTION
SELECT * FROM actor;
INSERT INTO actor (first_name, last_name)
VALUES ('Hampton', 'Avenue'), ('Lisa', 'Byway');

--ROLLBACK
COMMIT

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.

START TRANSACTION
INSERT INTO film (title, description, release_year, language_id, length)
VALUES ('Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198);

SELECT * FROM film WHERE title = 'Euclidean PI';

ROLLBACK
COMMIT

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
SELECT * FROM film_actor;

START TRANSACTION
INSERT INTO film_actor (actor_id, film_id) VALUES (202, 1002); --actor id 202 is Hampton Avenue, while film id 1002 is Euclidean PI
INSERT INTO film_actor (actor_id, film_id) VALUES (203, 1002); --actor id 203 is Lisa Byway, while film id 1002 is Euclidean PI

SELECT * FROM film_actor WHERE film_id = 1002;

ROLLBACK
COMMIT

-- 4. Add Mathmagical to the category table.
SELECT * FROM category;

START TRANSACTION
INSERT INTO category (name) VALUES ('Mathmagical');

ROLLBACK
COMMIT

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
SELECT * FROM film_category WHERE category_id = 17;

START TRANSACTION
UPDATE film_category SET category_id = 17 WHERE film_id IN (274, 494, 714, 996);
INSERT INTO film_category VALUES (1002, 17);

ROLLBACK
COMMIT

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
SELECT rating FROM film WHERE film_id IN (SELECT film.film_id FROM film JOIN film_category ON film.film_id= film_category.film_id WHERE film_category.category_id= 17);

START TRANSACTION
UPDATE film SET rating='G' WHERE film_id IN (SELECT film.film_id FROM film JOIN film_category ON film.film_id= film_category.film_id WHERE film_category.category_id= 17);

ROLLBACK
COMMIT

-- 7. Add a copy of "Euclidean PI" to all the stores.
SELECT * FROM inventory WHERE film_id = 1002;

START TRANSACTION
INSERT INTO inventory VALUES(4582, 1002, 1);
INSERT INTO inventory VALUES(4583, 1002, 2);

ROLLBACK
COMMIT

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <No. It's referenced in the table film_actor and thus can't be deleted until it's deleted from that table>
SELECT * FROM film WHERE title = 'Euclidean PI';

START TRANSACTION
DELETE FROM film WHERE title = 'Euclidean PI';

ROLLBACK
COMMIT

-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <No. It's still being referenced in the film_category table>
SELECT * FROM category WHERE name = 'Mathmagical';

START TRANSACTION
DELETE FROM category WHERE name = 'Mathmagical';

ROLLBACK
COMMIT

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <Yes. It doesn't take away from the primary category table, and it's at the lowest level and thus not being referenced anywhere else that needs it>
SELECT * FROM film_category WHERE category_id = 17;

START TRANSACTION
DELETE FROM film_category WHERE category_id = 17;

ROLLBACK
COMMIT

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <Mathemagical succeeded in deletion because it wasn't being referenced in film_category anymore. Euclidean PI could not be removed because it is still being referenced in film_actor>

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
--<To remove Euclidean PI, we would need to first delete it on the film_actor table, referencing film_id=1002. After that, we can delete from film>