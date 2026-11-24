/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab08_objectrelationships_student;

/**
 *
 * @author natas
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FleetDepot {

    private String depotId;
    private String locationName;

    // Aggregation: Stores references to existing vehicles
    private final List<Vehicle> assignedVehicles;

    // Constructor
    public FleetDepot(String depotId, String locationName) {

        if (depotId == null || depotId.isBlank()
                || locationName == null || locationName.isBlank()) {
            throw new IllegalArgumentException(
                    "Depot ID and location cannot be empty");
        }

        this.depotId = depotId;
        this.locationName = locationName;
        this.assignedVehicles = new ArrayList<>();
    }

    // Assign an existing vehicle
    public void assignVehicle(Vehicle vehicle) {

        if (vehicle == null) {
            throw new IllegalArgumentException(
                    "Vehicle cannot be null");
        }

        if (!assignedVehicles.contains(vehicle)) {
            assignedVehicles.add(vehicle);
        }
    }

    // Release a vehicle without destroying it
    public void releaseVehicle(Vehicle vehicle) {
        assignedVehicles.remove(vehicle);
    }

    // Return an unmodifiable view
    public List<Vehicle> getAssignedVehicles() {
        return Collections.unmodifiableList(assignedVehicles);
    }

    // Getters
    public String getDepotId() {
        return depotId;
    }

    public String getLocationName() {
        return locationName;
    }

    // Display depot information
    @Override
    public String toString() {
        return "FleetDepot{" +
                "depotId='" + depotId + '\'' +
                ", locationName='" + locationName + '\'' +
                ", assignedVehicles=" + assignedVehicles.size() +
                '}';
    }
}
