package com.taxiPark.park.car.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class FuelInfo implements Serializable {

    private String fuelType; // тип пального
    private String engineType; //тип двигуна
    private double engineCapacity; //об'єм баку
    private double fuelConsumptionFor100km; // витрати пального

    private static final Logger logger = LoggerFactory.getLogger(FuelInfo.class);

    public static FuelInfoBuilder builder(){
        return new FuelInfoBuilder();
    }

    public static FuelInfoBuilder builder(FuelInfo fuelInfo){
        return new FuelInfoBuilder(fuelInfo);
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getEngineType() {
        return engineType;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public double getFuelConsumptionFor100km() {
        return fuelConsumptionFor100km;
    }

    public FuelInfo() {

        logger.info("Створено новий об'єкт класу FuelInfo.");
    }

    @Override
    public String toString() {
        return  "\n\tfuel type ----------------------- " + fuelType +
                "\n\tengine type --------------------- " + engineType +
                "\n\tengine capacity ----------------- " + engineCapacity +
                "\n\tfuel consumption for 100 km ----- " + fuelConsumptionFor100km;
    }

    public String toListString(){
        return String.format("| %-12s| %-16.2f| %-17.2f", fuelType, engineCapacity, fuelConsumptionFor100km);
    }

    public static class FuelInfoBuilder{
        private final FuelInfo fuelInfo;

        public FuelInfoBuilder() {
            this.fuelInfo = new FuelInfo();
        }

        public FuelInfoBuilder(FuelInfo fuelInfo) {
            this.fuelInfo = fuelInfo;
        }

        public FuelInfoBuilder setFuelType(String fuelType){
            fuelInfo.fuelType = fuelType;
            return this;
        }

        public FuelInfoBuilder setEngineType(String engineType){
            fuelInfo.engineType = engineType;
            return this;
        }

        public FuelInfoBuilder setEngineCapacity(double engineCapacity){
            fuelInfo.engineCapacity = engineCapacity;
            return this;
        }

        public FuelInfoBuilder setFuelConsumptionFor100km(double fuelConsumptionFor100km){
            fuelInfo.fuelConsumptionFor100km = fuelConsumptionFor100km;
            return this;
        }

        public FuelInfo build(){
            return this.fuelInfo;
        }
    }
}
