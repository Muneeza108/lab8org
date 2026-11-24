/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab08_objectrelationships_student;

/**
 *
 * @author natas
 */

public class MaintenanceLog {

    private String logId;
    private String serviceDescription;
    private double serviceCost;

    // Parameterized constructor
    public MaintenanceLog(String logId, String serviceDescription, double serviceCost) {
        if (logId == null || logId.isBlank()
        || serviceDescription == null || serviceDescription.isBlank()
        || serviceCost < 0 || !Double.isFinite(serviceCost)) {
    throw new IllegalArgumentException("Invalid maintenance details");
}
        this.logId = logId;
        this.serviceDescription = serviceDescription;
        this.serviceCost = serviceCost;
    }

    // Copy Constructor
    public MaintenanceLog(MaintenanceLog other) {
        this.logId = other.logId;
        this.serviceDescription = other.serviceDescription;
        this.serviceCost = other.serviceCost;
    }

    // Getters
    public String getLogId() {
        return logId;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    // Setters
    public void setLogId(String logId) {
        this.logId = logId;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    @Override
    public String toString() {
        return "MaintenanceLog{" +
                "logId='" + logId + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", serviceCost=" + serviceCost +
                '}';
    }
}
