# Lab Task 08 – Object-Oriented Programming in Java

**University:** University of Engineering and Technology, Abbottabad Campus  
**Department:** Software Engineering  
**Semester:** 5th Semester  
**Subject:** Software Construction  
**Instructor:** Engr. Rizwan Shah  
**Lab Date:** 03 November 2026

## Project Title
Autonomous Fleet & Vehicle Management System (FleetOps)

## Objective
The objective of this lab is to understand and implement Aggregation and Composition in Java, prevent representation exposure through defensive copying, and verify object lifecycle independence.

## Project Structure

The project contains the following Java classes:

- **Driver.java:** Represents an independent fleet driver with validated attributes, getters, setters, and toString().
- **Engine.java:** Represents a vehicle engine and implements a copy constructor for defensive copying.
- **MaintenanceLog.java:** Stores vehicle maintenance records and supports defensive duplication.
- **Vehicle.java:** Represents a vehicle and implements Composition with Engine and MaintenanceLog, along with Aggregation with Driver.
- **FleetDepot.java:** Manages existing Vehicle objects using Aggregation and provides an unmodifiable vehicle collection.
- **FleetVerificationDriver.java:** Tests aggregation lifecycle independence, composition, and defensive copying.

## Tasks Implemented

### Task 1: Environment and Project Setup
Created a Java Maven Application using Apache NetBeans with the required project metadata and .gitignore configuration.

### Task 2: Aggregation
Implemented Driver and FleetDepot relationships. Vehicles and drivers can exist independently of a depot, and the depot can assign or release existing vehicles.

### Task 3: Composition and Defensive Copying
Implemented Engine and MaintenanceLog as components owned by Vehicle. Copy constructors and defensive accessors prevent external modification of internal vehicle data.

### Task 4: Verification and Testing
Created FleetVerificationDriver to demonstrate:
- Aggregation lifecycle independence.
- Engine defensive copying.
- Maintenance history protection.
- Prevention of representation exposure.

## Technologies Used
- Java
- Apache NetBeans IDE
- Maven
- Git and GitHub

## How to Run the Project

1. Clone or download this repository.
2. Open Apache NetBeans.
3. Select File → Open Project.
4. Select the project folder.
5. Expand Source Packages and locate `com.uet.construction.fleetops`.
6. Right-click `FleetVerificationDriver.java`.
7. Select Run File.
8. Check the Output window for the verification results.

## Expected Results

The verification program should demonstrate that:
- Vehicles and drivers remain accessible after the depot reference is removed.
- Modifying a copied Engine does not affect the original Engine.
- Clearing a retrieved maintenance history does not affect the vehicle's internal history.
- Modifying a copied maintenance record does not affect the original record.

## Conclusion
This lab demonstrates the practical implementation of Object-Oriented Programming relationships in Java. Aggregation allows independent objects to be associated without sharing lifecycles, while Composition establishes strong ownership between objects. Defensive copying protects internal object state and prevents representation exposure.

