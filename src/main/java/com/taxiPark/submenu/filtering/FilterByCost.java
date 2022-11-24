package com.taxiPark.submenu.filtering;

import java.util.Scanner;

public class FilterByCost extends ATypeFiltering {

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

    @Override
    public void filter() {

        cars.removeIf(car -> car.getGeneralInfo().getCost() > end
                || car.getGeneralInfo().getCost() < start);
    }

    @Override
    public void enterLimitation(Scanner scanner) {
        System.out.println("\nEnter cost limits cars for filtering :\n");

        System.out.print("Enter start :\t");
        start = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter end :\t");
        end = Double.parseDouble(scanner.nextLine());
    }
}
