package com.taxiPark.submenu.filtering;

import com.taxiPark.park.car.Car;

import java.util.Iterator;
import java.util.Scanner;

public class FilterByFuelType extends ATypeFiltering{

    private String[] fuelTypes;

    public void setFuelTypes(String[] fuelTypes) {
        this.fuelTypes = fuelTypes;
    }

    public String[] getFuelTypes() {
        return fuelTypes;
    }

    @Override
    public void enterLimitation(Scanner scanner){
        System.out.println("\nEnter fuel types cars for filtering (A-95 diesel) :");
        String choosing = scanner.nextLine();

        fuelTypes = choosing.split(" ");
    }

    public void filter() {

        String fuelTypeCar;
        boolean ifFuelTypes;

        Iterator<Car> iter = cars.iterator();

        while (iter.hasNext()) {
            Car car = iter.next();
            ifFuelTypes = false;

            for (String fuelType : fuelTypes) {
                fuelTypeCar = car.getFuelInfo().getFuelType().toLowerCase();
                if (fuelTypeCar.contains(fuelType.toLowerCase())) {
                    ifFuelTypes = true;
                }
            }
            if (!ifFuelTypes) {
                iter.remove();
            }
        }
    }
}
