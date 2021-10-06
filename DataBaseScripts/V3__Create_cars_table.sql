CREATE TABLE cars(
	car_id serial PRIMARY KEY,
        driver_id INT NOT NULL,
        brand VARCHAR(50),
        number VARCHAR(10),
        number_of_places INT,
CONSTRAINT driver_id FOREIGN KEY (driver_id) REFERENCES drivers (driver_id)
)