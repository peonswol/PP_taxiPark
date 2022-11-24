package com.taxiPark.submenu.filtering;

import java.util.Scanner;

public class FilterByFuelConsumptionFor100km extends ATypeFiltering {

    private double start;
    private double end;

    public void setStart(double start) {
        this.start = start;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

    public void filter() {

        /*Iterator<Car> iter = cars.iterator();

        while (iter.hasNext()) {
            Car car = iter.next();
            option = car.getFuelInfo().getFuelConsumptionFor100km();

            if (option>end || option<start) {
                iter.remove();
            }
        }*/

        cars.removeIf(car -> (car.getFuelInfo().getFuelConsumptionFor100km()) > end
                || car.getFuelInfo().getFuelConsumptionFor100km() < start);
    }

    @Override
    public void enterLimitation(Scanner scanner) {
        System.out.println("\nEnter fuel consumption for 100 km limits cars for filtering :\n");

        System.out.print("Enter start :\t");
        start = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter end :\t");
        end = Double.parseDouble(scanner.nextLine());
    }
}
