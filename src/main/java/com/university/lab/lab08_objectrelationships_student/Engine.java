/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab08_objectrelationships_student;

/**
 *
 * @author natas
 */

public class Engine {

    private String engineNumber;
    private int displacementCC;
    private String fuelType;

    // Parameterized constructor
    
    public Engine(String engineNumber, int displacementCC, String fuelType) {
        if (engineNumber == null || engineNumber.isBlank()
        || fuelType == null || fuelType.isBlank()
        || displacementCC <= 0) {
    throw new IllegalArgumentException("Invalid engine details");
}
        this.engineNumber = engineNumber;
        this.displacementCC = displacementCC;
        this.fuelType = fuelType;
    }

    // Copy Constructor
    public Engine(Engine other) {
        this.engineNumber = other.engineNumber;
        this.displacementCC = other.displacementCC;
        this.fuelType = other.fuelType;
    }

    // Getters
    public String getEngineNumber() {
        return engineNumber;
    }

    public int getDisplacementCC() {
        return displacementCC;
    }

    public String getFuelType() {
        return fuelType;
    }

    // Setters
    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public void setDisplacementCC(int displacementCC) {
        this.displacementCC = displacementCC;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineNumber='" + engineNumber + '\'' +
                ", displacementCC=" + displacementCC +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
