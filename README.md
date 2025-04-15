#Group Members: Bhavdep Singh, Sourav Modak, Hitesh Jha, Abdul Mubeen
Assignment 3-5: Industrial Machine Maintenance & Scheduling System (IMMS)


# Industrial Machine Maintenance & Scheduling System (IMMS)

## Overview

The **IMMS** (Industrial Machine Maintenance & Scheduling System) is an enterprise-grade application developed using **J2EE Web Components**, **EJB**, and **REST API**. This system helps in automating the tracking, maintenance scheduling, and technician resource allocation for industrial machines at **TitanMach Engineering**.

The system supports multiple user roles including **Admin**, **Maintenance Manager**, and **Technician**, and integrates functionalities such as:

- **Machine Management** (Registration, Status Updates, Filtering)
- **Maintenance Task Management** (Create, Assign, Track)
- **Technician Portal** (Task View and Update)
- **Reporting & Analytics** (Machine Downtime, Technician Performance)

## Learning Objectives

- Develop a multi-tier J2EE enterprise application following MVC principles.
- Implement reusable business logic using Stateless Session EJBs.
- Build RESTful APIs using JAX-RS integrated with EJB.
- Structure and deploy an application as an EAR archive.
- Persist data using JPA or JDBC.
- Collaborate via GitHub using version control and project management best practices.

## Functional Requirements

### User Roles:
- **Admin**: Manage all users, view reports.
- **Maintenance Manager**: Register machines, schedule maintenance, assign technicians.
- **Technician**: View and update assigned tasks.

### Core Features:
1. **Machine Management**:
   - Register new machines.
   - Update machine details (except serial number).
   - Change status (Active, Under Maintenance, Retired).
   - Filterable machine list.
   
2. **Maintenance Task Management**:
   - Create and assign maintenance tasks.
   - Set task type (Routine, Emergency, Inspection).
   - Track task status (Scheduled, In Progress, Completed, Failed).
   
3. **Technician Portal**:
   - View assigned tasks.
   - Update status and remarks.
   - View task history.
   
4. **Reporting & Analytics**:
   - Machine downtime report.
   - Technician performance stats.
   - Maintenance frequency analysis.

## Technical Architecture

### Project Structure:

### Web Layer:
- **MVC architecture** using **Servlets** and **JSP** for role-based login and dashboards.
- **Input validation** and **error handling**.

### EJB Layer:
- Stateless **EJBs** for business logic:
  - `MachineServiceBean`
  - `MaintenanceServiceBean`
  - `TechnicianServiceBean`

### REST API:
- Exposes RESTful endpoints using **JAX-RS** and **EJB**:
  - `GET /api/machines`
  - `POST /api/maintenance`
  - `GET /api/technicians/{id}/tasks`
  - `PUT /api/maintenance/{id}/status`
  - `GET /api/reports/summary`

### Persistence Layer:
- **JPA** for data persistence, using **MySQL** (or **H2**) database.
- Entity relationships: `Machine → MaintenanceTask → Technician/User`.

### Deployment:
- EAR archive is deployed on **GlassFish** or **WildFly**.
- Configuration via **application.xml** and **persistence.xml**.

## API Endpoints

The application exposes the following RESTful API endpoints:

### 1. **POST /api/login**
- **Description**: Authenticates the user based on username and password.
- **Request Body**:
  ```json
  {
    "username": "user",
    "password": "password"
  }
