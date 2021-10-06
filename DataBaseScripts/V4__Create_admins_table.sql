CREATE TABLE admins(
	admin_id serial PRIMARY KEY,
        name VARCHAR(50) NOT NULL,
        rating REAL,
        qualification VARCHAR(50)
)