CREATE TABLE IF NOT EXISTS students (
    id SERIAL PRIMARY KEY,
    name varchar(20),
    email varchar(50),
    date_of_birth timestamp
    );