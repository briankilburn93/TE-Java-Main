CREATE TABLE birthday_entry (
        id serial primary key,
        name varchar(255) not null,
        birth_day integer not null,
        birth_month integer not null,    
        birth_year integer not null,
        notes varchar(255)
);

INSERT INTO birthday_entry VALUES (DEFAULT, 'Molly McButter', 2, 12, 1970, 'Mom''s sister');
INSERT INTO birthday_entry VALUES (DEFAULT, 'Bert Johnson', 12, 31, 1995, null);