CREATE TABLE trips(
	trip_id serial PRIMARY KEY,
        admin_id INT NOT NULL,
        car_id INT NOT NULL,
        date VARCHAR(15),
        price INT,
        path VARCHAR(50),
CONSTRAINT admin_id FOREIGN KEY (admin_id) REFERENCES admins (admin_id),
CONSTRAINT car_id FOREIGN KEY (car_id) REFERENCES cars (car_id)
)