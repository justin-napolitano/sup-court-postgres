---
slug: github-sup-court-postgres
title: Automating PostgreSQL Setup for Supreme Court Data with Java and Maven
repo: justin-napolitano/sup-court-postgres
githubUrl: https://github.com/justin-napolitano/sup-court-postgres
generatedAt: '2025-11-23T09:41:18.440982Z'
source: github-auto
summary: >-
  Defines a PostgreSQL schema for Supreme Court jurisprudence and automates database creation using
  Java, Maven, Docker, and SQL scripts.
tags:
  - postgresql
  - java
  - maven
  - docker
  - legal-data
  - database-automation
seoPrimaryKeyword: postgresql database setup
seoSecondaryKeywords:
  - java automation
  - supreme court data
  - docker compose
  - sql schema
seoOptimized: true
---

# Setting Up a PostgreSQL Database for Supreme Court Data Using Java and Maven

## Motivation

This project aims to establish a foundational database infrastructure to support an open-source graph of US Supreme Court jurisprudence. The goal is to maintain a web-accessible platform that integrates a database backend with machine learning workflows and a web application interface. Existing solutions like Data Share were explored but found insufficient due to lack of orchestration and scalability features.

## Problem

The challenge is to reliably create and manage a PostgreSQL database schema for complex legal data, automate table creation, and prepare the system for further development including frontend and backend services. The setup must be reproducible, extendable, and manageable locally before moving to cloud or orchestrated environments.

## Implementation Details

### Technology Choices

- **Java and Maven**: Used for database automation tasks. Java offers robust JDBC support for PostgreSQL, and Maven handles dependencies and build lifecycle.
- **PostgreSQL**: Chosen as the relational database for its reliability and feature set.
- **Docker & Docker Compose**: Used to containerize PostgreSQL and Adminer, enabling easy local deployment and management.
- **Adminer**: Provides a lightweight web interface for database inspection and management.

### Database Setup

- The `docker-compose.yml` file defines two services: `db` (PostgreSQL) and `adminer`.
- PostgreSQL is configured with environment variables for user, password, and database name.
- Volumes are used to persist database data across container restarts.

### Java Code

- The `Main` class connects to the default `postgres` database to check if the target database (`supreme_court`) exists. If not, it creates it.
- After database creation, it connects to the new database and uses the `DatabaseClient` utility to execute SQL schema files.
- The `DatabaseClient` class reads SQL files, splits statements by `;`, and executes them sequentially.
- This approach allows easy extension by adding new SQL files to the `sql` directory.

### SQL Schema

- Tables created include `CallNumbers`, `Contributors`, `Items`, `Resources`, and `Subjects`.
- Each table uses a serial primary key and enforces uniqueness constraints on relevant fields.
- The schema is designed to store metadata related to Supreme Court items, contributors, subjects, and associated resources.

## Practical Notes

- The project assumes a local PostgreSQL instance running on the default port 5432.
- Docker Compose simplifies environment setup but requires Docker installed and running.
- Java 11 is specified in the Maven compiler plugin to ensure compatibility.
- The project currently focuses on database setup; the backend API (e.g., Flask server) and frontend are planned future additions.

## Future Considerations

- Introduce a backend service to expose the database via REST or GraphQL APIs.
- Develop a frontend UI for data exploration.
- Add orchestration for scaling beyond local Docker containers (e.g., Kubernetes).
- Integrate machine learning pipelines for analyzing jurisprudence data.
- Enhance error handling and logging within Java code to improve maintainability.

## Summary

This project establishes a repeatable, automated process for creating and populating a PostgreSQL database tailored to Supreme Court data. Using Java and Maven for automation, combined with Docker for environment management, it lays the groundwork for a scalable, extensible system to serve legal data for research and public access.

