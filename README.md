# ReliefLink — Disaster Relief Resource Management System

ReliefLink is a web-based Disaster Relief Resource Management System designed to help coordinate disaster response operations. It provides a centralized dashboard for managing volunteers, relief resources, shelters, emergency requests, and request tracking.

The project also demonstrates DevOps practices by integrating Docker containerization, Docker Compose orchestration, Jenkins-based CI/CD, and automated build and test stages.

## Table of Contents

* [Project Overview](#project-overview)
* [Objectives](#objectives)
* [Features](#features)
* [Technology Stack](#technology-stack)
* [System Architecture](#system-architecture)
* [Project Structure](#project-structure)
* [Prerequisites](#prerequisites)
* [Run the Project Locally](#run-the-project-locally)
* [Docker Deployment](#docker-deployment)
* [Jenkins CI/CD Pipeline](#jenkins-cicd-pipeline)
* [Application URLs](#application-urls)
* [Testing](#testing)
* [Future Enhancements](#future-enhancements)

## Project Overview

During a disaster, coordinating volunteers, relief supplies, shelters, and emergency requests is essential. ReliefLink aims to simplify these activities through a centralized web application.

The system uses a frontend dashboard to interact with a Spring Boot backend, which communicates with a MySQL database. Docker Compose manages the application containers, while Jenkins automates the build, test, and container deployment workflow.

## Objectives

* Centralize disaster relief operations in one application.
* Manage volunteers and their information.
* Maintain an inventory of relief resources.
* Manage shelter information.
* Record and manage emergency requests.
* Track emergency requests through the dashboard.
* Containerize the application using Docker.
* Automate building, testing, and deployment using Jenkins.

## Features

### 1. Operations Dashboard

Provides a centralized overview of disaster relief operations and access to the main management modules.

### 2. Volunteer Management

Provides an interface for managing volunteer information and supporting volunteer coordination.

### 3. Resource Inventory

Supports the management of relief resources and inventory information.

### 4. Shelter Management

Provides an interface for maintaining shelter information and supporting shelter coordination.

### 5. Emergency Requests

Provides a module for recording and managing emergency assistance requests.

### 6. Live Request Tracking

Provides a dedicated interface for viewing and monitoring emergency requests and their progress.

### 7. Admin Dashboard

Provides an administration interface for accessing the application's administrative functions.

### 8. Backend Health Monitoring

The frontend checks the backend health endpoint and displays whether the backend is online or offline.

Health endpoint:

`http://localhost:8080/api/health`

A successful response is:

```json
{
  "status": "success"
}
```

## Technology Stack

| Component               | Technology                 |
| ----------------------- | -------------------------- |
| Frontend                | HTML, CSS, JavaScript      |
| Backend                 | Java 21, Spring Boot 3.5.6 |
| Build Tool              | Apache Maven               |
| Database                | MySQL                      |
| Testing                 | JUnit, Spring Boot Test    |
| Containerization        | Docker                     |
| Container Orchestration | Docker Compose             |
| CI/CD                   | Jenkins                    |
| Version Control         | Git and GitHub             |
| Web Server              | Nginx                      |

## System Architecture

```text
                   Users
                     |
                     v
            Frontend Web Interface
               HTML, CSS, JS
                     |
                     v
               Nginx Container
               Port 3000:80
                     |
                     v
             Spring Boot Backend
                 Java 21
               Port 8080
                     |
                     v
               MySQL Database
               Port 3307:3306


       GitHub Repository
               |
               v
          Jenkins Pipeline
               |
               v
         Maven Build & Tests
               |
               v
        Docker Image Build
               |
               v
       Docker Compose Deployment
```

Docker Compose manages the frontend, backend, and database services. Jenkins checks out the source code and runs the configured CI/CD pipeline.

## Project Structure

```text
disaster-relief-resource-management/
|
|-- backend/
|   |-- src/
|   |   |-- main/
|   |   |   |-- java/
|   |   |   |-- resources/
|   |   |-- test/
|   |-- pom.xml
|   |-- Dockerfile
|
|-- frontend/
|   |-- index.html
|   |-- css/
|   |-- js/
|   |-- nginx.conf
|   |-- Dockerfile
|
|-- docker-compose.yml
|-- Jenkinsfile
|-- README.md
```

The exact directory structure may vary slightly depending on the current repository version.

## Prerequisites

Install the following software before running the project:

* Git
* Java Development Kit (JDK) 21
* Apache Maven
* Docker Desktop
* Jenkins
* A modern web browser

For the containerized setup, Docker Desktop must be running with its Linux container engine available.

## Run the Project Locally

### Step 1: Clone the repository

```bash
git clone https://github.com/kadavathpriyanka/Diaster-relief-management.git
cd Diaster-relief-management
```

### Step 2: Start Docker Desktop

Open Docker Desktop and wait until the Docker engine is running.

Verify the installation:

```bash
docker --version
docker compose version
docker ps
```

### Step 3: Start the application

From the project root directory, where `docker-compose.yml` is located, run:

```bash
docker compose up -d --build
```

This builds the configured images and starts the application services in the background.

### Step 4: Verify the containers

```bash
docker ps
```

The frontend, backend, and MySQL containers should be running. The database should report healthy if its health check is configured and passing.

### Step 5: Open the application

Visit:

* Frontend: http://localhost:3000
* Backend health endpoint: http://localhost:8080/api/health

### Step 6: Stop the application

```bash
docker compose down
```

To rebuild after source changes, run:

```bash
docker compose up -d --build
```

**Note:** If Docker reports that a container name is already in use, inspect existing containers with `docker ps -a` and stop or remove the conflicting container only after confirming it is no longer needed. Do not remove database volumes unless you intend to delete persisted data.

## Docker Deployment

The application is containerized into separate services:

* **Frontend:** Serves the web interface through Nginx.
* **Backend:** Runs the Spring Boot application.
* **Database:** Stores application data in MySQL.

Docker Compose defines how the services are configured and connected. It also supports repeatable startup and deployment on a compatible machine with Docker installed.

The frontend is mapped to port 3000, the backend to port 8080, and MySQL to port 3307 on the host, according to the local configuration.

This is a local container deployment. Publishing the application on a public server would require an additional hosting and production deployment configuration.

## Jenkins CI/CD Pipeline

The project includes a `Jenkinsfile` to automate the application's build and deployment workflow.

### Pipeline stages

1. **Checkout SCM:** Retrieves the source code from GitHub.
2. **Build Backend:** Uses Maven to compile and package the Spring Boot application.
3. **Test Backend:** Executes the backend tests.
4. **Docker Build:** Builds the frontend and backend Docker images.
5. **Docker Deploy:** Starts or updates the configured services using Docker Compose.
6. **Post Actions:** Reports the pipeline result.

### Running the pipeline

1. Start Docker Desktop.
2. Ensure the Jenkins service is running.
3. Open the Jenkins dashboard at `http://localhost:8080` if Jenkins is configured to use that port.
4. Open the configured project job.
5. Click **Build Now**.
6. Open **Console Output** to review the checkout, build, test, image build, and deployment stages.

**Important:** If Jenkins and the backend both use port 8080 on the same Windows host, they cannot both bind that host port simultaneously. Configure Jenkins or the backend to use separate host ports before running them together. For example, Jenkins could use port 8081 while the backend retains port 8080, provided the Jenkins service is reconfigured accordingly.

A successful Maven build and passing tests confirm the corresponding CI stages. A successful Docker deployment should also be verified by checking container status and opening the application.

## Application URLs

| Service              | Local URL                                          |
| -------------------- | -------------------------------------------------- |
| ReliefLink Frontend  | http://localhost:3000                              |
| Backend Health Check | http://localhost:8080/api/health                   |
| Jenkins Dashboard    | http://localhost:8080 (if configured on port 8080) |
| MySQL                | localhost:3307                                     |

The Jenkins and backend URLs cannot both use the same host port at the same time. If Jenkins has been moved to another port, use its configured URL instead.

## Testing

The backend includes integration tests that can be executed using Maven.

Run tests from the backend directory:

```bash
cd backend
mvn test
```

To build the backend package:

```bash
mvn clean package
```

To inspect the application logs:

```bash
docker logs --tail 100 disaster-relief-backend
```

To verify backend availability:

```bash
curl.exe http://localhost:8080/api/health
```

Expected health response:

```json
{"status":"success"}
```

## Future Enhancements

* Role-based authentication and authorization.
* Improved volunteer assignment and coordination.
* Real-time emergency request notifications.
* Maps and geographic resource tracking.
* More comprehensive automated tests.
* Automated image publishing to a container registry.
* Deployment to a cloud platform or remote server.
* HTTPS, monitoring, logging, and production security improvements.

## Conclusion

ReliefLink combines disaster relief resource management with practical DevOps tools. The application demonstrates frontend and backend integration, database connectivity, automated testing, Docker containerization, Docker Compose orchestration, and a Jenkins CI/CD pipeline.

The project provides a foundation for further development toward a more scalable and production-ready disaster response management platform.
