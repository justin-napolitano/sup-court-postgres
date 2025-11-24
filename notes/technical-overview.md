---
slug: github-sup-court-postgres-note-technical-overview
id: github-sup-court-postgres-note-technical-overview
title: sup-court-postgres Overview
repo: justin-napolitano/sup-court-postgres
githubUrl: https://github.com/justin-napolitano/sup-court-postgres
generatedAt: '2025-11-24T18:47:19.170Z'
source: github-auto
summary: >-
  This repo sets up and manages a PostgreSQL database for US Supreme Court data
  using Java. It features SQL schema files for several key tables, and a Docker
  setup for PostgreSQL and Adminer.
tags: []
seoPrimaryKeyword: ''
seoSecondaryKeywords: []
seoOptimized: false
topicFamily: null
topicFamilyConfidence: null
kind: note
entryLayout: note
showInProjects: false
showInNotes: true
showInWriting: false
showInLogs: false
---

This repo sets up and manages a PostgreSQL database for US Supreme Court data using Java. It features SQL schema files for several key tables, and a Docker setup for PostgreSQL and Adminer.

## Key Components
- **Java 11** for backend code
- **Maven** for dependencies
- **PostgreSQL** as the database
- **Docker Compose** to run containers

## Quick Start

1. **Clone the repo**:
    ```bash
    git clone https://github.com/justin-napolitano/sup-court-postgres.git
    cd sup-court-postgres
    ```

2. **Run Docker containers**:
    ```bash
    docker-compose up -d
    ```

3. **Build the project**:
    ```bash
    mvn clean package
    ```

4. **Create the database and tables**:
    ```bash
    mvn exec:java -Dexec.mainClass="com.createdb.Main"
    ```

### Gotchas
Ensure you have Java 11, Maven, and Docker installed before starting.
