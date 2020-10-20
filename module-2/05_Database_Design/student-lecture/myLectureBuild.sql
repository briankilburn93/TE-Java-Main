CREATE TABLE customer(
customer_id SERIAL PRIMARY KEY,
first_name VARCHAR(20), 
last_name VARCHAR(20), 
first_name VARCHAR(30), 
address VARCHAR(100),
phone_number VARCHAR(20)
);

CREATE TABLE purchase(
purchase_id SERIAL PRIMARY KEY,
artist_id INTEGER,
painting_id INTEGER,
date_of_purchase date NOT NULL, --could do: date_of_purchase TIMESTAMP NOT NULL
price INTEGER, 
CONSTRAINT fk_purchase_artist_id FOREIGN KEY(artist_id) REFERENCES artist(artist_id),
CONSTRAINT fk_purchase_painting_id FOREIGN KEY(painting_id) REFERENCES painting(painting_id)
);

CREATE TABLE customer_purchase(
customer_id INTEGER,
purchase_id INTEGER,
CONSTRAINT pk_customer_purchase PRIMARY KEY(customer_id, purchase_id)
);