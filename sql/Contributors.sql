-- Contributors.sql
CREATE TABLE IF NOT EXISTS Contributors (
    id SERIAL PRIMARY KEY,
    external_id VARCHAR(255) UNIQUE NOT NULL,
    contributor VARCHAR(255) NOT NULL
);

