package com.taxiPark.park.car.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class GeneralInfo implements Serializable {

    private String markAndModel;
    private int yearManufacture;
    private double cost;
    private String color;
    private double maxSpeed;

    private static final Logger logger = LoggerFactory.getLogger(GeneralInfo.class);

    public String getMarkAndModel() {
        return markAndModel;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public double getCost() {
        return cost;
    }

    public String getColor() {
        return color;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public GeneralInfo() {
        logger.info("Створено новий об'єкт класу GeneralInfo.");
    }

    @Override
    public String toString() {
        return  "\n\tmark and model ------------------ " + markAndModel +
                "\n\tyear manufacture ---------------- " + yearManufacture +
                "\n\tcost ---------------------------- " + cost +
                "\n\tcolor --------------------------- " + color +
                "\n\tmax speed ----------------------- " + maxSpeed;
    }

    public String toListString(){
        return String.format(" %-18s| %-17d| %-19.2f| %-18s| %-10.2f| --- ", markAndModel, yearManufacture, cost, color, maxSpeed);
    }

    public static GeneralInfoBuilder builder(){
        return new GeneralInfoBuilder();
    }

    public static GeneralInfoBuilder builder(GeneralInfo generalInfo){
        return new GeneralInfoBuilder(generalInfo);
    }
    public static class GeneralInfoBuilder{
        private final GeneralInfo generalInfo;

        public GeneralInfoBuilder() {
            this.generalInfo = new GeneralInfo();
        }

        public GeneralInfoBuilder(GeneralInfo generalInfo) {
            this.generalInfo = generalInfo;
        }

        public GeneralInfoBuilder setMarkAndModel(String markAndModel){
            generalInfo.markAndModel = markAndModel;
            return this;
        }

        public GeneralInfoBuilder setYearManufacture(int yearManufacture){
            generalInfo.yearManufacture = yearManufacture;
            return this;
        }

        public GeneralInfoBuilder setCost(double cost){
            generalInfo.cost = cost;
            return this;
        }

        public GeneralInfoBuilder setColor(String color){
            generalInfo.color = color;
            return this;
        }

        public GeneralInfoBuilder setMaxSpeed(double maxSpeed){
            generalInfo.maxSpeed = maxSpeed;
            return this;
        }

        public GeneralInfo build(){
            return this.generalInfo;
        }
    }
}
