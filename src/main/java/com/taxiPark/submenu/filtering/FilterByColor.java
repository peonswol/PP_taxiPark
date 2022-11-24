package com.taxiPark.submenu.filtering;


import com.taxiPark.park.car.Car;

import java.util.Iterator;
import java.util.Scanner;

public class FilterByColor extends ATypeFiltering {

    private String[] colorsCars;

    public void setColorsCars(String[] colorsCars) {
        this.colorsCars = colorsCars;
    }

    public String[] getColorsCars() {
        return colorsCars;
    }

    public void enterLimitation(Scanner scanner){
        System.out.println("\nEnter colors cars for filtering (black gray) :");
        String choosing = scanner.nextLine();

        colorsCars = choosing.split(" ");
    }

    public void filter(){

        String colorCar;
        boolean ifColor;

        Iterator<Car> iter = cars.iterator();

        while (iter.hasNext()) {
            Car car = iter.next();
            ifColor = false;
            for (String color:colorsCars){
                colorCar = car.getGeneralInfo().getColor().toLowerCase();
                if (colorCar.contains(color.toLowerCase())){
                    ifColor = true;
                }
            }
            if(!ifColor){
                iter.remove();
            }
        }
    }
}
