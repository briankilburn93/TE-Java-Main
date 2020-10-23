DROP TABLE IF EXISTS contact;

CREATE TABLE contact (

        id integer primary key,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        phone varchar(25),
        email varchar(255),
        birthyear integer

);

CREATE SEQUENCE seq_contact_id OWNED BY contact.id;

INSERT INTO contact VALUES ( (SELECT nextval('seq_contact_id')), 'Molly', 'McButter', '215-555-1212', 'mmcb215@gmail.com', 1970);