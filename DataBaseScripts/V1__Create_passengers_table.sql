CREATE TABLE passengers(
	passenger_id serial PRIMARY KEY,
        name VARCHAR(50) NOT NULL,
        surname VARCHAR(50) NOT NULL,
	login VARCHAR(50) NOT NULL,
        password VARCHAR(50) NOT NULL,
        rating REAL
)