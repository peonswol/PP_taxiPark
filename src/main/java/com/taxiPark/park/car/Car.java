package com.taxiPark.park.car;

import com.taxiPark.Color;
import com.taxiPark.park.car.component.FuelInfo;
import com.taxiPark.park.car.component.GeneralInfo;
import com.taxiPark.park.car.component.MoreInformation;
import com.taxiPark.park.car.component.TechnicInfo;


import java.io.Serializable;

public class Car implements Serializable {

    private static int kstCar;
    private int carID;
    private GeneralInfo generalInfo;
    private TechnicInfo technicInfo;
    private FuelInfo fuelInfo;
    private MoreInformation moreInformation;

    public Car(GeneralInfo generalInfo, TechnicInfo technicInfo, FuelInfo fuelInfo, MoreInformation moreInformation) {
        this.generalInfo = generalInfo;
        this.technicInfo = technicInfo;
        this.fuelInfo = fuelInfo;
        this.moreInformation = moreInformation;
        kstCar++;
        carID = kstCar;
    }

    public Car() {
        kstCar++;
        carID = kstCar;
    }

    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public TechnicInfo getTechnicInfo() {
        return technicInfo;
    }

    public FuelInfo getFuelInfo() {
        return fuelInfo;
    }

    public MoreInformation getMoreInformation() {
        return moreInformation;
    }

    public static int getKstCar() {
        return kstCar;
    }

    public static void setKstCar(int kstCar) {
        Car.kstCar = kstCar;
    }

    public int getCarID() {
        return carID;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

    public void setTechnicInfo(TechnicInfo technicInfo) {
        this.technicInfo = technicInfo;
    }

    public void setFuelInfo(FuelInfo fuelInfo) {
        this.fuelInfo = fuelInfo;
    }

    public void setMoreInformation(MoreInformation moreInformation) {
        this.moreInformation = moreInformation;
    }

    @Override
    public String toString() {
        return "Car ID = " + carID + "\n" + Color.ANSI_PURPLE_BACKGROUND +"\n"+Color.ANSI_RESET+
                "\n↪ general info :" + generalInfo +
                "\n\n↪ technic info :" + technicInfo +
                "\n\n↪ fuel info :" + fuelInfo +
                "\n\n↪ moreInformation :" + moreInformation;
    }

    public String toListString(){
        return String.format("| №%-5d \t|",carID)+generalInfo.toListString()+fuelInfo.toListString();
    }
}
