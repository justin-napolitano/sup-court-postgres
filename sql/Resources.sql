-- Resources.sql
CREATE TABLE IF NOT EXISTS Resources (
    id SERIAL PRIMARY KEY,
    external_id VARCHAR(255) UNIQUE NOT NULL,
    image VARCHAR(255),
    pdf VARCHAR(255)
);

