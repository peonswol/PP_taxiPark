package com.taxiPark.submenu.filtering;

import java.util.Scanner;

public class FilterByEngineCapacity extends ATypeFiltering {

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

        cars.removeIf(car -> car.getFuelInfo().getEngineCapacity() > end
                || car.getFuelInfo().getEngineCapacity() < start);
    }

    @Override
    public void enterLimitation(Scanner scanner) {
        System.out.println("\nEnter engine capacity limits cars for filtering :\n");

        System.out.print("Enter start :\t");
        start = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter end :\t");
        end = Double.parseDouble(scanner.nextLine());
    }
}
