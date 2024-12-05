# Crop Monitoring System

This repository contains the implementation of a **Crop Monitoring System** for **Green Shadow (Pvt) Ltd.**. The system is developed as part of the coursework for **ITS1114 – Advanced API Development** for the **BSc (Hons.) in Computer Science via GDSE** program.

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

 

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/crop-monitoring-system.git
   cd crop-monitoring-system
