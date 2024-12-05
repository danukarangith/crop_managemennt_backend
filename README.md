# Crop Monitoring System

This repository contains the implementation of a **Crop Monitoring System** for **Green Shadow (Pvt) Ltd.**. 

## Overview

The system is designed to manage and systematize operations related to crop monitoring, staff, equipment, vehicles, and fields. It enables efficient management and tracking with user roles, relational analysis, and spatial/temporal resource analysis.

## Features

- **User Access Control**: Role-based access for MANAGER, ADMINISTRATIVE, and SCIENTIST.
- **CRUD Operations**: Create, Read, Update, and Delete operations for all key entities.
- **Relational and Temporal Analysis**: Evaluate relationships and time/location-based resource utilization.
- **Field Management**: Monitor field extent, crop allocation, and staff assignments.
- **Crop Management**: Manage crop types, growth stages, and observations.
- **Staff Management**: Handle human resources, assignments, and designations.
- **Vehicle and Equipment Management**: Track vehicles and equipment assignments.
- **Secure Authentication**: Implemented with Spring Security and JWT.
- **Validation**: Client-side and server-side validation.


### Postman Collection

Access the Postman documentation for this API [here](https://documenter.getpostman.com/view/36300872/2sAYBbco3u).

## Application Architecture

The application follows a layered architecture:
- **API Layer**: Handles RESTful endpoints.
- **Service Layer**: Business logic.
- **Persistence Layer**: Database interactions.

## Technologies

**Frontend**:
- HTML, CSS, Bootstrap, JavaScript, jQuery, AJAX

**Backend**:
- Spring Boot, Spring Data JPA, Spring Security, Lombok, Model Mapper, Jackson, MySQL

**Security**:
- OAuth 2.0, JWT

## System Entities

 Access the Postman documentation for this API [here](https://documenter.getpostman.com/view/36300872/2sAYBbco3u).


## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/danukarangith/crop-monitoring-backend.git
   cd crop-monitoring-system



  ### Security Features
- Passwords are stored securely using encryption.
- Role-based access control (MANAGER, ADMINISTRATIVE, SCIENTIST).
- Spring Security integrated with OAuth 2.0 and JWT.

### Validation
- Validation is enforced at both the client and server levels.
- UI ensures proper input with user-friendly messages.

### Usage Guidelines
- Ensure proper role-based access for all users.
- Use the provided endpoints to interact with the system.

### Endpoints
- `POST /api/v1/fields`: Add a new field.
- `GET /api/v1/fields`: Retrieve all fields.
- `PATCH /api/v1/fields/{fieldCode}`: Update a field.
- `DELETE /api/v1/fields/{fieldCode}`: Delete a field.
- *(Add similar endpoints for other entities as per the implementation)*

### Future Enhancements
- Implement advanced analytics dashboards.
- Add support for IoT integration for real-time field monitoring.
- Extend user roles for customizable permissions.

### Author
Danuka Rangith
 
