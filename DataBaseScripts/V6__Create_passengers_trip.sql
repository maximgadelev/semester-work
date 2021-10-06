CREATE TABLE passengers_trip(
	passenger_id INT NOT NULL,
	trip_id INT NOT NULL,
	CONSTRAINT passenger_id  FOREIGN KEY (passenger_id) REFERENCES passengers  (passenger_id),
	CONSTRAINT trip_id FOREIGN KEY (trip_id) REFERENCES trips (trip_id)
	
)