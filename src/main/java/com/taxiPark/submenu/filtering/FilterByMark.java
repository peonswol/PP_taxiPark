package com.taxiPark.submenu.filtering;

import com.taxiPark.park.car.Car;

import java.util.Iterator;
import java.util.Scanner;

public class FilterByMark extends ATypeFiltering {

    private String[] marksCars;

    public String[] getMarksCars() {
        return marksCars;
    }

    public void setMarksCars(String[] marksCars) {
        this.marksCars = marksCars;
    }

    public void enterLimitation(Scanner scanner){
        System.out.println("\nEnter marks cars for filtering (audi bmw) :");
        String choosing = scanner.nextLine();

        marksCars = choosing.split(" ");
    }


    public void filter(){

        String markCar;
        boolean ifMark;

        Iterator<Car> iter = cars.iterator();

        while (iter.hasNext()) {
            Car car = iter.next();
            ifMark = false;

            for (String mark:marksCars){
                markCar = car.getGeneralInfo().getMarkAndModel().toLowerCase();
                if (markCar.contains(mark.toLowerCase())){
                    ifMark = true;
                }
            }
            if(!ifMark){
                iter.remove();
            }
        }
    }
}
