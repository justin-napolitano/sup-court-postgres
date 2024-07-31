-- CallNumbers.sql
CREATE TABLE IF NOT EXISTS CallNumbers (
    id SERIAL PRIMARY KEY,
    external_id VARCHAR(255) UNIQUE NOT NULL,
    call_number VARCHAR(255) NOT NULL
);

