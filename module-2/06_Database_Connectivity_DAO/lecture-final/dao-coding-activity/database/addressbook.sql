CREATE TABLE contact (

        id serial primary key,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        phone varchar(25),
        email varchar(255),
        birthyear integer

);

INSERT INTO contact VALUES (DEFAULT, 'Molly', 'McButter', '215-555-1212', 'mmcb215@gmail.com', 1970);