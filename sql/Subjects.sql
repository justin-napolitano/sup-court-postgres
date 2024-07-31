-- subjects.sql
CREATE TABLE Subjects (
    id SERIAL PRIMARY KEY,
    external_id VARCHAR(255) NOT NULL,
    subject TEXT NOT NULL,
    CONSTRAINT subjects_external_id_subject_key UNIQUE (external_id, subject)
);

