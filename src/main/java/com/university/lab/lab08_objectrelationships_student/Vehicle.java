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

public class Vehicle {

    private String vin;
    private String model;

    // Composition: Vehicle creates and owns its Engine
    private final Engine engine;

    // Composition: Vehicle owns its maintenance records
    private final List<MaintenanceLog> maintenanceHistory;

    // Aggregation: Driver exists independently
    private Driver driver;

    // Constructor
    public Vehicle(String vin, String model,
                   String engineNumber, int displacementCC,
                   String fuelType) {

        if (vin == null || vin.isBlank()
                || model == null || model.isBlank()) {
            throw new IllegalArgumentException(
                    "VIN and model cannot be empty");
        }

        this.vin = vin;
        this.model = model;

        // Engine is created internally
        this.engine = new Engine(
                engineNumber, displacementCC, fuelType);

        this.maintenanceHistory = new ArrayList<>();
    }

    // Getters
    public String getVin() {
        return vin;
    }

    public String getModel() {
        return model;
    }

    // Defensive copy of Engine
    public Engine getEngine() {
        return new Engine(this.engine);
    }

    // Add maintenance record internally
    public void addMaintenanceRecord(
            String logId, String description, double cost) {

        MaintenanceLog log = new MaintenanceLog(
                logId, description, cost);

        maintenanceHistory.add(log);
    }

    // Return defensive copies of maintenance records
    public List<MaintenanceLog> getMaintenanceHistory() {

        List<MaintenanceLog> copyList = new ArrayList<>();

        for (MaintenanceLog log : maintenanceHistory) {
            copyList.add(new MaintenanceLog(log));
        }

        return copyList;
    }

    // Aggregation: Assign independent Driver
    public void assignDriver(Driver driver) {
        this.driver = driver;
    }

    public void releaseDriver() {
        this.driver = null;
    }

    public Driver getDriver() {
        return driver;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", driver=" + driver +
                '}';
    }
}
