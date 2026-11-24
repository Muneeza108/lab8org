/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab08_objectrelationships_student;

/**
 *
 * @author natas
 */

import java.util.List;

public class FleetVerificationDriver {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" FLEETOPS SYSTEM VERIFICATION");
        System.out.println("====================================");

        // =================================
        // TEST CASE A: AGGREGATION
        // =================================

        System.out.println("\nTEST CASE A: AGGREGATION");

        // Create independent drivers
        Driver driver1 = new Driver(
                "D001", "Ali Khan", "LIC101");

        Driver driver2 = new Driver(
                "D002", "Ahmed Shah", "LIC102");

        // Create independent vehicles
        Vehicle vehicle1 = new Vehicle(
                "VIN001", "Toyota Corolla",
                "ENG001", 1800, "Petrol");

        Vehicle vehicle2 = new Vehicle(
                "VIN002", "Honda Civic",
                "ENG002", 2000, "Petrol");

        // Assign drivers
        vehicle1.assignDriver(driver1);
        vehicle2.assignDriver(driver2);

        // Create depot
        FleetDepot depot = new FleetDepot(
                "DEP001", "Abbottabad");

        depot.assignVehicle(vehicle1);
        depot.assignVehicle(vehicle2);

        System.out.println("Vehicles assigned: "
                + depot.getAssignedVehicles().size());

        // Remove depot reference
        depot = null;

        System.out.println("\nDepot reference set to null.");

        // Verify vehicles still exist
        System.out.println("Vehicle 1: " + vehicle1);
        System.out.println("Vehicle 2: " + vehicle2);

        // Verify drivers still exist
        System.out.println("Driver 1: " + driver1);
        System.out.println("Driver 2: " + driver2);

        System.out.println(
                "PASS: Vehicles and drivers remain accessible.");

        // =================================
        // TEST CASE B: COMPOSITION
        // =================================

        System.out.println("\nTEST CASE B: COMPOSITION");

        Vehicle vehicle3 = new Vehicle(
                "VIN003", "Suzuki Swift",
                "ENG003", 1200, "Petrol");

        // Add maintenance records
        vehicle3.addMaintenanceRecord(
                "LOG001", "Oil Change", 5000);

        vehicle3.addMaintenanceRecord(
                "LOG002", "Brake Inspection", 3000);

        // Get defensive copy of engine
        Engine leakedEngine = vehicle3.getEngine();

        System.out.println("\nOriginal Engine: "
                + vehicle3.getEngine());

        // Modify external engine copy
        leakedEngine.setEngineNumber("HACKED");

        System.out.println("Modified External Engine: "
                + leakedEngine);

        System.out.println("Actual Vehicle Engine: "
                + vehicle3.getEngine());

        if (!vehicle3.getEngine().getEngineNumber()
                .equals("HACKED")) {

            System.out.println(
                    "PASS: Engine defensive copying works.");

        } else {
            System.out.println(
                    "FAIL: Engine was modified externally.");
        }

        // Test maintenance history protection
        List<MaintenanceLog> history =
                vehicle3.getMaintenanceHistory();

        System.out.println("\nOriginal Maintenance History:");
        System.out.println(history);

        // Attempt to clear external history
        history.clear();

        System.out.println(
                "External History after clearing: " + history);

        System.out.println(
                "Actual Vehicle History: "
                + vehicle3.getMaintenanceHistory());

        if (vehicle3.getMaintenanceHistory().size() == 2) {

            System.out.println(
                    "PASS: Maintenance history is protected.");

        } else {
            System.out.println(
                    "FAIL: Maintenance history was modified.");
        }

        // Test modifying an individual copied log
        List<MaintenanceLog> copiedHistory =
                vehicle3.getMaintenanceHistory();

        copiedHistory.get(0).setServiceDescription("HACKED");

        System.out.println(
                "\nActual History after modifying copied log:");

        System.out.println(vehicle3.getMaintenanceHistory());

        System.out.println("\n====================================");
        System.out.println(" VERIFICATION COMPLETED");
        System.out.println("====================================");
    }
}
