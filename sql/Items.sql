-- Items.sql
CREATE TABLE IF NOT EXISTS Items (
    id SERIAL PRIMARY KEY,
    callnumber VARCHAR(255) NOT NULL,
    created_published VARCHAR(255),
    date DATE,
    notes TEXT,
    source_collection VARCHAR(255),
    title VARCHAR(255) NOT NULL,
    external_id VARCHAR(255) UNIQUE NOT NULL
);

